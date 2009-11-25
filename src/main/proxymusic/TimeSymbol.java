
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for time-symbol.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="time-symbol">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="common"/>
 *     &lt;enumeration value="cut"/>
 *     &lt;enumeration value="single-number"/>
 *     &lt;enumeration value="normal"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "time-symbol")
@XmlEnum
public enum TimeSymbol {

    @XmlEnumValue("common")
    COMMON("common"),
    @XmlEnumValue("cut")
    CUT("cut"),
    @XmlEnumValue("single-number")
    SINGLE_NUMBER("single-number"),
    @XmlEnumValue("normal")
    NORMAL("normal");
    private final java.lang.String value;

    TimeSymbol(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static TimeSymbol fromValue(java.lang.String v) {
        for (TimeSymbol c: TimeSymbol.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
