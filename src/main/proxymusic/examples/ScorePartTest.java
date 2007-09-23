//----------------------------------------------------------------------------//
//                                                                            //
//                         S c o r e P a r t T e s t                          //
//                                                                            //
//  Copyright (C) Herve Bitteur 2000-2007. All rights reserved.               //
//  This software is released under the GNU General Public License.           //
//  Contact author at herve.bitteur@laposte.net to report bugs & suggestions. //
//----------------------------------------------------------------------------//
package proxymusic.examples;

import proxymusic.*;

import proxymusic.util.Marshalling;

import java.io.*;
import java.lang.String;

/**
 * DOCUMENT ME!
 *
 * @author Herv&eacute; Bitteur
 * @version $Id$
 */
public class ScorePartTest
{
    //~ Instance fields --------------------------------------------------------

    /** Name of the temporary XML file */
    private final String FILE_NAME = "ScorePartTest-" +
                                     Marshalling.getMusicXmlVersion() + ".xml";

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
    {
        System.out.println(
            "MusicXmlVersion=" + Marshalling.getMusicXmlVersion());

        ScorePartTest instance = new ScorePartTest();
        System.out.println("Calling testMarshal");
        instance.testMarshal();
        System.out.println("Calling testUnmarshal");
        instance.testUnmarshal();
    }

    //-------------//
    // testMarshal //
    //-------------//
    /**
     * Test the marshalling of a ScorePartwise instance
     */
    public void testMarshal ()
    {
        // Get a populated score partwise
        ScorePartwise scorePartwise = getScorePartwise();

        //  Finally, marshal the proxy
        try {
            File         xmlFile = new File(FILE_NAME);
            OutputStream os = new FileOutputStream(xmlFile);

            Marshalling.marshal(scorePartwise, os);
            System.out.println("Score exported to " + xmlFile);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
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
            dumpScorePartwise(scorePartwise);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //-------------------//
    // dumpScorePartwise //
    //-------------------//
    /**
     * A very simplistic dump of a ScorePartwise instance
     *
     * @param scr the instance to dump
     */
    private void dumpScorePartwise (ScorePartwise scr)
    {
        System.out.println("version=" + scr.getVersion());

        PartList partList = scr.getPartList();

        for (Object obj : partList.getPartGroupOrScorePart()) {
            if (obj instanceof ScorePart) {
                ScorePart scorePart = (ScorePart) obj;
                System.out.println("scorePart.id=" + scorePart.getId());
                System.out.println(
                    "scorePart.partname=" +
                    scorePart.getPartName().getContent());

                for (ScoreInstrument scoreInstrument : scorePart.getScoreInstrument()) {
                    System.out.println(
                        "scoreInstrument.id=" + scoreInstrument.getId());
                    System.out.println(
                        "scoreInstrument.name=" +
                        scoreInstrument.getInstrumentName().getContent());
                }

                for (MidiInstrument midiInstrument : scorePart.getMidiInstrument()) {
                    System.out.println(
                        "midiInstrument.id=" + midiInstrument.getId() + " [" +
                        ((ScoreInstrument) midiInstrument.getId()).getId() +
                        "]");
                    System.out.println(
                        "midiInstrument.channel=" +
                        midiInstrument.getMidiChannel().getContent());
                    System.out.println(
                        "midiInstrument.program=" +
                        midiInstrument.getMidiProgram().getContent());
                }
            }
        }

        for (Part part : scr.getPart()) {
            System.out.println("part:" + ((ScorePart) part.getId()).getId());
        }
    }

    //----------------//
    // feedInstrument //
    //----------------//
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
    private void feedInstrument (ScorePart scorePart,
                                 String    iId,
                                 String    iName,
                                 int       channel,
                                 int       program)
    {
        ScoreInstrument scoreInstrument = new ScoreInstrument();
        scorePart.getScoreInstrument()
                 .add(scoreInstrument);
        scoreInstrument.setId(iId);

        InstrumentName instrumentName = new InstrumentName();
        scoreInstrument.setInstrumentName(instrumentName);
        instrumentName.setContent(iName);

        MidiInstrument midiInstrument = new MidiInstrument();
        scorePart.getMidiInstrument()
                 .add(midiInstrument);
        midiInstrument.setId(scoreInstrument);

        MidiChannel midiChannel = new MidiChannel();
        midiInstrument.setMidiChannel(midiChannel);
        midiChannel.setContent("" + channel);

        MidiProgram midiProgram = new MidiProgram();
        midiProgram.setContent("" + program);
        midiInstrument.setMidiProgram(midiProgram);
    }

    //---------------//
    // feedScorepart //
    //---------------//
    private ScorePart feedScorepart (ScorePartwise scorePartwise,
                                     PartList      partList,
                                     String        id,
                                     String        name)
    {
        // Scorepart in partList
        ScorePart scorePart = new ScorePart();
        partList.getPartGroupOrScorePart()
                .add(scorePart);
        scorePart.setId(id);

        PartName partName = new PartName();
        scorePart.setPartName(partName);
        partName.setContent(name);
        partName.setPrintObject("no");

        // ScorePart in scorePartwise
        Part part = new Part();
        scorePartwise.getPart()
                     .add(part);
        part.setId(scorePart);

        return scorePart;
    }

    //------------------//
    // getScorePartwise //
    //------------------//
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
    private ScorePartwise getScorePartwise ()
    {
        // Allocate the score partwise
        ScorePartwise scorePartwise = new ScorePartwise();

        // No Version, we leave this to ProxyMusic

        // PartList
        PartList partList = new PartList();
        scorePartwise.setPartList(partList);

        feedInstrument(
            feedScorepart(scorePartwise, partList, "P1", "Voice"),
            "P1-I3",
            "Voice",
            1,
            55);
        feedInstrument(
            feedScorepart(scorePartwise, partList, "P2", "Guitar"),
            "P2-I2",
            "Acoustic Guitar (steel)",
            2,
            26);

        return scorePartwise;
    }
}
