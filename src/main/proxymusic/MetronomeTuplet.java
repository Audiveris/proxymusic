
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * The metronome-tuplet type uses the same element structure as the time-modification element along with some attributes from the tuplet element.
 * 
 * <p>Java class for metronome-tuplet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="metronome-tuplet">
 *   &lt;complexContent>
 *     &lt;extension base="{}time-modification">
 *       &lt;attribute name="type" use="required" type="{}start-stop" />
 *       &lt;attribute name="bracket" type="{}yes-no" />
 *       &lt;attribute name="show-number" type="{}show-tuplet" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "metronome-tuplet")
public class MetronomeTuplet
    extends TimeModification
{

    @XmlAttribute(required = true)
    protected StartStop type;
    @XmlAttribute
    protected YesNo bracket;
    @XmlAttribute(name = "show-number")
    protected ShowTuplet showNumber;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link StartStop }
     *     
     */
    public StartStop getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link StartStop }
     *     
     */
    public void setType(StartStop value) {
        this.type = value;
    }

    /**
     * Gets the value of the bracket property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getBracket() {
        return bracket;
    }

    /**
     * Sets the value of the bracket property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setBracket(YesNo value) {
        this.bracket = value;
    }

    /**
     * Gets the value of the showNumber property.
     * 
     * @return
     *     possible object is
     *     {@link ShowTuplet }
     *     
     */
    public ShowTuplet getShowNumber() {
        return showNumber;
    }

    /**
     * Sets the value of the showNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShowTuplet }
     *     
     */
    public void setShowNumber(ShowTuplet value) {
        this.showNumber = value;
    }

}
