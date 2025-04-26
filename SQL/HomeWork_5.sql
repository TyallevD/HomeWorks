--DROP DATABASE University;
CREATE DATABASE University
GO
USE University

--Таблицы
--1. Кураторы (Curators)
--- Идентификатор (Id). Уникальный идентификатор куратора.
--Тип данных — int.
--Авто приращение.
--Не может содержать null-значения.
--Первичный ключ.
--- Имя (Name).
--Имя куратора. Тип данных — nvarchar(max).
--Не может содержать null-значения.
--Не может быть пустым.
--- Фамилия (Surname). Фамилия куратора.
--Тип данных — nvarchar(max).
--Не может содержать null-значения.
--Не может быть пустым.
CREATE TABLE Curators
(
id INT PRIMARY KEY IDENTITY,
name NVARCHAR(30) NOT NULL,
surname NVARCHAR(30) NOT NULL
);

--2. Кафедры (Departments)
--- Идентификатор (Id). Уникальный идентификатор кафедры.
--Тип данных — int.
--Авто приращение.
--Не может содержать null-значения.
--Первичный ключ.
--- Финансирование (Financing). Фонд финансирования кафедры.
--Тип данных — money.
--Не может содержать null-значения.
--Не может быть меньше 0.
--Значение по умолчанию — 0.
--- Название (Name). Название кафедры.
-- 	Тип данных — nvarchar(100).
--Не может содержать null-значения.
--Не может быть пустым.
--Должно быть уникальным.
--- Идентификатор факультета (FacultyId). Факультет, в состав которого входит кафедра.
--Тип данных — int.
--Не может содержать null-значения.
--Внешний ключ.
CREATE TABLE Departments
(
id INT PRIMARY KEY IDENTITY,
financing MONEY NOT NULL DEFAULT(0),
name NVARCHAR(100) NOT NULL UNIQUE,
faculty_id INT NOT NULL,

CONSTRAINT CK_Departments_financing CHECK(financing>=0),
CONSTRAINT FK_Departments_Faculties FOREIGN KEY (faculty_id)
REFERENCES Faculties(id)
);

--3. Факультеты (Faculties)
--- Идентификатор (Id). Уникальный идентификатор факультета.
--Тип данных — int.
--Авто приращение.
--Не может содержать null-значения.
--Первичный ключ.
--- Финансирование (Financing). Фонд финансирования факультета.
--Тип данных — money.
--Не может содержать null-значения.
--Не может быть меньше 0.
--Значение по умолчанию — 0.
--- Название (Name). Название факультета.
--Тип данных — nvarchar(100).
--Не может содержать null-значения.
--Не может быть пустым.
--Должно быть уникальным.
CREATE TABLE Faculties
(
id INT PRIMARY KEY IDENTITY,
financing MONEY NOT NULL DEFAULT(0),
name NVARCHAR(100) NOT NULL UNIQUE,

CONSTRAINT CK_Faculties_financing CHECK(financing>=0)
);

--4. Группы (Groups)
--- Идентификатор (Id). Уникальный идентификатор группы.
--Тип данных — int.
--Авто приращение.
--Не может содержать null-значения.
--Первичный ключ.
--- Название (Name). Название группы.
--Тип данных — nvarchar(10).
--Не может содержать null-значения.
--Не может быть пустым.
--Должно быть уникальным.
--- Курс (Year). Курс (год) на котором обучается группа.
--Тип данных — int.
--Не может содержать null-значения.
--Должно быть в диапазоне от 1 до 5.
--- Идентификатор кафедры (DepartmentId). Кафедра, в состав которой входит группа.
--Тип данных — int.
--Не может содержать null-значения.
--Внешний ключ.
CREATE TABLE Groups
(
id INT PRIMARY KEY IDENTITY,
name NVARCHAR(10) NOT NULL UNIQUE,
year INT NOT NULL,
department_id INT NOT NULL,

CONSTRAINT CK_Groups_year CHECK(year BETWEEN 1 and 5),
CONSTRAINT FK_Groups_Departments FOREIGN KEY(department_id)
REFERENCES Departments(id)
);

--5. Группы и кураторы (GroupsCurators)
--- Идентификатор (Id). Уникальный идентификатор группы и куратора.
--Тип данных — int.
--Авто приращение.
--Не может содержать null-значения.
--Первичный ключ.
--- Идентификатор куратора (CuratorId). Куратор.
--Тип данных — int.
--Не может содержать null-значения.
--Внешний ключ.
--- Идентификатор группы (GroupId). Группа.
--Тип данных — int.
--Не может содержать null-значения.
--Внешний ключ.
CREATE TABLE GroupsCurators
(
id INT PRIMARY KEY IDENTITY,
curator_id INT NOT NULL,
group_id INT NOT NULL,

CONSTRAINT FK_GroupsC_Curators FOREIGN KEY(curator_id)
REFERENCES Curators(id),
CONSTRAINT FK_GroupsC_Groups FOREIGN KEY(group_id)
REFERENCES Groups(id)
);

--6. Группы и лекции (GroupsLectures)
--- Идентификатор (Id). Уникальный идентификатор группы и лекции.
--Тип данных — int.
--Авто приращение.
--Не может содержать null-значения.
--Первичный ключ.
--- Идентификатор группы (GroupId). Группа.
--Тип данных — int.
--Не может содержать null-значения.
--Внешний ключ.
--- Идентификатор лекции (LectureId). Лекция.
--Тип данных — int.
--Не может содержать null-значения.
--Внешний ключ.
CREATE TABLE GroupsLectures
(
id INT PRIMARY KEY IDENTITY,
group_id INT NOT NULL,
lecture_id INT NOT NULL,

CONSTRAINT FK_GroupsL_Groups FOREIGN KEY (group_id)
REFERENCES Groups(id),
CONSTRAINT FK_GroupsL_Lectures FOREIGN KEY (lecture_id)
REFERENCES Lectures(id)
);

--7. Лекции (Lectures)
--- Идентификатор (Id). Уникальный идентификатор лекции.
--Тип данных — int.
--Авто приращение.
--Не может содержать null-значения.
--Первичный ключ.
--- Аудитория (LectureRoom). Аудитория в которой читается лекция.
--Тип данных — nvarchar(max).
--Не может содержать null-значения.
--Не может быть пустым.
--- Идентификатор дисциплины (SubjectId). Дисциплина, по которой читается лекция.
--Тип данных — int.
--Не может содержать null-значения.
--Внешний ключ.
--- Идентификатор преподавателя (TeacherId). Преподаватель, который читает лекцию.
--Тип данных — int.
--Не может содержать null-значения.
--Внешний ключ.
CREATE TABLE Lectures
(
id INT PRIMARY KEY IDENTITY,
lecture_room NVARCHAR(30) NOT NULL,
subject_id INT NOT NULL,
teacher_id INT NOT NULL,

CONSTRAINT FK_Lectures_Subjects FOREIGN KEY (subject_id)
REFERENCES Subjects(id),
CONSTRAINT FK_Lectures_Teachers FOREIGN KEY (teacher_id)
REFERENCES Teachers(id)
);

--8. Дисциплины (Subjects)
--- Идентификатор (Id). Уникальный идентификатор дисциплины.
--Тип данных — int.
--Авто приращение.
--Не может содержать null-значения.
--Первичный ключ.
--- Название (Name). Название дисциплины.
--Тип данных — nvarchar(100).
--Не может содержать null-значения.
--Не может быть пустым.
--Должно быть уникальным.
CREATE TABLE Subjects
(
id INT PRIMARY KEY IDENTITY,
name NVARCHAR(100) NOT NULL UNIQUE
);

--9. Преподаватели (Teachers)
--- Идентификатор (Id). Уникальный идентификатор преподавателя.
--Тип данных — int.
--Авто приращение.
--Не может содержать null-значения.
--Первичный ключ.
--- Имя (Name). Имя преподавателя.
--Тип данных — nvarchar(max).
--Не может содержать null-значения.
--Не может быть пустым.
--- Ставка (Salary). Ставка преподавателя.
--Тип данных — money.
--Не может содержать null-значения.
--Не может быть меньше либо равно 0.
--- Фамилия (Surname). Фамилия преподавателя.
--Тип данных — nvarchar(max).
--Не может содержать null-значения.
--Не может быть пустым.
CREATE TABLE Teachers
(
id INT PRIMARY KEY IDENTITY,
name NVARCHAR(50) NOT NULL,
surname NVARCHAR(50) NOT NULL,
salary MONEY NOT NULL,

CONSTRAINT CK_Teachers_salary CHECK(salary>0)
);

--Запросы
--1. Вывести все возможные пары строк преподавателей и групп.
--2. Вывести названия факультетов, фонд финансирования кафедр которых превышает фонд финансирования факультета.
--3. Вывести фамилии кураторов групп и названия групп, которые они курируют.
--4. Вывести имена и фамилии преподавателей, которые читают лекции у группы “P107”.
--5. Вывести фамилии преподавателей и названия факультетов на которых они читают лекции.
--6. Вывести названия кафедр и названия групп, которые к ним относятся.
--7. Вывести названия дисциплин, которые читает преподаватель “Samantha Adams”.
--8. Вывести названия кафедр, на которых читается дисциплина “Database Theory”.
--9. Вывести названия групп, которые относятся к факультету “Computer Science”.
--10. Вывести названия групп 5-го курса, а также название факультетов, к которым они относятся.
--11. Вывести полные имена преподавателей и лекции, которые они читают (названия дисциплин и групп), причем отобрать только те лекции, которые читаются в аудитории “B103”.
