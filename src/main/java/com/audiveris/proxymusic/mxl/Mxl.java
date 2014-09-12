//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                                              M x l                                             //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//  Copyright © Herve Bitteur and others 2000-2014. All rights reserved.
//  This software is released under the GNU Lesser General Public License.
//  Goto http://kenai.com/projects/proxymusic to report bugs or suggestions.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package com.audiveris.proxymusic.mxl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class {@code Mxl} handles the compressed MXL format, through its provided
 * {@link Input} and {@link Output} classes.
 *
 * @author Hervé Bitteur
 */
public abstract class Mxl
{
    //~ Static fields/initializers -----------------------------------------------------------------

    /** Name of the specific entry for container. */
    private static final String CONTAINER_ENTRY_NAME = "META-INF/container.xml";

    /** Container [un]marshalling context. */
    private static JAXBContext containerContext;

    //~ Methods ------------------------------------------------------------------------------------
    //------------//
    // getContext //
    //------------//
    /**
     * Get access to (and elaborate if not yet done) the Container JAXB context.
     *
     * @return the ready to use JAXB context
     * @exception JAXBException if anything goes wrong
     */
    private static JAXBContext getContext ()
            throws JAXBException
    {
        // Lazy creation
        if (containerContext == null) {
            synchronized (Mxl.class) {
                containerContext = JAXBContext.newInstance(Container.class);
            }
        }

        return containerContext;
    }

    //~ Inner Classes ------------------------------------------------------------------------------
    //-------//
    // Input //
    //-------//
    /**
     * Class {@code Input} allows to read a .mxl file.
     */
    public static class Input
    {
        //~ Instance fields ------------------------------------------------------------------------

        /** The underlying zip file. */
        private final ZipFile zipFile;

        /** MXL container. */
        private final Container container;

        //~ Constructors ---------------------------------------------------------------------------
        /**
         * Create an {@code Input} object on a provided file.
         *
         * @param file the provided file
         * @throws FileNotFoundException
         * @throws IOException
         * @throws MxlException
         * @throws JAXBException
         */
        public Input (File file)
                throws FileNotFoundException, IOException, MxlException, JAXBException
        {
            zipFile = new ZipFile(file);

            // Retrieve container
            ZipEntry containerEntry = zipFile.getEntry(CONTAINER_ENTRY_NAME);

            if (containerEntry == null) {
                throw new MxlException("No container found in " + file);
            }

            InputStream cis = zipFile.getInputStream(containerEntry);
            Unmarshaller um = getContext().createUnmarshaller();
            container = (Container) um.unmarshal(cis);
        }

        //~ Methods --------------------------------------------------------------------------------
        /**
         * Report the zip entry related to the provided name.
         *
         * @param entryName the provided entry name
         * @return the entry in the .mxl file
         * @throws IOException
         */
        public ZipEntry getEntry (String entryName)
                throws IOException
        {
            return zipFile.getEntry(entryName);
        }

        /**
         * Report the input stream related to the provided zip entry.
         *
         * @param zipEntry the provided zip entry
         * @return the corresponding input stream
         * @throws IOException
         */
        public InputStream getInputStream (ZipEntry zipEntry)
                throws IOException
        {
            return zipFile.getInputStream(zipEntry);
        }

        /**
         * Report the sequence of root files in the container.
         *
         * @return the (un-mutable) list of RootFile instances
         */
        public List<RootFile> getRootFiles ()
        {
            return Collections.unmodifiableList(container.rootFiles);
        }
    }

    //--------------//
    // MxlException //
    //--------------//
    /** Global exception. */
    public static class MxlException
            extends Exception
    {
        //~ Constructors ---------------------------------------------------------------------------

        public MxlException (Throwable cause)
        {
            super(cause);
        }

        public MxlException (String msg)
        {
            super(msg);
        }
    }

    //--------//
    // Output //
    //--------//
    /**
     * Class {@code Output} allows to write a .mxl file.
     */
    public static class Output
    {
        //~ Instance fields ------------------------------------------------------------------------

        /** The global container. */
        private final Container container = new Container();

        /** The underlying zip output stream. */
        private final MxlOutputStream mos;

        /** Flag to indicate if the stream has already been closed. */
        private boolean closed;

        //~ Constructors ---------------------------------------------------------------------------
        /**
         * Create an {@code Output} object on a provided output stream.
         *
         * @param out the provided output stream
         */
        public Output (OutputStream out)
        {
            mos = new MxlOutputStream(new BufferedOutputStream(out));
        }

        /**
         * Create an {@code Output} object on a provided output file.
         *
         * @param file the file to write
         * @throws FileNotFoundException
         */
        public Output (File file)
                throws FileNotFoundException
        {
            this(new FileOutputStream(file));
        }

        //~ Methods --------------------------------------------------------------------------------
        /**
         * Insert a new RootFile entry into this file.
         * This populates the internal container and positions the stream output accordingly.
         *
         * @param rootFile the provided RootFile
         * @return the corresponding Zip entry
         * @throws com.audiveris.proxymusic.mxl.Mxl.MxlException
         */
        public ZipEntry addEntry (RootFile rootFile)
                throws MxlException
        {
            try {
                ZipEntry entry = new ZipEntry(rootFile.fullPath);
                mos.putNextEntry(entry);
                container.addRootFile(rootFile);

                return entry;
            } catch (IOException ex) {
                throw new MxlException(ex);
            }
        }

        /**
         * Insert the provided RootFile as the FIRST entry.
         * This can be called at any time, to populate the internal container in first position, and
         * position the stream output accordingly.
         *
         * @param rootFile the provided RootFile
         * @return the corresponding Zip entry
         * @throws com.audiveris.proxymusic.mxl.Mxl.MxlException
         */
        public ZipEntry addFirstEntry (RootFile rootFile)
                throws MxlException
        {
            try {
                ZipEntry entry = new ZipEntry(rootFile.fullPath);
                mos.putNextEntry(entry);
                container.addFirstRootFile(rootFile);

                return entry;
            } catch (IOException ex) {
                throw new MxlException(ex);
            }
        }

        /**
         * Write the container and close the underlying output stream.
         *
         * @throws IOException
         */
        public void close ()
                throws IOException
        {
            if (closed) {
                return;
            }

            try {
                // Marshal the container
                Marshaller m = Mxl.getContext().createMarshaller();
                mos.putNextEntry(new ZipEntry(CONTAINER_ENTRY_NAME));
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                m.marshal(container, mos);

                // Close everything
                closed = true;
                mos.close();
            } catch (JAXBException ex) {
                throw new IOException(ex);
            }
        }

        /**
         * Report the underlying Zip output stream.
         *
         * @return the Zip output stream
         */
        public OutputStream getOutputStream ()
        {
            return mos;
        }

        //~ Inner Classes --------------------------------------------------------------------------
        /**
         * An OutputStream sub-classed in order to intercept closing.
         */
        public class MxlOutputStream
                extends ZipOutputStream
        {
            //~ Constructors -----------------------------------------------------------------------

            public MxlOutputStream (OutputStream out)
            {
                super(out, StandardCharsets.UTF_8);
            }

            //~ Methods ----------------------------------------------------------------------------
            @Override
            public void close ()
                    throws IOException
            {
                // Write the container data
                Output.this.close();

                // Close the stream
                super.close();
            }
        }
    }

    //-----------//
    // Container //
    //-----------//
    /**
     * The mandatory container structure.
     */
    @XmlAccessorType(XmlAccessType.NONE)
    @XmlRootElement(name = "container")
    private static class Container
    {
        //~ Instance fields ------------------------------------------------------------------------

        /** The collection of root files. */
        @XmlElementWrapper(name = "rootfiles")
        @XmlElement(name = "rootfile")
        private final List<RootFile> rootFiles = new ArrayList<RootFile>();

        //~ Constructors ---------------------------------------------------------------------------
        /**
         * No-arg constructor, needed by JAXB.
         */
        public Container ()
        {
        }

        //~ Methods --------------------------------------------------------------------------------
        //------------------//
        // addFirstRootFile //
        //------------------//
        /**
         * Add the rootFile entry to the container, in first position.
         *
         * @param rootFile the entry to add
         */
        public void addFirstRootFile (RootFile rootFile)
        {
            rootFiles.add(0, rootFile);
        }

        //-------------//
        // addRootFile //
        //-------------//
        /**
         * Add one rootFile entry to the container.
         *
         * @param rootFile the entry to add
         */
        public void addRootFile (RootFile rootFile)
        {
            rootFiles.add(rootFile);
        }
    }
}
