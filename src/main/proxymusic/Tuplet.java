
package proxymusic;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A tuplet element is present when a tuplet is to be displayed graphically, in addition to the sound data provided by the time-modification elements. The number attribute is used to distinguish nested tuplets. The bracket attribute is used to indicate the presence of a bracket. If unspecified, the results are implementation-dependent. The line-shape attribute is used to specify whether the bracket is straight or in the older curved or slurred style. It is straight by default.
 * 	
 * Whereas a time-modification element shows how the cumulative, sounding effect of tuplets compare to the written note type, the tuplet element describes how each tuplet is displayed.
 * 	
 * The show-number attribute is used to display either the number of actual notes, the number of both actual and normal notes, or neither. It is actual by default. The show-type attribute is used to display either the actual type, both the actual and normal types, or neither. It is none by default.
 * 
 * <p>Java class for tuplet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tuplet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tuplet-actual" type="{}tuplet-portion" minOccurs="0"/>
 *         &lt;element name="tuplet-normal" type="{}tuplet-portion" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}line-shape"/>
 *       &lt;attGroup ref="{}placement"/>
 *       &lt;attGroup ref="{}position"/>
 *       &lt;attribute name="type" use="required" type="{}start-stop" />
 *       &lt;attribute name="number" type="{}number-level" />
 *       &lt;attribute name="bracket" type="{}yes-no" />
 *       &lt;attribute name="show-number" type="{}show-tuplet" />
 *       &lt;attribute name="show-type" type="{}show-tuplet" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tuplet", propOrder = {
    "tupletActual",
    "tupletNormal"
})
public class Tuplet {

    @XmlElement(name = "tuplet-actual")
    protected TupletPortion tupletActual;
    @XmlElement(name = "tuplet-normal")
    protected TupletPortion tupletNormal;
    @XmlAttribute(required = true)
    protected StartStop type;
    @XmlAttribute
    protected Integer number;
    @XmlAttribute
    protected YesNo bracket;
    @XmlAttribute(name = "show-number")
    protected ShowTuplet showNumber;
    @XmlAttribute(name = "show-type")
    protected ShowTuplet showType;
    @XmlAttribute(name = "line-shape")
    protected LineShape lineShape;
    @XmlAttribute
    protected AboveBelow placement;
    @XmlAttribute(name = "default-x")
    protected BigDecimal defaultX;
    @XmlAttribute(name = "default-y")
    protected BigDecimal defaultY;
    @XmlAttribute(name = "relative-x")
    protected BigDecimal relativeX;
    @XmlAttribute(name = "relative-y")
    protected BigDecimal relativeY;

    /**
     * Gets the value of the tupletActual property.
     * 
     * @return
     *     possible object is
     *     {@link TupletPortion }
     *     
     */
    public TupletPortion getTupletActual() {
        return tupletActual;
    }

    /**
     * Sets the value of the tupletActual property.
     * 
     * @param value
     *     allowed object is
     *     {@link TupletPortion }
     *     
     */
    public void setTupletActual(TupletPortion value) {
        this.tupletActual = value;
    }

    /**
     * Gets the value of the tupletNormal property.
     * 
     * @return
     *     possible object is
     *     {@link TupletPortion }
     *     
     */
    public TupletPortion getTupletNormal() {
        return tupletNormal;
    }

    /**
     * Sets the value of the tupletNormal property.
     * 
     * @param value
     *     allowed object is
     *     {@link TupletPortion }
     *     
     */
    public void setTupletNormal(TupletPortion value) {
        this.tupletNormal = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link StartStop }
     *     
     */
    public StartStop getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link StartStop }
     *     
     */
    public void setType(StartStop value) {
        this.type = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumber(Integer value) {
        this.number = value;
    }

    /**
     * Gets the value of the bracket property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getBracket() {
        return bracket;
    }

    /**
     * Sets the value of the bracket property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setBracket(YesNo value) {
        this.bracket = value;
    }

    /**
     * Gets the value of the showNumber property.
     * 
     * @return
     *     possible object is
     *     {@link ShowTuplet }
     *     
     */
    public ShowTuplet getShowNumber() {
        return showNumber;
    }

    /**
     * Sets the value of the showNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShowTuplet }
     *     
     */
    public void setShowNumber(ShowTuplet value) {
        this.showNumber = value;
    }

    /**
     * Gets the value of the showType property.
     * 
     * @return
     *     possible object is
     *     {@link ShowTuplet }
     *     
     */
    public ShowTuplet getShowType() {
        return showType;
    }

    /**
     * Sets the value of the showType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShowTuplet }
     *     
     */
    public void setShowType(ShowTuplet value) {
        this.showType = value;
    }

    /**
     * Gets the value of the lineShape property.
     * 
     * @return
     *     possible object is
     *     {@link LineShape }
     *     
     */
    public LineShape getLineShape() {
        return lineShape;
    }

    /**
     * Sets the value of the lineShape property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineShape }
     *     
     */
    public void setLineShape(LineShape value) {
        this.lineShape = value;
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

}
