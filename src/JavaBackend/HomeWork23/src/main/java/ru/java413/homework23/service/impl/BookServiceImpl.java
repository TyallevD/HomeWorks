package ru.java413.homework23.service.impl;

import org.springframework.stereotype.Service;
import ru.java413.homework23.DTO.BookDto;
import ru.java413.homework23.entity.Book;
import ru.java413.homework23.repository.BookRepository;
import ru.java413.homework23.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<BookDto> getBooksSortedByTitle() {
        return bookRepository.findAllByOrderByTitleAsc().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<BookDto> getBooksSortedByAuthor() {
        return bookRepository.findAllByOrderByAuthorAsc().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<BookDto> getBooksSortedByReadStatus() {
        return bookRepository.findAllByOrderByIsReadAndTitle().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Книга не найдена с id: " + id));
        return convertToDto(book);
    }

    public BookDto createBook(BookDto bookDto) {
        Book book = convertToEntity(bookDto);
        Book savedBook = bookRepository.save(book);
        return convertToDto(savedBook);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public BookDto toggleReadStatus(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Книга не найдена с id: " + id));
        book.setIsRead(!book.getIsRead());
        Book updatedBook = bookRepository.save(book);
        return convertToDto(updatedBook);
    }

    private BookDto convertToDto(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getCreatedDate(),
                book.getIsRead()
        );
    }

    private Book convertToEntity(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setIsRead(bookDto.getIsRead() != null ? bookDto.getIsRead() : false);
        return book;
    }
}
