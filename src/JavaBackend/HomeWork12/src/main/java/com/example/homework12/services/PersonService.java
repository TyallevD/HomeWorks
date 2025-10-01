package com.example.homework12.services;

import com.example.homework12.entities.Person;
import com.example.homework12.projection.LastNameCountProjection;
import com.example.homework12.projection.PersonCitiesProjection;
import com.example.homework12.repository.PersonRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    //для подготовки данных
    @Autowired
    private Faker faker;

    public List<Person> addNewPersons() {
        if (personRepository.count() < 100) {
            List<Person> persons = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                String name = faker.name().firstName();
                String surname = faker.name().lastName();
                int age = faker.number().numberBetween(1, 90);
                String email = faker.internet().emailAddress();
//                int city_id = faker.number().numberBetween(1, 15); //todo
                persons.add(new Person(name, surname, age, email));
            }
            return personRepository.saveAll(persons);
        }
        return null;
    }

    //1.1
    public List<Person> findAllAndSortByFirstNameAsc() {
        return personRepository.findAll(Sort.by("firstName").ascending());
    }

    //1.2
    public List<Person> findAllAndSortByAgeDesc() {
        return personRepository.findAll(Sort.by("age").descending());
    }

    //1.3
    public Page<Person> findAllByPageAndSortById() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by("id"));
        return personRepository.findAll(pageable);
    }

    //1.4
    public Page<Person> findAllBySecondPageAndSortByLastName() {
        Pageable pageable = PageRequest.of(1, 10, Sort.by("lastName"));
        return personRepository.findAll(pageable);
    }

    //1.5
    public Page<Person> findPersonAboveEighteen() {
        Pageable pageable = PageRequest.of(0, 100);
        return personRepository.findPersonByAgeAfter(18, pageable);
    }

    //1.6
    public Page<Person> findFirstPageByLastname(String lastName) {
        Pageable pageable = PageRequest.of(0, 10);
        return personRepository.findPersonByLastName(lastName, pageable);
    }

    //1.7
    public List<Person> findSortedPersonByAgeAndLastName(Integer age, String lastName) {
        return personRepository.findAll(Sort.by(String.valueOf(age)).descending().
                and(Sort.by(String.valueOf(age)).ascending().
                        and(Sort.by(lastName).ascending().
                                and(Sort.by(lastName).descending()))));
    }

    //1.8
    public Page<Person> findAllByGmail() {
        Pageable pageable = PageRequest.of(0, 10);
        return personRepository.findPersonByEmailContaining("gmail.com", pageable);
    }

    //1.9
    public Page<Person> findPersonsByAgeBetween(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return personRepository.findPersonByAgeBetween(20, 40, pageable);
    }

    //1.10
    public Page<Person> findSortedPersonByName(String name, String sort) {
        Pageable pageable = PageRequest.of(0, 10,
                sort.equalsIgnoreCase("desc") ?
                        Sort.by("firstName").descending() :
                        Sort.by("firstName").ascending());

        return personRepository.findPersonByFirstNameContains(name, pageable);
    }

    //2.1
    public List<Person> findPersonsByGmail() {
        return personRepository.selectPersonsByGmail();
    }

    //2.2
    public List<PersonCitiesProjection> findPersonsWithCities() {
        return personRepository.selectPersonsWithCities();
    }

    //2.3
    public List<LastNameCountProjection> findLastNamesAndCount() {
        return personRepository.selectLastNamesAndCount();
    }

    //2.4
    public List<Person> findPersonsWithPagination(int page, int size) {
        return personRepository.selectPersonsWithPagination(page, size);
    }

    //todo
    //2.5

    //2.6

    //2.7

    //2.8

    //2.9

}
