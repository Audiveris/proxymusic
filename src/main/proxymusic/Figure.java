
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The figure type represents a single figure within a figured-bass element. 
 * 
 * <p>Java class for figure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="figure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="prefix" type="{}style-text" minOccurs="0"/>
 *         &lt;element name="figure-number" type="{}style-text" minOccurs="0"/>
 *         &lt;element name="suffix" type="{}style-text" minOccurs="0"/>
 *         &lt;element name="extend" type="{}extend"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "figure", propOrder = {
    "prefix",
    "figureNumber",
    "suffix",
    "extend"
})
public class Figure {

    protected StyleText prefix;
    @XmlElement(name = "figure-number")
    protected StyleText figureNumber;
    protected StyleText suffix;
    @XmlElement(required = true)
    protected Extend extend;

    /**
     * Gets the value of the prefix property.
     * 
     * @return
     *     possible object is
     *     {@link StyleText }
     *     
     */
    public StyleText getPrefix() {
        return prefix;
    }

    /**
     * Sets the value of the prefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link StyleText }
     *     
     */
    public void setPrefix(StyleText value) {
        this.prefix = value;
    }

    /**
     * Gets the value of the figureNumber property.
     * 
     * @return
     *     possible object is
     *     {@link StyleText }
     *     
     */
    public StyleText getFigureNumber() {
        return figureNumber;
    }

    /**
     * Sets the value of the figureNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link StyleText }
     *     
     */
    public void setFigureNumber(StyleText value) {
        this.figureNumber = value;
    }

    /**
     * Gets the value of the suffix property.
     * 
     * @return
     *     possible object is
     *     {@link StyleText }
     *     
     */
    public StyleText getSuffix() {
        return suffix;
    }

    /**
     * Sets the value of the suffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link StyleText }
     *     
     */
    public void setSuffix(StyleText value) {
        this.suffix = value;
    }

    /**
     * Gets the value of the extend property.
     * 
     * @return
     *     possible object is
     *     {@link Extend }
     *     
     */
    public Extend getExtend() {
        return extend;
    }

    /**
     * Sets the value of the extend property.
     * 
     * @param value
     *     allowed object is
     *     {@link Extend }
     *     
     */
    public void setExtend(Extend value) {
        this.extend = value;
    }

}
