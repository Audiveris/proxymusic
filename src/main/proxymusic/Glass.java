
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for glass.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="glass">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="wind chimes"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "glass")
@XmlEnum
public enum Glass {

    @XmlEnumValue("wind chimes")
    WIND_CHIMES("wind chimes");
    private final java.lang.String value;

    Glass(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static Glass fromValue(java.lang.String v) {
        for (Glass c: Glass.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
