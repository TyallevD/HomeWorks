package com.example.homework13.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Название книги не может быть пустым")
    private String title;

    @NotBlank(message = "Имя автора не может быть пустым")
    private String author;

    @Positive(message = "ISBN должен быть положительным")
    private Integer isbn;

    @Min(value = 1000, message = "Год публикации не может быть меньше 1000 года")
    @Max(value = 2025, message = "Год публикации не может быть больше 2025 года")
    private Integer publishedYear;

    @Positive(message = "Цена должна быть положительной")
    private Double price;

    public Book() {
    }

    public Book(String title, String author, Integer isbn, Integer publishedYear, Double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.price = price;
    }

    public Book(Long id, String title, String author, Integer isbn, Integer publishedYear, Double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.price = price;
    }

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

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
