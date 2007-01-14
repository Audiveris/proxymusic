
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * Textual direction types may have more than 1 component
 * due to multiple font numbers.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{}rehearsal" maxOccurs="unbounded"/>
 *         &lt;element ref="{}segno" maxOccurs="unbounded"/>
 *         &lt;element ref="{}words" maxOccurs="unbounded"/>
 *         &lt;element ref="{}coda" maxOccurs="unbounded"/>
 *         &lt;element ref="{}wedge"/>
 *         &lt;element ref="{}dynamics" maxOccurs="unbounded"/>
 *         &lt;element ref="{}dashes"/>
 *         &lt;element ref="{}bracket"/>
 *         &lt;element ref="{}pedal"/>
 *         &lt;element ref="{}metronome"/>
 *         &lt;element ref="{}octave-shift"/>
 *         &lt;element ref="{}harp-pedals"/>
 *         &lt;element ref="{}damp"/>
 *         &lt;element ref="{}damp-all"/>
 *         &lt;element ref="{}eyeglasses"/>
 *         &lt;element ref="{}scordatura"/>
 *         &lt;element ref="{}other-direction"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
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
    "otherDirection"
})
@XmlRootElement(name = "direction-type")
public class DirectionType {

    protected List<Rehearsal> rehearsal;
    protected List<Segno> segno;
    protected List<Words> words;
    protected List<Coda> coda;
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
    protected Damp damp;
    @XmlElement(name = "damp-all")
    protected DampAll dampAll;
    protected Eyeglasses eyeglasses;
    protected Scordatura scordatura;
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
     * {@link Segno }
     * 
     * 
     */
    public List<Segno> getSegno() {
        if (segno == null) {
            segno = new ArrayList<Segno>();
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
     * {@link Words }
     * 
     * 
     */
    public List<Words> getWords() {
        if (words == null) {
            words = new ArrayList<Words>();
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
     * {@link Coda }
     * 
     * 
     */
    public List<Coda> getCoda() {
        if (coda == null) {
            coda = new ArrayList<Coda>();
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
     *     {@link Damp }
     *     
     */
    public Damp getDamp() {
        return damp;
    }

    /**
     * Sets the value of the damp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Damp }
     *     
     */
    public void setDamp(Damp value) {
        this.damp = value;
    }

    /**
     * Gets the value of the dampAll property.
     * 
     * @return
     *     possible object is
     *     {@link DampAll }
     *     
     */
    public DampAll getDampAll() {
        return dampAll;
    }

    /**
     * Sets the value of the dampAll property.
     * 
     * @param value
     *     allowed object is
     *     {@link DampAll }
     *     
     */
    public void setDampAll(DampAll value) {
        this.dampAll = value;
    }

    /**
     * Gets the value of the eyeglasses property.
     * 
     * @return
     *     possible object is
     *     {@link Eyeglasses }
     *     
     */
    public Eyeglasses getEyeglasses() {
        return eyeglasses;
    }

    /**
     * Sets the value of the eyeglasses property.
     * 
     * @param value
     *     allowed object is
     *     {@link Eyeglasses }
     *     
     */
    public void setEyeglasses(Eyeglasses value) {
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
