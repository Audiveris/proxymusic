
package proxymusic;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * The midi-instrument type defines MIDI 1.0 instrument playback. The midi-instrument element can be a part of either the score-instrument element at the start of a part, or the sound element within a part. The id attribute refers to the score-instrument affected by the change.
 * 
 * <p>Java class for midi-instrument complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="midi-instrument">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="midi-channel" type="{}midi-16" minOccurs="0"/>
 *         &lt;element name="midi-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="midi-bank" type="{}midi-16384" minOccurs="0"/>
 *         &lt;element name="midi-program" type="{}midi-128" minOccurs="0"/>
 *         &lt;element name="midi-unpitched" type="{}midi-128" minOccurs="0"/>
 *         &lt;element name="volume" type="{}percent" minOccurs="0"/>
 *         &lt;element name="pan" type="{}rotation-degrees" minOccurs="0"/>
 *         &lt;element name="elevation" type="{}rotation-degrees" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "midi-instrument", propOrder = {
    "midiChannel",
    "midiName",
    "midiBank",
    "midiProgram",
    "midiUnpitched",
    "volume",
    "pan",
    "elevation"
})
public class MidiInstrument {

    @XmlElement(name = "midi-channel")
    protected Integer midiChannel;
    @XmlElement(name = "midi-name")
    protected java.lang.String midiName;
    @XmlElement(name = "midi-bank")
    protected Integer midiBank;
    @XmlElement(name = "midi-program")
    protected Integer midiProgram;
    @XmlElement(name = "midi-unpitched")
    protected Integer midiUnpitched;
    protected BigDecimal volume;
    protected BigDecimal pan;
    protected BigDecimal elevation;
    @XmlAttribute(required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object id;

    /**
     * Gets the value of the midiChannel property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMidiChannel() {
        return midiChannel;
    }

    /**
     * Sets the value of the midiChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMidiChannel(Integer value) {
        this.midiChannel = value;
    }

    /**
     * Gets the value of the midiName property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getMidiName() {
        return midiName;
    }

    /**
     * Sets the value of the midiName property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setMidiName(java.lang.String value) {
        this.midiName = value;
    }

    /**
     * Gets the value of the midiBank property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMidiBank() {
        return midiBank;
    }

    /**
     * Sets the value of the midiBank property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMidiBank(Integer value) {
        this.midiBank = value;
    }

    /**
     * Gets the value of the midiProgram property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMidiProgram() {
        return midiProgram;
    }

    /**
     * Sets the value of the midiProgram property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMidiProgram(Integer value) {
        this.midiProgram = value;
    }

    /**
     * Gets the value of the midiUnpitched property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMidiUnpitched() {
        return midiUnpitched;
    }

    /**
     * Sets the value of the midiUnpitched property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMidiUnpitched(Integer value) {
        this.midiUnpitched = value;
    }

    /**
     * Gets the value of the volume property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVolume() {
        return volume;
    }

    /**
     * Sets the value of the volume property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVolume(BigDecimal value) {
        this.volume = value;
    }

    /**
     * Gets the value of the pan property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPan() {
        return pan;
    }

    /**
     * Sets the value of the pan property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPan(BigDecimal value) {
        this.pan = value;
    }

    /**
     * Gets the value of the elevation property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getElevation() {
        return elevation;
    }

    /**
     * Sets the value of the elevation property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setElevation(BigDecimal value) {
        this.elevation = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setId(Object value) {
        this.id = value;
    }

}
