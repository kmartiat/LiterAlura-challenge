package com.one.challenge.literalura.dto;

import com.one.challenge.literalura.domain.Author;
import com.one.challenge.literalura.domain.Book;

public record AuthorDTO(Author author) {

    private String getBooks() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < author.getBooks().size(); i++) {
            result.append(author.getBooks().get(i).getTitle());
            if (i != author.getBooks().size() - 1) {
                result.append(", ");
            }
        }


        return result + "]";
    }

    @Override
    public String toString() {
        return """
                ********** Author **********
                Name: %s
                Birth Year: %d
                Death Year: %d
                Books: %s
                **************************
                """.formatted(author.getName(), author.getBirthYear(),
                author.getDeathYear(), this.getBooks());
    }
}