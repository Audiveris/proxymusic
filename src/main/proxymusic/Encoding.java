
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * The encoding element contains information about who did the digital encoding, when, with what software, and in what aspects. Standard type values for the encoder element are music, words, and arrangement, but other types may be used. The type attribute is only needed when there are multiple encoder elements.
 * 
 * <p>Java class for encoding complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="encoding">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="encoding-date" type="{}yyyy-mm-dd"/>
 *         &lt;element name="encoder" type="{}typed-text"/>
 *         &lt;element name="software" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="encoding-description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="supports" type="{}supports"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "encoding", propOrder = {
    "encodingDateOrEncoderOrSoftware"
})
public class Encoding {

    @XmlElementRefs({
        @XmlElementRef(name = "encoder", type = JAXBElement.class),
        @XmlElementRef(name = "encoding-description", type = JAXBElement.class),
        @XmlElementRef(name = "software", type = JAXBElement.class),
        @XmlElementRef(name = "supports", type = JAXBElement.class),
        @XmlElementRef(name = "encoding-date", type = JAXBElement.class)
    })
    protected List<JAXBElement<?>> encodingDateOrEncoderOrSoftware;

    /**
     * Gets the value of the encodingDateOrEncoderOrSoftware property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the encodingDateOrEncoderOrSoftware property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEncodingDateOrEncoderOrSoftware().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     * {@link JAXBElement }{@code <}{@link TypedText }{@code >}
     * {@link JAXBElement }{@code <}{@link Supports }{@code >}
     * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getEncodingDateOrEncoderOrSoftware() {
        if (encodingDateOrEncoderOrSoftware == null) {
            encodingDateOrEncoderOrSoftware = new ArrayList<JAXBElement<?>>();
        }
        return this.encodingDateOrEncoderOrSoftware;
    }

}
