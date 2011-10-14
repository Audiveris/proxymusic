
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
 *         &lt;element name="breath-mark" type="{}empty-placement"/>
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
        @XmlElementRef(name = "stress", type = JAXBElement.class),
        @XmlElementRef(name = "doit", type = JAXBElement.class),
        @XmlElementRef(name = "falloff", type = JAXBElement.class),
        @XmlElementRef(name = "plop", type = JAXBElement.class),
        @XmlElementRef(name = "staccato", type = JAXBElement.class),
        @XmlElementRef(name = "unstress", type = JAXBElement.class),
        @XmlElementRef(name = "tenuto", type = JAXBElement.class),
        @XmlElementRef(name = "scoop", type = JAXBElement.class),
        @XmlElementRef(name = "accent", type = JAXBElement.class),
        @XmlElementRef(name = "detached-legato", type = JAXBElement.class),
        @XmlElementRef(name = "spiccato", type = JAXBElement.class),
        @XmlElementRef(name = "staccatissimo", type = JAXBElement.class),
        @XmlElementRef(name = "strong-accent", type = JAXBElement.class),
        @XmlElementRef(name = "breath-mark", type = JAXBElement.class),
        @XmlElementRef(name = "caesura", type = JAXBElement.class),
        @XmlElementRef(name = "other-articulation", type = JAXBElement.class)
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
     * {@link JAXBElement }{@code <}{@link EmptyPlacement }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyLine }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyLine }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyLine }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyPlacement }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyPlacement }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyPlacement }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyLine }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyPlacement }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyPlacement }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyPlacement }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyPlacement }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyPlacement }{@code >}
     * {@link JAXBElement }{@code <}{@link StrongAccent }{@code >}
     * {@link JAXBElement }{@code <}{@link EmptyPlacement }{@code >}
     * {@link JAXBElement }{@code <}{@link PlacementText }{@code >}
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
