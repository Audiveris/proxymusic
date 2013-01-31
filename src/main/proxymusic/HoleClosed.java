
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * The hole-closed type represents whether the hole is closed, open, or half-open. The optional location attribute indicates which portion of the hole is filled in when the element value is half.
 * 
 * <p>Java class for hole-closed complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="hole-closed">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;>hole-closed-value">
 *       &lt;attribute name="location" type="{}hole-closed-location" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hole-closed", propOrder = {
    "value"
})
public class HoleClosed {

    @XmlValue
    protected HoleClosedValue value;
    @XmlAttribute(name = "location")
    protected HoleClosedLocation location;

    /**
     * The hole-closed-value type represents whether the hole is closed, open, or half-open.
     * 
     * @return
     *     possible object is
     *     {@link HoleClosedValue }
     *     
     */
    public HoleClosedValue getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link HoleClosedValue }
     *     
     */
    public void setValue(HoleClosedValue value) {
        this.value = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link HoleClosedLocation }
     *     
     */
    public HoleClosedLocation getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link HoleClosedLocation }
     *     
     */
    public void setLocation(HoleClosedLocation value) {
        this.location = value;
    }

}
