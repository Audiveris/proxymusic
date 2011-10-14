
package proxymusic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <B>[JAXB: simplified definition]</B><BR/>The lyric type represents text underlays for lyrics, based on Humdrum with support for other formats.  Two text elements that are not separated by an elision element are part of the same syllable, but may have different text formatting. The MusicXML 2.0 schema is more strict than the 2.0 DTD in enforcing this by disallowing a second syllabic element unless preceded by an elision element. The lyric number indicates multiple lines, though a name can be used as well (as in Finale's verse / chorus / section specification). Justification is center by default; placement is below by default.
 * 
 * <p>Java class for lyric complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lyric">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *               &lt;element name="elision" type="{}elision" minOccurs="0"/>
 *               &lt;element name="syllabic" type="{}syllabic" minOccurs="0"/>
 *               &lt;element name="text" type="{}text-element-data" minOccurs="0"/>
 *             &lt;/sequence>
 *             &lt;element name="extend" type="{}extend" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;element name="laughing" type="{}empty"/>
 *           &lt;element name="humming" type="{}empty"/>
 *         &lt;/choice>
 *         &lt;element name="end-line" type="{}empty" minOccurs="0"/>
 *         &lt;element name="end-paragraph" type="{}empty" minOccurs="0"/>
 *         &lt;group ref="{}editorial"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}placement"/>
 *       &lt;attGroup ref="{}color"/>
 *       &lt;attGroup ref="{}position"/>
 *       &lt;attGroup ref="{}justify"/>
 *       &lt;attribute name="number" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}token" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lyric", propOrder = {
    "elisionAndSyllabicAndText",
    "extend",
    "laughing",
    "humming",
    "endLine",
    "endParagraph",
    "footnote",
    "level"
})
public class Lyric {

    @XmlElements({
        @XmlElement(name = "elision", type = Elision.class),
        @XmlElement(name = "text", type = TextElementData.class),
        @XmlElement(name = "syllabic", type = Syllabic.class)
    })
    protected List<Object> elisionAndSyllabicAndText;
    protected Extend extend;
    protected Empty laughing;
    protected Empty humming;
    @XmlElement(name = "end-line")
    protected Empty endLine;
    @XmlElement(name = "end-paragraph")
    protected Empty endParagraph;
    protected FormattedText footnote;
    protected Level level;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected java.lang.String number;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected java.lang.String name;
    @XmlAttribute
    protected AboveBelow placement;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String color;
    @XmlAttribute(name = "default-x")
    protected BigDecimal defaultX;
    @XmlAttribute(name = "default-y")
    protected BigDecimal defaultY;
    @XmlAttribute(name = "relative-x")
    protected BigDecimal relativeX;
    @XmlAttribute(name = "relative-y")
    protected BigDecimal relativeY;
    @XmlAttribute
    protected LeftCenterRight justify;

    /**
     * Gets the value of the elisionAndSyllabicAndText property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the elisionAndSyllabicAndText property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElisionAndSyllabicAndText().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Elision }
     * {@link TextElementData }
     * {@link Syllabic }
     * 
     * 
     */
    public List<Object> getElisionAndSyllabicAndText() {
        if (elisionAndSyllabicAndText == null) {
            elisionAndSyllabicAndText = new ArrayList<Object>();
        }
        return this.elisionAndSyllabicAndText;
    }

    /**
     * Gets the value of the extend property.
     * 
     * @return
     *     possible object is
     *     {@link Extend }
     *     
     */
    public Extend getExtend() {
        return extend;
    }

    /**
     * Sets the value of the extend property.
     * 
     * @param value
     *     allowed object is
     *     {@link Extend }
     *     
     */
    public void setExtend(Extend value) {
        this.extend = value;
    }

    /**
     * Gets the value of the laughing property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getLaughing() {
        return laughing;
    }

    /**
     * Sets the value of the laughing property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setLaughing(Empty value) {
        this.laughing = value;
    }

    /**
     * Gets the value of the humming property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getHumming() {
        return humming;
    }

    /**
     * Sets the value of the humming property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setHumming(Empty value) {
        this.humming = value;
    }

    /**
     * Gets the value of the endLine property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getEndLine() {
        return endLine;
    }

    /**
     * Sets the value of the endLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setEndLine(Empty value) {
        this.endLine = value;
    }

    /**
     * Gets the value of the endParagraph property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getEndParagraph() {
        return endParagraph;
    }

    /**
     * Sets the value of the endParagraph property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setEndParagraph(Empty value) {
        this.endParagraph = value;
    }

    /**
     * Gets the value of the footnote property.
     * 
     * @return
     *     possible object is
     *     {@link FormattedText }
     *     
     */
    public FormattedText getFootnote() {
        return footnote;
    }

    /**
     * Sets the value of the footnote property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormattedText }
     *     
     */
    public void setFootnote(FormattedText value) {
        this.footnote = value;
    }

    /**
     * Gets the value of the level property.
     * 
     * @return
     *     possible object is
     *     {@link Level }
     *     
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     * @param value
     *     allowed object is
     *     {@link Level }
     *     
     */
    public void setLevel(Level value) {
        this.level = value;
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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setName(java.lang.String value) {
        this.name = value;
    }

    /**
     * Gets the value of the placement property.
     * 
     * @return
     *     possible object is
     *     {@link AboveBelow }
     *     
     */
    public AboveBelow getPlacement() {
        return placement;
    }

    /**
     * Sets the value of the placement property.
     * 
     * @param value
     *     allowed object is
     *     {@link AboveBelow }
     *     
     */
    public void setPlacement(AboveBelow value) {
        this.placement = value;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setColor(java.lang.String value) {
        this.color = value;
    }

    /**
     * Gets the value of the defaultX property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDefaultX() {
        return defaultX;
    }

    /**
     * Sets the value of the defaultX property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDefaultX(BigDecimal value) {
        this.defaultX = value;
    }

    /**
     * Gets the value of the defaultY property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDefaultY() {
        return defaultY;
    }

    /**
     * Sets the value of the defaultY property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDefaultY(BigDecimal value) {
        this.defaultY = value;
    }

    /**
     * Gets the value of the relativeX property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRelativeX() {
        return relativeX;
    }

    /**
     * Sets the value of the relativeX property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRelativeX(BigDecimal value) {
        this.relativeX = value;
    }

    /**
     * Gets the value of the relativeY property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRelativeY() {
        return relativeY;
    }

    /**
     * Sets the value of the relativeY property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRelativeY(BigDecimal value) {
        this.relativeY = value;
    }

    /**
     * Gets the value of the justify property.
     * 
     * @return
     *     possible object is
     *     {@link LeftCenterRight }
     *     
     */
    public LeftCenterRight getJustify() {
        return justify;
    }

    /**
     * Sets the value of the justify property.
     * 
     * @param value
     *     allowed object is
     *     {@link LeftCenterRight }
     *     
     */
    public void setJustify(LeftCenterRight value) {
        this.justify = value;
    }

}
