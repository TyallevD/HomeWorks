package ru.java413.homework16.services;

import ru.java413.homework16.entities.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();

    void generationData(int i);

    void deleteAll();

    void deleteById(Long id);

    List<Teacher> sortByField(String field, String direction);

}
