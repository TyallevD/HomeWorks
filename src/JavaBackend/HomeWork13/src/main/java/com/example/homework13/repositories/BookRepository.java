package com.example.homework13.repositories;

import com.example.homework13.DTOs.BookDTO;
import com.example.homework13.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

//    List<Book> findByTitleContaining(String title);
//
//    List<BookDTO> findByAuthor(String author);
}
