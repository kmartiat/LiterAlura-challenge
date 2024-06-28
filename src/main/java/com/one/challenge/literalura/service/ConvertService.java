package com.one.challenge.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertService {

    private ObjectMapper mapper = new ObjectMapper();

    public <T> T convert(String jsonSource, Class<T> t) {
        try {
            return mapper.readValue(jsonSource, t);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
