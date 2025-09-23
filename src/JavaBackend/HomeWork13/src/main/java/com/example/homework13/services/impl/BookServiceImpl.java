package com.example.homework13.services.impl;

import com.example.homework13.entities.Book;
import com.example.homework13.repositories.BookRepository;
import com.example.homework13.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    //реализовать все методы
}
