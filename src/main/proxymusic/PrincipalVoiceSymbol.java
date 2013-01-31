
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for principal-voice-symbol.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="principal-voice-symbol">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Hauptstimme"/>
 *     &lt;enumeration value="Nebenstimme"/>
 *     &lt;enumeration value="plain"/>
 *     &lt;enumeration value="none"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "principal-voice-symbol")
@XmlEnum
public enum PrincipalVoiceSymbol {

    @XmlEnumValue("Hauptstimme")
    HAUPTSTIMME("Hauptstimme"),
    @XmlEnumValue("Nebenstimme")
    NEBENSTIMME("Nebenstimme"),
    @XmlEnumValue("plain")
    PLAIN("plain"),
    @XmlEnumValue("none")
    NONE("none");
    private final java.lang.String value;

    PrincipalVoiceSymbol(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static PrincipalVoiceSymbol fromValue(java.lang.String v) {
        for (PrincipalVoiceSymbol c: PrincipalVoiceSymbol.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
