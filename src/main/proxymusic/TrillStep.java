
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for trill-step.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="trill-step">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="whole"/>
 *     &lt;enumeration value="half"/>
 *     &lt;enumeration value="unison"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "trill-step")
@XmlEnum
public enum TrillStep {

    @XmlEnumValue("whole")
    WHOLE("whole"),
    @XmlEnumValue("half")
    HALF("half"),
    @XmlEnumValue("unison")
    UNISON("unison");
    private final java.lang.String value;

    TrillStep(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static TrillStep fromValue(java.lang.String v) {
        for (TrillStep c: TrillStep.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
