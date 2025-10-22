package ru.java413.homework16.DTOs;

public class TeacherDTO {
    private Long id;
    private String name;
    private String surname;
    private Integer age;

    public TeacherDTO(Long id, String name, String surname, Integer age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }
}
