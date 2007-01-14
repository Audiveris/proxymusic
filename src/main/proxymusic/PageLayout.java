
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
 * Page layout can be defined both in score-wide
 * defaults and in the print element. Page margins
 * are specified either for both even and odd pages,
 * or via separate odd and even page number values.
 * The type is not needed when used in as part of
 * a print element. If omitted when used in the
 * defaults element, "both" is the default.
 * 
 * Original definition was:
 * 
 * <!ELEMENT page-layout (page-height, page-width,
 * page-margins?, page-margins?)>
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}page-height"/>
 *         &lt;element ref="{}page-width"/>
 *         &lt;element ref="{}page-margins" maxOccurs="unbounded" minOccurs="0"/>
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
    "pageHeight",
    "pageWidth",
    "pageMargins"
})
@XmlRootElement(name = "page-layout")
public class PageLayout {

    @XmlElement(name = "page-height", required = true)
    protected PageHeight pageHeight;
    @XmlElement(name = "page-width", required = true)
    protected PageWidth pageWidth;
    @XmlElement(name = "page-margins")
    protected List<PageMargins> pageMargins;

    /**
     * Gets the value of the pageHeight property.
     * 
     * @return
     *     possible object is
     *     {@link PageHeight }
     *     
     */
    public PageHeight getPageHeight() {
        return pageHeight;
    }

    /**
     * Sets the value of the pageHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link PageHeight }
     *     
     */
    public void setPageHeight(PageHeight value) {
        this.pageHeight = value;
    }

    /**
     * Gets the value of the pageWidth property.
     * 
     * @return
     *     possible object is
     *     {@link PageWidth }
     *     
     */
    public PageWidth getPageWidth() {
        return pageWidth;
    }

    /**
     * Sets the value of the pageWidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link PageWidth }
     *     
     */
    public void setPageWidth(PageWidth value) {
        this.pageWidth = value;
    }

    /**
     * Gets the value of the pageMargins property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pageMargins property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPageMargins().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PageMargins }
     * 
     * 
     */
    public List<PageMargins> getPageMargins() {
        if (pageMargins == null) {
            pageMargins = new ArrayList<PageMargins>();
        }
        return this.pageMargins;
    }

}
