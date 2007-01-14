
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * Slur elements are empty. Most slurs are represented
 * with two elements: one with a start type, and one
 * with a stop type. Very complex slurs can add more
 * elements using a continue type.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attGroup ref="{}line-type"/>
 *       &lt;attGroup ref="{}orientation"/>
 *       &lt;attGroup ref="{}position"/>
 *       &lt;attGroup ref="{}bezier"/>
 *       &lt;attGroup ref="{}placement"/>
 *       &lt;attGroup ref="{}color"/>
 *       &lt;attribute name="number" default="1">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="1"/>
 *             &lt;enumeration value="2"/>
 *             &lt;enumeration value="3"/>
 *             &lt;enumeration value="4"/>
 *             &lt;enumeration value="5"/>
 *             &lt;enumeration value="6"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="type" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="start"/>
 *             &lt;enumeration value="stop"/>
 *             &lt;enumeration value="continue"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "slur")
public class Slur {

    @XmlAttribute
    protected java.lang.String number;
    @XmlAttribute(required = true)
    protected java.lang.String type;
    @XmlAttribute(name = "line-type")
    protected java.lang.String lineType;
    @XmlAttribute
    protected java.lang.String orientation;
    @XmlAttribute(name = "default-x")
    protected java.lang.String defaultX;
    @XmlAttribute(name = "default-y")
    protected java.lang.String defaultY;
    @XmlAttribute(name = "relative-x")
    protected java.lang.String relativeX;
    @XmlAttribute(name = "relative-y")
    protected java.lang.String relativeY;
    @XmlAttribute(name = "bezier-offset")
    protected java.lang.String bezierOffset;
    @XmlAttribute(name = "bezier-offset2")
    protected java.lang.String bezierOffset2;
    @XmlAttribute(name = "bezier-x")
    protected java.lang.String bezierX;
    @XmlAttribute(name = "bezier-x2")
    protected java.lang.String bezierX2;
    @XmlAttribute(name = "bezier-y")
    protected java.lang.String bezierY;
    @XmlAttribute(name = "bezier-y2")
    protected java.lang.String bezierY2;
    @XmlAttribute
    protected java.lang.String placement;
    @XmlAttribute
    protected java.lang.String color;

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getNumber() {
        if (number == null) {
            return "1";
        } else {
            return number;
        }
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setNumber(java.lang.String value) {
        this.number = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setType(java.lang.String value) {
        this.type = value;
    }

    /**
     * Gets the value of the lineType property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getLineType() {
        return lineType;
    }

    /**
     * Sets the value of the lineType property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setLineType(java.lang.String value) {
        this.lineType = value;
    }

    /**
     * Gets the value of the orientation property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getOrientation() {
        return orientation;
    }

    /**
     * Sets the value of the orientation property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setOrientation(java.lang.String value) {
        this.orientation = value;
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

    /**
     * Gets the value of the bezierOffset property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getBezierOffset() {
        return bezierOffset;
    }

    /**
     * Sets the value of the bezierOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setBezierOffset(java.lang.String value) {
        this.bezierOffset = value;
    }

    /**
     * Gets the value of the bezierOffset2 property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getBezierOffset2() {
        return bezierOffset2;
    }

    /**
     * Sets the value of the bezierOffset2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setBezierOffset2(java.lang.String value) {
        this.bezierOffset2 = value;
    }

    /**
     * Gets the value of the bezierX property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getBezierX() {
        return bezierX;
    }

    /**
     * Sets the value of the bezierX property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setBezierX(java.lang.String value) {
        this.bezierX = value;
    }

    /**
     * Gets the value of the bezierX2 property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getBezierX2() {
        return bezierX2;
    }

    /**
     * Sets the value of the bezierX2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setBezierX2(java.lang.String value) {
        this.bezierX2 = value;
    }

    /**
     * Gets the value of the bezierY property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getBezierY() {
        return bezierY;
    }

    /**
     * Sets the value of the bezierY property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setBezierY(java.lang.String value) {
        this.bezierY = value;
    }

    /**
     * Gets the value of the bezierY2 property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getBezierY2() {
        return bezierY2;
    }

    /**
     * Sets the value of the bezierY2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setBezierY2(java.lang.String value) {
        this.bezierY2 = value;
    }

    /**
     * Gets the value of the placement property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPlacement() {
        return placement;
    }

    /**
     * Sets the value of the placement property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPlacement(java.lang.String value) {
        this.placement = value;
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
