//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.10 at 10:30:36 AM CEST 
//

package com.nyx.mower.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for move.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="move">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="D"/>
 *     &lt;enumeration value="G"/>
 *     &lt;enumeration value="A"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "move")
@XmlEnum
public enum Move {

    D {
        @Override
        public Location move(Location location) {

            location.setOrientation(location.orientation.next());

            return location;
        }
    },
    G {
        @Override
        public Location move(Location location) {

            location.setOrientation(location.orientation.previous());

            return location;
        }
    },
    A {
        @Override
        public Location move(Location location) {

            location.setCoordinate(location.orientation.move(location.coordinate));

            return location;
        }
    };

    public String value() {
        return name();
    }

    public static Move fromValue(String v) {
        return valueOf(v);
    }

    public abstract Location move(Location location);

}
