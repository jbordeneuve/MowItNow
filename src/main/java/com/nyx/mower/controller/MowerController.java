package com.nyx.mower.controller;

import com.nyx.mower.model.Gardener;
import com.nyx.mower.model.Lawn;

import java.util.List;

public final class MowerController {

    private Lawn lawn;

    private List<Gardener> gardener;

    public MowerController() {
    }

    public MowerController(final Lawn lawn, final List<Gardener> gardeners) {
        this.lawn = lawn;
        this.gardener = gardeners;
    }

    public Lawn getLawn() {
        return lawn;
    }

    public void setLawn(Lawn lawn) {
        this.lawn = lawn;
    }

    public List<Gardener> getGardener() {
        return gardener;
    }

    public void setGardener(List<Gardener> gardener) {
        this.gardener = gardener;
    }

    public void run() {○

        gardener.stream().forEach(ite ->
                {
                    ite.getPath().stream().allMatch(path -> {

                        if (this.getLawn().isStillOnField(ite.getMower().getLocation())) {
                            path.move(ite.getMower());

                            return true;
                        }

                        return false;
                    });
                }
        );
    }
}
