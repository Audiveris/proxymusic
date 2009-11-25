
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The root type indicates a pitch like C, D, E vs. a function indication like I, II, III. It is used with chord symbols in popular music. The root element has a root-step and optional root-alter element similar to the step and alter elements, but renamed to distinguish the different musical meanings.
 * 
 * <p>Java class for root complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="root">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="root-step" type="{}root-step"/>
 *         &lt;element name="root-alter" type="{}root-alter" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "root", propOrder = {
    "rootStep",
    "rootAlter"
})
public class Root {

    @XmlElement(name = "root-step", required = true)
    protected RootStep rootStep;
    @XmlElement(name = "root-alter")
    protected RootAlter rootAlter;

    /**
     * Gets the value of the rootStep property.
     * 
     * @return
     *     possible object is
     *     {@link RootStep }
     *     
     */
    public RootStep getRootStep() {
        return rootStep;
    }

    /**
     * Sets the value of the rootStep property.
     * 
     * @param value
     *     allowed object is
     *     {@link RootStep }
     *     
     */
    public void setRootStep(RootStep value) {
        this.rootStep = value;
    }

    /**
     * Gets the value of the rootAlter property.
     * 
     * @return
     *     possible object is
     *     {@link RootAlter }
     *     
     */
    public RootAlter getRootAlter() {
        return rootAlter;
    }

    /**
     * Sets the value of the rootAlter property.
     * 
     * @param value
     *     allowed object is
     *     {@link RootAlter }
     *     
     */
    public void setRootAlter(RootAlter value) {
        this.rootAlter = value;
    }

}
