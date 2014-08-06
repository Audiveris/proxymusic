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
import java.io.StringBufferInputStream;
import java.io.Writer;
import java.lang.String; // Don't remove this line!
import java.util.GregorianCalendar;
import java.util.HashMap;
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
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLResolver;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * Class {@code Marshalling} gathers static methods to marshal and to un-marshal {@link
 * ScorePartwise} of {@link Opus} java objects to/from an output/input stream in UTF8
 * encoding and using MusicXML format.
 * <p>
 * No access to a DTD (local or remote) is made during the un-marshalling thanks to a specific
 * {@code EntityResolver} which ignores MusicXML DTD URL.
 * <p>
 * The method {@link #getContext} is publicly visible so as to allow an asynchronous elaboration of
 * the JAXB context, which is an expensive operation because of the large number of Java classes in
 * the ScorePartwise hierarchy.
 *
 * @author Hervé Bitteur
 */
public class Marshalling
{
    //~ Static fields/initializers -----------------------------------------------------------------

    /** [Un]marshalling context for use with JAXB. */
    private static final Map<Class, JAXBContext> jaxbContextMap = new HashMap<Class, JAXBContext>();

    /** The XML document statement. */
    private static final String XML_LINE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

    /** URL of DTDs. */
    private static final String DTDS_URL = "http://www.musicxml.org/dtds";

    /** The DOCTYPE statement for PARTWISE. */
    private static final String PARTWISE_DOCTYPE_LINE = "<!DOCTYPE score-partwise PUBLIC"
                                                        + " \"-//Recordare//DTD MusicXML "
                                                        + ProgramId.VERSION + " Partwise//EN\""
                                                        + " \"" + DTDS_URL + "/partwise.dtd\">";

    /** The DOCTYPE statement for OPUS. */
    private static final String OPUS_DOCTYPE_LINE = "<!DOCTYPE opus PUBLIC"
                                                    + " \"-//Recordare//DTD MusicXML 3.0 Opus//EN\""
                                                    + " \"" + DTDS_URL + "/opus.dtd\">";

    private static final XMLResolver filteringXMLResolver = new XMLResolver()
    {
        public Object resolveEntity (String publicID,
                                     String systemID,
                                     String baseURI,
                                     String namespace)
                throws XMLStreamException
        {
            if (systemID.startsWith(DTDS_URL)
                || ((baseURI != null) && baseURI.startsWith(DTDS_URL))) {
                // Return an empty input source
                return new StringBufferInputStream("");
            } else {
                // Use the default behavior
                return null;
            }
        }
    };

    //~ Constructors -------------------------------------------------------------------------------
    //
    //-------------//
    // Marshalling //
    //-------------//
    /**
     * Class is not meant to be instantiated.
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
     * Marshal the provided ScorePartwise instance to an OutputStream.
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
            annotate(scorePartwise, injectSignature);

            /** Marshal to temporary data. */
            Marshaller marshaller = getContext(ScorePartwise.class).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            Writer out = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            out.write(XML_LINE);
            out.write("\n");
            out.write(PARTWISE_DOCTYPE_LINE);

            /** Our custom XmlStreamWriter for name-space, formatting and comment line. */
            XMLOutputFactory xof = XMLOutputFactory.newFactory();
            XMLStreamWriter writer = xof.createXMLStreamWriter(out);
            writer = new CustomXMLStreamWriter(writer, indentation);

            // No longer used: Instance of MeasureAdapter to insert a comment line before measure
            ///marshaller.setAdapter(new MeasureAdapter(writer));
            //
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
     * Marshal the provided Opus instance to an OutputStream.
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

            Writer writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(XML_LINE);
            writer.write("\n");
            writer.write(OPUS_DOCTYPE_LINE);
            writer.write("\n");

            // Marshalling
            com.audiveris.proxymusic.opus.ObjectFactory opusFactory = new com.audiveris.proxymusic.opus.ObjectFactory();
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
     * Marshal the hierarchy rooted at provided ScorePartwise instance directly to a DOM
     * node.
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
     * Un-marshal a ScorePartwise instance or an Opus instance from an InputStream.
     * <b>Nota:</b> The URLs of MusicXML DTD are specifically ignored by this method.
     *
     * @param is the input stream
     * @return the root element (either Opus or ScorePartwise object)
     * @throws UnmarshallingException global exception (use getCause() for original exception)
     */
    public static Object unmarshal (final InputStream is)
            throws UnmarshallingException
    {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            factory.setXMLResolver(filteringXMLResolver);

            XMLEventReader reader = factory.createXMLEventReader(is);

            while (reader.hasNext()) {
                /* Peek root element */
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
//    //---------------//
//    // unmarshalOpus //
//    //---------------//
//    /**
//     * Un-marshal an Opus instance from an InputStream.
//     * <b>Nota:</b> The URLs of MusicXML DTD are specifically ignored by this method.
//     *
//     * @param is the input stream
//     * @return the opus root element
//     * @throws UnmarshallingException global exception (use getCause() for original exception)
//     */
//    @Deprecated
//    public static Opus unmarshalOpus (final InputStream is)
//            throws UnmarshallingException
//    {
//        try {
//            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
//            XMLReader xmlReader = saxParser.getXMLReader();
//            xmlReader.setEntityResolver(filteringEntityResolver);
//
//            SAXSource saxSource = new SAXSource(xmlReader, new InputSource(is));
//            Unmarshaller um = getContext(Opus.class).createUnmarshaller();
//
//            JAXBElement<Opus> root = um.unmarshal(saxSource, Opus.class);
//            Opus opus = root.getValue();
//
//            return opus;
//        } catch (Exception ex) {
//            throw new UnmarshallingException(ex);
//        }
//    }
//
//    //-------------------//
//    // unmarshalPartwise //
//    //-------------------//
//    /**
//     * Un-marshal a ScorePartwise instance from an InputStream.
//     * <b>Nota:</b> The URLs of MusicXML DTD are specifically ignored by this method.
//     *
//     * @param is the input stream
//     * @return the scorePartwise root element
//     * @throws UnmarshallingException global exception (use getCause() for original exception)
//     */
//    @Deprecated
//    public static ScorePartwise unmarshalPartwise (final InputStream is)
//            throws UnmarshallingException
//    {
//        try {
//            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
//            XMLReader xmlReader = saxParser.getXMLReader();
//            xmlReader.setEntityResolver(filteringEntityResolver);
//
//            SAXSource saxSource = new SAXSource(xmlReader, new InputSource(is));
//            Unmarshaller um = getContext(ScorePartwise.class).createUnmarshaller();
//            ScorePartwise partwise = (ScorePartwise) um.unmarshal(saxSource);
//
//            return partwise;
//        } catch (Exception ex) {
//            throw new UnmarshallingException(ex);
//        }
//    }
//
//    /**
//     * Specific entity resolver to filter out the DTDS_URL.
//     */
//    private static final EntityResolver filteringEntityResolver = new EntityResolver()
//    {
//        @Override
//        public InputSource resolveEntity (final String publicId,
//                                          final String systemId)
//                throws SAXException, IOException
//        {
//            if (systemId.startsWith(DTDS_URL)) {
//                // Return an empty input source
//                return new InputSource(new StringReader(""));
//            } else {
//                // Use the default behavior
//                return null;
//            }
//        }
//    };
