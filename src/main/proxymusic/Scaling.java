
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * Margins, page sizes, and distances are all measured in
 * tenths to keep MusicXML data in a consistent coordinate
 * system as much as possible. The translation to absolute
 * units is done in the scaling element, which specifies
 * how many millimeters are equal to how many tenths. For
 * a staff height of 7 mm, millimeters would be set to 7
 * while tenths is set to 40. The ability to set a formula
 * rather than a single scaling factor helps avoid roundoff
 * errors.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}millimeters"/>
 *         &lt;element ref="{}tenths"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "millimeters",
    "tenths"
})
@XmlRootElement(name = "scaling")
public class Scaling {

    @XmlElement(required = true)
    protected Millimeters millimeters;
    @XmlElement(required = true)
    protected Tenths tenths;

    /**
     * Gets the value of the millimeters property.
     * 
     * @return
     *     possible object is
     *     {@link Millimeters }
     *     
     */
    public Millimeters getMillimeters() {
        return millimeters;
    }

    /**
     * Sets the value of the millimeters property.
     * 
     * @param value
     *     allowed object is
     *     {@link Millimeters }
     *     
     */
    public void setMillimeters(Millimeters value) {
        this.millimeters = value;
    }

    /**
     * Gets the value of the tenths property.
     * 
     * @return
     *     possible object is
     *     {@link Tenths }
     *     
     */
    public Tenths getTenths() {
        return tenths;
    }

    /**
     * Sets the value of the tenths property.
     * 
     * @param value
     *     allowed object is
     *     {@link Tenths }
     *     
     */
    public void setTenths(Tenths value) {
        this.tenths = value;
    }

}
