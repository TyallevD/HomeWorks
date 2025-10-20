package ru.java413.homework24.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.java413.homework24.DTO.NoteDTO;
import ru.java413.homework24.DTO.UserRegistrationDTO;
import ru.java413.homework24.entity.Note;
import ru.java413.homework24.entity.NoteUser;
import ru.java413.homework24.service.Impl.RegistryServiceImpl;
import ru.java413.homework24.service.Impl.UserServiceImpl;

import java.util.List;
import java.util.Optional;

//@RestController
@Controller
@RequestMapping("/main")
public class MainController {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    RegistryServiceImpl registryService;

    @GetMapping
    public String homePage(Model model) {
        return "index";
    }

    //todo доработать ответы
    @GetMapping("/")
    public ResponseEntity<List<Note>> findUserNotes(@RequestParam String username) {
        return ResponseEntity.ok(userService.getUserNotes(username));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Note>> openNote(@PathVariable Long id) {
        return ResponseEntity.ok(userService.openNote(id));
    }

    //todo доработать ответы
    @PostMapping("/")
    public ResponseEntity<Note> createNote(
            @RequestBody NoteDTO noteDTO,
            @RequestParam String username) {
        return ResponseEntity.ok(userService.createNote(noteDTO, username));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteNote(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteNote(id));
    }

    @GetMapping("/registry")
    public String registryPage(Model model){
        return "registry";
    }
//    public ResponseEntity<NoteUser> registryNewUser(@RequestBody UserRegistrationDTO user) {
//        return ResponseEntity.ok(registryService.createNewUser(user));
//    }
}
