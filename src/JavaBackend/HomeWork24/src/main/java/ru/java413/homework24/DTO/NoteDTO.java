package ru.java413.homework24.DTO;

import ru.java413.homework24.entity.Note;
import ru.java413.homework24.entity.NoteUser;

import java.time.LocalDateTime;

public class NoteDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String authorUsername;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public static NoteDTO fromEntity(Note note) {
        NoteDTO dto = new NoteDTO();
        dto.id = note.getId();
        dto.title = note.getTitle();
        dto.content = note.getContent();
        dto.createdAt = note.getCreatedAt();
        dto.authorUsername = note.getAuthor().getUsername();
        return dto;
    }

    public static Note toEntity(NoteDTO dto, NoteUser author) {
        Note note = new Note();
        note.setTitle(dto.title);
        note.setContent(dto.content);
        note.setCreatedAt(LocalDateTime.now());
        note.setAuthor(author);
        return note;
    }
}
