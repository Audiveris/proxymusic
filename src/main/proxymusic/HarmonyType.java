
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for harmony-type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="harmony-type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="explicit"/>
 *     &lt;enumeration value="implied"/>
 *     &lt;enumeration value="alternate"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "harmony-type")
@XmlEnum
public enum HarmonyType {

    @XmlEnumValue("explicit")
    EXPLICIT("explicit"),
    @XmlEnumValue("implied")
    IMPLIED("implied"),
    @XmlEnumValue("alternate")
    ALTERNATE("alternate");
    private final java.lang.String value;

    HarmonyType(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static HarmonyType fromValue(java.lang.String v) {
        for (HarmonyType c: HarmonyType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
