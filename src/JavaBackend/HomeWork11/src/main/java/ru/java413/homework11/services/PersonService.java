package ru.java413.homework11.services;

import ru.java413.homework11.entities.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    //save
    Person save(Person person);

    //saveAll
    List<Person> saveAll(List<Person> persons);

    //findById
    Optional<Person> findById(Long id);

    //existById
    boolean existById(Long id);

    //findAll
    List<Person> findAll();

    //findAllById
    List<Person> findAllById(Long id);

    //count
    Long count();

    //deleteById
    void deleteById(Long id);

    //delete
    void delete(Person person);

    //deleteAll
    void deleteAll();
}
