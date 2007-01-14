
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}prefix" minOccurs="0"/>
 *         &lt;element ref="{}figure-number" minOccurs="0"/>
 *         &lt;element ref="{}suffix" minOccurs="0"/>
 *         &lt;element ref="{}extend" minOccurs="0"/>
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
    "prefix",
    "figureNumber",
    "suffix",
    "extend"
})
@XmlRootElement(name = "figure")
public class Figure {

    protected Prefix prefix;
    @XmlElement(name = "figure-number")
    protected FigureNumber figureNumber;
    protected Suffix suffix;
    protected Extend extend;

    /**
     * Gets the value of the prefix property.
     * 
     * @return
     *     possible object is
     *     {@link Prefix }
     *     
     */
    public Prefix getPrefix() {
        return prefix;
    }

    /**
     * Sets the value of the prefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link Prefix }
     *     
     */
    public void setPrefix(Prefix value) {
        this.prefix = value;
    }

    /**
     * Gets the value of the figureNumber property.
     * 
     * @return
     *     possible object is
     *     {@link FigureNumber }
     *     
     */
    public FigureNumber getFigureNumber() {
        return figureNumber;
    }

    /**
     * Sets the value of the figureNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link FigureNumber }
     *     
     */
    public void setFigureNumber(FigureNumber value) {
        this.figureNumber = value;
    }

    /**
     * Gets the value of the suffix property.
     * 
     * @return
     *     possible object is
     *     {@link Suffix }
     *     
     */
    public Suffix getSuffix() {
        return suffix;
    }

    /**
     * Sets the value of the suffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link Suffix }
     *     
     */
    public void setSuffix(Suffix value) {
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
