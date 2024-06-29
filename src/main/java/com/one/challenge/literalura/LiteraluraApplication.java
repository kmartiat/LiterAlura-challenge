package com.one.challenge.literalura;

import com.one.challenge.literalura.controller.MainController;
import com.one.challenge.literalura.repository.IAuthorRepository;
import com.one.challenge.literalura.repository.IBookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

    private IBookRepository bookRepository;
    private IAuthorRepository authorRepository;

    public LiteraluraApplication(IBookRepository bookRepository, IAuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(LiteraluraApplication.class, args);
    }

    @Override
    public void run(String... args) {
        MainController mainController = new MainController(bookRepository, authorRepository);
        mainController.showMenu();
    }
}
