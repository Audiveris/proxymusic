
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The appearance type controls general graphical settings for the music's final form appearance on a printed page of display. Currently this includes support for line widths and definitions for note sizes, plus an extension element for other aspects of appearance.
 * 
 * <p>Java class for appearance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="appearance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="line-width" type="{}line-width" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="note-size" type="{}note-size" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="other-appearance" type="{}other-appearance" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "appearance", propOrder = {
    "lineWidth",
    "noteSize",
    "otherAppearance"
})
public class Appearance {

    @XmlElement(name = "line-width")
    protected List<LineWidth> lineWidth;
    @XmlElement(name = "note-size")
    protected List<NoteSize> noteSize;
    @XmlElement(name = "other-appearance")
    protected List<OtherAppearance> otherAppearance;

    /**
     * Gets the value of the lineWidth property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineWidth property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineWidth().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LineWidth }
     * 
     * 
     */
    public List<LineWidth> getLineWidth() {
        if (lineWidth == null) {
            lineWidth = new ArrayList<LineWidth>();
        }
        return this.lineWidth;
    }

    /**
     * Gets the value of the noteSize property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the noteSize property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNoteSize().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NoteSize }
     * 
     * 
     */
    public List<NoteSize> getNoteSize() {
        if (noteSize == null) {
            noteSize = new ArrayList<NoteSize>();
        }
        return this.noteSize;
    }

    /**
     * Gets the value of the otherAppearance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otherAppearance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtherAppearance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OtherAppearance }
     * 
     * 
     */
    public List<OtherAppearance> getOtherAppearance() {
        if (otherAppearance == null) {
            otherAppearance = new ArrayList<OtherAppearance>();
        }
        return this.otherAppearance;
    }

}
