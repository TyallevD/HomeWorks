package com.example.homework12.repository;

import com.example.homework12.entities.Person;
import com.example.homework12.projection.LastNameCountProjection;
import com.example.homework12.projection.PersonCitiesProjection;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Page<Person> findPersonByAgeAfter(Integer ageAfter, Pageable pageable);

    Page<Person> findPersonByLastName(String lastName, Pageable pageable);

    Page<Person> findPersonByEmailContaining(String s, Pageable pageable);

    Page<Person> findPersonByAgeBetween(Integer ageAfter, Integer ageBefore, Pageable pageable);

    Page<Person> findPersonByFirstNameContains(String firstName, Pageable pageable);

    //2.1
    @Query(value = " SELECT * FROM person WHERE email LIKE '%@gmail.com' ", nativeQuery = true)
    List<Person> selectPersonsByGmail();

    //2.2
    @Query(value = " SELECT person.id, person.first_name, city.name AS cityName FROM person JOIN city ON city.id = person.city_id ", nativeQuery = true)
    List<PersonCitiesProjection> selectPersonsWithCities();

    //2.3
    @Query(value = " SELECT person.last_name, COUNT(last_name) as Count FROM person GROUP BY last_name ", nativeQuery = true)
    List<LastNameCountProjection> selectLastNamesAndCount();

    //2.4
    @Query(value = " SELECT * FROM person ORDER BY id OFFSET :page ROWS FETCH NEXT :size ROWS ONLY ", nativeQuery = true)
    List<Person> selectPersonsWithPagination(int page, int size);

    //2.5
    @Modifying
    @Transactional
    @Query(value = " UPDATE person SET age = (age + :delta) WHERE age < :maxAge ", nativeQuery = true)
    Integer updatePersonsAge(int delta, int maxAge);

    //2.6
    @Modifying
    @Transactional
    @Query(value = " DELETE FROM person WHERE age < :age ", nativeQuery = true)
    Integer deletePersonByAgeBefore(int age);

    //2.7
    @Modifying
    @Transactional
    @Query(value = " INSERT INTO person(first_name, last_name, age, email) VALUES (:firstname, :lastname, :age, :email) ", nativeQuery = true)
    Integer insertPerson(String firstname, String lastname,int age, String email); //todo проверить ещё...

    //2.8
    @Query(value = " exec GetPersonsAbove10 ", nativeQuery = true)
    List<Person> executeGetPersonsAboveTen();

    //2.9
    @Query(value = " exec GetPersonsAboveAge :minAge", nativeQuery = true)
    List<Person> executeGetPersonAboveAge(int minAge);
}
