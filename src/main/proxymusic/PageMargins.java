
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
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}left-margin"/>
 *         &lt;element ref="{}right-margin"/>
 *         &lt;element ref="{}top-margin"/>
 *         &lt;element ref="{}bottom-margin"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="odd"/>
 *             &lt;enumeration value="even"/>
 *             &lt;enumeration value="both"/>
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
@XmlType(name = "", propOrder = {
    "leftMargin",
    "rightMargin",
    "topMargin",
    "bottomMargin"
})
@XmlRootElement(name = "page-margins")
public class PageMargins {

    @XmlElement(name = "left-margin", required = true)
    protected LeftMargin leftMargin;
    @XmlElement(name = "right-margin", required = true)
    protected RightMargin rightMargin;
    @XmlElement(name = "top-margin", required = true)
    protected TopMargin topMargin;
    @XmlElement(name = "bottom-margin", required = true)
    protected BottomMargin bottomMargin;
    @XmlAttribute
    protected java.lang.String type;

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

    /**
     * Gets the value of the topMargin property.
     * 
     * @return
     *     possible object is
     *     {@link TopMargin }
     *     
     */
    public TopMargin getTopMargin() {
        return topMargin;
    }

    /**
     * Sets the value of the topMargin property.
     * 
     * @param value
     *     allowed object is
     *     {@link TopMargin }
     *     
     */
    public void setTopMargin(TopMargin value) {
        this.topMargin = value;
    }

    /**
     * Gets the value of the bottomMargin property.
     * 
     * @return
     *     possible object is
     *     {@link BottomMargin }
     *     
     */
    public BottomMargin getBottomMargin() {
        return bottomMargin;
    }

    /**
     * Sets the value of the bottomMargin property.
     * 
     * @param value
     *     allowed object is
     *     {@link BottomMargin }
     *     
     */
    public void setBottomMargin(BottomMargin value) {
        this.bottomMargin = value;
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

}
