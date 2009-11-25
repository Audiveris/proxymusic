
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for accidental-text.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="accidental-text">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="sharp"/>
 *     &lt;enumeration value="natural"/>
 *     &lt;enumeration value="flat"/>
 *     &lt;enumeration value="double-sharp"/>
 *     &lt;enumeration value="sharp-sharp"/>
 *     &lt;enumeration value="flat-flat"/>
 *     &lt;enumeration value="natural-sharp"/>
 *     &lt;enumeration value="natural-flat"/>
 *     &lt;enumeration value="quarter-flat"/>
 *     &lt;enumeration value="quarter-sharp"/>
 *     &lt;enumeration value="three-quarters-flat"/>
 *     &lt;enumeration value="three-quarters-sharp"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "accidental-text")
@XmlEnum
public enum AccidentalText {

    @XmlEnumValue("sharp")
    SHARP("sharp"),
    @XmlEnumValue("natural")
    NATURAL("natural"),
    @XmlEnumValue("flat")
    FLAT("flat"),
    @XmlEnumValue("double-sharp")
    DOUBLE_SHARP("double-sharp"),
    @XmlEnumValue("sharp-sharp")
    SHARP_SHARP("sharp-sharp"),
    @XmlEnumValue("flat-flat")
    FLAT_FLAT("flat-flat"),
    @XmlEnumValue("natural-sharp")
    NATURAL_SHARP("natural-sharp"),
    @XmlEnumValue("natural-flat")
    NATURAL_FLAT("natural-flat"),
    @XmlEnumValue("quarter-flat")
    QUARTER_FLAT("quarter-flat"),
    @XmlEnumValue("quarter-sharp")
    QUARTER_SHARP("quarter-sharp"),
    @XmlEnumValue("three-quarters-flat")
    THREE_QUARTERS_FLAT("three-quarters-flat"),
    @XmlEnumValue("three-quarters-sharp")
    THREE_QUARTERS_SHARP("three-quarters-sharp");
    private final java.lang.String value;

    AccidentalText(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static AccidentalText fromValue(java.lang.String v) {
        for (AccidentalText c: AccidentalText.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
