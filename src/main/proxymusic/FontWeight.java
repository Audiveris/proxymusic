
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for font-weight.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="font-weight">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="normal"/>
 *     &lt;enumeration value="bold"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "font-weight")
@XmlEnum
public enum FontWeight {

    @XmlEnumValue("normal")
    NORMAL("normal"),
    @XmlEnumValue("bold")
    BOLD("bold");
    private final java.lang.String value;

    FontWeight(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static FontWeight fromValue(java.lang.String v) {
        for (FontWeight c: FontWeight.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
