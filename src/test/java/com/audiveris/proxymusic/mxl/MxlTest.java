//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                                          M x l T e s t                                         //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//  Copyright © Herve Bitteur and others 2000-2014. All rights reserved.
//  This software is released under the GNU General Public License.
//  Goto http://kenai.com/projects/audiveris to report bugs or suggestions.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package com.audiveris.proxymusic.mxl;

import com.audiveris.proxymusic.Attributes;
import com.audiveris.proxymusic.Clef;
import com.audiveris.proxymusic.ClefSign;
import com.audiveris.proxymusic.Identification;
import com.audiveris.proxymusic.Key;
import com.audiveris.proxymusic.Note;
import com.audiveris.proxymusic.NoteType;
import com.audiveris.proxymusic.ObjectFactory;
import com.audiveris.proxymusic.PartList;
import com.audiveris.proxymusic.PartName;
import com.audiveris.proxymusic.Pitch;
import com.audiveris.proxymusic.ScorePart;
import com.audiveris.proxymusic.ScorePartwise;
import com.audiveris.proxymusic.Step;
import com.audiveris.proxymusic.Time;
import com.audiveris.proxymusic.TypedText;
import com.audiveris.proxymusic.opus.Opus;
import com.audiveris.proxymusic.util.Dumper;
import com.audiveris.proxymusic.util.Marshalling;

import junit.framework.TestCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.zip.ZipEntry;

import javax.xml.bind.JAXBException;
import org.junit.Test;

/**
 * Class {@code MxlTest} is meant to test features related to mxl (compressed)
 * MusicXML files.
 *
 * @author Hervé Bitteur
 */
public class MxlTest
        extends TestCase
{

    private static final String sourcePath = "mysource.png";
    //~ Methods ------------------------------------------------------------------------------------

    public static void main (String... args)
            throws JAXBException, FileNotFoundException, IOException, Mxl.MxlException,
                   Marshalling.MarshallingException,
                   Marshalling.UnmarshallingException
    {
        new MxlTest().play(args[0]);
    }

    public void play (String fileName)
            throws JAXBException, FileNotFoundException, IOException, Mxl.MxlException,
                   Marshalling.MarshallingException,
                   Marshalling.UnmarshallingException
    {

        System.out.println("Building contexts ...");
        Marshalling.getContext(ScorePartwise.class);
        Marshalling.getContext(Opus.class);

        System.out.println("Marshalling ...");
        Mxl.Output mof = new Mxl.Output(new File(fileName));
        OutputStream zos = mof.getOutputStream();
        ScorePartwise scorePartwise = getScorePartwise();
        System.out.println(new Dumper.Column(scorePartwise).toString());
        mof.addEntry(new RootFile("myscore.xml", RootFile.MUSICXML_MEDIA_TYPE));
        Marshalling.marshal(scorePartwise, zos, true, 2);
        mof.addEntry(new RootFile("myscore2.mxl", RootFile.COMPRESSED_MUSICXML_MEDIA_TYPE));
        Marshalling.marshal(scorePartwise, zos, true, 2); // Wrong! but this is just for test
        mof.close();
        System.out.println("Marshalled.");

        System.out.println("Unmarshalling ...");
        Mxl.Input mif = new Mxl.Input(new File(fileName));

        for (RootFile rootFile : mif.getRootFiles()) {
            System.out.println("   " + rootFile);
            ZipEntry zipEntry = mif.getEntry(rootFile.fullPath);
            System.out.println("   entryTime: " + new Date(zipEntry.getTime()));
        }

        RootFile first = mif.getRootFiles().get(0);
        ZipEntry zipEntry = mif.getEntry(first.fullPath);
        InputStream is = mif.getInputStream(zipEntry);
        ScorePartwise newScorePartwise = Marshalling.unmarshal(is);
        System.out.println(new Dumper.Column(newScorePartwise).toString());
        System.out.println(new Dumper.Column(newScorePartwise.getIdentification()).toString());
        System.out.println("Unmarshalled.");
    }

    @Test
    public void test ()
            throws JAXBException, FileNotFoundException, IOException, Mxl.MxlException,
                   Marshalling.MarshallingException,
                   Marshalling.UnmarshallingException
    {
        File dir = new File("target/temp");
        dir.mkdirs();
        play(new File(dir, "myfile.mxl").toString());
    }

    //------------------//
    // getScorePartwise //
    //------------------//
    /**
     * Build a ScorePartwise instance from scratch.
     *
     * @return the populated instance
     */
    private ScorePartwise getScorePartwise ()
    {
        // Generated factory for all proxymusic elements
        ObjectFactory factory = new ObjectFactory();

        // Allocate the score partwise
        ScorePartwise scorePartwise = factory.createScorePartwise();

        // Movement
        scorePartwise.setMovementTitle("This is the movement title");

        // Identification
        Identification identification = factory.createIdentification();
        scorePartwise.setIdentification(identification);

        // Source
        identification.setSource(sourcePath);
        TypedText typedText = factory.createTypedText();
        typedText.setValue("The Composer");
        typedText.setType("composer");
        identification.getCreator().add(typedText);

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
        ScorePartwise.Part.Measure measure = factory.createScorePartwisePartMeasure();
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

        // Note
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

        return scorePartwise;
    }
}
