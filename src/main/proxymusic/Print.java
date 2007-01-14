
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * The print element contains general printing parameters,
 * including the layout elements defined in layout.dtd.
 * 
 * The new-system and new-page attributes indicate whether
 * to force a system or page break, or to force the current
 * music onto the same system or page as the preceding
 * music. Normally this is the first music data within a
 * measure. If used in multi-part music, they should be
 * placed in the same positions within each part, or the
 * results are undefined. The page-number attribute sets
 * the number of a new page; it is ignored if new-page
 * is not "yes".
 * 
 * Staff spacing between multiple staves is measured in
 * tenths of staff lines (e.g. 100 = 10 staff lines).
 * This is deprecated in MusicXML 1.1; the staff-layout
 * element should be used instead. If both are present,
 * the staff-layout values take priority.
 * 
 * Layout elements in a print statement only apply to
 * the current page, system, staff, or measure. Music
 * that follows continues to take the default values
 * from the layout included in the <defaults> element.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}page-layout" minOccurs="0"/>
 *         &lt;element ref="{}system-layout" minOccurs="0"/>
 *         &lt;element ref="{}staff-layout" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}measure-layout" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="new-page">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="yes"/>
 *             &lt;enumeration value="no"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="new-system">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="yes"/>
 *             &lt;enumeration value="no"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="page-number" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="staff-spacing" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pageLayout",
    "systemLayout",
    "staffLayout",
    "measureLayout"
})
@XmlRootElement(name = "print")
public class Print {

    @XmlElement(name = "page-layout")
    protected PageLayout pageLayout;
    @XmlElement(name = "system-layout")
    protected SystemLayout systemLayout;
    @XmlElement(name = "staff-layout")
    protected List<StaffLayout> staffLayout;
    @XmlElement(name = "measure-layout")
    protected MeasureLayout measureLayout;
    @XmlAttribute(name = "new-page")
    protected java.lang.String newPage;
    @XmlAttribute(name = "new-system")
    protected java.lang.String newSystem;
    @XmlAttribute(name = "page-number")
    protected java.lang.String pageNumber;
    @XmlAttribute(name = "staff-spacing")
    protected java.lang.String staffSpacing;

    /**
     * Gets the value of the pageLayout property.
     * 
     * @return
     *     possible object is
     *     {@link PageLayout }
     *     
     */
    public PageLayout getPageLayout() {
        return pageLayout;
    }

    /**
     * Sets the value of the pageLayout property.
     * 
     * @param value
     *     allowed object is
     *     {@link PageLayout }
     *     
     */
    public void setPageLayout(PageLayout value) {
        this.pageLayout = value;
    }

    /**
     * Gets the value of the systemLayout property.
     * 
     * @return
     *     possible object is
     *     {@link SystemLayout }
     *     
     */
    public SystemLayout getSystemLayout() {
        return systemLayout;
    }

    /**
     * Sets the value of the systemLayout property.
     * 
     * @param value
     *     allowed object is
     *     {@link SystemLayout }
     *     
     */
    public void setSystemLayout(SystemLayout value) {
        this.systemLayout = value;
    }

    /**
     * Gets the value of the staffLayout property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the staffLayout property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStaffLayout().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StaffLayout }
     * 
     * 
     */
    public List<StaffLayout> getStaffLayout() {
        if (staffLayout == null) {
            staffLayout = new ArrayList<StaffLayout>();
        }
        return this.staffLayout;
    }

    /**
     * Gets the value of the measureLayout property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureLayout }
     *     
     */
    public MeasureLayout getMeasureLayout() {
        return measureLayout;
    }

    /**
     * Sets the value of the measureLayout property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureLayout }
     *     
     */
    public void setMeasureLayout(MeasureLayout value) {
        this.measureLayout = value;
    }

    /**
     * Gets the value of the newPage property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getNewPage() {
        return newPage;
    }

    /**
     * Sets the value of the newPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setNewPage(java.lang.String value) {
        this.newPage = value;
    }

    /**
     * Gets the value of the newSystem property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getNewSystem() {
        return newSystem;
    }

    /**
     * Sets the value of the newSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setNewSystem(java.lang.String value) {
        this.newSystem = value;
    }

    /**
     * Gets the value of the pageNumber property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPageNumber() {
        return pageNumber;
    }

    /**
     * Sets the value of the pageNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPageNumber(java.lang.String value) {
        this.pageNumber = value;
    }

    /**
     * Gets the value of the staffSpacing property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getStaffSpacing() {
        return staffSpacing;
    }

    /**
     * Sets the value of the staffSpacing property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setStaffSpacing(java.lang.String value) {
        this.staffSpacing = value;
    }

}
