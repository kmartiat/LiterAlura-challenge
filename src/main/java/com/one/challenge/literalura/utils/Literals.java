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
            4 - List Authors Alive In A Given Year
            5 - Search author by name
            6 - List of books by language
            7 - The 10 most downloaded books
                                
            0 - Exit
            """;

    public static final String WELCOME = """
            ****************************************************
                       *** Welcome to LiterAlura ***""";

    public static final String INVALID_MESSAGE = "Invalid option. Please choose a valid option. \n";

    public static final String FINAL_MESSAGE = "Thank you for visiting LiterAlura.";

    public static final String BASE_URL = "https://gutendex.com/books/?search=";

    public static final String EMPTY_BOOK = "There is no book with the title '%s'.";

    public static final String EMPTY_LIST_BOOKS = "There are no books registered in the database.";

    public static final String EMPTY_LIST_AUTHORS = "There are no authors registered in the database.";

    public static final String EMPTY_AUTHOR = "There is no author in the database with the name '%s'.";
}
