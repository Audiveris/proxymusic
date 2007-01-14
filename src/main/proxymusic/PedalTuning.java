
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
 *         &lt;element ref="{}pedal-step"/>
 *         &lt;element ref="{}pedal-alter"/>
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
    "pedalStep",
    "pedalAlter"
})
@XmlRootElement(name = "pedal-tuning")
public class PedalTuning {

    @XmlElement(name = "pedal-step", required = true)
    protected PedalStep pedalStep;
    @XmlElement(name = "pedal-alter", required = true)
    protected PedalAlter pedalAlter;

    /**
     * Gets the value of the pedalStep property.
     * 
     * @return
     *     possible object is
     *     {@link PedalStep }
     *     
     */
    public PedalStep getPedalStep() {
        return pedalStep;
    }

    /**
     * Sets the value of the pedalStep property.
     * 
     * @param value
     *     allowed object is
     *     {@link PedalStep }
     *     
     */
    public void setPedalStep(PedalStep value) {
        this.pedalStep = value;
    }

    /**
     * Gets the value of the pedalAlter property.
     * 
     * @return
     *     possible object is
     *     {@link PedalAlter }
     *     
     */
    public PedalAlter getPedalAlter() {
        return pedalAlter;
    }

    /**
     * Sets the value of the pedalAlter property.
     * 
     * @param value
     *     allowed object is
     *     {@link PedalAlter }
     *     
     */
    public void setPedalAlter(PedalAlter value) {
        this.pedalAlter = value;
    }

}
