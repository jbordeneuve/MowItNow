package com.nyx.mower.controller;

import com.nyx.mower.model.Lawn;
import com.nyx.mower.model.Mower;

import java.util.List;

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

    public void setLawn(Lawn lawn) {
        this.lawn = lawn;
    }

    public List<Mower> getMowers() {
        return mowers;
    }

    public void setMowers(List<Mower> mowers) {
        this.mowers = mowers;
    }

    public void run() {

        mowers.stream().forEach(ite -> ite.getPath().stream().allMatch(path -> {

            if (this.getLawn().isStillOnField(ite.getLocation())) {
                path.move(ite);

                return true;
            }

            return false;
        }));
    }

}
