
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * The beater type represents pictograms for beaters, mallets, and sticks that do not have different materials represented in the pictogram.
 * 
 * <p>Java class for beater complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="beater">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;>beater-value">
 *       &lt;attribute name="tip" type="{}tip-direction" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "beater", propOrder = {
    "value"
})
public class Beater {

    @XmlValue
    protected BeaterValue value;
    @XmlAttribute(name = "tip")
    protected TipDirection tip;

    /**
     * The beater-value type represents pictograms for beaters, mallets, and sticks that do not have different materials represented in the pictogram. The finger and hammer values are in addition to Stone's list.
     * 
     * @return
     *     possible object is
     *     {@link BeaterValue }
     *     
     */
    public BeaterValue getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link BeaterValue }
     *     
     */
    public void setValue(BeaterValue value) {
        this.value = value;
    }

    /**
     * Gets the value of the tip property.
     * 
     * @return
     *     possible object is
     *     {@link TipDirection }
     *     
     */
    public TipDirection getTip() {
        return tip;
    }

    /**
     * Sets the value of the tip property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipDirection }
     *     
     */
    public void setTip(TipDirection value) {
        this.tip = value;
    }

}
