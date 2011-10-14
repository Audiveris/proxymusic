//----------------------------------------------------------------------------//
//                                                                            //
//                           M a r s h a l l i n g                            //
//                                                                            //
//  Copyright (C) Herve Bitteur 2000-2010. All rights reserved.               //
//  This software is released under the GNU Lesser General Public License.    //
//  Please contact users@proxymusic.dev.java.net to report bugs & suggestions.//
//----------------------------------------------------------------------------//
//
package proxymusic.util;

import org.w3c.dom.Node;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import proxymusic.*;

import java.io.*;
import java.lang.String; // Don't remove this line!
import java.util.GregorianCalendar;
import java.util.logging.Logger;

import javax.xml.bind.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;

/**
 * Class {@ode Marshalling} gathers static methods to marshal and to unmarshal
 * {@code ScorePartwise} java objects to/from an output/input stream in UTF8
 * encoding and using MusicXML format.
 *
 * <p>No access to a DTD (local or remote) is made during the unmarshalling
 * thanks to a specific {@code EntityResolver} which ignores MusicXML DTD URL.
 *
 * <p>The method {@link #getContext} is publicly visible so as to allow an
 * asynchronous elaboration of the JAXB context, which is an expensive operation
 * because of the large number of Java classes in the ScorePartwise hierarchy.
 *
 * @author Hervé Bitteur
 */
public class Marshalling
{
    //~ Static fields/initializers ---------------------------------------------

    /** Containing package */
    private static final Package pmPackage = ObjectFactory.class.getPackage();

    /** Precise tool name, example: "ProxyMusic" */
    public static final String specificationTitle = (pmPackage.getSpecificationTitle() != null)
                                                    ? pmPackage.getSpecificationTitle()
                                                    : "ProxyMusic";

    /** Supported MusicXML version, example: "1.1", "2.0"*/
    public static final String specificationVersion = (pmPackage.getSpecificationVersion() != null)
                                                      ? pmPackage.getSpecificationVersion()
                                                      : "2.0";

    /** Full binding version, example: "MusicXML-2.0 JAXB-2.0 d" */
    public static final String implementationVersion = pmPackage.getImplementationVersion();

    /** [Un]marshalling context for use with JAXB */
    private static JAXBContext jaxbContext;

    /** The xml document statement */
    private static final String XML_LINE = "<?xml version=\"1.0\"" +
                                           " encoding=\"UTF-8\"" + //" standalone=\"yes\" +
                                           "?>\n";

    /** URL of MusicXML DTD */
    private static final String DTD_URL = "http://www.musicxml.org/dtds/partwise.dtd";

    /** The DOCTYPE statement for xml */
    private static final String DOCTYPE_LINE = "<!DOCTYPE score-partwise PUBLIC" +
                                               " \"-//Recordare//DTD MusicXML " +
                                               specificationVersion +
                                               " Partwise//EN\"" + " \"" +
                                               DTD_URL + "\">\n";

    /** Specific entity resolver to filter out the DTD_URL */
    private static final EntityResolver filteringEntityResolver = new EntityResolver() {
        public InputSource resolveEntity (String publicId,
                                          String systemId)
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


    //~ Constructors -----------------------------------------------------------

    // Not meant to be instantiated
    private Marshalling ()
    {
    }

    //~ Methods ----------------------------------------------------------------

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
     * OutputStream, ProxyMusic being referenced as an encoder.
     * (The output stream is not closed by this method)
     *
     * @param scorePartwise the root element
     * @param os the output stream
     * @exception JAXBException if marshalling goes wrong
     * @exception IOException for output error
     * @exception UnsupportedEncodingException if UTF8 is not supported
     */
    public static void marshal (ScorePartwise scorePartwise,
                                OutputStream  os)
        throws JAXBException, IOException, UnsupportedEncodingException
    {
        marshal(scorePartwise, os, true);
    }

    //---------//
    // marshal //
    //---------//
    /**
     * Marshal the hierarchy rooted at provided ScorePartwise instance to an
     * OutputStream (which is not closed by this method).
     *
     * @param scorePartwise the root element
     * @param os the output stream
     * @param injectSignature false if ProxyMusic encoder must not be referenced
     * @exception JAXBException if marshalling goes wrong
     * @exception IOException for output error
     * @exception UnsupportedEncodingException if UTF8 is not supported
     */
    public static void marshal (ScorePartwise scorePartwise,
                                OutputStream  os,
                                boolean       injectSignature)
        throws JAXBException, IOException, UnsupportedEncodingException
    {
        annotate(scorePartwise, injectSignature);

        /* Marshal to temporary data */
        Marshaller m = getContext()
                           .createMarshaller();
        m.setProperty(Marshaller.JAXB_FRAGMENT, true);
        m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter stringWriter = new StringWriter();
        m.marshal(scorePartwise, stringWriter);
        stringWriter.flush();

        /** Postprocessing (to remove the xmlns:ns2 stuff) */
        String data = stringWriter.toString();

        if (true) {
            data = stringWriter.toString()
                               .replaceAll(
                " xmlns:ns2=\"http://www.w3.org/1999/xlink\"",
                "");
        }

        stringWriter.close();

        /** Finally, write out data to the UTF8 stream */
        Writer out = new BufferedWriter(new OutputStreamWriter(os, "UTF8"));
        out.write(XML_LINE);
        out.write(DOCTYPE_LINE);
        out.write(data);
        out.flush();
        out.close();
    }

    //---------//
    // marshal //
    //---------//
    /**
     * Marshal the hierarchy rooted at provided ScorePartwise instance directly
     * to a DOM node.
     *
     * @param scorePartwise the root element
     * @param node the DOM node where elements must be added
     * @param injectSignature false if ProxyMusic encoder must not be referenced
     * @exception JAXBException if marshalling goes wrong
     */
    public static void marshal (ScorePartwise scorePartwise,
                                Node          node,
                                boolean       injectSignature)
        throws JAXBException
    {
        annotate(scorePartwise, injectSignature);

        // Then the object to marshal
        Marshaller m = getContext()
                           .createMarshaller();
        m.setProperty(Marshaller.JAXB_FRAGMENT, true);
        m.marshal(scorePartwise, node);
    }

    //-----------//
    // unmarshal //
    //-----------//
    /**
     * Unmarshal a ScorePartwise instance from an InputStream.
     * <b>Nota:</b> The URL of MusicXML DTD is specifically ignored by this
     * method.
     *
     * @param is the input stream
     * @return the scorePartwise root element
     * @exception JAXBException if unmarshalling goes wrong
     * @exception SAXException
     * @exception ParserConfigurationException
     */
    public static ScorePartwise unmarshal (InputStream is)
        throws JAXBException, SAXException, ParserConfigurationException
    {
        SAXParser saxParser = SAXParserFactory.newInstance()
                                              .newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        xmlReader.setEntityResolver(filteringEntityResolver);

        SAXSource     saxSource = new SAXSource(xmlReader, new InputSource(is));
        Unmarshaller  um = getContext()
                               .createUnmarshaller();
        ScorePartwise partwise = (ScorePartwise) um.unmarshal(saxSource);

        return partwise;
    }

    //----------//
    // annotate //
    //----------//
    /**
     * Annotate the scorePartwise tree with information about MusicXML version
     * and, if so desired, with information about ProxyMusic and generation date.
     * @param scorePartwise the tree to annotate
     * @param injectSignature if true, ProxyMusic information is added
     */
    private static void annotate (ScorePartwise scorePartwise,
                                  boolean       injectSignature)
    {
        // Predefined factory for all proxymusic elements
        ObjectFactory factory = new ObjectFactory();

        // Inject version
        if (specificationVersion != null) {
            scorePartwise.setVersion(specificationVersion);
        }

        // Inject signature if so desired
        if (injectSignature && (specificationTitle != null)) {
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
            encoding.getEncodingDateOrEncoderOrSoftware()
                    .add(
                factory.createEncodingSoftware(
                    specificationTitle +
                    ((implementationVersion != null)
                     ? (" " + implementationVersion) : "")));

            // [Encoding]/EncodingDate
            try {
                encoding.getEncodingDateOrEncoderOrSoftware()
                        .add(
                    factory.createEncodingEncodingDate(
                        DatatypeFactory.newInstance().newXMLGregorianCalendar(
                            new GregorianCalendar())));
            } catch (DatatypeConfigurationException ex) {
                Logger.getLogger(Marshalling.class.getName())
                      .log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }
}
