
package proxymusic;

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
 * The score-instrument type represents a single instrument within a score-part. As with the score-part type, each score-instrument has a required ID attribute, a name, and an optional abbreviation.
 * 	
 * A score-instrument type is also required if the score specifies MIDI 1.0 channels, banks, or programs. An initial midi-instrument assignment can also be made here. MusicXML software should be able to automatically assign reasonable channels and instruments without these elements in simple cases, such as where part names match General MIDI instrument names.
 * 
 * <p>Java class for score-instrument complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="score-instrument">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="instrument-name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="instrument-abbreviation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="instrument-sound" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="solo" type="{}empty"/>
 *           &lt;element name="ensemble" type="{}positive-integer-or-empty"/>
 *         &lt;/choice>
 *         &lt;element name="virtual-instrument" type="{}virtual-instrument" minOccurs="0"/>
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
@XmlType(name = "score-instrument", propOrder = {
    "instrumentName",
    "instrumentAbbreviation",
    "instrumentSound",
    "solo",
    "ensemble",
    "virtualInstrument"
})
public class ScoreInstrument {

    @XmlElement(name = "instrument-name", required = true)
    protected java.lang.String instrumentName;
    @XmlElement(name = "instrument-abbreviation")
    protected java.lang.String instrumentAbbreviation;
    @XmlElement(name = "instrument-sound")
    protected java.lang.String instrumentSound;
    protected Empty solo;
    protected java.lang.String ensemble;
    @XmlElement(name = "virtual-instrument")
    protected VirtualInstrument virtualInstrument;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected java.lang.String id;

    /**
     * Gets the value of the instrumentName property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getInstrumentName() {
        return instrumentName;
    }

    /**
     * Sets the value of the instrumentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setInstrumentName(java.lang.String value) {
        this.instrumentName = value;
    }

    /**
     * Gets the value of the instrumentAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getInstrumentAbbreviation() {
        return instrumentAbbreviation;
    }

    /**
     * Sets the value of the instrumentAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setInstrumentAbbreviation(java.lang.String value) {
        this.instrumentAbbreviation = value;
    }

    /**
     * Gets the value of the instrumentSound property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getInstrumentSound() {
        return instrumentSound;
    }

    /**
     * Sets the value of the instrumentSound property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setInstrumentSound(java.lang.String value) {
        this.instrumentSound = value;
    }

    /**
     * Gets the value of the solo property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getSolo() {
        return solo;
    }

    /**
     * Sets the value of the solo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setSolo(Empty value) {
        this.solo = value;
    }

    /**
     * Gets the value of the ensemble property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getEnsemble() {
        return ensemble;
    }

    /**
     * Sets the value of the ensemble property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setEnsemble(java.lang.String value) {
        this.ensemble = value;
    }

    /**
     * Gets the value of the virtualInstrument property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualInstrument }
     *     
     */
    public VirtualInstrument getVirtualInstrument() {
        return virtualInstrument;
    }

    /**
     * Sets the value of the virtualInstrument property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualInstrument }
     *     
     */
    public void setVirtualInstrument(VirtualInstrument value) {
        this.virtualInstrument = value;
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
