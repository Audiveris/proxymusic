
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for stem-value.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="stem-value">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="down"/>
 *     &lt;enumeration value="up"/>
 *     &lt;enumeration value="double"/>
 *     &lt;enumeration value="none"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "stem-value")
@XmlEnum
public enum StemValue {

    @XmlEnumValue("down")
    DOWN("down"),
    @XmlEnumValue("up")
    UP("up"),
    @XmlEnumValue("double")
    DOUBLE("double"),
    @XmlEnumValue("none")
    NONE("none");
    private final java.lang.String value;

    StemValue(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static StemValue fromValue(java.lang.String v) {
        for (StemValue c: StemValue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
