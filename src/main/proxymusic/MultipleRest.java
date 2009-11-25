
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * The text of the multiple-rest type indicates the number of measures in the multiple rest. Multiple rests may use the 1-bar / 2-bar / 4-bar rest symbols, or a single shape. The use-symbols attribute indicates which to use; it is no if not specified. The element text is ignored when the type is stop.
 * 
 * <p>Java class for multiple-rest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="multiple-rest">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;>positive-integer-or-empty">
 *       &lt;attribute name="use-symbols" type="{}yes-no" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "multiple-rest", propOrder = {
    "value"
})
public class MultipleRest {

    @XmlValue
    protected java.lang.String value;
    @XmlAttribute(name = "use-symbols")
    protected YesNo useSymbols;

    /**
     * The number-or-normal values can be either a positive integer or an empty string. This is used for the content of the ensemble element.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }

    /**
     * Gets the value of the useSymbols property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getUseSymbols() {
        return useSymbols;
    }

    /**
     * Sets the value of the useSymbols property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setUseSymbols(YesNo value) {
        this.useSymbols = value;
    }

}
