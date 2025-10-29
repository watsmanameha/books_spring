package com.example.books.web;

import com.example.books.domain.Book;
import com.example.books.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@Validated
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> getAll() {
        return service.findAll(); // 200 OK
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) {
        return service.findById(id); // 200 OK или 404 через advice
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody @Valid Book body) {
        Book saved = service.create(body);
        return ResponseEntity
                .created(URI.create("/api/books/" + saved.getId()))
                .body(saved); // 201 Created
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody @Valid Book body) {
        return service.update(id, body); // 200 OK
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id); // 204 No Content
    }
}
