
package proxymusic;

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
 * The degree element is used to add, alter, or subtract
 * individual notes in the chord. The degree-value element
 * is a number indicating the degree of the chord (1 for
 * the root, 3 for third, etc). The degree-alter element
 * is like the alter element in notes: 1 for sharp, -1 for
 * flat, etc. The degree-type element can be add, alter, or
 * subtract. If the degree-type is alter or subtract, the
 * degree-alter is relative to the degree already in the
 * chord based on its kind element. If the degree-type is
 * add, the degree-alter is relative to a dominant chord
 * (major and perfect intervals except for a minor
 * seventh). The print-object attribute can be used to
 * keep the degree from printing separately when it has
 * already taken into account in the text attribute of
 * the kind element.
 * 
 * A harmony of kind "other" can be spelled explicitly by
 * using a series of degree elements together with a root.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}degree-value"/>
 *         &lt;element ref="{}degree-alter"/>
 *         &lt;element ref="{}degree-type"/>
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
@XmlType(name = "", propOrder = {
    "degreeValue",
    "degreeAlter",
    "degreeType"
})
@XmlRootElement(name = "degree")
public class Degree {

    @XmlElement(name = "degree-value", required = true)
    protected DegreeValue degreeValue;
    @XmlElement(name = "degree-alter", required = true)
    protected DegreeAlter degreeAlter;
    @XmlElement(name = "degree-type", required = true)
    protected DegreeType degreeType;
    @XmlAttribute(name = "print-object")
    protected java.lang.String printObject;

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
