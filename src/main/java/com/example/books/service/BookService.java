package com.example.books.service;

import com.example.books.domain.Book;
import com.example.books.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    @Transactional(readOnly = true)
    public List<Book> findAll() { return repo.findAll(); }

    @Transactional(readOnly = true)
    public Book findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    public Book create(Book book) {
        book.setId(null);
        return repo.save(book);
    }

    public Book update(Long id, Book patch) {
        Book b = findById(id);
        b.setTitle(patch.getTitle());
        b.setAuthor(patch.getAuthor());
        b.setPublishedYear(patch.getPublishedYear());
        b.setDescription(patch.getDescription());
        return repo.save(b);
    }

    public void delete(Long id) {
        Book b = findById(id);
        repo.delete(b);
    }
}
