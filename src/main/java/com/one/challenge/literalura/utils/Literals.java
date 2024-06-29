package com.one.challenge.literalura.utils;

public class Literals {
    private Literals() {

    }

    public static final String MENU = """
            *********************************************
            Choose an option:
            1 - Search book by title
            2 - List of registered books
            3 - List of registered authors
            4 - List of books by language
            5 - List of books by language
                                
            0 - Exit
            """;

    public static final String WELCOME = """
            ****************************************************
                       *** Welcome to LiterAlura ***""";

    public static final String INVALID_MESSAGE = "Invalid option. Please choose a valid option. \n";

    public static final String FINAL_MESSAGE = "Thank you for visiting LiterAlura.";
}
