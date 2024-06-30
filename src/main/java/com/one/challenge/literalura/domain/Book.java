package com.one.challenge.literalura.domain;

import jakarta.persistence.*;

@Table(name = "books")
@Entity
public class Book {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
    private String language;

    @Column(name = "download_count")
    private Integer downloadCount;

    public Book() {
    }

    public Book(BookData data, Author author) {
        this.title = data.title();
        this.author = author;
        this.language = data.languages().get(0);
        this.downloadCount = data.downloadCount();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getLanguage() {
        return language;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }
}
