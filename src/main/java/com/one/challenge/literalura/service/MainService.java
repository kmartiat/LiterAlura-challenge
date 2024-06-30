package com.one.challenge.literalura.service;

import com.one.challenge.literalura.domain.*;
import com.one.challenge.literalura.dto.BookDTO;
import com.one.challenge.literalura.repository.IAuthorRepository;
import com.one.challenge.literalura.repository.IBookRepository;

import java.util.Optional;
import java.util.Scanner;

public class MainService {
    private Scanner scanner = new Scanner(System.in);
    private String BASE_URL = "https://gutendex.com/books/?search=";
    private ConvertService convertService = new ConvertService();
    private IBookRepository bookRepository;
    private IAuthorRepository authorRepository;

    public MainService(IBookRepository bookRepository, IAuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void searchBooksByTitle() {
        System.out.println("Enter the name of the book you want to search for: ");
        String nameBook = scanner.nextLine();

        Optional<Book> optionalBook = bookRepository.findByTitleContainingIgnoreCase(nameBook);

        if (optionalBook.isPresent()) {
            System.out.println(new BookDTO(optionalBook.get()));
        } else {
            ApiConnector connector = new ApiConnector();
            String jsonSource = connector.connector(BASE_URL + nameBook.replace(' ', '+'));

            ResultData resultData = convertService.convert(jsonSource, ResultData.class);
            BookData data = resultData.results().get(0);
            AuthorData authorData = resultData.results().get(0).authors().get(0);
            Author author = new Author(authorData);
            Book book = new Book(data, author);
            authorRepository.save(author);
            bookRepository.save(book);

            System.out.println(new BookDTO(book).toString());
            System.out.println("successfully registered book");
        }
    }
}
