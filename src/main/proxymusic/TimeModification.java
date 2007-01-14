
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * Time modification indicates tuplets and other
 * durational changes. The actual-notes element describes
 * how many notes are played in the time usually occupied
 * by the number of normal-notes. If the normal-notes type
 * is different than the current note type (e.g., a
 * quarter note within an eighth note triplet), then the
 * normal-notes type (e.g. eighth) is specified in the
 * normal-type and normal-dot elements.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}actual-notes"/>
 *         &lt;element ref="{}normal-notes"/>
 *         &lt;sequence minOccurs="0">
 *           &lt;element ref="{}normal-type"/>
 *           &lt;element ref="{}normal-dot" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/sequence>
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
    "actualNotes",
    "normalNotes",
    "normalType",
    "normalDot"
})
@XmlRootElement(name = "time-modification")
public class TimeModification {

    @XmlElement(name = "actual-notes", required = true)
    protected ActualNotes actualNotes;
    @XmlElement(name = "normal-notes", required = true)
    protected NormalNotes normalNotes;
    @XmlElement(name = "normal-type")
    protected NormalType normalType;
    @XmlElement(name = "normal-dot")
    protected List<NormalDot> normalDot;

    /**
     * Gets the value of the actualNotes property.
     * 
     * @return
     *     possible object is
     *     {@link ActualNotes }
     *     
     */
    public ActualNotes getActualNotes() {
        return actualNotes;
    }

    /**
     * Sets the value of the actualNotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActualNotes }
     *     
     */
    public void setActualNotes(ActualNotes value) {
        this.actualNotes = value;
    }

    /**
     * Gets the value of the normalNotes property.
     * 
     * @return
     *     possible object is
     *     {@link NormalNotes }
     *     
     */
    public NormalNotes getNormalNotes() {
        return normalNotes;
    }

    /**
     * Sets the value of the normalNotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link NormalNotes }
     *     
     */
    public void setNormalNotes(NormalNotes value) {
        this.normalNotes = value;
    }

    /**
     * Gets the value of the normalType property.
     * 
     * @return
     *     possible object is
     *     {@link NormalType }
     *     
     */
    public NormalType getNormalType() {
        return normalType;
    }

    /**
     * Sets the value of the normalType property.
     * 
     * @param value
     *     allowed object is
     *     {@link NormalType }
     *     
     */
    public void setNormalType(NormalType value) {
        this.normalType = value;
    }

    /**
     * Gets the value of the normalDot property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the normalDot property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNormalDot().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NormalDot }
     * 
     * 
     */
    public List<NormalDot> getNormalDot() {
        if (normalDot == null) {
            normalDot = new ArrayList<NormalDot>();
        }
        return this.normalDot;
    }

}
