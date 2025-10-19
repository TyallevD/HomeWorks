package ru.java413.homework24.DTO;

import ru.java413.homework24.entity.NoteUser;

public class UserRegistrationDTO {
    private Long id;
    private String username;
    private String password;
    private String fullname;
    private String role;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullname() {
        return fullname;
    }

    public String getRole() {
        return role;
    }

    private static UserRegistrationDTO fromEntity(NoteUser noteUser) {
        UserRegistrationDTO dto = new UserRegistrationDTO();
        dto.id = noteUser.getId();
        dto.username = noteUser.getUsername();
        dto.password = noteUser.getPassword();
        dto.fullname = noteUser.getFullName();
        dto.role = noteUser.getRole();

        return dto;
    }

    public static NoteUser toEntity(UserRegistrationDTO dto) {
        NoteUser user = new NoteUser();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setFullName(dto.getFullname());
        user.setRole(dto.getRole());

        return user;
    }
}
