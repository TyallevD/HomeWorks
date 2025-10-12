package com.example.homework12.services;

import com.example.homework12.entities.City;
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
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CityService cityService;

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
                City city = cityService.getCityById();
                Person newPerson = new Person(name, surname, age, email, city);

                persons.add(newPerson);
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
    public List<Person> findSortedPersonByAgeAndLastName(String ageSort, String lastNameSort) {
        if (ageSort.equalsIgnoreCase("asc") && lastNameSort.equalsIgnoreCase("asc")) {
            return personRepository.findAll(Sort.by("age").ascending().and(Sort.by("lastName").ascending()));
        } else if (ageSort.equalsIgnoreCase("desc") && lastNameSort.equalsIgnoreCase("asc")) {
            return personRepository.findAll(Sort.by("age").descending().and(Sort.by("lastName")).ascending());
        } else if (ageSort.equalsIgnoreCase("asc") && lastNameSort.equalsIgnoreCase("desc")) {
            return personRepository.findAll(Sort.by("age").ascending().and(Sort.by("lastName").descending()));
        } else if (ageSort.equalsIgnoreCase("desc") && lastNameSort.equalsIgnoreCase("desc")) {
            return personRepository.findAll(Sort.by("age").descending().and(Sort.by("lastName").descending()));
        }
        return personRepository.findAll();
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

    //2.5
    public Integer updatePersonsAge(int delta, int maxAge) {
        return personRepository.updatePersonsAge(delta, maxAge);
    }

    //2.6
    public Integer deletePersonsByAge(int age) {
        return personRepository.deletePersonByAgeBefore(age);
    }

    //2.7
    public Integer insertPerson(String name, String lastName, int age, String email) {
        return personRepository.insertPerson(name, lastName, age, email);
    }

    //2.8
    public List<Person> findPersonAboveTen() {
        return personRepository.executeGetPersonsAboveTen();
    }

    //2.9
    public List<Person> findPersonAboveAge(int minAge) {
        return personRepository.executeGetPersonAboveAge(minAge);
    }

}
