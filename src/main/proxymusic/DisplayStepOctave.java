
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The display-step-octave type contains the sequence of elements used by both the rest and unpitched elements. This group is used to place rests and unpitched elements on the staff without implying that these elements have pitch. Positioning follows the current clef. If percussion clef is used, the display-step and display-octave elements are interpreted as if in treble clef, with a G in octave 4 on line 2. If not present, the note is placed on the middle line of the staff, generally used for one-line staffs.
 * 
 * <p>Java class for display-step-octave complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="display-step-octave">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="display-step" type="{}step"/>
 *         &lt;element name="display-octave" type="{}octave"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "display-step-octave", propOrder = {
    "displayStep",
    "displayOctave"
})
public class DisplayStepOctave {

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
