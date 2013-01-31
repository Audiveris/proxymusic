
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pitched.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="pitched">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="chimes"/>
 *     &lt;enumeration value="glockenspiel"/>
 *     &lt;enumeration value="mallet"/>
 *     &lt;enumeration value="marimba"/>
 *     &lt;enumeration value="tubular chimes"/>
 *     &lt;enumeration value="vibraphone"/>
 *     &lt;enumeration value="xylophone"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "pitched")
@XmlEnum
public enum Pitched {

    @XmlEnumValue("chimes")
    CHIMES("chimes"),
    @XmlEnumValue("glockenspiel")
    GLOCKENSPIEL("glockenspiel"),
    @XmlEnumValue("mallet")
    MALLET("mallet"),
    @XmlEnumValue("marimba")
    MARIMBA("marimba"),
    @XmlEnumValue("tubular chimes")
    TUBULAR_CHIMES("tubular chimes"),
    @XmlEnumValue("vibraphone")
    VIBRAPHONE("vibraphone"),
    @XmlEnumValue("xylophone")
    XYLOPHONE("xylophone");
    private final java.lang.String value;

    Pitched(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static Pitched fromValue(java.lang.String v) {
        for (Pitched c: Pitched.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
