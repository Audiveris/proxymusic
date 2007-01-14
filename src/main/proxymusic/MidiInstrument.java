
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * The midi-instrument element can be a part of either
 * the score-instrument element at the start of a part,
 * or the sound element within a part. The id attribute
 * refers to the score-instrument affected by the change.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}midi-channel" minOccurs="0"/>
 *         &lt;element ref="{}midi-name" minOccurs="0"/>
 *         &lt;element ref="{}midi-bank" minOccurs="0"/>
 *         &lt;element ref="{}midi-program" minOccurs="0"/>
 *         &lt;element ref="{}midi-unpitched" minOccurs="0"/>
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
@XmlType(name = "", propOrder = {
    "midiChannel",
    "midiName",
    "midiBank",
    "midiProgram",
    "midiUnpitched"
})
@XmlRootElement(name = "midi-instrument")
public class MidiInstrument {

    @XmlElement(name = "midi-channel")
    protected MidiChannel midiChannel;
    @XmlElement(name = "midi-name")
    protected MidiName midiName;
    @XmlElement(name = "midi-bank")
    protected MidiBank midiBank;
    @XmlElement(name = "midi-program")
    protected MidiProgram midiProgram;
    @XmlElement(name = "midi-unpitched")
    protected MidiUnpitched midiUnpitched;
    @XmlAttribute(required = true)
    @XmlIDREF
    protected Object id;

    /**
     * Gets the value of the midiChannel property.
     * 
     * @return
     *     possible object is
     *     {@link MidiChannel }
     *     
     */
    public MidiChannel getMidiChannel() {
        return midiChannel;
    }

    /**
     * Sets the value of the midiChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link MidiChannel }
     *     
     */
    public void setMidiChannel(MidiChannel value) {
        this.midiChannel = value;
    }

    /**
     * Gets the value of the midiName property.
     * 
     * @return
     *     possible object is
     *     {@link MidiName }
     *     
     */
    public MidiName getMidiName() {
        return midiName;
    }

    /**
     * Sets the value of the midiName property.
     * 
     * @param value
     *     allowed object is
     *     {@link MidiName }
     *     
     */
    public void setMidiName(MidiName value) {
        this.midiName = value;
    }

    /**
     * Gets the value of the midiBank property.
     * 
     * @return
     *     possible object is
     *     {@link MidiBank }
     *     
     */
    public MidiBank getMidiBank() {
        return midiBank;
    }

    /**
     * Sets the value of the midiBank property.
     * 
     * @param value
     *     allowed object is
     *     {@link MidiBank }
     *     
     */
    public void setMidiBank(MidiBank value) {
        this.midiBank = value;
    }

    /**
     * Gets the value of the midiProgram property.
     * 
     * @return
     *     possible object is
     *     {@link MidiProgram }
     *     
     */
    public MidiProgram getMidiProgram() {
        return midiProgram;
    }

    /**
     * Sets the value of the midiProgram property.
     * 
     * @param value
     *     allowed object is
     *     {@link MidiProgram }
     *     
     */
    public void setMidiProgram(MidiProgram value) {
        this.midiProgram = value;
    }

    /**
     * Gets the value of the midiUnpitched property.
     * 
     * @return
     *     possible object is
     *     {@link MidiUnpitched }
     *     
     */
    public MidiUnpitched getMidiUnpitched() {
        return midiUnpitched;
    }

    /**
     * Sets the value of the midiUnpitched property.
     * 
     * @param value
     *     allowed object is
     *     {@link MidiUnpitched }
     *     
     */
    public void setMidiUnpitched(MidiUnpitched value) {
        this.midiUnpitched = value;
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
