
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}left-margin"/>
 *         &lt;element ref="{}right-margin"/>
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
    "leftMargin",
    "rightMargin"
})
@XmlRootElement(name = "system-margins")
public class SystemMargins {

    @XmlElement(name = "left-margin", required = true)
    protected LeftMargin leftMargin;
    @XmlElement(name = "right-margin", required = true)
    protected RightMargin rightMargin;

    /**
     * Gets the value of the leftMargin property.
     * 
     * @return
     *     possible object is
     *     {@link LeftMargin }
     *     
     */
    public LeftMargin getLeftMargin() {
        return leftMargin;
    }

    /**
     * Sets the value of the leftMargin property.
     * 
     * @param value
     *     allowed object is
     *     {@link LeftMargin }
     *     
     */
    public void setLeftMargin(LeftMargin value) {
        this.leftMargin = value;
    }

    /**
     * Gets the value of the rightMargin property.
     * 
     * @return
     *     possible object is
     *     {@link RightMargin }
     *     
     */
    public RightMargin getRightMargin() {
        return rightMargin;
    }

    /**
     * Sets the value of the rightMargin property.
     * 
     * @param value
     *     allowed object is
     *     {@link RightMargin }
     *     
     */
    public void setRightMargin(RightMargin value) {
        this.rightMargin = value;
    }

}
