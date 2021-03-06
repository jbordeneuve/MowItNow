package com.nyx.mower.converter;

import com.beust.jcommander.IStringConverter;
import com.nyx.mower.exception.StorageException;
import com.nyx.mower.model.Mowitnow;
import com.nyx.mower.service.XmlTransformationService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InstructionConverter implements IStringConverter<Mowitnow> {

    @Override
    public Mowitnow convert(String path) {

        try (final InputStream inputStream = new FileInputStream(path)) {
            return (new XmlTransformationService()).extractData(inputStream);
        } catch (IOException e) {
            throw new StorageException("Unable to load instruction file from this path :" + path, e);
        }
    }
}
