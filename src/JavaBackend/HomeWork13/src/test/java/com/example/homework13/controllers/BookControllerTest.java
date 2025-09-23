package com.example.homework13.controllers;


import com.example.homework13.services.impl.BookServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {
    @Autowired
    BookServiceImpl bookService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    Faker faker;

    //Задание 1: Базовый CRUD для книг
    //Создайте тест-класс BookControllerTest для тестирования REST API управления книгами.
    // Модель Book содержит поля: id, title, author, isbn, publishedYear, price.
    // Напишите тесты:
    // для создания книги с валидными данными,
    // получения книги по существующему ID,
    // получения книги по несуществующему ID (должен возвращать 404).


    //Задание 2: Тестирование валидации данных
    //Протестируйте валидацию при создании книги.
    // Напишите тесты для:
    // создания книги с пустым title (должен возвращать 400),
    // создания книги с невалидным ISBN (должен возвращать 400),
    // создания книги с отрицательной ценой (должен возвращать 400),
    // создания книги с годом публикации из будущего (должен возвращать 400).


    //Задание 3: Тестирование обновления книг
    //Создайте тесты для PUT endpoint обновления книг.
    // Протестируйте:
    // полное обновление существующей книги,
    // обновление несуществующей книги (404),
    // частичное обновление книги (PATCH),
    // обновление с невалидными данными (400).


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
