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

import org.w3c.dom.Node;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.String; // Don't remove this line!
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Class {@code Marshalling} gathers static methods to marshal and to un-marshal {@code
 * ScorePartwise} java objects to/from an output/input stream in UTF8 encoding and
 * using MusicXML format.
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
    private static JAXBContext jaxbContext;

    /** The XML document statement. */
    private static final String XML_LINE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

    /** URL of MusicXML DTD. */
    private static final String DTD_URL = "http://www.musicxml.org/dtds/partwise.dtd";

    /** The DOCTYPE statement for XML. */
    private static final String DOCTYPE_LINE = "<!DOCTYPE score-partwise PUBLIC"
                                               + " \"-//Recordare//DTD MusicXML "
                                               + ProgramId.VERSION + " Partwise//EN\"" + " \""
                                               + DTD_URL + "\">";

    /**
     * Specific entity resolver to filter out the DTD_URL.
     */
    private static final EntityResolver filteringEntityResolver = new EntityResolver()
    {
        @Override
        public InputSource resolveEntity (final String publicId,
                                          final String systemId)
                throws SAXException, IOException
        {
            if (systemId.equals(DTD_URL)) {
                // Return an empty input source
                return new InputSource(new StringReader(""));
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
     * @return the ready to use JAXB context
     * @exception JAXBException if anything goes wrong
     */
    public static synchronized JAXBContext getContext ()
            throws JAXBException
    {
        // Lazy creation
        if (jaxbContext == null) {
            jaxbContext = JAXBContext.newInstance(ScorePartwise.class);
        }

        return jaxbContext;
    }

    //---------//
    // marshal //
    //---------//
    /**
     * Marshal the hierarchy rooted at provided ScorePartwise instance to an
     * OutputStream.
     *
     * @param scorePartwise   the root element
     * @param os              the output stream
     * @param injectSignature false if ProxyMusic encoder must not be referenced
     * @param indentation     formatting indentation value, null for no formatting.
     *                        when formatting, a comment line is inserted before parts and measures
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
            Marshaller marshaller = getContext().createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            Writer out = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            out.write(XML_LINE);
            out.write("\n");
            out.write(DOCTYPE_LINE);

            /** Our custom XmlStreamWriter for namespace, formatting and comment line. */
            XMLOutputFactory xof = XMLOutputFactory.newFactory();
            XMLStreamWriter writer = xof.createXMLStreamWriter(out);
            writer = new CustomXMLStreamWriter(writer, indentation);

            // No longer used: Instance of MeasureAdapter to insert a comment line before measure
            ///marshaller.setAdapter(new MeasureAdapter(writer));
            //
            // Marshalling
            marshaller.marshal(scorePartwise, writer);
            out.flush();
            out.close();
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

            Marshaller marshaller = getContext().createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.marshal(scorePartwise, node);
        } catch (Exception ex) {
            throw new MarshallingException(ex);
        }
    }

    //--------------//
    // prettyFormat //
    //--------------//
    /**
     * Properly format an input XML string.
     * (not used actually, since formatting is done in custom stream writer)
     *
     * @param input  the XML input string
     * @param indent indentation value
     * @return the formatted XML output string
     * @throws FormattingException global exception. Use getCause() for original exception
     * @see <a
     * href="http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java">Author
     * article</a>
     */
    public static String prettyFormat (String input,
                                       int indent)
            throws FormattingException
    {
        try {
            Source xmlInput = new StreamSource(new StringReader(input));
            StringWriter stringWriter = new StringWriter();
            StreamResult xmlOutput = new StreamResult(stringWriter);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", indent);

            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(xmlInput, xmlOutput);

            return xmlOutput.getWriter().toString();
        } catch (Exception ex) {
            throw new FormattingException(ex);
        }
    }

    //-----------//
    // unmarshal //
    //-----------//
    /**
     * Un-marshal a ScorePartwise instance from an InputStream.
     * <b>Nota:</b> The URL of MusicXML DTD is specifically ignored by this method.
     *
     * @param is the input stream
     * @return the scorePartwise root element
     * @throws UnmarshallingException global exception (use getCause() for original exception)
     */
    public static ScorePartwise unmarshal (final InputStream is)
            throws UnmarshallingException
    {
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setEntityResolver(filteringEntityResolver);

            SAXSource saxSource = new SAXSource(xmlReader, new InputSource(is));
            Unmarshaller um = getContext().createUnmarshaller();
            ScorePartwise partwise = (ScorePartwise) um.unmarshal(saxSource);

            return partwise;
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
