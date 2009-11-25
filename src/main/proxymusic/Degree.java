
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The degree type is used to add, alter, or subtract individual notes in the chord. The print-object attribute can be used to keep the degree from printing separately when it has already taken into account in the text attribute of the kind element. The degree-value and degree-type text attributes specify how the value and type of the degree should be displayed.
 * 	
 * A harmony of kind "other" can be spelled explicitly by using a series of degree elements together with a root.
 * 
 * <p>Java class for degree complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="degree">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="degree-value" type="{}degree-value"/>
 *         &lt;element name="degree-alter" type="{}degree-alter"/>
 *         &lt;element name="degree-type" type="{}degree-type"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}print-object"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "degree", propOrder = {
    "degreeValue",
    "degreeAlter",
    "degreeType"
})
public class Degree {

    @XmlElement(name = "degree-value", required = true)
    protected DegreeValue degreeValue;
    @XmlElement(name = "degree-alter", required = true)
    protected DegreeAlter degreeAlter;
    @XmlElement(name = "degree-type", required = true)
    protected DegreeType degreeType;
    @XmlAttribute(name = "print-object")
    protected YesNo printObject;

    /**
     * Gets the value of the degreeValue property.
     * 
     * @return
     *     possible object is
     *     {@link DegreeValue }
     *     
     */
    public DegreeValue getDegreeValue() {
        return degreeValue;
    }

    /**
     * Sets the value of the degreeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link DegreeValue }
     *     
     */
    public void setDegreeValue(DegreeValue value) {
        this.degreeValue = value;
    }

    /**
     * Gets the value of the degreeAlter property.
     * 
     * @return
     *     possible object is
     *     {@link DegreeAlter }
     *     
     */
    public DegreeAlter getDegreeAlter() {
        return degreeAlter;
    }

    /**
     * Sets the value of the degreeAlter property.
     * 
     * @param value
     *     allowed object is
     *     {@link DegreeAlter }
     *     
     */
    public void setDegreeAlter(DegreeAlter value) {
        this.degreeAlter = value;
    }

    /**
     * Gets the value of the degreeType property.
     * 
     * @return
     *     possible object is
     *     {@link DegreeType }
     *     
     */
    public DegreeType getDegreeType() {
        return degreeType;
    }

    /**
     * Sets the value of the degreeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DegreeType }
     *     
     */
    public void setDegreeType(DegreeType value) {
        this.degreeType = value;
    }

    /**
     * Gets the value of the printObject property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getPrintObject() {
        return printObject;
    }

    /**
     * Sets the value of the printObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setPrintObject(YesNo value) {
        this.printObject = value;
    }

}
