package com.one.challenge.literalura.repository;

import com.one.challenge.literalura.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
