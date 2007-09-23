//----------------------------------------------------------------------------//
//                                                                            //
//                           M a r s h a l l i n g                            //
//                                                                            //
//  Copyright (C) Herve Bitteur 2007. All rights reserved.                    //
//  This software is released under the terms of the GNU General Public       //
//  License. Please contact the author at herve.bitteur@laposte.net           //
//  to report bugs & suggestions.                                             //
//----------------------------------------------------------------------------//
//
package proxymusic.util;

import proxymusic.*;

import java.io.*;
import java.lang.String;

import javax.xml.bind.*;

/**
 * Class <code>Marshalling</code> gathers static methods to marshal and to
 * unmarshal ScorePartwise java objects to/from an output/input stream using
 * MusicXML format.
 *
 * <p>The method {@link #getContext} is publicly visible so as to allow an
 * asynchronous elaboration of the JAXB context, which is an expensive operation
 * because of the large number of Java classes in the ScorePartwise hierarchy.
 *
 * @author Herv&eacute Bitteur
 * @version $Id$
 */
public class Marshalling
{
    //~ Static fields/initializers ---------------------------------------------

    /** Containing package */
    private static final Package thisPackage = Marshalling.class.getPackage();

    /** Tool name, example: "ProxyMusic" */
    private static final String specificationTitle = thisPackage.getSpecificationTitle();

    /** Tool version, example: "1.1", "2.0"*/
    private static final String specificationVersion = thisPackage.getSpecificationVersion();

    /** Tool build,, example "1.1 a", "2.0 beta" */
    private static final String implementationVersion = thisPackage.getImplementationVersion();

    /** [Un]marshalling context for use with JAXB */
    private static JAXBContext jaxbContext;

    /** The xml document statement */
    private static final String XML_LINE = "<?xml version=\"1.0\"" +
                                           " encoding=\"UTF-8\"" + //" standalone=\"yes\" +
                                           "?>\n";

    /** The DOCTYPE statement for xml */
    private static final String DOCTYPE_LINE = "<!DOCTYPE score-partwise PUBLIC" +
                                               " \"-//Recordare//DTD MusicXML " +
                                               specificationVersion +
                                               " Partwise//EN\"" +
                                               " \"http://www.musicxml.org/dtds/partwise.dtd\">";

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
     * Get access to (and elaborate if not yet done) the needed JAXB context
     *
     * @return the ready to use JAXB context
     * @exception JAXBException if anything goes wrong
     */
    public static synchronized JAXBContext getContext ()
        throws JAXBException
    {
        // Lazy creation
        if (jaxbContext == null) {
            jaxbContext = JAXBContext.newInstance(
                ScorePartwise.class,
                Part.class);
        }

        return jaxbContext;
    }

    //--------------------//
    // getMusicXmlVersion //
    //--------------------//
    /**
     * Report the version of MusicXML being used (e.g. "2.0")
     *
     * @return the MusicXML version being used
     */
    public static String getMusicXmlVersion ()
    {
        return specificationVersion;
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
     */
    public static void marshal (ScorePartwise scorePartwise,
                                OutputStream  os)
        throws JAXBException, IOException
    {
        marshal(scorePartwise, os, true);
    }

    //---------//
    // marshal //
    //---------//
    /**
     * Marshal the hierarchy rooted at provided ScorePartwise instance to an
     * OutputStream
     * (The output stream is not closed by this method)
     *
     * @param scorePartwise the root element
     * @param os the output stream
     * @param injectSignature false if ProxyMusic encoder must not be referenced
     * @exception JAXBException if marshalling goes wrong
     * @exception IOException for output error
     */
    public static void marshal (ScorePartwise scorePartwise,
                                OutputStream  os,
                                boolean       injectSignature)
        throws JAXBException, IOException
    {
        // Inject version
        if (specificationVersion != null) {
            scorePartwise.setVersion(specificationVersion);
        }

        // Inject signature if so desired
        if (injectSignature &&
            (specificationTitle != null) &&
            (implementationVersion != null)) {
            // Identification
            Identification identification = scorePartwise.getIdentification();

            if (identification == null) {
                identification = new Identification();
                scorePartwise.setIdentification(identification);
            }

            // Encoding
            Encoding encoding = identification.getEncoding();

            if (encoding == null) {
                encoding = new Encoding();
                identification.setEncoding(encoding);
            }

            // [Encoding]/Software
            Software software = new Software();
            encoding.getEncodingDateOrEncoderOrSoftware()
                    .add(software);
            software.setContent(
                specificationTitle + " " + implementationVersion);
        }

        // Take care of first statements
        os.write(XML_LINE.getBytes());
        os.write(DOCTYPE_LINE.getBytes());

        // Then the object to marshal
        Marshaller m = getContext()
                           .createMarshaller();
        m.setProperty(Marshaller.JAXB_FRAGMENT, true);
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(scorePartwise, os);

        // We don't close os
    }

    //-----------//
    // unmarshal //
    //-----------//
    /**
     * Unmarshal a ScorePartwise instance from an InputStream.
     * (The input stream is not closed by this method)
     *
     * @param is the input stream
     * @return the scorePartwise root element
     * @exception JAXBException if unmarshalling goes wrong
     */
    public static ScorePartwise unmarshal (InputStream is)
        throws JAXBException
    {
        Unmarshaller um = getContext()
                              .createUnmarshaller();
        um.setSchema(null);

        return (ScorePartwise) um.unmarshal(is);
    }
}
