//----------------------------------------------------------------------------//
//                                                                            //
//                          C o p y C o m m e n t s                           //
//                                                                            //
//  Copyright (C) Herve Bitteur 2007. All rights reserved.                    //
//  This software is released under the terms of the GNU General Public       //
//  License. Please contact the author at herve.bitteur@laposte.net           //
//  to report bugs & suggestions.                                             //
//----------------------------------------------------------------------------//
//
package proxymusic.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class <code>CopyComments</code> is used only at build time, to handle the
 * extraction of comments out of the initial DTD files, and their inclusion in
 * the generated Java classes, wherever appropriate.
 *
 * @author Herv&eacute Bitteur
 * @version $Id$
 */
public class CopyComments
{
    //~ Static fields/initializers ---------------------------------------------

    /** Magic string to detect when annotations have been inserted */
    private static final String DTD_COMMENT = " * <p>Comments from original DTD:";

    //~ Enumerations -----------------------------------------------------------

    /** Parser states */
    enum State {
        /** Within a bloc of comment */
        IN_COMMENT,
        /** Leaving a bloc of comment */
        LEAVING_COMMENT,
        /** Outside a bloc of comment */
        OUT_COMMENT,
        /** Defining an element */
        ELEMENT;
    }

    //~ Instance fields --------------------------------------------------------

    /** Directory where Java classes are to be found */
    private final File javaDir;

    //~ Constructors -----------------------------------------------------------

    //--------------//
    // CopyComments //
    //--------------//
    /**
     * Create a new instance of CopyComments
     *
     * @param dtdDirName name of DTD directory
     * @param javaDirName name of Java classes directory
     */
    private CopyComments (String dtdDirName,
                          String javaDirName)
        throws FileNotFoundException, IOException
    {
        javaDir = new File(javaDirName);

        // Browse the DTDs
        File           dtdDir = new File(dtdDirName);
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept (File   dir,
                                   String name)
            {
                return name.endsWith(".dtd") || name.endsWith(".mod");
            }
        };

        for (File file : dtdDir.listFiles(filter)) {
            browseDtd(file);
        }
    }

    //~ Methods ----------------------------------------------------------------

    //------//
    // main //
    //------//
    /**
     * Entry point for launching the process
     *
     * @param args first arg is directory where DTDs are read, second arg is
     *             directory where Java classes are updated
     */
    public static void main (String... args)
    {
        if (args.length != 2) {
            System.err.println(
                "Usage: proxymusic.util.CopyComments <DTD-dir> <Java-dir>");
        } else {
            try {
                new CopyComments(args[0], args[1]);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    //----------------//
    // annotateSource //
    //----------------//
    /**
     * Annotate the Java source file, if any, that corresponds to the provided
     * XML element
     *
     * @param element the xml element name
     * @param block the block of comment lines
     */
    private void annotateSource (String       element,
                                 List<String> block)
        throws FileNotFoundException, IOException
    {
        // First, check if the source exists
        String javaName = javaNameFor(element);
        File   file = new File(javaDir, javaName + ".java");

        if (file.exists()) {
            FileReader     fileReader = new FileReader(file);
            BufferedReader in = new BufferedReader(fileReader);
            String         line;
            List<String>   lines = new ArrayList<String>();

            while ((line = in.readLine()) != null) {
                lines.add(line);

                if (line.equals(DTD_COMMENT)) {
                    System.out.println(
                        "   File " + file + " is already annotated.");

                    return;
                }

                if (line.equals(" * <p>Java class for anonymous complex type.")) {
                    // Insert here the DTD comments
                    lines.add(" *");
                    lines.add(DTD_COMMENT);
                    lines.add(" * <pre>");

                    for (String l : block) {
                        lines.add(" * " + l);
                    }

                    lines.add(" * </pre>");
                }
            }

            fileReader.close();

            // Rewrite the file
            System.out.println("   Annotating " + file);

            PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(file)));

            for (String l : lines) {
                out.println(l);
            }

            out.close();
        } else {
            System.err.println("   File " + file + " does not exist.");
        }
    }

    //-----------//
    // browseDtd //
    //-----------//
    /**
     * Read a DTD file, looking for comments and element definitions
     *
     * @param dtd the DTD file to be read
     */
    private void browseDtd (File dtd)
        throws FileNotFoundException, IOException
    {
        System.out.println("Browsing " + dtd);

        BufferedReader reader = new BufferedReader(new FileReader(dtd));
        String         line;
        State          state = State.OUT_COMMENT;
        List<String>   block = new ArrayList<String>();
        String[]       tokens;
        boolean        lineCopied = false;

        while ((line = reader.readLine()) != null) {
            lineCopied = false;
            ///  System.out.println(
            ///      "===============================line='" + line + "'");
            line = line.trim();
            tokens = line.split("\\s");

            ///System.out.println("tokens=" + Arrays.toString(tokens));
            for (String token : tokens) {
                switch (state) {
                case OUT_COMMENT :

                    if (token.equals("<!--")) {
                        state = State.IN_COMMENT;
                        block.clear();
                    }

                    break;

                case IN_COMMENT :

                    if (token.equals("-->")) {
                        state = State.LEAVING_COMMENT;
                    } else {
                        if (!lineCopied) {
                            block.add(line);
                            lineCopied = true;
                        }
                    }

                    break;

                case LEAVING_COMMENT :

                    if (token.startsWith("<!")) {
                        state = State.OUT_COMMENT;
                    }

                    if (token.equals("<!--")) {
                        state = State.IN_COMMENT;
                        block.clear();
                    } else if (token.equals("<!ELEMENT")) {
                        state = State.ELEMENT;
                    }

                    break;

                case ELEMENT :

                    // Get element name
                    String element = token;
                    ///    System.out.println("*** Element='" + element + "'");
                    ///    System.out.println(
                    ///        "Block=" + Arrays.toString(block.toArray()));
                    state = State.OUT_COMMENT;
                    annotateSource(element, block);

                    break;
                }

                ///System.out.println("token='" + token + "' state=" + state);
            }
        }
    }

    //-------------//
    // javaNameFor //
    //-------------//
    /**
     * Generate the java class name for the given element
     *
     * @param element the xml element
     * @return the java class name
     */
    private String javaNameFor (String element)
    {
        String[]      words = element.split("-");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            sb.append(word.substring(0, 1).toUpperCase());
            sb.append(word.substring(1));
        }

        return sb.toString();
    }
}
