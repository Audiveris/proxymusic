//----------------------------------------------------------------------------//
//                                                                            //
//                         H e l l o W o r l d _ 2 _ 0                        //
//                                                                            //
//  Copyright (C) Herve Bitteur 2000-2007. All rights reserved.               //
//  This software is released under the GNU General Public License.           //
//  Contact the author at herve.bitteur@laposte.net for bugs & suggestions.   //
//----------------------------------------------------------------------------//
package proxymusic.examples;

import proxymusic.*;

import proxymusic.util.Marshalling;

import java.io.*;
import java.lang.String;

/**
 * Class <code>HelloWorld</code> mimics the usual "HelloWorld" as found in the
 * MusicXML tutorial, by marshalling and unmarshalling a hierarchy of Java
 * objects rooted at a ScorePartwise instance to and from a proper XML file.
 * It does so by using the Marshalling utility class.
 *
 * This class version is meant to test MusicXML 2.0
 *
 * @author Herv&eacute Bitteur
 * @version $Id$
 */
public class HelloWorld_2_0
{
    //~ Instance fields --------------------------------------------------------

    /** Name of the temporary XML file */
    private final String FILE_NAME = "HelloWorld-" +
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

        HelloWorld_2_0 instance = new HelloWorld_2_0();
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

        PartList  partList = scr.getPartList();
        
        for (Object obj : partList.getPartGroupOrScorePart()) {
            if (obj instanceof ScorePart) {
                ScorePart scorePart = (ScorePart) obj;
                System.out.println("scorePart.id=" + scorePart.getId());
                System.out.println(
                    "scorePart.partname=" +
                    scorePart.getPartName().getContent());
            }
        }

        for (Part part : scr.getPart()) {
            System.out.println("part:" + ((ScorePart)part.getId()).getId());

            for (Measure measure : part.getMeasure()) {
                System.out.println("measure.number=" + measure.getNumber());

                for (Object obj : measure.getNoteOrBackupOrForward()) {
                    if (obj instanceof Attributes) {
                        Attributes attr = (Attributes) obj;
                        System.out.println(
                            "attributes.divisions=" +
                            attr.getDivisions().getContent());
                        System.out.println(
                            "attributes.key.fifths=" +
                            attr.getKey().get(0).getFifths().getContent());

                        for (Object o : attr.getTime().get(0)
                                            .getBeatsAndBeatType()) {
                            if (o instanceof Beats) {
                                Beats beats = (Beats) o;
                                System.out.println(
                                    "attributes.time.beats=" +
                                    beats.getContent());
                            } else if (o instanceof BeatType) {
                                BeatType beatType = (BeatType) o;
                                System.out.println(
                                    "attributes.time.beatType=" +
                                    beatType.getContent());
                            }
                        }

                        for (Clef clef : attr.getClef()) {
                            System.out.println(
                                "attributes.clef.sign=" +
                                clef.getSign().getContent());
                            System.out.println(
                                "attributes.clef.line=" +
                                clef.getLine().getContent());
                        }
                    } else if (obj instanceof Note) {
                        Note note = (Note) obj;
                        System.out.println(
                            "note.pitch.step=" +
                            note.getPitch().getStep().getContent());
                        System.out.println(
                            "note.pitch.octave=" +
                            note.getPitch().getOctave().getContent());
                        System.out.println(
                            "note.duration=" + note.getDuration().getContent());
                        System.out.println(
                            "note.type=" + note.getType().getContent());
                    }
                }
            }
        }
    }

    //------------------//
    // getScorePartwise //
    //------------------//
    /**
     * Build a ScorePartwise instance from scratch, using the same musical
     * information as provided on MusicXML site through the HelloWorld example.
     *
     * @return the populated instance
     */
    private ScorePartwise getScorePartwise ()
    {
        // Allocate the score partwise
        ScorePartwise scorePartwise = new ScorePartwise();

        // No Version, we leave this to ProxyMusic
        ///scorePartwise.setVersion("1.1");

        // PartList
        PartList partList = new PartList();
        scorePartwise.setPartList(partList);

        // Scorepart in partList
        ScorePart scorePart = new ScorePart();
        partList.getPartGroupOrScorePart()
                .add(scorePart);
        scorePart.setId("P1");

        PartName partName = new PartName();
        scorePart.setPartName(partName);
        partName.setContent("Music");

        // ScorePart in scorePartwise
        Part part = new Part();
        scorePartwise.getPart()
                     .add(part);
        part.setId(scorePart);

        // Measure
        Measure measure = new Measure();
        part.getMeasure()
            .add(measure);
        measure.setNumber("1");

        // Attributes
        Attributes attributes = new Attributes();
        measure.getNoteOrBackupOrForward()
               .add(attributes);

        // Divisions
        Divisions divisions = new Divisions();
        attributes.setDivisions(divisions);
        divisions.setContent("1");

        // Key
        Key key = new Key();
        attributes.getKey().add(key);

        Fifths fifths = new Fifths();
        key.setFifths(fifths);
        fifths.setContent("0");

        // Time
        Time time = new Time();
        attributes.getTime().add(time);

        Beats beats = new Beats();
        time.getBeatsAndBeatType()
            .add(beats);
        beats.setContent("4");

        BeatType beatType = new BeatType();
        time.getBeatsAndBeatType()
            .add(beatType);
        beatType.setContent("4");

        // Clef
        Clef clef = new Clef();
        attributes.getClef()
                  .add(clef);

        Sign sign = new Sign();
        clef.setSign(sign);
        sign.setContent("G");

        Line line = new Line();
        clef.setLine(line);
        line.setContent("2");

        // Note
        Note note = new Note();
        measure.getNoteOrBackupOrForward()
               .add(note);

        // Pitch
        Pitch pitch = new Pitch();
        note.setPitch(pitch);

        Step step = new Step();
        pitch.setStep(step);
        step.setContent("C");

        Octave octave = new Octave();
        pitch.setOctave(octave);
        octave.setContent("4");

        // Duration
        Duration duration = new Duration();
        note.setDuration(duration);
        duration.setContent("4");

        // Type
        Type type = new Type();
        note.setType(type);
        type.setContent("whole");

        return scorePartwise;
    }
}
