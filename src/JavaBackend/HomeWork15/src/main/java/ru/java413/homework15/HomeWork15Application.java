package ru.java413.homework15;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomeWork15Application {

    public static void main(String[] args) {
        SpringApplication.run(HomeWork15Application.class, args);
    }

    @Bean
    Faker faker() {
        return new Faker();
    }
}
