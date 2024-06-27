package com.one.challenge.literalura.controller;

import com.one.challenge.literalura.service.MainService;

import java.util.Scanner;

public class MainController {
    private Scanner scanner = new Scanner(System.in);
    private MainService mainService = new MainService();

    public void showMenu() {
        Integer option = -1;
        while (option != 0) {
            String menu = """
                    1 - Search book by title
                    2 - List of registered books
                    3 - List of registered authors
                    4 - List of books by language
                    5 - List of books by language
                                        
                    0 - Exit
                    """;
            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    mainService.searchBooksByTitle();
                    break;
                case 0:
                    System.out.println("Exit from app...");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
