
package proxymusic;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * System layout includes left and right margins and the vertical distance from the previous system. The system distance is measured from the bottom line of the previous system to the top line of the current system. It is ignored for the first system on a page. The top system distance is measured from the page's top margin to the top line of the first system. It is ignored for all but the first system on a page.
 * 	
 * Sometimes the sum of measure widths in a system may not equal the system width specified by the layout elements due to roundoff or other errors. The behavior when reading MusicXML files in these cases is application-dependent. For instance, applications may find that the system layout data is more reliable than the sum of the measure widths, and adjust the measure widths accordingly.
 * 
 * <p>Java class for system-layout complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="system-layout">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="system-margins" type="{}system-margins" minOccurs="0"/>
 *         &lt;element name="system-distance" type="{}tenths" minOccurs="0"/>
 *         &lt;element name="top-system-distance" type="{}tenths" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "system-layout", propOrder = {
    "systemMargins",
    "systemDistance",
    "topSystemDistance"
})
public class SystemLayout {

    @XmlElement(name = "system-margins")
    protected SystemMargins systemMargins;
    @XmlElement(name = "system-distance")
    protected BigDecimal systemDistance;
    @XmlElement(name = "top-system-distance")
    protected BigDecimal topSystemDistance;

    /**
     * Gets the value of the systemMargins property.
     * 
     * @return
     *     possible object is
     *     {@link SystemMargins }
     *     
     */
    public SystemMargins getSystemMargins() {
        return systemMargins;
    }

    /**
     * Sets the value of the systemMargins property.
     * 
     * @param value
     *     allowed object is
     *     {@link SystemMargins }
     *     
     */
    public void setSystemMargins(SystemMargins value) {
        this.systemMargins = value;
    }

    /**
     * Gets the value of the systemDistance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSystemDistance() {
        return systemDistance;
    }

    /**
     * Sets the value of the systemDistance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSystemDistance(BigDecimal value) {
        this.systemDistance = value;
    }

    /**
     * Gets the value of the topSystemDistance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTopSystemDistance() {
        return topSystemDistance;
    }

    /**
     * Sets the value of the topSystemDistance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTopSystemDistance(BigDecimal value) {
        this.topSystemDistance = value;
    }

}
