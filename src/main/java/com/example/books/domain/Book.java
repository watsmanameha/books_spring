package com.example.books.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "title is required")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "author is required")
    @Column(nullable = false)
    private String author;

    @Column(name = "published_year")
    private Integer publishedYear;

    @Column(length = 4000)
    private String description;

    public Book() {}

    public Book(String title, String author, Integer publishedYear, String description) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public Integer getPublishedYear() { return publishedYear; }
    public void setPublishedYear(Integer publishedYear) { this.publishedYear = publishedYear; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
