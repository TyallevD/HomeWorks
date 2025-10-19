package ru.java413.homework24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.java413.homework24.entity.Note;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByAuthorUsernameOrderByCreatedAtDesc(String username);
}
