package ru.java413.homework24.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.java413.homework24.DTO.NoteDTO;
import ru.java413.homework24.entity.Note;
import ru.java413.homework24.service.Impl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/main")
public class MainController {
    @Autowired
    UserServiceImpl userService;


    //todo доработать ответы
    @GetMapping("/")
    public ResponseEntity<List<Note>> findUserNotes(@RequestParam String username) {
        return ResponseEntity.ok(userService.getUserNotes(username));
    }

    //todo доработать ответы
    @PostMapping("/")
    public ResponseEntity<Note> createNote(
            @RequestBody NoteDTO noteDTO,
            @RequestParam String username) {
        return ResponseEntity.ok(userService.createNote(noteDTO, username));
    }
}
