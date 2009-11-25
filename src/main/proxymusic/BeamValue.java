
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for beam-value.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="beam-value">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="begin"/>
 *     &lt;enumeration value="continue"/>
 *     &lt;enumeration value="end"/>
 *     &lt;enumeration value="forward hook"/>
 *     &lt;enumeration value="backward hook"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "beam-value")
@XmlEnum
public enum BeamValue {

    @XmlEnumValue("begin")
    BEGIN("begin"),
    @XmlEnumValue("continue")
    CONTINUE("continue"),
    @XmlEnumValue("end")
    END("end"),
    @XmlEnumValue("forward hook")
    FORWARD_HOOK("forward hook"),
    @XmlEnumValue("backward hook")
    BACKWARD_HOOK("backward hook");
    private final java.lang.String value;

    BeamValue(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static BeamValue fromValue(java.lang.String v) {
        for (BeamValue c: BeamValue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
