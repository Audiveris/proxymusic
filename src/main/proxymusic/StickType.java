
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for stick-type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="stick-type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="bass drum"/>
 *     &lt;enumeration value="double bass drum"/>
 *     &lt;enumeration value="timpani"/>
 *     &lt;enumeration value="xylophone"/>
 *     &lt;enumeration value="yarn"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "stick-type")
@XmlEnum
public enum StickType {

    @XmlEnumValue("bass drum")
    BASS_DRUM("bass drum"),
    @XmlEnumValue("double bass drum")
    DOUBLE_BASS_DRUM("double bass drum"),
    @XmlEnumValue("timpani")
    TIMPANI("timpani"),
    @XmlEnumValue("xylophone")
    XYLOPHONE("xylophone"),
    @XmlEnumValue("yarn")
    YARN("yarn");
    private final java.lang.String value;

    StickType(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static StickType fromValue(java.lang.String v) {
        for (StickType c: StickType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
