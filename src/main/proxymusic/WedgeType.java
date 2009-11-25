
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wedge-type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="wedge-type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="crescendo"/>
 *     &lt;enumeration value="diminuendo"/>
 *     &lt;enumeration value="stop"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "wedge-type")
@XmlEnum
public enum WedgeType {

    @XmlEnumValue("crescendo")
    CRESCENDO("crescendo"),
    @XmlEnumValue("diminuendo")
    DIMINUENDO("diminuendo"),
    @XmlEnumValue("stop")
    STOP("stop");
    private final java.lang.String value;

    WedgeType(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static WedgeType fromValue(java.lang.String v) {
        for (WedgeType c: WedgeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
