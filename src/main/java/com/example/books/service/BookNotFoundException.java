package com.example.books.service;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("Book not found: id=" + id);
    }
}
