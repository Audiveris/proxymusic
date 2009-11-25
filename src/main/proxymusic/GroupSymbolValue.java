
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for group-symbol-value.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="group-symbol-value">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="brace"/>
 *     &lt;enumeration value="line"/>
 *     &lt;enumeration value="bracket"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "group-symbol-value")
@XmlEnum
public enum GroupSymbolValue {

    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("brace")
    BRACE("brace"),
    @XmlEnumValue("line")
    LINE("line"),
    @XmlEnumValue("bracket")
    BRACKET("bracket");
    private final java.lang.String value;

    GroupSymbolValue(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static GroupSymbolValue fromValue(java.lang.String v) {
        for (GroupSymbolValue c: GroupSymbolValue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
