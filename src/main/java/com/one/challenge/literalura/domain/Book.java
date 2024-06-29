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

    public Book(BookData data, Author author) {
        this.title = data.title();
        this.author = author;
        this.language = data.languages().get(0);
        this.downloadCount = data.downloadCount();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", language='" + language + '\'' +
                ", downloadCount=" + downloadCount +
                '}';
    }
}
