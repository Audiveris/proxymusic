//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                                         O p u s T e s t                                        //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//  Copyright © Herve Bitteur and others 2000-2014. All rights reserved.
//  This software is released under the GNU General Public License.
//  Goto http://kenai.com/projects/audiveris to report bugs or suggestions.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package com.audiveris.proxymusic.opus;

import com.audiveris.proxymusic.util.Dumper;
import com.audiveris.proxymusic.util.Marshalling;

import junit.framework.TestCase;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Class {@code OpusTest} is a small test that builds an Opus instance, marshal and
 * un-marshal it.
 * For a more complete example, see {@link MxlOpusTest}.
 *
 * @author Hervé Bitteur
 */
public class OpusTest
    extends TestCase
{
    //~ Methods ------------------------------------------------------------------------------------

    @Test
    public void test ()
        throws Exception
    {
        System.out.println("OpusTest.test()");

        File dir = new File("target/temp");
        dir.mkdirs();

        File          file = new File(dir, "my-opus.xml");
        OutputStream  os = new FileOutputStream(file);

        // Allocate the top opus
        ObjectFactory opusFactory = new ObjectFactory();
        Opus          topOpus = opusFactory.createOpus();
        topOpus.setTitle("This is the top opus");
        topOpus.setVersion("3.0");

        {
            // score 1 within opus
            final String entryName = "myfirstscore.xml";
            Score        score = opusFactory.createScore();
            score.setHref(entryName);
            score.setTitle("The first score");
            score.setNewPage(YesNo.YES);
            topOpus.getOpusOrOpusLinkOrScore().add(score);
        }

        {
            // score 2 within opus
            final String entryName = "mysecondscore.xml";
            Score        score = opusFactory.createScore();
            score.setHref(entryName);
            score.setTitle("The second score");
            score.setNewPage(YesNo.NO);
            topOpus.getOpusOrOpusLinkOrScore().add(score);
        }

        {
            // linked opus
            final String entryName = "linked-opus.xml";
            OpusLink     opusLink = opusFactory.createOpusLink();
            opusLink.setTitle("Link to another opus");
            opusLink.setHref(entryName);
            topOpus.getOpusOrOpusLinkOrScore().add(opusLink);
        }

        {
            // nested opus within top opus
            Opus nestedOpus = opusFactory.createOpus();
            nestedOpus.setTitle("This is the nested opus");
            nestedOpus.setVersion("3.0");
            topOpus.getOpusOrOpusLinkOrScore().add(nestedOpus);

            {
                // score 3 within nested opus
                Score score3 = opusFactory.createScore();
                score3.setHref("mythirdscore.xml");
                score3.setTitle("The third score");
                nestedOpus.getOpusOrOpusLinkOrScore().add(score3);
            }
        }

        // Marshal
        Marshalling.marshal(topOpus, os);
        os.close();

        // Un-marshal
        InputStream is = new FileInputStream(file);
        Opus        newOpus = (Opus) Marshalling.unmarshal(is);
        System.out.println(new Dumper.Column(newOpus, "(unmarshalled opus)").toString());

        for (Object item : topOpus.getOpusOrOpusLinkOrScore()) {
            System.out.println(new Dumper.Column(item, 1).toString());
        }

        System.out.println();
        System.out.println("My marshalling of un-marshalled opus:");
        System.out.println("-------------------------------------");
        Marshalling.marshal(newOpus, System.out);
        System.out.println();
        System.out.println();
    }
}
