package com.xebia.mower.converter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.beust.jcommander.IStringConverter;
import com.xebia.mower.exception.StorageException;
import com.xebia.mower.model.Mowitnow;
import com.xebia.mower.service.XmlTransformationService;

public class InstructionConverter implements IStringConverter<Mowitnow> {

	@Override
	public Mowitnow convert(String path) {

		try (final InputStream inputStream = new FileInputStream(path)) {
			return (new XmlTransformationService()).extractData(inputStream);
		} catch (IOException e) {
			throw new StorageException(
					"Unable to load instruction file from this path :" + path, e);
		}
	}
}
