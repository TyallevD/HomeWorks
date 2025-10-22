package ru.java413.homework16.services;

import ru.java413.homework16.DTOs.TeacherDTO;

import java.util.List;

public interface TeacherService {
    List<TeacherDTO> findAll();

    void generationData(int i);

    void deleteAll();

    void deleteById(Long id);

    List<TeacherDTO> sortByField(String field, String direction);

}
