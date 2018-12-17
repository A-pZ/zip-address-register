package com.github.apz.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;
import org.supercsv.prefs.CsvPreference;

import com.github.apz.model.Address;
import com.github.mygreen.supercsv.builder.BeanMappingFactory;
import com.github.mygreen.supercsv.builder.SpringBeanFactory;
import com.github.mygreen.supercsv.io.CsvAnnotationBeanReader;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CSVReadRepository {
	private final SpringBeanFactory csvBeanFactory;
	private final ResourceLoader resourceLoader;

	public List<Address> read(String pathString) throws IOException {
		return read(getCsv(pathString));
	}

	public List<Address> read(InputStream is) throws IOException {
		BeanMappingFactory beanMappingFactory = new BeanMappingFactory();
        beanMappingFactory.getConfiguration().setBeanFactory(csvBeanFactory);

        BufferedReader bufferedReader =
				new BufferedReader(new InputStreamReader(is, Charset.forName("Windows-31J")));

        CsvAnnotationBeanReader<Address> csvReader = new CsvAnnotationBeanReader<> (
				Address.class,
				bufferedReader,
				CsvPreference.STANDARD_PREFERENCE
				);

		List<Address> result = csvReader.readAll();

		csvReader.close();

		return result;
	}

	private InputStream getCsv(String pathString) throws IOException {
		Resource resource = resourceLoader.getResource("classpath:" + pathString);
		return resource.getInputStream();
	}

}
