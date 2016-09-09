//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                                      M a r s h a l l i n g                                     //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//  Copyright © Herve Bitteur and others 2000-2016. All rights reserved.
//  This software is released under the GNU Lesser General Public License v3.
//  Go to https://github.com/Audiveris/proxymusic/issues to report bugs or suggestions.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package org.audiveris.proxymusic.util;

import org.audiveris.proxymusic.Encoding;
import org.audiveris.proxymusic.Identification;
import org.audiveris.proxymusic.ObjectFactory;
import org.audiveris.proxymusic.ScorePartwise;
import org.audiveris.proxymusic.opus.Opus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
 * xlink prefix to its proper namespace URI).
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

    private static final Logger logger = LoggerFactory.getLogger(
            Marshalling.class);

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
            writer.flush();
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
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            Writer out = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            out.write(XML_LINE);
            out.write("\n");
            out.write(OPUS_DOCTYPE_LINE);

            XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
            XMLStreamWriter writer = outputFactory.createXMLStreamWriter(out);

            // Our custom XmlStreamWriter for name-space, formatting and comment line
            writer = new MyStreamWriter(writer, 2);

            // Marshalling
            org.audiveris.proxymusic.opus.ObjectFactory opusFactory = new org.audiveris.proxymusic.opus.ObjectFactory();
            JAXBElement<Opus> elem = opusFactory.createOpus(opus);
            marshaller.marshal(elem, writer);
            writer.flush();
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
            // Identification
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

            // [Encoding]/Software (only if ProxyMusic is not already listed there)
            List<JAXBElement<?>> list = encoding.getEncodingDateOrEncoderOrSoftware();
            final String programName = ProgramId.NAME + " ";

            for (Iterator<JAXBElement<?>> it = list.iterator(); it.hasNext();) {
                JAXBElement<?> element = it.next();

                if (element.getName().getLocalPart().equals("software")) {
                    Object obj = element.getValue();

                    if (obj instanceof String && ((String) obj).startsWith(programName)) {
                        // Remove it
                        it.remove();

                        break;
                    }
                }
            }

            list.add(
                    factory.createEncodingSoftware(
                            ProgramId.NAME + " " + ProgramId.VERSION + "." + ProgramId.REVISION));

            // [Encoding]/EncodingDate (overwrite any existing date)
            for (Iterator<JAXBElement<?>> it = list.iterator(); it.hasNext();) {
                if (it.next().getName().getLocalPart().equals("encoding-date")) {
                    it.remove();

                    break;
                }
            }

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
            list.add(factory.createEncodingEncodingDate(gc));
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
     * info. It does so by treating all namespace declarations as default namespaces.
     * <p>
     * The "xlink:" prefix is preserved for relevant attributes (opus).
     * <p>
     * It also performs formatting on the fly, if a non-null indentation value was provided.
     * <p>
     * Detected empty elements are written as one (empty) element rather than start + end tags.
     * <p>
     * It also inserts a comment line just before a part or measure element begins.
     *
     * @author Blaise Doughan (namespace handling)
     * @see <a href="http://stackoverflow.com/a/5722013">Blaise article</a>
     * @author Hervé Bitteur (other features)
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

        /** Pending element if any. (meant to handle empty elements) */
        private PendingElement pending;

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
        @Override
        public void setNamespaceContext (NamespaceContext context)
                throws XMLStreamException
        {
            // void (we keep using our own NamespaceContext)
        }

        @Override
        public void writeAttribute (String localName,
                                    String value)
                throws XMLStreamException
        {
            checkPending();
            super.writeAttribute(localName, value);
        }

        @Override
        public void writeAttribute (String namespaceURI,
                                    String localName,
                                    String value)
                throws XMLStreamException
        {
            checkPending();
            super.writeAttribute(namespaceURI, localName, value);
        }

        @Override
        public void writeAttribute (String prefix,
                                    String namespaceURI,
                                    String localName,
                                    String value)
                throws XMLStreamException
        {
            checkPending();
            super.writeAttribute(prefix, namespaceURI, localName, value);
        }

        @Override
        public void writeCData (String data)
                throws XMLStreamException
        {
            checkPending();
            super.writeCData(data);
        }

        @Override
        public void writeCharacters (String text)
                throws XMLStreamException
        {
            checkPending();
            super.writeCharacters(text);
        }

        @Override
        public void writeCharacters (char[] text,
                                     int start,
                                     int len)
                throws XMLStreamException
        {
            checkPending();
            super.writeCharacters(text, start, len);
        }

        @Override
        public void writeComment (String data)
                throws XMLStreamException
        {
            checkPending();
            indentComment();

            super.writeComment(data);
        }

        @Override
        public void writeDTD (String dtd)
                throws XMLStreamException
        {
            checkPending();
            super.writeDTD(dtd);
        }

        @Override
        public void writeDefaultNamespace (String namespaceURI)
                throws XMLStreamException
        {
            checkPending();
            super.writeDefaultNamespace(namespaceURI);
        }

        @Override
        public void writeEmptyElement (String localName)
                throws XMLStreamException
        {
            checkPending();
            super.writeEmptyElement(localName);
        }

        @Override
        public void writeEmptyElement (String namespaceURI,
                                       String localName)
                throws XMLStreamException
        {
            checkPending();
            super.writeEmptyElement(namespaceURI, localName);
        }

        @Override
        public void writeEmptyElement (String prefix,
                                       String localName,
                                       String namespaceURI)
                throws XMLStreamException
        {
            checkPending();
            super.writeEmptyElement(prefix, localName, namespaceURI);
        }

        @Override
        public void writeEndElement ()
                throws XMLStreamException
        {
            if (pending != null) {
                // The end is immediately following the start, with nothing in between:
                // So, write an empty element, instead of start + end
                pending.writeEmpty();
                indentEnd();
                pending = null;
            } else {
                indentEnd();
                super.writeEndElement();
            }
        }

        @Override
        public void writeEntityRef (String name)
                throws XMLStreamException
        {
            checkPending();
            super.writeEntityRef(name);
        }

        @Override
        public void writeNamespace (String prefix,
                                    String namespaceURI)
                throws XMLStreamException
        {
            // void (we don't output this information)
        }

        @Override
        public void writeProcessingInstruction (String target)
                throws XMLStreamException
        {
            checkPending();
            super.writeProcessingInstruction(target);
        }

        @Override
        public void writeProcessingInstruction (String target,
                                                String data)
                throws XMLStreamException
        {
            checkPending();
            super.writeProcessingInstruction(target, data);
        }

        @Override
        public void writeStartElement (String localName)
                throws XMLStreamException
        {
            checkPending();
            indentStart(localName);

            // We don't write the element start now, but save it as pending
            pending = new PendingElement(localName);
        }

        @Override
        public void writeStartElement (String namespaceURI,
                                       String localName)
                throws XMLStreamException
        {
            checkPending();
            indentStart(localName);

            // We don't write the element start now, but save it as pending
            pending = new PendingElement2(namespaceURI, localName);
        }

        @Override
        public void writeStartElement (String prefix,
                                       String localName,
                                       String namespaceURI)
                throws XMLStreamException
        {
            checkPending();
            indentStart(localName);

            // We don't write the element start now, but save it as pending
            pending = new PendingElement3(prefix, localName, namespaceURI);
        }

        //--------------//
        // checkPending //
        //--------------//
        private void checkPending ()
                throws XMLStreamException
        {
            if (pending != null) {
                pending.writeStart();
                pending = null;
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
            super.writeCharacters("\n");

            for (int i = 0; i < level; i++) {
                super.writeCharacters(INDENT);
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
                    doIndent();
                    super.writeComment("=======================================================");
                } else if (localName.equals("part")) {
                    doIndent();
                    super.writeComment("= = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
                }

                doIndent();
                level++;
                closing = false;
            }
        }

        //~ Inner Classes --------------------------------------------------------------------------
        /**
         * Class meant to save a starting element with its parameters.
         */
        private class PendingElement
        {
            //~ Instance fields --------------------------------------------------------------------

            final String localName;

            //~ Constructors -----------------------------------------------------------------------
            public PendingElement (String localName)
            {
                this.localName = localName;
            }

            //~ Methods ----------------------------------------------------------------------------
            /** Write an empty element. */
            public void writeEmpty ()
                    throws XMLStreamException
            {
                getParent().writeEmptyElement(localName);
            }

            /** Write just the element start. */
            public void writeStart ()
                    throws XMLStreamException
            {
                getParent().writeStartElement(localName);
            }
        }

        private class PendingElement2
                extends PendingElement
        {
            //~ Instance fields --------------------------------------------------------------------

            final String namespaceURI;

            //~ Constructors -----------------------------------------------------------------------
            public PendingElement2 (String namespaceURI,
                                    String localName)
            {
                super(localName);
                this.namespaceURI = namespaceURI;
            }

            //~ Methods ----------------------------------------------------------------------------
            @Override
            public void writeEmpty ()
                    throws XMLStreamException
            {
                getParent().writeEmptyElement(namespaceURI, localName);
            }

            @Override
            public void writeStart ()
                    throws XMLStreamException
            {
                getParent().writeStartElement(namespaceURI, localName);
            }
        }

        private class PendingElement3
                extends PendingElement2
        {
            //~ Instance fields --------------------------------------------------------------------

            final String prefix;

            //~ Constructors -----------------------------------------------------------------------
            public PendingElement3 (String prefix,
                                    String localName,
                                    String namespaceURI)
            {
                super(namespaceURI, localName);
                this.prefix = prefix;
            }

            //~ Methods ----------------------------------------------------------------------------
            @Override
            public void writeEmpty ()
                    throws XMLStreamException
            {
                getParent().writeEmptyElement(prefix, localName, namespaceURI);
            }

            @Override
            public void writeStart ()
                    throws XMLStreamException
            {
                getParent().writeStartElement(prefix, localName, namespaceURI);
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
