
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * The interchangeable type is used to represent the second in a pair of interchangeable dual time signatures, such as the 6/8 in 3/4 (6/8). A separate symbol attribute value is available compared to the time element's symbol attribute, which applies to the first of the dual time signatures. The parentheses attribute value is yes by default.
 * 
 * <p>Java class for interchangeable complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="interchangeable">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="time-relation" type="{}time-relation" minOccurs="0"/>
 *         &lt;group ref="{}time-signature" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="symbol" type="{}time-symbol" />
 *       &lt;attribute name="separator" type="{}time-separator" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "interchangeable", propOrder = {
    "timeRelation",
    "timeSignature"
})
public class Interchangeable {

    @XmlElement(name = "time-relation")
    protected TimeRelation timeRelation;
    @XmlElementRefs({
        @XmlElementRef(name = "beat-type", type = JAXBElement.class),
        @XmlElementRef(name = "beats", type = JAXBElement.class)
    })
    protected List<JAXBElement<java.lang.String>> timeSignature;
    @XmlAttribute(name = "symbol")
    protected TimeSymbol symbol;
    @XmlAttribute(name = "separator")
    protected TimeSeparator separator;

    /**
     * Gets the value of the timeRelation property.
     * 
     * @return
     *     possible object is
     *     {@link TimeRelation }
     *     
     */
    public TimeRelation getTimeRelation() {
        return timeRelation;
    }

    /**
     * Sets the value of the timeRelation property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeRelation }
     *     
     */
    public void setTimeRelation(TimeRelation value) {
        this.timeRelation = value;
    }

    /**
     * Gets the value of the timeSignature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the timeSignature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTimeSignature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     * {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<java.lang.String>> getTimeSignature() {
        if (timeSignature == null) {
            timeSignature = new ArrayList<JAXBElement<java.lang.String>>();
        }
        return this.timeSignature;
    }

    /**
     * Gets the value of the symbol property.
     * 
     * @return
     *     possible object is
     *     {@link TimeSymbol }
     *     
     */
    public TimeSymbol getSymbol() {
        return symbol;
    }

    /**
     * Sets the value of the symbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeSymbol }
     *     
     */
    public void setSymbol(TimeSymbol value) {
        this.symbol = value;
    }

    /**
     * Gets the value of the separator property.
     * 
     * @return
     *     possible object is
     *     {@link TimeSeparator }
     *     
     */
    public TimeSeparator getSeparator() {
        return separator;
    }

    /**
     * Sets the value of the separator property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeSeparator }
     *     
     */
    public void setSeparator(TimeSeparator value) {
        this.separator = value;
    }

}
