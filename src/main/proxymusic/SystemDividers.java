
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The system-dividers element indicates the presence or absence of system dividers (also known as system separation marks) between systems displayed on the same page. Dividers on the left and right side of the page are controlled by the left-divider and right-divider elements respectively. The default vertical position is half the system-distance value from the top of the system that is below the divider. The default horizontal position is the left and right system margin, respectively.
 * 
 * When used in the print element, the system-dividers element affects the dividers that would appear between the current system and the previous system.
 * 
 * <p>Java class for system-dividers complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="system-dividers">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="left-divider" type="{}empty-print-object-style-align"/>
 *         &lt;element name="right-divider" type="{}empty-print-object-style-align"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "system-dividers", propOrder = {
    "leftDivider",
    "rightDivider"
})
public class SystemDividers {

    @XmlElement(name = "left-divider", required = true)
    protected EmptyPrintObjectStyleAlign leftDivider;
    @XmlElement(name = "right-divider", required = true)
    protected EmptyPrintObjectStyleAlign rightDivider;

    /**
     * Gets the value of the leftDivider property.
     * 
     * @return
     *     possible object is
     *     {@link EmptyPrintObjectStyleAlign }
     *     
     */
    public EmptyPrintObjectStyleAlign getLeftDivider() {
        return leftDivider;
    }

    /**
     * Sets the value of the leftDivider property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmptyPrintObjectStyleAlign }
     *     
     */
    public void setLeftDivider(EmptyPrintObjectStyleAlign value) {
        this.leftDivider = value;
    }

    /**
     * Gets the value of the rightDivider property.
     * 
     * @return
     *     possible object is
     *     {@link EmptyPrintObjectStyleAlign }
     *     
     */
    public EmptyPrintObjectStyleAlign getRightDivider() {
        return rightDivider;
    }

    /**
     * Sets the value of the rightDivider property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmptyPrintObjectStyleAlign }
     *     
     */
    public void setRightDivider(EmptyPrintObjectStyleAlign value) {
        this.rightDivider = value;
    }

}
