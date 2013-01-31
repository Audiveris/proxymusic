
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for semi-pitched.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="semi-pitched">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="high"/>
 *     &lt;enumeration value="medium-high"/>
 *     &lt;enumeration value="medium"/>
 *     &lt;enumeration value="medium-low"/>
 *     &lt;enumeration value="low"/>
 *     &lt;enumeration value="very-low"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "semi-pitched")
@XmlEnum
public enum SemiPitched {

    @XmlEnumValue("high")
    HIGH("high"),
    @XmlEnumValue("medium-high")
    MEDIUM_HIGH("medium-high"),
    @XmlEnumValue("medium")
    MEDIUM("medium"),
    @XmlEnumValue("medium-low")
    MEDIUM_LOW("medium-low"),
    @XmlEnumValue("low")
    LOW("low"),
    @XmlEnumValue("very-low")
    VERY_LOW("very-low");
    private final java.lang.String value;

    SemiPitched(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static SemiPitched fromValue(java.lang.String v) {
        for (SemiPitched c: SemiPitched.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
