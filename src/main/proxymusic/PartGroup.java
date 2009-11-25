
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The part-group element indicates groupings of parts in the score, usually indicated by braces and brackets. Braces that are used for multi-staff parts should be defined in the attributes element for that part. The part-group start element appears before the first score-part in the group. The part-group stop element appears after the last  score-part in the group.
 * 	
 * The number attribute is used to distinguish overlapping and nested part-groups, not the sequence of groups. As with parts, groups can have a name and abbreviation. Values for the child elements are ignored at the stop of a group. 
 * 	
 * A part-group element is not needed for a single multi-staff part. By default, multi-staff parts include a brace symbol and (if appropriate given the bar-style) common barlines. The symbol formatting for a multi-staff part can be more fully specified using the part-symbol element.
 * 
 * <p>Java class for part-group complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="part-group">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="group-name" type="{}group-name" minOccurs="0"/>
 *         &lt;element name="group-name-display" type="{}name-display" minOccurs="0"/>
 *         &lt;element name="group-abbreviation" type="{}group-name" minOccurs="0"/>
 *         &lt;element name="group-abbreviation-display" type="{}name-display" minOccurs="0"/>
 *         &lt;element name="group-symbol" type="{}group-symbol" minOccurs="0"/>
 *         &lt;element name="group-barline" type="{}group-barline" minOccurs="0"/>
 *         &lt;element name="group-time" type="{}empty" minOccurs="0"/>
 *         &lt;group ref="{}editorial"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" use="required" type="{}start-stop" />
 *       &lt;attribute name="number" type="{http://www.w3.org/2001/XMLSchema}token" default="1" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "part-group", propOrder = {
    "groupName",
    "groupNameDisplay",
    "groupAbbreviation",
    "groupAbbreviationDisplay",
    "groupSymbol",
    "groupBarline",
    "groupTime",
    "footnote",
    "level"
})
public class PartGroup {

    @XmlElement(name = "group-name")
    protected GroupName groupName;
    @XmlElement(name = "group-name-display")
    protected NameDisplay groupNameDisplay;
    @XmlElement(name = "group-abbreviation")
    protected GroupName groupAbbreviation;
    @XmlElement(name = "group-abbreviation-display")
    protected NameDisplay groupAbbreviationDisplay;
    @XmlElement(name = "group-symbol")
    protected GroupSymbol groupSymbol;
    @XmlElement(name = "group-barline")
    protected GroupBarline groupBarline;
    @XmlElement(name = "group-time")
    protected Empty groupTime;
    protected FormattedText footnote;
    protected Level level;
    @XmlAttribute(required = true)
    protected StartStop type;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected java.lang.String number;

    /**
     * Gets the value of the groupName property.
     * 
     * @return
     *     possible object is
     *     {@link GroupName }
     *     
     */
    public GroupName getGroupName() {
        return groupName;
    }

    /**
     * Sets the value of the groupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupName }
     *     
     */
    public void setGroupName(GroupName value) {
        this.groupName = value;
    }

    /**
     * Gets the value of the groupNameDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link NameDisplay }
     *     
     */
    public NameDisplay getGroupNameDisplay() {
        return groupNameDisplay;
    }

    /**
     * Sets the value of the groupNameDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameDisplay }
     *     
     */
    public void setGroupNameDisplay(NameDisplay value) {
        this.groupNameDisplay = value;
    }

    /**
     * Gets the value of the groupAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link GroupName }
     *     
     */
    public GroupName getGroupAbbreviation() {
        return groupAbbreviation;
    }

    /**
     * Sets the value of the groupAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupName }
     *     
     */
    public void setGroupAbbreviation(GroupName value) {
        this.groupAbbreviation = value;
    }

    /**
     * Gets the value of the groupAbbreviationDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link NameDisplay }
     *     
     */
    public NameDisplay getGroupAbbreviationDisplay() {
        return groupAbbreviationDisplay;
    }

    /**
     * Sets the value of the groupAbbreviationDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameDisplay }
     *     
     */
    public void setGroupAbbreviationDisplay(NameDisplay value) {
        this.groupAbbreviationDisplay = value;
    }

    /**
     * Gets the value of the groupSymbol property.
     * 
     * @return
     *     possible object is
     *     {@link GroupSymbol }
     *     
     */
    public GroupSymbol getGroupSymbol() {
        return groupSymbol;
    }

    /**
     * Sets the value of the groupSymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupSymbol }
     *     
     */
    public void setGroupSymbol(GroupSymbol value) {
        this.groupSymbol = value;
    }

    /**
     * Gets the value of the groupBarline property.
     * 
     * @return
     *     possible object is
     *     {@link GroupBarline }
     *     
     */
    public GroupBarline getGroupBarline() {
        return groupBarline;
    }

    /**
     * Sets the value of the groupBarline property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupBarline }
     *     
     */
    public void setGroupBarline(GroupBarline value) {
        this.groupBarline = value;
    }

    /**
     * Gets the value of the groupTime property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getGroupTime() {
        return groupTime;
    }

    /**
     * Sets the value of the groupTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setGroupTime(Empty value) {
        this.groupTime = value;
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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link StartStop }
     *     
     */
    public StartStop getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link StartStop }
     *     
     */
    public void setType(StartStop value) {
        this.type = value;
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
        if (number == null) {
            return "1";
        } else {
            return number;
        }
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

}
