
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * Time signatures are represented by two elements. The
 * beats element indicates the number of beats, as found in
 * the numerator of a time signature. The beat-type element
 * indicates the beat unit, as found in the denominator of
 * a time signature. The symbol attribute is used to
 * indicate another notation beyond a fraction: the common
 * and cut time symbols, as well as a single number with an
 * implied denominator. Normal (a fraction) is the implied
 * symbol type if none is specified. Multiple pairs of
 * beat and beat-type elements are used for composite
 * time signatures with multiple denominators, such as
 * 2/4 + 3/8. A composite such as 3+2/8 requires only one
 * beat/beat-type pair. A senza-misura element explicitly
 * indicates that no time signature is present.
 * 
 * The print-object attribute allows a time signature to be
 * specified but not printed, as is the case for excerpts
 * from the middle of a score. The value is "yes" if
 * not present. The optional number attribute refers to staff
 * numbers, from top to bottom on the system. If absent, the
 * time signature applies to all staves in the part.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence maxOccurs="unbounded">
 *           &lt;element ref="{}beats"/>
 *           &lt;element ref="{}beat-type"/>
 *         &lt;/sequence>
 *         &lt;element ref="{}senza-misura"/>
 *       &lt;/choice>
 *       &lt;attGroup ref="{}color"/>
 *       &lt;attGroup ref="{}print-object"/>
 *       &lt;attribute name="number" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="symbol">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="common"/>
 *             &lt;enumeration value="cut"/>
 *             &lt;enumeration value="single-number"/>
 *             &lt;enumeration value="normal"/>
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
    "beatsAndBeatType",
    "senzaMisura"
})
@XmlRootElement(name = "time")
public class Time {

    @XmlElements({
        @XmlElement(name = "beat-type", type = BeatType.class),
        @XmlElement(name = "beats", type = Beats.class)
    })
    protected List<Object> beatsAndBeatType;
    @XmlElement(name = "senza-misura")
    protected SenzaMisura senzaMisura;
    @XmlAttribute
    protected java.lang.String number;
    @XmlAttribute
    protected java.lang.String symbol;
    @XmlAttribute
    protected java.lang.String color;
    @XmlAttribute(name = "print-object")
    protected java.lang.String printObject;

    /**
     * Gets the value of the beatsAndBeatType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the beatsAndBeatType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBeatsAndBeatType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BeatType }
     * {@link Beats }
     * 
     * 
     */
    public List<Object> getBeatsAndBeatType() {
        if (beatsAndBeatType == null) {
            beatsAndBeatType = new ArrayList<Object>();
        }
        return this.beatsAndBeatType;
    }

    /**
     * Gets the value of the senzaMisura property.
     * 
     * @return
     *     possible object is
     *     {@link SenzaMisura }
     *     
     */
    public SenzaMisura getSenzaMisura() {
        return senzaMisura;
    }

    /**
     * Sets the value of the senzaMisura property.
     * 
     * @param value
     *     allowed object is
     *     {@link SenzaMisura }
     *     
     */
    public void setSenzaMisura(SenzaMisura value) {
        this.senzaMisura = value;
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
     * Gets the value of the symbol property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getSymbol() {
        return symbol;
    }

    /**
     * Sets the value of the symbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setSymbol(java.lang.String value) {
        this.symbol = value;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setColor(java.lang.String value) {
        this.color = value;
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

}
