
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{}note"/>
 *           &lt;element ref="{}backup"/>
 *           &lt;element ref="{}forward"/>
 *           &lt;element ref="{}direction"/>
 *           &lt;element ref="{}attributes"/>
 *           &lt;element ref="{}harmony"/>
 *           &lt;element ref="{}figured-bass"/>
 *           &lt;element ref="{}print"/>
 *           &lt;element ref="{}sound"/>
 *           &lt;element ref="{}barline"/>
 *           &lt;element ref="{}grouping"/>
 *           &lt;element ref="{}link"/>
 *           &lt;element ref="{}bookmark"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="implicit">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="yes"/>
 *             &lt;enumeration value="no"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="non-controlling">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="yes"/>
 *             &lt;enumeration value="no"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="number" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "noteOrBackupOrForward"
})
@XmlRootElement(name = "measure")
public class Measure {

    @XmlElements({
        @XmlElement(name = "backup", type = Backup.class),
        @XmlElement(name = "bookmark", type = Bookmark.class),
        @XmlElement(name = "grouping", type = Grouping.class),
        @XmlElement(name = "link", type = Link.class),
        @XmlElement(name = "note", type = Note.class),
        @XmlElement(name = "direction", type = Direction.class),
        @XmlElement(name = "forward", type = Forward.class),
        @XmlElement(name = "figured-bass", type = FiguredBass.class),
        @XmlElement(name = "attributes", type = Attributes.class),
        @XmlElement(name = "sound", type = Sound.class),
        @XmlElement(name = "print", type = Print.class),
        @XmlElement(name = "barline", type = Barline.class),
        @XmlElement(name = "harmony", type = Harmony.class)
    })
    protected List<Object> noteOrBackupOrForward;
    @XmlAttribute
    protected java.lang.String implicit;
    @XmlAttribute(name = "non-controlling")
    protected java.lang.String nonControlling;
    @XmlAttribute(required = true)
    protected java.lang.String number;
    @XmlAttribute
    protected java.lang.String width;

    /**
     * Gets the value of the noteOrBackupOrForward property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the noteOrBackupOrForward property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNoteOrBackupOrForward().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Backup }
     * {@link Bookmark }
     * {@link Grouping }
     * {@link Link }
     * {@link Note }
     * {@link Direction }
     * {@link Forward }
     * {@link FiguredBass }
     * {@link Attributes }
     * {@link Sound }
     * {@link Print }
     * {@link Barline }
     * {@link Harmony }
     * 
     * 
     */
    public List<Object> getNoteOrBackupOrForward() {
        if (noteOrBackupOrForward == null) {
            noteOrBackupOrForward = new ArrayList<Object>();
        }
        return this.noteOrBackupOrForward;
    }

    /**
     * Gets the value of the implicit property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getImplicit() {
        return implicit;
    }

    /**
     * Sets the value of the implicit property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setImplicit(java.lang.String value) {
        this.implicit = value;
    }

    /**
     * Gets the value of the nonControlling property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getNonControlling() {
        return nonControlling;
    }

    /**
     * Sets the value of the nonControlling property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setNonControlling(java.lang.String value) {
        this.nonControlling = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setNumber(java.lang.String value) {
        this.number = value;
    }

    /**
     * Gets the value of the width property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setWidth(java.lang.String value) {
        this.width = value;
    }

}
