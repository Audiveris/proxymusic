
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
 * Articulations and accents are grouped together here.
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
 *           &lt;element ref="{}accent"/>
 *           &lt;element ref="{}strong-accent"/>
 *           &lt;element ref="{}staccato"/>
 *           &lt;element ref="{}tenuto"/>
 *           &lt;element ref="{}detached-legato"/>
 *           &lt;element ref="{}staccatissimo"/>
 *           &lt;element ref="{}spiccato"/>
 *           &lt;element ref="{}scoop"/>
 *           &lt;element ref="{}plop"/>
 *           &lt;element ref="{}doit"/>
 *           &lt;element ref="{}falloff"/>
 *           &lt;element ref="{}breath-mark"/>
 *           &lt;element ref="{}caesura"/>
 *           &lt;element ref="{}other-articulation"/>
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
    "accentOrStrongAccentOrStaccato"
})
@XmlRootElement(name = "articulations")
public class Articulations {

    @XmlElements({
        @XmlElement(name = "staccatissimo", type = Staccatissimo.class),
        @XmlElement(name = "caesura", type = Caesura.class),
        @XmlElement(name = "tenuto", type = Tenuto.class),
        @XmlElement(name = "spiccato", type = Spiccato.class),
        @XmlElement(name = "falloff", type = Falloff.class),
        @XmlElement(name = "staccato", type = Staccato.class),
        @XmlElement(name = "scoop", type = Scoop.class),
        @XmlElement(name = "strong-accent", type = StrongAccent.class),
        @XmlElement(name = "accent", type = Accent.class),
        @XmlElement(name = "doit", type = Doit.class),
        @XmlElement(name = "other-articulation", type = OtherArticulation.class),
        @XmlElement(name = "breath-mark", type = BreathMark.class),
        @XmlElement(name = "detached-legato", type = DetachedLegato.class),
        @XmlElement(name = "plop", type = Plop.class)
    })
    protected List<Object> accentOrStrongAccentOrStaccato;

    /**
     * Gets the value of the accentOrStrongAccentOrStaccato property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accentOrStrongAccentOrStaccato property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccentOrStrongAccentOrStaccato().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Staccatissimo }
     * {@link Caesura }
     * {@link Tenuto }
     * {@link Spiccato }
     * {@link Falloff }
     * {@link Staccato }
     * {@link Scoop }
     * {@link StrongAccent }
     * {@link Accent }
     * {@link Doit }
     * {@link OtherArticulation }
     * {@link BreathMark }
     * {@link DetachedLegato }
     * {@link Plop }
     * 
     * 
     */
    public List<Object> getAccentOrStrongAccentOrStaccato() {
        if (accentOrStrongAccentOrStaccato == null) {
            accentOrStrongAccentOrStaccato = new ArrayList<Object>();
        }
        return this.accentOrStrongAccentOrStaccato;
    }

}
