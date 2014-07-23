//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                            C u s t o m X m l S t r e a m W r i t e r                           //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
package com.audiveris.proxymusic.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * Class {@code CustomXMLStreamWriter} removes the namespaces from the marshal operation.
 * <p>
 * It is a wrapper for an XMLStreamWriter that intercepts and removes the relevant namespace info.
 * It does so by treating all namespace declarations as default namespaces.
 * <p>
 * It also performs formatting on the fly, if a non-null indentation value was provided.
 * TODO: Still to be checked for writeEmptyElement and writeProcessingInstruction
 * <p>
 * It also inserts a comment line just before a part or measure element begins.
 *
 * @author Blaise Doughan (namespace handling)
 * @see <a href="http://stackoverflow.com/a/5722013">Blaise article</a>
 * @author Hervé Bitteur (formatting)
 */
public class CustomXMLStreamWriter
        implements XMLStreamWriter
{
    //~ Static fields/initializers -----------------------------------------------------------------

    private static final Logger logger = LoggerFactory.getLogger(CustomXMLStreamWriter.class);

    //~ Instance fields ----------------------------------------------------------------------------
    /** The real writer. */
    private final XMLStreamWriter xsw;

    /** Special name context. */
    private final MyNamespaceContext nc = new MyNamespaceContext();

    /** Indentation string, if any. */
    private final String INDENT;

    /** Current level of indentation. */
    private int level;

    /** Are we closing element(s)?. */
    private boolean closing;

    //~ Constructors -------------------------------------------------------------------------------
    /**
     * Creates a new {@code CustomXMLStreamWriter} object.
     *
     * @param xsw         the real XML stream writer
     * @param indentValue desired indentation value, if any (null, 0 or n)
     *
     * @throws XMLStreamException for any processing error
     */
    public CustomXMLStreamWriter (XMLStreamWriter xsw,
                                  Integer indentValue)
            throws XMLStreamException
    {
        this.xsw = xsw;
        xsw.setNamespaceContext(nc);

        INDENT = getIndentString(indentValue);
    }

    //~ Methods ------------------------------------------------------------------------------------
    @Override
    public void close ()
            throws XMLStreamException
    {
        xsw.close();
    }

    @Override
    public void flush ()
            throws XMLStreamException
    {
        xsw.flush();
    }

    @Override
    public NamespaceContext getNamespaceContext ()
    {
        return xsw.getNamespaceContext();
    }

    @Override
    public String getPrefix (String uri)
            throws XMLStreamException
    {
        return xsw.getPrefix(uri);
    }

    @Override
    public Object getProperty (String name)
            throws IllegalArgumentException
    {
        return xsw.getProperty(name);
    }

    @Override
    public void setDefaultNamespace (String uri)
            throws XMLStreamException
    {
        xsw.setDefaultNamespace(uri);
    }

    //---------------------//
    // setNamespaceContext //
    //---------------------//
    @Override
    public void setNamespaceContext (NamespaceContext context)
            throws XMLStreamException
    {
        ///xsw.setNamespaceContext(context);
        // void (we keep using our own NamespaceContext)
    }

    @Override
    public void setPrefix (String prefix,
                           String uri)
            throws XMLStreamException
    {
        xsw.setPrefix(prefix, uri);
    }

    @Override
    public void writeAttribute (String localName,
                                String value)
            throws XMLStreamException
    {
        xsw.writeAttribute(localName, value);
    }

    @Override
    public void writeAttribute (String prefix,
                                String namespaceURI,
                                String localName,
                                String value)
            throws XMLStreamException
    {
        xsw.writeAttribute(prefix, namespaceURI, localName, value);
    }

    @Override
    public void writeAttribute (String namespaceURI,
                                String localName,
                                String value)
            throws XMLStreamException
    {
        xsw.writeAttribute(namespaceURI, localName, value);
    }

    @Override
    public void writeCData (String data)
            throws XMLStreamException
    {
        xsw.writeCData(data);
    }

    @Override
    public void writeCharacters (String text)
            throws XMLStreamException
    {
        xsw.writeCharacters(text);
    }

    @Override
    public void writeCharacters (char[] text,
                                 int start,
                                 int len)
            throws XMLStreamException
    {
        xsw.writeCharacters(text, start, len);
    }

    //--------------//
    // writeComment //
    //--------------//
    @Override
    public void writeComment (String data)
            throws XMLStreamException
    {
        indentComment();
        xsw.writeComment(data);
    }

    @Override
    public void writeDTD (String dtd)
            throws XMLStreamException
    {
        xsw.writeDTD(dtd);
    }

    @Override
    public void writeDefaultNamespace (String namespaceURI)
            throws XMLStreamException
    {
        xsw.writeDefaultNamespace(namespaceURI);
    }

    @Override
    public void writeEmptyElement (String namespaceURI,
                                   String localName)
            throws XMLStreamException
    {
        xsw.writeEmptyElement(namespaceURI, localName);
    }

    @Override
    public void writeEmptyElement (String prefix,
                                   String localName,
                                   String namespaceURI)
            throws XMLStreamException
    {
        xsw.writeEmptyElement(prefix, localName, namespaceURI);
    }

    @Override
    public void writeEmptyElement (String localName)
            throws XMLStreamException
    {
        xsw.writeEmptyElement(localName);
    }

    @Override
    public void writeEndDocument ()
            throws XMLStreamException
    {
        xsw.writeEndDocument();
    }

    @Override
    public void writeEndElement ()
            throws XMLStreamException
    {
        indentEnd();
        xsw.writeEndElement();
    }

    @Override
    public void writeEntityRef (String name)
            throws XMLStreamException
    {
        xsw.writeEntityRef(name);
    }

    //----------------//
    // writeNamespace //
    //----------------//
    @Override
    public void writeNamespace (String prefix,
                                String namespaceURI)
            throws XMLStreamException
    {
        ///xsw.writeNamespace(prefix, namespaceURI);
        // void (we don't output this information)
    }

    @Override
    public void writeProcessingInstruction (String target)
            throws XMLStreamException
    {
        xsw.writeProcessingInstruction(target);
    }

    @Override
    public void writeProcessingInstruction (String target,
                                            String data)
            throws XMLStreamException
    {
        xsw.writeProcessingInstruction(target, data);
    }

    @Override
    public void writeStartDocument ()
            throws XMLStreamException
    {
        xsw.writeStartDocument();
    }

    @Override
    public void writeStartDocument (String version)
            throws XMLStreamException
    {
        xsw.writeStartDocument(version);
    }

    @Override
    public void writeStartDocument (String encoding,
                                    String version)
            throws XMLStreamException
    {
        xsw.writeStartDocument(encoding, version);
    }

    @Override
    public void writeStartElement (String localName)
            throws XMLStreamException
    {
        indentStart(localName);
        xsw.writeStartElement(localName);
    }

    @Override
    public void writeStartElement (String namespaceURI,
                                   String localName)
            throws XMLStreamException
    {
        indentStart(localName);
        xsw.writeStartElement(namespaceURI, localName);
    }

    //-------------------//
    // writeStartElement //
    //-------------------//
    @Override
    public void writeStartElement (String prefix,
                                   String localName,
                                   String namespaceURI)
            throws XMLStreamException
    {
        ///xsw.writeStartElement(prefix, localName, namespaceURI);
        indentStart(localName);
        xsw.writeStartElement("", localName, namespaceURI);

        if ((namespaceURI != null) && (namespaceURI.length() > 0)) {
            String currentDefaultNS = nc.getNamespaceURI("");

            if (!namespaceURI.equals(currentDefaultNS)) {
                writeDefaultNamespace(namespaceURI);
                nc.setDefaultNS(namespaceURI);
            }
        }
    }

    //----------//
    // doIndent //
    //----------//
    /**
     * Insert a new line, followed by proper level of indentation.
     *
     * @throws XMLStreamException
     */
    private void doIndent ()
            throws XMLStreamException
    {
        xsw.writeCharacters("\n");

        for (int i = 0; i < level; i++) {
            xsw.writeCharacters(INDENT);
        }
    }

    //-----------------//
    // getIndentString //
    //-----------------//
    /**
     * Build proper indentation string.
     *
     * @param value desired indentation value
     * @return the indentation string to use: null for no indentation at all, empty string for LF
     *         only, non-empty string for LF and concrete indentation
     */
    private String getIndentString (Integer value)
    {
        if (value == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < value; i++) {
            sb.append(" ");
        }

        return sb.toString();
    }

    //---------------//
    // indentComment //
    //---------------//
    /**
     * Indentation before comment. Always indent.
     *
     * @throws XMLStreamException
     */
    private void indentComment ()
            throws XMLStreamException
    {
        if (INDENT != null) {
            doIndent();
        }
    }

    //-----------//
    // indentEnd //
    //-----------//
    /**
     * Indentation before end tag. Indent except on first close.
     *
     * @throws XMLStreamException
     */
    private void indentEnd ()
            throws XMLStreamException
    {
        if (INDENT != null) {
            level--;

            if (closing) {
                doIndent();
            }

            closing = true;
        }
    }

    //-------------//
    // indentStart //
    //-------------//
    /**
     * Indentation before start tag. Always indent.
     *
     * @param localName the local tag name
     * @throws XMLStreamException
     */
    private void indentStart (String localName)
            throws XMLStreamException
    {
        if (INDENT != null) {
            // Insert visible comment lines only for measures and parts
            if (localName.equals("measure")) {
                writeComment("=======================================================");
            } else if (localName.equals("part")) {
                writeComment("= = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
            }

            doIndent();
            level++;
            closing = false;
        }
    }

    //~ Inner Classes ------------------------------------------------------------------------------
    //--------------------//
    // MyNamespaceContext //
    //--------------------//
    private static class MyNamespaceContext
            implements NamespaceContext
    {
        //~ Instance fields ------------------------------------------------------------------------

        private String defaultNS = "";

        //~ Methods --------------------------------------------------------------------------------
        public String getNamespaceURI (String prefix)
        {
            if ("".equals(prefix)) {
                return defaultNS;
            }

            return null;
        }

        public String getPrefix (String namespaceURI)
        {
            return "";
        }

        public Iterator getPrefixes (String namespaceURI)
        {
            return null;
        }

        public void setDefaultNS (String ns)
        {
            defaultNS = ns;
        }
    }
}
