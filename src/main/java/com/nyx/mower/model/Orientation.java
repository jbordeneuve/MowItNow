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
 * <p>
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette
 * classe.
 * <p>
 * <p>
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
 */
@XmlType(name = "orientation")
@XmlEnum
public enum Orientation {

    N (0, 1) {
        @Override
        public Orientation turnToLeft() {
            return W;
        }
    },
    E (1, 0),
    S (0, -1),
    W (-1, 0 );

    private final int x;

    private final int y;

    Orientation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected Location move(Location location) {
        Location locBuild = new Location();
        locBuild.setX(location.getX() + x);
        locBuild.setY(location.getY() + y);
        locBuild.setOrientation(location.getOrientation());
        return locBuild;
    }

    public Orientation turnToRight() {
        return Orientation.values()[(this.ordinal() + 1) % Orientation.values().length];
    }

    public Orientation turnToLeft() {
        return Orientation.values()[(this.ordinal() - 1) % Orientation.values().length];
    }
}
