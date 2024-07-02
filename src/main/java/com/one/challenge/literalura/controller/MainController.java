package com.one.challenge.literalura.controller;

import com.one.challenge.literalura.repository.IAuthorRepository;
import com.one.challenge.literalura.repository.IBookRepository;
import com.one.challenge.literalura.service.MainService;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.one.challenge.literalura.utils.Literals.*;

public class MainController {
    private Scanner scanner = new Scanner(System.in);
    private IBookRepository bookRepository;
    private IAuthorRepository authorRepository;

    public MainController(IBookRepository bookRepository, IAuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void showMenu() {
        MainService mainService = new MainService(this.bookRepository, this.authorRepository);
        Integer option = -1;
        System.out.println(WELCOME);

        while (option != 0) {
            System.out.println(MENU);

            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                option = 9;
            }
            scanner.nextLine();

            switch (option) {
                case 1 -> mainService.searchBooksByTitle();
                case 2 -> mainService.listRegisteredBooks();
                case 3 -> mainService.listRegisteredAuthors();
                case 4 -> mainService.listAuthorsAliveInAGivenYear();
                case 5 -> mainService.searchAuthorByName();
                case 6 -> mainService.listBooksByLanguage();
                case 7 -> mainService.listTop10MostDownloadedbooks();
                case 0 -> System.out.println(FINAL_MESSAGE);
                default -> System.out.println(INVALID_MESSAGE);
            }
        }
    }
}
