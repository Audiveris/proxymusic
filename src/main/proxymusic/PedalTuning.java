
package proxymusic;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The pedal-tuning type specifies the tuning of a single harp pedal.
 * 
 * <p>Java class for pedal-tuning complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pedal-tuning">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pedal-step" type="{}step"/>
 *         &lt;element name="pedal-alter" type="{}semitones"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pedal-tuning", propOrder = {
    "pedalStep",
    "pedalAlter"
})
public class PedalTuning {

    @XmlElement(name = "pedal-step", required = true)
    protected Step pedalStep;
    @XmlElement(name = "pedal-alter", required = true)
    protected BigDecimal pedalAlter;

    /**
     * Gets the value of the pedalStep property.
     * 
     * @return
     *     possible object is
     *     {@link Step }
     *     
     */
    public Step getPedalStep() {
        return pedalStep;
    }

    /**
     * Sets the value of the pedalStep property.
     * 
     * @param value
     *     allowed object is
     *     {@link Step }
     *     
     */
    public void setPedalStep(Step value) {
        this.pedalStep = value;
    }

    /**
     * Gets the value of the pedalAlter property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPedalAlter() {
        return pedalAlter;
    }

    /**
     * Sets the value of the pedalAlter property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPedalAlter(BigDecimal value) {
        this.pedalAlter = value;
    }

}
