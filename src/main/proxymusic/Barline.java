
package proxymusic;

import java.math.BigDecimal;
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
 * If a barline is other than a normal single barline, it should be represented by a barline type that describes it. This includes information about repeats and multiple endings, as well as line style. Barline data is on the same level as the other musical data in a score - a child of a measure in a partwise score, or a part in a timewise score. This allows for barlines within measures, as in dotted barlines that subdivide measures in complex meters. The two fermata elements allow for fermatas on both sides of the barline (the lower one inverted).
 * 	
 * Barlines have a location attribute to make it easier to process barlines independently of the other musical data in a score. It is often easier to set up measures separately from entering notes. The location attribute must match where the barline element occurs within the rest of the musical data in the score. If location is left, it should be the first element in the measure, aside from the print, bookmark, and link elements. If location is right, it should be the last element, again with the possible exception of the print, bookmark, and link elements. If no location is specified, the right barline is the default. The segno, coda, and divisions attributes work the same way as in the sound element. They are used for playback when barline elements contain segno or coda child elements.
 * 
 * <p>Java class for barline complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="barline">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bar-style" type="{}bar-style-color" minOccurs="0"/>
 *         &lt;group ref="{}editorial"/>
 *         &lt;element name="wavy-line" type="{}wavy-line" minOccurs="0"/>
 *         &lt;element name="segno" type="{}empty-print-style" minOccurs="0"/>
 *         &lt;element name="coda" type="{}empty-print-style" minOccurs="0"/>
 *         &lt;element name="fermata" type="{}fermata" maxOccurs="2" minOccurs="0"/>
 *         &lt;element name="ending" type="{}ending" minOccurs="0"/>
 *         &lt;element name="repeat" type="{}repeat" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="location" type="{}right-left-middle" default="right" />
 *       &lt;attribute name="segno" type="{http://www.w3.org/2001/XMLSchema}token" />
 *       &lt;attribute name="coda" type="{http://www.w3.org/2001/XMLSchema}token" />
 *       &lt;attribute name="divisions" type="{}divisions" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "barline", propOrder = {
    "barStyle",
    "footnote",
    "level",
    "wavyLine",
    "segno",
    "coda",
    "fermata",
    "ending",
    "repeat"
})
public class Barline {

    @XmlElement(name = "bar-style")
    protected BarStyleColor barStyle;
    protected FormattedText footnote;
    protected Level level;
    @XmlElement(name = "wavy-line")
    protected WavyLine wavyLine;
    protected EmptyPrintStyle segno;
    protected EmptyPrintStyle coda;
    protected List<Fermata> fermata;
    protected Ending ending;
    protected Repeat repeat;
    @XmlAttribute
    protected RightLeftMiddle location;
    @XmlAttribute(name = "segno")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected java.lang.String segnoAttribute;
    @XmlAttribute(name = "coda")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected java.lang.String codaAttribute;
    @XmlAttribute
    protected BigDecimal divisions;

    /**
     * Gets the value of the barStyle property.
     * 
     * @return
     *     possible object is
     *     {@link BarStyleColor }
     *     
     */
    public BarStyleColor getBarStyle() {
        return barStyle;
    }

    /**
     * Sets the value of the barStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link BarStyleColor }
     *     
     */
    public void setBarStyle(BarStyleColor value) {
        this.barStyle = value;
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
     * Gets the value of the wavyLine property.
     * 
     * @return
     *     possible object is
     *     {@link WavyLine }
     *     
     */
    public WavyLine getWavyLine() {
        return wavyLine;
    }

    /**
     * Sets the value of the wavyLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link WavyLine }
     *     
     */
    public void setWavyLine(WavyLine value) {
        this.wavyLine = value;
    }

    /**
     * Gets the value of the segno property.
     * 
     * @return
     *     possible object is
     *     {@link EmptyPrintStyle }
     *     
     */
    public EmptyPrintStyle getSegno() {
        return segno;
    }

    /**
     * Sets the value of the segno property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmptyPrintStyle }
     *     
     */
    public void setSegno(EmptyPrintStyle value) {
        this.segno = value;
    }

    /**
     * Gets the value of the coda property.
     * 
     * @return
     *     possible object is
     *     {@link EmptyPrintStyle }
     *     
     */
    public EmptyPrintStyle getCoda() {
        return coda;
    }

    /**
     * Sets the value of the coda property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmptyPrintStyle }
     *     
     */
    public void setCoda(EmptyPrintStyle value) {
        this.coda = value;
    }

    /**
     * Gets the value of the fermata property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fermata property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFermata().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Fermata }
     * 
     * 
     */
    public List<Fermata> getFermata() {
        if (fermata == null) {
            fermata = new ArrayList<Fermata>();
        }
        return this.fermata;
    }

    /**
     * Gets the value of the ending property.
     * 
     * @return
     *     possible object is
     *     {@link Ending }
     *     
     */
    public Ending getEnding() {
        return ending;
    }

    /**
     * Sets the value of the ending property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ending }
     *     
     */
    public void setEnding(Ending value) {
        this.ending = value;
    }

    /**
     * Gets the value of the repeat property.
     * 
     * @return
     *     possible object is
     *     {@link Repeat }
     *     
     */
    public Repeat getRepeat() {
        return repeat;
    }

    /**
     * Sets the value of the repeat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Repeat }
     *     
     */
    public void setRepeat(Repeat value) {
        this.repeat = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link RightLeftMiddle }
     *     
     */
    public RightLeftMiddle getLocation() {
        if (location == null) {
            return RightLeftMiddle.RIGHT;
        } else {
            return location;
        }
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link RightLeftMiddle }
     *     
     */
    public void setLocation(RightLeftMiddle value) {
        this.location = value;
    }

    /**
     * Gets the value of the segnoAttribute property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getSegnoAttribute() {
        return segnoAttribute;
    }

    /**
     * Sets the value of the segnoAttribute property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setSegnoAttribute(java.lang.String value) {
        this.segnoAttribute = value;
    }

    /**
     * Gets the value of the codaAttribute property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getCodaAttribute() {
        return codaAttribute;
    }

    /**
     * Sets the value of the codaAttribute property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setCodaAttribute(java.lang.String value) {
        this.codaAttribute = value;
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

}
