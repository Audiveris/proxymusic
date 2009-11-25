
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rehearsal-enclosure.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="rehearsal-enclosure">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="square"/>
 *     &lt;enumeration value="circle"/>
 *     &lt;enumeration value="none"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "rehearsal-enclosure")
@XmlEnum
public enum RehearsalEnclosure {

    @XmlEnumValue("square")
    SQUARE("square"),
    @XmlEnumValue("circle")
    CIRCLE("circle"),
    @XmlEnumValue("none")
    NONE("none");
    private final java.lang.String value;

    RehearsalEnclosure(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static RehearsalEnclosure fromValue(java.lang.String v) {
        for (RehearsalEnclosure c: RehearsalEnclosure.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
