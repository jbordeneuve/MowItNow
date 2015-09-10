package com.nyx.mower.utils;

import com.beust.jcommander.Parameter;
import com.nyx.mower.converter.InstructionConverter;
import com.nyx.mower.model.Mowitnow;

public class Setting {
	@Parameter(names = "-file", description = "Input file path", converter = InstructionConverter.class)
	public Mowitnow mowitnow;
	
    @Parameter(names = "-help", help = true)
	public boolean help;
}
