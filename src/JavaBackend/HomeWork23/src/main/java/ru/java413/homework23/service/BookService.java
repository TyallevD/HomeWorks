package ru.java413.homework23.service;

import jakarta.validation.Valid;
import ru.java413.homework23.DTO.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> getBooksSortedByTitle();

    List<BookDto> getBooksSortedByAuthor();

    List<BookDto> getBooksSortedByReadStatus();

    List<BookDto> getAllBooks();

    BookDto createBook(@Valid BookDto bookDto);

    void deleteBook(Long id);

    BookDto toggleReadStatus(Long id);
}
