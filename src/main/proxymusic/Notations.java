
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * Notations refer to musical notations, not XML notations. Multiple notations are allowed in order to represent multiple editorial levels. The print-object attribute, added in Version 3.0, allows notations to represent details of performance technique, such as fingerings, without having them appear in the score.
 * 
 * <p>Java class for notations complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="notations">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{}editorial"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="tied" type="{}tied"/>
 *           &lt;element name="slur" type="{}slur"/>
 *           &lt;element name="tuplet" type="{}tuplet"/>
 *           &lt;element name="glissando" type="{}glissando"/>
 *           &lt;element name="slide" type="{}slide"/>
 *           &lt;element name="ornaments" type="{}ornaments"/>
 *           &lt;element name="technical" type="{}technical"/>
 *           &lt;element name="articulations" type="{}articulations"/>
 *           &lt;element name="dynamics" type="{}dynamics"/>
 *           &lt;element name="fermata" type="{}fermata"/>
 *           &lt;element name="arpeggiate" type="{}arpeggiate"/>
 *           &lt;element name="non-arpeggiate" type="{}non-arpeggiate"/>
 *           &lt;element name="accidental-mark" type="{}accidental-mark"/>
 *           &lt;element name="other-notation" type="{}other-notation"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}print-object"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notations", propOrder = {
    "footnote",
    "level",
    "tiedOrSlurOrTuplet"
})
public class Notations {

    protected FormattedText footnote;
    protected Level level;
    @XmlElements({
        @XmlElement(name = "tied", type = Tied.class),
        @XmlElement(name = "slur", type = Slur.class),
        @XmlElement(name = "tuplet", type = Tuplet.class),
        @XmlElement(name = "glissando", type = Glissando.class),
        @XmlElement(name = "slide", type = Slide.class),
        @XmlElement(name = "ornaments", type = Ornaments.class),
        @XmlElement(name = "technical", type = Technical.class),
        @XmlElement(name = "articulations", type = Articulations.class),
        @XmlElement(name = "dynamics", type = Dynamics.class),
        @XmlElement(name = "fermata", type = Fermata.class),
        @XmlElement(name = "arpeggiate", type = Arpeggiate.class),
        @XmlElement(name = "non-arpeggiate", type = NonArpeggiate.class),
        @XmlElement(name = "accidental-mark", type = AccidentalMark.class),
        @XmlElement(name = "other-notation", type = OtherNotation.class)
    })
    protected List<Object> tiedOrSlurOrTuplet;
    @XmlAttribute(name = "print-object")
    protected YesNo printObject;

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
     * Gets the value of the tiedOrSlurOrTuplet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tiedOrSlurOrTuplet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTiedOrSlurOrTuplet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Tied }
     * {@link Slur }
     * {@link Tuplet }
     * {@link Glissando }
     * {@link Slide }
     * {@link Ornaments }
     * {@link Technical }
     * {@link Articulations }
     * {@link Dynamics }
     * {@link Fermata }
     * {@link Arpeggiate }
     * {@link NonArpeggiate }
     * {@link AccidentalMark }
     * {@link OtherNotation }
     * 
     * 
     */
    public List<Object> getTiedOrSlurOrTuplet() {
        if (tiedOrSlurOrTuplet == null) {
            tiedOrSlurOrTuplet = new ArrayList<Object>();
        }
        return this.tiedOrSlurOrTuplet;
    }

    /**
     * Gets the value of the printObject property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getPrintObject() {
        return printObject;
    }

    /**
     * Sets the value of the printObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setPrintObject(YesNo value) {
        this.printObject = value;
    }

}
