package com.example.homework12;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomeWork12Application {

    public static void main(String[] args) {
        SpringApplication.run(HomeWork12Application.class, args);
    }

    @Bean
    Faker faker() {
        return new Faker();
    }

}
