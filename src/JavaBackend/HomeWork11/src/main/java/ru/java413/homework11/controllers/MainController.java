package ru.java413.homework11.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        return ResponseEntity.ok(personServiceImpl.save(person));
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
    public ResponseEntity<List<Person>> saveAllPersons(@RequestBody List<Person> persons) {
        return ResponseEntity.ok(personServiceImpl.saveAll(persons));
    }

    //findById
    //curl -L -X GET "http://127.0.0.1:8080/main/findById/1"
    @GetMapping("/findById/{id}")
    public ResponseEntity<Optional<Person>> findPersonById(@PathVariable Long id) {
        return ResponseEntity.ok(personServiceImpl.findById(id));
    }

    //existById
    //curl -L -X GET "http://127.0.0.1:8080/main/existsById/1"
    @GetMapping("/existsById/{id}")
    public ResponseEntity<Boolean> existsPersonById(@PathVariable Long id) {
        return personServiceImpl.existById(id) ?
                ResponseEntity.ok(true) :
                ResponseEntity.notFound().build();
    }

    //findAll
    //curl -L -X GET "http://127.0.0.1:8080/main/"
    @GetMapping("/")
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.ok(personServiceImpl.findAll());
    }

    //findAllById
    //curl -L -X GET "http://127.0.0.1:8080/main/allByIds?ids=1&ids=2&ids=3"
    @GetMapping("/allByIds")
    public ResponseEntity<Iterable<Person>> findAllPersonsById(@RequestParam("ids") List<Long> ids) {
        return ResponseEntity.ok(personServiceImpl.findAllById(ids));
    }

    //count
    //curl -L -X GET "http://127.0.0.1:8080/main/count"
    @GetMapping("/count")
    public ResponseEntity<Long> countPersons() {
        return ResponseEntity.ok(personServiceImpl.count());
    }

    //deleteById
    //curl -L -X DELETE "http://127.0.0.1:8080/main/1"
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        personServiceImpl.deleteById(id);
        return ResponseEntity.ok().build();
    }

    //delete
    //curl -L -X DELETE "http://127.0.0.1:8080/main/" -H "Content-Type: application/json" -d "{\"id\": 1,\"firstName\": \"Oleg\",\"lastName\": \"Sidorov\",\"age\": 36}"
    @DeleteMapping("/")
    public ResponseEntity<Void> delete(@RequestBody Person person) {
        personServiceImpl.delete(person);
        return ResponseEntity.ok().build();
    }

    //deleteAll
    //curl -L -X DELETE "http://127.0.0.1:8080/main/deleteAll"
    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAll() {
        personServiceImpl.deleteAll();
        return ResponseEntity.ok().build();
    }
}
