package ru.java413.homework24.DTO;

import ru.java413.homework24.entity.NoteUser;

public class UserDTO {
    private Long id;
    private String username;
    private String fullName;
    private String role;

    public String getRole() {
        return role;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public static UserDTO fromEntity(NoteUser noteUser) {
        UserDTO dto = new UserDTO();
        dto.id = noteUser.getId();
        dto.username = noteUser.getUsername();
        dto.fullName = noteUser.getFullName();
        dto.role = noteUser.getRole();

        return dto;
    }
}
