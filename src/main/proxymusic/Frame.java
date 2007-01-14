
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * The frame element represents a frame or fretboard
 * diagram used together with a chord symbol. The
 * representation is based on the NIFF guitar grid
 * with additional information. The frame-strings and
 * frame-frets elements give the overall size of the
 * frame in vertical lines (strings) and horizontal
 * spaces (frets). The first-fret indicates which fret
 * is shown in the top space of the frame; it is fret 1
 * if the element is not present. The frame-note element
 * represents each note included in the frame. The
 * definitions for string, fret, and fingering are found
 * in common.dtd.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}frame-strings"/>
 *         &lt;element ref="{}frame-frets"/>
 *         &lt;element ref="{}first-fret" minOccurs="0"/>
 *         &lt;element ref="{}frame-note" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}color"/>
 *       &lt;attGroup ref="{}position"/>
 *       &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "frameStrings",
    "frameFrets",
    "firstFret",
    "frameNote"
})
@XmlRootElement(name = "frame")
public class Frame {

    @XmlElement(name = "frame-strings", required = true)
    protected FrameStrings frameStrings;
    @XmlElement(name = "frame-frets", required = true)
    protected FrameFrets frameFrets;
    @XmlElement(name = "first-fret")
    protected FirstFret firstFret;
    @XmlElement(name = "frame-note", required = true)
    protected List<FrameNote> frameNote;
    @XmlAttribute
    protected java.lang.String height;
    @XmlAttribute
    protected java.lang.String width;
    @XmlAttribute
    protected java.lang.String color;
    @XmlAttribute(name = "default-x")
    protected java.lang.String defaultX;
    @XmlAttribute(name = "default-y")
    protected java.lang.String defaultY;
    @XmlAttribute(name = "relative-x")
    protected java.lang.String relativeX;
    @XmlAttribute(name = "relative-y")
    protected java.lang.String relativeY;

    /**
     * Gets the value of the frameStrings property.
     * 
     * @return
     *     possible object is
     *     {@link FrameStrings }
     *     
     */
    public FrameStrings getFrameStrings() {
        return frameStrings;
    }

    /**
     * Sets the value of the frameStrings property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrameStrings }
     *     
     */
    public void setFrameStrings(FrameStrings value) {
        this.frameStrings = value;
    }

    /**
     * Gets the value of the frameFrets property.
     * 
     * @return
     *     possible object is
     *     {@link FrameFrets }
     *     
     */
    public FrameFrets getFrameFrets() {
        return frameFrets;
    }

    /**
     * Sets the value of the frameFrets property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrameFrets }
     *     
     */
    public void setFrameFrets(FrameFrets value) {
        this.frameFrets = value;
    }

    /**
     * Gets the value of the firstFret property.
     * 
     * @return
     *     possible object is
     *     {@link FirstFret }
     *     
     */
    public FirstFret getFirstFret() {
        return firstFret;
    }

    /**
     * Sets the value of the firstFret property.
     * 
     * @param value
     *     allowed object is
     *     {@link FirstFret }
     *     
     */
    public void setFirstFret(FirstFret value) {
        this.firstFret = value;
    }

    /**
     * Gets the value of the frameNote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the frameNote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFrameNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FrameNote }
     * 
     * 
     */
    public List<FrameNote> getFrameNote() {
        if (frameNote == null) {
            frameNote = new ArrayList<FrameNote>();
        }
        return this.frameNote;
    }

    /**
     * Gets the value of the height property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setHeight(java.lang.String value) {
        this.height = value;
    }

    /**
     * Gets the value of the width property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setWidth(java.lang.String value) {
        this.width = value;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setColor(java.lang.String value) {
        this.color = value;
    }

    /**
     * Gets the value of the defaultX property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getDefaultX() {
        return defaultX;
    }

    /**
     * Sets the value of the defaultX property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setDefaultX(java.lang.String value) {
        this.defaultX = value;
    }

    /**
     * Gets the value of the defaultY property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getDefaultY() {
        return defaultY;
    }

    /**
     * Sets the value of the defaultY property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setDefaultY(java.lang.String value) {
        this.defaultY = value;
    }

    /**
     * Gets the value of the relativeX property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getRelativeX() {
        return relativeX;
    }

    /**
     * Sets the value of the relativeX property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setRelativeX(java.lang.String value) {
        this.relativeX = value;
    }

    /**
     * Gets the value of the relativeY property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getRelativeY() {
        return relativeY;
    }

    /**
     * Sets the value of the relativeY property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setRelativeY(java.lang.String value) {
        this.relativeY = value;
    }

}
