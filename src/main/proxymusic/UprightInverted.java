
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for upright-inverted.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="upright-inverted">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="upright"/>
 *     &lt;enumeration value="inverted"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "upright-inverted")
@XmlEnum
public enum UprightInverted {

    @XmlEnumValue("upright")
    UPRIGHT("upright"),
    @XmlEnumValue("inverted")
    INVERTED("inverted");
    private final java.lang.String value;

    UprightInverted(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static UprightInverted fromValue(java.lang.String v) {
        for (UprightInverted c: UprightInverted.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
