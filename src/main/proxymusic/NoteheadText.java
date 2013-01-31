
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * The notehead-text type represents text that is displayed inside a notehead, as is done in some educational music. It is not needed for the numbers used in tablature or jianpu notation. The presence of a TAB or jianpu clefs is sufficient to indicate that numbers are used. The display-text and accidental-text elements allow display of fully formatted text and accidentals.
 * 
 * <p>Java class for notehead-text complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="notehead-text">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element name="display-text" type="{}formatted-text"/>
 *           &lt;element name="accidental-text" type="{}accidental-text"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notehead-text", propOrder = {
    "displayTextOrAccidentalText"
})
public class NoteheadText {

    @XmlElements({
        @XmlElement(name = "display-text", type = FormattedText.class),
        @XmlElement(name = "accidental-text", type = AccidentalText.class)
    })
    protected List<Object> displayTextOrAccidentalText;

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
     * {@link FormattedText }
     * {@link AccidentalText }
     * 
     * 
     */
    public List<Object> getDisplayTextOrAccidentalText() {
        if (displayTextOrAccidentalText == null) {
            displayTextOrAccidentalText = new ArrayList<Object>();
        }
        return this.displayTextOrAccidentalText;
    }

}
