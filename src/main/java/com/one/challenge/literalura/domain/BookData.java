package com.one.challenge.literalura.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(@JsonAlias("title") String title,
                       @JsonAlias("authors") List<AuthorData> authors,
                       @JsonAlias("languages") List<String> languages,
                       @JsonAlias("download_count") Integer downloadCount) {
}
