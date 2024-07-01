package com.one.challenge.literalura.repository;

import com.one.challenge.literalura.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IBookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByLanguage(String language);
}
