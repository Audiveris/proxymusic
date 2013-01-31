
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * The play type, new in Version 3.0, specifies playback techniques to be used in conjunction with the instrument-sound element. When used as part of a sound element, it applies to all notes going forward in score order. In multi-instrument parts, the affected instrument should be specified using the id attribute. When used as part of a note element, it applies to the current note only.
 * 
 * <p>Java class for play complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="play">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="ipa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="mute" type="{}mute"/>
 *           &lt;element name="semi-pitched" type="{}semi-pitched"/>
 *           &lt;element name="other-play" type="{}other-play"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "play", propOrder = {
    "ipaOrMuteOrSemiPitched"
})
public class Play {

    @XmlElements({
        @XmlElement(name = "ipa", type = java.lang.String.class),
        @XmlElement(name = "mute", type = Mute.class),
        @XmlElement(name = "semi-pitched", type = SemiPitched.class),
        @XmlElement(name = "other-play", type = OtherPlay.class)
    })
    protected List<Object> ipaOrMuteOrSemiPitched;
    @XmlAttribute(name = "id")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object id;

    /**
     * Gets the value of the ipaOrMuteOrSemiPitched property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ipaOrMuteOrSemiPitched property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIpaOrMuteOrSemiPitched().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link java.lang.String }
     * {@link Mute }
     * {@link SemiPitched }
     * {@link OtherPlay }
     * 
     * 
     */
    public List<Object> getIpaOrMuteOrSemiPitched() {
        if (ipaOrMuteOrSemiPitched == null) {
            ipaOrMuteOrSemiPitched = new ArrayList<Object>();
        }
        return this.ipaOrMuteOrSemiPitched;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setId(Object value) {
        this.id = value;
    }

}
