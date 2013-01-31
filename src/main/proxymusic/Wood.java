
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wood.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="wood">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="board clapper"/>
 *     &lt;enumeration value="cabasa"/>
 *     &lt;enumeration value="castanets"/>
 *     &lt;enumeration value="claves"/>
 *     &lt;enumeration value="guiro"/>
 *     &lt;enumeration value="log drum"/>
 *     &lt;enumeration value="maraca"/>
 *     &lt;enumeration value="maracas"/>
 *     &lt;enumeration value="ratchet"/>
 *     &lt;enumeration value="sandpaper blocks"/>
 *     &lt;enumeration value="slit drum"/>
 *     &lt;enumeration value="temple block"/>
 *     &lt;enumeration value="vibraslap"/>
 *     &lt;enumeration value="wood block"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "wood")
@XmlEnum
public enum Wood {

    @XmlEnumValue("board clapper")
    BOARD_CLAPPER("board clapper"),
    @XmlEnumValue("cabasa")
    CABASA("cabasa"),
    @XmlEnumValue("castanets")
    CASTANETS("castanets"),
    @XmlEnumValue("claves")
    CLAVES("claves"),
    @XmlEnumValue("guiro")
    GUIRO("guiro"),
    @XmlEnumValue("log drum")
    LOG_DRUM("log drum"),
    @XmlEnumValue("maraca")
    MARACA("maraca"),
    @XmlEnumValue("maracas")
    MARACAS("maracas"),
    @XmlEnumValue("ratchet")
    RATCHET("ratchet"),
    @XmlEnumValue("sandpaper blocks")
    SANDPAPER_BLOCKS("sandpaper blocks"),
    @XmlEnumValue("slit drum")
    SLIT_DRUM("slit drum"),
    @XmlEnumValue("temple block")
    TEMPLE_BLOCK("temple block"),
    @XmlEnumValue("vibraslap")
    VIBRASLAP("vibraslap"),
    @XmlEnumValue("wood block")
    WOOD_BLOCK("wood block");
    private final java.lang.String value;

    Wood(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static Wood fromValue(java.lang.String v) {
        for (Wood c: Wood.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
