package com.nyx.mower.move;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.nyx.mower.controller.MowerController;
import com.nyx.mower.model.Coordinate;
import com.nyx.mower.model.Lawn;
import com.nyx.mower.model.Location;

@RunWith(Parameterized.class)
public class LawnTest {

	private MowerController mowerController;

	private Location location;
	
	private boolean isStillOnField;

	public LawnTest( Integer x,  Integer y,  Boolean isStillOnField) {
		this.location = new Location();
		this.location.setCoordinate(new Coordinate());
		
		location.getCoordinate().setX(x);
		location.getCoordinate().setY(y);

		this.isStillOnField = isStillOnField;
	}

	@Before
	public void init() throws Exception {
		mowerController = new MowerController();
		
		final Lawn lawn = new Lawn();
		lawn.setLength(4);
		lawn.setWidth(4);

		mowerController.setLawn(lawn);
	}

	@After
	public void destroy() throws Exception {
		mowerController = null;
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = { { 0, 0, true }, { 0, 1, true }, { 0, 2, true },
				{ 0, 3, true }, { 0, 4, true }, { 1, 0, true }, { 1, 1, true },
				{ 1, 2, true }, { 1, 3, true }, { 1, 4, true }, { 2, 0, true },
				{ 2, 1, true }, { 2, 2, true }, { 2, 3, true }, { 2, 4, true },
				{ 3, 0, true }, { 3, 1, true }, { 3, 2, true }, { 3, 3, true },
				{ 3, 4, true }, { 4, 0, true }, { 4, 1, true }, { 4, 2, true },
				{ 4, 3, true }, { 4, 4, true }, { -1, -1, false },
				{ 1, 5, false }, { 5, 1, false }, { 5, 5, false }, };
		
		return Arrays.asList(data);
	}

	@Test
	public void should_still_on_the_field() {
		assertThat(mowerController.isStillOnField(location)).isEqualTo(
				isStillOnField);
	}
}
