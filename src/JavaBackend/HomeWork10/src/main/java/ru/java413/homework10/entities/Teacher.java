package ru.java413.homework10.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

//4. Преподаватели (Teachers) +
//- Идентификатор (Id). Уникальный идентификатор преподавателя. +
//Тип данных — int.
//Авто приращение. +
//Не может содержать null-значения. +
//Первичный ключ. +

//- Дата трудоустройства (EmploymentDate). Дата приема преподавателя на работу. - //todo надо разобраться с датой
//Тип данных — date. ▷ Не может содержать null-значения.
//Не может быть меньше 01.01.1990.

//- Ассистент (IsAssistant). Является ли преподаватель ассистентом. +
//Тип данных — bit.
//Не может содержать null-значения.
//Значение по умолчанию — 0.

//- Профессор (IsProfessor). Является ли преподаватель профессором. +
//Тип данных — bit.
//Не может содержать null-значения.
//Значение по умолчанию — 0.

//- Имя (Name). Имя преподавателя. +
//Тип данных — nvarchar(max). +
//Не может содержать null-значения. +
//Не может быть пустым. +

//- Фамилия (Surname). Фамилия преподавателя. +
//Тип данных — nvarchar(max). +
//Не может содержать null-значения. +
//Не может быть пустым. +

//- Должность (Position). Должность преподавателя. +
//Тип данных — nvarchar(max). +
//Не может содержать null-значения. +
//Не может быть пустым. +

//- Надбавка (Premium). Надбавка преподавателя. +
//Тип данных — money. +
//Не может содержать null-значения +
//Не может быть меньше 0. +
//Значение по умолчанию — 0. +

//- Ставка (Salary). Ставка преподавателя.
//Тип данных — money. +
//Не может содержать null-значения. +
//Не может быть меньше либо равно 0. +- //todo поставил больше либо равно 1, но возможно есть вариант получше

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //todo
//    @Column(name = "employment_date", nullable = false)
//    @Range(min = 1990)
//    private LocalDate employmentDate;

    @Column(name = "is_assistant", nullable = false, columnDefinition = "BIT DEFAULT 0")
    private Byte isAssistant;

    @Column(name = "is_professor", nullable = false, columnDefinition = "BIT DEFAULT 0")
    private Byte isProfessor;

    @NotEmpty
    @NotBlank
    @Column(name = "name", columnDefinition = "NVARCHAR(MAX)")
    private String name;

    @NotEmpty
    @NotBlank
    @Column(name = "surname", columnDefinition = "NVARCHAR(MAX)")
    private String surname;

    @NotEmpty
    @NotBlank
    @Column(name = "position", columnDefinition = "NVARCHAR(MAX)")
    private String position;


    @Column(name = "premium", nullable = false, columnDefinition = "MONEY DEFAULT 0")
    @Range(min = 0)
    private Double premium;

    @Column(name = "salary", nullable = false, columnDefinition = "MONEY")
    @Range(min = 1)
    private Double salary;
}