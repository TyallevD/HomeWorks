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
    private int isbn;

    @Min(value = 1000, message = "Год публикации не может быть меньше 1000 года")
    @Max(value = 2025, message = "Год публикации не может быть больше 2025 года")
    private int publishedYear;

    @Positive(message = "Цена должна быть положительной")
    private double price;

    public Book() {
    }

    public Book(String title, String author, int isbn, int publishedYear, double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.price = price;
    }

    public Book(Long id, String title, String author, int isbn, int publishedYear, double price) {
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

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
