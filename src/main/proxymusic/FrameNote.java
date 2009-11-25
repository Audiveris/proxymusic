
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The frame-note type represents each note included in the frame.  An open string will have a fret value of 0, while a muted string will not be associated with a frame-note element.
 * 
 * <p>Java class for frame-note complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="frame-note">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="string" type="{}string"/>
 *         &lt;element name="fret" type="{}fret"/>
 *         &lt;element name="fingering" type="{}fingering" minOccurs="0"/>
 *         &lt;element name="barre" type="{}barre" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "frame-note", propOrder = {
    "string",
    "fret",
    "fingering",
    "barre"
})
public class FrameNote {

    @XmlElement(required = true)
    protected String string;
    @XmlElement(required = true)
    protected Fret fret;
    protected Fingering fingering;
    protected Barre barre;

    /**
     * Gets the value of the string property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getString() {
        return string;
    }

    /**
     * Sets the value of the string property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setString(String value) {
        this.string = value;
    }

    /**
     * Gets the value of the fret property.
     * 
     * @return
     *     possible object is
     *     {@link Fret }
     *     
     */
    public Fret getFret() {
        return fret;
    }

    /**
     * Sets the value of the fret property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fret }
     *     
     */
    public void setFret(Fret value) {
        this.fret = value;
    }

    /**
     * Gets the value of the fingering property.
     * 
     * @return
     *     possible object is
     *     {@link Fingering }
     *     
     */
    public Fingering getFingering() {
        return fingering;
    }

    /**
     * Sets the value of the fingering property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fingering }
     *     
     */
    public void setFingering(Fingering value) {
        this.fingering = value;
    }

    /**
     * Gets the value of the barre property.
     * 
     * @return
     *     possible object is
     *     {@link Barre }
     *     
     */
    public Barre getBarre() {
        return barre;
    }

    /**
     * Sets the value of the barre property.
     * 
     * @param value
     *     allowed object is
     *     {@link Barre }
     *     
     */
    public void setBarre(Barre value) {
        this.barre = value;
    }

}
