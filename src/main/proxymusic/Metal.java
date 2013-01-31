
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for metal.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="metal">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="almglocken"/>
 *     &lt;enumeration value="bell"/>
 *     &lt;enumeration value="bell plate"/>
 *     &lt;enumeration value="brake drum"/>
 *     &lt;enumeration value="Chinese cymbal"/>
 *     &lt;enumeration value="cowbell"/>
 *     &lt;enumeration value="crash cymbals"/>
 *     &lt;enumeration value="crotale"/>
 *     &lt;enumeration value="cymbal tongs"/>
 *     &lt;enumeration value="domed gong"/>
 *     &lt;enumeration value="finger cymbals"/>
 *     &lt;enumeration value="flexatone"/>
 *     &lt;enumeration value="gong"/>
 *     &lt;enumeration value="hi-hat"/>
 *     &lt;enumeration value="high-hat cymbals"/>
 *     &lt;enumeration value="handbell"/>
 *     &lt;enumeration value="sistrum"/>
 *     &lt;enumeration value="sizzle cymbal"/>
 *     &lt;enumeration value="sleigh bells"/>
 *     &lt;enumeration value="suspended cymbal"/>
 *     &lt;enumeration value="tam tam"/>
 *     &lt;enumeration value="triangle"/>
 *     &lt;enumeration value="Vietnamese hat"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "metal")
@XmlEnum
public enum Metal {

    @XmlEnumValue("almglocken")
    ALMGLOCKEN("almglocken"),
    @XmlEnumValue("bell")
    BELL("bell"),
    @XmlEnumValue("bell plate")
    BELL_PLATE("bell plate"),
    @XmlEnumValue("brake drum")
    BRAKE_DRUM("brake drum"),
    @XmlEnumValue("Chinese cymbal")
    CHINESE_CYMBAL("Chinese cymbal"),
    @XmlEnumValue("cowbell")
    COWBELL("cowbell"),
    @XmlEnumValue("crash cymbals")
    CRASH_CYMBALS("crash cymbals"),
    @XmlEnumValue("crotale")
    CROTALE("crotale"),
    @XmlEnumValue("cymbal tongs")
    CYMBAL_TONGS("cymbal tongs"),
    @XmlEnumValue("domed gong")
    DOMED_GONG("domed gong"),
    @XmlEnumValue("finger cymbals")
    FINGER_CYMBALS("finger cymbals"),
    @XmlEnumValue("flexatone")
    FLEXATONE("flexatone"),
    @XmlEnumValue("gong")
    GONG("gong"),
    @XmlEnumValue("hi-hat")
    HI_HAT("hi-hat"),
    @XmlEnumValue("high-hat cymbals")
    HIGH_HAT_CYMBALS("high-hat cymbals"),
    @XmlEnumValue("handbell")
    HANDBELL("handbell"),
    @XmlEnumValue("sistrum")
    SISTRUM("sistrum"),
    @XmlEnumValue("sizzle cymbal")
    SIZZLE_CYMBAL("sizzle cymbal"),
    @XmlEnumValue("sleigh bells")
    SLEIGH_BELLS("sleigh bells"),
    @XmlEnumValue("suspended cymbal")
    SUSPENDED_CYMBAL("suspended cymbal"),
    @XmlEnumValue("tam tam")
    TAM_TAM("tam tam"),
    @XmlEnumValue("triangle")
    TRIANGLE("triangle"),
    @XmlEnumValue("Vietnamese hat")
    VIETNAMESE_HAT("Vietnamese hat");
    private final java.lang.String value;

    Metal(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static Metal fromValue(java.lang.String v) {
        for (Metal c: Metal.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
