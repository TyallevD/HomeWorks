package com.example.homework13.controllers;

import com.example.homework13.entities.Book;
import com.example.homework13.services.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @GetMapping("/")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.findAll();
        if (books != null && !books.isEmpty()) {
            return ResponseEntity.ok(books);
        }
        return ResponseEntity.noContent().build();
    }

}
