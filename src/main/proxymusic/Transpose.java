
package proxymusic;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The transpose type represents what must be added to a written pitch to get a correct sounding pitch.
 * 
 * <p>Java class for transpose complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transpose">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="diatonic" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="chromatic" type="{}semitones"/>
 *         &lt;element name="octave-change" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="double" type="{}empty" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transpose", propOrder = {
    "diatonic",
    "chromatic",
    "octaveChange",
    "_double"
})
public class Transpose {

    protected BigInteger diatonic;
    @XmlElement(required = true)
    protected BigDecimal chromatic;
    @XmlElement(name = "octave-change")
    protected BigInteger octaveChange;
    @XmlElement(name = "double")
    protected Empty _double;

    /**
     * Gets the value of the diatonic property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDiatonic() {
        return diatonic;
    }

    /**
     * Sets the value of the diatonic property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDiatonic(BigInteger value) {
        this.diatonic = value;
    }

    /**
     * Gets the value of the chromatic property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getChromatic() {
        return chromatic;
    }

    /**
     * Sets the value of the chromatic property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setChromatic(BigDecimal value) {
        this.chromatic = value;
    }

    /**
     * Gets the value of the octaveChange property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOctaveChange() {
        return octaveChange;
    }

    /**
     * Sets the value of the octaveChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOctaveChange(BigInteger value) {
        this.octaveChange = value;
    }

    /**
     * Gets the value of the double property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getDouble() {
        return _double;
    }

    /**
     * Sets the value of the double property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setDouble(Empty value) {
        this._double = value;
    }

}
