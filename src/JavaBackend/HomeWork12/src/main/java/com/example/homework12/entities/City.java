package com.example.homework12.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "city")
    private List<Person> people = new ArrayList<>();

    public City() {
    }

    public City(String name) {
        this.name = name;
    }
}
