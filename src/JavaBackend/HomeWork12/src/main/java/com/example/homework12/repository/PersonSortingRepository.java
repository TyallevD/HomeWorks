package com.example.homework12.repository;

import com.example.homework12.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonSortingRepository extends JpaRepository<Person, Long> {
    Page<Person> findPersonByAgeAfter(Integer age, Pageable pageable);

    Page<Person> findPersonByLastName(String lastName, Pageable pageable);
}
