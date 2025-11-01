package com.example.homework13.services.impl;

import com.example.homework13.DTOs.BookDTO;
import com.example.homework13.entities.Book;
import com.example.homework13.repositories.BookRepository;
import com.example.homework13.services.BookService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookDTO> findAll() {

        return bookRepository.findAll()
                .stream()
                .map(BookDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookDTO> findById(Long id) {
        return bookRepository.findById(id)
                .map(BookDTO::fromEntity);
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Книга с id \"" + id + "\" не найдена"));


        if (book.getTitle() != null) {
            if (book.getTitle().trim().isEmpty()) {
                throw new IllegalArgumentException("Название книги не может быть пустым");
            }
            existingBook.setTitle(book.getTitle());
        }

        if (book.getAuthor() != null) {
            if (book.getAuthor().trim().isEmpty()) {
                throw new IllegalArgumentException("Имя автора не может быть пустым");
            }
            existingBook.setAuthor(book.getAuthor());
        }

        if (book.getIsbn() > 0) {
            existingBook.setIsbn(book.getIsbn());
        } else if (book.getIsbn() < 0) {
            throw new IllegalArgumentException("ISBN должен быть положительным");
        }

        if (book.getPrice() > 0) {
            existingBook.setPrice(book.getPrice());
        } else if (book.getPrice() < 0) {
            throw new IllegalArgumentException("Цена должна быть положительной");
        }

        if (book.getPublishedYear() != 0) {
            if (book.getPublishedYear() < 1000 || book.getPublishedYear() > 2025) {
                throw new IllegalArgumentException("Год публикации должен быть от 1000 до 2025 года включительно");
            }
            existingBook.setPublishedYear(book.getPublishedYear());
        }

        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteById(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Книга с id \"" + id + "\" уже удалена или не существует");
        }
        bookRepository.deleteById(id);
    }
    //todo реализовать сервис частичного поиска, пагинации, фильтрации и сортировки
    @Override
    public Page<Book> findBooks(
            String title,
            String author,
            int isbn,
            int publishedYear,
            double price,
            String sortBy,
            String sortDirection,
            int page,
            int size) {
        return null;
    }

}
