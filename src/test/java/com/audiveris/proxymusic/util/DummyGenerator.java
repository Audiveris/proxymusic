//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                                   D u m m y G e n e r a t o r                                  //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//  Copyright © Herve Bitteur and others 2000-2014. All rights reserved.
//  This software is released under the GNU General Public License.
//  Goto http://kenai.com/projects/audiveris to report bugs or suggestions.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package com.audiveris.proxymusic.util;

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

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Class {@code DummyGenerator} is a utility class to generate a rather dummy
 * instance of ScorePartwise, just for test purpose.
 *
 * @author Hervé Bitteur
 */
public abstract class DummyGenerator
{
    //~ Methods ------------------------------------------------------------------------------------

    /**
     * Build a ScorePartwise instance with as many measures as desired.
     *
     * @param title        title for the movement
     * @param measureCount number of measures
     * @return the ScorePartwise instance
     */
    public static ScorePartwise buildScorePartwise (String title,
                                                    int measureCount)
    {
        // Generated factory for all proxymusic elements
        ObjectFactory factory = new ObjectFactory();

        // Allocate the score partwise
        ScorePartwise scorePartwise = factory.createScorePartwise();

        // Movement
        scorePartwise.setMovementTitle(title);

        // Identification
        Identification identification = factory.createIdentification();
        scorePartwise.setIdentification(identification);

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

        for (int count = 2; count <= measureCount; count++) {
            ScorePartwise.Part.Measure meas = factory.createScorePartwisePartMeasure();
            part.getMeasure().add(meas);
            meas.setNumber("" + count);

            // Note 1 ---
            note = factory.createNote();
            meas.getNoteOrBackupOrForward().add(note);

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
        }

        return scorePartwise;
    }
}
