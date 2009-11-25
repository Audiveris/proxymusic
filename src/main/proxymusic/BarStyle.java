
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bar-style.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="bar-style">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="regular"/>
 *     &lt;enumeration value="dotted"/>
 *     &lt;enumeration value="dashed"/>
 *     &lt;enumeration value="heavy"/>
 *     &lt;enumeration value="light-light"/>
 *     &lt;enumeration value="light-heavy"/>
 *     &lt;enumeration value="heavy-light"/>
 *     &lt;enumeration value="heavy-heavy"/>
 *     &lt;enumeration value="tick"/>
 *     &lt;enumeration value="short"/>
 *     &lt;enumeration value="none"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "bar-style")
@XmlEnum
public enum BarStyle {

    @XmlEnumValue("regular")
    REGULAR("regular"),
    @XmlEnumValue("dotted")
    DOTTED("dotted"),
    @XmlEnumValue("dashed")
    DASHED("dashed"),
    @XmlEnumValue("heavy")
    HEAVY("heavy"),
    @XmlEnumValue("light-light")
    LIGHT_LIGHT("light-light"),
    @XmlEnumValue("light-heavy")
    LIGHT_HEAVY("light-heavy"),
    @XmlEnumValue("heavy-light")
    HEAVY_LIGHT("heavy-light"),
    @XmlEnumValue("heavy-heavy")
    HEAVY_HEAVY("heavy-heavy"),
    @XmlEnumValue("tick")
    TICK("tick"),
    @XmlEnumValue("short")
    SHORT("short"),
    @XmlEnumValue("none")
    NONE("none");
    private final java.lang.String value;

    BarStyle(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static BarStyle fromValue(java.lang.String v) {
        for (BarStyle c: BarStyle.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
