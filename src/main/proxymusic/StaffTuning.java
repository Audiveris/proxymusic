
package proxymusic;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The staff-tuning type specifies the open, non-capo tuning of the lines on a tabluature staff. 
 * 
 * <p>Java class for staff-tuning complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="staff-tuning">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;group ref="{}tuning"/>
 *       &lt;attribute name="line" type="{}staff-line" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "staff-tuning", propOrder = {
    "tuningStep",
    "tuningAlter",
    "tuningOctave"
})
public class StaffTuning {

    @XmlElement(name = "tuning-step", required = true)
    protected Step tuningStep;
    @XmlElement(name = "tuning-alter")
    protected BigDecimal tuningAlter;
    @XmlElement(name = "tuning-octave")
    protected int tuningOctave;
    @XmlAttribute
    protected BigInteger line;

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
     * Gets the value of the line property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLine() {
        return line;
    }

    /**
     * Sets the value of the line property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLine(BigInteger value) {
        this.line = value;
    }

}
