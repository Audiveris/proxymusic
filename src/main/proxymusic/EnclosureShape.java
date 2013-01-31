
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for enclosure-shape.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="enclosure-shape">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="rectangle"/>
 *     &lt;enumeration value="square"/>
 *     &lt;enumeration value="oval"/>
 *     &lt;enumeration value="circle"/>
 *     &lt;enumeration value="bracket"/>
 *     &lt;enumeration value="triangle"/>
 *     &lt;enumeration value="diamond"/>
 *     &lt;enumeration value="none"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "enclosure-shape")
@XmlEnum
public enum EnclosureShape {

    @XmlEnumValue("rectangle")
    RECTANGLE("rectangle"),
    @XmlEnumValue("square")
    SQUARE("square"),
    @XmlEnumValue("oval")
    OVAL("oval"),
    @XmlEnumValue("circle")
    CIRCLE("circle"),
    @XmlEnumValue("bracket")
    BRACKET("bracket"),
    @XmlEnumValue("triangle")
    TRIANGLE("triangle"),
    @XmlEnumValue("diamond")
    DIAMOND("diamond"),
    @XmlEnumValue("none")
    NONE("none");
    private final java.lang.String value;

    EnclosureShape(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static EnclosureShape fromValue(java.lang.String v) {
        for (EnclosureShape c: EnclosureShape.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
