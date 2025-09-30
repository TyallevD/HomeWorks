package com.example.homework12.controllers;

import com.example.homework12.entities.Person;
import com.example.homework12.repository.PersonRepository;
import com.example.homework12.repository.PersonSortingRepository;
import com.example.homework12.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    private PersonService personService;
    //todo переделать всё под работу с сервисом или же сделать попроще но через репозиторий?
    // (тогда надо репозиторий переименовать и убрать лишний)

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    PersonSortingRepository personSortingRepository;

    //curl -L -X POST "http://127.0.0.1:8080/main/addPersons"
    @PostMapping("/addPersons")
    public ResponseEntity<List<Person>> addNewPersons() {
        return ResponseEntity.ok(personService.addNewPersons());
    }


    //1) Задания для PagingAndSortingRepository (работа с сортировкой и постраничностью)
    //1. Получить все записи с сортировкой по firstName по возрастанию.
    //curl -L -X GET "http://127.0.0.1:8080/main/firstnameAsc"
    @GetMapping("/firstnameAsc")
    public List<Person> sortByFirstnameAsc() {
        return (List<Person>) personSortingRepository.findAll(Sort.by("firstName").ascending());
    }

    //2. Получить все записи с сортировкой по age по убыванию.
    //curl -L -X GET "http://127.0.0.1:8080/main/ageDesc"
    @GetMapping("/ageDesc")
    public List<Person> sortByAgeDesc() {
        return (List<Person>) personSortingRepository.findAll(Sort.by("age").descending());
    }

    //3. Вернуть первую страницу (по 5 элементов) с сортировкой по id.
    //curl -L -X GET "http://127.0.0.1:8080/main/getFirstPage"
    @GetMapping("/getFirstPage")
    public Page<Person> getFirstPage() {
        Pageable pageable = PageRequest.of(0, 5);
        return personSortingRepository.findAll(pageable);
    }

    //4. Вернуть вторую страницу (по 10 элементов) с сортировкой по lastName.
    //curl -L -X GET "http://127.0.0.1:8080/main/getSecondPage"
    @GetMapping("/getSecondPage")
    public Page<Person> getSecondPage() {
        Pageable pageable = PageRequest.of(1, 10, Sort.by("lastName"));
        return personSortingRepository.findAll(pageable);
    }

    //5. Найти записи Person, у которых возраст больше 18 лет, с пагинацией.
    //curl -L -X GET "http://127.0.0.1:8080/main/above18"
    @GetMapping("/above18")
    public Page<Person> getPersonAboveEighteen() {
        Pageable pageable = PageRequest.of(0, 100);
        return personSortingRepository.findPersonByAgeAfter(18, pageable);
    }

    //6. Найти записи Person по lastName, возвращая только первую страницу.
    //curl -L -X GET "http://127.0.0.1:8080/main/getByLastName1?lastName=<фамилия>"
    @GetMapping("/getByLastName1")
    public Page<Person> getPersonByLastName(@RequestParam String lastName) {
        Pageable pageable = PageRequest.of(0, 10);
        return personSortingRepository.findPersonByLastName(lastName, pageable);
    }

    //7. Реализовать метод, который возвращает все записи с несколькими сортировками (по age и lastName).
    //8. Получить записи с фильтром email LIKE %gmail.com и пагинацией.
    //9. Найти записи в возрастном диапазоне (от 20 до 40) с постраничной выборкой.
    //10 Реализовать поиск Person по имени с сортировкой и пагинацией одновременно.


    //2)  Задания для nativeQuery = true ( Можно с DTO или без)

    //SELECT (native):
    //Напиши метод репозитория c @Query(nativeQuery = true),
    //который вернёт всех Person, у кого email оканчивается на @gmail.com (используй LIKE '%@gmail.com').

    //SELECT + JOIN (native):
    //Верни список Person вместе с названием их города из таблицы cities через JOIN
    //(верни только поля person.id, person.firstName, cities.name AS cityName — маппинг в интерфейс-проекцию).

    //SELECT + агрегаты (native):
    //Верни пары (lastName, count) с количеством людей на каждую фамилию, отсортированных по count DESC.
    //(Группировка GROUP BY lastName, возврат в интерфейс-проекцию).

    //Пагинация SQL Server (native):
    //Метод с параметрами page, size, который вернёт людей по
    //ORDER BY id с использованием OFFSET :offset ROWS FETCH NEXT :size ROWS ONLY.

    //UPDATE (native @Modifying):
    //Метод репозитория @Modifying @Query(nativeQuery = true),
    //который увеличивает age на :delta у всех, у кого age < :maxAge. Верни количество обновлённых строк.

    //DELETE (native @Modifying):
    //Метод @Modifying @Query(nativeQuery = true), который удаляет всех Person,
    //у кого age < :age. Верни количество удалённых строк.

    //INSERT (native @Modifying):
    //Метод @Modifying @Query(nativeQuery = true), который вставляет новую запись в
    //таблицу persons (значения приходят из параметров метода). Проверить, что метод возвращает 1.

    //EXEC без параметров (native):
    //Создай в БД процедуру GetPersonsAbove10, возвращающую SELECT * FROM persons WHERE age > 10.
    //В репозитории сделай метод с @Query(value = "EXEC GetPersonsAbove10", nativeQuery = true) и верни List<Person>.

    //EXEC с IN-параметром (native):
    //Процедура GetPersonsAboveAge @minAge INT → SELECT * FROM persons WHERE age > @minAge.
    //В репозитории метод @Query(value = "EXEC GetPersonsAboveAge :minAge",
    //nativeQuery = true) с параметром @Param("minAge").
}
