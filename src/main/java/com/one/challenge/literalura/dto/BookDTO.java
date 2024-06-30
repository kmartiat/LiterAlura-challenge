package com.one.challenge.literalura.dto;

import com.one.challenge.literalura.domain.Book;

public record BookDTO(Book book) {
    @Override
    public String toString() {
        return """
                ********** Book **********
                Title: %s
                Author: %s
                Language: %s
                Number of downloads: %d
                **************************
                """.formatted(book.getTitle(), book.getAuthor().getName(),
                book.getLanguage(), book.getDownloadCount());
    }
}