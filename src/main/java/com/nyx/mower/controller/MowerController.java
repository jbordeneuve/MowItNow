package com.nyx.mower.controller;

import java.util.List;

import com.nyx.mower.model.Lawn;
import com.nyx.mower.model.Location;
import com.nyx.mower.model.Move;
import com.nyx.mower.model.Mower;

public final class MowerController {

    private Lawn lawn;

    private List<Mower> mowers;

    public MowerController() {
    }

    public MowerController(final Lawn lawn, final List<Mower> mowers) {
        this.lawn = lawn;
        this.mowers = mowers;
    }

    public Lawn getLawn() {
        return lawn;
    }

    public List<Mower> getMowers() {
        return mowers;
    }

    public boolean isStillOnField(Location location) {
        final int x = location.getCoordinate().getX();
        final int y = location.getCoordinate().getY();

        return 0 <= x && x <= lawn.getLength() && 0 <= y && y <= lawn.getWidth();
    }

    public void run() {

        for (final Mower mowerIte : mowers) {

            for (final Move orderIte : mowerIte.getPath()) {

                if (!isStillOnField(mowerIte.getLocation())) {
                    break;
                }

                mowerIte.setLocation(orderIte.move(mowerIte.getLocation()));
            }
        }
    }

    public void setLawn(Lawn lawn) {
        this.lawn = lawn;
    }

    public void setMowers(List<Mower> mowers) {
        this.mowers = mowers;
    }
}
