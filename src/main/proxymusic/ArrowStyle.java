
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for arrow-style.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="arrow-style">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="single"/>
 *     &lt;enumeration value="double"/>
 *     &lt;enumeration value="filled"/>
 *     &lt;enumeration value="hollow"/>
 *     &lt;enumeration value="paired"/>
 *     &lt;enumeration value="combined"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "arrow-style")
@XmlEnum
public enum ArrowStyle {

    @XmlEnumValue("single")
    SINGLE("single"),
    @XmlEnumValue("double")
    DOUBLE("double"),
    @XmlEnumValue("filled")
    FILLED("filled"),
    @XmlEnumValue("hollow")
    HOLLOW("hollow"),
    @XmlEnumValue("paired")
    PAIRED("paired"),
    @XmlEnumValue("combined")
    COMBINED("combined"),
    @XmlEnumValue("other")
    OTHER("other");
    private final java.lang.String value;

    ArrowStyle(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static ArrowStyle fromValue(java.lang.String v) {
        for (ArrowStyle c: ArrowStyle.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
