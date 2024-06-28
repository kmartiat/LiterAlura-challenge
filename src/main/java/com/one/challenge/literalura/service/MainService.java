package com.one.challenge.literalura.service;

import com.one.challenge.literalura.domain.Book;
import com.one.challenge.literalura.domain.BookData;
import com.one.challenge.literalura.domain.ResultData;

import java.util.List;

public class MainService {
    private String BASE_URL = "https://gutendex.com/books/?search=pride";
    private ConvertService convertService = new ConvertService();

    public void searchBooksByTitle() {
        ApiConnector connector = new ApiConnector();
        String jsonSource = connector.connector(BASE_URL);

        ResultData resultData = convertService.convert(jsonSource, ResultData.class);
        BookData data = resultData.results().get(0);
    }
}
