
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * Notations refer to musical notations, not XML notations. Multiple notations are allowed in order to represent multiple editorial levels. The set of notations may be refined and expanded over time, especially to handle more instrument-specific technical notations.
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
        @XmlElement(name = "arpeggiate", type = Arpeggiate.class),
        @XmlElement(name = "dynamics", type = Dynamics.class),
        @XmlElement(name = "slide", type = Slide.class),
        @XmlElement(name = "ornaments", type = Ornaments.class),
        @XmlElement(name = "other-notation", type = OtherNotation.class),
        @XmlElement(name = "technical", type = Technical.class),
        @XmlElement(name = "slur", type = Slur.class),
        @XmlElement(name = "fermata", type = Fermata.class),
        @XmlElement(name = "accidental-mark", type = AccidentalMark.class),
        @XmlElement(name = "articulations", type = Articulations.class),
        @XmlElement(name = "non-arpeggiate", type = NonArpeggiate.class),
        @XmlElement(name = "glissando", type = Glissando.class),
        @XmlElement(name = "tuplet", type = Tuplet.class)
    })
    protected List<Object> tiedOrSlurOrTuplet;

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
     * {@link Arpeggiate }
     * {@link Dynamics }
     * {@link Slide }
     * {@link Ornaments }
     * {@link OtherNotation }
     * {@link Technical }
     * {@link Slur }
     * {@link Fermata }
     * {@link AccidentalMark }
     * {@link Articulations }
     * {@link NonArpeggiate }
     * {@link Glissando }
     * {@link Tuplet }
     * 
     * 
     */
    public List<Object> getTiedOrSlurOrTuplet() {
        if (tiedOrSlurOrTuplet == null) {
            tiedOrSlurOrTuplet = new ArrayList<Object>();
        }
        return this.tiedOrSlurOrTuplet;
    }

}
