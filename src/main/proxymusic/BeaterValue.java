
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for beater-value.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="beater-value">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="bow"/>
 *     &lt;enumeration value="chime hammer"/>
 *     &lt;enumeration value="coin"/>
 *     &lt;enumeration value="finger"/>
 *     &lt;enumeration value="fingernail"/>
 *     &lt;enumeration value="fist"/>
 *     &lt;enumeration value="guiro scraper"/>
 *     &lt;enumeration value="hammer"/>
 *     &lt;enumeration value="hand"/>
 *     &lt;enumeration value="jazz stick"/>
 *     &lt;enumeration value="knitting needle"/>
 *     &lt;enumeration value="metal hammer"/>
 *     &lt;enumeration value="snare stick"/>
 *     &lt;enumeration value="spoon mallet"/>
 *     &lt;enumeration value="triangle beater"/>
 *     &lt;enumeration value="triangle beater plain"/>
 *     &lt;enumeration value="wire brush"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "beater-value")
@XmlEnum
public enum BeaterValue {

    @XmlEnumValue("bow")
    BOW("bow"),
    @XmlEnumValue("chime hammer")
    CHIME_HAMMER("chime hammer"),
    @XmlEnumValue("coin")
    COIN("coin"),
    @XmlEnumValue("finger")
    FINGER("finger"),
    @XmlEnumValue("fingernail")
    FINGERNAIL("fingernail"),
    @XmlEnumValue("fist")
    FIST("fist"),
    @XmlEnumValue("guiro scraper")
    GUIRO_SCRAPER("guiro scraper"),
    @XmlEnumValue("hammer")
    HAMMER("hammer"),
    @XmlEnumValue("hand")
    HAND("hand"),
    @XmlEnumValue("jazz stick")
    JAZZ_STICK("jazz stick"),
    @XmlEnumValue("knitting needle")
    KNITTING_NEEDLE("knitting needle"),
    @XmlEnumValue("metal hammer")
    METAL_HAMMER("metal hammer"),
    @XmlEnumValue("snare stick")
    SNARE_STICK("snare stick"),
    @XmlEnumValue("spoon mallet")
    SPOON_MALLET("spoon mallet"),
    @XmlEnumValue("triangle beater")
    TRIANGLE_BEATER("triangle beater"),
    @XmlEnumValue("triangle beater plain")
    TRIANGLE_BEATER_PLAIN("triangle beater plain"),
    @XmlEnumValue("wire brush")
    WIRE_BRUSH("wire brush");
    private final java.lang.String value;

    BeaterValue(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static BeaterValue fromValue(java.lang.String v) {
        for (BeaterValue c: BeaterValue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
