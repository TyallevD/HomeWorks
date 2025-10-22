package ru.java413.homework16.services.impl;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.java413.homework16.DTOs.TeacherDTO;
import ru.java413.homework16.entities.Teacher;
import ru.java413.homework16.repositories.TeacherRepository;
import ru.java413.homework16.services.TeacherService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<TeacherDTO> findAll() {
        return teacherRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    public void deleteAll() {
        teacherRepository.deleteAll();
    }

    public void deleteById(Long id) {
        teacherRepository.deleteById(id);
    }

//    public List<TeacherDTO> sortByField(String field, String direction) {
//        Sort sort = direction.equalsIgnoreCase("desc")
//                ? Sort.by(field).descending()
//                : Sort.by(field).ascending();
//        return teacherRepository.findAll(sort)
//                .stream()
//                .map(this::entityToDto)
//                .collect(Collectors.toList());
//    }

    //альтернативная сортировка через DTO, а не через Entity
    public List<TeacherDTO> sortByField(String field, String direction) {
        List<TeacherDTO> teacherDTOS = teacherRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .toList();

        Comparator<TeacherDTO> comparator = getComparator(field);
        if ("desc".equalsIgnoreCase(direction)) {
            comparator = comparator.reversed();
        }

        return teacherDTOS.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    private Comparator<TeacherDTO> getComparator(String field) {
        return switch (field) {
            case "name" -> Comparator.comparing(TeacherDTO::getName);
            case "surname" -> Comparator.comparing(TeacherDTO::getSurname);
            case "age" -> Comparator.comparing(TeacherDTO::getAge);
            default -> Comparator.comparing(TeacherDTO::getId);
        };
    }

    public TeacherDTO entityToDto(Teacher teacher) {
        return new TeacherDTO(
                teacher.getId(),
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getAge()
        );
    }
}
