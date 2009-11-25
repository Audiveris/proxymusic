
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The bass type is used to indicate a bass note in popular music chord symbols, e.g. G/C. It is generally not used in functional harmony, as inversion is generally not used in pop chord symbols. As with root, it is divided into step and alter elements, similar to pitches.
 * 
 * <p>Java class for bass complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bass">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bass-step" type="{}bass-step"/>
 *         &lt;element name="bass-alter" type="{}bass-alter" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bass", propOrder = {
    "bassStep",
    "bassAlter"
})
public class Bass {

    @XmlElement(name = "bass-step", required = true)
    protected BassStep bassStep;
    @XmlElement(name = "bass-alter")
    protected BassAlter bassAlter;

    /**
     * Gets the value of the bassStep property.
     * 
     * @return
     *     possible object is
     *     {@link BassStep }
     *     
     */
    public BassStep getBassStep() {
        return bassStep;
    }

    /**
     * Sets the value of the bassStep property.
     * 
     * @param value
     *     allowed object is
     *     {@link BassStep }
     *     
     */
    public void setBassStep(BassStep value) {
        this.bassStep = value;
    }

    /**
     * Gets the value of the bassAlter property.
     * 
     * @return
     *     possible object is
     *     {@link BassAlter }
     *     
     */
    public BassAlter getBassAlter() {
        return bassAlter;
    }

    /**
     * Sets the value of the bassAlter property.
     * 
     * @param value
     *     allowed object is
     *     {@link BassAlter }
     *     
     */
    public void setBassAlter(BassAlter value) {
        this.bassAlter = value;
    }

}
