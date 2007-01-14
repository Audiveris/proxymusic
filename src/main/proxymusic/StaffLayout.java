
package proxymusic;

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
 * Staff layout includes the vertical distance from
 * the bottom line of the previous staff in this system
 * to the top line of the staff specified by the number
 * attribute. The first staff of the part is used if
 * the number attribute is missing. When used in the
 * defaults element, the values apply to all parts.
 * This value is ignored for the first staff in a system.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}staff-distance" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="number" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "staffDistance"
})
@XmlRootElement(name = "staff-layout")
public class StaffLayout {

    @XmlElement(name = "staff-distance")
    protected StaffDistance staffDistance;
    @XmlAttribute
    protected java.lang.String number;

    /**
     * Gets the value of the staffDistance property.
     * 
     * @return
     *     possible object is
     *     {@link StaffDistance }
     *     
     */
    public StaffDistance getStaffDistance() {
        return staffDistance;
    }

    /**
     * Sets the value of the staffDistance property.
     * 
     * @param value
     *     allowed object is
     *     {@link StaffDistance }
     *     
     */
    public void setStaffDistance(StaffDistance value) {
        this.staffDistance = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getNumber() {
        return number;
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

}
