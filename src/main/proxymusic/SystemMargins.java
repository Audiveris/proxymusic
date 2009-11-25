
package proxymusic;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * System margins are relative to the page margins. Positive values indent and negative values reduce the margin size.
 * 
 * <p>Java class for system-margins complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="system-margins">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;group ref="{}left-right-margins"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "system-margins", propOrder = {
    "leftMargin",
    "rightMargin"
})
public class SystemMargins {

    @XmlElement(name = "left-margin", required = true)
    protected BigDecimal leftMargin;
    @XmlElement(name = "right-margin", required = true)
    protected BigDecimal rightMargin;

    /**
     * Gets the value of the leftMargin property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLeftMargin() {
        return leftMargin;
    }

    /**
     * Sets the value of the leftMargin property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLeftMargin(BigDecimal value) {
        this.leftMargin = value;
    }

    /**
     * Gets the value of the rightMargin property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRightMargin() {
        return rightMargin;
    }

    /**
     * Sets the value of the rightMargin property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRightMargin(BigDecimal value) {
        this.rightMargin = value;
    }

}
