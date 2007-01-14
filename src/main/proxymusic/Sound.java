
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * The sound element contains general playback parameters.
 * They can stand alone within a part/measure, or be a
 * component element within a direction.
 * 
 * Tempo is expressed in quarter notes per minute. If 0,
 * the sound-generating program must prompt the user at the
 * time of compiling a sound (MIDI) file.
 * 
 * Dynamics (or MIDI velocity) are expressed as a percentage
 * of the default forte value (90 for MIDI).
 * 
 * Dacapo indicates to go back to the beginning of the
 * movement. When used it always has the value "yes".
 * 
 * Segno and dalsegno are used for backwards jumps to a
 * segno sign; coda and tocoda are used for forward jumps
 * to a coda sign. If there are multiple jumps, the value
 * of these parameters can be used to name and distinguish
 * them. If segno or coda is used, the divisions attribute
 * can also be used to indicate the number of divisions
 * per quarter note. Otherwise sound and MIDI generating
 * programs may have to recompute this.
 * 
 * A dalsegno or dacapo attribute indicates that the
 * jump should occur the first time through; a tocoda
 * attribute indicates the jump should occur the second
 * time through.
 * 
 * Forward-repeat is used when a forward repeat sign is
 * implied, and usually follows a bar line. When used it
 * always has the value of "yes".
 * 
 * The fine attribute follows the final note or rest in a
 * movement with a da capo direction. If numeric, the value
 * represents the actual duration of the final note or rest,
 * which can be ambiguous in written notation and different
 * among parts and voices. The value may also be "yes" to
 * indicate no change to the final duration.
 * 
 * If the sound element applies only one time through a
 * repeat, the time-only attribute indicates which time
 * to apply the sound element.
 * 
 * Pizzicato in a sound element effects all following notes.
 * Yes indicates pizzicato, no indicates arco.
 * 
 * Pan and elevation allow placing of sound in a 3-D space
 * relative to the listener. Both are expressed in degrees
 * ranging from -180 to 180. For pan, 0 is straight ahead,
 * -90 is hard left, 90 is hard right, and -180 and 180
 * are directly behind the listener. For elevation, 0 is
 * level with the listener, 90 is directly above, and -90
 * is directly below.
 * 
 * The damper-pedal, soft-pedal, and sostenuto-pedal
 * attributes effect playback of the three common piano
 * pedals and their MIDI controller equivalents. Yes
 * indicates the pedal is depressed; no indicates the
 * pedal is released.
 * 
 * MIDI instruments are changed using the midi-instrument
 * element defined in common.dtd.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}midi-instrument" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="coda" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="dacapo">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="yes"/>
 *             &lt;enumeration value="no"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="dalsegno" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="damper-pedal">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="yes"/>
 *             &lt;enumeration value="no"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="divisions" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="dynamics" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="elevation" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="fine" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="forward-repeat">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="yes"/>
 *             &lt;enumeration value="no"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="pan" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="pizzicato">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="yes"/>
 *             &lt;enumeration value="no"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="segno" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="soft-pedal">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="yes"/>
 *             &lt;enumeration value="no"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="sostenuto-pedal">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="yes"/>
 *             &lt;enumeration value="no"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="tempo" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="time-only" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="tocoda" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "midiInstrument"
})
@XmlRootElement(name = "sound")
public class Sound {

    @XmlElement(name = "midi-instrument")
    protected List<MidiInstrument> midiInstrument;
    @XmlAttribute
    protected java.lang.String coda;
    @XmlAttribute
    protected java.lang.String dacapo;
    @XmlAttribute
    protected java.lang.String dalsegno;
    @XmlAttribute(name = "damper-pedal")
    protected java.lang.String damperPedal;
    @XmlAttribute
    protected java.lang.String divisions;
    @XmlAttribute
    protected java.lang.String dynamics;
    @XmlAttribute
    protected java.lang.String elevation;
    @XmlAttribute
    protected java.lang.String fine;
    @XmlAttribute(name = "forward-repeat")
    protected java.lang.String forwardRepeat;
    @XmlAttribute
    protected java.lang.String pan;
    @XmlAttribute
    protected java.lang.String pizzicato;
    @XmlAttribute
    protected java.lang.String segno;
    @XmlAttribute(name = "soft-pedal")
    protected java.lang.String softPedal;
    @XmlAttribute(name = "sostenuto-pedal")
    protected java.lang.String sostenutoPedal;
    @XmlAttribute
    protected java.lang.String tempo;
    @XmlAttribute(name = "time-only")
    protected java.lang.String timeOnly;
    @XmlAttribute
    protected java.lang.String tocoda;

    /**
     * Gets the value of the midiInstrument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the midiInstrument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMidiInstrument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MidiInstrument }
     * 
     * 
     */
    public List<MidiInstrument> getMidiInstrument() {
        if (midiInstrument == null) {
            midiInstrument = new ArrayList<MidiInstrument>();
        }
        return this.midiInstrument;
    }

    /**
     * Gets the value of the coda property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getCoda() {
        return coda;
    }

    /**
     * Sets the value of the coda property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setCoda(java.lang.String value) {
        this.coda = value;
    }

    /**
     * Gets the value of the dacapo property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getDacapo() {
        return dacapo;
    }

    /**
     * Sets the value of the dacapo property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setDacapo(java.lang.String value) {
        this.dacapo = value;
    }

    /**
     * Gets the value of the dalsegno property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getDalsegno() {
        return dalsegno;
    }

    /**
     * Sets the value of the dalsegno property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setDalsegno(java.lang.String value) {
        this.dalsegno = value;
    }

    /**
     * Gets the value of the damperPedal property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getDamperPedal() {
        return damperPedal;
    }

    /**
     * Sets the value of the damperPedal property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setDamperPedal(java.lang.String value) {
        this.damperPedal = value;
    }

    /**
     * Gets the value of the divisions property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getDivisions() {
        return divisions;
    }

    /**
     * Sets the value of the divisions property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setDivisions(java.lang.String value) {
        this.divisions = value;
    }

    /**
     * Gets the value of the dynamics property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getDynamics() {
        return dynamics;
    }

    /**
     * Sets the value of the dynamics property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setDynamics(java.lang.String value) {
        this.dynamics = value;
    }

    /**
     * Gets the value of the elevation property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getElevation() {
        return elevation;
    }

    /**
     * Sets the value of the elevation property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setElevation(java.lang.String value) {
        this.elevation = value;
    }

    /**
     * Gets the value of the fine property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getFine() {
        return fine;
    }

    /**
     * Sets the value of the fine property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setFine(java.lang.String value) {
        this.fine = value;
    }

    /**
     * Gets the value of the forwardRepeat property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getForwardRepeat() {
        return forwardRepeat;
    }

    /**
     * Sets the value of the forwardRepeat property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setForwardRepeat(java.lang.String value) {
        this.forwardRepeat = value;
    }

    /**
     * Gets the value of the pan property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPan() {
        return pan;
    }

    /**
     * Sets the value of the pan property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPan(java.lang.String value) {
        this.pan = value;
    }

    /**
     * Gets the value of the pizzicato property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPizzicato() {
        return pizzicato;
    }

    /**
     * Sets the value of the pizzicato property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPizzicato(java.lang.String value) {
        this.pizzicato = value;
    }

    /**
     * Gets the value of the segno property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getSegno() {
        return segno;
    }

    /**
     * Sets the value of the segno property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setSegno(java.lang.String value) {
        this.segno = value;
    }

    /**
     * Gets the value of the softPedal property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getSoftPedal() {
        return softPedal;
    }

    /**
     * Sets the value of the softPedal property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setSoftPedal(java.lang.String value) {
        this.softPedal = value;
    }

    /**
     * Gets the value of the sostenutoPedal property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getSostenutoPedal() {
        return sostenutoPedal;
    }

    /**
     * Sets the value of the sostenutoPedal property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setSostenutoPedal(java.lang.String value) {
        this.sostenutoPedal = value;
    }

    /**
     * Gets the value of the tempo property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getTempo() {
        return tempo;
    }

    /**
     * Sets the value of the tempo property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setTempo(java.lang.String value) {
        this.tempo = value;
    }

    /**
     * Gets the value of the timeOnly property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getTimeOnly() {
        return timeOnly;
    }

    /**
     * Sets the value of the timeOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setTimeOnly(java.lang.String value) {
        this.timeOnly = value;
    }

    /**
     * Gets the value of the tocoda property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getTocoda() {
        return tocoda;
    }

    /**
     * Sets the value of the tocoda property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setTocoda(java.lang.String value) {
        this.tocoda = value;
    }

}
