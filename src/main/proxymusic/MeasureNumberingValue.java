
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for measure-numbering-value.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="measure-numbering-value">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="measure"/>
 *     &lt;enumeration value="system"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "measure-numbering-value")
@XmlEnum
public enum MeasureNumberingValue {

    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("measure")
    MEASURE("measure"),
    @XmlEnumValue("system")
    SYSTEM("system");
    private final java.lang.String value;

    MeasureNumberingValue(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static MeasureNumberingValue fromValue(java.lang.String v) {
        for (MeasureNumberingValue c: MeasureNumberingValue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
