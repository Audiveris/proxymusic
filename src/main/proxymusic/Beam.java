
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Beam values include begin, continue, end, forward hook, and backward hook. Up to six concurrent beam levels are available to cover up to 256th notes. The repeater attribute, used for tremolos, needs to be specified with a "yes" value for each beam using it. Beams that have a begin value can also have a fan attribute to indicate accelerandos and ritardandos using fanned beams. The fan attribute may also be used with a continue value if the fanning direction changes on that note. The value is "none" if not specified.
 * 	
 * Note that the beam number does not distinguish sets of beams that overlap, as it does for slur and other elements. Beaming groups are distinguished by being in different voices and/or the presence or absence of grace and cue elements.
 * 
 * <p>Java class for beam complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="beam">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;>beam-value">
 *       &lt;attGroup ref="{}color"/>
 *       &lt;attribute name="number" type="{}beam-level" default="1" />
 *       &lt;attribute name="repeater" type="{}yes-no" />
 *       &lt;attribute name="fan" type="{}fan" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "beam", propOrder = {
    "value"
})
public class Beam {

    @XmlValue
    protected BeamValue value;
    @XmlAttribute
    protected Integer number;
    @XmlAttribute
    protected YesNo repeater;
    @XmlAttribute
    protected Fan fan;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String color;

    /**
     * The beam-value type represents the type of beam associated with each of 6 beam levels (up to 256th notes) available for each note.
     * 
     * @return
     *     possible object is
     *     {@link BeamValue }
     *     
     */
    public BeamValue getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link BeamValue }
     *     
     */
    public void setValue(BeamValue value) {
        this.value = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getNumber() {
        if (number == null) {
            return  1;
        } else {
            return number;
        }
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumber(Integer value) {
        this.number = value;
    }

    /**
     * Gets the value of the repeater property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getRepeater() {
        return repeater;
    }

    /**
     * Sets the value of the repeater property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setRepeater(YesNo value) {
        this.repeater = value;
    }

    /**
     * Gets the value of the fan property.
     * 
     * @return
     *     possible object is
     *     {@link Fan }
     *     
     */
    public Fan getFan() {
        return fan;
    }

    /**
     * Sets the value of the fan property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fan }
     *     
     */
    public void setFan(Fan value) {
        this.fan = value;
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

}
