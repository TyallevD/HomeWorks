package ru.java413.homework16.services.impl;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.java413.homework16.entities.Teacher;
import ru.java413.homework16.repositories.TeacherRepository;
import ru.java413.homework16.services.TeacherService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private Faker faker;

    @Autowired
    TeacherRepository teacherRepository;

    public void generationData(int size) {
        if (teacherRepository.count() == 0) {
            List<Teacher> people = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                String name = faker.name().firstName();
                String surname = faker.name().lastName();
                Integer age = faker.number().numberBetween(18, 100);
                people.add(new Teacher(name, surname, age));
            }
            teacherRepository.saveAll(people);
        }
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public void deleteAll() {
        teacherRepository.deleteAll();
    }

    public void deleteById(Long id) {
        teacherRepository.deleteById(id);
    }

    public List<Teacher> sortByField(String field, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(field).descending()
                : Sort.by(field).ascending();
        return teacherRepository.findAll(sort);
    }
}
