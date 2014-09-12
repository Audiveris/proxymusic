//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                             S t r e a m W r i t e r D e l e g a t e                            //
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
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * Class {@code StreamWriterDelegate} is meant to serve as a base class for
 * deriving an {@link XMLStreamWriter} filter.
 *
 * @author Hervé Bitteur
 */
public class StreamWriterDelegate
        implements XMLStreamWriter
{
    //~ Instance fields ----------------------------------------------------------------------------

    private XMLStreamWriter writer;

    //~ Constructors -------------------------------------------------------------------------------
    /**
     * Construct an empty filter with no parent.
     */
    public StreamWriterDelegate ()
    {
    }

    /**
     * Construct a filter with the specified parent.
     *
     * @param writer the parent
     */
    public StreamWriterDelegate (XMLStreamWriter writer)
    {
        this.writer = writer;
    }

    //~ Methods ------------------------------------------------------------------------------------
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
    public XMLStreamWriter getParent ()
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
    public Object getProperty (String name)
            throws IllegalArgumentException
    {
        return writer.getProperty(name);
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
    public void setParent (XMLStreamWriter writer)
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

    @Override
    public void writeAttribute (String localName,
                                String value)
            throws XMLStreamException
    {
        writer.writeAttribute(localName, value);
    }

    @Override
    public void writeAttribute (String prefix,
                                String namespaceURI,
                                String localName,
                                String value)
            throws XMLStreamException
    {
        writer.writeAttribute(prefix, namespaceURI, localName, value);
    }

    @Override
    public void writeAttribute (String namespaceURI,
                                String localName,
                                String value)
            throws XMLStreamException
    {
        writer.writeAttribute(namespaceURI, localName, value);
    }

    @Override
    public void writeCData (String data)
            throws XMLStreamException
    {
        writer.writeCData(data);
    }

    @Override
    public void writeCharacters (String text)
            throws XMLStreamException
    {
        writer.writeCharacters(text);
    }

    @Override
    public void writeCharacters (char[] text,
                                 int start,
                                 int len)
            throws XMLStreamException
    {
        writer.writeCharacters(text, start, len);
    }

    @Override
    public void writeComment (String data)
            throws XMLStreamException
    {
        writer.writeComment(data);
    }

    @Override
    public void writeDTD (String dtd)
            throws XMLStreamException
    {
        writer.writeDTD(dtd);
    }

    @Override
    public void writeDefaultNamespace (String namespaceURI)
            throws XMLStreamException
    {
        writer.writeDefaultNamespace(namespaceURI);
    }

    @Override
    public void writeEmptyElement (String namespaceURI,
                                   String localName)
            throws XMLStreamException
    {
        writer.writeEmptyElement(namespaceURI, localName);
    }

    @Override
    public void writeEmptyElement (String prefix,
                                   String localName,
                                   String namespaceURI)
            throws XMLStreamException
    {
        writer.writeEmptyElement(prefix, localName, namespaceURI);
    }

    @Override
    public void writeEmptyElement (String localName)
            throws XMLStreamException
    {
        writer.writeEmptyElement(localName);
    }

    @Override
    public void writeEndDocument ()
            throws XMLStreamException
    {
        writer.writeEndDocument();
    }

    @Override
    public void writeEndElement ()
            throws XMLStreamException
    {
        writer.writeEndElement();
    }

    @Override
    public void writeEntityRef (String name)
            throws XMLStreamException
    {
        writer.writeEntityRef(name);
    }

    @Override
    public void writeNamespace (String prefix,
                                String namespaceURI)
            throws XMLStreamException
    {
        writer.writeNamespace(prefix, namespaceURI);
    }

    @Override
    public void writeProcessingInstruction (String target)
            throws XMLStreamException
    {
        writer.writeProcessingInstruction(target);
    }

    @Override
    public void writeProcessingInstruction (String target,
                                            String data)
            throws XMLStreamException
    {
        writer.writeProcessingInstruction(target, data);
    }

    @Override
    public void writeStartDocument ()
            throws XMLStreamException
    {
        writer.writeStartDocument();
    }

    @Override
    public void writeStartDocument (String version)
            throws XMLStreamException
    {
        writer.writeStartDocument(version);
    }

    @Override
    public void writeStartDocument (String encoding,
                                    String version)
            throws XMLStreamException
    {
        writer.writeStartDocument(encoding, version);
    }

    @Override
    public void writeStartElement (String localName)
            throws XMLStreamException
    {
        writer.writeStartElement(localName);
    }

    @Override
    public void writeStartElement (String namespaceURI,
                                   String localName)
            throws XMLStreamException
    {
        writer.writeStartElement(namespaceURI, localName);
    }

    @Override
    public void writeStartElement (String prefix,
                                   String localName,
                                   String namespaceURI)
            throws XMLStreamException
    {
        writer.writeStartElement(prefix, localName, namespaceURI);
    }
}
