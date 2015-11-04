package com.nyx.mower.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for location complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="location">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attGroup ref="{}coordinate"/>
 *       &lt;attribute name="orientation" type="{}orientation" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "location")
public class Location {

    @XmlAttribute(name = "orientation")
    protected Orientation orientation;
    @XmlAttribute(name = "x")
    protected Integer x;
    @XmlAttribute(name = "y")
    protected Integer y;

    /**
     * Gets the value of the orientation property.
     *
     * @return possible object is
     * {@link Orientation }
     */
    public Orientation getOrientation() {
        return orientation;
    }

    /**
     * Sets the value of the orientation property.
     *
     * @param value allowed object is
     *              {@link Orientation }
     */
    public void setOrientation(Orientation value) {
        this.orientation = value;
    }

    /**
     * Gets the value of the x property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getX() {
        return x;
    }

    /**
     * Sets the value of the x property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setX(Integer value) {
        this.x = value;
    }

    /**
     * Gets the value of the y property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getY() {
        return y;
    }

    /**
     * Sets the value of the y property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setY(Integer value) {
        this.y = value;
    }

}
