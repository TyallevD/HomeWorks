package ru.java413.homework16;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomeWork16Application {

    public static void main(String[] args) {
        SpringApplication.run(HomeWork16Application.class, args);
    }

    @Bean
    public Faker faker() {
        return new Faker();
    }

    //todo сделать сортировку на бэкенде (добавить кнопки в hmtl на заголовки таблиц, добавить эндпоинты для сортировки)
}
