
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * The heel and toe elements are used with organ pedals. The substitution value is "no" if the attribute is not present.
 * 
 * <p>Java class for heel-toe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="heel-toe">
 *   &lt;complexContent>
 *     &lt;extension base="{}empty-placement">
 *       &lt;attribute name="substitution" type="{}yes-no" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "heel-toe")
public class HeelToe
    extends EmptyPlacement
{

    @XmlAttribute
    protected YesNo substitution;

    /**
     * Gets the value of the substitution property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getSubstitution() {
        return substitution;
    }

    /**
     * Sets the value of the substitution property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setSubstitution(YesNo value) {
        this.substitution = value;
    }

}
