
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
 *         &lt;element name="rehearsal" type="{}rehearsal" maxOccurs="unbounded"/>
 *         &lt;element name="segno" type="{}empty-print-style" maxOccurs="unbounded"/>
 *         &lt;element name="words" type="{}formatted-text" maxOccurs="unbounded"/>
 *         &lt;element name="coda" type="{}empty-print-style" maxOccurs="unbounded"/>
 *         &lt;element name="wedge" type="{}wedge"/>
 *         &lt;element name="dynamics" type="{}dynamics"/>
 *         &lt;element name="dashes" type="{}dashes"/>
 *         &lt;element name="bracket" type="{}bracket"/>
 *         &lt;element name="pedal" type="{}pedal"/>
 *         &lt;element name="metronome" type="{}metronome"/>
 *         &lt;element name="octave-shift" type="{}octave-shift"/>
 *         &lt;element name="harp-pedals" type="{}harp-pedals"/>
 *         &lt;element name="damp" type="{}empty-print-style"/>
 *         &lt;element name="damp-all" type="{}empty-print-style"/>
 *         &lt;element name="eyeglasses" type="{}empty-print-style"/>
 *         &lt;element name="scordatura" type="{}scordatura"/>
 *         &lt;element name="image" type="{}image"/>
 *         &lt;element name="accordion-registration" type="{}accordion-registration"/>
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
    "scordatura",
    "image",
    "accordionRegistration",
    "otherDirection"
})
public class DirectionType {

    protected List<Rehearsal> rehearsal;
    protected List<EmptyPrintStyle> segno;
    protected List<FormattedText> words;
    protected List<EmptyPrintStyle> coda;
    protected Wedge wedge;
    protected Dynamics dynamics;
    protected Dashes dashes;
    protected Bracket bracket;
    protected Pedal pedal;
    protected Metronome metronome;
    @XmlElement(name = "octave-shift")
    protected OctaveShift octaveShift;
    @XmlElement(name = "harp-pedals")
    protected HarpPedals harpPedals;
    protected EmptyPrintStyle damp;
    @XmlElement(name = "damp-all")
    protected EmptyPrintStyle dampAll;
    protected EmptyPrintStyle eyeglasses;
    protected Scordatura scordatura;
    protected Image image;
    @XmlElement(name = "accordion-registration")
    protected AccordionRegistration accordionRegistration;
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
     * {@link Rehearsal }
     * 
     * 
     */
    public List<Rehearsal> getRehearsal() {
        if (rehearsal == null) {
            rehearsal = new ArrayList<Rehearsal>();
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
     * {@link EmptyPrintStyle }
     * 
     * 
     */
    public List<EmptyPrintStyle> getSegno() {
        if (segno == null) {
            segno = new ArrayList<EmptyPrintStyle>();
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
     * {@link EmptyPrintStyle }
     * 
     * 
     */
    public List<EmptyPrintStyle> getCoda() {
        if (coda == null) {
            coda = new ArrayList<EmptyPrintStyle>();
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
     * @return
     *     possible object is
     *     {@link Dynamics }
     *     
     */
    public Dynamics getDynamics() {
        return dynamics;
    }

    /**
     * Sets the value of the dynamics property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dynamics }
     *     
     */
    public void setDynamics(Dynamics value) {
        this.dynamics = value;
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
     *     {@link EmptyPrintStyle }
     *     
     */
    public EmptyPrintStyle getDamp() {
        return damp;
    }

    /**
     * Sets the value of the damp property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmptyPrintStyle }
     *     
     */
    public void setDamp(EmptyPrintStyle value) {
        this.damp = value;
    }

    /**
     * Gets the value of the dampAll property.
     * 
     * @return
     *     possible object is
     *     {@link EmptyPrintStyle }
     *     
     */
    public EmptyPrintStyle getDampAll() {
        return dampAll;
    }

    /**
     * Sets the value of the dampAll property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmptyPrintStyle }
     *     
     */
    public void setDampAll(EmptyPrintStyle value) {
        this.dampAll = value;
    }

    /**
     * Gets the value of the eyeglasses property.
     * 
     * @return
     *     possible object is
     *     {@link EmptyPrintStyle }
     *     
     */
    public EmptyPrintStyle getEyeglasses() {
        return eyeglasses;
    }

    /**
     * Sets the value of the eyeglasses property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmptyPrintStyle }
     *     
     */
    public void setEyeglasses(EmptyPrintStyle value) {
        this.eyeglasses = value;
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
