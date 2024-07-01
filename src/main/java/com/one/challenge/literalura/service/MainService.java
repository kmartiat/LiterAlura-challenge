package com.one.challenge.literalura.service;

import com.one.challenge.literalura.domain.*;
import com.one.challenge.literalura.dto.AuthorDTO;
import com.one.challenge.literalura.dto.BookDTO;
import com.one.challenge.literalura.repository.IAuthorRepository;
import com.one.challenge.literalura.repository.IBookRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static com.one.challenge.literalura.utils.Literals.*;

public class MainService {
    private Scanner scanner = new Scanner(System.in);
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
            Author author;

            Optional<Author> authorOptional = authorRepository.findByName(authorData.name());
            if (authorOptional.isEmpty()) {
                author = new Author(authorData);
                authorRepository.save(author);
            } else {
                author = authorOptional.get();
            }

            Book book = new Book(data, author);
            bookRepository.save(book);

            System.out.println(new BookDTO(book));
            System.out.println("successfully registered book");
        }
    }

    public void listRegisteredBooks() {
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            System.out.println(EMPTY_LIST_BOOKS);
        } else {
            books.stream().forEach(b -> System.out.println(new BookDTO(b)));
        }
    }

    public void listRegisteredAuthors() {
        List<Author> authors = authorRepository.findAll();
        if (authors.isEmpty()) {
            System.out.println(EMPTY_LIST_AUTHORS);
        } else {
            authors.stream().forEach(a -> System.out.println(new AuthorDTO(a)));
        }
    }
}

