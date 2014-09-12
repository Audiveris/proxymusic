//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                                           S o u r c e                                          //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//  Copyright © Herve Bitteur and others 2000-2014. All rights reserved.
//  This software is released under the GNU General Public License.
//  Goto http://kenai.com/projects/audiveris to report bugs or suggestions.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package com.audiveris.proxymusic.util;

import com.audiveris.proxymusic.Identification;
import com.audiveris.proxymusic.Miscellaneous;
import com.audiveris.proxymusic.MiscellaneousField;
import com.audiveris.proxymusic.ObjectFactory;
import com.audiveris.proxymusic.ScorePartwise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Class {@code Source} precisely describes the source of a ScorePartwise.
 * <p>
 * Within a given input file (or uri), perhaps composed of several page images, the relevant pages
 * are listed, each with the systems processed for the ScorePartwise instance at hand.
 * <p>
 * A page with no system processed (for example because it is made of text only), could explicitly
 * appear but with an empty sequence of system numbers (this is recommended), or the page could not
 * appear at all in this source structure.
 * <p>
 * In the following example, the ScorePartwise spans the first 3 pages of the input file, with
 * page #2 being "empty", and only the first system in page #3.
 * Another ScorePartwise instance, typically representing a following movement, could start with the
 * same page #3, but from system 2.
 * <p>
 * In MusicXML, such Source data is encoded using the miscellaneous element.
 * <br/>
 * Using file:
 * <pre>
 * &lt;miscellaneous&gt;
 *     &lt;miscellaneous-field name="input-file"&gt;D:\soft\scores\morphology\recordare\MozartTrio.png&lt;/miscellaneous-field&gt;
 *     &lt;miscellaneous-field name="input-page-1"&gt;1 2&lt;/miscellaneous-field&gt;
 *     &lt;miscellaneous-field name="input-page-2"&gt;&lt;/miscellaneous-field&gt;
 *     &lt;miscellaneous-field name="input-page-3"&gt;1&lt;/miscellaneous-field&gt;
 * &lt;/miscellaneous&gt;
 * </pre>
 * <p>
 * Using uri:
 * <pre>
 * &lt;miscellaneous&gt;
 *     &lt;miscellaneous-field name="input-uri"&gt;file:///MozartTrio.png&lt;/miscellaneous-field&gt;
 *     &lt;miscellaneous-field name="input-page-1"&gt;1 2&lt;/miscellaneous-field&gt;
 *     &lt;miscellaneous-field name="input-page-2"&gt;&lt;/miscellaneous-field&gt;
 *     &lt;miscellaneous-field name="input-page-3"&gt;1&lt;/miscellaneous-field&gt;
 * &lt;/miscellaneous&gt;
 * </pre>
 *
 * @author Hervé Bitteur
 */
public class Source
{
    //~ Static fields/initializers -----------------------------------------------------------------

    private static final Logger logger = LoggerFactory.getLogger(Source.class);

    private static final String SOURCE_PREFIX = "source-";

    private static final String PAGE_PREFIX = "page-";

    //~ Instance fields ----------------------------------------------------------------------------
    /** Path to source image file, if any. */
    private String file;

    /** Source image URI, if any. */
    private URI uri;

    /** Systems processed in each image page. */
    private final List<PageSystems> pages = new ArrayList<PageSystems>();

    //~ Methods ------------------------------------------------------------------------------------
    //--------//
    // decode //
    //--------//
    public static Source decode (ScorePartwise scorePartwise)
    {
        Identification identification = scorePartwise.getIdentification();

        if (identification == null) {
            return null;
        }

        Miscellaneous misc = identification.getMiscellaneous();

        if (misc == null) {
            return null;
        }

        Source source = new Source();

        for (MiscellaneousField field : misc.getMiscellaneousField()) {
            String name = field.getName();
            String value = field.getValue().trim();

            ///logger.info("miscellaneous-field name:{} value:'{}'", name, value);
            if (name.startsWith(SOURCE_PREFIX)) {
                String tail = name.substring(SOURCE_PREFIX.length());

                if (tail.equals("file")) {
                    source.file = value;
                } else if (tail.equals("uri")) {
                    source.uri = URI.create(value);
                } else if (tail.startsWith(PAGE_PREFIX)) {
                    String numStr = tail.substring(PAGE_PREFIX.length());
                    int num = Integer.decode(numStr);
                    PageSystems page = new PageSystems(num);
                    source.pages.add(page);
                    page.getSystems().addAll(parseInts(value));
                }
            }
        }

        return source;
    }

    //--------//
    // encode //
    //--------//
    public void encode (ScorePartwise scorePartwise)
    {
        final ObjectFactory factory = new ObjectFactory();
        Identification identification = scorePartwise.getIdentification();

        if (identification == null) {
            identification = factory.createIdentification();
            scorePartwise.setIdentification(identification);
        }

        Miscellaneous misc = identification.getMiscellaneous();

        if (misc == null) {
            misc = factory.createMiscellaneous();
            identification.setMiscellaneous(misc);
        }

        MiscellaneousField field;

        if (file != null) {
            misc.getMiscellaneousField().add(field = factory.createMiscellaneousField());
            field.setName(SOURCE_PREFIX + "file");
            field.setValue(file);
        } else if (uri != null) {
            misc.getMiscellaneousField().add(field = factory.createMiscellaneousField());
            field.setName(SOURCE_PREFIX + "uri");
            field.setValue(uri.toString());
        }

        for (PageSystems page : pages) {
            misc.getMiscellaneousField().add(field = factory.createMiscellaneousField());
            field.setName(SOURCE_PREFIX + PAGE_PREFIX + page.pageNumber);
            field.setValue(packInts(page.getSystems()));
        }
    }

    /**
     * @return the file
     */
    public String getFile ()
    {
        return file;
    }

    /**
     * @return the pageSystems
     */
    public List<PageSystems> getPages ()
    {
        return pages;
    }

    /**
     * @return the uri
     */
    public URI getUri ()
    {
        return uri;
    }

    /**
     * @param file the file to set
     */
    public void setFile (String file)
    {
        this.file = file;
    }

    /**
     * @param uri the uri to set
     */
    public void setUri (URI uri)
    {
        this.uri = uri;
    }

    @Override
    public String toString ()
    {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append("{");

        if (file != null) {
            sb.append("file='").append(file).append("'");
        } else if (uri != null) {
            sb.append("uri=").append(uri);
        }

        for (PageSystems page : pages) {
            sb.append(" ").append(page);
        }

        sb.append("}");

        return sb.toString();
    }

    //----------//
    // packInts //
    //----------//
    /**
     * Return a single string made of provided ints separated by space.
     *
     * @param ints the provided integer values
     * @return the resulting string
     */
    private static String packInts (List<Integer> ints)
    {
        StringBuilder sb = new StringBuilder();

        for (int val : ints) {
            if (sb.length() > 0) {
                sb.append(" ");
            }

            sb.append(val);
        }

        return sb.toString();
    }

    //-----------//
    // parseInts //
    //-----------//
    /**
     * Parse a string of integers, separated by space.
     *
     * @param str the string to parse
     * @return the sequence of integers decoded
     */
    private static List<Integer> parseInts (String str)
    {
        final List<Integer> intList = new ArrayList<Integer>();
        final String[] tokens = str.split("\\s+");

        for (String token : tokens) {
            try {
                String trimmedToken = token.trim();

                if (!trimmedToken.isEmpty()) {
                    intList.add(Integer.decode(trimmedToken));
                }
            } catch (NumberFormatException ex) {
                logger.warn("Illegal integer", ex);
            }
        }

        return intList;
    }

    //~ Inner Classes ------------------------------------------------------------------------------
    //-------------//
    // PageSystems //
    //-------------//
    /**
     * Describes which systems were processed in this page.
     */
    public static class PageSystems
    {
        //~ Instance fields ------------------------------------------------------------------------

        /** Page number within source file, starting from 1. */
        final int pageNumber;

        /** Sequence of systems processed, starting from 1. */
        private final List<Integer> systems = new ArrayList<Integer>();

        //~ Constructors ---------------------------------------------------------------------------
        public PageSystems (int pageNumber)
        {
            this.pageNumber = pageNumber;
        }

        //~ Methods --------------------------------------------------------------------------------
        /**
         * @return the systems
         */
        public List<Integer> getSystems ()
        {
            return systems;
        }

        @Override
        public String toString ()
        {
            StringBuilder sb = new StringBuilder("page");
            sb.append("#").append(pageNumber);
            sb.append("[");

            boolean first = true;

            for (Integer system : systems) {
                if (!first) {
                    sb.append(" ");
                }

                sb.append(system);
                first = false;
            }

            sb.append("]");

            return sb.toString();
        }
    }
}
