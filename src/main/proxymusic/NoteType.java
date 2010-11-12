
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * The note-type type indicates the graphic note type, Valid values (from shortest to longest) are 256th, 128th, 64th, 32nd, 16th, eighth, quarter, half, whole, breve, and long. The size attribute indicates full, cue, or large size, with full the default for regular notes and cue the default for cue and grace notes.
 * 
 * <p>Java class for note-type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="note-type">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;>note-type-value">
 *       &lt;attribute name="size" type="{}symbol-size" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "note-type", propOrder = {
    "value"
})
public class NoteType {

    @XmlValue
    protected java.lang.String value;
    @XmlAttribute
    protected SymbolSize size;

    /**
     * The note-type type is used for the MusicXML type element and represents the graphic note type, from 256th (shortest) to long (longest).
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }

    /**
     * Gets the value of the size property.
     * 
     * @return
     *     possible object is
     *     {@link SymbolSize }
     *     
     */
    public SymbolSize getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     * @param value
     *     allowed object is
     *     {@link SymbolSize }
     *     
     */
    public void setSize(SymbolSize value) {
        this.size = value;
    }

}
