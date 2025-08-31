package ru.java413.homework10.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;


//Таблицы
//1. Кафедры (Departments) +
//- Идентификатор (Id). Уникальный идентификатор кафедры. +
//Тип данных — int. +
//Авто приращение. +
//Не может содержать null-значения. +
//Первичный ключ +

//- Финансирование (Financing). Фонд финансирования кафедры. +
//Тип данных — money.  +
//Не может содержать null-значения. +
//Не может быть меньше 0. +
//Значение по умолчанию — 0. +

//- Название (Name). Название кафедры.  +
//Тип данных — nvarchar(100).  +
//Не может содержать null-значения. +
//Не может быть пустым. +
//Должно быть уникальным. +- //todo надо проверять

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "financing", nullable = false, columnDefinition = "MONEY DEFAULT 0")
    @Range(min = 0)
    private Double financing;

    @NotEmpty
    @NotBlank
    @Column(name = "name", unique = true, columnDefinition = "NVARCHAR(100)")
    private String name;
}
