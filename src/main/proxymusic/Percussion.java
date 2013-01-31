
package proxymusic;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The percussion element is used to define percussion pictogram symbols. Definitions for these symbols can be found in Kurt Stone's "Music Notation in the Twentieth Century" on pages 206-212 and 223. Some values are added to these based on how usage has evolved in the 30 years since Stone's book was published.
 * 
 * <p>Java class for percussion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="percussion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="glass" type="{}glass"/>
 *         &lt;element name="metal" type="{}metal"/>
 *         &lt;element name="wood" type="{}wood"/>
 *         &lt;element name="pitched" type="{}pitched"/>
 *         &lt;element name="membrane" type="{}membrane"/>
 *         &lt;element name="effect" type="{}effect"/>
 *         &lt;element name="timpani" type="{}empty"/>
 *         &lt;element name="beater" type="{}beater"/>
 *         &lt;element name="stick" type="{}stick"/>
 *         &lt;element name="stick-location" type="{}stick-location"/>
 *         &lt;element name="other-percussion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/choice>
 *       &lt;attGroup ref="{}print-style-align"/>
 *       &lt;attGroup ref="{}enclosure"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "percussion", propOrder = {
    "glass",
    "metal",
    "wood",
    "pitched",
    "membrane",
    "effect",
    "timpani",
    "beater",
    "stick",
    "stickLocation",
    "otherPercussion"
})
public class Percussion {

    protected Glass glass;
    protected Metal metal;
    protected Wood wood;
    protected Pitched pitched;
    protected Membrane membrane;
    protected Effect effect;
    protected Empty timpani;
    protected Beater beater;
    protected Stick stick;
    @XmlElement(name = "stick-location")
    protected StickLocation stickLocation;
    @XmlElement(name = "other-percussion")
    protected java.lang.String otherPercussion;
    @XmlAttribute(name = "halign")
    protected LeftCenterRight halign;
    @XmlAttribute(name = "valign")
    protected Valign valign;
    @XmlAttribute(name = "color")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String color;
    @XmlAttribute(name = "default-x")
    protected BigDecimal defaultX;
    @XmlAttribute(name = "default-y")
    protected BigDecimal defaultY;
    @XmlAttribute(name = "relative-x")
    protected BigDecimal relativeX;
    @XmlAttribute(name = "relative-y")
    protected BigDecimal relativeY;
    @XmlAttribute(name = "font-family")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String fontFamily;
    @XmlAttribute(name = "font-style")
    protected FontStyle fontStyle;
    @XmlAttribute(name = "font-size")
    protected java.lang.String fontSize;
    @XmlAttribute(name = "font-weight")
    protected FontWeight fontWeight;
    @XmlAttribute(name = "enclosure")
    protected EnclosureShape enclosure;

    /**
     * Gets the value of the glass property.
     * 
     * @return
     *     possible object is
     *     {@link Glass }
     *     
     */
    public Glass getGlass() {
        return glass;
    }

    /**
     * Sets the value of the glass property.
     * 
     * @param value
     *     allowed object is
     *     {@link Glass }
     *     
     */
    public void setGlass(Glass value) {
        this.glass = value;
    }

    /**
     * Gets the value of the metal property.
     * 
     * @return
     *     possible object is
     *     {@link Metal }
     *     
     */
    public Metal getMetal() {
        return metal;
    }

    /**
     * Sets the value of the metal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Metal }
     *     
     */
    public void setMetal(Metal value) {
        this.metal = value;
    }

    /**
     * Gets the value of the wood property.
     * 
     * @return
     *     possible object is
     *     {@link Wood }
     *     
     */
    public Wood getWood() {
        return wood;
    }

    /**
     * Sets the value of the wood property.
     * 
     * @param value
     *     allowed object is
     *     {@link Wood }
     *     
     */
    public void setWood(Wood value) {
        this.wood = value;
    }

    /**
     * Gets the value of the pitched property.
     * 
     * @return
     *     possible object is
     *     {@link Pitched }
     *     
     */
    public Pitched getPitched() {
        return pitched;
    }

    /**
     * Sets the value of the pitched property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pitched }
     *     
     */
    public void setPitched(Pitched value) {
        this.pitched = value;
    }

    /**
     * Gets the value of the membrane property.
     * 
     * @return
     *     possible object is
     *     {@link Membrane }
     *     
     */
    public Membrane getMembrane() {
        return membrane;
    }

    /**
     * Sets the value of the membrane property.
     * 
     * @param value
     *     allowed object is
     *     {@link Membrane }
     *     
     */
    public void setMembrane(Membrane value) {
        this.membrane = value;
    }

    /**
     * Gets the value of the effect property.
     * 
     * @return
     *     possible object is
     *     {@link Effect }
     *     
     */
    public Effect getEffect() {
        return effect;
    }

    /**
     * Sets the value of the effect property.
     * 
     * @param value
     *     allowed object is
     *     {@link Effect }
     *     
     */
    public void setEffect(Effect value) {
        this.effect = value;
    }

    /**
     * Gets the value of the timpani property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getTimpani() {
        return timpani;
    }

    /**
     * Sets the value of the timpani property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setTimpani(Empty value) {
        this.timpani = value;
    }

    /**
     * Gets the value of the beater property.
     * 
     * @return
     *     possible object is
     *     {@link Beater }
     *     
     */
    public Beater getBeater() {
        return beater;
    }

    /**
     * Sets the value of the beater property.
     * 
     * @param value
     *     allowed object is
     *     {@link Beater }
     *     
     */
    public void setBeater(Beater value) {
        this.beater = value;
    }

    /**
     * Gets the value of the stick property.
     * 
     * @return
     *     possible object is
     *     {@link Stick }
     *     
     */
    public Stick getStick() {
        return stick;
    }

    /**
     * Sets the value of the stick property.
     * 
     * @param value
     *     allowed object is
     *     {@link Stick }
     *     
     */
    public void setStick(Stick value) {
        this.stick = value;
    }

    /**
     * Gets the value of the stickLocation property.
     * 
     * @return
     *     possible object is
     *     {@link StickLocation }
     *     
     */
    public StickLocation getStickLocation() {
        return stickLocation;
    }

    /**
     * Sets the value of the stickLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link StickLocation }
     *     
     */
    public void setStickLocation(StickLocation value) {
        this.stickLocation = value;
    }

    /**
     * Gets the value of the otherPercussion property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getOtherPercussion() {
        return otherPercussion;
    }

    /**
     * Sets the value of the otherPercussion property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setOtherPercussion(java.lang.String value) {
        this.otherPercussion = value;
    }

    /**
     * Gets the value of the halign property.
     * 
     * @return
     *     possible object is
     *     {@link LeftCenterRight }
     *     
     */
    public LeftCenterRight getHalign() {
        return halign;
    }

    /**
     * Sets the value of the halign property.
     * 
     * @param value
     *     allowed object is
     *     {@link LeftCenterRight }
     *     
     */
    public void setHalign(LeftCenterRight value) {
        this.halign = value;
    }

    /**
     * Gets the value of the valign property.
     * 
     * @return
     *     possible object is
     *     {@link Valign }
     *     
     */
    public Valign getValign() {
        return valign;
    }

    /**
     * Sets the value of the valign property.
     * 
     * @param value
     *     allowed object is
     *     {@link Valign }
     *     
     */
    public void setValign(Valign value) {
        this.valign = value;
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
     * Gets the value of the enclosure property.
     * 
     * @return
     *     possible object is
     *     {@link EnclosureShape }
     *     
     */
    public EnclosureShape getEnclosure() {
        return enclosure;
    }

    /**
     * Sets the value of the enclosure property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnclosureShape }
     *     
     */
    public void setEnclosure(EnclosureShape value) {
        this.enclosure = value;
    }

}
