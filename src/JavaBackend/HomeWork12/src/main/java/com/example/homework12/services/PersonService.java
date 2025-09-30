package com.example.homework12.services;

import com.example.homework12.entities.Person;
import com.example.homework12.repository.PersonRepository;
import com.example.homework12.repository.PersonSortingRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    PersonSortingRepository personSortingRepository;

    //для подготовки данных
    @Autowired
    Faker faker;

    public List<Person> addNewPersons() {
        if (personRepository.count() < 100) {
            List<Person> persons = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                String name = faker.name().firstName();
                String surname = faker.name().lastName();
                int age = faker.number().numberBetween(1, 90);
                String email = faker.internet().emailAddress();

                persons.add(new Person(name, surname, age, email));
            }
            return personRepository.saveAll(persons);
        }
        return null;
    }


//    public List<Person> saveAll(List<Person> persons) {
//        return personRepository.saveAll(persons);
//    }
}
