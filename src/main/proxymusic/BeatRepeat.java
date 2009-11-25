
package proxymusic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * The beat-repeat type is used to indicate that a single beat (but possibly many notes) is repeated. Both the start and stop of the beat being repeated should be specified. The slashes attribute specifies the number of slashes to use in the symbol. The use-dots attribute indicates whether or not to use dots as well (for instance, with mixed rhythm patterns). By default, the value for slashes is 1 and the value for use-dots is no.
 * 	
 * The beat-repeat element specifies a notation style for repetitions. The actual music being repeated needs to be repeated within the MusicXML file. This element specifies the notation that indicates the repeat.
 * 
 * <p>Java class for beat-repeat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="beat-repeat">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;group ref="{}slash" minOccurs="0"/>
 *       &lt;attribute name="type" use="required" type="{}start-stop" />
 *       &lt;attribute name="slashes" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="use-dots" type="{}yes-no" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "beat-repeat", propOrder = {
    "slashType",
    "slashDot"
})
public class BeatRepeat {

    @XmlElement(name = "slash-type")
    protected java.lang.String slashType;
    @XmlElement(name = "slash-dot")
    protected List<Empty> slashDot;
    @XmlAttribute(required = true)
    protected StartStop type;
    @XmlAttribute
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger slashes;
    @XmlAttribute(name = "use-dots")
    protected YesNo useDots;

    /**
     * Gets the value of the slashType property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getSlashType() {
        return slashType;
    }

    /**
     * Sets the value of the slashType property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setSlashType(java.lang.String value) {
        this.slashType = value;
    }

    /**
     * Gets the value of the slashDot property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the slashDot property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSlashDot().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Empty }
     * 
     * 
     */
    public List<Empty> getSlashDot() {
        if (slashDot == null) {
            slashDot = new ArrayList<Empty>();
        }
        return this.slashDot;
    }

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
     * Gets the value of the slashes property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSlashes() {
        return slashes;
    }

    /**
     * Sets the value of the slashes property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSlashes(BigInteger value) {
        this.slashes = value;
    }

    /**
     * Gets the value of the useDots property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getUseDots() {
        return useDots;
    }

    /**
     * Sets the value of the useDots property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setUseDots(YesNo value) {
        this.useDots = value;
    }

}
