
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for winged.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="winged">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="straight"/>
 *     &lt;enumeration value="curved"/>
 *     &lt;enumeration value="double-straight"/>
 *     &lt;enumeration value="double-curved"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "winged")
@XmlEnum
public enum Winged {

    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("straight")
    STRAIGHT("straight"),
    @XmlEnumValue("curved")
    CURVED("curved"),
    @XmlEnumValue("double-straight")
    DOUBLE_STRAIGHT("double-straight"),
    @XmlEnumValue("double-curved")
    DOUBLE_CURVED("double-curved");
    private final java.lang.String value;

    Winged(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static Winged fromValue(java.lang.String v) {
        for (Winged c: Winged.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
