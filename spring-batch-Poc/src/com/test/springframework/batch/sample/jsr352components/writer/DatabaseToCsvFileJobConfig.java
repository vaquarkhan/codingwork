package com.test.springframework.batch.sample.jsr352components.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import com.test.springframework.batch.sample.jsr352components.util.StringHeaderWriter;
import com.test.springframework.batch.sample.Person;
 
@Configuration
public class DatabaseToCsvFileJobConfig {
 
    @Bean
    ItemWriter<Person> databaseCsvItemWriter() {
        FlatFileItemWriter<Person> csvFileWriter = new FlatFileItemWriter<>();
 
        String exportFileHeader = "NAME;EMAIL_ADDRESS;PACKAGE";
        StringHeaderWriter headerWriter = new StringHeaderWriter(exportFileHeader);
        csvFileWriter.setHeaderCallback(headerWriter);
 
        String exportFilePath ="students.csv";
        csvFileWriter.setResource(new FileSystemResource(exportFilePath));
 
        LineAggregator<Person> lineAggregator = createStudentLineAggregator();
        csvFileWriter.setLineAggregator(lineAggregator);
 
        return csvFileWriter;
    }
 
    private LineAggregator<Person> createStudentLineAggregator() {
        DelimitedLineAggregator<Person> lineAggregator = new DelimitedLineAggregator<>();
        lineAggregator.setDelimiter(";");
 
        FieldExtractor<Person> fieldExtractor = createStudentFieldExtractor();
        lineAggregator.setFieldExtractor(fieldExtractor);
 
        return lineAggregator;
    }
 
    private FieldExtractor<Person> createStudentFieldExtractor() {
        BeanWrapperFieldExtractor<Person> extractor = new BeanWrapperFieldExtractor<>();
        extractor.setNames(new String[] {"name", "emailAddress", "purchasedPackage"});
        return extractor;
    }
}
