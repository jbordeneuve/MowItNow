package com.nyx.mower.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;
import java.util.List;

@XmlType(name = "orientation")
@XmlEnum
public enum Orientation {

    N(0, 1),
    E(1, 0),
    S(0, -1),
    W(-1, 0);

    private static final List<Orientation> ORIENTATIONS = Arrays.asList(Orientation.values());

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
        int idx = ORIENTATIONS.indexOf(this);
        return (idx < 0 || idx + 1 == ORIENTATIONS.size()) ? ORIENTATIONS.get(0) : ORIENTATIONS.get(idx + 1);
    }

    public Orientation turnToLeft() {
        int idx = ORIENTATIONS.indexOf(this);
        return (idx <= 0) ? ORIENTATIONS.get(ORIENTATIONS.size() - 1) : ORIENTATIONS.get(idx - 1);
    }

}
