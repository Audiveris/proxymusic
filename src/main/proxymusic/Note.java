
package proxymusic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <B>[JAXB: simplified definition]</B><BR/>Notes are the most common type of MusicXML data. The MusicXML format keeps the MuseData distinction between elements used for sound information and elements used for notation information (e.g., tie is used for sound, tied for notation). Thus grace notes do not have a duration element. Cue notes have a duration element, as do forward elements, but no tie elements. Having these two types of information available can make interchange considerably easier, as some programs handle one type of information much more readily than the other. 
 * 	
 * The dynamics and end-dynamics attributes correspond to MIDI 1.0's Note On and Note Off velocities, respectively. They are expressed in terms of percentages of the default forte value (90 for MIDI 1.0). The attack and release attributes are used to alter the staring and stopping time of the note from when it would otherwise occur based on the flow of durations - information that is specific to a performance. They are expressed in terms of divisions, either positive or negative. A note that starts a tie should not have a release attribute, and a note that stops a tie should not have an attack attribute. If a note is played only one time through a repeat, the time-only attribute shows which time to play the note. The pizzicato attribute is used when just this note is sounded pizzicato, vs. the pizzicato element which changes overall playback between pizzicato and arco.
 * 
 * <p>Java class for note complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="note">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;sequence>
 *           &lt;element name="grace" type="{}grace" minOccurs="0"/>
 *           &lt;element name="cue" type="{}empty" minOccurs="0"/>
 *           &lt;group ref="{}full-note"/>
 *           &lt;group ref="{}duration" minOccurs="0"/>
 *           &lt;element name="tie" type="{}tie" maxOccurs="2" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;element name="instrument" type="{}instrument" minOccurs="0"/>
 *         &lt;group ref="{}editorial-voice"/>
 *         &lt;element name="type" type="{}note-type" minOccurs="0"/>
 *         &lt;element name="dot" type="{}empty-placement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="accidental" type="{}accidental" minOccurs="0"/>
 *         &lt;element name="time-modification" type="{}time-modification" minOccurs="0"/>
 *         &lt;element name="stem" type="{}stem" minOccurs="0"/>
 *         &lt;element name="notehead" type="{}notehead" minOccurs="0"/>
 *         &lt;group ref="{}staff" minOccurs="0"/>
 *         &lt;element name="beam" type="{}beam" maxOccurs="6" minOccurs="0"/>
 *         &lt;element name="notations" type="{}notations" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lyric" type="{}lyric" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}color"/>
 *       &lt;attGroup ref="{}font"/>
 *       &lt;attGroup ref="{}x-position"/>
 *       &lt;attGroup ref="{}printout"/>
 *       &lt;attribute name="dynamics" type="{}non-negative-decimal" />
 *       &lt;attribute name="end-dynamics" type="{}non-negative-decimal" />
 *       &lt;attribute name="attack" type="{}divisions" />
 *       &lt;attribute name="release" type="{}divisions" />
 *       &lt;attribute name="time-only" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="pizzicato" type="{}yes-no" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "note", propOrder = {
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
public class Note {

    protected Grace grace;
    protected Empty cue;
    protected Empty chord;
    protected Pitch pitch;
    protected DisplayStepOctave unpitched;
    protected DisplayStepOctave rest;
    protected BigDecimal duration;
    protected List<Tie> tie;
    protected Instrument instrument;
    protected FormattedText footnote;
    protected Level level;
    protected java.lang.String voice;
    protected NoteType type;
    protected List<EmptyPlacement> dot;
    protected Accidental accidental;
    @XmlElement(name = "time-modification")
    protected TimeModification timeModification;
    protected Stem stem;
    protected Notehead notehead;
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger staff;
    protected List<Beam> beam;
    protected List<Notations> notations;
    protected List<Lyric> lyric;
    @XmlAttribute
    protected BigDecimal dynamics;
    @XmlAttribute(name = "end-dynamics")
    protected BigDecimal endDynamics;
    @XmlAttribute
    protected BigDecimal attack;
    @XmlAttribute
    protected BigDecimal release;
    @XmlAttribute(name = "time-only")
    protected java.lang.String timeOnly;
    @XmlAttribute
    protected YesNo pizzicato;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String color;
    @XmlAttribute(name = "font-family")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String fontFamily;
    @XmlAttribute(name = "font-style")
    protected FontStyle fontStyle;
    @XmlAttribute(name = "font-size")
    protected java.lang.String fontSize;
    @XmlAttribute(name = "font-weight")
    protected FontWeight fontWeight;
    @XmlAttribute(name = "default-x")
    protected BigDecimal defaultX;
    @XmlAttribute(name = "default-y")
    protected BigDecimal defaultY;
    @XmlAttribute(name = "relative-x")
    protected BigDecimal relativeX;
    @XmlAttribute(name = "relative-y")
    protected BigDecimal relativeY;
    @XmlAttribute(name = "print-dot")
    protected YesNo printDot;
    @XmlAttribute(name = "print-lyric")
    protected YesNo printLyric;
    @XmlAttribute(name = "print-object")
    protected YesNo printObject;
    @XmlAttribute(name = "print-spacing")
    protected YesNo printSpacing;

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
     *     {@link Empty }
     *     
     */
    public Empty getCue() {
        return cue;
    }

    /**
     * Sets the value of the cue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setCue(Empty value) {
        this.cue = value;
    }

    /**
     * Gets the value of the chord property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getChord() {
        return chord;
    }

    /**
     * Sets the value of the chord property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setChord(Empty value) {
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
     *     {@link DisplayStepOctave }
     *     
     */
    public DisplayStepOctave getUnpitched() {
        return unpitched;
    }

    /**
     * Sets the value of the unpitched property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayStepOctave }
     *     
     */
    public void setUnpitched(DisplayStepOctave value) {
        this.unpitched = value;
    }

    /**
     * Gets the value of the rest property.
     * 
     * @return
     *     possible object is
     *     {@link DisplayStepOctave }
     *     
     */
    public DisplayStepOctave getRest() {
        return rest;
    }

    /**
     * Sets the value of the rest property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayStepOctave }
     *     
     */
    public void setRest(DisplayStepOctave value) {
        this.rest = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDuration(BigDecimal value) {
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
     *     {@link FormattedText }
     *     
     */
    public FormattedText getFootnote() {
        return footnote;
    }

    /**
     * Sets the value of the footnote property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormattedText }
     *     
     */
    public void setFootnote(FormattedText value) {
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
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getVoice() {
        return voice;
    }

    /**
     * Sets the value of the voice property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setVoice(java.lang.String value) {
        this.voice = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link NoteType }
     *     
     */
    public NoteType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoteType }
     *     
     */
    public void setType(NoteType value) {
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
     * {@link EmptyPlacement }
     * 
     * 
     */
    public List<EmptyPlacement> getDot() {
        if (dot == null) {
            dot = new ArrayList<EmptyPlacement>();
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
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStaff() {
        return staff;
    }

    /**
     * Sets the value of the staff property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStaff(BigInteger value) {
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
     * Gets the value of the dynamics property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDynamics() {
        return dynamics;
    }

    /**
     * Sets the value of the dynamics property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDynamics(BigDecimal value) {
        this.dynamics = value;
    }

    /**
     * Gets the value of the endDynamics property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEndDynamics() {
        return endDynamics;
    }

    /**
     * Sets the value of the endDynamics property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEndDynamics(BigDecimal value) {
        this.endDynamics = value;
    }

    /**
     * Gets the value of the attack property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAttack() {
        return attack;
    }

    /**
     * Sets the value of the attack property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAttack(BigDecimal value) {
        this.attack = value;
    }

    /**
     * Gets the value of the release property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRelease() {
        return release;
    }

    /**
     * Sets the value of the release property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRelease(BigDecimal value) {
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
     * Gets the value of the pizzicato property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getPizzicato() {
        return pizzicato;
    }

    /**
     * Sets the value of the pizzicato property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setPizzicato(YesNo value) {
        this.pizzicato = value;
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
     * Gets the value of the fontStyle property.
     * 
     * @return
     *     possible object is
     *     {@link FontStyle }
     *     
     */
    public FontStyle getFontStyle() {
        return fontStyle;
    }

    /**
     * Sets the value of the fontStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link FontStyle }
     *     
     */
    public void setFontStyle(FontStyle value) {
        this.fontStyle = value;
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
     * Gets the value of the fontWeight property.
     * 
     * @return
     *     possible object is
     *     {@link FontWeight }
     *     
     */
    public FontWeight getFontWeight() {
        return fontWeight;
    }

    /**
     * Sets the value of the fontWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link FontWeight }
     *     
     */
    public void setFontWeight(FontWeight value) {
        this.fontWeight = value;
    }

    /**
     * Gets the value of the defaultX property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDefaultX() {
        return defaultX;
    }

    /**
     * Sets the value of the defaultX property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDefaultX(BigDecimal value) {
        this.defaultX = value;
    }

    /**
     * Gets the value of the defaultY property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDefaultY() {
        return defaultY;
    }

    /**
     * Sets the value of the defaultY property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDefaultY(BigDecimal value) {
        this.defaultY = value;
    }

    /**
     * Gets the value of the relativeX property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRelativeX() {
        return relativeX;
    }

    /**
     * Sets the value of the relativeX property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRelativeX(BigDecimal value) {
        this.relativeX = value;
    }

    /**
     * Gets the value of the relativeY property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRelativeY() {
        return relativeY;
    }

    /**
     * Sets the value of the relativeY property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRelativeY(BigDecimal value) {
        this.relativeY = value;
    }

    /**
     * Gets the value of the printDot property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getPrintDot() {
        return printDot;
    }

    /**
     * Sets the value of the printDot property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setPrintDot(YesNo value) {
        this.printDot = value;
    }

    /**
     * Gets the value of the printLyric property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getPrintLyric() {
        return printLyric;
    }

    /**
     * Sets the value of the printLyric property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setPrintLyric(YesNo value) {
        this.printLyric = value;
    }

    /**
     * Gets the value of the printObject property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getPrintObject() {
        return printObject;
    }

    /**
     * Sets the value of the printObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setPrintObject(YesNo value) {
        this.printObject = value;
    }

    /**
     * Gets the value of the printSpacing property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getPrintSpacing() {
        return printSpacing;
    }

    /**
     * Sets the value of the printSpacing property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setPrintSpacing(YesNo value) {
        this.printSpacing = value;
    }

}
