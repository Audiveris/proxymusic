
package proxymusic;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The accord type represents the tuning of a single string in the scordatura element. It uses the same group of elements as the staff-tuning element. Strings are numbered from high to low.
 * 
 * <p>Java class for accord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accord">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;group ref="{}tuning"/>
 *       &lt;attribute name="string" type="{}string-number" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accord", propOrder = {
    "tuningStep",
    "tuningAlter",
    "tuningOctave"
})
public class Accord {

    @XmlElement(name = "tuning-step", required = true)
    protected Step tuningStep;
    @XmlElement(name = "tuning-alter")
    protected BigDecimal tuningAlter;
    @XmlElement(name = "tuning-octave")
    protected int tuningOctave;
    @XmlAttribute
    protected BigInteger string;

    /**
     * Gets the value of the tuningStep property.
     * 
     * @return
     *     possible object is
     *     {@link Step }
     *     
     */
    public Step getTuningStep() {
        return tuningStep;
    }

    /**
     * Sets the value of the tuningStep property.
     * 
     * @param value
     *     allowed object is
     *     {@link Step }
     *     
     */
    public void setTuningStep(Step value) {
        this.tuningStep = value;
    }

    /**
     * Gets the value of the tuningAlter property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTuningAlter() {
        return tuningAlter;
    }

    /**
     * Sets the value of the tuningAlter property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTuningAlter(BigDecimal value) {
        this.tuningAlter = value;
    }

    /**
     * Gets the value of the tuningOctave property.
     * 
     */
    public int getTuningOctave() {
        return tuningOctave;
    }

    /**
     * Sets the value of the tuningOctave property.
     * 
     */
    public void setTuningOctave(int value) {
        this.tuningOctave = value;
    }

    /**
     * Gets the value of the string property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getString() {
        return string;
    }

    /**
     * Sets the value of the string property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setString(BigInteger value) {
        this.string = value;
    }

}
