package com.example.homework12.controllers;

import com.example.homework12.entities.Person;
import com.example.homework12.projection.LastNameCountProjection;
import com.example.homework12.projection.PersonCitiesProjection;
import com.example.homework12.services.CityService;
import com.example.homework12.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    private PersonService personService;

    @Autowired
    private CityService cityService;

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
        return personService.findAllAndSortByFirstNameAsc();
    }

    //2. Получить все записи с сортировкой по age по убыванию.
    //curl -L -X GET "http://127.0.0.1:8080/main/ageDesc"
    @GetMapping("/ageDesc")
    public List<Person> sortByAgeDesc() {
        return personService.findAllAndSortByAgeDesc();
    }

    //3. Вернуть первую страницу (по 5 элементов) с сортировкой по id.
    //curl -L -X GET "http://127.0.0.1:8080/main/getFirstPageSortById"
    @GetMapping("/getFirstPageSortById")
    public Page<Person> getFirstPageSortById() {
        return personService.findAllByPageAndSortById();
    }

    //4. Вернуть вторую страницу (по 10 элементов) с сортировкой по lastName.
    //curl -L -X GET "http://127.0.0.1:8080/main/getSecondPage"
    @GetMapping("/getSecondPage")
    public Page<Person> getSecondPage() {
        return personService.findAllBySecondPageAndSortByLastName();
    }

    //5. Найти записи Person, у которых возраст больше 18 лет, с пагинацией.
    //curl -L -X GET "http://127.0.0.1:8080/main/above18"
    @GetMapping("/above18")
    public Page<Person> getPersonAboveEighteen() {
        return personService.findPersonAboveEighteen();
    }

    //6. Найти записи Person по lastName, возвращая только первую страницу.
    //curl -L -X GET "http://127.0.0.1:8080/main/getByLastName1?lastName=<фамилия>"
    @GetMapping("/getByLastName1")
    public Page<Person> getPersonByLastName(@RequestParam String lastName) {
        return personService.findFirstPageByLastname(lastName);
    }

    //7. Реализовать метод, который возвращает все записи с несколькими сортировками (по age и lastName).
    //todo надо доделать сортировку (или проверить)
    @GetMapping("/getSortedByAgeAndLastName")
    public List<Person> getSortedPersonByAgeAndLastName(
            @RequestParam Integer age,
            @RequestParam String lastName
    ) {
        return personService.findSortedPersonByAgeAndLastName(age, lastName);
    }

    //8. Получить записи с фильтром email LIKE %gmail.com и пагинацией.
    //curl -L "http://127.0.0.1:8080/main/getByGmail"
    @GetMapping("/getByGmail")
    public Page<Person> getByGmail() {
        return personService.findAllByGmail();
    }

    //9. Найти записи в возрастном диапазоне (от 20 до 40) с постраничной выборкой.
    //curl -L "http://127.0.0.1:8080/main/getPersonsByAgeBetween20And40?page=1"
    @GetMapping("/getPersonsByAgeBetween20And40")
    public Page<Person> getPersonsByAgeBetween(
            @RequestParam int page
    ) {
        return personService.findPersonsByAgeBetween(page);
    }

    //10 Реализовать поиск Person по имени с сортировкой и пагинацией одновременно.
    //curl -L "http://127.0.0.1:8080/main/getSortedPersonByName?name=da&sort=desc"
    //curl -L "http://127.0.0.1:8080/main/getSortedPersonByName?name=da&sort=asc"
    @GetMapping("/getSortedPersonByName")
    public Page<Person> getSortedPersonByName(
            @RequestParam String name,
            @RequestParam String sort
    ) {
        return personService.findSortedPersonByName(name, sort);
    }

    //2) Задания для nativeQuery = true ( Можно с DTO или без)
    //1.SELECT (native):
    //Напиши метод репозитория c @Query(nativeQuery = true),
    //который вернёт всех Person, у кого email оканчивается на @gmail.com (используй LIKE '%@gmail.com').
    //curl -L "http://127.0.0.1:8080/main/nativeGmail"
    @GetMapping("/nativeGmail")
    public List<Person> getNativeGmail() {
        return personService.findPersonsByGmail();
    }

    //todo запрос работает, но нужно разобраться как сразу заполнить 2 таблицы со связкой (первым города, потом людей)
    //2.SELECT + JOIN (native):
    //Верни список Person вместе с названием их города из таблицы cities через JOIN
    //(верни только поля person.id, person.firstName, cities.name AS cityName — маппинг в интерфейс-проекцию).
    //curl -L "http://127.0.0.1:8080/main/nativePersonsWithCities"
    @GetMapping("/nativePersonsWithCities")
    public List<PersonCitiesProjection> getNativePersonsWithCities() {
        return personService.findPersonsWithCities();
    }

    //3.SELECT + агрегаты (native):
    //Верни пары (lastName, count) с количеством людей на каждую фамилию, отсортированных по count DESC.
    //(Группировка GROUP BY lastName, возврат в интерфейс-проекцию).
    //curl -L "http://127.0.0.1:8080/main/nativeLastNamesAndCount"
    @GetMapping("/nativeLastNamesAndCount")
    public List<LastNameCountProjection> getNativeLastNamesAndCount() {
        return personService.findLastNamesAndCount();
    }

    //4.Пагинация SQL Server (native):
    //Метод с параметрами page, size, который вернёт людей по
    //ORDER BY id с использованием OFFSET :offset ROWS FETCH NEXT :size ROWS ONLY.
    //curl -L "http://127.0.0.1:8080/main/nativePersonsWithPagination?page=0&size=3"
    @GetMapping("/nativePersonsWithPagination")
    public List<Person> getNativePersonsWithPagination(
            @RequestParam int page,
            @RequestParam int size
    ) {
        return personService.findPersonsWithPagination(page, size);
    }

    //5.UPDATE (native @Modifying):
    //Метод репозитория @Modifying @Query(nativeQuery = true),
    //который увеличивает age на :delta у всех, у кого age < :maxAge. Верни количество обновлённых строк.
    //curl -L -X PUT "http://127.0.0.1:8080/main/nativeUpdatePersonAge?delta=2&maxAge=33"
    @PutMapping("/nativeUpdatePersonAge")
    public Integer updatePersonAge(
            @RequestParam Integer delta,
            @RequestParam Integer maxAge) {
        return personService.updatePersonsAge(delta, maxAge);
    }

    //6.DELETE (native @Modifying):
    //Метод @Modifying @Query(nativeQuery = true), который удаляет всех Person,
    //у кого age < :age. Верни количество удалённых строк.
    //curl -L -X DELETE "http://127.0.0.1:8080/main/deletePersonByAge?age=25"
    @DeleteMapping("/deletePersonByAge")
    public Integer deletePersonByAge(@RequestParam Integer age) {
        return personService.deletePersonsByAge(age);
    }

    //7.INSERT (native @Modifying):
    //Метод @Modifying @Query(nativeQuery = true), который вставляет новую запись в
    //таблицу persons (значения приходят из параметров метода). Проверить, что метод возвращает 1.
    //http://127.0.0.1:8080/main/createNewPerson
    //{
    //    "firstName": "Dmitry",
    //    "lastName": "Tyallev",
    //    "age": 35,
    //    "email": "wow.friesen@hotmail.com"
    //}
    @PostMapping("/createNewPerson")
    public Integer createNewPerson(
            @RequestBody Person person) {
        return personService.insertPerson(person);
    }

    //8.EXEC без параметров (native):
    //Создай в БД процедуру GetPersonsAbove10, возвращающую SELECT * FROM persons WHERE age > 10.
    //В репозитории сделай метод с @Query(value = "EXEC GetPersonsAbove10", nativeQuery = true) и верни List<Person>.
    //CREATE PROCEDURE GetPersonsAbove10
    //AS
    //BEGIN
    //	SELECT * FROM person WHERE age > 10
    //END
    //curl -L "http://127.0.0.1:8080/main/execPersonsAboveTen"
    @GetMapping("/execPersonsAboveTen")
    public List<Person> execPersonsAboveTen() {
        return personService.findPersonAboveTen();
    }

    //9.EXEC с IN-параметром (native):
    //Процедура GetPersonsAboveAge @minAge INT → SELECT * FROM persons WHERE age > @minAge.
    //В репозитории метод @Query(value = "EXEC GetPersonsAboveAge :minAge",
    //nativeQuery = true) с параметром @Param("minAge").
    //CREATE PROCEDURE GetPersonsAboveAge
    //@minAge INT
    //AS
    //BEGIN
    //	SELECT * FROM person WHERE age > @minAge
    //END
    //curl -L "http://127.0.0.1:8080/main/execPersonsAboveAge?minAge=81"
    @GetMapping("/execPersonsAboveAge")
    public List<Person> execPersonsAboveAge(@RequestParam Integer minAge) {
        return personService.findPersonAboveAge(minAge);
    }
}
