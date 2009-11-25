
package proxymusic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <B>[JAXB: simplified definition]</B><BR/>The metronome type represents metronome marks and other metric relationships. The beat-unit group and per-minute element specify regular metronome marks. The metronome-note and metronome-relation elements allow for the specification of more complicated metric relationships, such as swing tempo marks where two eighths are equated to a quarter note / eighth note triplet. The parentheses attribute indicates whether or not to put the metronome mark in parentheses; its value is no if not specified. 
 * 
 * <p>Java class for metronome complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="metronome">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;group ref="{}beat-unit" maxOccurs="2"/>
 *           &lt;element name="per-minute" type="{}per-minute"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element name="metronome-note" type="{}metronome-note" maxOccurs="unbounded"/>
 *           &lt;sequence minOccurs="0">
 *             &lt;element name="metronome-relation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *             &lt;element name="related-metronome-note" type="{}metronome-note" maxOccurs="unbounded"/>
 *           &lt;/sequence>
 *         &lt;/sequence>
 *       &lt;/choice>
 *       &lt;attGroup ref="{}print-style"/>
 *       &lt;attribute name="parentheses" type="{}yes-no" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "metronome", propOrder = {
    "beatUnit",
    "perMinute",
    "metronomeNote",
    "metronomeRelation",
    "relatedMetronomeNote"
})
public class Metronome {

    @XmlElements({
        @XmlElement(name = "beat-unit", type = java.lang.String.class),
        @XmlElement(name = "beat-unit-dot", type = Empty.class)
    })
    protected List<Object> beatUnit;
    @XmlElement(name = "per-minute")
    protected PerMinute perMinute;
    @XmlElement(name = "metronome-note")
    protected List<MetronomeNote> metronomeNote;
    @XmlElement(name = "metronome-relation")
    protected java.lang.String metronomeRelation;
    @XmlElement(name = "related-metronome-note")
    protected List<MetronomeNote> relatedMetronomeNote;
    @XmlAttribute
    protected YesNo parentheses;
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

    /**
     * Gets the value of the beatUnit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the beatUnit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBeatUnit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link java.lang.String }
     * {@link Empty }
     * 
     * 
     */
    public List<Object> getBeatUnit() {
        if (beatUnit == null) {
            beatUnit = new ArrayList<Object>();
        }
        return this.beatUnit;
    }

    /**
     * Gets the value of the perMinute property.
     * 
     * @return
     *     possible object is
     *     {@link PerMinute }
     *     
     */
    public PerMinute getPerMinute() {
        return perMinute;
    }

    /**
     * Sets the value of the perMinute property.
     * 
     * @param value
     *     allowed object is
     *     {@link PerMinute }
     *     
     */
    public void setPerMinute(PerMinute value) {
        this.perMinute = value;
    }

    /**
     * Gets the value of the metronomeNote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the metronomeNote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMetronomeNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MetronomeNote }
     * 
     * 
     */
    public List<MetronomeNote> getMetronomeNote() {
        if (metronomeNote == null) {
            metronomeNote = new ArrayList<MetronomeNote>();
        }
        return this.metronomeNote;
    }

    /**
     * Gets the value of the metronomeRelation property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getMetronomeRelation() {
        return metronomeRelation;
    }

    /**
     * Sets the value of the metronomeRelation property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setMetronomeRelation(java.lang.String value) {
        this.metronomeRelation = value;
    }

    /**
     * Gets the value of the relatedMetronomeNote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relatedMetronomeNote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelatedMetronomeNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MetronomeNote }
     * 
     * 
     */
    public List<MetronomeNote> getRelatedMetronomeNote() {
        if (relatedMetronomeNote == null) {
            relatedMetronomeNote = new ArrayList<MetronomeNote>();
        }
        return this.relatedMetronomeNote;
    }

    /**
     * Gets the value of the parentheses property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getParentheses() {
        return parentheses;
    }

    /**
     * Sets the value of the parentheses property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setParentheses(YesNo value) {
        this.parentheses = value;
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

}
