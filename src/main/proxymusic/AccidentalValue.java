
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for accidental-value.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="accidental-value">
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
 *     &lt;enumeration value="sharp-down"/>
 *     &lt;enumeration value="sharp-up"/>
 *     &lt;enumeration value="natural-down"/>
 *     &lt;enumeration value="natural-up"/>
 *     &lt;enumeration value="flat-down"/>
 *     &lt;enumeration value="flat-up"/>
 *     &lt;enumeration value="triple-sharp"/>
 *     &lt;enumeration value="triple-flat"/>
 *     &lt;enumeration value="slash-quarter-sharp"/>
 *     &lt;enumeration value="slash-sharp"/>
 *     &lt;enumeration value="slash-flat"/>
 *     &lt;enumeration value="double-slash-flat"/>
 *     &lt;enumeration value="sharp-1"/>
 *     &lt;enumeration value="sharp-2"/>
 *     &lt;enumeration value="sharp-3"/>
 *     &lt;enumeration value="sharp-5"/>
 *     &lt;enumeration value="flat-1"/>
 *     &lt;enumeration value="flat-2"/>
 *     &lt;enumeration value="flat-3"/>
 *     &lt;enumeration value="flat-4"/>
 *     &lt;enumeration value="sori"/>
 *     &lt;enumeration value="koron"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "accidental-value")
@XmlEnum
public enum AccidentalValue {

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
    THREE_QUARTERS_SHARP("three-quarters-sharp"),
    @XmlEnumValue("sharp-down")
    SHARP_DOWN("sharp-down"),
    @XmlEnumValue("sharp-up")
    SHARP_UP("sharp-up"),
    @XmlEnumValue("natural-down")
    NATURAL_DOWN("natural-down"),
    @XmlEnumValue("natural-up")
    NATURAL_UP("natural-up"),
    @XmlEnumValue("flat-down")
    FLAT_DOWN("flat-down"),
    @XmlEnumValue("flat-up")
    FLAT_UP("flat-up"),
    @XmlEnumValue("triple-sharp")
    TRIPLE_SHARP("triple-sharp"),
    @XmlEnumValue("triple-flat")
    TRIPLE_FLAT("triple-flat"),
    @XmlEnumValue("slash-quarter-sharp")
    SLASH_QUARTER_SHARP("slash-quarter-sharp"),
    @XmlEnumValue("slash-sharp")
    SLASH_SHARP("slash-sharp"),
    @XmlEnumValue("slash-flat")
    SLASH_FLAT("slash-flat"),
    @XmlEnumValue("double-slash-flat")
    DOUBLE_SLASH_FLAT("double-slash-flat"),
    @XmlEnumValue("sharp-1")
    SHARP_1("sharp-1"),
    @XmlEnumValue("sharp-2")
    SHARP_2("sharp-2"),
    @XmlEnumValue("sharp-3")
    SHARP_3("sharp-3"),
    @XmlEnumValue("sharp-5")
    SHARP_5("sharp-5"),
    @XmlEnumValue("flat-1")
    FLAT_1("flat-1"),
    @XmlEnumValue("flat-2")
    FLAT_2("flat-2"),
    @XmlEnumValue("flat-3")
    FLAT_3("flat-3"),
    @XmlEnumValue("flat-4")
    FLAT_4("flat-4"),
    @XmlEnumValue("sori")
    SORI("sori"),
    @XmlEnumValue("koron")
    KORON("koron");
    private final java.lang.String value;

    AccidentalValue(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static AccidentalValue fromValue(java.lang.String v) {
        for (AccidentalValue c: AccidentalValue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
