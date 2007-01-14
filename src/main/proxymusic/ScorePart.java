
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}identification" minOccurs="0"/>
 *         &lt;element ref="{}part-name"/>
 *         &lt;element ref="{}part-abbreviation" minOccurs="0"/>
 *         &lt;element ref="{}group" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}score-instrument" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}midi-device" minOccurs="0"/>
 *         &lt;element ref="{}midi-instrument" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "", propOrder = {
    "identification",
    "partName",
    "partAbbreviation",
    "group",
    "scoreInstrument",
    "midiDevice",
    "midiInstrument"
})
@XmlRootElement(name = "score-part")
public class ScorePart {

    protected Identification identification;
    @XmlElement(name = "part-name", required = true)
    protected PartName partName;
    @XmlElement(name = "part-abbreviation")
    protected PartAbbreviation partAbbreviation;
    protected List<Group> group;
    @XmlElement(name = "score-instrument")
    protected List<ScoreInstrument> scoreInstrument;
    @XmlElement(name = "midi-device")
    protected MidiDevice midiDevice;
    @XmlElement(name = "midi-instrument")
    protected List<MidiInstrument> midiInstrument;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
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
     * Gets the value of the partAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link PartAbbreviation }
     *     
     */
    public PartAbbreviation getPartAbbreviation() {
        return partAbbreviation;
    }

    /**
     * Sets the value of the partAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartAbbreviation }
     *     
     */
    public void setPartAbbreviation(PartAbbreviation value) {
        this.partAbbreviation = value;
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
     * {@link Group }
     * 
     * 
     */
    public List<Group> getGroup() {
        if (group == null) {
            group = new ArrayList<Group>();
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
