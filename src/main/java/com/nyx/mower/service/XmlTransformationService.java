package com.nyx.mower.service;

import com.nyx.mower.exception.ParserException;
import com.nyx.mower.exception.StorageException;
import com.nyx.mower.model.Mowitnow;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;
import java.io.InputStream;

public class XmlTransformationService {

    public Mowitnow extractData(final InputStream inputStream) {
        try (final InputStream xsdStream = getClass().getResourceAsStream("/xsd/mowitnow.xsd")) {

            final JAXBContext jc = JAXBContext.newInstance(Mowitnow.class);

            final XMLInputFactory xif = XMLInputFactory.newInstance();
            final XMLStreamReader xsr = xif.createXMLStreamReader(inputStream);

            final SchemaFactory sf = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);

            final Unmarshaller unmarshaller = jc.createUnmarshaller();
            unmarshaller.setSchema(sf.newSchema(new StreamSource(xsdStream)));

            return (Mowitnow) unmarshaller.unmarshal(xsr);
        } catch (IOException e) {
            throw new StorageException("Unable to load schema file from storage", e);
        } catch (JAXBException e) {
            throw new ParserException("Instruction file parsing failed", e);
        } catch (XMLStreamException | SAXException e) {
            throw new ParserException("Instruction file failed", e);
        }
    }
}
