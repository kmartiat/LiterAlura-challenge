package com.one.challenge.literalura.repository;

import com.one.challenge.literalura.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IAuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByName(String name);

    @Query("SELECT a FROM Author a WHERE a.deathYear > ?1 AND a.birthYear < ?1")
    List<Author> findByYear(Integer year);

    Optional<Author> findByNameContainingIgnoreCase(String name);
}
