
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for css-font-size.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="css-font-size">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="xx-small"/>
 *     &lt;enumeration value="x-small"/>
 *     &lt;enumeration value="small"/>
 *     &lt;enumeration value="medium"/>
 *     &lt;enumeration value="large"/>
 *     &lt;enumeration value="x-large"/>
 *     &lt;enumeration value="xx-large"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "css-font-size")
@XmlEnum
public enum CssFontSize {

    @XmlEnumValue("xx-small")
    XX_SMALL("xx-small"),
    @XmlEnumValue("x-small")
    X_SMALL("x-small"),
    @XmlEnumValue("small")
    SMALL("small"),
    @XmlEnumValue("medium")
    MEDIUM("medium"),
    @XmlEnumValue("large")
    LARGE("large"),
    @XmlEnumValue("x-large")
    X_LARGE("x-large"),
    @XmlEnumValue("xx-large")
    XX_LARGE("xx-large");
    private final java.lang.String value;

    CssFontSize(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static CssFontSize fromValue(java.lang.String v) {
        for (CssFontSize c: CssFontSize.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
