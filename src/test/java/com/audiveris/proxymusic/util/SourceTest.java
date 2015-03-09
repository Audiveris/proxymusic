//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                                       S o u r c e T e s t                                      //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//  Copyright © Herve Bitteur and others 2000-2014. All rights reserved.
//  This software is released under the GNU General Public License.
//  Goto http://kenai.com/projects/audiveris to report bugs or suggestions.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package com.audiveris.proxymusic.util;

import com.audiveris.proxymusic.Identification;
import com.audiveris.proxymusic.Miscellaneous;
import com.audiveris.proxymusic.MiscellaneousField;
import com.audiveris.proxymusic.Opus;
import com.audiveris.proxymusic.ScorePartwise;
import com.audiveris.proxymusic.util.Source.SheetSystems;

import junit.framework.TestCase;

import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Class {@code SourceTest}
 *
 * @author Hervé Bitteur
 */
public class SourceTest
    extends TestCase
{
    //~ Static fields/initializers -----------------------------------------------------------------

    private static final Logger logger = LoggerFactory.getLogger(SourceTest.class);

    /** Temporary area. */
    private static final File TEMP_DIR = new File("target/temp");

    /** Name of the temporary XML file. */
    private static final String FILE_NAME = "source-test.xml";

    //~ Methods ------------------------------------------------------------------------------------

    //-----------------//
    // testBothInOrder //
    //-----------------//
    @Test
    public void testBothInOrder ()
        throws Exception
    {
        logger.info("Calling testBothInOrder...");

        logger.info("Building Opus JAXB context");
        Marshalling.getContext(Opus.class);

        logger.info("Building ScorePartwise JAXB context");
        Marshalling.getContext(ScorePartwise.class);

        tryMarshal();
        tryUnmarshal();
    }

    //------------//
    // tryMarshal //
    //------------//
    /**
     * Test the marshalling of a ScorePartwise instance
     */
    public void tryMarshal ()
        throws Exception
    {
        logger.info("Calling tryMarshal...");

        // Get a populated score partwise
        ScorePartwise scorePartwise = DummyGenerator.buildScorePartwise("Dummy score", 2);

        // Inject additional miscellaneous element
        addSource(scorePartwise);

        //  Finally, marshal the proxy
        File         xmlFile = new File(TEMP_DIR, FILE_NAME);
        OutputStream os = new FileOutputStream(xmlFile);
        long         start = System.currentTimeMillis();

        Marshalling.marshal(scorePartwise, os, true, 2);

        logger.info("Marshalling done in {} ms", System.currentTimeMillis() - start);
        logger.info("Score exported to {}", xmlFile);
        os.close();
    }

    //--------------//
    // tryUnmarshal //
    //--------------//
    /**
     * Test the unmarshalling of a ScorePartwise instance from the XML file
     * written by the testmarshal() method.
     */
    public void tryUnmarshal ()
        throws Exception
    {
        logger.info("Calling tryUnmarshal...");

        //  Unmarshal the proxy
        File          xmlFile = new File(TEMP_DIR, FILE_NAME);
        InputStream   is = new FileInputStream(xmlFile);
        long          start = System.currentTimeMillis();

        ScorePartwise scorePartwise = (ScorePartwise) Marshalling.unmarshal(is);

        logger.info("Unmarshalling done in {} ms", System.currentTimeMillis() - start);
        logger.info("Score imported from {}", xmlFile);
        is.close();

        // Basic check of the java objects
        checkSource(scorePartwise);

        // Higher level
        Source input = Source.decode(scorePartwise);
        logger.info("Decoded {}", input);
    }

    //-------//
    // setUp //
    //-------//
    @Override
    protected void setUp ()
        throws Exception
    {
        logger.info(
            "SourceTest. name:{} version:{} revision:{}",
            ProgramId.NAME,
            ProgramId.VERSION,
            ProgramId.REVISION);

        // Make sure the temp directory exists
        TEMP_DIR.mkdirs();
    }

    //-----------//
    // addSource //
    //-----------//
    /**
     * Inject some Source data into ScorePartwise instance.
     *
     * @param scorePartwise
     */
    private void addSource (ScorePartwise scorePartwise)
    {
        // Build a Source structure
        Source source = new Source();
        source.setFile("miscellaneous.png");

        source.setOffset(10);

        SheetSystems sheetSystems = new SheetSystems(1);
        sheetSystems.getSystems().add(1);
        sheetSystems.getSystems().add(2);
        source.getSheets().add(sheetSystems);

        source.getSheets().add(new SheetSystems(2));

        source.getSheets().add(sheetSystems = new SheetSystems(3));
        sheetSystems.getSystems().add(1);

        source.encode(scorePartwise);
        logger.info("Source buit as {}", source);
    }

    //-------------//
    // checkSource //
    //-------------//
    private void checkSource (ScorePartwise scorePartwise)
    {
        // Inspect the miscellaneous stuff
        Identification identification = scorePartwise.getIdentification();
        Miscellaneous  misc = identification.getMiscellaneous();

        for (MiscellaneousField field : misc.getMiscellaneousField()) {
            String name = field.getName();
            String value = field.getValue();
            logger.info("miscellaneous-field name:{} value:'{}'", name, value);
        }
    }
}
