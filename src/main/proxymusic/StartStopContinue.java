
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for start-stop-continue.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="start-stop-continue">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="start"/>
 *     &lt;enumeration value="stop"/>
 *     &lt;enumeration value="continue"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "start-stop-continue")
@XmlEnum
public enum StartStopContinue {

    @XmlEnumValue("start")
    START("start"),
    @XmlEnumValue("stop")
    STOP("stop"),
    @XmlEnumValue("continue")
    CONTINUE("continue");
    private final java.lang.String value;

    StartStopContinue(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static StartStopContinue fromValue(java.lang.String v) {
        for (StartStopContinue c: StartStopContinue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
