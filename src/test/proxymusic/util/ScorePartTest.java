//----------------------------------------------------------------------------//
//                                                                            //
//                         S c o r e P a r t T e s t                          //
//                                                                            //
//  Copyright (C) Herve Bitteur 2000-2009. All rights reserved.               //
//  This software is released under the GNU Lesser General Public License.    //
//  Please contact users@proxymusic.dev.java.net to report bugs & suggestions //
//----------------------------------------------------------------------------//
//
package proxymusic.util;

import junit.framework.TestCase;

import proxymusic.*;

import proxymusic.ScorePartwise.Part;

import java.io.*;
import java.lang.String;
import java.util.List;

/**
 * This example test marshalling and unmarshalling with information related to
 * MIDI instruments.
 *
 * @author Herv&eacute; Bitteur
 * @version $Id$
 */
public class ScorePartTest
    extends TestCase
{
    //~ Static fields/initializers ---------------------------------------------

    /**
     *  <part-list>
     *    <score-part id="P1">
     *      <part-name print-object="no">Voice</part-name>
     *      <score-instrument id="P1-I3">
     *        <instrument-name>Voice</instrument-name>
     *      </score-instrument>
     *      <midi-instrument id="P1-I3">
     *        <midi-channel>1</midi-channel>
     *        <midi-program>55</midi-program>
     *      </midi-instrument>
     *    </score-part>
     *    <score-part id="P2">
     *      <part-name print-object="no">Guitar</part-name>
     *      <score-instrument id="P2-I2">
     *        <instrument-name>Acoustic Guitar (steel)</instrument-name>
     *      </score-instrument>
     *      <midi-instrument id="P2-I2">
     *        <midi-channel>2</midi-channel>
     *        <midi-program>26</midi-program>
     *      </midi-instrument>
     *    </score-part>
     *  </part-list>
     */
    private static final String versionData = "2.0";
    private static final int        dataNb = 2;
    private static final PartData[] partData = new PartData[dataNb];
    private static final InstData[] instData = new InstData[dataNb];

    static {
        partData[0] = new PartData("P1", "Voice");
        instData[0] = new InstData("P1-I3", "Voice", 1, 55);

        partData[1] = new PartData("P2", "Guitar");
        instData[1] = new InstData("P2-I2", "Acoustic Guitar (steel)", 2, 26);
    }

    //~ Instance fields --------------------------------------------------------

    /** Name of the temporary XML file */
    private final String FILE_NAME = "ScorePartTest.xml";

    /** Factory for all proxymusic elements */
    private final ObjectFactory factory = new ObjectFactory();

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
        System.out.println("Calling testMarshal...");
        instance.testMarshal();
        System.out.println("Calling testUnmarshal...");
        instance.testUnmarshal();
    }

    //-------//
    // setUp //
    //-------//
    @Override
    protected void setUp ()
        throws Exception
    {
        System.out.println(
            "ScorePartTest. " + " specificationTitle:" +
            Marshalling.specificationTitle + " specificationVersion:" +
            Marshalling.specificationVersion + " implementationVersion:" +
            Marshalling.implementationVersion);
    }

    //-------------//
    // testMarshal //
    //-------------//
    /**
     * Test the marshalling of a ScorePartwise instance
     */
    public void testMarshal ()
    {
        try {
            // Get a populated score partwise
            ScorePartwise scorePartwise = getScorePartwise();

            //  Finally, marshal the proxy
            File         xmlFile = new File(FILE_NAME);
            OutputStream os = new FileOutputStream(xmlFile);

            Marshalling.marshal(scorePartwise, os);
            System.out.println("Score exported to " + xmlFile);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Error in testMarshal");
        }
    }

    //---------------//
    // testUnmarshal //
    //---------------//
    /**
     * Test the unmarshalling of a ScorePartwise instance from the XML file
     * written by the testmarshal() method.
     */
    public void testUnmarshal ()
    {
        //  Unmarshal the proxy
        try {
            File          xmlFile = new File(FILE_NAME);
            InputStream   is = new FileInputStream(xmlFile);

            ScorePartwise scorePartwise = Marshalling.unmarshal(is);
            System.out.println("Score imported from " + xmlFile);
            is.close();

            // Basic dump of the java objects
            checkScorePartwise(scorePartwise);
        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Error in testUnmarshal");
        }
    }

    //-----------//
    // checkPart //
    //-----------//
    private void checkPart (Part     part,
                            PartData pData)
    {
        Object obj = part.getId();
        assertNotNull(obj);
        Dumper.dump(obj, "from checkPart");
    }

    //---------------//
    // checkPartList //
    //---------------//
    private void checkPartList (PartList partList)
    {
        assertNotNull(partList);
        Dumper.dump(partList);

        List<Object> objects = partList.getPartGroupOrScorePart();
        assertTrue(dataNb == objects.size());

        for (int i = 0; i < dataNb; i++) {
            checkScorePart(
                (ScorePart) objects.get(i),
                partData[i],
                instData[i]);
        }
    }

    //--------------------//
    // checkScorePartwise //
    //--------------------//
    private void checkScorePartwise (ScorePartwise scr)
    {
        Dumper.dump(scr);
        assertEquals(versionData, scr.getVersion());

        Identification identification = scr.getIdentification();
        assertNotNull(identification);
        Dumper.dump(identification);

        checkPartList(scr.getPartList());

        List<Part> parts = scr.getPart();
        assertTrue(dataNb == parts.size());

        for (int i = 0; i < dataNb; i++) {
            checkPart(parts.get(i), partData[i]);
        }
    }

    //----------------//
    // checkScorePart //
    //----------------//
    private void checkScorePart (ScorePart scorePart,
                                 PartData  pData,
                                 InstData  iData)
    {
        assertNotNull(scorePart);
        Dumper.dump(scorePart, "from checkScorePart");

        assertEquals(pData.id, scorePart.getId());
        assertEquals(pData.name, scorePart.getPartName().getValue());

        List<ScoreInstrument> instruments = scorePart.getScoreInstrument();
        assertTrue(1 == instruments.size());

        for (ScoreInstrument scoreInstrument : instruments) {
            assertEquals(iData.id, scoreInstrument.getId());
            assertEquals(iData.name, scoreInstrument.getInstrumentName());
        }

        List<MidiInstrument> midis = scorePart.getMidiInstrument();
        assertTrue(1 == midis.size());

        for (MidiInstrument midiInstrument : midis) {
            assertEquals(
                iData.id,
                ((ScoreInstrument) midiInstrument.getId()).getId());
            assertTrue(iData.channel == midiInstrument.getMidiChannel());
            assertTrue(iData.program == midiInstrument.getMidiProgram());
        }
    }

    //----------------//
    // feedInstrument //
    //----------------//
    private void feedInstrument (ScorePart scorePart,
                                 InstData  data)
    {
        ScoreInstrument scoreInstrument = factory.createScoreInstrument();
        scorePart.getScoreInstrument()
                 .add(scoreInstrument);
        scoreInstrument.setId(data.id);
        scoreInstrument.setInstrumentName(data.name);

        MidiInstrument midiInstrument = factory.createMidiInstrument();
        scorePart.getMidiInstrument()
                 .add(midiInstrument);
        midiInstrument.setId(scoreInstrument);
        midiInstrument.setMidiChannel(data.channel);
        midiInstrument.setMidiProgram(data.program);
    }

    //---------------//
    // feedScorepart //
    //---------------//
    private ScorePart feedScorepart (ScorePartwise scorePartwise,
                                     PartData      data)
    {
        // Scorepart in partList
        ScorePart scorePart = factory.createScorePart();
        PartList  partList = scorePartwise.getPartList();
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
        final int    channel;
        final int    program;

        //~ Constructors -------------------------------------------------------

        public InstData (String id,
                         String name,
                         int    channel,
                         int    program)
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
