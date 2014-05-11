package com.xebia.mower.reader;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.xebia.mower.exception.ParserException;
import com.xebia.mower.model.Mowitnow;
import com.xebia.mower.service.XmlTransformationService;

@RunWith(MockitoJUnitRunner.class)
public class XmlTransformationServiceTest {

	@InjectMocks
	private XmlTransformationService xmlTransformationService;

	@Test
	public void should_convert_valid_file_instruction() {
		final Mowitnow mowitnow = xmlTransformationService
				.extractData(getClass().getResourceAsStream("/files/valid.xml"));

		assertThat(mowitnow).isNotNull();
		assertThat(mowitnow.getLawn()).isNotNull();
		assertThat(mowitnow.getMowers()).isNotNull();
	}

	@Test(expected = ParserException.class)
	public void should_throws_exception_when_converting_invalid_file_instruction() {
		xmlTransformationService.extractData(getClass().getResourceAsStream(
				"/files/invalid.xml"));
	}

	@Test(expected = ParserException.class)
	public void should_throws_exception_when_converting_null_file_instruction() {
		xmlTransformationService.extractData(null);
	}
}