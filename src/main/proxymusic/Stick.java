
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The stick type represents pictograms where the material of the stick, mallet, or beater is included.
 * 
 * <p>Java class for stick complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stick">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stick-type" type="{}stick-type"/>
 *         &lt;element name="stick-material" type="{}stick-material"/>
 *       &lt;/sequence>
 *       &lt;attribute name="tip" type="{}tip-direction" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stick", propOrder = {
    "stickType",
    "stickMaterial"
})
public class Stick {

    @XmlElement(name = "stick-type", required = true)
    protected StickType stickType;
    @XmlElement(name = "stick-material", required = true)
    protected StickMaterial stickMaterial;
    @XmlAttribute(name = "tip")
    protected TipDirection tip;

    /**
     * Gets the value of the stickType property.
     * 
     * @return
     *     possible object is
     *     {@link StickType }
     *     
     */
    public StickType getStickType() {
        return stickType;
    }

    /**
     * Sets the value of the stickType property.
     * 
     * @param value
     *     allowed object is
     *     {@link StickType }
     *     
     */
    public void setStickType(StickType value) {
        this.stickType = value;
    }

    /**
     * Gets the value of the stickMaterial property.
     * 
     * @return
     *     possible object is
     *     {@link StickMaterial }
     *     
     */
    public StickMaterial getStickMaterial() {
        return stickMaterial;
    }

    /**
     * Sets the value of the stickMaterial property.
     * 
     * @param value
     *     allowed object is
     *     {@link StickMaterial }
     *     
     */
    public void setStickMaterial(StickMaterial value) {
        this.stickMaterial = value;
    }

    /**
     * Gets the value of the tip property.
     * 
     * @return
     *     possible object is
     *     {@link TipDirection }
     *     
     */
    public TipDirection getTip() {
        return tip;
    }

    /**
     * Sets the value of the tip property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipDirection }
     *     
     */
    public void setTip(TipDirection value) {
        this.tip = value;
    }

}
