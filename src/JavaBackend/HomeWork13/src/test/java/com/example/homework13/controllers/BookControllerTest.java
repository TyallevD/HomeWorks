package com.example.homework13.controllers;


import com.example.homework13.entities.Book;
import com.example.homework13.services.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {
    @Autowired
    private BookService bookService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    //Задание 1: Базовый CRUD для книг
    //Создайте тест-класс BookControllerTest для тестирования REST API управления книгами.
    // Модель Book содержит поля: id, title, author, isbn, publishedYear, price.
    // Напишите тесты:
    // для создания книги с валидными данными,
    @Test
    public void create_book_with_valid_data_return_book() throws Exception {
        Book book = new Book();

        book.setTitle(faker.book().title());
        book.setPublishedYear(faker.number().numberBetween(1900, 2026));
        book.setIsbn(faker.number().numberBetween(100, 200));
        book.setAuthor(faker.book().author());
        book.setPrice(faker.number().randomDouble(2, 1, 9999));

        mockMvc.perform(post("/api/book")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is(book.getTitle())))
                .andExpect(jsonPath("$.publishedYear", is(book.getPublishedYear())))
                .andExpect(jsonPath("$.isbn", is(book.getIsbn())))
                .andExpect(jsonPath("$.author", is(book.getAuthor())))
                .andExpect(jsonPath("$.price", is(book.getPrice())));
    }

    // получения книги по существующему ID
    @Test
    public void get_book_by_existing_id_and_return_book() throws Exception {
        Book book = new Book();

        book.setTitle(faker.book().title());
        book.setPublishedYear(faker.number().numberBetween(1900, 2026));
        book.setIsbn(faker.number().numberBetween(100, 200));
        book.setAuthor(faker.book().author());
        book.setPrice(faker.number().randomDouble(2, 1, 9999));

        Book result = bookService.createBook(book);

        mockMvc.perform(get("/api/book/{id}", book.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is(result.getTitle())))
                .andExpect(jsonPath("$.publishedYear", is(result.getPublishedYear())))
                .andExpect(jsonPath("$.isbn", is(result.getIsbn())))
                .andExpect(jsonPath("$.author", is(result.getAuthor())))
                .andExpect(jsonPath("$.price", is(result.getPrice())))
                .andExpect(jsonPath("$.id").value(result.getId()));
    }

    // получения книги по несуществующему ID (должен возвращать 404)
    @Test
    public void get_book_by_not_existing_id_return_not_found() throws Exception {
        mockMvc.perform(get("/api/book/{id}", -1))
                .andExpect(status().isNotFound());
    }

    //Задание 2: Тестирование валидации данных
    //Протестируйте валидацию при создании книги.
    // Напишите тесты для:
    // создания книги с пустым title (должен возвращать 400)
    @Test
    public void create_book_without_title_return_400() throws Exception {
        Book book = new Book();
//        book.setTitle(faker.book().title());
        book.setPublishedYear(faker.number().numberBetween(1900, 2025));
        book.setIsbn(faker.number().numberBetween(100, 200));
        book.setAuthor(faker.book().author());
        book.setPrice(faker.number().randomDouble(2, 1, 9999));

        mockMvc.perform(post("/api/book")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().is(400));
    }

    // создания книги с невалидным ISBN (должен возвращать 400)
    @Test
    public void create_book_with_invalid_isbn_return_400() throws Exception {
        Book book = new Book();
        book.setTitle(faker.book().title());
        book.setPublishedYear(faker.number().numberBetween(1900, 2025));
        book.setIsbn(-1);
        book.setAuthor(faker.book().author());
        book.setPrice(faker.number().randomDouble(2, 1, 9999));

        mockMvc.perform(post("/api/book")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().is(400));
    }

    // создания книги с отрицательной ценой (должен возвращать 400),
    @Test
    public void create_book_with_negative_price_return_400() throws Exception {
        Book book = new Book();
        book.setTitle(faker.book().title());
        book.setPublishedYear(faker.number().numberBetween(1900, 2025));
        book.setIsbn(faker.number().numberBetween(100, 200));
        book.setAuthor(faker.book().author());
        book.setPrice(-200);

        mockMvc.perform(post("/api/book")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().is(400));
    }

    // создания книги с годом публикации из будущего (должен возвращать 400).
    @Test
    public void create_book_with_future_published_year_return_400() throws Exception {
        Book book = new Book();
        book.setTitle(faker.book().title());
        book.setPublishedYear(faker.number().numberBetween(2050, 2100));
        book.setIsbn(faker.number().numberBetween(100, 200));
        book.setAuthor(faker.book().author());
        book.setPrice(faker.number().randomDouble(2, 1, 9999));

        mockMvc.perform(post("/api/book")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().is(400));
    }

    //Задание 3: Тестирование обновления книг
    //Создайте тесты для PUT endpoint обновления книг.
    // Протестируйте:
    // полное обновление существующей книги,
    @Test
    public void update_existing_book_return_ok() throws Exception {
        Book book = new Book();

        book.setTitle(faker.book().title());
        book.setPublishedYear(faker.number().numberBetween(1900, 2026));
        book.setIsbn(faker.number().numberBetween(100, 200));
        book.setAuthor(faker.book().author());
        book.setPrice(faker.number().randomDouble(2, 1, 9999));

        Book result = bookService.createBook(book);

        Book newBook = new Book("NEW TITLE", "NEW AUTHOR", 146, 2012, 15.00);

        mockMvc.perform(put("/api/book/{id}", result.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newBook)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is(newBook.getTitle())))
                .andExpect(jsonPath("$.author", is(newBook.getAuthor())))
                .andExpect(jsonPath("$.isbn").value(newBook.getIsbn()))
                .andExpect(jsonPath("$.publishedYear").value(newBook.getPublishedYear()))
                .andExpect(jsonPath("$.price").value(newBook.getPrice()))
                .andExpect(jsonPath("$.id").value(result.getId()));

    }

    // обновление несуществующей книги (404),
    @Test
    public void update_not_existing_book_return_not_found() throws Exception {
        Book newBook = new Book("NEW TITLE", "NEW AUTHOR", 146, 2012, 15.00);
        mockMvc.perform(put("/api/book/{id}", -1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newBook)))
                .andExpect(status().isNotFound());

    }

    // частичное обновление книги (PATCH)
    //todo ну тут видимо надо частично существующую книгу подправить
    @Test
    public void partial_book_update_return_ok(){
        Book book = new Book();
        //создать книгу, затем её частично (к примеру title обновить, получить ок)
    }

    // обновление с невалидными данными (400).
    @Test
    public void update_book_with_invalid_data_return_bad_request() throws Exception {
        Book book = new Book();
        book.setTitle(faker.book().title());
        book.setPublishedYear(faker.number().numberBetween(1900, 2026));
        book.setIsbn(faker.number().numberBetween(100, 200));
        book.setAuthor(faker.book().author());
        book.setPrice(faker.number().randomDouble(2, 1, 9999));

        Book result = bookService.createBook(book);

        Book newBook = new Book(); //книга для обновления на пустые данные

        mockMvc.perform(put("/api/book/{id}", result.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newBook)))
                .andExpect(status().isBadRequest());
    }

    //todo доделать задания
    //Задание 4: Поиск и фильтрация книг
    //Напишите тесты для поиска книг по различным критериям:
    // поиск по названию (частичное совпадение),
    // поиск по автору,
    // фильтрация по диапазону цен,
    // фильтрация по году публикации,
    // комбинированный поиск по нескольким параметрам.
    // Используйте Faker для генерации 1000 тестовых книг.


    //Задание 5: Пагинация и сортировка
    //Протестируйте пагинацию списка книг.
    // Создайте тесты для:
    // получения первой страницы с лимитом 10,
    // получения конкретной страницы,
    // сортировки по цене (по возрастанию и убыванию),
    // сортировки по году публикации,
    // получения пустой страницы при превышении лимита.
}
