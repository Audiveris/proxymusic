
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for show-tuplet.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="show-tuplet">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="actual"/>
 *     &lt;enumeration value="both"/>
 *     &lt;enumeration value="none"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "show-tuplet")
@XmlEnum
public enum ShowTuplet {

    @XmlEnumValue("actual")
    ACTUAL("actual"),
    @XmlEnumValue("both")
    BOTH("both"),
    @XmlEnumValue("none")
    NONE("none");
    private final java.lang.String value;

    ShowTuplet(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static ShowTuplet fromValue(java.lang.String v) {
        for (ShowTuplet c: ShowTuplet.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
