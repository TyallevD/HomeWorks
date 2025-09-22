package ru.java413.homework11.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.java413.homework11.entities.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
