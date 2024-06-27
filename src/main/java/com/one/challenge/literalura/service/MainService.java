package com.one.challenge.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.one.challenge.literalura.domain.ResultData;

public class MainService {
    private String BASE_URL = "https://gutendex.com/books/?search=pride";

    public void searchBooksByTitle() {
        ApiConnector connector = new ApiConnector();
        String jsonSource = connector.connector(BASE_URL);

        ObjectMapper mapper = new ObjectMapper();
        try {
            ResultData names = mapper.readValue(jsonSource, ResultData.class);
            System.out.println(names.results().get(0));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
