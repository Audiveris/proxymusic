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

    /** Un/marshalling context for use with JAXB */
    private static JAXBContext jaxbContext;

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
    // Marshal //
    //---------//
    /**
     * Marshal the hierarchy rooted at provided ScorePartwise instance to an
     * OutputStream
     *
     * @param scorePartwise the root element
     * @param os the output stream
     * @exception JAXBException if marshalling goes wrong
     */
    public static void marshal (ScorePartwise scorePartwise,
                                OutputStream  os)
        throws JAXBException
    {
        Marshaller m = getContext()
                           .createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(scorePartwise, os);
    }

    //---------//
    // marshal //
    //---------//
    /**
     * Unmarshal a ScorePartwise instance from an InputStream
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

        return (ScorePartwise) um.unmarshal(is);
    }
}
