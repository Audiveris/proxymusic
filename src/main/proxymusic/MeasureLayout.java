
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * Measure layout includes the horizontal distance
 * from the previous measure. This value is only used
 * for systems where there is horizontal whitespace
 * in the middle of a system, as in systems with codas.
 * To specify the measure width, use the width attribute
 * of the measure element.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}measure-distance" minOccurs="0"/>
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
    "measureDistance"
})
@XmlRootElement(name = "measure-layout")
public class MeasureLayout {

    @XmlElement(name = "measure-distance")
    protected MeasureDistance measureDistance;

    /**
     * Gets the value of the measureDistance property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureDistance }
     *     
     */
    public MeasureDistance getMeasureDistance() {
        return measureDistance;
    }

    /**
     * Sets the value of the measureDistance property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureDistance }
     *     
     */
    public void setMeasureDistance(MeasureDistance value) {
        this.measureDistance = value;
    }

}
