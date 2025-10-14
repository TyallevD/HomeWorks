package com.example.homework13.services.impl;

import com.example.homework13.entities.Book;
import com.example.homework13.repositories.BookRepository;
import com.example.homework13.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Book createBook(Book book) {
        if (book.getTitle() != null) {
            return bookRepository.save(book);
        }
        return null;
    }

    public ResponseEntity<Book> updateBook(Long id, Book book) {
        return bookRepository.findById(id)
                .map(exist -> {
                    if (book.getTitle() != null) {
                        exist.setTitle(book.getTitle());
                    }
                    if (book.getAuthor() != null) {
                        exist.setAuthor(book.getAuthor());
                    }
                    if (book.getIsbn() != 0) {
                        exist.setIsbn(book.getIsbn());
                    }
                    if (book.getPrice() > 0) {
                        exist.setPrice(book.getPrice());
                    }
                    if (book.getPublishedYear() > 1900) {
                        exist.setPublishedYear(book.getPublishedYear());
                    }
                    return ResponseEntity.ok(bookRepository.save(exist));
                }).orElse(ResponseEntity.status(400).build());
    }

    public void deleteById(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Книга с id " + id + " уже удалена или не существует");
        }
        bookRepository.deleteById(id);
    }

}
