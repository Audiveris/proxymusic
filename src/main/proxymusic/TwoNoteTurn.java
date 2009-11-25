
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for two-note-turn.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="two-note-turn">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="whole"/>
 *     &lt;enumeration value="half"/>
 *     &lt;enumeration value="none"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "two-note-turn")
@XmlEnum
public enum TwoNoteTurn {

    @XmlEnumValue("whole")
    WHOLE("whole"),
    @XmlEnumValue("half")
    HALF("half"),
    @XmlEnumValue("none")
    NONE("none");
    private final java.lang.String value;

    TwoNoteTurn(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static TwoNoteTurn fromValue(java.lang.String v) {
        for (TwoNoteTurn c: TwoNoteTurn.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
