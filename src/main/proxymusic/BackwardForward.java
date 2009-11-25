
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for backward-forward.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="backward-forward">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="backward"/>
 *     &lt;enumeration value="forward"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "backward-forward")
@XmlEnum
public enum BackwardForward {

    @XmlEnumValue("backward")
    BACKWARD("backward"),
    @XmlEnumValue("forward")
    FORWARD("forward");
    private final java.lang.String value;

    BackwardForward(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static BackwardForward fromValue(java.lang.String v) {
        for (BackwardForward c: BackwardForward.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
