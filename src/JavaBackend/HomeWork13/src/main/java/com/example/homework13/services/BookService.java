package com.example.homework13.services;

import com.example.homework13.DTOs.BookDTO;
import com.example.homework13.entities.Book;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookDTO> findAll();

    Optional<BookDTO> findById(Long id);

    Book createBook(Book book);

    Book updateBook(Long id, Book book);

    void deleteById(Long id);

    //todo реализовать сервис частичного поиска, пагинации, фильтрации и сортировки
    Page<Book> findBooks(
            String title,
            String author,
            Integer isbn,
            Integer publishedYear,
            Double price,
            String sortBy,
            String sortDirection,
            int page,
            int size);

//    List<BookDTO> findBooksByTitle(String title);
//
//    List<BookDTO> findBooksByAuthor(String author);
}
