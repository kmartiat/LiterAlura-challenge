package com.one.challenge.literalura.repository;

import com.one.challenge.literalura.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<Author, Long> {
}
