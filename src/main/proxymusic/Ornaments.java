
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * Ornaments can be any of several types, followed optionally by accidentals. The accidental-mark element's content is represented the same as an accidental element, but with a different name to reflect the different musical meaning.
 * 
 * <p>Java class for ornaments complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ornaments">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;choice>
 *           &lt;element name="trill-mark" type="{}empty-trill-sound"/>
 *           &lt;element name="turn" type="{}empty-trill-sound"/>
 *           &lt;element name="delayed-turn" type="{}empty-trill-sound"/>
 *           &lt;element name="inverted-turn" type="{}empty-trill-sound"/>
 *           &lt;element name="shake" type="{}empty-trill-sound"/>
 *           &lt;element name="wavy-line" type="{}wavy-line"/>
 *           &lt;element name="mordent" type="{}mordent"/>
 *           &lt;element name="inverted-mordent" type="{}mordent"/>
 *           &lt;element name="schleifer" type="{}empty-placement"/>
 *           &lt;element name="tremolo" type="{}tremolo"/>
 *           &lt;element name="other-ornament" type="{}placement-text"/>
 *         &lt;/choice>
 *         &lt;element name="accidental-mark" type="{}accidental-mark" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ornaments", propOrder = {
    "trillMarkOrTurnOrDelayedTurn"
})
public class Ornaments {

    @XmlElementRefs({
        @XmlElementRef(name = "trill-mark", type = JAXBElement.class),
        @XmlElementRef(name = "inverted-mordent", type = JAXBElement.class),
        @XmlElementRef(name = "tremolo", type = JAXBElement.class),
        @XmlElementRef(name = "accidental-mark", type = JAXBElement.class),
        @XmlElementRef(name = "wavy-line", type = JAXBElement.class),
        @XmlElementRef(name = "other-ornament", type = JAXBElement.class),
        @XmlElementRef(name = "mordent", type = JAXBElement.class),
        @XmlElementRef(name = "turn", type = JAXBElement.class),
        @XmlElementRef(name = "shake", type = JAXBElement.class),
        @XmlElementRef(name = "delayed-turn", type = JAXBElement.class),
        @XmlElementRef(name = "inverted-turn", type = JAXBElement.class),
        @XmlElementRef(name = "schleifer", type = JAXBElement.class)
    })
    protected List<JAXBElement<?>> trillMarkOrTurnOrDelayedTurn;

    /**
     * Gets the value of the trillMarkOrTurnOrDelayedTurn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trillMarkOrTurnOrDelayedTurn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrillMarkOrTurnOrDelayedTurn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link EmptyTrillSound }{@code >}
     * {@link JAXBElement }{@code <}{@link Mordent }{@code >}
     * {@link JAXBElement }{@code <}{@link Tremolo }{@code >}
     * {@link JAXBElement }{@code <}{@link WavyLine }{@code >}
     * {@link JAXBElement }{@code <}{@link AccidentalMark }{@code >}
     * {@link JAXBElement }{@code <}{@link PlacementText }{@code >}
     * {@link JAXBElement }{@code <}{@link Mordent }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyTrillSound }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyPlacement }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyTrillSound }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyTrillSound }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyTrillSound }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getTrillMarkOrTurnOrDelayedTurn() {
        if (trillMarkOrTurnOrDelayedTurn == null) {
            trillMarkOrTurnOrDelayedTurn = new ArrayList<JAXBElement<?>>();
        }
        return this.trillMarkOrTurnOrDelayedTurn;
    }

}
