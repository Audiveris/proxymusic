
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for stick-location.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="stick-location">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="center"/>
 *     &lt;enumeration value="rim"/>
 *     &lt;enumeration value="cymbal bell"/>
 *     &lt;enumeration value="cymbal edge"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "stick-location")
@XmlEnum
public enum StickLocation {

    @XmlEnumValue("center")
    CENTER("center"),
    @XmlEnumValue("rim")
    RIM("rim"),
    @XmlEnumValue("cymbal bell")
    CYMBAL_BELL("cymbal bell"),
    @XmlEnumValue("cymbal edge")
    CYMBAL_EDGE("cymbal edge");
    private final java.lang.String value;

    StickLocation(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static StickLocation fromValue(java.lang.String v) {
        for (StickLocation c: StickLocation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
