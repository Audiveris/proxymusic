
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * Technical indications give performance information for
 * individual instruments. The current elements are
 * weighted towards keyboard and string instruments.
 * Woodwind, brass, and percussion will be treated
 * more thoroughly in later revisions.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{}up-bow"/>
 *           &lt;element ref="{}down-bow"/>
 *           &lt;element ref="{}harmonic"/>
 *           &lt;element ref="{}open-string"/>
 *           &lt;element ref="{}thumb-position"/>
 *           &lt;element ref="{}fingering"/>
 *           &lt;element ref="{}pluck"/>
 *           &lt;element ref="{}double-tongue"/>
 *           &lt;element ref="{}triple-tongue"/>
 *           &lt;element ref="{}stopped"/>
 *           &lt;element ref="{}snap-pizzicato"/>
 *           &lt;element ref="{}fret"/>
 *           &lt;element ref="{}string"/>
 *           &lt;element ref="{}hammer-on"/>
 *           &lt;element ref="{}pull-off"/>
 *           &lt;element ref="{}bend"/>
 *           &lt;element ref="{}tap"/>
 *           &lt;element ref="{}heel"/>
 *           &lt;element ref="{}toe"/>
 *           &lt;element ref="{}fingernails"/>
 *           &lt;element ref="{}other-technical"/>
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
@XmlType(name = "", propOrder = {
    "upBowOrDownBowOrHarmonic"
})
@XmlRootElement(name = "technical")
public class Technical {

    @XmlElements({
        @XmlElement(name = "toe", type = Toe.class),
        @XmlElement(name = "down-bow", type = DownBow.class),
        @XmlElement(name = "fingering", type = Fingering.class),
        @XmlElement(name = "stopped", type = Stopped.class),
        @XmlElement(name = "triple-tongue", type = TripleTongue.class),
        @XmlElement(name = "heel", type = Heel.class),
        @XmlElement(name = "open-string", type = OpenString.class),
        @XmlElement(name = "string", type = String.class),
        @XmlElement(name = "double-tongue", type = DoubleTongue.class),
        @XmlElement(name = "fingernails", type = Fingernails.class),
        @XmlElement(name = "other-technical", type = OtherTechnical.class),
        @XmlElement(name = "bend", type = Bend.class),
        @XmlElement(name = "hammer-on", type = HammerOn.class),
        @XmlElement(name = "snap-pizzicato", type = SnapPizzicato.class),
        @XmlElement(name = "tap", type = Tap.class),
        @XmlElement(name = "pluck", type = Pluck.class),
        @XmlElement(name = "fret", type = Fret.class),
        @XmlElement(name = "thumb-position", type = ThumbPosition.class),
        @XmlElement(name = "up-bow", type = UpBow.class),
        @XmlElement(name = "harmonic", type = Harmonic.class),
        @XmlElement(name = "pull-off", type = PullOff.class)
    })
    protected List<Object> upBowOrDownBowOrHarmonic;

    /**
     * Gets the value of the upBowOrDownBowOrHarmonic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the upBowOrDownBowOrHarmonic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUpBowOrDownBowOrHarmonic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Toe }
     * {@link DownBow }
     * {@link Fingering }
     * {@link Stopped }
     * {@link TripleTongue }
     * {@link Heel }
     * {@link OpenString }
     * {@link String }
     * {@link DoubleTongue }
     * {@link Fingernails }
     * {@link OtherTechnical }
     * {@link Bend }
     * {@link HammerOn }
     * {@link SnapPizzicato }
     * {@link Tap }
     * {@link Pluck }
     * {@link Fret }
     * {@link ThumbPosition }
     * {@link UpBow }
     * {@link Harmonic }
     * {@link PullOff }
     * 
     * 
     */
    public List<Object> getUpBowOrDownBowOrHarmonic() {
        if (upBowOrDownBowOrHarmonic == null) {
            upBowOrDownBowOrHarmonic = new ArrayList<Object>();
        }
        return this.upBowOrDownBowOrHarmonic;
    }

}
