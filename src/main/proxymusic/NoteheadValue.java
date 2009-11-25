
package proxymusic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for notehead-value.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="notehead-value">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="slash"/>
 *     &lt;enumeration value="triangle"/>
 *     &lt;enumeration value="diamond"/>
 *     &lt;enumeration value="square"/>
 *     &lt;enumeration value="cross"/>
 *     &lt;enumeration value="x"/>
 *     &lt;enumeration value="circle-x"/>
 *     &lt;enumeration value="inverted triangle"/>
 *     &lt;enumeration value="arrow down"/>
 *     &lt;enumeration value="arrow up"/>
 *     &lt;enumeration value="slashed"/>
 *     &lt;enumeration value="back slashed"/>
 *     &lt;enumeration value="normal"/>
 *     &lt;enumeration value="cluster"/>
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="do"/>
 *     &lt;enumeration value="re"/>
 *     &lt;enumeration value="mi"/>
 *     &lt;enumeration value="fa"/>
 *     &lt;enumeration value="so"/>
 *     &lt;enumeration value="la"/>
 *     &lt;enumeration value="ti"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "notehead-value")
@XmlEnum
public enum NoteheadValue {

    @XmlEnumValue("slash")
    SLASH("slash"),
    @XmlEnumValue("triangle")
    TRIANGLE("triangle"),
    @XmlEnumValue("diamond")
    DIAMOND("diamond"),
    @XmlEnumValue("square")
    SQUARE("square"),
    @XmlEnumValue("cross")
    CROSS("cross"),
    @XmlEnumValue("x")
    X("x"),
    @XmlEnumValue("circle-x")
    CIRCLE_X("circle-x"),
    @XmlEnumValue("inverted triangle")
    INVERTED_TRIANGLE("inverted triangle"),
    @XmlEnumValue("arrow down")
    ARROW_DOWN("arrow down"),
    @XmlEnumValue("arrow up")
    ARROW_UP("arrow up"),
    @XmlEnumValue("slashed")
    SLASHED("slashed"),
    @XmlEnumValue("back slashed")
    BACK_SLASHED("back slashed"),
    @XmlEnumValue("normal")
    NORMAL("normal"),
    @XmlEnumValue("cluster")
    CLUSTER("cluster"),
    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("do")
    DO("do"),
    @XmlEnumValue("re")
    RE("re"),
    @XmlEnumValue("mi")
    MI("mi"),
    @XmlEnumValue("fa")
    FA("fa"),
    @XmlEnumValue("so")
    SO("so"),
    @XmlEnumValue("la")
    LA("la"),
    @XmlEnumValue("ti")
    TI("ti");
    private final java.lang.String value;

    NoteheadValue(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static NoteheadValue fromValue(java.lang.String v) {
        for (NoteheadValue c: NoteheadValue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
