package ru.java413.homework24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.java413.homework24.entity.NoteUser;

public interface UserRepository extends JpaRepository<NoteUser, Long> {
    NoteUser findByUsername(String username);
}
