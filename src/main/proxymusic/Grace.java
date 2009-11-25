
package proxymusic;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * The grace type indicates the presence of a grace note. The slash attribute for a grace note is yes for slashed eighth notes. The other grace note attributes come from MuseData sound suggestions. Steal-time-previous indicates the percentage of time to steal from the previous note for the grace note. Steal-time-following indicates the percentage of time to steal from the following note for the grace note. Make-time indicates to make time, not steal time; the units are in real-time divisions for the grace note.
 * 
 * <p>Java class for grace complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="grace">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="steal-time-previous" type="{}percent" />
 *       &lt;attribute name="steal-time-following" type="{}percent" />
 *       &lt;attribute name="make-time" type="{}divisions" />
 *       &lt;attribute name="slash" type="{}yes-no" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "grace")
public class Grace {

    @XmlAttribute(name = "steal-time-previous")
    protected BigDecimal stealTimePrevious;
    @XmlAttribute(name = "steal-time-following")
    protected BigDecimal stealTimeFollowing;
    @XmlAttribute(name = "make-time")
    protected BigDecimal makeTime;
    @XmlAttribute
    protected YesNo slash;

    /**
     * Gets the value of the stealTimePrevious property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getStealTimePrevious() {
        return stealTimePrevious;
    }

    /**
     * Sets the value of the stealTimePrevious property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setStealTimePrevious(BigDecimal value) {
        this.stealTimePrevious = value;
    }

    /**
     * Gets the value of the stealTimeFollowing property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getStealTimeFollowing() {
        return stealTimeFollowing;
    }

    /**
     * Sets the value of the stealTimeFollowing property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setStealTimeFollowing(BigDecimal value) {
        this.stealTimeFollowing = value;
    }

    /**
     * Gets the value of the makeTime property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMakeTime() {
        return makeTime;
    }

    /**
     * Sets the value of the makeTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMakeTime(BigDecimal value) {
        this.makeTime = value;
    }

    /**
     * Gets the value of the slash property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getSlash() {
        return slash;
    }

    /**
     * Sets the value of the slash property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setSlash(YesNo value) {
        this.slash = value;
    }

}
