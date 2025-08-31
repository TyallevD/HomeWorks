package ru.java413.homework10.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

//3. Группы (Groups) +
//- Идентификатор (Id). Уникальный идентификатор группы. +
//Тип данных — int. +
//Авто приращение. +
//Не может содержать null-значения. +
//Первичный ключ. +

//- Название (Name). Название группы. +
//Тип данных — nvarchar(10). +
//Не может содержать null-значения. +
//Не может быть пустым. +
//Должно быть уникальным. +- //todo надо проверять

//- Рейтинг (Rating). Рейтинг группы. +
//Тип данных — int. +
//Не может содержать null-значения. +
//Должно быть в диапазоне от 0 до 5. +

//- Курс (Year). Курс (год) на котором обучается группа. +
//Тип данных — int. +
//Не может содержать null-значения. +
//Должно быть в диапазоне от 1 до 5. +

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true, columnDefinition = "NVARCHAR(10)")
    @NotBlank
    @NotEmpty
    private String name;

    @Column(name = "rating", nullable = false)
    @Range(min = 0, max = 5)
    private int rating;


    @Column(name = "year", nullable = false)
    @Range(min = 1, max = 5)
    private int year;
}
