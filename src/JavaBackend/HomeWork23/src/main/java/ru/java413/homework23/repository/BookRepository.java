package ru.java413.homework23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.java413.homework23.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByOrderByTitleAsc();
    List<Book> findAllByOrderByAuthorAsc();
    List<Book> findAllByOrderByIsReadAsc();

    @Query("SELECT b FROM Book b ORDER BY b.isRead, b.title")
    List<Book> findAllByOrderByIsReadAndTitle();
}
