package ru.java413.homework24.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.java413.homework24.DTO.NoteDTO;
import ru.java413.homework24.entity.Note;
import ru.java413.homework24.entity.NoteUser;
import ru.java413.homework24.repository.NoteRepository;
import ru.java413.homework24.repository.UserRepository;
import ru.java413.homework24.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NoteRepository noteRepository;

    //
    public List<Note> getUserNotes(String username) {
        return noteRepository.findByAuthorUsernameOrderByCreatedAtDesc(username);
    }


    public Note createNote(NoteDTO noteDTO, String username) {
//        User author = userRepository.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

        NoteUser author = userRepository.findByUsername(username);
//                .orElseThrow(() -> new RuntimeException("User not found"));

        Note note = NoteDTO.toEntity(noteDTO, author);

        return noteRepository.save(note);
    }

    public Optional<Note> openNote(Long id) {
        return noteRepository.findById(id);
    }

    public Boolean deleteNote(Long id) {
        if (noteRepository.findById(id).isPresent()) {
            noteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
