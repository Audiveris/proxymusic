
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for right-left-middle.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="right-left-middle">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="right"/>
 *     &lt;enumeration value="left"/>
 *     &lt;enumeration value="middle"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "right-left-middle")
@XmlEnum
public enum RightLeftMiddle {

    @XmlEnumValue("right")
    RIGHT("right"),
    @XmlEnumValue("left")
    LEFT("left"),
    @XmlEnumValue("middle")
    MIDDLE("middle");
    private final java.lang.String value;

    RightLeftMiddle(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static RightLeftMiddle fromValue(java.lang.String v) {
        for (RightLeftMiddle c: RightLeftMiddle.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
