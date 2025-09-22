package ru.java413.homework11.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.java413.homework11.entities.Person;
import ru.java413.homework11.repositories.PersonRepository;
import ru.java413.homework11.services.PersonService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    //save
    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    //saveAll
    @Override
    public List<Person> saveAll(List<Person> persons) {
        return (List<Person>) personRepository.saveAll(persons);
    }

    //findById
    @Override
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    //existById
    public boolean existById(Long id) {
        return personRepository.existsById(id);
    }

    //findAll
    @Override
    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    //findAllById
    @Override
    public List<Person> findAllById(Long id) {
        return (List<Person>) personRepository.findAllById(Collections.singleton(id));
    }

    //count
    @Override
    public Long count() {
        return personRepository.count();
    }

    //deleteById
    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    //delete
    @Override
    public void delete(Person person) {
        personRepository.delete(person);
    }

    //deleteAll
    @Override
    public void deleteAll() {
        personRepository.deleteAll();
    }
}
