package com.example.homework13;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomeWork13Application {

    public static void main(String[] args) {
        SpringApplication.run(HomeWork13Application.class, args);
    }

    @Bean
    public Faker faker() {
        return new Faker();
    }
}
