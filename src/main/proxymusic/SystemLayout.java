
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
 * System layout includes left and right margins and the
 * vertical distance from the previous system. Margins
 * are relative to the page margins. Positive values
 * indent and negative values reduce the margin size.
 * The system distance is measured from the bottom line
 * of the previous system to the top line of the current
 * system. It is ignored for the first system on a page.
 * The top system distance is measured from the page's
 * top margin to the top line of the first system. It is
 * ignored for all but the first system on a page.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}system-margins" minOccurs="0"/>
 *         &lt;element ref="{}system-distance" minOccurs="0"/>
 *         &lt;element ref="{}top-system-distance" minOccurs="0"/>
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
    "systemMargins",
    "systemDistance",
    "topSystemDistance"
})
@XmlRootElement(name = "system-layout")
public class SystemLayout {

    @XmlElement(name = "system-margins")
    protected SystemMargins systemMargins;
    @XmlElement(name = "system-distance")
    protected SystemDistance systemDistance;
    @XmlElement(name = "top-system-distance")
    protected TopSystemDistance topSystemDistance;

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
     *     {@link SystemDistance }
     *     
     */
    public SystemDistance getSystemDistance() {
        return systemDistance;
    }

    /**
     * Sets the value of the systemDistance property.
     * 
     * @param value
     *     allowed object is
     *     {@link SystemDistance }
     *     
     */
    public void setSystemDistance(SystemDistance value) {
        this.systemDistance = value;
    }

    /**
     * Gets the value of the topSystemDistance property.
     * 
     * @return
     *     possible object is
     *     {@link TopSystemDistance }
     *     
     */
    public TopSystemDistance getTopSystemDistance() {
        return topSystemDistance;
    }

    /**
     * Sets the value of the topSystemDistance property.
     * 
     * @param value
     *     allowed object is
     *     {@link TopSystemDistance }
     *     
     */
    public void setTopSystemDistance(TopSystemDistance value) {
        this.topSystemDistance = value;
    }

}
