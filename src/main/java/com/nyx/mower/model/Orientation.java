//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.09.09 à 10:42:43 AM CEST 
//

package com.nyx.mower.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Classe Java pour orientation.
 * 
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette
 * classe.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="orientation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="N"/>
 *     &lt;enumeration value="E"/>
 *     &lt;enumeration value="S"/>
 *     &lt;enumeration value="W"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "orientation")
@XmlEnum
public enum Orientation {

    N {
        @Override
        protected Coordinate move(Coordinate coordinate) {
            coordinate.setY(coordinate.getY() + 1);
            return coordinate;
        }

        @Override
        public Orientation previous() {
            return W;
        }
    },
    E {
        @Override
        protected Coordinate move(Coordinate coordinate) {
            coordinate.setX(coordinate.getX() + 1);
            return coordinate;
        }
    },
    S {
        @Override
        protected Coordinate move(Coordinate coordinate) {
            coordinate.setY(coordinate.getY() - 1);
            return coordinate;
        }
    },
    W {
        @Override
        protected Coordinate move(Coordinate coordinate) {
            coordinate.setX(coordinate.getX() - 1);
            return coordinate;
        }
    };

    public String value() {
        return name();
    }

    public static Orientation fromValue(String v) {
        return valueOf(v);
    }

    protected abstract Coordinate move(Coordinate coordinate);

    public Orientation next() {
        return Orientation.values()[(this.ordinal() + 1) % Orientation.values().length];
    }

    public Orientation previous() {
        return Orientation.values()[(this.ordinal() - 1) % Orientation.values().length];
    }
}
