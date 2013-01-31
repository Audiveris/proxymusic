
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for time-relation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="time-relation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="parentheses"/>
 *     &lt;enumeration value="bracket"/>
 *     &lt;enumeration value="equals"/>
 *     &lt;enumeration value="slash"/>
 *     &lt;enumeration value="space"/>
 *     &lt;enumeration value="hyphen"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "time-relation")
@XmlEnum
public enum TimeRelation {

    @XmlEnumValue("parentheses")
    PARENTHESES("parentheses"),
    @XmlEnumValue("bracket")
    BRACKET("bracket"),
    @XmlEnumValue("equals")
    EQUALS("equals"),
    @XmlEnumValue("slash")
    SLASH("slash"),
    @XmlEnumValue("space")
    SPACE("space"),
    @XmlEnumValue("hyphen")
    HYPHEN("hyphen");
    private final java.lang.String value;

    TimeRelation(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static TimeRelation fromValue(java.lang.String v) {
        for (TimeRelation c: TimeRelation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
