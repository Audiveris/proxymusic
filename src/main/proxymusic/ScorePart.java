
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Each MusicXML part corresponds to a track in a Standard MIDI Format 1 file. The score-instrument elements are used when there are multiple instruments per track. The midi-device element is used to make a MIDI device or port assignment for the given track. Initial midi-instrument assignments may be made here as well.
 * 
 * <p>Java class for score-part complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="score-part">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="identification" type="{}identification" minOccurs="0"/>
 *         &lt;element name="part-name" type="{}part-name"/>
 *         &lt;element name="part-name-display" type="{}name-display" minOccurs="0"/>
 *         &lt;element name="part-abbreviation" type="{}part-name" minOccurs="0"/>
 *         &lt;element name="part-abbreviation-display" type="{}name-display" minOccurs="0"/>
 *         &lt;element name="group" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="score-instrument" type="{}score-instrument" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="midi-device" type="{}midi-device" minOccurs="0"/>
 *         &lt;element name="midi-instrument" type="{}midi-instrument" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "score-part", propOrder = {
    "identification",
    "partName",
    "partNameDisplay",
    "partAbbreviation",
    "partAbbreviationDisplay",
    "group",
    "scoreInstrument",
    "midiDevice",
    "midiInstrument"
})
public class ScorePart {

    protected Identification identification;
    @XmlElement(name = "part-name", required = true)
    protected PartName partName;
    @XmlElement(name = "part-name-display")
    protected NameDisplay partNameDisplay;
    @XmlElement(name = "part-abbreviation")
    protected PartName partAbbreviation;
    @XmlElement(name = "part-abbreviation-display")
    protected NameDisplay partAbbreviationDisplay;
    protected List<java.lang.String> group;
    @XmlElement(name = "score-instrument")
    protected List<ScoreInstrument> scoreInstrument;
    @XmlElement(name = "midi-device")
    protected MidiDevice midiDevice;
    @XmlElement(name = "midi-instrument")
    protected List<MidiInstrument> midiInstrument;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected java.lang.String id;

    /**
     * Gets the value of the identification property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getIdentification() {
        return identification;
    }

    /**
     * Sets the value of the identification property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setIdentification(Identification value) {
        this.identification = value;
    }

    /**
     * Gets the value of the partName property.
     * 
     * @return
     *     possible object is
     *     {@link PartName }
     *     
     */
    public PartName getPartName() {
        return partName;
    }

    /**
     * Sets the value of the partName property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartName }
     *     
     */
    public void setPartName(PartName value) {
        this.partName = value;
    }

    /**
     * Gets the value of the partNameDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link NameDisplay }
     *     
     */
    public NameDisplay getPartNameDisplay() {
        return partNameDisplay;
    }

    /**
     * Sets the value of the partNameDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameDisplay }
     *     
     */
    public void setPartNameDisplay(NameDisplay value) {
        this.partNameDisplay = value;
    }

    /**
     * Gets the value of the partAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link PartName }
     *     
     */
    public PartName getPartAbbreviation() {
        return partAbbreviation;
    }

    /**
     * Sets the value of the partAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartName }
     *     
     */
    public void setPartAbbreviation(PartName value) {
        this.partAbbreviation = value;
    }

    /**
     * Gets the value of the partAbbreviationDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link NameDisplay }
     *     
     */
    public NameDisplay getPartAbbreviationDisplay() {
        return partAbbreviationDisplay;
    }

    /**
     * Sets the value of the partAbbreviationDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameDisplay }
     *     
     */
    public void setPartAbbreviationDisplay(NameDisplay value) {
        this.partAbbreviationDisplay = value;
    }

    /**
     * Gets the value of the group property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the group property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link java.lang.String }
     * 
     * 
     */
    public List<java.lang.String> getGroup() {
        if (group == null) {
            group = new ArrayList<java.lang.String>();
        }
        return this.group;
    }

    /**
     * Gets the value of the scoreInstrument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scoreInstrument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScoreInstrument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ScoreInstrument }
     * 
     * 
     */
    public List<ScoreInstrument> getScoreInstrument() {
        if (scoreInstrument == null) {
            scoreInstrument = new ArrayList<ScoreInstrument>();
        }
        return this.scoreInstrument;
    }

    /**
     * Gets the value of the midiDevice property.
     * 
     * @return
     *     possible object is
     *     {@link MidiDevice }
     *     
     */
    public MidiDevice getMidiDevice() {
        return midiDevice;
    }

    /**
     * Sets the value of the midiDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link MidiDevice }
     *     
     */
    public void setMidiDevice(MidiDevice value) {
        this.midiDevice = value;
    }

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
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setId(java.lang.String value) {
        this.id = value;
    }

}
