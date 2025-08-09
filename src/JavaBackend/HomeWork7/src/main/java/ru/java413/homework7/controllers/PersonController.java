package ru.java413.homework7.controllers;

import org.springframework.web.bind.annotation.*;
import ru.java413.homework7.models.Person;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    private List<Person> people;

    public PersonController(){
        people = new ArrayList<>();
    }

    @GetMapping("/all")
    public List<Person> getAll(){
        return people;
    }

    @PostMapping("/")
    public Boolean add(@RequestBody Person person){
        return people.add(person);
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable int id){
        return people.stream().filter(x-> x.getId()==id).findFirst().orElse(null);
    }

    @DeleteMapping("/{id}")
    public Person deleteById(@PathVariable int id){
        Person p = people.stream().filter(x->x.getId()==id).findFirst().orElse(null);
        people.remove(p);
        return p;
    }

    @PutMapping("/{id}")
    public Person updateById(@PathVariable int id, @RequestBody Person person){
        Person p = people.stream().filter(x->x.getId() ==id).findFirst().orElse(null);
        if (p!=null){
            if (person.getAge()!=0){
                p.setAge(person.getAge());
            }
            if (person.getSurname()!=null){
                p.setSurname(person.getSurname());
            }
            if (person.getName()!=null){
                p.setName(person.getName());
            }
        }
        return p;
    }

    //todo
    //1. Поиск по фамилии
    // Верни всех людей с указанной фамилией (игнорируй регистр).
    // (GET /api/person/search?surname=Ivanov)

    //2. Фильтрация по возрасту
    // Верни всех людей, чей возраст находится в диапазоне от min до max.
    // (GET /api/person/filter?min=20&max=40)

    //3. Сортировка
    //by: может быть name, surname, age
    //dir: asc или desc
    //Верни список людей, отсортированный по заданному полю и направлению.
    // (GET /api/person/sort?by=name&dir=asc)

    //4. Валидация при добавлении
    //Если имя, фамилия или возраст не заданы (или возраст < 0),
    // — не добавляй пользователя, верни false.

    //5. Удаление по фамилии
    //Удаляет всех людей с этой фамилией (игнорируя регистр), возвращает количество удалённых.
    //(DELETE /api/person/deleteBySurname?surname=Ivanov)

    //6. Верни самого молодого и самого старого
    // (GET /oldest , /youngest)
}
