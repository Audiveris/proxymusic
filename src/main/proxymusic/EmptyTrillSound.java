
package proxymusic;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The empty-trill-sound type represents an empty element with print-style, placement, and trill-sound attributes.
 * 
 * <p>Java class for empty-trill-sound complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="empty-trill-sound">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attGroup ref="{}print-style"/>
 *       &lt;attGroup ref="{}placement"/>
 *       &lt;attGroup ref="{}trill-sound"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "empty-trill-sound")
@XmlSeeAlso({
    Mordent.class
})
public class EmptyTrillSound {

    @XmlAttribute(name = "font-family")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String fontFamily;
    @XmlAttribute(name = "font-style")
    protected FontStyle fontStyle;
    @XmlAttribute(name = "font-size")
    protected java.lang.String fontSize;
    @XmlAttribute(name = "font-weight")
    protected FontWeight fontWeight;
    @XmlAttribute(name = "default-x")
    protected BigDecimal defaultX;
    @XmlAttribute(name = "default-y")
    protected BigDecimal defaultY;
    @XmlAttribute(name = "relative-x")
    protected BigDecimal relativeX;
    @XmlAttribute(name = "relative-y")
    protected BigDecimal relativeY;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String color;
    @XmlAttribute
    protected AboveBelow placement;
    @XmlAttribute(name = "start-note")
    protected StartNote startNote;
    @XmlAttribute(name = "trill-step")
    protected TrillStep trillStep;
    @XmlAttribute(name = "two-note-turn")
    protected TwoNoteTurn twoNoteTurn;
    @XmlAttribute
    protected YesNo accelerate;
    @XmlAttribute
    protected BigDecimal beats;
    @XmlAttribute(name = "second-beat")
    protected BigDecimal secondBeat;
    @XmlAttribute(name = "last-beat")
    protected BigDecimal lastBeat;

    /**
     * Gets the value of the fontFamily property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getFontFamily() {
        return fontFamily;
    }

    /**
     * Sets the value of the fontFamily property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setFontFamily(java.lang.String value) {
        this.fontFamily = value;
    }

    /**
     * Gets the value of the fontStyle property.
     * 
     * @return
     *     possible object is
     *     {@link FontStyle }
     *     
     */
    public FontStyle getFontStyle() {
        return fontStyle;
    }

    /**
     * Sets the value of the fontStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link FontStyle }
     *     
     */
    public void setFontStyle(FontStyle value) {
        this.fontStyle = value;
    }

    /**
     * Gets the value of the fontSize property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getFontSize() {
        return fontSize;
    }

    /**
     * Sets the value of the fontSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setFontSize(java.lang.String value) {
        this.fontSize = value;
    }

    /**
     * Gets the value of the fontWeight property.
     * 
     * @return
     *     possible object is
     *     {@link FontWeight }
     *     
     */
    public FontWeight getFontWeight() {
        return fontWeight;
    }

    /**
     * Sets the value of the fontWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link FontWeight }
     *     
     */
    public void setFontWeight(FontWeight value) {
        this.fontWeight = value;
    }

    /**
     * Gets the value of the defaultX property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDefaultX() {
        return defaultX;
    }

    /**
     * Sets the value of the defaultX property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDefaultX(BigDecimal value) {
        this.defaultX = value;
    }

    /**
     * Gets the value of the defaultY property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDefaultY() {
        return defaultY;
    }

    /**
     * Sets the value of the defaultY property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDefaultY(BigDecimal value) {
        this.defaultY = value;
    }

    /**
     * Gets the value of the relativeX property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRelativeX() {
        return relativeX;
    }

    /**
     * Sets the value of the relativeX property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRelativeX(BigDecimal value) {
        this.relativeX = value;
    }

    /**
     * Gets the value of the relativeY property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRelativeY() {
        return relativeY;
    }

    /**
     * Sets the value of the relativeY property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRelativeY(BigDecimal value) {
        this.relativeY = value;
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
     * Gets the value of the placement property.
     * 
     * @return
     *     possible object is
     *     {@link AboveBelow }
     *     
     */
    public AboveBelow getPlacement() {
        return placement;
    }

    /**
     * Sets the value of the placement property.
     * 
     * @param value
     *     allowed object is
     *     {@link AboveBelow }
     *     
     */
    public void setPlacement(AboveBelow value) {
        this.placement = value;
    }

    /**
     * Gets the value of the startNote property.
     * 
     * @return
     *     possible object is
     *     {@link StartNote }
     *     
     */
    public StartNote getStartNote() {
        return startNote;
    }

    /**
     * Sets the value of the startNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link StartNote }
     *     
     */
    public void setStartNote(StartNote value) {
        this.startNote = value;
    }

    /**
     * Gets the value of the trillStep property.
     * 
     * @return
     *     possible object is
     *     {@link TrillStep }
     *     
     */
    public TrillStep getTrillStep() {
        return trillStep;
    }

    /**
     * Sets the value of the trillStep property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrillStep }
     *     
     */
    public void setTrillStep(TrillStep value) {
        this.trillStep = value;
    }

    /**
     * Gets the value of the twoNoteTurn property.
     * 
     * @return
     *     possible object is
     *     {@link TwoNoteTurn }
     *     
     */
    public TwoNoteTurn getTwoNoteTurn() {
        return twoNoteTurn;
    }

    /**
     * Sets the value of the twoNoteTurn property.
     * 
     * @param value
     *     allowed object is
     *     {@link TwoNoteTurn }
     *     
     */
    public void setTwoNoteTurn(TwoNoteTurn value) {
        this.twoNoteTurn = value;
    }

    /**
     * Gets the value of the accelerate property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getAccelerate() {
        return accelerate;
    }

    /**
     * Sets the value of the accelerate property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setAccelerate(YesNo value) {
        this.accelerate = value;
    }

    /**
     * Gets the value of the beats property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBeats() {
        return beats;
    }

    /**
     * Sets the value of the beats property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBeats(BigDecimal value) {
        this.beats = value;
    }

    /**
     * Gets the value of the secondBeat property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSecondBeat() {
        return secondBeat;
    }

    /**
     * Sets the value of the secondBeat property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSecondBeat(BigDecimal value) {
        this.secondBeat = value;
    }

    /**
     * Gets the value of the lastBeat property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLastBeat() {
        return lastBeat;
    }

    /**
     * Sets the value of the lastBeat property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLastBeat(BigDecimal value) {
        this.lastBeat = value;
    }

}
