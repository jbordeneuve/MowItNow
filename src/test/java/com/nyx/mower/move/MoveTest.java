package com.nyx.mower.move;

import com.nyx.mower.controller.MowerController;
import com.nyx.mower.model.Location;
import com.nyx.mower.model.Mowitnow;
import com.nyx.mower.model.Orientation;
import com.nyx.mower.service.XmlTransformationService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MoveTest {

    private MowerController mowerController;

    @InjectMocks
    private XmlTransformationService xmlTransformationService;

    @Before
    public void init() throws Exception {
        mowerController = new MowerController();
    }

    @After
    public void destroy() throws Exception {
        mowerController = null;
    }

    @Test
    public void should_mowers_reach_at_destination() {
        final Mowitnow mowitnow = xmlTransformationService.extractData(getClass().getResourceAsStream("/files/valid.xml"));

        mowerController.setLawn(mowitnow.getLawn());
        mowerController.setMowers(mowitnow.getMower());

        mowerController.run();

        Location firstMoweLocation = mowerController.getMowers().get(0).getLocation();
        Location secondMoweLocation = mowerController.getMowers().get(1).getLocation();

        assertThat(firstMoweLocation.getX()).isEqualTo(1);
        assertThat(firstMoweLocation.getY()).isEqualTo(3);
        assertThat(firstMoweLocation.getOrientation()).isEqualTo(Orientation.N);

        assertThat(secondMoweLocation.getX()).isEqualTo(5);
        assertThat(secondMoweLocation.getY()).isEqualTo(1);
        assertThat(secondMoweLocation.getOrientation()).isEqualTo(Orientation.E);
    }
}
