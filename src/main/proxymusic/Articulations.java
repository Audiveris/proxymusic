
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
 * Articulations and accents are grouped together here.
 * 
 * <p>Java class for articulations complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="articulations">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="accent" type="{}empty-placement"/>
 *         &lt;element name="strong-accent" type="{}strong-accent"/>
 *         &lt;element name="staccato" type="{}empty-placement"/>
 *         &lt;element name="tenuto" type="{}empty-placement"/>
 *         &lt;element name="detached-legato" type="{}empty-placement"/>
 *         &lt;element name="staccatissimo" type="{}empty-placement"/>
 *         &lt;element name="spiccato" type="{}empty-placement"/>
 *         &lt;element name="scoop" type="{}empty-line"/>
 *         &lt;element name="plop" type="{}empty-line"/>
 *         &lt;element name="doit" type="{}empty-line"/>
 *         &lt;element name="falloff" type="{}empty-line"/>
 *         &lt;element name="breath-mark" type="{}breath-mark"/>
 *         &lt;element name="caesura" type="{}empty-placement"/>
 *         &lt;element name="stress" type="{}empty-placement"/>
 *         &lt;element name="unstress" type="{}empty-placement"/>
 *         &lt;element name="other-articulation" type="{}placement-text"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articulations", propOrder = {
    "accentOrStrongAccentOrStaccato"
})
public class Articulations {

    @XmlElementRefs({
        @XmlElementRef(name = "strong-accent", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "accent", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "staccato", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "unstress", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "scoop", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "caesura", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "breath-mark", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "stress", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "detached-legato", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "other-articulation", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "spiccato", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "tenuto", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "falloff", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "plop", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "doit", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "staccatissimo", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> accentOrStrongAccentOrStaccato;

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
     * {@link JAXBElement }{@code <}{@link StrongAccent }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyPlacement }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyPlacement }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyPlacement }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyLine }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyPlacement }{@code >}
     * {@link JAXBElement }{@code <}{@link BreathMark }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyPlacement }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyPlacement }{@code >}
     * {@link JAXBElement }{@code <}{@link PlacementText }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyPlacement }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyPlacement }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyLine }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyLine }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyLine }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyPlacement }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getAccentOrStrongAccentOrStaccato() {
        if (accentOrStrongAccentOrStaccato == null) {
            accentOrStrongAccentOrStaccato = new ArrayList<JAXBElement<?>>();
        }
        return this.accentOrStrongAccentOrStaccato;
    }

}
