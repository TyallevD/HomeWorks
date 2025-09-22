package ru.java413.homework11.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.java413.homework11.entities.Person;
import ru.java413.homework11.services.impl.PersonServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/main")
//http://127.0.0.1:8080/main/
public class MainController {

    @Autowired
    private PersonServiceImpl personServiceImpl;

    //save
    //http://127.0.0.1:8080/main/save
    //{
    //    "firstName": "Dmitry",
    //    "lastName": "Tyallev",
    //    "age": 34
    //}
    @PostMapping("/save")
    public Person savePerson(@RequestBody Person person) {
        return personServiceImpl.save(person);
    }

    //saveAll
//    http://127.0.0.1:8080/main/saveAll
//    [
//    {
//        "firstName": "Oleg",
//        "lastName": "Sidorov",
//        "age": 36
//    },
//    {
//        "firstName": "Dmitry",
//        "lastName": "Tyallev",
//        "age": 34
//    },
//    {
//        "firstName": "Konstantin",
//        "lastName": "Cheremnov",
//        "age": 38
//    },
//    {
//        "firstName": "Mikhail",
//        "lastName": "Parfenov",
//        "age": 25
//    }
//]
    @PostMapping("/saveAll")
    public List<Person> saveAllPersons(@RequestBody List<Person> persons) {
        return personServiceImpl.saveAll(persons);
    }

    //findById
    //http://127.0.0.1:8080/main/findById/1
    @GetMapping("/findById/{id}")
    public Optional<Person> findPersonById(@PathVariable Long id) {
        return personServiceImpl.findById(id);
    }

    //existById
    //http://127.0.0.1:8080/main/existsById/1
    @GetMapping("/existsById/{id}")
    public Boolean existsPersonById(@PathVariable Long id) {
        return personServiceImpl.existById(id);
    }

    //findAll
    //http://127.0.0.1:8080/main/
    @GetMapping("/")
    public List<Person> findAll() {
        return personServiceImpl.findAll();
    }

    //findAllById //todo не понял
    //http://127.0.0.1:8080/main/all/1
    @GetMapping("/all/{id}")
    public List<Person> findAllPersonsById(@PathVariable Long id) {
        return personServiceImpl.findAllById(id);
    }

    //count
    //http://127.0.0.1:8080/main/count
    @GetMapping("/count")
    public Long countPersons() {
        return personServiceImpl.count();
    }

    //deleteById
    //http://127.0.0.1:8080/main/1
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        personServiceImpl.deleteById(id);
    }

    //delete //todo не понял
    @DeleteMapping("/")
    public void delete(Person person) {
        personServiceImpl.delete(person);
    }

    //deleteAll
    //http://127.0.0.1:8080/main/deleteAll
    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        personServiceImpl.deleteAll();
    }
}
