
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for arrow-direction.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="arrow-direction">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="left"/>
 *     &lt;enumeration value="up"/>
 *     &lt;enumeration value="right"/>
 *     &lt;enumeration value="down"/>
 *     &lt;enumeration value="northwest"/>
 *     &lt;enumeration value="northeast"/>
 *     &lt;enumeration value="southeast"/>
 *     &lt;enumeration value="southwest"/>
 *     &lt;enumeration value="left right"/>
 *     &lt;enumeration value="up down"/>
 *     &lt;enumeration value="northwest southeast"/>
 *     &lt;enumeration value="northeast southwest"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "arrow-direction")
@XmlEnum
public enum ArrowDirection {

    @XmlEnumValue("left")
    LEFT("left"),
    @XmlEnumValue("up")
    UP("up"),
    @XmlEnumValue("right")
    RIGHT("right"),
    @XmlEnumValue("down")
    DOWN("down"),
    @XmlEnumValue("northwest")
    NORTHWEST("northwest"),
    @XmlEnumValue("northeast")
    NORTHEAST("northeast"),
    @XmlEnumValue("southeast")
    SOUTHEAST("southeast"),
    @XmlEnumValue("southwest")
    SOUTHWEST("southwest"),
    @XmlEnumValue("left right")
    LEFT_RIGHT("left right"),
    @XmlEnumValue("up down")
    UP_DOWN("up down"),
    @XmlEnumValue("northwest southeast")
    NORTHWEST_SOUTHEAST("northwest southeast"),
    @XmlEnumValue("northeast southwest")
    NORTHEAST_SOUTHWEST("northeast southwest"),
    @XmlEnumValue("other")
    OTHER("other");
    private final java.lang.String value;

    ArrowDirection(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static ArrowDirection fromValue(java.lang.String v) {
        for (ArrowDirection c: ArrowDirection.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
