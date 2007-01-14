
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * Notes are the most common type of MusicXML data. MusicXML
 * keeps the MuseData distinction between elements used for
 * sound information and element used for notation
 * information (e.g., tie is used for sound, tied for
 * notation). Thus grace notes do not have a duration
 * element. Cue notes have a duration element, as do forward
 * elements, but no tie elements. Having these two types of
 * information available can make interchange considerably
 * easier, as some programs handle one type of information
 * much more readily than the other.
 * 
 * Original definition was:
 * 
 * <!ELEMENT note
 * (((grace, %full-note;, (tie, tie?)?) |
 * (cue, %full-note;, duration) |
 * (%full-note;, duration, (tie, tie?)?)),
 * instrument?, %editorial-voice;, type?, dot*,
 * accidental?, time-modification?, stem?, notehead?,
 * staff?, beam*, notations*, lyric*)>
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element ref="{}grace"/>
 *           &lt;element ref="{}cue"/>
 *         &lt;/choice>
 *         &lt;sequence>
 *           &lt;element ref="{}chord" minOccurs="0"/>
 *           &lt;choice>
 *             &lt;element ref="{}pitch"/>
 *             &lt;element ref="{}unpitched"/>
 *             &lt;element ref="{}rest"/>
 *           &lt;/choice>
 *         &lt;/sequence>
 *         &lt;element ref="{}duration"/>
 *         &lt;element ref="{}tie" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}instrument" minOccurs="0"/>
 *         &lt;sequence>
 *           &lt;element ref="{}footnote" minOccurs="0"/>
 *           &lt;element ref="{}level" minOccurs="0"/>
 *           &lt;element ref="{}voice" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;element ref="{}type" minOccurs="0"/>
 *         &lt;element ref="{}dot" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}accidental" minOccurs="0"/>
 *         &lt;element ref="{}time-modification" minOccurs="0"/>
 *         &lt;element ref="{}stem" minOccurs="0"/>
 *         &lt;element ref="{}notehead" minOccurs="0"/>
 *         &lt;element ref="{}staff" minOccurs="0"/>
 *         &lt;element ref="{}beam" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}notations" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}lyric" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}printout"/>
 *       &lt;attGroup ref="{}print-style"/>
 *       &lt;attribute name="attack" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="dynamics" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="end-dynamics" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="pizzicato">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="yes"/>
 *             &lt;enumeration value="no"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="release" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="time-only" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "grace",
    "cue",
    "chord",
    "pitch",
    "unpitched",
    "rest",
    "duration",
    "tie",
    "instrument",
    "footnote",
    "level",
    "voice",
    "type",
    "dot",
    "accidental",
    "timeModification",
    "stem",
    "notehead",
    "staff",
    "beam",
    "notations",
    "lyric"
})
@XmlRootElement(name = "note")
public class Note {

    protected Grace grace;
    protected Cue cue;
    protected Chord chord;
    protected Pitch pitch;
    protected Unpitched unpitched;
    protected Rest rest;
    @XmlElement(required = true)
    protected Duration duration;
    protected List<Tie> tie;
    protected Instrument instrument;
    protected Footnote footnote;
    protected Level level;
    protected Voice voice;
    protected Type type;
    protected List<Dot> dot;
    protected Accidental accidental;
    @XmlElement(name = "time-modification")
    protected TimeModification timeModification;
    protected Stem stem;
    protected Notehead notehead;
    protected Staff staff;
    protected List<Beam> beam;
    protected List<Notations> notations;
    protected List<Lyric> lyric;
    @XmlAttribute
    protected java.lang.String attack;
    @XmlAttribute
    protected java.lang.String dynamics;
    @XmlAttribute(name = "end-dynamics")
    protected java.lang.String endDynamics;
    @XmlAttribute
    protected java.lang.String pizzicato;
    @XmlAttribute
    protected java.lang.String release;
    @XmlAttribute(name = "time-only")
    protected java.lang.String timeOnly;
    @XmlAttribute(name = "print-dot")
    protected java.lang.String printDot;
    @XmlAttribute(name = "print-lyric")
    protected java.lang.String printLyric;
    @XmlAttribute(name = "print-spacing")
    protected java.lang.String printSpacing;
    @XmlAttribute(name = "print-object")
    protected java.lang.String printObject;
    @XmlAttribute(name = "default-x")
    protected java.lang.String defaultX;
    @XmlAttribute(name = "default-y")
    protected java.lang.String defaultY;
    @XmlAttribute(name = "relative-x")
    protected java.lang.String relativeX;
    @XmlAttribute(name = "relative-y")
    protected java.lang.String relativeY;
    @XmlAttribute(name = "font-family")
    protected java.lang.String fontFamily;
    @XmlAttribute(name = "font-size")
    protected java.lang.String fontSize;
    @XmlAttribute(name = "font-style")
    protected java.lang.String fontStyle;
    @XmlAttribute(name = "font-weight")
    protected java.lang.String fontWeight;
    @XmlAttribute
    protected java.lang.String color;

    /**
     * Gets the value of the grace property.
     * 
     * @return
     *     possible object is
     *     {@link Grace }
     *     
     */
    public Grace getGrace() {
        return grace;
    }

    /**
     * Sets the value of the grace property.
     * 
     * @param value
     *     allowed object is
     *     {@link Grace }
     *     
     */
    public void setGrace(Grace value) {
        this.grace = value;
    }

    /**
     * Gets the value of the cue property.
     * 
     * @return
     *     possible object is
     *     {@link Cue }
     *     
     */
    public Cue getCue() {
        return cue;
    }

    /**
     * Sets the value of the cue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cue }
     *     
     */
    public void setCue(Cue value) {
        this.cue = value;
    }

    /**
     * Gets the value of the chord property.
     * 
     * @return
     *     possible object is
     *     {@link Chord }
     *     
     */
    public Chord getChord() {
        return chord;
    }

    /**
     * Sets the value of the chord property.
     * 
     * @param value
     *     allowed object is
     *     {@link Chord }
     *     
     */
    public void setChord(Chord value) {
        this.chord = value;
    }

    /**
     * Gets the value of the pitch property.
     * 
     * @return
     *     possible object is
     *     {@link Pitch }
     *     
     */
    public Pitch getPitch() {
        return pitch;
    }

    /**
     * Sets the value of the pitch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pitch }
     *     
     */
    public void setPitch(Pitch value) {
        this.pitch = value;
    }

    /**
     * Gets the value of the unpitched property.
     * 
     * @return
     *     possible object is
     *     {@link Unpitched }
     *     
     */
    public Unpitched getUnpitched() {
        return unpitched;
    }

    /**
     * Sets the value of the unpitched property.
     * 
     * @param value
     *     allowed object is
     *     {@link Unpitched }
     *     
     */
    public void setUnpitched(Unpitched value) {
        this.unpitched = value;
    }

    /**
     * Gets the value of the rest property.
     * 
     * @return
     *     possible object is
     *     {@link Rest }
     *     
     */
    public Rest getRest() {
        return rest;
    }

    /**
     * Sets the value of the rest property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rest }
     *     
     */
    public void setRest(Rest value) {
        this.rest = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setDuration(Duration value) {
        this.duration = value;
    }

    /**
     * Gets the value of the tie property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tie property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTie().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Tie }
     * 
     * 
     */
    public List<Tie> getTie() {
        if (tie == null) {
            tie = new ArrayList<Tie>();
        }
        return this.tie;
    }

    /**
     * Gets the value of the instrument property.
     * 
     * @return
     *     possible object is
     *     {@link Instrument }
     *     
     */
    public Instrument getInstrument() {
        return instrument;
    }

    /**
     * Sets the value of the instrument property.
     * 
     * @param value
     *     allowed object is
     *     {@link Instrument }
     *     
     */
    public void setInstrument(Instrument value) {
        this.instrument = value;
    }

    /**
     * Gets the value of the footnote property.
     * 
     * @return
     *     possible object is
     *     {@link Footnote }
     *     
     */
    public Footnote getFootnote() {
        return footnote;
    }

    /**
     * Sets the value of the footnote property.
     * 
     * @param value
     *     allowed object is
     *     {@link Footnote }
     *     
     */
    public void setFootnote(Footnote value) {
        this.footnote = value;
    }

    /**
     * Gets the value of the level property.
     * 
     * @return
     *     possible object is
     *     {@link Level }
     *     
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     * @param value
     *     allowed object is
     *     {@link Level }
     *     
     */
    public void setLevel(Level value) {
        this.level = value;
    }

    /**
     * Gets the value of the voice property.
     * 
     * @return
     *     possible object is
     *     {@link Voice }
     *     
     */
    public Voice getVoice() {
        return voice;
    }

    /**
     * Sets the value of the voice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Voice }
     *     
     */
    public void setVoice(Voice value) {
        this.voice = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link Type }
     *     
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link Type }
     *     
     */
    public void setType(Type value) {
        this.type = value;
    }

    /**
     * Gets the value of the dot property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dot property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDot().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Dot }
     * 
     * 
     */
    public List<Dot> getDot() {
        if (dot == null) {
            dot = new ArrayList<Dot>();
        }
        return this.dot;
    }

    /**
     * Gets the value of the accidental property.
     * 
     * @return
     *     possible object is
     *     {@link Accidental }
     *     
     */
    public Accidental getAccidental() {
        return accidental;
    }

    /**
     * Sets the value of the accidental property.
     * 
     * @param value
     *     allowed object is
     *     {@link Accidental }
     *     
     */
    public void setAccidental(Accidental value) {
        this.accidental = value;
    }

    /**
     * Gets the value of the timeModification property.
     * 
     * @return
     *     possible object is
     *     {@link TimeModification }
     *     
     */
    public TimeModification getTimeModification() {
        return timeModification;
    }

    /**
     * Sets the value of the timeModification property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeModification }
     *     
     */
    public void setTimeModification(TimeModification value) {
        this.timeModification = value;
    }

    /**
     * Gets the value of the stem property.
     * 
     * @return
     *     possible object is
     *     {@link Stem }
     *     
     */
    public Stem getStem() {
        return stem;
    }

    /**
     * Sets the value of the stem property.
     * 
     * @param value
     *     allowed object is
     *     {@link Stem }
     *     
     */
    public void setStem(Stem value) {
        this.stem = value;
    }

    /**
     * Gets the value of the notehead property.
     * 
     * @return
     *     possible object is
     *     {@link Notehead }
     *     
     */
    public Notehead getNotehead() {
        return notehead;
    }

    /**
     * Sets the value of the notehead property.
     * 
     * @param value
     *     allowed object is
     *     {@link Notehead }
     *     
     */
    public void setNotehead(Notehead value) {
        this.notehead = value;
    }

    /**
     * Gets the value of the staff property.
     * 
     * @return
     *     possible object is
     *     {@link Staff }
     *     
     */
    public Staff getStaff() {
        return staff;
    }

    /**
     * Sets the value of the staff property.
     * 
     * @param value
     *     allowed object is
     *     {@link Staff }
     *     
     */
    public void setStaff(Staff value) {
        this.staff = value;
    }

    /**
     * Gets the value of the beam property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the beam property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBeam().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Beam }
     * 
     * 
     */
    public List<Beam> getBeam() {
        if (beam == null) {
            beam = new ArrayList<Beam>();
        }
        return this.beam;
    }

    /**
     * Gets the value of the notations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Notations }
     * 
     * 
     */
    public List<Notations> getNotations() {
        if (notations == null) {
            notations = new ArrayList<Notations>();
        }
        return this.notations;
    }

    /**
     * Gets the value of the lyric property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lyric property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLyric().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Lyric }
     * 
     * 
     */
    public List<Lyric> getLyric() {
        if (lyric == null) {
            lyric = new ArrayList<Lyric>();
        }
        return this.lyric;
    }

    /**
     * Gets the value of the attack property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getAttack() {
        return attack;
    }

    /**
     * Sets the value of the attack property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setAttack(java.lang.String value) {
        this.attack = value;
    }

    /**
     * Gets the value of the dynamics property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getDynamics() {
        return dynamics;
    }

    /**
     * Sets the value of the dynamics property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setDynamics(java.lang.String value) {
        this.dynamics = value;
    }

    /**
     * Gets the value of the endDynamics property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getEndDynamics() {
        return endDynamics;
    }

    /**
     * Sets the value of the endDynamics property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setEndDynamics(java.lang.String value) {
        this.endDynamics = value;
    }

    /**
     * Gets the value of the pizzicato property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPizzicato() {
        return pizzicato;
    }

    /**
     * Sets the value of the pizzicato property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPizzicato(java.lang.String value) {
        this.pizzicato = value;
    }

    /**
     * Gets the value of the release property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getRelease() {
        return release;
    }

    /**
     * Sets the value of the release property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setRelease(java.lang.String value) {
        this.release = value;
    }

    /**
     * Gets the value of the timeOnly property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getTimeOnly() {
        return timeOnly;
    }

    /**
     * Sets the value of the timeOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setTimeOnly(java.lang.String value) {
        this.timeOnly = value;
    }

    /**
     * Gets the value of the printDot property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPrintDot() {
        return printDot;
    }

    /**
     * Sets the value of the printDot property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPrintDot(java.lang.String value) {
        this.printDot = value;
    }

    /**
     * Gets the value of the printLyric property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPrintLyric() {
        return printLyric;
    }

    /**
     * Sets the value of the printLyric property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPrintLyric(java.lang.String value) {
        this.printLyric = value;
    }

    /**
     * Gets the value of the printSpacing property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPrintSpacing() {
        return printSpacing;
    }

    /**
     * Sets the value of the printSpacing property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPrintSpacing(java.lang.String value) {
        this.printSpacing = value;
    }

    /**
     * Gets the value of the printObject property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPrintObject() {
        return printObject;
    }

    /**
     * Sets the value of the printObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPrintObject(java.lang.String value) {
        this.printObject = value;
    }

    /**
     * Gets the value of the defaultX property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getDefaultX() {
        return defaultX;
    }

    /**
     * Sets the value of the defaultX property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setDefaultX(java.lang.String value) {
        this.defaultX = value;
    }

    /**
     * Gets the value of the defaultY property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getDefaultY() {
        return defaultY;
    }

    /**
     * Sets the value of the defaultY property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setDefaultY(java.lang.String value) {
        this.defaultY = value;
    }

    /**
     * Gets the value of the relativeX property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getRelativeX() {
        return relativeX;
    }

    /**
     * Sets the value of the relativeX property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setRelativeX(java.lang.String value) {
        this.relativeX = value;
    }

    /**
     * Gets the value of the relativeY property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getRelativeY() {
        return relativeY;
    }

    /**
     * Sets the value of the relativeY property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setRelativeY(java.lang.String value) {
        this.relativeY = value;
    }

    /**
     * Gets the value of the fontFamily property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getFontFamily() {
        return fontFamily;
    }

    /**
     * Sets the value of the fontFamily property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setFontFamily(java.lang.String value) {
        this.fontFamily = value;
    }

    /**
     * Gets the value of the fontSize property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getFontSize() {
        return fontSize;
    }

    /**
     * Sets the value of the fontSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setFontSize(java.lang.String value) {
        this.fontSize = value;
    }

    /**
     * Gets the value of the fontStyle property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getFontStyle() {
        return fontStyle;
    }

    /**
     * Sets the value of the fontStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setFontStyle(java.lang.String value) {
        this.fontStyle = value;
    }

    /**
     * Gets the value of the fontWeight property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getFontWeight() {
        return fontWeight;
    }

    /**
     * Sets the value of the fontWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setFontWeight(java.lang.String value) {
        this.fontWeight = value;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setColor(java.lang.String value) {
        this.color = value;
    }

}
