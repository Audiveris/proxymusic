
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * The cue and grace elements indicate the presence of
 * cue and grace notes. The slash attribute for a grace
 * note is yes for slashed eighth notes. The other grace
 * note attributes come from MuseData sound suggestions.
 * Steal-time-previous indicates the percentage of time
 * to steal from the previous note for the grace note.
 * Steal-time-following indicates the percentage of time
 * to steal from the following note for the grace note.
 * Make-time indicates to make time, not steal time; the
 * units are in real-time divisions for the grace note.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "cue")
public class Cue {


}
