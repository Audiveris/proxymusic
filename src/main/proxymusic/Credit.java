
package proxymusic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <B>[JAXB: simplified definition]</B><BR/>The credit type represents the appearance of the title, composer, arranger, lyricist, copyright, dedication, and other text and graphics that commonly appears on the first page of a score. The credit-words and credit-image elements are similar to the words and image elements for directions. However, since the credit is not part of a measure, the default-x and default-y attributes adjust the origin relative to the bottom left-hand corner of the first page. The enclosure for credit-words is none by default.
 * 	
 * By default, a series of credit-words elements within a single credit element follow one another in sequence visually. Non-positional formatting attributes are carried over from the previous element by default.
 * 	
 * The page attribute for the credit element, new in Version 2.0, specifies the page number where the credit should appear. This is an integer value that starts with 1 for the first page. Its value is 1 by default. Since credits occur before the music, these page numbers do not refer to the page numbering specified by the print element's page-number attribute.
 * 
 * The credit-type element, new in Version 3.0, indicates the purpose behind a credit. Multiple types of data may be combined in a single credit, so multiple elements may be used. Standard values include page number, title, subtitle, composer, arranger, lyricist, and rights.
 * 
 * 
 * <p>Java class for credit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="credit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;choice>
 *           &lt;element name="credit-type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="link" type="{}link"/>
 *           &lt;element name="bookmark" type="{}bookmark"/>
 *           &lt;element name="credit-image" type="{}image"/>
 *           &lt;element name="credit-words" type="{}formatted-text"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="page" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "credit", propOrder = {
    "creditTypeOrLinkOrBookmark"
})
public class Credit {

    @XmlElements({
        @XmlElement(name = "credit-type", type = java.lang.String.class),
        @XmlElement(name = "link", type = Link.class),
        @XmlElement(name = "bookmark", type = Bookmark.class),
        @XmlElement(name = "credit-image", type = Image.class),
        @XmlElement(name = "credit-words", type = FormattedText.class)
    })
    protected List<Object> creditTypeOrLinkOrBookmark;
    @XmlAttribute(name = "page")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger page;

    /**
     * Gets the value of the creditTypeOrLinkOrBookmark property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creditTypeOrLinkOrBookmark property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreditTypeOrLinkOrBookmark().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link java.lang.String }
     * {@link Link }
     * {@link Bookmark }
     * {@link Image }
     * {@link FormattedText }
     * 
     * 
     */
    public List<Object> getCreditTypeOrLinkOrBookmark() {
        if (creditTypeOrLinkOrBookmark == null) {
            creditTypeOrLinkOrBookmark = new ArrayList<Object>();
        }
        return this.creditTypeOrLinkOrBookmark;
    }

    /**
     * Gets the value of the page property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPage() {
        return page;
    }

    /**
     * Sets the value of the page property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPage(BigInteger value) {
        this.page = value;
    }

}
