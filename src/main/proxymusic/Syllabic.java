
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for syllabic.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="syllabic">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="single"/>
 *     &lt;enumeration value="begin"/>
 *     &lt;enumeration value="end"/>
 *     &lt;enumeration value="middle"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "syllabic")
@XmlEnum
public enum Syllabic {

    @XmlEnumValue("single")
    SINGLE("single"),
    @XmlEnumValue("begin")
    BEGIN("begin"),
    @XmlEnumValue("end")
    END("end"),
    @XmlEnumValue("middle")
    MIDDLE("middle");
    private final java.lang.String value;

    Syllabic(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static Syllabic fromValue(java.lang.String v) {
        for (Syllabic c: Syllabic.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
