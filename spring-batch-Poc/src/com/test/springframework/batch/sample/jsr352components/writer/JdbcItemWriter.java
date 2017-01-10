package com.test.springframework.batch.sample.jsr352components.writer;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.springframework.batch.sample.Person;


public class JdbcItemWriter extends AbstractItemWriter {

    private static final String SQL = "INSERT INTO PEOPLE VALUES(NULL, ?, ?)";

    @Autowired
    private DataSource dataSource;
    private Connection connection;
    private PreparedStatement preparedStatement;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        connection = dataSource.getConnection();
        preparedStatement = connection.prepareStatement(SQL);
    }

    @Override
    public void close() throws Exception {
        if(preparedStatement != null) {
            preparedStatement.close();
        }

        if(connection != null) {
            connection.close();
        }
    }

    @Override
    public void writeItems(List<Object> items) throws Exception {
        for (Object item : items) {
            Person person = (Person) item;
            System.out.printf("writing person %s", person);

            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());

            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();
    }
}