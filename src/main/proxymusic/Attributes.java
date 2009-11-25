
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
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The attributes element contains musical information that typically changes on measure boundaries. This includes key and time signatures, clefs, transpositions, and staving.
 * 
 * <p>Java class for attributes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="attributes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{}editorial"/>
 *         &lt;element name="divisions" type="{}positive-divisions" minOccurs="0"/>
 *         &lt;element name="key" type="{}key" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="time" type="{}time" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="staves" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="part-symbol" type="{}part-symbol" minOccurs="0"/>
 *         &lt;element name="instruments" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="clef" type="{}clef" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="staff-details" type="{}staff-details" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="transpose" type="{}transpose" minOccurs="0"/>
 *         &lt;element name="directive" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attGroup ref="{}print-style"/>
 *                 &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/>
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="measure-style" type="{}measure-style" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attributes", propOrder = {
    "footnote",
    "level",
    "divisions",
    "key",
    "time",
    "staves",
    "partSymbol",
    "instruments",
    "clef",
    "staffDetails",
    "transpose",
    "directive",
    "measureStyle"
})
public class Attributes {

    protected FormattedText footnote;
    protected Level level;
    protected BigDecimal divisions;
    protected List<Key> key;
    protected List<Time> time;
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger staves;
    @XmlElement(name = "part-symbol")
    protected PartSymbol partSymbol;
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger instruments;
    protected List<Clef> clef;
    @XmlElement(name = "staff-details")
    protected List<StaffDetails> staffDetails;
    protected Transpose transpose;
    protected List<Attributes.Directive> directive;
    @XmlElement(name = "measure-style")
    protected List<MeasureStyle> measureStyle;

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
     * Gets the value of the divisions property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDivisions() {
        return divisions;
    }

    /**
     * Sets the value of the divisions property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDivisions(BigDecimal value) {
        this.divisions = value;
    }

    /**
     * Gets the value of the key property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the key property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKey().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Key }
     * 
     * 
     */
    public List<Key> getKey() {
        if (key == null) {
            key = new ArrayList<Key>();
        }
        return this.key;
    }

    /**
     * Gets the value of the time property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the time property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTime().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Time }
     * 
     * 
     */
    public List<Time> getTime() {
        if (time == null) {
            time = new ArrayList<Time>();
        }
        return this.time;
    }

    /**
     * Gets the value of the staves property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStaves() {
        return staves;
    }

    /**
     * Sets the value of the staves property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStaves(BigInteger value) {
        this.staves = value;
    }

    /**
     * Gets the value of the partSymbol property.
     * 
     * @return
     *     possible object is
     *     {@link PartSymbol }
     *     
     */
    public PartSymbol getPartSymbol() {
        return partSymbol;
    }

    /**
     * Sets the value of the partSymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartSymbol }
     *     
     */
    public void setPartSymbol(PartSymbol value) {
        this.partSymbol = value;
    }

    /**
     * Gets the value of the instruments property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getInstruments() {
        return instruments;
    }

    /**
     * Sets the value of the instruments property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setInstruments(BigInteger value) {
        this.instruments = value;
    }

    /**
     * Gets the value of the clef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Clef }
     * 
     * 
     */
    public List<Clef> getClef() {
        if (clef == null) {
            clef = new ArrayList<Clef>();
        }
        return this.clef;
    }

    /**
     * Gets the value of the staffDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the staffDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStaffDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StaffDetails }
     * 
     * 
     */
    public List<StaffDetails> getStaffDetails() {
        if (staffDetails == null) {
            staffDetails = new ArrayList<StaffDetails>();
        }
        return this.staffDetails;
    }

    /**
     * Gets the value of the transpose property.
     * 
     * @return
     *     possible object is
     *     {@link Transpose }
     *     
     */
    public Transpose getTranspose() {
        return transpose;
    }

    /**
     * Sets the value of the transpose property.
     * 
     * @param value
     *     allowed object is
     *     {@link Transpose }
     *     
     */
    public void setTranspose(Transpose value) {
        this.transpose = value;
    }

    /**
     * Gets the value of the directive property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the directive property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDirective().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Attributes.Directive }
     * 
     * 
     */
    public List<Attributes.Directive> getDirective() {
        if (directive == null) {
            directive = new ArrayList<Attributes.Directive>();
        }
        return this.directive;
    }

    /**
     * Gets the value of the measureStyle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the measureStyle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeasureStyle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MeasureStyle }
     * 
     * 
     */
    public List<MeasureStyle> getMeasureStyle() {
        if (measureStyle == null) {
            measureStyle = new ArrayList<MeasureStyle>();
        }
        return this.measureStyle;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attGroup ref="{}print-style"/>
     *       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/>
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Directive {

        @XmlValue
        protected java.lang.String value;
        @XmlAttribute(namespace = "http://www.w3.org/XML/1998/namespace")
        protected java.lang.String lang;
        @XmlAttribute(name = "font-family")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected java.lang.String fontFamily;
        @XmlAttribute(name = "font-style")
        protected FontStyle fontStyle;
        @XmlAttribute(name = "font-size")
        protected java.lang.String fontSize;
        @XmlAttribute(name = "font-weight")
        protected FontWeight fontWeight;
        @XmlAttribute(name = "default-x")
        protected BigDecimal defaultX;
        @XmlAttribute(name = "default-y")
        protected BigDecimal defaultY;
        @XmlAttribute(name = "relative-x")
        protected BigDecimal relativeX;
        @XmlAttribute(name = "relative-y")
        protected BigDecimal relativeY;
        @XmlAttribute
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected java.lang.String color;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link java.lang.String }
         *     
         */
        public java.lang.String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link java.lang.String }
         *     
         */
        public void setValue(java.lang.String value) {
            this.value = value;
        }

        /**
         * Gets the value of the lang property.
         * 
         * @return
         *     possible object is
         *     {@link java.lang.String }
         *     
         */
        public java.lang.String getLang() {
            return lang;
        }

        /**
         * Sets the value of the lang property.
         * 
         * @param value
         *     allowed object is
         *     {@link java.lang.String }
         *     
         */
        public void setLang(java.lang.String value) {
            this.lang = value;
        }

        /**
         * Gets the value of the fontFamily property.
         * 
         * @return
         *     possible object is
         *     {@link java.lang.String }
         *     
         */
        public java.lang.String getFontFamily() {
            return fontFamily;
        }

        /**
         * Sets the value of the fontFamily property.
         * 
         * @param value
         *     allowed object is
         *     {@link java.lang.String }
         *     
         */
        public void setFontFamily(java.lang.String value) {
            this.fontFamily = value;
        }

        /**
         * Gets the value of the fontStyle property.
         * 
         * @return
         *     possible object is
         *     {@link FontStyle }
         *     
         */
        public FontStyle getFontStyle() {
            return fontStyle;
        }

        /**
         * Sets the value of the fontStyle property.
         * 
         * @param value
         *     allowed object is
         *     {@link FontStyle }
         *     
         */
        public void setFontStyle(FontStyle value) {
            this.fontStyle = value;
        }

        /**
         * Gets the value of the fontSize property.
         * 
         * @return
         *     possible object is
         *     {@link java.lang.String }
         *     
         */
        public java.lang.String getFontSize() {
            return fontSize;
        }

        /**
         * Sets the value of the fontSize property.
         * 
         * @param value
         *     allowed object is
         *     {@link java.lang.String }
         *     
         */
        public void setFontSize(java.lang.String value) {
            this.fontSize = value;
        }

        /**
         * Gets the value of the fontWeight property.
         * 
         * @return
         *     possible object is
         *     {@link FontWeight }
         *     
         */
        public FontWeight getFontWeight() {
            return fontWeight;
        }

        /**
         * Sets the value of the fontWeight property.
         * 
         * @param value
         *     allowed object is
         *     {@link FontWeight }
         *     
         */
        public void setFontWeight(FontWeight value) {
            this.fontWeight = value;
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

    }

}
