
package proxymusic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The sound element contains general playback parameters. They can stand alone within a part/measure, or be a component element within a direction.
 * 	
 * Tempo is expressed in quarter notes per minute. If 0, the sound-generating program should prompt the user at the time of compiling a sound (MIDI) file.
 * 	
 * Dynamics (or MIDI velocity) are expressed as a percentage of the default forte value (90 for MIDI 1.0).
 * 	
 * Dacapo indicates to go back to the beginning of the movement. When used it always has the value "yes".
 * 	
 * Segno and dalsegno are used for backwards jumps to a segno sign; coda and tocoda are used for forward jumps to a coda sign. If there are multiple jumps, the value of these parameters can be used to name and distinguish them. If segno or coda is used, the divisions attribute can also be used to indicate the number of divisions per quarter note. Otherwise sound and MIDI generating programs may have to recompute this.
 * 	
 * By default, a dalsegno or dacapo attribute indicates that the jump should occur the first time through, while a  tocoda attribute indicates the jump should occur the second time through. The time that jumps occur can be changed by using the time-only attribute.
 * 	
 * Forward-repeat is used when a forward repeat sign is implied, and usually follows a bar line. When used it always has the value of "yes".
 * 	
 * The fine attribute follows the final note or rest in a movement with a da capo or dal segno direction. If numeric, the value represents the actual duration of the final note or rest, which can be ambiguous in written notation and different among parts and voices. The value may also be "yes" to indicate no change to the final duration.
 * 	
 * If the sound element applies only one time through a repeat, the time-only attribute indicates which time to apply the sound element.
 * 	
 * Pizzicato in a sound element effects all following notes. Yes indicates pizzicato, no indicates arco.
 * 
 * The pan and elevation attributes are deprecated in Version 2.0. The pan and elevation elements in the midi-instrument element should be used instead. The meaning of the pan and elevation attributes is the same as for the pan and elevation elements. If both are present, the mid-instrument elements take priority.
 * 	
 * The damper-pedal, soft-pedal, and sostenuto-pedal attributes effect playback of the three common piano pedals and their MIDI controller equivalents. The yes value indicates the pedal is depressed; no indicates  the pedal is released. A numeric value from 0 to 100 may also be used for half pedaling. This value is the percentage that the pedal is depressed. A value of 0 is equivalent to no, and a value of 100 is equivalent to yes.
 * 	
 * MIDI instruments are changed using the midi-instrument element defined in the common.mod file.
 * 
 * The offset element is used to indicate that the sound takes place offset from the current score position. If the sound element is a child of a direction element, the sound offset element overrides the direction offset element if both elements are present. Note that the offset reflects the intended musical position for the change in sound. It should not be used to compensate for latency issues in particular hardware configurations.
 * 
 * <p>Java class for sound complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sound">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="midi-instrument" type="{}midi-instrument" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="offset" type="{}offset" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="tempo" type="{}non-negative-decimal" />
 *       &lt;attribute name="dynamics" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="dacapo" type="{}yes-no" />
 *       &lt;attribute name="segno" type="{http://www.w3.org/2001/XMLSchema}token" />
 *       &lt;attribute name="dalsegno" type="{http://www.w3.org/2001/XMLSchema}token" />
 *       &lt;attribute name="coda" type="{http://www.w3.org/2001/XMLSchema}token" />
 *       &lt;attribute name="tocoda" type="{http://www.w3.org/2001/XMLSchema}token" />
 *       &lt;attribute name="divisions" type="{}divisions" />
 *       &lt;attribute name="forward-repeat" type="{}yes-no" />
 *       &lt;attribute name="fine" type="{http://www.w3.org/2001/XMLSchema}token" />
 *       &lt;attribute name="time-only" type="{http://www.w3.org/2001/XMLSchema}token" />
 *       &lt;attribute name="pizzicato" type="{}yes-no" />
 *       &lt;attribute name="pan" type="{}rotation-degrees" />
 *       &lt;attribute name="elevation" type="{}rotation-degrees" />
 *       &lt;attribute name="damper-pedal" type="{}yes-no-number" />
 *       &lt;attribute name="soft-pedal" type="{}yes-no-number" />
 *       &lt;attribute name="sostenuto-pedal" type="{}yes-no-number" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sound", propOrder = {
    "midiInstrument",
    "offset"
})
public class Sound {

    @XmlElement(name = "midi-instrument")
    protected List<MidiInstrument> midiInstrument;
    protected Offset offset;
    @XmlAttribute
    protected BigDecimal tempo;
    @XmlAttribute
    protected BigDecimal dynamics;
    @XmlAttribute
    protected YesNo dacapo;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected java.lang.String segno;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected java.lang.String dalsegno;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected java.lang.String coda;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected java.lang.String tocoda;
    @XmlAttribute
    protected BigDecimal divisions;
    @XmlAttribute(name = "forward-repeat")
    protected YesNo forwardRepeat;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected java.lang.String fine;
    @XmlAttribute(name = "time-only")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected java.lang.String timeOnly;
    @XmlAttribute
    protected YesNo pizzicato;
    @XmlAttribute
    protected BigDecimal pan;
    @XmlAttribute
    protected BigDecimal elevation;
    @XmlAttribute(name = "damper-pedal")
    protected java.lang.String damperPedal;
    @XmlAttribute(name = "soft-pedal")
    protected java.lang.String softPedal;
    @XmlAttribute(name = "sostenuto-pedal")
    protected java.lang.String sostenutoPedal;

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
     * Gets the value of the offset property.
     * 
     * @return
     *     possible object is
     *     {@link Offset }
     *     
     */
    public Offset getOffset() {
        return offset;
    }

    /**
     * Sets the value of the offset property.
     * 
     * @param value
     *     allowed object is
     *     {@link Offset }
     *     
     */
    public void setOffset(Offset value) {
        this.offset = value;
    }

    /**
     * Gets the value of the tempo property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTempo() {
        return tempo;
    }

    /**
     * Sets the value of the tempo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTempo(BigDecimal value) {
        this.tempo = value;
    }

    /**
     * Gets the value of the dynamics property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDynamics() {
        return dynamics;
    }

    /**
     * Sets the value of the dynamics property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDynamics(BigDecimal value) {
        this.dynamics = value;
    }

    /**
     * Gets the value of the dacapo property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getDacapo() {
        return dacapo;
    }

    /**
     * Sets the value of the dacapo property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setDacapo(YesNo value) {
        this.dacapo = value;
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

    /**
     * Gets the value of the divisions property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDivisions() {
        return divisions;
    }

    /**
     * Sets the value of the divisions property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDivisions(BigDecimal value) {
        this.divisions = value;
    }

    /**
     * Gets the value of the forwardRepeat property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getForwardRepeat() {
        return forwardRepeat;
    }

    /**
     * Sets the value of the forwardRepeat property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setForwardRepeat(YesNo value) {
        this.forwardRepeat = value;
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
     * Gets the value of the pizzicato property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getPizzicato() {
        return pizzicato;
    }

    /**
     * Sets the value of the pizzicato property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setPizzicato(YesNo value) {
        this.pizzicato = value;
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

}
