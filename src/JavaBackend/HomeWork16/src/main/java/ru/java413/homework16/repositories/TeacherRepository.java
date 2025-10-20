package ru.java413.homework16.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.java413.homework16.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
