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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Class {@code OpusTest} is a small test for opus features.
 *
 * @author Hervé Bitteur
 */
public class OpusTest
        extends TestCase
{
    //~ Static fields/initializers -----------------------------------------------------------------

    private static final String XML_LINE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

    private static final String OPUS_DOCTYPE_LINE = "<!DOCTYPE opus PUBLIC \"-//Recordare//DTD MusicXML 3.0 Opus//EN\" \"http://www.musicxml.org/dtds/opus.dtd\">";

    //~ Methods ------------------------------------------------------------------------------------
    @Test
    public void test ()
            throws Marshalling.MarshallingException, FileNotFoundException, IOException,
                   Marshalling.UnmarshallingException
    {
        System.out.println("OpusTest.test()");

        ObjectFactory opusFactory = new ObjectFactory();

        // Allocate the opus
        Opus opus = opusFactory.createOpus();

        opus.setTitle("This is the opus title");
        opus.setVersion("2.0");

        Score score1 = opusFactory.createScore();
        score1.setHref("myscore.xml");
        opus.getOpusOrOpusLinkOrScore().add(score1);

        Score score2 = opusFactory.createScore();
        score2.setHref("mysecondscore.xml");
        opus.getOpusOrOpusLinkOrScore().add(score2);
        System.out.println(new Dumper.Column(opus).toString());

        File dir = new File("target/temp");
        dir.mkdirs();

        File file = new File(dir, "my-opus.xml");

        // Marshal
        OutputStream os = new FileOutputStream(file);
        Marshalling.marshal(opus, os);
        os.close();

        // Un-marshal
        InputStream is = new FileInputStream(file);
        Opus newOpus = (Opus) Marshalling.unmarshal(is);
        System.out.println(new Dumper.Column(newOpus).toString());
    }
}
