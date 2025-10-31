package com.example.homework13.services;

import com.example.homework13.DTOs.BookDTO;
import com.example.homework13.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookDTO> findAll();

    Optional<BookDTO> findById(Long id);

    Book createBook(Book book);

    Book updateBook(Long id, com.example.homework13.entities.Book book);

    void deleteById(Long id);

}
