
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for time-separator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="time-separator">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="horizontal"/>
 *     &lt;enumeration value="diagonal"/>
 *     &lt;enumeration value="vertical"/>
 *     &lt;enumeration value="adjacent"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "time-separator")
@XmlEnum
public enum TimeSeparator {

    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("horizontal")
    HORIZONTAL("horizontal"),
    @XmlEnumValue("diagonal")
    DIAGONAL("diagonal"),
    @XmlEnumValue("vertical")
    VERTICAL("vertical"),
    @XmlEnumValue("adjacent")
    ADJACENT("adjacent");
    private final java.lang.String value;

    TimeSeparator(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static TimeSeparator fromValue(java.lang.String v) {
        for (TimeSeparator c: TimeSeparator.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
