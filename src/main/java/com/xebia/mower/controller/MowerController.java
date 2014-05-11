package com.xebia.mower.controller;

import java.util.List;

import com.xebia.mower.model.Lawn;
import com.xebia.mower.model.Location;
import com.xebia.mower.model.Mower;
import com.xebia.mower.model.Orientation;

public final class MowerController {

	private Lawn lawn;

	private List<Mower> mowers;

	public MowerController() {
	}

	public MowerController(final Lawn lawn, final List<Mower> mowers) {
		this.lawn = lawn;
		this.mowers = mowers;
	}

	public Location computeLocation(final char order, final Location location) {

		final Location locationTmp = location;

		final int size = Orientation.values().length;

		final int current = locationTmp.getOrientation().ordinal();

		final int x = location.getX();

		final int y = location.getY();

		switch (order) {
		case 'D':

			if ((current + 1) >= size) {
				locationTmp.setOrientation(Orientation.N);
				break;
			}

			locationTmp.setOrientation(Orientation.values()[(current + 1)]);

			break;

		case 'G':

			if ((current - 1) < 0) {
				locationTmp.setOrientation(Orientation.W);
				break;
			}

			locationTmp.setOrientation(Orientation.values()[(current - 1)]);

			break;

		case 'A':

			switch (locationTmp.getOrientation()) {
			case N:

				locationTmp.setY(y + 1);
				break;

			case E:

				locationTmp.setX(x + 1);
				break;

			case S:

				locationTmp.setY(y - 1);
				break;

			case W:

				locationTmp.setX(x - 1);
				break;

			default:
				// Should not happen
				throw new IllegalArgumentException("Invalid orientation given");
			}

			break;
			
		default:
			// Should not happen
			throw new IllegalArgumentException("Invalid order given : " + order);
		}

		return locationTmp;
	}

	public Lawn getLawn() {
		return lawn;
	}

	public List<Mower> getMowers() {
		return mowers;
	}

	public boolean isStillOnField(Location location) {
		final int x = location.getX();
		final int y = location.getY();

		return 0 <= x && x <= lawn.getLength() && 0 <= y
				&& y <= lawn.getWidth();
	}

	public void run() {

		for (final Mower mowerIte : mowers) {

			for (final char orderIte : mowerIte.getPath().toCharArray()) {

				if (!isStillOnField(mowerIte.getLocation())) {
					break;
				}

				mowerIte.setLocation(computeLocation(orderIte,
						mowerIte.getLocation()));
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
