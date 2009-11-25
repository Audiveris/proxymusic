
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for degree-type-value.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="degree-type-value">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="add"/>
 *     &lt;enumeration value="alter"/>
 *     &lt;enumeration value="subtract"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "degree-type-value")
@XmlEnum
public enum DegreeTypeValue {

    @XmlEnumValue("add")
    ADD("add"),
    @XmlEnumValue("alter")
    ALTER("alter"),
    @XmlEnumValue("subtract")
    SUBTRACT("subtract");
    private final java.lang.String value;

    DegreeTypeValue(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static DegreeTypeValue fromValue(java.lang.String v) {
        for (DegreeTypeValue c: DegreeTypeValue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
