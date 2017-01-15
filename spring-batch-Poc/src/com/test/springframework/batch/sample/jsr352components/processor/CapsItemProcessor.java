package com.test.springframework.batch.sample.jsr352components.processor;

import javax.batch.api.chunk.ItemProcessor;

import com.test.springframework.batch.sample.Person;
import com.test.springframework.batch.sample.PersonItemProcessor;

public class CapsItemProcessor implements ItemProcessor {

    @Override
    public Object processItem(Object item) throws Exception {
        return new PersonItemProcessor().process((Person) item);
    }
}
