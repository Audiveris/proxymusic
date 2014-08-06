//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                                         R o o t F i l e                                        //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//  Copyright © Herve Bitteur and others 2000-2014. All rights reserved.
//  This software is released under the GNU Lesser General Public License.
//  Goto http://kenai.com/projects/proxymusic to report bugs or suggestions.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package com.audiveris.proxymusic.mxl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class {@code RootFile} represents a file entry in MXL Container.
 *
 * @author Hervé Bitteur
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "rootfile")
public class RootFile
{
    //~ Static fields/initializers -----------------------------------------------------------------

    /** Media type for an uncompressed MusicXML file (default). */
    public static final String MUSICXML_MEDIA_TYPE = "application/vnd.recordare.musicxml+xml";

    /** Media type for a compressed MusicXML file. */
    public static final String COMPRESSED_MUSICXML_MEDIA_TYPE = "application/vnd.recordare.musicxml";

    //~ Instance fields ----------------------------------------------------------------------------
    /** Full path. Path relative to the root folder of the zip file */
    @XmlAttribute(name = "full-path")
    public final String fullPath;

    /** Media type. It identifies the type of different top-level root files */
    @XmlAttribute(name = "media-type")
    public final String mediaType;

    //~ Constructors -------------------------------------------------------------------------------
    /**
     * Creates a new {@code RootFile} object.
     *
     * @param fullPath path to the file, relative to root folder
     */
    public RootFile (String fullPath)
    {
        this.fullPath = fullPath;
        this.mediaType = null;
    }

    /**
     * Creates a new {@code RootFile} object with a specific media type.
     *
     * @param fullPath  path to the file, relative to root folder
     * @param mediaType type of file
     */
    public RootFile (String fullPath,
                     String mediaType)
    {
        this.fullPath = fullPath;
        this.mediaType = mediaType;
    }

    /**
     * No-arg constructor needed for JAXB
     */
    private RootFile ()
    {
        this.fullPath = null;
        this.mediaType = null;
    }

    //~ Methods ------------------------------------------------------------------------------------
    @Override
    public String toString ()
    {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append("{").append("fullPath=").append(fullPath);

        if (mediaType != null) {
            sb.append(" mediaType=").append(mediaType);
        }

        sb.append("}");

        return sb.toString();
    }
}
