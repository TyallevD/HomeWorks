package com.example.homework13.controllers;

import com.example.homework13.DTOs.BookDTO;
import com.example.homework13.entities.Book;
import com.example.homework13.services.BookService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    //http://127.0.0.1:8080/swagger-ui/index.html

    @GetMapping("/")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookService.findAll();
        if (books != null && !books.isEmpty()) {
            return ResponseEntity.ok(books);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getOneBook(@PathVariable Long id) {
        return bookService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Book> create(@RequestBody @Valid Book book) {
        Book createdBook = bookService.createBook(book);
        return ResponseEntity.status(HttpStatus.OK).body(createdBook);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid Book book) {
        try {
            Book updatedBook = bookService.updateBook(id, book);
            return ResponseEntity.ok(updatedBook);
        } catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //todo надо сделать сервис и контроллер пагинации, фильтрации
    @GetMapping("/books")
    public ResponseEntity<Page<Book>> getBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) Integer isbn,
            @RequestParam(required = false) Integer publishedYear,
            @RequestParam(required = false) Double price,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        Page<Book> books = bookService.findBooks(
                title, author, isbn, publishedYear, price, sortBy, sortDirection, page, size
        );
        return ResponseEntity.ok(books);
    }
//    @GetMapping("/filter/{title}")
//    public ResponseEntity<List<BookDTO>> getBooksByTitle(
//            @PathVariable String title) {
//        List<BookDTO> books = bookService.findBooksByTitle(title);
//        return ResponseEntity.ok(books);
//    }
//
//    @GetMapping("/filter/{author}")
//    public ResponseEntity<List<BookDTO>> getBooksByAuthor(
//            @PathVariable String author) {
//        List<BookDTO> books = bookService.findBooksByAuthor(author);
//        return ResponseEntity.ok(books);
//    }
}
