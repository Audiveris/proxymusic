
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for over-under.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="over-under">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="over"/>
 *     &lt;enumeration value="under"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "over-under")
@XmlEnum
public enum OverUnder {

    @XmlEnumValue("over")
    OVER("over"),
    @XmlEnumValue("under")
    UNDER("under");
    private final java.lang.String value;

    OverUnder(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static OverUnder fromValue(java.lang.String v) {
        for (OverUnder c: OverUnder.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
