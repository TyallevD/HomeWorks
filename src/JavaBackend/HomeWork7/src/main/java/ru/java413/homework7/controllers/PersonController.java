package ru.java413.homework7.controllers;

import org.springframework.web.bind.annotation.*;
import ru.java413.homework7.models.Person;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    private List<Person> people;

    public PersonController() {
        people = new ArrayList<>();
//        people.add(new Person("Дима", "Тяллев", 34));
//        people.add(new Person("Олег", "Сидоров", 38));
//        people.add(new Person("Максим", "Федоров", 27));
//        people.add(new Person("Константин", "Смирнов", 24));
    }

    @GetMapping("/all")
    public List<Person> getAll() {
        return people;
    }

//    @PostMapping("/")
//    public Boolean add(@RequestBody Person person) {
//        return people.add(person);
//    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable int id) {
        return people.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    @DeleteMapping("/{id}")
    public Person deleteById(@PathVariable int id) {
        Person p = people.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        people.remove(p);
        return p;
    }

    @PutMapping("/{id}")
    public Person updateById(@PathVariable int id, @RequestBody Person person) {
        Person p = people.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if (p != null) {
            if (person.getAge() != 0) {
                p.setAge(person.getAge());
            }
            if (person.getSurname() != null) {
                p.setSurname(person.getSurname());
            }
            if (person.getName() != null) {
                p.setName(person.getName());
            }
        }
        return p;
    }

    //1. Поиск по фамилии
    // Верни всех людей с указанной фамилией (игнорируй регистр).
    // (GET /api/person/search?surname=Ivanov)
    @GetMapping("/search")
    private List<Person> getBySurname(@RequestParam String surname) {
        return people.stream()
                .filter(x -> x.getSurname().equalsIgnoreCase(surname))
                .collect(Collectors.toList());
    }

    //2. Фильтрация по возрасту
    // Верни всех людей, чей возраст находится в диапазоне от min до max.
    // (GET /api/person/filter?min=20&max=40)
    @GetMapping("/filter")
    private List<Person> filterByAge(
            @RequestParam(name = "min") int min,
            @RequestParam(name = "max") int max) {
        return people.stream()
                .filter(x -> x.getAge() >= min && x.getAge() <= max)
                .collect(Collectors.toList());
    }

    //3. Сортировка
    //by: может быть name, surname, age
    //dir: asc или desc
    //Верни список людей, отсортированный по заданному полю и направлению.
    // (GET /api/person/sort?by=name&dir=asc)
    @GetMapping("/sort")
    private List<Person> sorting(
            @RequestParam(name = "by") String by,
            @RequestParam(name = "dir") String dir
    ) {
        List<Person> sortedPersons = new ArrayList<>();
        if (dir.equalsIgnoreCase("asc")) {
            if (by.equalsIgnoreCase("name")) {
                sortedPersons = people.stream().sorted(Comparator.comparing(Person::getName)).toList();
            } else if (by.equalsIgnoreCase("surname")) {
                sortedPersons = people.stream().sorted(Comparator.comparing(Person::getSurname)).toList();
            } else if (by.equalsIgnoreCase("age")) {
                sortedPersons = people.stream().sorted(Comparator.comparing(Person::getAge)).toList();
            }
        } else if (dir.equalsIgnoreCase("desc")) {
            if (by.equalsIgnoreCase("name")) {
                sortedPersons = people.stream().sorted(Comparator.comparing(Person::getName).reversed()).toList();
            } else if (by.equalsIgnoreCase("surname")) {
                sortedPersons = people.stream().sorted(Comparator.comparing(Person::getSurname).reversed()).toList();
            } else if (by.equalsIgnoreCase("age")) {
                sortedPersons = people.stream().sorted(Comparator.comparing(Person::getAge).reversed()).toList();
            }
        }
        return sortedPersons;
    }

    //4. Валидация при добавлении
    //Если имя, фамилия или возраст не заданы (или возраст < 0),
    // — не добавляй пользователя, верни false.
    @PostMapping("/")
    public Boolean add(@RequestBody Person person) {
        if (person.getAge() <= 0 || person.getName() == null || person.getSurname() == null) {
            return false;
        }
        return people.add(person);
    }

    //5. Удаление по фамилии
    //Удаляет всех людей с этой фамилией (игнорируя регистр), возвращает количество удалённых.
    //(DELETE /api/person/deleteBySurname?surname=Ivanov)
    @DeleteMapping("/deleteBySurname")
    private int deleteBySurname(
            @RequestParam(name = "surname") String surname
    ) {
        int count = 0;
        Iterator<Person> iterator = people.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getSurname().equalsIgnoreCase(surname)) {
                iterator.remove();
                count++;
            }
        }
        return count;
    }

    //6. Верни самого молодого и самого старого
    // (GET /oldest , /youngest)
    @GetMapping("/oldest")
    private Person getOldest() {
        return people.stream().max(Comparator.comparing(Person::getAge)).orElse(null);
    }

    @GetMapping("/youngest")
    private Person getYoungest() {
        return people.stream().min(Comparator.comparing(Person::getAge)).orElse(null);
    }
}
