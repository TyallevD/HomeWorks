package ru.java413.homework10.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

//2. Факультеты (Faculties)
//- Идентификатор (Id). Уникальный идентификатор факультета. +
//Тип данных — int. +
//Авто приращение. +
//Не может содержать null-значения. +
//Первичный ключ. +

//- Декан (Dean). Декан факультета. +
//Тип данных — nvarchar(max). +
//Не может содержать null-значения. +
//Не может быть пустым. +

//- Название (Name). Название факультета. +
//Тип данных — nvarchar(100). +
//Не может содержать null-значения. +
//Не может быть пустым. +
//Должно быть уникальным. +- //todo надо проверять

@Entity
@Table(name = "faculties")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotBlank
    @Column(name = "dean", columnDefinition = "NVARCHAR(MAX)")
    private String dean;

    @NotEmpty
    @NotBlank
    @Column(name = "name", unique = true, columnDefinition = "NVARCHAR(100)")
    private String name;
}
