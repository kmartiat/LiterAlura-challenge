package com.one.challenge.literalura.service;

import com.one.challenge.literalura.domain.*;

public class MainService {
    private String BASE_URL = "https://gutendex.com/books/?search=pride";
    private ConvertService convertService = new ConvertService();

    public void searchBooksByTitle() {
        ApiConnector connector = new ApiConnector();
        String jsonSource = connector.connector(BASE_URL);

        ResultData resultData = convertService.convert(jsonSource, ResultData.class);
        BookData data = resultData.results().get(0);
        AuthorData authorData = resultData.results().get(0).authors().get(0);
        Author author = new Author(authorData);
        System.out.println(author);
        Book book = new Book(data, author);
        System.out.println(book);
    }
}
