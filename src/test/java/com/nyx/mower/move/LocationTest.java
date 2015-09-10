package com.nyx.mower.move;

import static com.nyx.mower.model.Move.D;
import static com.nyx.mower.model.Move.G;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import com.nyx.mower.model.Location;
import com.nyx.mower.model.Orientation;

public class LocationTest {

    @Test
    public void should_orientied_on_north_after_turn_right() {

        final Location location = new Location();
        location.setOrientation(Orientation.W);

        assertThat(D.move(location).getOrientation()).isEqualTo(Orientation.N);
    }

    @Test
    public void should_orientied_on_east_after_turn_right() {

        final Location location = new Location();
        location.setOrientation(Orientation.N);

        assertThat(D.move(location).getOrientation()).isEqualTo(Orientation.E);
    }

    @Test
    public void should_orientied_on_south_after_turn_right() {

        final Location location = new Location();
        location.setOrientation(Orientation.E);

        assertThat(D.move(location).getOrientation()).isEqualTo(Orientation.S);
    }

    @Test
    public void should_orientied_on_west_after_turn_right() {

        final Location location = new Location();
        location.setOrientation(Orientation.S);

        assertThat(D.move(location).getOrientation()).isEqualTo(Orientation.W);
    }

    @Test
    public void should_orientied_on_north_after_turn_left() {

        final Location location = new Location();
        location.setOrientation(Orientation.E);

        assertThat(G.move(location).getOrientation()).isEqualTo(Orientation.N);
    }

    @Test
    public void should_orientied_on_east_after_turn_left() {

        final Location location = new Location();
        location.setOrientation(Orientation.S);

        assertThat(G.move(location).getOrientation()).isEqualTo(Orientation.E);
    }

    @Test
    public void should_orientied_on_south_after_turn_left() {

        final Location location = new Location();
        location.setOrientation(Orientation.W);

        assertThat(G.move(location).getOrientation()).isEqualTo(Orientation.S);
    }

    @Test
    public void should_orientied_on_west_after_turn_left() {

        final Location location = new Location();
        location.setOrientation(Orientation.N);

        assertThat(G.move(location).getOrientation()).isEqualTo(Orientation.W);
    }
}