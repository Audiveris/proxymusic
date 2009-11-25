
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for start-note.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="start-note">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="upper"/>
 *     &lt;enumeration value="main"/>
 *     &lt;enumeration value="below"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "start-note")
@XmlEnum
public enum StartNote {

    @XmlEnumValue("upper")
    UPPER("upper"),
    @XmlEnumValue("main")
    MAIN("main"),
    @XmlEnumValue("below")
    BELOW("below");
    private final java.lang.String value;

    StartNote(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static StartNote fromValue(java.lang.String v) {
        for (StartNote c: StartNote.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
