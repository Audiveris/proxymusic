
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
 * Scordatura string tunings are represented by a series
 * of accord elements. The tuning-step, tuning-alter,
 * and tuning-octave elements are also used with the
 * staff-tuning element, and are defined in the common.dtd
 * file. Strings are numbered from high to low.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}accord" maxOccurs="unbounded"/>
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
    "accord"
})
@XmlRootElement(name = "scordatura")
public class Scordatura {

    @XmlElement(required = true)
    protected List<Accord> accord;

    /**
     * Gets the value of the accord property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accord property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccord().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Accord }
     * 
     * 
     */
    public List<Accord> getAccord() {
        if (accord == null) {
            accord = new ArrayList<Accord>();
        }
        return this.accord;
    }

}
