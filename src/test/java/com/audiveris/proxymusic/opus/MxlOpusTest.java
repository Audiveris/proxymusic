//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                                      M x l O p u s T e s t                                     //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//  Copyright © Herve Bitteur and others 2000-2014. All rights reserved.
//  This software is released under the GNU General Public License.
//  Goto http://kenai.com/projects/audiveris to report bugs or suggestions.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package com.audiveris.proxymusic.opus;

import com.audiveris.proxymusic.ScorePartwise;
import com.audiveris.proxymusic.mxl.Mxl;
import com.audiveris.proxymusic.mxl.RootFile;
import com.audiveris.proxymusic.util.DummyGenerator;
import com.audiveris.proxymusic.util.Dumper;
import com.audiveris.proxymusic.util.Marshalling;

import junit.framework.TestCase;

import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;

/**
 * Class {@code MxlOpusTest} provides a realistic Opus example.
 * An Opus of scores (movements) is stored and then loaded again, all items being gathered in a
 * compressed (.mxl) file.
 *
 * @author Hervé Bitteur
 */
public class MxlOpusTest
        extends TestCase
{
    //~ Static fields/initializers -----------------------------------------------------------------

    private static final Logger logger = LoggerFactory.getLogger(MxlOpusTest.class);

    private static final File DIR = new File("target/temp");

    private static final String FILE_NAME = "my-opus.mxl";

    //~ Instance fields ----------------------------------------------------------------------------
    /** Global MXL input stream. */
    private Mxl.Input mi;

    //~ Methods ------------------------------------------------------------------------------------
    //------//
    // test //
    //------//
    /**
     * Single entry point for testing.
     *
     * @throws Exception
     */
    @Test
    public void test ()
            throws Exception
    {
        logger.info("Building contexts ...");
        Marshalling.getContext(ScorePartwise.class);
        Marshalling.getContext(Opus.class);

        logger.info("MxlOpusTest.test()");
        DIR.mkdirs();

        // Test in that order
        storing();
        reloading();
    }

    //-------------//
    // processOpus //
    //-------------//
    private void processOpus (Opus opus,
                              int level)
            throws Exception
    {
        logger.info("Processing opus '{}' at level {}", opus.getTitle(), level);

        for (Object item : opus.getOpusOrOpusLinkOrScore()) {
            logger.info("Opus item {}", new Dumper.Column(item, level));

            if (item instanceof Score) {
                Score score = (Score) item;
                String href = score.href;
                logger.info("Reading score at {}", href);
                assertNotNull(href);

                ZipEntry zipEntry = mi.getEntry(href);
                InputStream sis = mi.getInputStream(zipEntry);
                ScorePartwise scorePartwise = (ScorePartwise) Marshalling.unmarshal(sis);
                logger.info("Score {}", new Dumper.Column(scorePartwise, level));
            } else if (item instanceof OpusLink) {
                OpusLink link = (OpusLink) item;
                String href = link.href;
                logger.info("Reading linked opus at {}", href);
                assertNotNull(href);

                ZipEntry entry = mi.getEntry(href);
                InputStream lis = mi.getInputStream(entry);
                Opus linked = (Opus) Marshalling.unmarshal(lis);
                logger.info("Linked opus {}", new Dumper.Column(linked, level));
                processOpus(linked, level + 1);
            } else if (item instanceof Opus) {
                Opus nested = (Opus) item;
                logger.info("Opening nested opus {}", nested);
                processOpus(nested, level + 1);
            }
        }
    }

    //-----------//
    // reloading //
    //-----------//
    /**
     * Re-load the complex Opus from disk.
     *
     * @throws Exception
     */
    private void reloading ()
            throws Exception
    {
        logger.info("Beginning of reloading");

        File file = new File(DIR, FILE_NAME);
        mi = new Mxl.Input(file);

        // Un-marshal
        RootFile first = mi.getRootFiles().get(0);
        ZipEntry zipEntry = mi.getEntry(first.fullPath);
        InputStream is = mi.getInputStream(zipEntry);

        Object object = Marshalling.unmarshal(is);
        logger.info("Unmarshalled object {}", new Dumper.Column(object));

        if (object instanceof Opus) {
            processOpus((Opus) object, 1);
        } else if (object instanceof ScorePartwise) {
            ScorePartwise score = (ScorePartwise) object;
            logger.info("Score {}", new Dumper.Column(score, 1));
        } else {
            throw new RuntimeException("Unsupported " + object.getClass());
        }

        logger.info("End of reloading");
    }

    //---------//
    // storing //
    //---------//
    /**
     * Build a rather complex Opus and store the whole thing on disk.
     *
     * @throws Exception
     */
    private void storing ()
            throws Exception
    {
        logger.info("Beginning of storing");

        File file = new File(DIR, FILE_NAME);
        Mxl.Output mo = new Mxl.Output(new FileOutputStream(file));
        OutputStream zos = mo.getOutputStream();

        // Allocate the top opus
        ObjectFactory opusFactory = new ObjectFactory();
        Opus topOpus = opusFactory.createOpus();
        topOpus.setTitle("This is the top opus");
        topOpus.setVersion("3.0");

        {
            // score 1 within top opus
            final String entryName = "myfirstscore.xml";
            Score score = opusFactory.createScore();
            score.setHref(entryName);
            score.setTitle("The first score");
            score.setNewPage(YesNo.YES);
            topOpus.getOpusOrOpusLinkOrScore().add(score);

            ScorePartwise sp = DummyGenerator.buildScorePartwise("Score #1", 1);
            mo.addEntry(new RootFile(entryName, RootFile.MUSICXML_MEDIA_TYPE));
            Marshalling.marshal(sp, zos, true, 2);
        }

        {
            // score 2 within top opus
            final String entryName = "mysecondscore.xml";
            Score score = opusFactory.createScore();
            score.setHref(entryName);
            score.setTitle("The second score");
            score.setNewPage(YesNo.NO);
            topOpus.getOpusOrOpusLinkOrScore().add(score);

            ScorePartwise sp = DummyGenerator.buildScorePartwise("Score #2", 2);
            mo.addEntry(new RootFile(entryName, RootFile.MUSICXML_MEDIA_TYPE));
            Marshalling.marshal(sp, zos, true, 2);
        }

        {
            // linked opus
            final String entryName = "linked-opus.xml";
            OpusLink opusLink = opusFactory.createOpusLink();
            opusLink.setTitle("Link to another opus");
            opusLink.setHref(entryName);
            topOpus.getOpusOrOpusLinkOrScore().add(opusLink);

            Opus linkedOpus = opusFactory.createOpus();
            linkedOpus.setTitle("This is the linked opus");
            linkedOpus.setVersion("3.0");

            {
                // score 4 within linked opus
                final String theName = "myfourthscore.xml";
                Score score = opusFactory.createScore();
                score.setHref(theName);
                linkedOpus.getOpusOrOpusLinkOrScore().add(score);

                ScorePartwise sp = DummyGenerator.buildScorePartwise("Score #4", 4);
                mo.addEntry(new RootFile(theName, RootFile.MUSICXML_MEDIA_TYPE));
                Marshalling.marshal(sp, zos, true, 2);
            }

            mo.addEntry(new RootFile(entryName, RootFile.MUSICXML_MEDIA_TYPE));
            Marshalling.marshal(linkedOpus, zos);
        }

        {
            // nested opus within top opus
            Opus nestedOpus = opusFactory.createOpus();
            nestedOpus.setTitle("This is the nested opus");
            nestedOpus.setVersion("3.0");
            topOpus.getOpusOrOpusLinkOrScore().add(nestedOpus);

            {
                // score 3 within nested opus
                final String entryName = "mythirdscore.xml";
                Score score = opusFactory.createScore();
                score.setHref(entryName);
                score.setTitle("The third score");
                nestedOpus.getOpusOrOpusLinkOrScore().add(score);

                ScorePartwise sp = DummyGenerator.buildScorePartwise("Score #3", 3);
                mo.addEntry(new RootFile(entryName, RootFile.MUSICXML_MEDIA_TYPE));
                Marshalling.marshal(sp, zos, true, 2);
            }
        }

        // Marshal top opus (note use of addFirstEntry for a correct container)
        mo.addFirstEntry(new RootFile("my-opus.xml", RootFile.MUSICXML_MEDIA_TYPE));
        Marshalling.marshal(topOpus, zos);
        mo.close();
        logger.info("End of storing");
    }
}
