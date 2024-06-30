package com.one.challenge.literalura.repository;

import com.one.challenge.literalura.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByName(String name);
}
