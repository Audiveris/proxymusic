
package proxymusic;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Kind indicates the type of chord. Degree elements can then add, subtract, or alter from these starting points
 * 	
 * The attributes are used to indicate the formatting of the symbol. Since the kind element is the constant in all the harmony-chord entities that can make up a polychord, many formatting attributes are here.
 * 	
 * The use-symbols attribute is yes if the kind should be represented when possible with harmony symbols rather than letters and numbers. These symbols include:
 * 	
 * 	major: a triangle, like Unicode 25B3
 * 	minor: -, like Unicode 002D
 * 	augmented: +, like Unicode 002B
 * 	diminished: °, like Unicode 00B0
 * 	half-diminished: ø, like Unicode 00F8
 * 	
 * The text attribute describes how the kind should be spelled if not using symbols; it is ignored if use-symbols is yes. The stack-degrees attribute is yes if the degree elements should be stacked above each other. The parentheses-degrees attribute is yes if all the degrees should be in parentheses. The bracket-degrees attribute is yes if all the degrees should be in a bracket. If not  specified, these values are implementation-specific. The alignment attributes are for the entire harmony-chord entity of which this kind element is a part.
 * 
 * <p>Java class for kind complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="kind">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;>kind-value">
 *       &lt;attGroup ref="{}valign"/>
 *       &lt;attGroup ref="{}halign"/>
 *       &lt;attGroup ref="{}print-style"/>
 *       &lt;attribute name="use-symbols" type="{}yes-no" />
 *       &lt;attribute name="text" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="stack-degrees" type="{}yes-no" />
 *       &lt;attribute name="parentheses-degrees" type="{}yes-no" />
 *       &lt;attribute name="bracket-degrees" type="{}yes-no" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "kind", propOrder = {
    "value"
})
public class Kind {

    @XmlValue
    protected KindValue value;
    @XmlAttribute(name = "use-symbols")
    protected YesNo useSymbols;
    @XmlAttribute
    protected java.lang.String text;
    @XmlAttribute(name = "stack-degrees")
    protected YesNo stackDegrees;
    @XmlAttribute(name = "parentheses-degrees")
    protected YesNo parenthesesDegrees;
    @XmlAttribute(name = "bracket-degrees")
    protected YesNo bracketDegrees;
    @XmlAttribute
    protected Valign valign;
    @XmlAttribute
    protected LeftCenterRight halign;
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
     * A kind-value indicates the type of chord. Degree elements can then add, subtract, or alter from these starting points. Values include:
     * 	
     * Triads:
     * 	major (major third, perfect fifth)
     * 	minor (minor third, perfect fifth)
     * 	augmented (major third, augmented fifth)
     * 	diminished (minor third, diminished fifth)
     * Sevenths:
     * 	dominant (major triad, minor seventh)
     * 	major-seventh (major triad, major seventh)
     * 	minor-seventh (minor triad, minor seventh)
     * 	diminished-seventh (diminished triad, diminished seventh)
     * 	augmented-seventh (augmented triad, minor seventh)
     * 	half-diminished (diminished triad, minor seventh)
     * 	major-minor (minor triad, major seventh)
     * Sixths:
     * 	major-sixth (major triad, added sixth)
     * 	minor-sixth (minor triad, added sixth)
     * Ninths:
     * 	dominant-ninth (dominant-seventh, major ninth)
     * 	major-ninth (major-seventh, major ninth)
     * 	minor-ninth (minor-seventh, major ninth)
     *  11ths (usually as the basis for alteration):
     * 	dominant-11th (dominant-ninth, perfect 11th)
     * 	major-11th (major-ninth, perfect 11th)
     * 	minor-11th (minor-ninth, perfect 11th)
     *  13ths (usually as the basis for alteration):
     * 	dominant-13th (dominant-11th, major 13th)
     * 	major-13th (major-11th, major 13th)
     * 	minor-13th (minor-11th, major 13th)
     * Suspended:
     * 	suspended-second (major second, perfect fifth)
     * 	suspended-fourth (perfect fourth, perfect fifth)
     * Functional sixths:
     * 	Neapolitan
     * 	Italian
     * 	French
     * 	German
     * Other:
     * 	pedal (pedal-point bass)
     * 	power (perfect fifth)
     * 	Tristan
     * 	
     * The "other" kind is used when the harmony is entirely composed of add elements. The "none" kind is used to explicitly encode absence of chords or functional harmony.
     * 
     * @return
     *     possible object is
     *     {@link KindValue }
     *     
     */
    public KindValue getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link KindValue }
     *     
     */
    public void setValue(KindValue value) {
        this.value = value;
    }

    /**
     * Gets the value of the useSymbols property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getUseSymbols() {
        return useSymbols;
    }

    /**
     * Sets the value of the useSymbols property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setUseSymbols(YesNo value) {
        this.useSymbols = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setText(java.lang.String value) {
        this.text = value;
    }

    /**
     * Gets the value of the stackDegrees property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getStackDegrees() {
        return stackDegrees;
    }

    /**
     * Sets the value of the stackDegrees property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setStackDegrees(YesNo value) {
        this.stackDegrees = value;
    }

    /**
     * Gets the value of the parenthesesDegrees property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getParenthesesDegrees() {
        return parenthesesDegrees;
    }

    /**
     * Sets the value of the parenthesesDegrees property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setParenthesesDegrees(YesNo value) {
        this.parenthesesDegrees = value;
    }

    /**
     * Gets the value of the bracketDegrees property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getBracketDegrees() {
        return bracketDegrees;
    }

    /**
     * Sets the value of the bracketDegrees property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setBracketDegrees(YesNo value) {
        this.bracketDegrees = value;
    }

    /**
     * Gets the value of the valign property.
     * 
     * @return
     *     possible object is
     *     {@link Valign }
     *     
     */
    public Valign getValign() {
        return valign;
    }

    /**
     * Sets the value of the valign property.
     * 
     * @param value
     *     allowed object is
     *     {@link Valign }
     *     
     */
    public void setValign(Valign value) {
        this.valign = value;
    }

    /**
     * Gets the value of the halign property.
     * 
     * @return
     *     possible object is
     *     {@link LeftCenterRight }
     *     
     */
    public LeftCenterRight getHalign() {
        return halign;
    }

    /**
     * Sets the value of the halign property.
     * 
     * @param value
     *     allowed object is
     *     {@link LeftCenterRight }
     *     
     */
    public void setHalign(LeftCenterRight value) {
        this.halign = value;
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
