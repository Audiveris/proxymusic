
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * Encoding contains information about who did the digital
 * encoding, when, with what software, and in what aspects.
 * The supports element indicates if the encoding supports
 * a particular MusicXML element. This is recommended for
 * elements like beam, stem, and accidental, where the
 * absence of an element is ambiguous if you do not know
 * if the encoding supports that element.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{}encoding-date"/>
 *           &lt;element ref="{}encoder"/>
 *           &lt;element ref="{}software"/>
 *           &lt;element ref="{}encoding-description"/>
 *           &lt;element ref="{}supports"/>
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
@XmlType(name = "", propOrder = {
    "encodingDateOrEncoderOrSoftware"
})
@XmlRootElement(name = "encoding")
public class Encoding {

    @XmlElements({
        @XmlElement(name = "encoder", type = Encoder.class),
        @XmlElement(name = "encoding-date", type = EncodingDate.class),
        @XmlElement(name = "encoding-description", type = EncodingDescription.class),
        @XmlElement(name = "software", type = Software.class),
        @XmlElement(name = "supports", type = Supports.class)
    })
    protected List<Object> encodingDateOrEncoderOrSoftware;

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
     * {@link Encoder }
     * {@link EncodingDate }
     * {@link EncodingDescription }
     * {@link Software }
     * {@link Supports }
     * 
     * 
     */
    public List<Object> getEncodingDateOrEncoderOrSoftware() {
        if (encodingDateOrEncoderOrSoftware == null) {
            encodingDateOrEncoderOrSoftware = new ArrayList<Object>();
        }
        return this.encodingDateOrEncoderOrSoftware;
    }

}
