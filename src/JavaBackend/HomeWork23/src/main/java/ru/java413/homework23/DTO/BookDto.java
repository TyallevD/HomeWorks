package ru.java413.homework23.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class BookDto {

    private Long id;

    @NotBlank(message = "Название книги не может быть пустым")
    @Size(max = 200, message = "Название книги не должно превышать 200 символов")
    private String title;

    @NotBlank(message = "Автор не может быть пустым")
    @Size(max = 100, message = "Имя автора не должно превышать 100 символов")
    private String author;

    private LocalDateTime createdDate;
    private Boolean isRead;

    // Конструкторы
    public BookDto() {}

    public BookDto(Long id, String title, String author, LocalDateTime createdDate, Boolean isRead) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.createdDate = createdDate;
        this.isRead = isRead;
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
