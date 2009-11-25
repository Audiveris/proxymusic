
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for enclosure.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="enclosure">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="rectangle"/>
 *     &lt;enumeration value="oval"/>
 *     &lt;enumeration value="none"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "enclosure")
@XmlEnum
public enum Enclosure {

    @XmlEnumValue("rectangle")
    RECTANGLE("rectangle"),
    @XmlEnumValue("oval")
    OVAL("oval"),
    @XmlEnumValue("none")
    NONE("none");
    private final java.lang.String value;

    Enclosure(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static Enclosure fromValue(java.lang.String v) {
        for (Enclosure c: Enclosure.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
