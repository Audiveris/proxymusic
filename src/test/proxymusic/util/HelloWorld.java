//----------------------------------------------------------------------------//
//                                                                            //
//                            H e l l o W o r l d                             //
//                                                                            //
//  Copyright (C) Herve Bitteur 2000-2010. All rights reserved.               //
//  This software is released under the GNU Lesser General Public License.    //
//  Please contact users@proxymusic.dev.java.net to report bugs & suggestions //
//----------------------------------------------------------------------------//
//
package proxymusic.util;

import junit.framework.TestCase;

import proxymusic.*;

import proxymusic.ScorePartwise.Part;
import proxymusic.ScorePartwise.Part.Measure;

import java.io.*;
import java.lang.String;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBElement;

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
public class HelloWorld
    extends TestCase
{
    //~ Static fields/initializers ---------------------------------------------

    private static final String     versionData = "2.0";
    private static final AttrData   attrData = new AttrData(
        new BigDecimal(1),
        new BigInteger("0"),
        "4",
        "4",
        ClefSign.G,
        new BigInteger("2"));
    private static final NoteData   noteData = new NoteData(
        Step.C,
        4,
        new BigDecimal(4),
        "whole");
    private static final MeasData[] measData = new MeasData[] {
                                                   new MeasData(
        "1",
        Arrays.asList(attrData, noteData))
                                               };
    private static final PartData[] partData = new PartData[] {
                                                   new PartData(
        "P1",
        "Music",
        Arrays.asList(measData))
                                               };
    private static final int        partNb = partData.length;

    //~ Instance fields --------------------------------------------------------

    /** Name of the temporary XML file */
    private final String FILE_NAME = "HelloWorld.xml";

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
        HelloWorld instance = new HelloWorld();
        instance.setUp();

        System.out.println("Building jaxbContext...");

        long start = System.currentTimeMillis();
        Marshalling.getContext();
        System.out.println(
            "jaxbContext built in " + (System.currentTimeMillis() - start) +
            " ms");

        try {
            instance.testMarshal();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        start = System.currentTimeMillis();

        try {
            instance.testUnmarshal();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //-------------//
    // testMarshal //
    //-------------//
    /**
     * Test the marshalling of a ScorePartwise instance
     */
    public void testMarshal ()
        throws Exception
    {
        System.out.println("Calling testMarshal...");

        // Get a populated score partwise
        ScorePartwise scorePartwise = getScorePartwise();

        //  Finally, marshal the proxy
        File         xmlFile = new File(FILE_NAME);
        OutputStream os = new FileOutputStream(xmlFile);
        long         start = System.currentTimeMillis();

        Marshalling.marshal(scorePartwise, os);

        System.out.println(
            "Marshalling done in " + (System.currentTimeMillis() - start) +
            " ms");
        System.out.println("Score exported to " + xmlFile);
        os.close();
    }

    //---------------//
    // testUnmarshal //
    //---------------//
    /**
     * Test the unmarshalling of a ScorePartwise instance from the XML file
     * written by the testmarshal() method.
     */
    public void testUnmarshal ()
        throws Exception
    {
        System.out.println("Calling testUnmarshal...");

        //  Unmarshal the proxy
        File          xmlFile = new File(FILE_NAME);
        InputStream   is = new FileInputStream(xmlFile);
        long          start = System.currentTimeMillis();

        ScorePartwise scorePartwise = Marshalling.unmarshal(is);

        System.out.println(
            "Unmarshalling done in " + (System.currentTimeMillis() - start) +
            " ms");
        System.out.println("Score imported from " + xmlFile);
        is.close();

        // Basic check of the java objects
        checkScorePartwise(scorePartwise);
    }

    //-------//
    // setUp //
    //-------//
    @Override
    protected void setUp ()
        throws Exception
    {
        System.out.println(
            "HelloWorld. " + " specificationTitle:" +
            Marshalling.specificationTitle + " specificationVersion:" +
            Marshalling.specificationVersion + " implementationVersion:" +
            Marshalling.implementationVersion);
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
        // Generated factory for all proxymusic elements
        ObjectFactory factory = new ObjectFactory();

        // Allocate the score partwise
        ScorePartwise scorePartwise = factory.createScorePartwise();

        // No Version, we leave this to ProxyMusic
        ///scorePartwise.setVersion("1.1");

        // PartList
        PartList partList = factory.createPartList();
        scorePartwise.setPartList(partList);

        // Scorepart in partList
        ScorePart scorePart = factory.createScorePart();
        partList.getPartGroupOrScorePart()
                .add(scorePart);
        scorePart.setId("P1");

        PartName partName = factory.createPartName();
        scorePart.setPartName(partName);
        partName.setValue("Music");

        // ScorePart in scorePartwise
        ScorePartwise.Part part = factory.createScorePartwisePart();
        scorePartwise.getPart()
                     .add(part);
        part.setId(scorePart);

        // Measure
        Measure measure = factory.createScorePartwisePartMeasure();
        part.getMeasure()
            .add(measure);
        measure.setNumber("1");

        // Attributes
        Attributes attributes = factory.createAttributes();
        measure.getNoteOrBackupOrForward()
               .add(attributes);

        // Divisions
        attributes.setDivisions(new BigDecimal(1));

        // Key
        Key key = factory.createKey();
        attributes.getKey()
                  .add(key);
        key.setFifths(new BigInteger("0"));

        // Time
        Time time = factory.createTime();
        attributes.getTime()
                  .add(time);
        time.getBeatsAndBeatType()
            .add(factory.createTimeBeats("4"));
        time.getBeatsAndBeatType()
            .add(factory.createTimeBeatType("4"));

        // Clef
        Clef clef = factory.createClef();
        attributes.getClef()
                  .add(clef);
        clef.setSign(ClefSign.G);
        clef.setLine(new BigInteger("2"));

        // Note
        Note note = factory.createNote();
        measure.getNoteOrBackupOrForward()
               .add(note);

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

        return scorePartwise;
    }

    //-----------------//
    // checkAttributes //
    //-----------------//
    private void checkAttributes (Attributes attr,
                                  AttrData   attrData)
    {
        assertNotNull(attr);
        Dumper.dump(attr);

        assertEquals(attrData.divisions, attr.getDivisions());
        assertTrue(1 == attr.getKey().size());

        Key key = attr.getKey()
                      .get(0);
        Dumper.dump(key);
        assertEquals(attrData.fifths, key.getFifths());

        assertTrue(1 == attr.getTime().size());

        Time time = attr.getTime()
                        .get(0);
        Dumper.dump(time);

        for (JAXBElement<java.lang.String> elem : time.getBeatsAndBeatType()) {
            Dumper.dump(elem);

            java.lang.String name = elem.getName()
                                        .getLocalPart();

            if (name.equals("beats")) {
                assertEquals(attrData.beats, elem.getValue());
            } else if (name.equals("beat-type")) {
                assertEquals(attrData.beatType, elem.getValue());
            } else {
                fail(
                    "Unexpected attribute " + "name=" + name + " value=" +
                    elem.getValue());
            }
        }

        assertTrue(1 == attr.getClef().size());

        Clef clef = attr.getClef()
                        .get(0);
        Dumper.dump(clef);
        assertEquals(attrData.clefSign, clef.getSign());
        assertEquals(attrData.clefLine, clef.getLine());
    }

    //--------------//
    // checkMeasure //
    //--------------//
    private void checkMeasure (Measure  measure,
                               MeasData measData)
    {
        assertNotNull(measure);
        Dumper.dump(measure);
        assertEquals(measData.number, measure.getNumber());

        assertTrue(
            measData.objects.size() == measure.getNoteOrBackupOrForward().size());

        for (int i = 0; i < measData.objects.size(); i++) {
            Object obj = measure.getNoteOrBackupOrForward()
                                .get(i);

            if (obj instanceof Attributes) {
                checkAttributes(
                    (Attributes) obj,
                    (AttrData) measData.objects.get(i));
            } else if (obj instanceof Note) {
                checkNote((Note) obj, (NoteData) measData.objects.get(i));
            }
        }
    }

    //-----------//
    // checkNote //
    //-----------//
    private void checkNote (Note     note,
                            NoteData noteData)
    {
        assertNotNull(note);
        Dumper.dump(note);

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
    private void checkPart (Part     part,
                            PartData partData)
    {
        Object id = part.getId();
        assertNotNull(id);
        Dumper.dump(id, "from checkPart");

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
        Dumper.dump(partList);

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
                                 PartData  partData)
    {
        assertNotNull(scorePart);
        Dumper.dump(scorePart, "from checkScorePart");

        assertEquals(partData.id, scorePart.getId());
        assertEquals(partData.name, scorePart.getPartName().getValue());
    }

    //--------------------//
    // checkScorePartwise //
    //--------------------//
    private void checkScorePartwise (ScorePartwise scr)
    {
        Dumper.dump(scr);

        if (Marshalling.specificationVersion != null) {
            assertEquals(versionData, scr.getVersion());
        }

        checkPartList(scr.getPartList());

        List<Part> parts = scr.getPart();
        assertTrue(partNb == parts.size());

        for (int i = 0; i < partNb; i++) {
            checkPart(parts.get(i), partData[i]);
        }
    }

    //~ Inner Classes ----------------------------------------------------------

    /**
       <score-partwise xmlns:ns2="http://www.w3.org/1999/xlink" version="2.0">
       <identification>
           <encoding>
               <software>ProxyMusic MusicXML-2.0 JAXB-2.0 d</software>
               <encoding-date>2008-11-14T18:13:47.500+01:00</encoding-date>
           </encoding>
       </identification>
       <part-list>
           <score-part id="P1">
               <part-name>Music</part-name>
           </score-part>
       </part-list>
       <part id="P1">
           <measure number="1">
               <attributes>
                   <divisions>1</divisions>
                   <key>
                       <fifths>0</fifths>
                   </key>
                   <time>
                       <beats>4</beats>
                       <beat-type>4</beat-type>
                   </time>
                   <clef>
                       <sign>G</sign>
                       <line>2</line>
                   </clef>
               </attributes>
               <note>
                   <pitch>
                       <step>C</step>
                       <octave>4</octave>
                   </pitch>
                   <duration>4</duration>
                   <type>whole</type>
               </note>
           </measure>
       </part>
       </score-partwise>
     */
    private static class AttrData
    {
        //~ Instance fields ----------------------------------------------------

        final BigDecimal divisions;
        final BigInteger fifths;
        final String     beats;
        final String     beatType;
        final ClefSign   clefSign;
        final BigInteger clefLine;

        //~ Constructors -------------------------------------------------------

        public AttrData (BigDecimal divisions,
                         BigInteger fifths,
                         String     beats,
                         String     beatType,
                         ClefSign   clefSign,
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
        //~ Instance fields ----------------------------------------------------

        final String       number;
        final List<Object> objects;

        //~ Constructors -------------------------------------------------------

        public MeasData (String       number,
                         List<Object> objects)
        {
            this.number = number;
            this.objects = objects;
        }
    }

    private static class NoteData
    {
        //~ Instance fields ----------------------------------------------------

        final Step       pitchStep;
        final int        pitchOctave;
        final BigDecimal duration;
        final String     type;

        //~ Constructors -------------------------------------------------------

        public NoteData (Step       pitchStep,
                         int        pitchOctave,
                         BigDecimal duration,
                         String     type)
        {
            this.pitchStep = pitchStep;
            this.pitchOctave = pitchOctave;
            this.duration = duration;
            this.type = type;
        }
    }

    private static class PartData
    {
        //~ Instance fields ----------------------------------------------------

        final String         id;
        final String         name;
        final List<MeasData> measures;

        //~ Constructors -------------------------------------------------------

        public PartData (String         id,
                         String         name,
                         List<MeasData> measures)
        {
            this.id = id;
            this.name = name;
            this.measures = measures;
        }
    }
}
