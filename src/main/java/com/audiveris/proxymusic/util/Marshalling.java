//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                                      M a r s h a l l i n g                                     //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//  Copyright © Herve Bitteur and others 2000-2014. All rights reserved.
//  This software is released under the GNU Lesser General Public License.
//  Go to http://kenai.com/projects/proxymusic/ to report bugs or suggestions.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package com.audiveris.proxymusic.util;

import com.audiveris.proxymusic.Encoding;
import com.audiveris.proxymusic.Identification;
import com.audiveris.proxymusic.ObjectFactory;
import com.audiveris.proxymusic.ScorePartwise;
import com.audiveris.proxymusic.opus.Opus;


import org.w3c.dom.Node;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.String; // Don't remove this line!
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.util.StreamReaderDelegate;

/**
 * Class {@code Marshalling} gathers static methods to marshal and to un-marshal {@link
 * ScorePartwise} or {@link Opus} java objects to/from an output/input stream in UTF8
 * encoding and using MusicXML format.
 * <p>
 * Several tricks are used to work around namespaces during marshalling and un-marshalling since
 * MusicXML does not support them
 * (MusicXML uses prefixed attribute names such as <i>xlink:href</i>, although it never binds the
 * xlink
 * prefix to its proper namespace URI).
 * <p>
 * No access to a DTD (local or remote) is made during the un-marshalling which ignores DTDs.
 * <p>
 * The method {@link #getContext(Class)} is publicly visible so as to allow an asynchronous
 * elaboration of the JAXB context, which can be an expensive operation because of the large number
 * of Java classes in the ScorePartwise hierarchy.
 *
 * @author Hervé Bitteur
 */
public abstract class Marshalling
{
    //~ Static fields/initializers -----------------------------------------------------------------

    /** JAXB contexts. */
    private static final Map<Class, JAXBContext> jaxbContextMap = new HashMap<Class, JAXBContext>();

    /** The XML document statement. */
    private static final String XML_LINE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

    /** The official URI for XLink namespace. */
    private static final String XLINK_NAMESPACE_URI = "http://www.w3.org/1999/xlink";

    /** The collection of all supported attributes with xlink: prefix. */
    private static final List<String> XLINK_ATTRIBUTES = Arrays.asList(
            "href",
            "type",
            "role",
            "title",
            "show",
            "actuate");

    /** The DOCTYPE statement for PARTWISE. */
    private static final String PARTWISE_DOCTYPE_LINE = "<!DOCTYPE score-partwise PUBLIC \"-//Recordare//DTD MusicXML "
                                                        + ProgramId.VERSION
                                                        + " Partwise//EN\" \"http://www.musicxml.org/dtds/partwise.dtd\">";

    /** The DOCTYPE statement for OPUS. */
    private static final String OPUS_DOCTYPE_LINE = "<!DOCTYPE opus PUBLIC \"-//Recordare//DTD MusicXML "
                                                    + ProgramId.VERSION
                                                    + " Opus//EN\" \"http://www.musicxml.org/dtds/opus.dtd\">";

    //~ Constructors -------------------------------------------------------------------------------
    /**
     * This class is not meant to be instantiated.
     */
    private Marshalling ()
    {
    }

    //~ Methods ------------------------------------------------------------------------------------
    //----------------//
    // getJaxbContext //
    //----------------//
    /**
     * Get access to (and elaborate if not yet done) the needed JAXB context.
     * This method can be called any time.
     *
     * @param classe the desired class
     * @return the ready to use JAXB context
     * @exception JAXBException if anything goes wrong
     */
    public static JAXBContext getContext (Class classe)
            throws JAXBException
    {
        // Lazy creation
        JAXBContext context = jaxbContextMap.get(classe);

        if (context == null) {
            synchronized (jaxbContextMap) {
                context = jaxbContextMap.get(classe); // It may have just been created!

                if (context == null) {
                    context = JAXBContext.newInstance(classe);
                    jaxbContextMap.put(classe, context);
                }
            }
        }

        return context;
    }

    //---------//
    // marshal //
    //---------//
    /**
     * Marshal the provided <b>ScorePartwise</b> instance to an OutputStream.
     *
     * @param scorePartwise   the root scorePartwise element
     * @param os              the output stream (not closed by this method)
     * @param injectSignature false if ProxyMusic encoder must not be referenced
     * @param indentation     formatting indentation value, null for no formatting.
     *                        When formatting, a comment line is inserted before parts and measures
     * @throws MarshallingException global exception (use getCause() for original exception)
     */
    public static void marshal (final ScorePartwise scorePartwise,
                                final OutputStream os,
                                final boolean injectSignature,
                                final Integer indentation)
            throws MarshallingException
    {
        try {
            // Inject version & signature
            annotate(scorePartwise, injectSignature);

            Marshaller marshaller = getContext(ScorePartwise.class).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            Writer out = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            out.write(XML_LINE);
            out.write("\n");
            out.write(PARTWISE_DOCTYPE_LINE);

            XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
            XMLStreamWriter writer = outputFactory.createXMLStreamWriter(out);
            // Use our custom XmlStreamWriter for name-space, formatting and comment line
            writer = new MyStreamWriter(writer, indentation);

            // Marshalling
            marshaller.marshal(scorePartwise, writer);
            out.flush();
        } catch (Exception ex) {
            throw new MarshallingException(ex);
        }
    }

    //---------//
    // marshal //
    //---------//
    /**
     * Marshal the provided <b>Opus</b> instance to an OutputStream.
     *
     * @param opus the root opus element
     * @param os   the output stream (not closed by this method)
     * @throws MarshallingException global exception (use getCause() for original exception)
     */
    public static void marshal (final Opus opus,
                                final OutputStream os)
            throws MarshallingException
    {
        try {
            Marshaller marshaller = getContext(Opus.class).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            Writer out = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            out.write(XML_LINE);
            out.write("\n");
            out.write(OPUS_DOCTYPE_LINE);

            XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
            XMLStreamWriter writer = outputFactory.createXMLStreamWriter(out);
            // Our custom XmlStreamWriter for name-space, formatting and comment line
            writer = new MyStreamWriter(writer, 2);

            // Marshalling
            com.audiveris.proxymusic.opus.ObjectFactory opusFactory = new com.audiveris.proxymusic.opus.ObjectFactory();
            JAXBElement<Opus> elem = opusFactory.createOpus(opus);
            marshaller.marshal(elem, writer);
            out.flush();
        } catch (Exception ex) {
            throw new MarshallingException(ex);
        }
    }

    //---------//
    // marshal //
    //---------//
    /**
     * Marshal the provided <b>ScorePartwise</b> instance directly to a <b>DOM node</b>.
     *
     * @param scorePartwise   the root element
     * @param node            the DOM node where elements must be added
     * @param injectSignature false if ProxyMusic encoder must not be referenced
     * @throws MarshallingException global exception (use getCause() for original exception)
     */
    public static void marshal (final ScorePartwise scorePartwise,
                                final Node node,
                                final boolean injectSignature)
            throws MarshallingException
    {
        try {
            annotate(scorePartwise, injectSignature);

            Marshaller marshaller = getContext(ScorePartwise.class).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.marshal(scorePartwise, node);
        } catch (Exception ex) {
            throw new MarshallingException(ex);
        }
    }

    //-----------//
    // unmarshal //
    //-----------//
    /**
     * Un-marshal a <b>ScorePartwise</b> instance or an <b>Opus</b> instance from an InputStream.
     * <p>
     * Nota: The URLs of MusicXML DTD are specifically ignored by this method.
     *
     * @param is the input stream
     * @return the root element (either Opus or ScorePartwise object)
     * @throws UnmarshallingException global exception (use getCause() for original exception)
     */
    public static Object unmarshal (final InputStream is)
            throws UnmarshallingException
    {
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();

            // Do not try to resolve DTDs (especially on the network!)
            inputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, false);

            // Make the input reader non namespace aware
            // (attributes xlink:href and the like will be manually handled on the fly)
            inputFactory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, false); // OK

            XMLStreamReader xsr = inputFactory.createXMLStreamReader(is);
            // Use our specific stream reader
            xsr = new MyStreamReader(xsr);

            XMLEventReader reader = inputFactory.createXMLEventReader(xsr);

            while (reader.hasNext()) {
                // Peek root element, to decide between ScorePartwise or Opus un-marshalling
                XMLEvent event = reader.peek();

                if (event.isStartElement()) {
                    StartElement rootStart = event.asStartElement();
                    QName qName = rootStart.getName();
                    String name = qName.getLocalPart();

                    if (name.equals("opus")) {
                        Unmarshaller um = getContext(Opus.class).createUnmarshaller();

                        return um.unmarshal(reader, Opus.class).getValue();
                    } else if (name.equals("score-partwise")) {
                        Unmarshaller um = getContext(ScorePartwise.class).createUnmarshaller();

                        return um.unmarshal(reader, ScorePartwise.class).getValue();
                    } else {
                        reader.next();
                    }
                } else {
                    reader.next();
                }
            }

            return null;
        } catch (Exception ex) {
            throw new UnmarshallingException(ex);
        }
    }

    //----------//
    // annotate //
    //----------//
    /**
     * Annotate the scorePartwise tree with information about MusicXML version and, if
     * so desired, with signature composed of ProxyMusic version and date of marshalling.
     *
     * @param scorePartwise   the tree to annotate
     * @param injectSignature if true, ProxyMusic information is added
     */
    private static void annotate (final ScorePartwise scorePartwise,
                                  final boolean injectSignature)
            throws DatatypeConfigurationException
    {
        // Predefined factory for all proxymusic elements
        ObjectFactory factory = new ObjectFactory();

        // Inject version
        scorePartwise.setVersion(ProgramId.VERSION);

        // Inject signature if so desired
        if (injectSignature) {
            Identification identification = scorePartwise.getIdentification();

            if (identification == null) {
                identification = factory.createIdentification();
                scorePartwise.setIdentification(identification);
            }

            // Encoding
            Encoding encoding = identification.getEncoding();

            if (encoding == null) {
                encoding = factory.createEncoding();
                identification.setEncoding(encoding);
            }

            // [Encoding]/Software
            encoding.getEncodingDateOrEncoderOrSoftware().add(
                    factory.createEncodingSoftware(
                            ProgramId.NAME + " " + ProgramId.VERSION + "." + ProgramId.REVISION));

            // [Encoding]/EncodingDate
            // Use date without time information (patch by lasconic)
            // Output:     2012-05-03
            // instead of: 2012-05-03T16:17:51.250+02:00
            XMLGregorianCalendar gc = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(
                            new GregorianCalendar());
            gc.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
            gc.setTime(
                    DatatypeConstants.FIELD_UNDEFINED,
                    DatatypeConstants.FIELD_UNDEFINED,
                    DatatypeConstants.FIELD_UNDEFINED);
            encoding.getEncodingDateOrEncoderOrSoftware().add(
                    factory.createEncodingEncodingDate(gc));
        }
    }

    //~ Inner Classes ------------------------------------------------------------------------------
    /** Global exception for formatting. */
    public static class FormattingException
            extends Exception
    {
        //~ Constructors ---------------------------------------------------------------------------

        public FormattingException (Throwable cause)
        {
            super(cause);
        }
    }

    /** Global exception for marshalling. */
    public static class MarshallingException
            extends Exception
    {
        //~ Constructors ---------------------------------------------------------------------------

        public MarshallingException (Throwable cause)
        {
            super(cause);
        }
    }

    /** Global exception for un-marshalling. */
    public static class UnmarshallingException
            extends Exception
    {
        //~ Constructors ---------------------------------------------------------------------------

        public UnmarshallingException (Throwable cause)
        {
            super(cause);
        }
    }

    //--------------------//
    // MyNamespaceContext //
    //--------------------//
    /**
     * Class to avoid any namespace binding during marshal operation.
     */
    private static class MyNamespaceContext
            implements NamespaceContext
    {
        //~ Instance fields ------------------------------------------------------------------------

        private String defaultNS = "";

        //~ Methods --------------------------------------------------------------------------------
        public String getNamespaceURI (String prefix)
        {
            if ("".equals(prefix)) {
                return defaultNS;
            }

            return null;
        }

        public String getPrefix (String namespaceURI)
        {
            // Trick for xlink:...
            if (XLINK_NAMESPACE_URI.equals(namespaceURI)) {
                return "xlink";
            }

            return "";
        }

        public Iterator getPrefixes (String namespaceURI)
        {
            return null;
        }

        public void setDefaultNS (String ns)
        {
            defaultNS = ns;
        }
    }

    //----------------//
    // MyStreamReader //
    //----------------//
    /**
     * Class to resolve any xlink:xxx attribute on the fly during unmarshal operation.
     */
    private static class MyStreamReader
            extends StreamReaderDelegate
    {
        //~ Constructors ---------------------------------------------------------------------------

        public MyStreamReader (XMLStreamReader reader)
        {
            super(reader);
        }

        //~ Methods --------------------------------------------------------------------------------
        @Override
        public QName getAttributeName (int index)
        {
            String prefix = getAttributePrefix(index);

            if ("xlink".equals(prefix)) {
                QName qName = super.getAttributeName(index);
                String local = qName.getLocalPart();

                if (XLINK_ATTRIBUTES.contains(local)) {
                    return new QName(XLINK_NAMESPACE_URI, local, "xlink");
                }
            }

            return super.getAttributeName(index);
        }
    }

    //----------------//
    // MyStreamWriter //
    //----------------//
    /**
     * Class {@code MyStreamWriter} removes the namespaces from the marshal operation.
     * <p>
     * It is a wrapper for an XMLStreamWriter that intercepts and removes the relevant namespace
     * info.
     * It does so by treating all namespace declarations as default namespaces.
     * <p>
     * The "xlink:" prefix is preserved for relevant attributes (opus).
     * <p>
     * It also performs formatting on the fly, if a non-null indentation value was provided.
     * TODO: Still to be checked for writeEmptyElement and writeProcessingInstruction
     * <p>
     * It also inserts a comment line just before a part or measure element begins.
     *
     * @author Blaise Doughan (namespace handling)
     * @see <a href="http://stackoverflow.com/a/5722013">Blaise article</a>
     * @author Hervé Bitteur (formatting)
     */
    private static class MyStreamWriter
            extends StreamWriterDelegate
    {
        //~ Instance fields ------------------------------------------------------------------------

        /** Special name context. */
        private final MyNamespaceContext nc = new MyNamespaceContext();

        /** Indentation string, if any. */
        private final String INDENT;

        /** Current level of indentation. */
        private int level;

        /** Are we closing element(s)?. */
        private boolean closing;

        //~ Constructors ---------------------------------------------------------------------------
        /**
         * Creates a new {@code MyXMLStreamWriter} object.
         *
         * @param writer      the real XML stream writer
         * @param indentValue desired indentation value, if any (null, 0 or n)
         *
         * @throws XMLStreamException for any processing error
         */
        public MyStreamWriter (XMLStreamWriter writer,
                               Integer indentValue)
                throws XMLStreamException
        {
            super(writer);

            writer.setNamespaceContext(nc);
            INDENT = getIndentString(indentValue);
        }

        //~ Methods --------------------------------------------------------------------------------
        //---------------------//
        // setNamespaceContext //
        //---------------------//
        @Override
        public void setNamespaceContext (NamespaceContext context)
                throws XMLStreamException
        {
            // void (we keep using our own NamespaceContext)
        }

        //--------------//
        // writeComment //
        //--------------//
        @Override
        public void writeComment (String data)
                throws XMLStreamException
        {
            indentComment();

            super.writeComment(data);
        }

        //-----------------//
        // writeEndElement //
        //-----------------//
        @Override
        public void writeEndElement ()
                throws XMLStreamException
        {
            indentEnd();

            super.writeEndElement();
        }

        //----------------//
        // writeNamespace //
        //----------------//
        @Override
        public void writeNamespace (String prefix,
                                    String namespaceURI)
                throws XMLStreamException
        {
            // void (we don't output this information)
        }

        //-------------------//
        // writeStartElement //
        //-------------------//
        @Override
        public void writeStartElement (String localName)
                throws XMLStreamException
        {
            indentStart(localName);

            super.writeStartElement(localName);
        }

        //-------------------//
        // writeStartElement //
        //-------------------//
        @Override
        public void writeStartElement (String namespaceURI,
                                       String localName)
                throws XMLStreamException
        {
            indentStart(localName);

            super.writeStartElement(namespaceURI, localName);
        }

        //-------------------//
        // writeStartElement //
        //-------------------//
        @Override
        public void writeStartElement (String prefix,
                                       String localName,
                                       String namespaceURI)
                throws XMLStreamException
        {
            indentStart(localName);

            super.writeStartElement("", localName, namespaceURI);

            if ((namespaceURI != null) && (namespaceURI.length() > 0)) {
                String currentDefaultNS = nc.getNamespaceURI("");

                if (!namespaceURI.equals(currentDefaultNS)) {
                    writeDefaultNamespace(namespaceURI);
                    nc.setDefaultNS(namespaceURI);
                }
            }
        }

        //----------//
        // doIndent //
        //----------//
        /**
         * Insert a new line, followed by proper level of indentation.
         *
         * @throws XMLStreamException
         */
        private void doIndent ()
                throws XMLStreamException
        {
            writeCharacters("\n");

            for (int i = 0; i < level; i++) {
                writeCharacters(INDENT);
            }
        }

        //-----------------//
        // getIndentString //
        //-----------------//
        /**
         * Build proper indentation string.
         *
         * @param value desired indentation value
         * @return the indentation string to use: null for no indentation at all, empty string for
         *         LF only, non-empty string for LF and concrete indentation
         */
        private String getIndentString (Integer value)
        {
            if (value == null) {
                return null;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < value; i++) {
                sb.append(" ");
            }

            return sb.toString();
        }

        //---------------//
        // indentComment //
        //---------------//
        /**
         * Indentation before comment. Always indent.
         *
         * @throws XMLStreamException
         */
        private void indentComment ()
                throws XMLStreamException
        {
            if (INDENT != null) {
                doIndent();
            }
        }

        //-----------//
        // indentEnd //
        //-----------//
        /**
         * Indentation before end tag. Indent except on first close.
         *
         * @throws XMLStreamException
         */
        private void indentEnd ()
                throws XMLStreamException
        {
            if (INDENT != null) {
                level--;

                if (closing) {
                    doIndent();
                }

                closing = true;
            }
        }

        //-------------//
        // indentStart //
        //-------------//
        /**
         * Indentation before start tag. Always indent.
         *
         * @param localName the local tag name
         * @throws XMLStreamException
         */
        private void indentStart (String localName)
                throws XMLStreamException
        {
            if (INDENT != null) {
                // Insert visible comment lines only for measures and parts
                if (localName.equals("measure")) {
                    writeComment("=======================================================");
                } else if (localName.equals("part")) {
                    writeComment("= = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
                }

                doIndent();
                level++;
                closing = false;
            }
        }
    }
}
//    //--------------//
//    // prettyFormat //
//    //--------------//
//    /**
//     * Properly format an input XML string.
//     * (not used actually, since formatting is done in custom stream writer)
//     *
//     * @param input  the XML input string
//     * @param indent indentation value
//     * @return the formatted XML output string
//     * @throws FormattingException global exception. Use getCause() for original exception
//     * @see <a
//     * href="http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java">Author
//     * article</a>
//     */
//    @Deprecated
//    public static String prettyFormat (String input,
//                                       int indent)
//            throws FormattingException
//    {
//        try {
//            Source xmlInput = new StreamSource(new StringReader(input));
//            StringWriter stringWriter = new StringWriter();
//            StreamResult xmlOutput = new StreamResult(stringWriter);
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//            transformerFactory.setAttribute("indent-number", indent);
//
//            Transformer transformer = transformerFactory.newTransformer();
//            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
//            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//            transformer.transform(xmlInput, xmlOutput);
//
//            return xmlOutput.getWriter().toString();
//        } catch (Exception ex) {
//            throw new FormattingException(ex);
//        }
//    }
//
//    //---------//
//    // marshal // Works OK too
//    //---------//
//    /**
//     * Marshal the provided Opus instance to an OutputStream.
//     * <p>
//     * Nota: We marshal to a temporary data string to remove the opus unwanted namespace binding
//     * xmlns:xlink="http://www.w3.org/1999/xlink"
//     *
//     * @param opus the root opus element
//     * @param os   the output stream (not closed by this method)
//     * @throws MarshallingException global exception (use getCause() for original exception)
//     */
//    public static void marshal (final Opus opus,
//                                final OutputStream os)
//            throws MarshallingException
//    {
//        try {
//            Marshaller marshaller = getContext(Opus.class).createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
//            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//            // Marshal to temporary data string
//            StringWriter stringWriter = new StringWriter();
//            com.audiveris.proxymusic.opus.ObjectFactory opusFactory = new com.audiveris.proxymusic.opus.ObjectFactory();
//            JAXBElement<Opus> elem = opusFactory.createOpus(opus);
//            marshaller.marshal(elem, stringWriter);
//            stringWriter.flush();
//
//            // Post-processing to remove unwanted xlink namespace binding
//            String data = stringWriter.toString();
//            stringWriter.close();
//
//            data = data.replaceAll(" xmlns:xlink=\"" + XLINK_NAMESPACE_URI + "\"", "");
//
//            //            }
//            // Finally, write out data to the UTF8 stream
//            Writer writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
//            writer.write(XML_LINE);
//            writer.write("\n");
//            writer.write(OPUS_DOCTYPE_LINE);
//            writer.write("\n");
//            writer.write(data);
//            writer.flush();
//        } catch (Exception ex) {
//            throw new MarshallingException(ex);
//        }
//    }
