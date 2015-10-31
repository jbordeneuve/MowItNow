package com.nyx.mower.move;

import com.nyx.mower.model.Lawn;
import com.nyx.mower.model.Location;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(Parameterized.class)
public class LawnTest {

    private final Location location;
    private final boolean isStillOnField;
    private Lawn lawn;

    public LawnTest(Integer x, Integer y, Boolean isStillOnField) {
        this.location = new Location();
        this.location.setX(x);
        this.location.setY(y);

        this.isStillOnField = isStillOnField;
    }

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = {
                {0, 0, true}, {0, 1, true}, {0, 2, true}, {0, 3, true},
                {0, 4, true}, {1, 0, true}, {1, 1, true}, {1, 2, true},
                {1, 3, true}, {1, 4, true}, {2, 0, true}, {2, 1, true},
                {2, 2, true}, {2, 3, true}, {2, 4, true}, {3, 0, true},
                {3, 1, true}, {3, 2, true}, {3, 3, true}, {3, 4, true},
                {4, 0, true}, {4, 1, true}, {4, 2, true}, {4, 3, true},
                {4, 4, true}, {-1, -1, false}, {1, 5, false}, {5, 1, false},
                {5, 5, false}
        };

        return Arrays.asList(data);
    }

    @Before
    public void init() throws Exception {
        this.lawn = new Lawn();
        lawn.setLength(4);
        lawn.setWidth(4);
    }

    @After
    public void destroy() throws Exception {
        this.lawn = null;
    }

    @Test
    public void should_still_on_the_field() {
        assertThat(lawn.isStillOnField(location)).isEqualTo(isStillOnField);
    }
}
