
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Textual direction types may have more than 1 component due to multiple fonts. The dynamics element may also be used in the notations element. Attribute groups related to print suggestions apply to the individual direction-type, not to the overall direction.
 * 
 * <p>Java class for direction-type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="direction-type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="rehearsal" type="{}formatted-text" maxOccurs="unbounded"/>
 *         &lt;element name="segno" type="{}empty-print-style-align" maxOccurs="unbounded"/>
 *         &lt;element name="words" type="{}formatted-text" maxOccurs="unbounded"/>
 *         &lt;element name="coda" type="{}empty-print-style-align" maxOccurs="unbounded"/>
 *         &lt;element name="wedge" type="{}wedge"/>
 *         &lt;element name="dynamics" type="{}dynamics" maxOccurs="unbounded"/>
 *         &lt;element name="dashes" type="{}dashes"/>
 *         &lt;element name="bracket" type="{}bracket"/>
 *         &lt;element name="pedal" type="{}pedal"/>
 *         &lt;element name="metronome" type="{}metronome"/>
 *         &lt;element name="octave-shift" type="{}octave-shift"/>
 *         &lt;element name="harp-pedals" type="{}harp-pedals"/>
 *         &lt;element name="damp" type="{}empty-print-style-align"/>
 *         &lt;element name="damp-all" type="{}empty-print-style-align"/>
 *         &lt;element name="eyeglasses" type="{}empty-print-style-align"/>
 *         &lt;element name="string-mute" type="{}string-mute"/>
 *         &lt;element name="scordatura" type="{}scordatura"/>
 *         &lt;element name="image" type="{}image"/>
 *         &lt;element name="principal-voice" type="{}principal-voice"/>
 *         &lt;element name="accordion-registration" type="{}accordion-registration"/>
 *         &lt;element name="percussion" type="{}percussion" maxOccurs="unbounded"/>
 *         &lt;element name="other-direction" type="{}other-direction"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "direction-type", propOrder = {
    "rehearsal",
    "segno",
    "words",
    "coda",
    "wedge",
    "dynamics",
    "dashes",
    "bracket",
    "pedal",
    "metronome",
    "octaveShift",
    "harpPedals",
    "damp",
    "dampAll",
    "eyeglasses",
    "stringMute",
    "scordatura",
    "image",
    "principalVoice",
    "accordionRegistration",
    "percussion",
    "otherDirection"
})
public class DirectionType {

    protected List<FormattedText> rehearsal;
    protected List<EmptyPrintStyleAlign> segno;
    protected List<FormattedText> words;
    protected List<EmptyPrintStyleAlign> coda;
    protected Wedge wedge;
    protected List<Dynamics> dynamics;
    protected Dashes dashes;
    protected Bracket bracket;
    protected Pedal pedal;
    protected Metronome metronome;
    @XmlElement(name = "octave-shift")
    protected OctaveShift octaveShift;
    @XmlElement(name = "harp-pedals")
    protected HarpPedals harpPedals;
    protected EmptyPrintStyleAlign damp;
    @XmlElement(name = "damp-all")
    protected EmptyPrintStyleAlign dampAll;
    protected EmptyPrintStyleAlign eyeglasses;
    @XmlElement(name = "string-mute")
    protected StringMute stringMute;
    protected Scordatura scordatura;
    protected Image image;
    @XmlElement(name = "principal-voice")
    protected PrincipalVoice principalVoice;
    @XmlElement(name = "accordion-registration")
    protected AccordionRegistration accordionRegistration;
    protected List<Percussion> percussion;
    @XmlElement(name = "other-direction")
    protected OtherDirection otherDirection;

    /**
     * Gets the value of the rehearsal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rehearsal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRehearsal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FormattedText }
     * 
     * 
     */
    public List<FormattedText> getRehearsal() {
        if (rehearsal == null) {
            rehearsal = new ArrayList<FormattedText>();
        }
        return this.rehearsal;
    }

    /**
     * Gets the value of the segno property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the segno property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSegno().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EmptyPrintStyleAlign }
     * 
     * 
     */
    public List<EmptyPrintStyleAlign> getSegno() {
        if (segno == null) {
            segno = new ArrayList<EmptyPrintStyleAlign>();
        }
        return this.segno;
    }

    /**
     * Gets the value of the words property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the words property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWords().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FormattedText }
     * 
     * 
     */
    public List<FormattedText> getWords() {
        if (words == null) {
            words = new ArrayList<FormattedText>();
        }
        return this.words;
    }

    /**
     * Gets the value of the coda property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the coda property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCoda().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EmptyPrintStyleAlign }
     * 
     * 
     */
    public List<EmptyPrintStyleAlign> getCoda() {
        if (coda == null) {
            coda = new ArrayList<EmptyPrintStyleAlign>();
        }
        return this.coda;
    }

    /**
     * Gets the value of the wedge property.
     * 
     * @return
     *     possible object is
     *     {@link Wedge }
     *     
     */
    public Wedge getWedge() {
        return wedge;
    }

    /**
     * Sets the value of the wedge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Wedge }
     *     
     */
    public void setWedge(Wedge value) {
        this.wedge = value;
    }

    /**
     * Gets the value of the dynamics property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dynamics property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDynamics().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Dynamics }
     * 
     * 
     */
    public List<Dynamics> getDynamics() {
        if (dynamics == null) {
            dynamics = new ArrayList<Dynamics>();
        }
        return this.dynamics;
    }

    /**
     * Gets the value of the dashes property.
     * 
     * @return
     *     possible object is
     *     {@link Dashes }
     *     
     */
    public Dashes getDashes() {
        return dashes;
    }

    /**
     * Sets the value of the dashes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dashes }
     *     
     */
    public void setDashes(Dashes value) {
        this.dashes = value;
    }

    /**
     * Gets the value of the bracket property.
     * 
     * @return
     *     possible object is
     *     {@link Bracket }
     *     
     */
    public Bracket getBracket() {
        return bracket;
    }

    /**
     * Sets the value of the bracket property.
     * 
     * @param value
     *     allowed object is
     *     {@link Bracket }
     *     
     */
    public void setBracket(Bracket value) {
        this.bracket = value;
    }

    /**
     * Gets the value of the pedal property.
     * 
     * @return
     *     possible object is
     *     {@link Pedal }
     *     
     */
    public Pedal getPedal() {
        return pedal;
    }

    /**
     * Sets the value of the pedal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pedal }
     *     
     */
    public void setPedal(Pedal value) {
        this.pedal = value;
    }

    /**
     * Gets the value of the metronome property.
     * 
     * @return
     *     possible object is
     *     {@link Metronome }
     *     
     */
    public Metronome getMetronome() {
        return metronome;
    }

    /**
     * Sets the value of the metronome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Metronome }
     *     
     */
    public void setMetronome(Metronome value) {
        this.metronome = value;
    }

    /**
     * Gets the value of the octaveShift property.
     * 
     * @return
     *     possible object is
     *     {@link OctaveShift }
     *     
     */
    public OctaveShift getOctaveShift() {
        return octaveShift;
    }

    /**
     * Sets the value of the octaveShift property.
     * 
     * @param value
     *     allowed object is
     *     {@link OctaveShift }
     *     
     */
    public void setOctaveShift(OctaveShift value) {
        this.octaveShift = value;
    }

    /**
     * Gets the value of the harpPedals property.
     * 
     * @return
     *     possible object is
     *     {@link HarpPedals }
     *     
     */
    public HarpPedals getHarpPedals() {
        return harpPedals;
    }

    /**
     * Sets the value of the harpPedals property.
     * 
     * @param value
     *     allowed object is
     *     {@link HarpPedals }
     *     
     */
    public void setHarpPedals(HarpPedals value) {
        this.harpPedals = value;
    }

    /**
     * Gets the value of the damp property.
     * 
     * @return
     *     possible object is
     *     {@link EmptyPrintStyleAlign }
     *     
     */
    public EmptyPrintStyleAlign getDamp() {
        return damp;
    }

    /**
     * Sets the value of the damp property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmptyPrintStyleAlign }
     *     
     */
    public void setDamp(EmptyPrintStyleAlign value) {
        this.damp = value;
    }

    /**
     * Gets the value of the dampAll property.
     * 
     * @return
     *     possible object is
     *     {@link EmptyPrintStyleAlign }
     *     
     */
    public EmptyPrintStyleAlign getDampAll() {
        return dampAll;
    }

    /**
     * Sets the value of the dampAll property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmptyPrintStyleAlign }
     *     
     */
    public void setDampAll(EmptyPrintStyleAlign value) {
        this.dampAll = value;
    }

    /**
     * Gets the value of the eyeglasses property.
     * 
     * @return
     *     possible object is
     *     {@link EmptyPrintStyleAlign }
     *     
     */
    public EmptyPrintStyleAlign getEyeglasses() {
        return eyeglasses;
    }

    /**
     * Sets the value of the eyeglasses property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmptyPrintStyleAlign }
     *     
     */
    public void setEyeglasses(EmptyPrintStyleAlign value) {
        this.eyeglasses = value;
    }

    /**
     * Gets the value of the stringMute property.
     * 
     * @return
     *     possible object is
     *     {@link StringMute }
     *     
     */
    public StringMute getStringMute() {
        return stringMute;
    }

    /**
     * Sets the value of the stringMute property.
     * 
     * @param value
     *     allowed object is
     *     {@link StringMute }
     *     
     */
    public void setStringMute(StringMute value) {
        this.stringMute = value;
    }

    /**
     * Gets the value of the scordatura property.
     * 
     * @return
     *     possible object is
     *     {@link Scordatura }
     *     
     */
    public Scordatura getScordatura() {
        return scordatura;
    }

    /**
     * Sets the value of the scordatura property.
     * 
     * @param value
     *     allowed object is
     *     {@link Scordatura }
     *     
     */
    public void setScordatura(Scordatura value) {
        this.scordatura = value;
    }

    /**
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     {@link Image }
     *     
     */
    public Image getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     {@link Image }
     *     
     */
    public void setImage(Image value) {
        this.image = value;
    }

    /**
     * Gets the value of the principalVoice property.
     * 
     * @return
     *     possible object is
     *     {@link PrincipalVoice }
     *     
     */
    public PrincipalVoice getPrincipalVoice() {
        return principalVoice;
    }

    /**
     * Sets the value of the principalVoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrincipalVoice }
     *     
     */
    public void setPrincipalVoice(PrincipalVoice value) {
        this.principalVoice = value;
    }

    /**
     * Gets the value of the accordionRegistration property.
     * 
     * @return
     *     possible object is
     *     {@link AccordionRegistration }
     *     
     */
    public AccordionRegistration getAccordionRegistration() {
        return accordionRegistration;
    }

    /**
     * Sets the value of the accordionRegistration property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccordionRegistration }
     *     
     */
    public void setAccordionRegistration(AccordionRegistration value) {
        this.accordionRegistration = value;
    }

    /**
     * Gets the value of the percussion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the percussion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPercussion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Percussion }
     * 
     * 
     */
    public List<Percussion> getPercussion() {
        if (percussion == null) {
            percussion = new ArrayList<Percussion>();
        }
        return this.percussion;
    }

    /**
     * Gets the value of the otherDirection property.
     * 
     * @return
     *     possible object is
     *     {@link OtherDirection }
     *     
     */
    public OtherDirection getOtherDirection() {
        return otherDirection;
    }

    /**
     * Sets the value of the otherDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link OtherDirection }
     *     
     */
    public void setOtherDirection(OtherDirection value) {
        this.otherDirection = value;
    }

}
