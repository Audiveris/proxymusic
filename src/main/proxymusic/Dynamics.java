
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * Dynamics can be associated either with a note or a
 * general musical direction. To avoid inconsistencies
 * between and amongst the letter abbreviations for
 * dynamics (what is sf vs. sfz, standing alone or with a
 * trailing dynamic that is not always piano), we use the
 * actual letters as the names of these dynamic elements.
 * The element other-dynamics allows other dynamic marks
 * that are not covered here, but many of those should
 * perhaps be included in a more general musical
 * direction element. Dynamics may also be combined as
 * in <sf/><mp/>.
 * 
 * These letter dynamic symbols are separated from
 * crescendo, decrescendo, and wedge indications. Dynamic
 * representation is basically inconsistent in scores
 * (lots of things are assumed by the composer and left out,
 * such as returns to original dynamics), and is quite
 * complex to do systematically. Humdrum for instance has
 * at least 3 representation formats related to dynamics.
 * MusicXML captures what is in the score, but does not try
 * to be optimal for analysis or synthesis of dynamics.
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
 *           &lt;element ref="{}p"/>
 *           &lt;element ref="{}pp"/>
 *           &lt;element ref="{}ppp"/>
 *           &lt;element ref="{}pppp"/>
 *           &lt;element ref="{}ppppp"/>
 *           &lt;element ref="{}pppppp"/>
 *           &lt;element ref="{}f"/>
 *           &lt;element ref="{}ff"/>
 *           &lt;element ref="{}fff"/>
 *           &lt;element ref="{}ffff"/>
 *           &lt;element ref="{}fffff"/>
 *           &lt;element ref="{}ffffff"/>
 *           &lt;element ref="{}mp"/>
 *           &lt;element ref="{}mf"/>
 *           &lt;element ref="{}sf"/>
 *           &lt;element ref="{}sfp"/>
 *           &lt;element ref="{}sfpp"/>
 *           &lt;element ref="{}fp"/>
 *           &lt;element ref="{}rf"/>
 *           &lt;element ref="{}rfz"/>
 *           &lt;element ref="{}sfz"/>
 *           &lt;element ref="{}sffz"/>
 *           &lt;element ref="{}fz"/>
 *           &lt;element ref="{}other-dynamics"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}placement"/>
 *       &lt;attGroup ref="{}print-style"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pOrPpOrPpp"
})
@XmlRootElement(name = "dynamics")
public class Dynamics {

    @XmlElements({
        @XmlElement(name = "ppppp", type = Ppppp.class),
        @XmlElement(name = "ppp", type = Ppp.class),
        @XmlElement(name = "pppppp", type = Pppppp.class),
        @XmlElement(name = "sfp", type = Sfp.class),
        @XmlElement(name = "mp", type = Mp.class),
        @XmlElement(name = "ffff", type = Ffff.class),
        @XmlElement(name = "ff", type = Ff.class),
        @XmlElement(name = "fffff", type = Fffff.class),
        @XmlElement(name = "fff", type = Fff.class),
        @XmlElement(name = "pp", type = Pp.class),
        @XmlElement(name = "mf", type = Mf.class),
        @XmlElement(name = "rfz", type = Rfz.class),
        @XmlElement(name = "sfz", type = Sfz.class),
        @XmlElement(name = "fz", type = Fz.class),
        @XmlElement(name = "other-dynamics", type = OtherDynamics.class),
        @XmlElement(name = "sffz", type = Sffz.class),
        @XmlElement(name = "rf", type = Rf.class),
        @XmlElement(name = "fp", type = Fp.class),
        @XmlElement(name = "pppp", type = Pppp.class),
        @XmlElement(name = "f", type = F.class),
        @XmlElement(name = "ffffff", type = Ffffff.class),
        @XmlElement(name = "p", type = P.class),
        @XmlElement(name = "sf", type = Sf.class),
        @XmlElement(name = "sfpp", type = Sfpp.class)
    })
    protected List<Object> pOrPpOrPpp;
    @XmlAttribute
    protected java.lang.String placement;
    @XmlAttribute(name = "default-x")
    protected java.lang.String defaultX;
    @XmlAttribute(name = "default-y")
    protected java.lang.String defaultY;
    @XmlAttribute(name = "relative-x")
    protected java.lang.String relativeX;
    @XmlAttribute(name = "relative-y")
    protected java.lang.String relativeY;
    @XmlAttribute(name = "font-family")
    protected java.lang.String fontFamily;
    @XmlAttribute(name = "font-size")
    protected java.lang.String fontSize;
    @XmlAttribute(name = "font-style")
    protected java.lang.String fontStyle;
    @XmlAttribute(name = "font-weight")
    protected java.lang.String fontWeight;
    @XmlAttribute
    protected java.lang.String color;

    /**
     * Gets the value of the pOrPpOrPpp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pOrPpOrPpp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPOrPpOrPpp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ppppp }
     * {@link Ppp }
     * {@link Pppppp }
     * {@link Sfp }
     * {@link Mp }
     * {@link Ffff }
     * {@link Ff }
     * {@link Fffff }
     * {@link Fff }
     * {@link Pp }
     * {@link Mf }
     * {@link Rfz }
     * {@link Sfz }
     * {@link Fz }
     * {@link OtherDynamics }
     * {@link Sffz }
     * {@link Rf }
     * {@link Fp }
     * {@link Pppp }
     * {@link F }
     * {@link Ffffff }
     * {@link P }
     * {@link Sf }
     * {@link Sfpp }
     * 
     * 
     */
    public List<Object> getPOrPpOrPpp() {
        if (pOrPpOrPpp == null) {
            pOrPpOrPpp = new ArrayList<Object>();
        }
        return this.pOrPpOrPpp;
    }

    /**
     * Gets the value of the placement property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPlacement() {
        return placement;
    }

    /**
     * Sets the value of the placement property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPlacement(java.lang.String value) {
        this.placement = value;
    }

    /**
     * Gets the value of the defaultX property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getDefaultX() {
        return defaultX;
    }

    /**
     * Sets the value of the defaultX property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setDefaultX(java.lang.String value) {
        this.defaultX = value;
    }

    /**
     * Gets the value of the defaultY property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getDefaultY() {
        return defaultY;
    }

    /**
     * Sets the value of the defaultY property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setDefaultY(java.lang.String value) {
        this.defaultY = value;
    }

    /**
     * Gets the value of the relativeX property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getRelativeX() {
        return relativeX;
    }

    /**
     * Sets the value of the relativeX property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setRelativeX(java.lang.String value) {
        this.relativeX = value;
    }

    /**
     * Gets the value of the relativeY property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getRelativeY() {
        return relativeY;
    }

    /**
     * Sets the value of the relativeY property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setRelativeY(java.lang.String value) {
        this.relativeY = value;
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
     * Gets the value of the fontStyle property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getFontStyle() {
        return fontStyle;
    }

    /**
     * Sets the value of the fontStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setFontStyle(java.lang.String value) {
        this.fontStyle = value;
    }

    /**
     * Gets the value of the fontWeight property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getFontWeight() {
        return fontWeight;
    }

    /**
     * Sets the value of the fontWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setFontWeight(java.lang.String value) {
        this.fontWeight = value;
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
