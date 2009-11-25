
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for line-type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="line-type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="solid"/>
 *     &lt;enumeration value="dashed"/>
 *     &lt;enumeration value="dotted"/>
 *     &lt;enumeration value="wavy"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "line-type")
@XmlEnum
public enum LineType {

    @XmlEnumValue("solid")
    SOLID("solid"),
    @XmlEnumValue("dashed")
    DASHED("dashed"),
    @XmlEnumValue("dotted")
    DOTTED("dotted"),
    @XmlEnumValue("wavy")
    WAVY("wavy");
    private final java.lang.String value;

    LineType(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static LineType fromValue(java.lang.String v) {
        for (LineType c: LineType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
