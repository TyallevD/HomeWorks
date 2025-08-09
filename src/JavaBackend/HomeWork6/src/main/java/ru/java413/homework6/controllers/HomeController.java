package ru.java413.homework6.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.java413.homework6.models.Person;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/home")
public class HomeController {
    private List<Person> people;

    public HomeController() {
        people = new ArrayList<>();
    }


    //http://localhost:8080/api/home/add?name=Дима&surname=Тяллев&age=34
    //http://localhost:8080/api/home/add?name=Алексей&surname=Никифоров&age=35
    //http://localhost:8080/api/home/add?name=Олег&surname=Сидоров&age=38
    //http://localhost:8080/api/home/add?name=Михаил&surname=Гусаров&age=23
    @GetMapping("/add")
    public boolean add(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "surname") String surname,
            @RequestParam(name = "age") int age
    ) {
        return isCheked(name, surname, age);
    }

    private boolean isCheked(String name, String surname, int age) {
        if (name == null || surname == null || age < 0) {
            return false;
        }
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getName().equals(name) &&
                    people.get(i).getSurname().equals(surname) &&
                    people.get(i).getAge() == age) {
                return false;
            }
        }
        people.add(new Person(name, surname, age));
        return true;
    }

    //http://localhost:8080/api/home/list
    @GetMapping("/list")
    public List<Person> list() {
        return people;
    }

    //http://localhost:8080/api/home/remove?id=1
    @GetMapping("/remove")
    public boolean remove(
            @RequestParam(name = "id") int id
    ) {
        for (Person p : people) {
            if (p.getId() == id) {
                people.remove(p);
                return true;
            }
        }
        return false;
    }

    //http://localhost:8080/api/home/removeall
    @GetMapping("/removeall")
    public boolean removeAll() {
        if (people.isEmpty()) {
            return false;
        } else {
            people.clear();
            return true;
        }
    }

    //http://localhost:8080/api/home/update?id=1&name=Константин
    //http://localhost:8080/api/home/update?id=2&surname=Петров
    //http://localhost:8080/api/home/update?id=3&age=39
    //http://localhost:8080/api/home/update?id=4&name=Антон&surname=Федоров&age=25
    @GetMapping("/update")
    public boolean update(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "surname", required = false) String surname,
            @RequestParam(name = "age", required = false) Integer age
    ) {
        boolean isChanged = false;
        for (Person p : people) {
            if (p.getId() == id) {
                if (name != null && !p.getName().equals(name)) {
                    p.setName(name);
                    isChanged = true;
                }
                if (surname != null && !p.getSurname().equals(surname)) {
                    p.setSurname(surname);
                    isChanged = true;
                }
                if ((age != null && age >= 0) && p.getAge() != age) {
                    p.setAge(age);
                    isChanged = true;
                }
                return isChanged;
            }
        }
        return isChanged;
    }
}
