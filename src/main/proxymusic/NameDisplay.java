
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * The name-display type ais used for exact formatting of multi-font text in part and group names to the left of the system. The print-object attribute can be used to determine what, if anything, is printed at the start of each system. Enclosure for the display-text element is none by default. Language for the display-text element is Italian ("it") by default. Formatting specified in the part-name-display element overrides the formatting specified in the part-name element.
 * 
 * <p>Java class for name-display complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="name-display">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="display-text" type="{}formatted-text"/>
 *           &lt;element name="accidental-text" type="{}accidental-text"/>
 *         &lt;/choice>
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
@XmlType(name = "name-display", propOrder = {
    "displayTextOrAccidentalText"
})
public class NameDisplay {

    @XmlElements({
        @XmlElement(name = "accidental-text", type = AccidentalText.class),
        @XmlElement(name = "display-text", type = FormattedText.class)
    })
    protected List<Object> displayTextOrAccidentalText;
    @XmlAttribute(name = "print-object")
    protected YesNo printObject;

    /**
     * Gets the value of the displayTextOrAccidentalText property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the displayTextOrAccidentalText property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisplayTextOrAccidentalText().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccidentalText }
     * {@link FormattedText }
     * 
     * 
     */
    public List<Object> getDisplayTextOrAccidentalText() {
        if (displayTextOrAccidentalText == null) {
            displayTextOrAccidentalText = new ArrayList<Object>();
        }
        return this.displayTextOrAccidentalText;
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
