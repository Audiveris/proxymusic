
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for text-direction.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="text-direction">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="ltr"/>
 *     &lt;enumeration value="rtl"/>
 *     &lt;enumeration value="lro"/>
 *     &lt;enumeration value="rlo"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "text-direction")
@XmlEnum
public enum TextDirection {

    @XmlEnumValue("ltr")
    LTR("ltr"),
    @XmlEnumValue("rtl")
    RTL("rtl"),
    @XmlEnumValue("lro")
    LRO("lro"),
    @XmlEnumValue("rlo")
    RLO("rlo");
    private final java.lang.String value;

    TextDirection(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static TextDirection fromValue(java.lang.String v) {
        for (TextDirection c: TextDirection.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
