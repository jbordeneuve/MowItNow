package com.nyx.mower.service;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.nyx.mower.exception.ParserException;
import com.nyx.mower.exception.StorageException;
import com.nyx.mower.model.Mowitnow;

public class XmlTransformationService {

	public Mowitnow extractData(final InputStream inputStream) {
		try (final InputStream xsdStream = getClass().getResourceAsStream(
				"/xsd/mowitnow.xsd")) {

			final JAXBContext jc = JAXBContext.newInstance(Mowitnow.class);

			final XMLInputFactory xif = XMLInputFactory.newInstance();
			final XMLStreamReader xsr = xif.createXMLStreamReader(inputStream);

			final SchemaFactory sf = SchemaFactory
					.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);

			final Schema schema = sf.newSchema(new StreamSource(xsdStream));

			final Unmarshaller unmarshaller = jc.createUnmarshaller();
			unmarshaller.setSchema(schema);

			final Mowitnow mowitnow = (Mowitnow) unmarshaller.unmarshal(xsr);

			return mowitnow;
		} catch (IOException e) {
			throw new StorageException(
					"Unable to load schema file from storage", e);
		} catch (JAXBException e) {
			throw new ParserException("Instruction file parsing failed", e);
		} catch (XMLStreamException e) {
			throw new ParserException("Instruction file failed", e);
		} catch (SAXException e) {
			throw new ParserException("Instruction file failed", e);
		}
	}
}