package com.nyx.mower;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.nyx.mower.controller.MowerController;
import com.nyx.mower.utils.Setting;
import com.nyx.mower.model.Mowitnow;

public class App {

	public static void main(String[] args) {

		final Setting setting = new Setting();

		final JCommander jc = new JCommander(setting);

		try {
			jc.parse(args);

			final Mowitnow mowitnow = setting.mowitnow;

			final MowerController moveService = new MowerController(
					mowitnow.getLawn(), mowitnow.getMowers().getMower());

			moveService.run();
		} catch (ParameterException e) {
			jc.usage();
		}
	}
}