package ru.java413.homework23.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    @NotBlank(message = "Название книги не может быть пустым")
    @Size(max = 200, message = "Название книги не должно превышать 200 символов")
    private String title;

    @NotBlank(message = "Автор не может быть пустым")
    @Size(max = 100, message = "Имя автора не должно превышать 100 символов")
    @Column(nullable = false, length = 100)
    private String author;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "is_read", nullable = false)
    private Boolean isRead = false;

    // Конструкторы
    public Book() {
        this.createdDate = LocalDateTime.now();
    }

    public Book(String title, String author) {
        this();
        this.title = title;
        this.author = author;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }
}