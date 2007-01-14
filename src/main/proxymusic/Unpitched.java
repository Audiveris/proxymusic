
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * The unpitched element indicates musical elements that are
 * notated on the staff but lack definite pitch, such as
 * unpitched percussion and speaking voice. Like notes, it
 * uses step and octave elements to indicate placement on
 * the staff, following the current clef. If percussion clef
 * is used, the display-step and display-octave are
 * interpreted as if in treble clef, with a G in octave 4
 * on line 2. If not present, the note is placed on the
 * middle line of the staff, generally used for one-line
 * staffs.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;sequence minOccurs="0">
 *           &lt;element ref="{}display-step"/>
 *           &lt;element ref="{}display-octave"/>
 *         &lt;/sequence>
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
    "displayStep",
    "displayOctave"
})
@XmlRootElement(name = "unpitched")
public class Unpitched {

    @XmlElement(name = "display-step")
    protected DisplayStep displayStep;
    @XmlElement(name = "display-octave")
    protected DisplayOctave displayOctave;

    /**
     * Gets the value of the displayStep property.
     * 
     * @return
     *     possible object is
     *     {@link DisplayStep }
     *     
     */
    public DisplayStep getDisplayStep() {
        return displayStep;
    }

    /**
     * Sets the value of the displayStep property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayStep }
     *     
     */
    public void setDisplayStep(DisplayStep value) {
        this.displayStep = value;
    }

    /**
     * Gets the value of the displayOctave property.
     * 
     * @return
     *     possible object is
     *     {@link DisplayOctave }
     *     
     */
    public DisplayOctave getDisplayOctave() {
        return displayOctave;
    }

    /**
     * Sets the value of the displayOctave property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayOctave }
     *     
     */
    public void setDisplayOctave(DisplayOctave value) {
        this.displayOctave = value;
    }

}
