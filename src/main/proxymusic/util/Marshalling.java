//----------------------------------------------------------------------------//
//                                                                            //
//                           M a r s h a l l i n g                            //
//                                                                            //
//  Copyright (C) Herve Bitteur 2000-2009. All rights reserved.               //
//  This software is released under the GNU Lesser General Public License.    //
//  Please contact users@proxymusic.dev.java.net to report bugs & suggestions.//
//----------------------------------------------------------------------------//
//
package proxymusic.util;

import org.w3c.dom.Node;

import proxymusic.*;

import java.io.*;
import java.lang.String; // Don't remove this line!
import java.util.GregorianCalendar;
import java.util.logging.Logger;

import javax.xml.bind.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

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
    private static final Package pmPackage = ObjectFactory.class.getPackage();

    /** Precise tool name, example: "ProxyMusic" */
    public static final String specificationTitle = pmPackage.getSpecificationTitle();

    /** Supported MusicXML version, example: "1.1", "2.0"*/
    public static final String specificationVersion = pmPackage.getSpecificationVersion();

    /** Full binding version, example: "MusicXML-2.0 JAXB-2.0 d" */
    public static final String implementationVersion = pmPackage.getImplementationVersion();

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
                                               " \"http://www.musicxml.org/dtds/partwise.dtd\">\n";

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
     * OutputStream (which is not closed by this method).
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
        annotate(scorePartwise, injectSignature);

        /* Marshal to temporary data */
        Marshaller m = getContext()
                           .createMarshaller();
        m.setProperty(Marshaller.JAXB_FRAGMENT, true);
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter stringWriter = new StringWriter();
        m.marshal(scorePartwise, stringWriter);
        stringWriter.flush();

        String data = stringWriter.toString();

        /** Postprocessing (to remove the xmlns:ns2 stuff) */
        data = stringWriter.toString()
                           .replaceAll(
            " xmlns:ns2=\"http://www.w3.org/1999/xlink\"",
            "");

        /** Finally, write out data to the stream */
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(os);
        outputStreamWriter.write(XML_LINE);
        outputStreamWriter.write(DOCTYPE_LINE);
        outputStreamWriter.write(data);

        outputStreamWriter.flush();
        outputStreamWriter.close();
        stringWriter.close();

        // We don't close os
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

    //----------//
    // annotate //
    //----------//
    /**
     * Annotate the scorePartwise tree with information about MusicXML version
     * and, if so desired, with information about ProxyMusic and generation date
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
        if (injectSignature &&
            (specificationTitle != null) &&
            (implementationVersion != null)) {
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
                    specificationTitle + " " + implementationVersion));

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
