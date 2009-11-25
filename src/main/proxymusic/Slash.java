
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The slash type is used to indicate that slash notation is to be used. If the slash is on every beat, use-stems is no (the default). To indicate rhythms but not pitches, use-stems is set to yes. The type attribute indicates whether this is the start or stop of a slash notation style. The use-dots attribute works as for the beat-repeat element, and only has effect if use-stems is no.
 * 
 * <p>Java class for slash complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="slash">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;group ref="{}slash" minOccurs="0"/>
 *       &lt;attribute name="type" use="required" type="{}start-stop" />
 *       &lt;attribute name="use-dots" type="{}yes-no" />
 *       &lt;attribute name="use-stems" type="{}yes-no" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "slash", propOrder = {
    "slashType",
    "slashDot"
})
public class Slash {

    @XmlElement(name = "slash-type")
    protected java.lang.String slashType;
    @XmlElement(name = "slash-dot")
    protected List<Empty> slashDot;
    @XmlAttribute(required = true)
    protected StartStop type;
    @XmlAttribute(name = "use-dots")
    protected YesNo useDots;
    @XmlAttribute(name = "use-stems")
    protected YesNo useStems;

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

    /**
     * Gets the value of the useStems property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getUseStems() {
        return useStems;
    }

    /**
     * Sets the value of the useStems property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setUseStems(YesNo value) {
        this.useStems = value;
    }

}
