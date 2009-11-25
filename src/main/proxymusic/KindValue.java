
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for kind-value.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="kind-value">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="major"/>
 *     &lt;enumeration value="minor"/>
 *     &lt;enumeration value="augmented"/>
 *     &lt;enumeration value="diminished"/>
 *     &lt;enumeration value="dominant"/>
 *     &lt;enumeration value="major-seventh"/>
 *     &lt;enumeration value="minor-seventh"/>
 *     &lt;enumeration value="diminished-seventh"/>
 *     &lt;enumeration value="augmented-seventh"/>
 *     &lt;enumeration value="half-diminished"/>
 *     &lt;enumeration value="major-minor"/>
 *     &lt;enumeration value="major-sixth"/>
 *     &lt;enumeration value="minor-sixth"/>
 *     &lt;enumeration value="dominant-ninth"/>
 *     &lt;enumeration value="major-ninth"/>
 *     &lt;enumeration value="minor-ninth"/>
 *     &lt;enumeration value="dominant-11th"/>
 *     &lt;enumeration value="major-11th"/>
 *     &lt;enumeration value="minor-11th"/>
 *     &lt;enumeration value="dominant-13th"/>
 *     &lt;enumeration value="major-13th"/>
 *     &lt;enumeration value="minor-13th"/>
 *     &lt;enumeration value="suspended-second"/>
 *     &lt;enumeration value="suspended-fourth"/>
 *     &lt;enumeration value="Neapolitan"/>
 *     &lt;enumeration value="Italian"/>
 *     &lt;enumeration value="French"/>
 *     &lt;enumeration value="German"/>
 *     &lt;enumeration value="pedal"/>
 *     &lt;enumeration value="power"/>
 *     &lt;enumeration value="Tristan"/>
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="none"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "kind-value")
@XmlEnum
public enum KindValue {

    @XmlEnumValue("major")
    MAJOR("major"),
    @XmlEnumValue("minor")
    MINOR("minor"),
    @XmlEnumValue("augmented")
    AUGMENTED("augmented"),
    @XmlEnumValue("diminished")
    DIMINISHED("diminished"),
    @XmlEnumValue("dominant")
    DOMINANT("dominant"),
    @XmlEnumValue("major-seventh")
    MAJOR_SEVENTH("major-seventh"),
    @XmlEnumValue("minor-seventh")
    MINOR_SEVENTH("minor-seventh"),
    @XmlEnumValue("diminished-seventh")
    DIMINISHED_SEVENTH("diminished-seventh"),
    @XmlEnumValue("augmented-seventh")
    AUGMENTED_SEVENTH("augmented-seventh"),
    @XmlEnumValue("half-diminished")
    HALF_DIMINISHED("half-diminished"),
    @XmlEnumValue("major-minor")
    MAJOR_MINOR("major-minor"),
    @XmlEnumValue("major-sixth")
    MAJOR_SIXTH("major-sixth"),
    @XmlEnumValue("minor-sixth")
    MINOR_SIXTH("minor-sixth"),
    @XmlEnumValue("dominant-ninth")
    DOMINANT_NINTH("dominant-ninth"),
    @XmlEnumValue("major-ninth")
    MAJOR_NINTH("major-ninth"),
    @XmlEnumValue("minor-ninth")
    MINOR_NINTH("minor-ninth"),
    @XmlEnumValue("dominant-11th")
    DOMINANT_11_TH("dominant-11th"),
    @XmlEnumValue("major-11th")
    MAJOR_11_TH("major-11th"),
    @XmlEnumValue("minor-11th")
    MINOR_11_TH("minor-11th"),
    @XmlEnumValue("dominant-13th")
    DOMINANT_13_TH("dominant-13th"),
    @XmlEnumValue("major-13th")
    MAJOR_13_TH("major-13th"),
    @XmlEnumValue("minor-13th")
    MINOR_13_TH("minor-13th"),
    @XmlEnumValue("suspended-second")
    SUSPENDED_SECOND("suspended-second"),
    @XmlEnumValue("suspended-fourth")
    SUSPENDED_FOURTH("suspended-fourth"),
    @XmlEnumValue("Neapolitan")
    NEAPOLITAN("Neapolitan"),
    @XmlEnumValue("Italian")
    ITALIAN("Italian"),
    @XmlEnumValue("French")
    FRENCH("French"),
    @XmlEnumValue("German")
    GERMAN("German"),
    @XmlEnumValue("pedal")
    PEDAL("pedal"),
    @XmlEnumValue("power")
    POWER("power"),
    @XmlEnumValue("Tristan")
    TRISTAN("Tristan"),
    @XmlEnumValue("other")
    OTHER("other"),
    @XmlEnumValue("none")
    NONE("none");
    private final java.lang.String value;

    KindValue(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static KindValue fromValue(java.lang.String v) {
        for (KindValue c: KindValue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
