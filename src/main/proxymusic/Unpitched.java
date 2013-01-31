
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The unpitched type represents musical elements that are notated on the staff but lack definite pitch, such as unpitched percussion and speaking voice.
 * 
 * <p>Java class for unpitched complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="unpitched">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{}display-step-octave" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "unpitched", propOrder = {
    "displayStep",
    "displayOctave"
})
public class Unpitched {

    @XmlElement(name = "display-step")
    protected Step displayStep;
    @XmlElement(name = "display-octave")
    protected Integer displayOctave;

    /**
     * Gets the value of the displayStep property.
     * 
     * @return
     *     possible object is
     *     {@link Step }
     *     
     */
    public Step getDisplayStep() {
        return displayStep;
    }

    /**
     * Sets the value of the displayStep property.
     * 
     * @param value
     *     allowed object is
     *     {@link Step }
     *     
     */
    public void setDisplayStep(Step value) {
        this.displayStep = value;
    }

    /**
     * Gets the value of the displayOctave property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDisplayOctave() {
        return displayOctave;
    }

    /**
     * Sets the value of the displayOctave property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDisplayOctave(Integer value) {
        this.displayOctave = value;
    }

}
