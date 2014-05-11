package com.xebia.mower;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.xebia.mower.controller.MowerController;
import com.xebia.mower.model.Mowitnow;
import com.xebia.mower.utils.Setting;

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