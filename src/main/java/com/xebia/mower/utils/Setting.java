package com.xebia.mower.utils;

import com.beust.jcommander.Parameter;
import com.xebia.mower.converter.InstructionConverter;
import com.xebia.mower.model.Mowitnow;

public class Setting {
	@Parameter(names = "-file", description = "Input file path", converter = InstructionConverter.class)
	public Mowitnow mowitnow;
	
    @Parameter(names = "-help", help = true)
	public boolean help;
}
