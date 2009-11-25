
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * The strong-accent type indicates a vertical accent mark. The type attribute indicates if the point of the accent is down or up.
 * 
 * <p>Java class for strong-accent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="strong-accent">
 *   &lt;complexContent>
 *     &lt;extension base="{}empty-placement">
 *       &lt;attribute name="type" type="{}up-down" default="up" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "strong-accent")
public class StrongAccent
    extends EmptyPlacement
{

    @XmlAttribute
    protected UpDown type;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link UpDown }
     *     
     */
    public UpDown getType() {
        if (type == null) {
            return UpDown.UP;
        } else {
            return type;
        }
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpDown }
     *     
     */
    public void setType(UpDown value) {
        this.type = value;
    }

}
