
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
 * The staff-details element is used to indicate different
 * types of staves. The staff-type element can be ossia,
 * cue, editorial, regular, or alternate. An alternate
 * staff indicates one that shares the same musical data
 * as the prior staff, but displayed differently (e.g.,
 * treble and bass clef, standard notation and tab).
 * The staff-lines element specifies the number of lines for
 * non 5-line staffs. The staff-tuning and capo elements are
 * used to specify tuning when using tablature notation.
 * The optional number attribute specifies the staff number
 * from top to bottom on the system, as with clef. The
 * optional show-frets attribute indicates whether to show
 * tablature frets as numbers (0, 1, 2) or letters (a, b, c).
 * The default choice is numbers. The print-object attribute
 * is used to indicate when a staff is not printed in a part,
 * usually in large scores where empty parts are omitted.
 * It is yes by default. If print-spacing is yes while
 * print-object is no, the score is printed in cutaway
 * format where vertical space is left for the empty part.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}staff-type" minOccurs="0"/>
 *         &lt;element ref="{}staff-lines" minOccurs="0"/>
 *         &lt;element ref="{}staff-tuning" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}capo" minOccurs="0"/>
 *         &lt;element ref="{}staff-size" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}print-object"/>
 *       &lt;attGroup ref="{}print-spacing"/>
 *       &lt;attribute name="number" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="show-frets">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="numbers"/>
 *             &lt;enumeration value="letters"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "staffType",
    "staffLines",
    "staffTuning",
    "capo",
    "staffSize"
})
@XmlRootElement(name = "staff-details")
public class StaffDetails {

    @XmlElement(name = "staff-type")
    protected StaffType staffType;
    @XmlElement(name = "staff-lines")
    protected StaffLines staffLines;
    @XmlElement(name = "staff-tuning")
    protected List<StaffTuning> staffTuning;
    protected Capo capo;
    @XmlElement(name = "staff-size")
    protected StaffSize staffSize;
    @XmlAttribute
    protected java.lang.String number;
    @XmlAttribute(name = "show-frets")
    protected java.lang.String showFrets;
    @XmlAttribute(name = "print-object")
    protected java.lang.String printObject;
    @XmlAttribute(name = "print-spacing")
    protected java.lang.String printSpacing;

    /**
     * Gets the value of the staffType property.
     * 
     * @return
     *     possible object is
     *     {@link StaffType }
     *     
     */
    public StaffType getStaffType() {
        return staffType;
    }

    /**
     * Sets the value of the staffType property.
     * 
     * @param value
     *     allowed object is
     *     {@link StaffType }
     *     
     */
    public void setStaffType(StaffType value) {
        this.staffType = value;
    }

    /**
     * Gets the value of the staffLines property.
     * 
     * @return
     *     possible object is
     *     {@link StaffLines }
     *     
     */
    public StaffLines getStaffLines() {
        return staffLines;
    }

    /**
     * Sets the value of the staffLines property.
     * 
     * @param value
     *     allowed object is
     *     {@link StaffLines }
     *     
     */
    public void setStaffLines(StaffLines value) {
        this.staffLines = value;
    }

    /**
     * Gets the value of the staffTuning property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the staffTuning property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStaffTuning().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StaffTuning }
     * 
     * 
     */
    public List<StaffTuning> getStaffTuning() {
        if (staffTuning == null) {
            staffTuning = new ArrayList<StaffTuning>();
        }
        return this.staffTuning;
    }

    /**
     * Gets the value of the capo property.
     * 
     * @return
     *     possible object is
     *     {@link Capo }
     *     
     */
    public Capo getCapo() {
        return capo;
    }

    /**
     * Sets the value of the capo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Capo }
     *     
     */
    public void setCapo(Capo value) {
        this.capo = value;
    }

    /**
     * Gets the value of the staffSize property.
     * 
     * @return
     *     possible object is
     *     {@link StaffSize }
     *     
     */
    public StaffSize getStaffSize() {
        return staffSize;
    }

    /**
     * Sets the value of the staffSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link StaffSize }
     *     
     */
    public void setStaffSize(StaffSize value) {
        this.staffSize = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setNumber(java.lang.String value) {
        this.number = value;
    }

    /**
     * Gets the value of the showFrets property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getShowFrets() {
        return showFrets;
    }

    /**
     * Sets the value of the showFrets property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setShowFrets(java.lang.String value) {
        this.showFrets = value;
    }

    /**
     * Gets the value of the printObject property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPrintObject() {
        return printObject;
    }

    /**
     * Sets the value of the printObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPrintObject(java.lang.String value) {
        this.printObject = value;
    }

    /**
     * Gets the value of the printSpacing property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPrintSpacing() {
        return printSpacing;
    }

    /**
     * Sets the value of the printSpacing property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPrintSpacing(java.lang.String value) {
        this.printSpacing = value;
    }

}
