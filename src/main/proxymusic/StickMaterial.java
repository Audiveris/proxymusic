
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for stick-material.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="stick-material">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="soft"/>
 *     &lt;enumeration value="medium"/>
 *     &lt;enumeration value="hard"/>
 *     &lt;enumeration value="shaded"/>
 *     &lt;enumeration value="x"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "stick-material")
@XmlEnum
public enum StickMaterial {

    @XmlEnumValue("soft")
    SOFT("soft"),
    @XmlEnumValue("medium")
    MEDIUM("medium"),
    @XmlEnumValue("hard")
    HARD("hard"),
    @XmlEnumValue("shaded")
    SHADED("shaded"),
    @XmlEnumValue("x")
    X("x");
    private final java.lang.String value;

    StickMaterial(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static StickMaterial fromValue(java.lang.String v) {
        for (StickMaterial c: StickMaterial.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
