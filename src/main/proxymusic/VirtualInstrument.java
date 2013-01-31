
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The virtual-instrument element defines a specific virtual instrument used for an instrument sound.
 * 
 * <p>Java class for virtual-instrument complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="virtual-instrument">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="virtual-library" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="virtual-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "virtual-instrument", propOrder = {
    "virtualLibrary",
    "virtualName"
})
public class VirtualInstrument {

    @XmlElement(name = "virtual-library")
    protected java.lang.String virtualLibrary;
    @XmlElement(name = "virtual-name")
    protected java.lang.String virtualName;

    /**
     * Gets the value of the virtualLibrary property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getVirtualLibrary() {
        return virtualLibrary;
    }

    /**
     * Sets the value of the virtualLibrary property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setVirtualLibrary(java.lang.String value) {
        this.virtualLibrary = value;
    }

    /**
     * Gets the value of the virtualName property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getVirtualName() {
        return virtualName;
    }

    /**
     * Sets the value of the virtualName property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setVirtualName(java.lang.String value) {
        this.virtualName = value;
    }

}
