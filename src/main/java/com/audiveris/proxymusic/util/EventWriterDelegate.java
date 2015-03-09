//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                              E v e n t W r i t e r D e l e g a t e                             //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//  Copyright © Herve Bitteur and others 2000-2014. All rights reserved.
//  This software is released under the GNU General Public License.
//  Goto http://kenai.com/projects/audiveris to report bugs or suggestions.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package com.audiveris.proxymusic.util;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

/**
 * Class {@code EventWriterDelegate}
 *
 * @author Hervé Bitteur
 */
public class EventWriterDelegate
        implements XMLEventWriter
{
    //~ Instance fields ----------------------------------------------------------------------------

    private XMLEventWriter writer;

    //~ Constructors -------------------------------------------------------------------------------
    /**
     * Construct an empty filter with no parent.
     */
    public EventWriterDelegate ()
    {
    }

    /**
     * Construct a filter with the specified parent.
     *
     * @param writer the parent
     */
    public EventWriterDelegate (XMLEventWriter writer)
    {
        this.writer = writer;
    }

    //~ Methods ------------------------------------------------------------------------------------
    @Override
    public void add (XMLEvent event)
            throws XMLStreamException
    {
        System.out.println(
                "Delegate.add type=" + event.getEventType()  + " " + event);
        writer.add(event);
    }

    @Override
    public void add (XMLEventReader reader)
            throws XMLStreamException
    {
        writer.add(reader);
    }

    @Override
    public void close ()
            throws XMLStreamException
    {
        writer.close();
    }

    @Override
    public void flush ()
            throws XMLStreamException
    {
        writer.flush();
    }

    @Override
    public NamespaceContext getNamespaceContext ()
    {
        return writer.getNamespaceContext();
    }

    /**
     * Get the parent of this instance.
     *
     * @return the parent or null if none is set
     */
    public XMLEventWriter getParent ()
    {
        return writer;
    }

    @Override
    public String getPrefix (String uri)
            throws XMLStreamException
    {
        return writer.getPrefix(uri);
    }

    @Override
    public void setDefaultNamespace (String uri)
            throws XMLStreamException
    {
        writer.setDefaultNamespace(uri);
    }

    @Override
    public void setNamespaceContext (NamespaceContext context)
            throws XMLStreamException
    {
        writer.setNamespaceContext(context);
    }

    /**
     * Set the parent of this instance.
     *
     * @param writer the new parent
     */
    public void setParent (XMLEventWriter writer)
    {
        this.writer = writer;
    }

    @Override
    public void setPrefix (String prefix,
                           String uri)
            throws XMLStreamException
    {
        writer.setPrefix(prefix, uri);
    }
}
