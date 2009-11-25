
package proxymusic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The print type contains general printing parameters, including the layout elements defined in the layout.mod file. The part-name-display and part-abbreviation-display elements used in the score.mod file may also be used here to change how a part name or abbreviation is displayed over the course of a piece. They take effect when the current measure or a succeeding measure starts a new system.
 * 	
 * Layout elements in a print statement only apply to the current page, system, staff, or measure. Music that follows continues to take the default values from the layout included in the defaults element.
 * 
 * <p>Java class for print complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="print">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{}layout"/>
 *         &lt;element name="measure-layout" type="{}measure-layout" minOccurs="0"/>
 *         &lt;element name="measure-numbering" type="{}measure-numbering" minOccurs="0"/>
 *         &lt;element name="part-name-display" type="{}name-display" minOccurs="0"/>
 *         &lt;element name="part-abbreviation-display" type="{}name-display" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}print-attributes"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "print", propOrder = {
    "pageLayout",
    "systemLayout",
    "staffLayout",
    "measureLayout",
    "measureNumbering",
    "partNameDisplay",
    "partAbbreviationDisplay"
})
public class Print {

    @XmlElement(name = "page-layout")
    protected PageLayout pageLayout;
    @XmlElement(name = "system-layout")
    protected SystemLayout systemLayout;
    @XmlElement(name = "staff-layout")
    protected List<StaffLayout> staffLayout;
    @XmlElement(name = "measure-layout")
    protected MeasureLayout measureLayout;
    @XmlElement(name = "measure-numbering")
    protected MeasureNumbering measureNumbering;
    @XmlElement(name = "part-name-display")
    protected NameDisplay partNameDisplay;
    @XmlElement(name = "part-abbreviation-display")
    protected NameDisplay partAbbreviationDisplay;
    @XmlAttribute(name = "staff-spacing")
    protected BigDecimal staffSpacing;
    @XmlAttribute(name = "new-system")
    protected YesNo newSystem;
    @XmlAttribute(name = "new-page")
    protected YesNo newPage;
    @XmlAttribute(name = "blank-page")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger blankPage;
    @XmlAttribute(name = "page-number")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected java.lang.String pageNumber;

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
     * Gets the value of the measureNumbering property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureNumbering }
     *     
     */
    public MeasureNumbering getMeasureNumbering() {
        return measureNumbering;
    }

    /**
     * Sets the value of the measureNumbering property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureNumbering }
     *     
     */
    public void setMeasureNumbering(MeasureNumbering value) {
        this.measureNumbering = value;
    }

    /**
     * Gets the value of the partNameDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link NameDisplay }
     *     
     */
    public NameDisplay getPartNameDisplay() {
        return partNameDisplay;
    }

    /**
     * Sets the value of the partNameDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameDisplay }
     *     
     */
    public void setPartNameDisplay(NameDisplay value) {
        this.partNameDisplay = value;
    }

    /**
     * Gets the value of the partAbbreviationDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link NameDisplay }
     *     
     */
    public NameDisplay getPartAbbreviationDisplay() {
        return partAbbreviationDisplay;
    }

    /**
     * Sets the value of the partAbbreviationDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameDisplay }
     *     
     */
    public void setPartAbbreviationDisplay(NameDisplay value) {
        this.partAbbreviationDisplay = value;
    }

    /**
     * Gets the value of the staffSpacing property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getStaffSpacing() {
        return staffSpacing;
    }

    /**
     * Sets the value of the staffSpacing property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setStaffSpacing(BigDecimal value) {
        this.staffSpacing = value;
    }

    /**
     * Gets the value of the newSystem property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getNewSystem() {
        return newSystem;
    }

    /**
     * Sets the value of the newSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setNewSystem(YesNo value) {
        this.newSystem = value;
    }

    /**
     * Gets the value of the newPage property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getNewPage() {
        return newPage;
    }

    /**
     * Sets the value of the newPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setNewPage(YesNo value) {
        this.newPage = value;
    }

    /**
     * Gets the value of the blankPage property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBlankPage() {
        return blankPage;
    }

    /**
     * Sets the value of the blankPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBlankPage(BigInteger value) {
        this.blankPage = value;
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

}
