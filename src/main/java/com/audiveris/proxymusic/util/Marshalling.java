//----------------------------------------------------------------------------//
//                                                                            //
//                           M a r s h a l l i n g                            //
//                                                                            //
//  Copyright © Hervé Bitteur and others 2000-20123. All rights reserved.     //
//  This software is released under the GNU Lesser General Public License.    //
//  Please see http://kenai.com/projects/proxymusic/ for bugs & suggestions.  //
//----------------------------------------------------------------------------//
//
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
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;

/**
 * Class {@code Marshalling} gathers static methods to marshal and to
 * unmarshal {@code ScorePartwise} java objects to/from an output/input
 * stream in UTF8 encoding and using MusicXML format.
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

    /** [Un]marshalling context for use with JAXB. */
    private static JAXBContext jaxbContext;

    /** The xml document statement. */
    private static final String XML_LINE = "<?xml version=\"1.0\""
                                           + " encoding=\"UTF-8\"" + //" standalone=\"yes\" +
            "?>\n";

    /** URL of MusicXML DTD. */
    private static final String DTD_URL = "http://www.musicxml.org/dtds/partwise.dtd";

    /** The DOCTYPE statement for xml. */
    private static final String DOCTYPE_LINE = "<!DOCTYPE score-partwise PUBLIC"
                                               + " \"-//Recordare//DTD MusicXML "
                                               + ProgramId.VERSION
                                               + " Partwise//EN\"" + " \""
                                               + DTD_URL + "\">\n";

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

    //~ Constructors -----------------------------------------------------------
    /** Not meant to be instantiated. */
    private Marshalling ()
    {
    }

    //~ Methods ----------------------------------------------------------------
    //----------------//
    // getJaxbContext //
    //----------------//
    /**
     * Get access to (and elaborate if not yet done) the needed JAXB
     * context.
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
     * Marshal the hierarchy rooted at provided ScorePartwise instance
     * to an OutputStream, ProxyMusic being referenced as an encoder.
     * (The output stream is not closed by this method)
     *
     * @param scorePartwise the root element
     * @param os            the output stream
     * @exception JAXBException if marshalling goes wrong
     * @exception IOException   for output error
     */
    public static void marshal (final ScorePartwise scorePartwise,
                                final OutputStream os)
            throws JAXBException, IOException
    {
        marshal(scorePartwise, os, true);
    }

    //---------//
    // marshal //
    //---------//
    /**
     * Marshal the hierarchy rooted at provided ScorePartwise instance
     * to an OutputStream (which is not closed by this method).
     *
     * @param scorePartwise   the root element
     * @param os              the output stream
     * @param injectSignature false if ProxyMusic encoder must not be referenced
     * @exception JAXBException if marshalling goes wrong
     * @exception IOException   for output error
     */
    public static void marshal (final ScorePartwise scorePartwise,
                                final OutputStream os,
                                final boolean injectSignature)
            throws JAXBException, IOException
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
        Writer out = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
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
     * Marshal the hierarchy rooted at provided ScorePartwise instance
     * directly to a DOM node.
     *
     * @param scorePartwise   the root element
     * @param node            the DOM node where elements must be added
     * @param injectSignature false if ProxyMusic encoder must not be referenced
     * @exception JAXBException if marshalling goes wrong
     */
    public static void marshal (final ScorePartwise scorePartwise,
                                final Node node,
                                final boolean injectSignature)
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
     * @exception JAXBException                if unmarshalling goes wrong
     * @exception SAXException                 if unmarshalling goes wrong
     * @exception ParserConfigurationException if unmarshalling goes wrong
     */
    public static ScorePartwise unmarshal (final InputStream is)
            throws JAXBException, SAXException, ParserConfigurationException
    {
        SAXParser saxParser = SAXParserFactory.newInstance()
                .newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        xmlReader.setEntityResolver(filteringEntityResolver);

        SAXSource saxSource = new SAXSource(xmlReader, new InputSource(is));
        Unmarshaller um = getContext()
                .createUnmarshaller();
        ScorePartwise partwise = (ScorePartwise) um.unmarshal(saxSource);

        return partwise;
    }

    //----------//
    // annotate //
    //----------//
    /**
     * Annotate the scorePartwise tree with information about MusicXML
     * version and, if so desired, with information about ProxyMusic
     * and generation date.
     *
     * @param scorePartwise   the tree to annotate
     * @param injectSignature if true, ProxyMusic information is added
     */
    private static void annotate (final ScorePartwise scorePartwise,
                                  final boolean injectSignature)
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
            encoding.getEncodingDateOrEncoderOrSoftware()
                    .add(
                    factory.createEncodingSoftware(
                    ProgramId.NAME + " "
                    + ProgramId.VERSION + "."
                    + ProgramId.REVISION));

            // [Encoding]/EncodingDate
            try {
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
                encoding.getEncodingDateOrEncoderOrSoftware()
                        .add(factory.createEncodingEncodingDate(gc));
            } catch (DatatypeConfigurationException ex) {
                Logger.getLogger(Marshalling.class.getName())
                        .log(
                        java.util.logging.Level.SEVERE,
                        "Cannot encode date",
                        ex);
            }
        }
    }
}
