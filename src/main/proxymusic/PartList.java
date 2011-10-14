
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <B>[JAXB: simplified definition]</B><BR/>The part-list identifies the different musical parts in this movement. Each part has an ID that is used later within the musical data. Since parts may be encoded separately and combined later, identification elements are present at both the score and score-part levels. There must be at least one score-part, combined as desired with part-group elements that indicate braces and brackets. Parts are ordered from top to bottom in a score based on the order in which they appear in the part-list.
 * 
 * <p>Java class for part-list complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="part-list">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;choice>
 *           &lt;group ref="{}part-group"/>
 *           &lt;group ref="{}score-part"/>
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
@XmlType(name = "part-list", propOrder = {
    "partGroupOrScorePart"
})
public class PartList {

    @XmlElements({
        @XmlElement(name = "score-part", type = ScorePart.class),
        @XmlElement(name = "part-group", type = PartGroup.class)
    })
    protected List<Object> partGroupOrScorePart;

    /**
     * Gets the value of the partGroupOrScorePart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partGroupOrScorePart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartGroupOrScorePart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ScorePart }
     * {@link PartGroup }
     * 
     * 
     */
    public List<Object> getPartGroupOrScorePart() {
        if (partGroupOrScorePart == null) {
            partGroupOrScorePart = new ArrayList<Object>();
        }
        return this.partGroupOrScorePart;
    }

}
