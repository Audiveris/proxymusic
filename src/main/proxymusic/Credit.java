
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
 * Credit elements refer to the title, composer, arranger,
 * lyricist, copyright, dedication, and other text that
 * appears on the first page of a score. The credit-words
 * element is similar to the words element for directions.
 * However, since the credit is not part of a measure,
 * the default-x and default-y attributes adjust the
 * origin relative to the bottom left-hand corner of
 * the first page. The enclosure is none by default.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}credit-words" maxOccurs="unbounded"/>
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
    "creditWords"
})
@XmlRootElement(name = "credit")
public class Credit {

    @XmlElement(name = "credit-words", required = true)
    protected List<CreditWords> creditWords;

    /**
     * Gets the value of the creditWords property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creditWords property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreditWords().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CreditWords }
     * 
     * 
     */
    public List<CreditWords> getCreditWords() {
        if (creditWords == null) {
            creditWords = new ArrayList<CreditWords>();
        }
        return this.creditWords;
    }

}
