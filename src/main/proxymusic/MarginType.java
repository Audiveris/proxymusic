
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for margin-type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="margin-type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="odd"/>
 *     &lt;enumeration value="even"/>
 *     &lt;enumeration value="both"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "margin-type")
@XmlEnum
public enum MarginType {

    @XmlEnumValue("odd")
    ODD("odd"),
    @XmlEnumValue("even")
    EVEN("even"),
    @XmlEnumValue("both")
    BOTH("both");
    private final java.lang.String value;

    MarginType(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static MarginType fromValue(java.lang.String v) {
        for (MarginType c: MarginType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
