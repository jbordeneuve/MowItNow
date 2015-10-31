package com.nyx.mower.move;

import com.nyx.mower.model.Orientation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static com.nyx.mower.model.Orientation.*;
import static org.fest.assertions.Assertions.assertThat;

@RunWith(Parameterized.class)
public class OrientationTest {

    private final Orientation start;

    private final Orientation end;

    private final boolean turnToRight;

    public OrientationTest(Orientation start, Orientation end, boolean turnToRight) {
        this.start = start;
        this.end = end;
        this.turnToRight = turnToRight;
    }

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = {
                {N, E, true}, {E, S, true}, {S, W, true}, {W, N, true},
                {N, W, false}, {W, S, false}, {S, E, false}, {E, N, false}
        };

        return Arrays.asList(data);
    }

    @Test
    public void should_find_good_orientation() {

        if (turnToRight) {
            assertThat(this.start.turnToRight()).isEqualTo(this.end);
        } else {
            assertThat(this.start.turnToLeft()).isEqualTo(this.end);
        }
    }
}
