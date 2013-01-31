
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for membrane.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="membrane">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="bass drum"/>
 *     &lt;enumeration value="bass drum on side"/>
 *     &lt;enumeration value="bongos"/>
 *     &lt;enumeration value="conga drum"/>
 *     &lt;enumeration value="goblet drum"/>
 *     &lt;enumeration value="military drum"/>
 *     &lt;enumeration value="snare drum"/>
 *     &lt;enumeration value="snare drum snares off"/>
 *     &lt;enumeration value="tambourine"/>
 *     &lt;enumeration value="tenor drum"/>
 *     &lt;enumeration value="timbales"/>
 *     &lt;enumeration value="tomtom"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "membrane")
@XmlEnum
public enum Membrane {

    @XmlEnumValue("bass drum")
    BASS_DRUM("bass drum"),
    @XmlEnumValue("bass drum on side")
    BASS_DRUM_ON_SIDE("bass drum on side"),
    @XmlEnumValue("bongos")
    BONGOS("bongos"),
    @XmlEnumValue("conga drum")
    CONGA_DRUM("conga drum"),
    @XmlEnumValue("goblet drum")
    GOBLET_DRUM("goblet drum"),
    @XmlEnumValue("military drum")
    MILITARY_DRUM("military drum"),
    @XmlEnumValue("snare drum")
    SNARE_DRUM("snare drum"),
    @XmlEnumValue("snare drum snares off")
    SNARE_DRUM_SNARES_OFF("snare drum snares off"),
    @XmlEnumValue("tambourine")
    TAMBOURINE("tambourine"),
    @XmlEnumValue("tenor drum")
    TENOR_DRUM("tenor drum"),
    @XmlEnumValue("timbales")
    TIMBALES("timbales"),
    @XmlEnumValue("tomtom")
    TOMTOM("tomtom");
    private final java.lang.String value;

    Membrane(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static Membrane fromValue(java.lang.String v) {
        for (Membrane c: Membrane.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
