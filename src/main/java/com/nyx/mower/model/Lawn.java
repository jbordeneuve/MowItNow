package com.nyx.mower.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lawn complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="lawn">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attGroup ref="{}size"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lawn")
public class Lawn {

    @XmlAttribute(name = "length")
    protected Integer length;

    @XmlAttribute(name = "width")
    protected Integer width;

    /**
     * Gets the value of the length property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setLength(Integer value) {
        this.length = value;
    }

    /**
     * Gets the value of the width property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setWidth(Integer value) {
        this.width = value;
    }

    /**
     * @param location allowed object is
     *                 {@link Location }
     */
    public boolean isStillOnField(Location location) {
        final int x = location.getX();
        final int y = location.getY();

        return 0 <= x && x <= this.getLength() && 0 <= y && y <= this.getWidth();
    }
}
