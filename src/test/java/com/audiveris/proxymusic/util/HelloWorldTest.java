//----------------------------------------------------------------------------//
//                                                                            //
//                        H e l l o W o r l d T e s t                         //
//                                                                            //
//  Copyright © Hervé Bitteur and others 2000-2014. All rights reserved.      //
//  This software is released under the GNU Lesser General Public License.    //
//  Please see http://kenai.com/projects/proxymusic/ for bugs & suggestions.  //
//----------------------------------------------------------------------------//
//
package com.audiveris.proxymusic.util;

import com.audiveris.proxymusic.*;
import com.audiveris.proxymusic.ScorePartwise.Part;
import com.audiveris.proxymusic.ScorePartwise.Part.Measure;
import static com.audiveris.proxymusic.util.Marshalling.getContext;

import junit.framework.TestCase;

import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.String; // Do not remove this line
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;

/**
 * Class {@code HelloWorldTest} mimics the usual "HelloWorld" as
 * found in the MusicXML tutorial, by marshalling and unmarshalling a
 * hierarchy of Java objects rooted at a ScorePartwise instance to and
 * from a proper XML file.
 * It does so by using the Marshalling utility class.
 *
 * This class version is meant to test MusicXML 3.0
 *
 * @author Hervé Bitteur
 */
public class HelloWorldTest
        extends TestCase
{
    //~ Static fields/initializers -----------------------------------------------------------------

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldTest.class);

    private static final String versionData = ProgramId.VERSION;

    private static final AttrData attrData = new AttrData(
            new BigDecimal(1),
            new BigInteger("0"),
            "4",
            "4",
            ClefSign.G,
            new BigInteger("2"));

    private static final NoteData[] noteData = new NoteData[]{
        // 0
        new NoteData(Step.C, 4, new BigDecimal(4), "whole"),
        // 1
        new NoteData(Step.E, 4, new BigDecimal(4), "whole"),
        // 2
        new NoteData(Step.G, 4, new BigDecimal(4), "whole")
    };

    private static final MeasData[] measData = new MeasData[]{
        new MeasData(
        "1",
        Arrays.asList(attrData, noteData[0], noteData[1], noteData[2]))
    };

    private static final PartData[] partData = new PartData[]{
        new PartData(
        "P1",
        "Music",
        Arrays.asList(measData))
    };

    private static final int partNb = partData.length;

    /** Temporary area. */
    private static final File TEMP_DIR = new File("target/temp");

    /** Name of the temporary XML file. */
    private static final String FILE_NAME = "hello-world-test.xml";

    //~ Methods ------------------------------------------------------------------------------------
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
        HelloWorldTest instance = new HelloWorldTest();
        instance.setUp();

        logger.info("Building jaxbContext...");

        long start = System.currentTimeMillis();
        Marshalling.getContext(ScorePartwise.class);
        logger.info("jaxbContext built in {} ms", System.currentTimeMillis() - start);

        try {
            instance.tryMarshal();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        start = System.currentTimeMillis();

        try {
            instance.tryUnmarshal();
            logger.info("Unmarshalling done in {} ms", System.currentTimeMillis() - start);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //-----------------//
    // testBothInOrder //
    //-----------------//
    @Test
    public void testBothInOrder ()
            throws Exception
    {
        logger.info("Calling testBothInOrder...");

        logger.info("Building ScorePartwise JAXB context");
        Marshalling.getContext(ScorePartwise.class);

        logger.info("Building Opus JAXB context");
        Marshalling.getContext(Opus.class);

        tryMarshal();

        tryUnmarshal();
    }

    //-------//
    // setUp //
    //-------//
    @Override
    protected void setUp ()
            throws Exception
    {
        logger.info(
                "HelloWorldtest. name:{} version:{} revision:{}",
                ProgramId.NAME,
                ProgramId.VERSION,
                ProgramId.REVISION);

        // Make sure the temp directory exists
        TEMP_DIR.mkdirs();
    }

    //-----------------//
    // checkAttributes //
    //-----------------//
    private void checkAttributes (Attributes attr,
                                  AttrData attrData)
    {
        assertNotNull(attr);
        logger.info(new Dumper.Column(attr).toString());

        assertEquals(attrData.divisions, attr.getDivisions());
        assertTrue(1 == attr.getKey().size());

        Key key = attr.getKey().get(0);
        logger.info(new Dumper.Column(key).toString());
        assertEquals(attrData.fifths, key.getFifths());

        assertTrue(1 == attr.getTime().size());

        Time time = attr.getTime().get(0);
        logger.info(new Dumper.Column(time).toString());

        ///for (JAXBElement<java.lang.String> elem : time.getBeatsAndBeatType()) {
        for (JAXBElement<java.lang.String> elem : time.getTimeSignature()) {
            logger.info(new Dumper.Column(elem).toString());

            java.lang.String name = elem.getName().getLocalPart();

            if (name.equals("beats")) {
                assertEquals(attrData.beats, elem.getValue());
            } else if (name.equals("beat-type")) {
                assertEquals(attrData.beatType, elem.getValue());
            } else {
                fail("Unexpected attribute " + "name=" + name + " value=" + elem.getValue());
            }
        }

        assertTrue(1 == attr.getClef().size());

        Clef clef = attr.getClef().get(0);
        logger.info(new Dumper.Column(clef).toString());
        assertEquals(attrData.clefSign, clef.getSign());
        assertEquals(attrData.clefLine, clef.getLine());
    }

    //--------------//
    // checkMeasure //
    //--------------//
    private void checkMeasure (Measure measure,
                               MeasData measData)
    {
        assertNotNull(measure);
        logger.info(new Dumper.Column(measure).toString());
        assertEquals(measData.number, measure.getNumber());

        assertTrue(measData.objects.size() == measure.getNoteOrBackupOrForward().size());

        Object obj = measure.getNoteOrBackupOrForward().get(0);
        checkAttributes((Attributes) obj, (AttrData) measData.objects.get(0));
        obj = measure.getNoteOrBackupOrForward().get(1);
        checkNote((Note) obj, (NoteData) measData.objects.get(1));
        obj = measure.getNoteOrBackupOrForward().get(2);
        checkNote((Note) obj, (NoteData) measData.objects.get(2));
        obj = measure.getNoteOrBackupOrForward().get(3);
        checkNote((Note) obj, (NoteData) measData.objects.get(3));
    }

    //-----------//
    // checkNote //
    //-----------//
    private void checkNote (Note note,
                            NoteData noteData)
    {
        assertNotNull(note);
        logger.info(new Dumper.Column(note).toString());

        Pitch pitch = note.getPitch();
        assertEquals(noteData.pitchStep, pitch.getStep());
        assertEquals(noteData.pitchOctave, pitch.getOctave());

        BigDecimal duration = note.getDuration();
        assertEquals(noteData.duration, duration);

        NoteType type = note.getType();
        assertEquals(noteData.type, type.getValue());
    }

    //-----------//
    // checkPart //
    //-----------//
    private void checkPart (Part part,
                            PartData partData)
    {
        Object id = part.getId();
        assertNotNull(id);
        logger.info(new Dumper.Column(id, "from checkPart", 0).toString());

        List<Measure> measures = part.getMeasure();
        assertTrue(partData.measures.size() == measures.size());

        for (int i = 0; i < partData.measures.size(); i++) {
            checkMeasure(measures.get(i), partData.measures.get(i));
        }
    }

    //---------------//
    // checkPartList //
    //---------------//
    private void checkPartList (PartList partList)
    {
        assertNotNull(partList);
        logger.info(new Dumper.Column(partList).toString());

        List<Object> objects = partList.getPartGroupOrScorePart();
        assertTrue(partNb == objects.size());

        for (int i = 0; i < partNb; i++) {
            checkScorePart((ScorePart) objects.get(i), partData[i]);
        }
    }

    //----------------//
    // checkScorePart //
    //----------------//
    private void checkScorePart (ScorePart scorePart,
                                 PartData partData)
    {
        assertNotNull(scorePart);
        logger.info(new Dumper.Column(scorePart, "from checkScorePart", 0).toString());

        assertEquals(partData.id, scorePart.getId());
        assertEquals(partData.name, scorePart.getPartName().getValue());
    }

    //--------------------//
    // checkScorePartwise //
    //--------------------//
    private void checkScorePartwise (ScorePartwise scr)
    {
        logger.info(new Dumper.Column(scr).toString());

        {
            // Work & Opus
            Work work = scr.getWork();
            assertNotNull(work);
            logger.info(new Dumper.Column(work, 1).toString());

            Opus opus = work.getOpus();
            assertNotNull(opus);
            logger.info(new Dumper.Column(opus, 2).toString());

            String href = opus.getHref();
            assertNotNull(href);

            String actuate = opus.getActuate();
            assertNotNull(actuate);
        }

        assertEquals(versionData, scr.getVersion());

        checkPartList(scr.getPartList());

        List<Part> parts = scr.getPart();
        assertTrue(partNb == parts.size());

        for (int i = 0; i < partNb; i++) {
            checkPart(parts.get(i), partData[i]);
        }
    }

    //------------------//
    // getScorePartwise //
    //------------------//
    /**
     * Build a ScorePartwise instance from scratch, using the similar information as
     * provided on MusicXML site through the HelloWorldTest example.
     *
     * @return the populated instance
     */
    private ScorePartwise getScorePartwise ()
    {
        // Generated factory for all proxymusic elements
        ObjectFactory factory = new ObjectFactory();

        // Allocate the score partwise
        ScorePartwise scorePartwise = factory.createScorePartwise();

        {
            // Work
            Work work = factory.createWork();
            scorePartwise.setWork(work);
            work.setWorkTitle("Title for the work");
            work.setWorkNumber("Number for the work");

            // Work::Opus
            Opus opus = factory.createOpus();
            work.setOpus(opus);
            opus.setHref("Href to opus");
            opus.setType("simple");
            opus.setRole("Role of opus"); // Some text
            opus.setTitle("Title of opus"); // Some text
            opus.setShow("new"); // new, replace, embed, other, none
            opus.setActuate("onLoad"); // onRequest, onLoad, other, none
        }

        // PartList
        PartList partList = factory.createPartList();
        scorePartwise.setPartList(partList);

        // Scorepart in partList
        ScorePart scorePart = factory.createScorePart();
        partList.getPartGroupOrScorePart().add(scorePart);
        scorePart.setId("P1");

        PartName partName = factory.createPartName();
        scorePart.setPartName(partName);
        partName.setValue("Music");

        // ScorePart in scorePartwise
        ScorePartwise.Part part = factory.createScorePartwisePart();
        scorePartwise.getPart().add(part);
        part.setId(scorePart);

        // Measure
        Measure measure = factory.createScorePartwisePartMeasure();
        part.getMeasure().add(measure);
        measure.setNumber("1");

        // Attributes
        Attributes attributes = factory.createAttributes();
        measure.getNoteOrBackupOrForward().add(attributes);

        // Divisions
        attributes.setDivisions(new BigDecimal(1));

        // Key
        Key key = factory.createKey();
        attributes.getKey().add(key);
        key.setFifths(new BigInteger("0"));

        // Time
        Time time = factory.createTime();
        attributes.getTime().add(time);
        time.getTimeSignature().add(factory.createTimeBeats("4"));
        time.getTimeSignature().add(factory.createTimeBeatType("4"));

        // Clef
        Clef clef = factory.createClef();
        attributes.getClef().add(clef);
        clef.setSign(ClefSign.G);
        clef.setLine(new BigInteger("2"));

        // Note 0 ---
        Note note = factory.createNote();
        measure.getNoteOrBackupOrForward().add(note);

        // Pitch
        Pitch pitch = factory.createPitch();
        note.setPitch(pitch);
        pitch.setStep(Step.C);
        pitch.setOctave(4);

        // Duration
        note.setDuration(new BigDecimal(4));

        // Type
        NoteType type = factory.createNoteType();
        type.setValue("whole");
        note.setType(type);

        // Note 1 ---
        note = factory.createNote();
        measure.getNoteOrBackupOrForward().add(note);
        note.setChord(new Empty());

        // Pitch
        pitch = factory.createPitch();
        note.setPitch(pitch);
        pitch.setStep(Step.E);
        pitch.setOctave(4);

        // Duration
        note.setDuration(new BigDecimal(4));

        // Type
        type = factory.createNoteType();
        type.setValue("whole");
        note.setType(type);

        // Note 2 ---
        note = factory.createNote();
        measure.getNoteOrBackupOrForward().add(note);
        note.setChord(new Empty());

        // Pitch
        pitch = factory.createPitch();
        note.setPitch(pitch);
        pitch.setStep(Step.G);
        pitch.setOctave(4);

        // Duration
        note.setDuration(new BigDecimal(4));

        // Type
        type = factory.createNoteType();
        type.setValue("whole");
        note.setType(type);

        return scorePartwise;
    }

    //------------//
    // tryMarshal //
    //------------//
    /**
     * Test the marshaling of a ScorePartwise instance
     */
    private void tryMarshal ()
            throws Exception
    {
        logger.info("Calling tryMarshal...");

        // Get a populated score partwise
        ScorePartwise scorePartwise = getScorePartwise();

        //  Finally, marshal the proxy
        File xmlFile = new File(TEMP_DIR, FILE_NAME);
        OutputStream os = new FileOutputStream(xmlFile);
        long start = System.currentTimeMillis();

        Marshalling.marshal(scorePartwise, os, true, 2);

        logger.info("Marshalling done in {} ms", System.currentTimeMillis() - start);
        logger.info("Score exported to {}", xmlFile);
        os.close();
    }

    //--------------//
    // tryUnmarshal //
    //--------------//
    /**
     * Test the un-marshaling of a ScorePartwise instance from the XML file
     * written by the tryMarshal() method.
     */
    private void tryUnmarshal ()
            throws Exception
    {
        logger.info("Calling tryUnmarshal...");

        //  Unmarshal the proxy
        File xmlFile = new File(TEMP_DIR, FILE_NAME);
        InputStream is = new FileInputStream(xmlFile);
        long start = System.currentTimeMillis();

        ScorePartwise scorePartwise = (ScorePartwise) Marshalling.unmarshal(is);

        logger.info("Unmarshalling done in {} ms", System.currentTimeMillis() - start);
        logger.info("Score imported from {}", xmlFile);
        is.close();

        // Basic check of the java objects
        checkScorePartwise(scorePartwise);

        // Display what we have got
        System.out.println();
        System.out.println("Raw output of un-marshalled data:");
        System.out.println("---------------------------------");

        Marshaller marshaller = getContext(ScorePartwise.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(scorePartwise, System.out);

        System.out.println();
        System.out.println("My marshalling of un-marshalled data:");
        System.out.println("-------------------------------------");
        Marshalling.marshal(scorePartwise, System.out, false, 2);
        System.out.println();
        System.out.println();
    }

    //~ Inner Classes ------------------------------------------------------------------------------
    private static class AttrData
    {
        //~ Instance fields ------------------------------------------------------------------------

        final BigDecimal divisions;

        final BigInteger fifths;

        final String beats;

        final String beatType;

        final ClefSign clefSign;

        final BigInteger clefLine;

        //~ Constructors ---------------------------------------------------------------------------
        public AttrData (BigDecimal divisions,
                         BigInteger fifths,
                         String beats,
                         String beatType,
                         ClefSign clefSign,
                         BigInteger clefLine)
        {
            this.divisions = divisions;
            this.fifths = fifths;
            this.beats = beats;
            this.beatType = beatType;
            this.clefSign = clefSign;
            this.clefLine = clefLine;
        }
    }

    private static class MeasData
    {
        //~ Instance fields ------------------------------------------------------------------------

        final String number;

        final List<Object> objects;

        //~ Constructors ---------------------------------------------------------------------------
        public MeasData (String number,
                         List<Object> objects)
        {
            this.number = number;
            this.objects = objects;
        }
    }

    private static class NoteData
    {
        //~ Instance fields ------------------------------------------------------------------------

        final Step pitchStep;

        final int pitchOctave;

        final BigDecimal duration;

        final String type;

        //~ Constructors ---------------------------------------------------------------------------
        public NoteData (Step pitchStep,
                         int pitchOctave,
                         BigDecimal duration,
                         String type)
        {
            this.pitchStep = pitchStep;
            this.pitchOctave = pitchOctave;
            this.duration = duration;
            this.type = type;
        }
    }

    private static class PartData
    {
        //~ Instance fields ------------------------------------------------------------------------

        final String id;

        final String name;

        final List<MeasData> measures;

        //~ Constructors ---------------------------------------------------------------------------
        public PartData (String id,
                         String name,
                         List<MeasData> measures)
        {
            this.id = id;
            this.name = name;
            this.measures = measures;
        }
    }
}
