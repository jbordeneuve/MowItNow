package com.xebia.mower.move;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.xebia.mower.controller.MowerController;
import com.xebia.mower.model.Location;
import com.xebia.mower.model.Orientation;

public class LocationTest {

	private MowerController mowerController;

	@Before
	public void init() throws Exception {
		mowerController = new MowerController();
	}

	@After
	public void destroy() throws Exception {
		mowerController = null;
	}
	
	@Test
	public void should_orientied_on_north_after_turn_right() {

		final Location location = new Location();
		location.setOrientation(Orientation.W);

		assertThat(
				mowerController.computeLocation('D', location).getOrientation())
				.isEqualTo(Orientation.N);
	}

	@Test
	public void should_orientied_on_east_after_turn_right() {

		final Location location = new Location();
		location.setOrientation(Orientation.W);

		assertThat(
				mowerController.computeLocation('D', location).getOrientation())
				.isEqualTo(Orientation.N);
	}

	@Test
	public void should_orientied_on_south_after_turn_right() {

		final Location location = new Location();
		location.setOrientation(Orientation.E);

		assertThat(
				mowerController.computeLocation('D', location).getOrientation())
				.isEqualTo(Orientation.S);
	}

	@Test
	public void should_orientied_on_west_after_turn_right() {

		final Location location = new Location();
		location.setOrientation(Orientation.S);

		assertThat(
				mowerController.computeLocation('D', location).getOrientation())
				.isEqualTo(Orientation.W);
	}

	@Test
	public void should_orientied_on_north_after_turn_left() {

		final Location location = new Location();
		location.setOrientation(Orientation.E);

		assertThat(
				mowerController.computeLocation('G', location).getOrientation())
				.isEqualTo(Orientation.N);
	}

	@Test
	public void should_orientied_on_east_after_turn_left() {

		final Location location = new Location();
		location.setOrientation(Orientation.S);

		assertThat(
				mowerController.computeLocation('G', location).getOrientation())
				.isEqualTo(Orientation.E);
	}

	@Test
	public void should_orientied_on_south_after_turn_left() {

		final Location location = new Location();
		location.setOrientation(Orientation.W);

		assertThat(
				mowerController.computeLocation('G', location).getOrientation())
				.isEqualTo(Orientation.S);
	}

	@Test
	public void should_orientied_on_west_after_turn_left() {

		final Location location = new Location();
		location.setOrientation(Orientation.N);

		assertThat(
				mowerController.computeLocation('G', location).getOrientation())
				.isEqualTo(Orientation.W);
	}
}