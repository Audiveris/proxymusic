//----------------------------------------------------------------------------//
//                                                                            //
//                         S c o r e P a r t T e s t                          //
//                                                                            //
//  Copyright © Hervé Bitteur and others 2000-2014. All rights reserved.      //
//  This software is released under the GNU Lesser General Public License.    //
//  Please see http://kenai.com/projects/proxymusic/ for bugs & suggestions.  //
//----------------------------------------------------------------------------//
//
package com.audiveris.proxymusic.util;

import com.audiveris.proxymusic.*;
import com.audiveris.proxymusic.ScorePartwise.Part;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Test;

import java.io.*;
import java.lang.String; // Do not remove this line
import java.util.List;

/**
 * This example test marshalling and unmarshalling with information
 * related to MIDI instruments.
 *
 * @author Hervé Bitteur
 */
public class ScorePartTest
        extends TestCase
{
    //~ Static fields/initializers ---------------------------------------------

    /** Usual logger utility */
    private static final Logger logger = LoggerFactory.getLogger(ScorePartTest.class);

    /**
     * <part-list>
     * <score-part id="P1">
     * <part-name print-object="no">Voice</part-name>
     * <score-instrument id="P1-I3">
     * <instrument-name>Voice</instrument-name>
     * </score-instrument>
     * <midi-instrument id="P1-I3">
     * <midi-channel>1</midi-channel>
     * <midi-program>55</midi-program>
     * </midi-instrument>
     * </score-part>
     * <score-part id="P2">
     * <part-name print-object="no">Guitar</part-name>
     * <score-instrument id="P2-I2">
     * <instrument-name>Acoustic Guitar (steel)</instrument-name>
     * </score-instrument>
     * <midi-instrument id="P2-I2">
     * <midi-channel>2</midi-channel>
     * <midi-program>26</midi-program>
     * </midi-instrument>
     * </score-part>
     * </part-list>
     */
    private static final String versionData = ProgramId.VERSION;

    private static final int dataNb = 2;

    private static final PartData[] partData = new PartData[dataNb];

    private static final InstData[] instData = new InstData[dataNb];

    static {
        partData[0] = new PartData("P1", "Voice");
        instData[0] = new InstData("P1-I3", "Voice", 1, 55);

        partData[1] = new PartData("P2", "Guitar");
        instData[1] = new InstData("P2-I2", "Acoustic Guitar (steel)", 2, 26);
    }

    //~ Instance fields --------------------------------------------------------
    /** Factory for all proxymusic elements */
    private final ObjectFactory factory = new ObjectFactory();

    /** Temporary area. */
    private static final File TEMP_DIR = new File("target/temp");

    /** Name of the temporary XML file. */
    private static final String FILE_NAME = "score-part-test.xml";

    //~ Methods ----------------------------------------------------------------
    //------//
    // main //
    //------//
    /**
     * Method for stand-alone execution (outside of Junit environment)
     *
     * @param notUsed
     */
    public static void main (String... notUsed)
            throws Exception
    {
        ScorePartTest instance = new ScorePartTest();
        instance.setUp();
        instance.tryMarshal();
        instance.tryUnmarshal();
    }

    //-----------------//
    // testBothInOrder //
    //-----------------//
    @Test
    public void testBothInOrder ()
            throws Exception
    {
        logger.info("Calling testBothInOrder...");
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
    {
        logger.info("Calling tryMarshal...");

        try {
            // Get a populated score partwise
            ScorePartwise scorePartwise = getScorePartwise();

            //  Finally, marshal the proxy
            File xmlFile = new File(TEMP_DIR, FILE_NAME);
            OutputStream os = new FileOutputStream(xmlFile);

            Marshalling.marshal(scorePartwise, os, true, 2);
            logger.info("Score exported to {}", xmlFile);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Error in testMarshal");
        }
    }

    //--------------//
    // tryUnmarshal //
    //--------------//
    /**
     * Test the unmarshalling of a ScorePartwise instance from the XML file
     * written by the testmarshal() method.
     */
    public void tryUnmarshal ()
    {
        logger.info("Calling tryUnmarshal...");

        //  Unmarshal the proxy
        try {
            File xmlFile = new File(TEMP_DIR, FILE_NAME);
            InputStream is = new FileInputStream(xmlFile);

            ScorePartwise scorePartwise = (ScorePartwise) Marshalling.unmarshal(is);
            logger.info("Score imported from {}", xmlFile);
            is.close();

            // Basic dump of the java objects
            checkScorePartwise(scorePartwise);
        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Error in testUnmarshal");
        }
    }

    //-------//
    // setUp //
    //-------//
    @Override
    protected void setUp ()
            throws Exception
    {
        logger.info("ScorePartTest. name:{} version:{} revision:{}",
                ProgramId.NAME, ProgramId.VERSION, ProgramId.REVISION);

        // Make sure the temp directory exists
        TEMP_DIR.mkdirs();
    }

    //-----------//
    // checkPart //
    //-----------//
    private void checkPart (Part part,
                            PartData pData)
    {
        Object obj = part.getId();
        assertNotNull(obj);
        logger.info(new Dumper.Column(obj, "from checkPart").toString());
    }

    //---------------//
    // checkPartList //
    //---------------//
    private void checkPartList (PartList partList)
    {
        assertNotNull(partList);
        logger.info(new Dumper.Column(partList).toString());

        List<Object> objects = partList.getPartGroupOrScorePart();
        assertTrue(dataNb == objects.size());

        for (int i = 0; i < dataNb; i++) {
            checkScorePart((ScorePart) objects.get(i), partData[i], instData[i]);
        }
    }

    //----------------//
    // checkScorePart //
    //----------------//
    private void checkScorePart (ScorePart scorePart,
                                 PartData pData,
                                 InstData iData)
    {
        assertNotNull(scorePart);
        logger.info(new Dumper.Column(scorePart, "from checkScorePart").toString());

        assertEquals(pData.id, scorePart.getId());
        assertEquals(pData.name, scorePart.getPartName().getValue());

        List<ScoreInstrument> instruments = scorePart.getScoreInstrument();
        assertTrue(1 == instruments.size());

        for (ScoreInstrument scoreInstrument : instruments) {
            assertEquals(iData.id, scoreInstrument.getId());
            assertEquals(iData.name, scoreInstrument.getInstrumentName());
        }

        List<Object> midis = scorePart.getMidiDeviceAndMidiInstrument();
        assertTrue(1 == midis.size());

        for (Object object : midis) {
            assertTrue(object instanceof MidiInstrument);

            MidiInstrument midiInstrument = (MidiInstrument) object;
            assertEquals(
                    iData.id,
                    ((ScoreInstrument) midiInstrument.getId()).getId());
            assertTrue(iData.channel == midiInstrument.getMidiChannel());
            assertTrue(iData.program == midiInstrument.getMidiProgram());
        }
    }

    //--------------------//
    // checkScorePartwise //
    //--------------------//
    private void checkScorePartwise (ScorePartwise scr)
    {
        logger.info(new Dumper.Column(scr).toString());
        assertEquals(versionData, scr.getVersion());

        Identification identification = scr.getIdentification();
        assertNotNull(identification);
        logger.info(new Dumper.Column(identification).toString());

        checkPartList(scr.getPartList());

        List<Part> parts = scr.getPart();
        assertTrue(dataNb == parts.size());

        for (int i = 0; i < dataNb; i++) {
            checkPart(parts.get(i), partData[i]);
        }
    }

    //----------------//
    // feedInstrument //
    //----------------//
    private void feedInstrument (ScorePart scorePart,
                                 InstData data)
    {
        ScoreInstrument scoreInstrument = factory.createScoreInstrument();
        scorePart.getScoreInstrument()
                .add(scoreInstrument);
        scoreInstrument.setId(data.id);
        scoreInstrument.setInstrumentName(data.name);

        MidiInstrument midiInstrument = factory.createMidiInstrument();
        scorePart.getMidiDeviceAndMidiInstrument()
                .add(midiInstrument);
        midiInstrument.setId(scoreInstrument);
        midiInstrument.setMidiChannel(data.channel);
        midiInstrument.setMidiProgram(data.program);
    }

    //---------------//
    // feedScorepart //
    //---------------//
    private ScorePart feedScorepart (ScorePartwise scorePartwise,
                                     PartData data)
    {
        // Scorepart in partList
        ScorePart scorePart = factory.createScorePart();
        PartList partList = scorePartwise.getPartList();
        partList.getPartGroupOrScorePart()
                .add(scorePart);
        scorePart.setId(data.id);

        PartName partName = factory.createPartName();
        scorePart.setPartName(partName);
        partName.setValue(data.name);
        partName.setPrintObject(YesNo.NO);

        // ScorePart in scorePartwise
        Part part = factory.createScorePartwisePart();
        scorePartwise.getPart()
                .add(part);
        part.setId(scorePart);

        return scorePart;
    }

    //------------------//
    // getScorePartwise //
    //------------------//
    private ScorePartwise getScorePartwise ()
    {
        // Allocate the score partwise
        ScorePartwise scorePartwise = factory.createScorePartwise();

        // No Version, we leave this to ProxyMusic

        // PartList
        PartList partList = factory.createPartList();
        scorePartwise.setPartList(partList);

        for (int i = 0; i < dataNb; i++) {
            feedInstrument(
                    feedScorepart(scorePartwise, partData[i]),
                    instData[i]);
        }

        return scorePartwise;
    }

    //~ Inner Classes ----------------------------------------------------------
    private static class InstData
    {
        //~ Instance fields ----------------------------------------------------

        final String id;

        final String name;

        final int channel;

        final int program;

        //~ Constructors -------------------------------------------------------
        public InstData (String id,
                         String name,
                         int channel,
                         int program)
        {
            this.id = id;
            this.name = name;
            this.channel = channel;
            this.program = program;
        }
    }

    private static class PartData
    {
        //~ Instance fields ----------------------------------------------------

        final String id;

        final String name;

        //~ Constructors -------------------------------------------------------
        public PartData (String id,
                         String name)
        {
            this.id = id;
            this.name = name;
        }
    }
}
