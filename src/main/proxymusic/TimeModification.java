
package proxymusic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * The time-modification type represents tuplets and other durational changes.
 * 
 * <p>Java class for time-modification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="time-modification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="actual-notes" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="normal-notes" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;sequence minOccurs="0">
 *           &lt;element name="normal-type" type="{}note-type-value"/>
 *           &lt;element name="normal-dot" type="{}empty" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "time-modification", propOrder = {
    "actualNotes",
    "normalNotes",
    "normalType",
    "normalDot"
})
@XmlSeeAlso({
    MetronomeTuplet.class
})
public class TimeModification {

    @XmlElement(name = "actual-notes", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger actualNotes;
    @XmlElement(name = "normal-notes", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger normalNotes;
    @XmlElement(name = "normal-type")
    protected java.lang.String normalType;
    @XmlElement(name = "normal-dot")
    protected List<Empty> normalDot;

    /**
     * Gets the value of the actualNotes property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getActualNotes() {
        return actualNotes;
    }

    /**
     * Sets the value of the actualNotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setActualNotes(BigInteger value) {
        this.actualNotes = value;
    }

    /**
     * Gets the value of the normalNotes property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNormalNotes() {
        return normalNotes;
    }

    /**
     * Sets the value of the normalNotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNormalNotes(BigInteger value) {
        this.normalNotes = value;
    }

    /**
     * Gets the value of the normalType property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getNormalType() {
        return normalType;
    }

    /**
     * Sets the value of the normalType property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setNormalType(java.lang.String value) {
        this.normalType = value;
    }

    /**
     * Gets the value of the normalDot property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the normalDot property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNormalDot().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Empty }
     * 
     * 
     */
    public List<Empty> getNormalDot() {
        if (normalDot == null) {
            normalDot = new ArrayList<Empty>();
        }
        return this.normalDot;
    }

}
