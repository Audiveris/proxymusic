
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
 * The attributes element contains musical information
 * that typically changes on measure boundaries. This
 * includes key and time signatures, clefs, transpositions,
 * and staving.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;sequence>
 *           &lt;element ref="{}footnote" minOccurs="0"/>
 *           &lt;element ref="{}level" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;element ref="{}divisions" minOccurs="0"/>
 *         &lt;element ref="{}key" minOccurs="0"/>
 *         &lt;element ref="{}time" minOccurs="0"/>
 *         &lt;element ref="{}staves" minOccurs="0"/>
 *         &lt;element ref="{}instruments" minOccurs="0"/>
 *         &lt;element ref="{}clef" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}staff-details" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}transpose" minOccurs="0"/>
 *         &lt;element ref="{}directive" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}measure-style" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "footnote",
    "level",
    "divisions",
    "key",
    "time",
    "staves",
    "instruments",
    "clef",
    "staffDetails",
    "transpose",
    "directive",
    "measureStyle"
})
@XmlRootElement(name = "attributes")
public class Attributes {

    protected Footnote footnote;
    protected Level level;
    protected Divisions divisions;
    protected Key key;
    protected Time time;
    protected Staves staves;
    protected Instruments instruments;
    protected List<Clef> clef;
    @XmlElement(name = "staff-details")
    protected List<StaffDetails> staffDetails;
    protected Transpose transpose;
    protected List<Directive> directive;
    @XmlElement(name = "measure-style")
    protected List<MeasureStyle> measureStyle;

    /**
     * Gets the value of the footnote property.
     * 
     * @return
     *     possible object is
     *     {@link Footnote }
     *     
     */
    public Footnote getFootnote() {
        return footnote;
    }

    /**
     * Sets the value of the footnote property.
     * 
     * @param value
     *     allowed object is
     *     {@link Footnote }
     *     
     */
    public void setFootnote(Footnote value) {
        this.footnote = value;
    }

    /**
     * Gets the value of the level property.
     * 
     * @return
     *     possible object is
     *     {@link Level }
     *     
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     * @param value
     *     allowed object is
     *     {@link Level }
     *     
     */
    public void setLevel(Level value) {
        this.level = value;
    }

    /**
     * Gets the value of the divisions property.
     * 
     * @return
     *     possible object is
     *     {@link Divisions }
     *     
     */
    public Divisions getDivisions() {
        return divisions;
    }

    /**
     * Sets the value of the divisions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Divisions }
     *     
     */
    public void setDivisions(Divisions value) {
        this.divisions = value;
    }

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link Key }
     *     
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link Key }
     *     
     */
    public void setKey(Key value) {
        this.key = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link Time }
     *     
     */
    public Time getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link Time }
     *     
     */
    public void setTime(Time value) {
        this.time = value;
    }

    /**
     * Gets the value of the staves property.
     * 
     * @return
     *     possible object is
     *     {@link Staves }
     *     
     */
    public Staves getStaves() {
        return staves;
    }

    /**
     * Sets the value of the staves property.
     * 
     * @param value
     *     allowed object is
     *     {@link Staves }
     *     
     */
    public void setStaves(Staves value) {
        this.staves = value;
    }

    /**
     * Gets the value of the instruments property.
     * 
     * @return
     *     possible object is
     *     {@link Instruments }
     *     
     */
    public Instruments getInstruments() {
        return instruments;
    }

    /**
     * Sets the value of the instruments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Instruments }
     *     
     */
    public void setInstruments(Instruments value) {
        this.instruments = value;
    }

    /**
     * Gets the value of the clef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Clef }
     * 
     * 
     */
    public List<Clef> getClef() {
        if (clef == null) {
            clef = new ArrayList<Clef>();
        }
        return this.clef;
    }

    /**
     * Gets the value of the staffDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the staffDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStaffDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StaffDetails }
     * 
     * 
     */
    public List<StaffDetails> getStaffDetails() {
        if (staffDetails == null) {
            staffDetails = new ArrayList<StaffDetails>();
        }
        return this.staffDetails;
    }

    /**
     * Gets the value of the transpose property.
     * 
     * @return
     *     possible object is
     *     {@link Transpose }
     *     
     */
    public Transpose getTranspose() {
        return transpose;
    }

    /**
     * Sets the value of the transpose property.
     * 
     * @param value
     *     allowed object is
     *     {@link Transpose }
     *     
     */
    public void setTranspose(Transpose value) {
        this.transpose = value;
    }

    /**
     * Gets the value of the directive property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the directive property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDirective().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Directive }
     * 
     * 
     */
    public List<Directive> getDirective() {
        if (directive == null) {
            directive = new ArrayList<Directive>();
        }
        return this.directive;
    }

    /**
     * Gets the value of the measureStyle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the measureStyle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeasureStyle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MeasureStyle }
     * 
     * 
     */
    public List<MeasureStyle> getMeasureStyle() {
        if (measureStyle == null) {
            measureStyle = new ArrayList<MeasureStyle>();
        }
        return this.measureStyle;
    }

}
