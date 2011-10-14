
package proxymusic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{}score-header"/>
 *         &lt;element name="measure" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="part" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;group ref="{}music-data"/>
 *                           &lt;attGroup ref="{}part-attributes"/>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attGroup ref="{}measure-attributes"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}document-attributes"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "work",
    "movementNumber",
    "movementTitle",
    "identification",
    "defaults",
    "credit",
    "partList",
    "measure"
})
@XmlRootElement(name = "score-timewise")
public class ScoreTimewise {

    protected Work work;
    @XmlElement(name = "movement-number")
    protected java.lang.String movementNumber;
    @XmlElement(name = "movement-title")
    protected java.lang.String movementTitle;
    protected Identification identification;
    protected Defaults defaults;
    protected List<Credit> credit;
    @XmlElement(name = "part-list", required = true)
    protected PartList partList;
    @XmlElement(required = true)
    protected List<ScoreTimewise.Measure> measure;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected java.lang.String version;

    /**
     * Gets the value of the work property.
     * 
     * @return
     *     possible object is
     *     {@link Work }
     *     
     */
    public Work getWork() {
        return work;
    }

    /**
     * Sets the value of the work property.
     * 
     * @param value
     *     allowed object is
     *     {@link Work }
     *     
     */
    public void setWork(Work value) {
        this.work = value;
    }

    /**
     * Gets the value of the movementNumber property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getMovementNumber() {
        return movementNumber;
    }

    /**
     * Sets the value of the movementNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setMovementNumber(java.lang.String value) {
        this.movementNumber = value;
    }

    /**
     * Gets the value of the movementTitle property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getMovementTitle() {
        return movementTitle;
    }

    /**
     * Sets the value of the movementTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setMovementTitle(java.lang.String value) {
        this.movementTitle = value;
    }

    /**
     * Gets the value of the identification property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getIdentification() {
        return identification;
    }

    /**
     * Sets the value of the identification property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setIdentification(Identification value) {
        this.identification = value;
    }

    /**
     * Gets the value of the defaults property.
     * 
     * @return
     *     possible object is
     *     {@link Defaults }
     *     
     */
    public Defaults getDefaults() {
        return defaults;
    }

    /**
     * Sets the value of the defaults property.
     * 
     * @param value
     *     allowed object is
     *     {@link Defaults }
     *     
     */
    public void setDefaults(Defaults value) {
        this.defaults = value;
    }

    /**
     * Gets the value of the credit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the credit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCredit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Credit }
     * 
     * 
     */
    public List<Credit> getCredit() {
        if (credit == null) {
            credit = new ArrayList<Credit>();
        }
        return this.credit;
    }

    /**
     * Gets the value of the partList property.
     * 
     * @return
     *     possible object is
     *     {@link PartList }
     *     
     */
    public PartList getPartList() {
        return partList;
    }

    /**
     * Sets the value of the partList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartList }
     *     
     */
    public void setPartList(PartList value) {
        this.partList = value;
    }

    /**
     * Gets the value of the measure property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the measure property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeasure().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ScoreTimewise.Measure }
     * 
     * 
     */
    public List<ScoreTimewise.Measure> getMeasure() {
        if (measure == null) {
            measure = new ArrayList<ScoreTimewise.Measure>();
        }
        return this.measure;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getVersion() {
        if (version == null) {
            return "1.0";
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setVersion(java.lang.String value) {
        this.version = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="part" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;group ref="{}music-data"/>
     *                 &lt;attGroup ref="{}part-attributes"/>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attGroup ref="{}measure-attributes"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "part"
    })
    public static class Measure {

        @XmlElement(required = true)
        protected List<ScoreTimewise.Measure.Part> part;
        @XmlAttribute(required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected java.lang.String number;
        @XmlAttribute
        protected YesNo implicit;
        @XmlAttribute(name = "non-controlling")
        protected YesNo nonControlling;
        @XmlAttribute
        protected BigDecimal width;

        /**
         * Gets the value of the part property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the part property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPart().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ScoreTimewise.Measure.Part }
         * 
         * 
         */
        public List<ScoreTimewise.Measure.Part> getPart() {
            if (part == null) {
                part = new ArrayList<ScoreTimewise.Measure.Part>();
            }
            return this.part;
        }

        /**
         * Gets the value of the number property.
         * 
         * @return
         *     possible object is
         *     {@link java.lang.String }
         *     
         */
        public java.lang.String getNumber() {
            return number;
        }

        /**
         * Sets the value of the number property.
         * 
         * @param value
         *     allowed object is
         *     {@link java.lang.String }
         *     
         */
        public void setNumber(java.lang.String value) {
            this.number = value;
        }

        /**
         * Gets the value of the implicit property.
         * 
         * @return
         *     possible object is
         *     {@link YesNo }
         *     
         */
        public YesNo getImplicit() {
            return implicit;
        }

        /**
         * Sets the value of the implicit property.
         * 
         * @param value
         *     allowed object is
         *     {@link YesNo }
         *     
         */
        public void setImplicit(YesNo value) {
            this.implicit = value;
        }

        /**
         * Gets the value of the nonControlling property.
         * 
         * @return
         *     possible object is
         *     {@link YesNo }
         *     
         */
        public YesNo getNonControlling() {
            return nonControlling;
        }

        /**
         * Sets the value of the nonControlling property.
         * 
         * @param value
         *     allowed object is
         *     {@link YesNo }
         *     
         */
        public void setNonControlling(YesNo value) {
            this.nonControlling = value;
        }

        /**
         * Gets the value of the width property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getWidth() {
            return width;
        }

        /**
         * Sets the value of the width property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setWidth(BigDecimal value) {
            this.width = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;group ref="{}music-data"/>
         *       &lt;attGroup ref="{}part-attributes"/>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "noteOrBackupOrForward"
        })
        public static class Part {

            @XmlElements({
                @XmlElement(name = "bookmark", type = Bookmark.class),
                @XmlElement(name = "note", type = Note.class),
                @XmlElement(name = "backup", type = Backup.class),
                @XmlElement(name = "grouping", type = Grouping.class),
                @XmlElement(name = "forward", type = Forward.class),
                @XmlElement(name = "direction", type = Direction.class),
                @XmlElement(name = "link", type = Link.class),
                @XmlElement(name = "figured-bass", type = FiguredBass.class),
                @XmlElement(name = "sound", type = Sound.class),
                @XmlElement(name = "print", type = Print.class),
                @XmlElement(name = "harmony", type = Harmony.class),
                @XmlElement(name = "attributes", type = Attributes.class),
                @XmlElement(name = "barline", type = Barline.class)
            })
            protected List<Object> noteOrBackupOrForward;
            @XmlAttribute(required = true)
            @XmlIDREF
            @XmlSchemaType(name = "IDREF")
            protected Object id;

            /**
             * Gets the value of the noteOrBackupOrForward property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the noteOrBackupOrForward property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getNoteOrBackupOrForward().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Bookmark }
             * {@link Note }
             * {@link Backup }
             * {@link Grouping }
             * {@link Forward }
             * {@link Direction }
             * {@link Link }
             * {@link FiguredBass }
             * {@link Sound }
             * {@link Print }
             * {@link Harmony }
             * {@link Attributes }
             * {@link Barline }
             * 
             * 
             */
            public List<Object> getNoteOrBackupOrForward() {
                if (noteOrBackupOrForward == null) {
                    noteOrBackupOrForward = new ArrayList<Object>();
                }
                return this.noteOrBackupOrForward;
            }

            /**
             * Gets the value of the id property.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getId() {
                return id;
            }

            /**
             * Sets the value of the id property.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setId(Object value) {
                this.id = value;
            }

        }

    }

}
