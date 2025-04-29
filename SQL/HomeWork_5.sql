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

CONSTRAINT CK_Departments_financing CHECK(financing>=0)
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

CONSTRAINT CK_Groups_year CHECK(year BETWEEN 1 and 5)
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
group_id INT NOT NULL
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
lecture_id INT NOT NULL
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
teacher_id INT NOT NULL
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

ALTER TABLE Departments
ADD CONSTRAINT FK_Departments_Faculties FOREIGN KEY (faculty_id)
REFERENCES Faculties(id);

ALTER TABLE Groups
ADD CONSTRAINT FK_Groups_Departments FOREIGN KEY(department_id)
REFERENCES Departments(id);

ALTER TABLE GroupsCurators
ADD CONSTRAINT FK_GroupsC_Curators FOREIGN KEY(curator_id)
REFERENCES Curators(id),
CONSTRAINT FK_GroupsC_Groups FOREIGN KEY(group_id)
REFERENCES Groups(id);

ALTER TABLE GroupsLectures
ADD CONSTRAINT FK_GroupsL_Groups FOREIGN KEY (group_id)
REFERENCES Groups(id),
CONSTRAINT FK_GroupsL_Lectures FOREIGN KEY (lecture_id)
REFERENCES Lectures(id);

ALTER TABLE Lectures
ADD CONSTRAINT FK_Lectures_Subjects FOREIGN KEY (subject_id)
REFERENCES Subjects(id),
CONSTRAINT FK_Lectures_Teachers FOREIGN KEY (teacher_id)
REFERENCES Teachers(id);
--=========================================================================================================
--Добавление данных
INSERT INTO Faculties (financing, name)
VALUES	(1000.00,'Радиоприборостроение'),
		(1500.00,'Машиностроение'),
		(2000.00,'ЭВМ');

INSERT INTO Departments (financing, name, faculty_id)
VALUES	(1250.00,'Физика',1),
		(1300.00,'Высшая математика',3),
		(500.00,'Иностранные языки',3),
		(750.00,'Материаловедение',2),
		(500.00,'Химия',1),
		(300.00,'Физическая культура',2);

INSERT INTO Subjects (name)
VALUES	('Классическая механика'),
		('Электромагнетизм'),
		('Термодинамика'),
		('Математический анализ'),
		('Линейная алгебра'),
		('Геометрия'),
		('Английский язык'),
		('Французский язык'),
		('Немецкий язык'),
		('Сопротивление материалов'),
		('Металлургия'),
		('Органическая химия'),
		('Неорганическая химия'),
		('Валеология'),
		('Физическая подготовка');

INSERT INTO Teachers (name,surname,salary)
VALUES	('Oran', 'Stronough', 82.46),
		('Gibbie', 'Beamond', 77.41),
		('Peggi', 'Spears', 112.55),
		('Margo', 'Edmonds', 173.30),
		('Gregoire', 'Delamar', 132.54),
		('Barny', 'Crutchley', 29.74),
		('Amandy', 'Cridlon', 136.87),
		('Cherry', 'Dalliwatr', 81.89),
		('Peria', 'Aslen', 85.85),
		('Thornton', 'Leasor', 71.83),
		('Bastien', 'Eyton', 63.93),
		('Bobbee', 'Speir', 148.72),
		('Kiah', 'Pauncefort', 125.43),
		('Sandro', 'Agge', 67.06),
		('Gladys', 'Capenor', 44.49),
		('Larine', 'Jest', 97.88),
		('Leighton', 'Rowsell', 50.38),
		('Archy', 'Oxtaby', 22.69),
		('Veriee', 'St Pierre', 125.35),
		('Cece', 'Rosbotham', 56.98),
		('Nicolea', 'Dovidian', 126.17),
		('Corrinne', 'Muck', 76.61),
		('Selina', 'Antusch', 50.61),
		('Arri', 'Wandrach', 17.53),
		('Joaquin', 'Gullan', 67.22),
		('Aubrey', 'Lohde', 95.55),
		('Philly', 'Casemore', 36.10),
		('Rita', 'Jacop', 157.45),
		('Ralf', 'Biever', 31.75),
		('Ranique', 'Kimpton', 28.30);

INSERT INTO Groups (name, year, department_id)
VALUES	('Р1',1,1),
		('Р2',2,1),
		('Р3',3,2),
		('Р4',4,2),
		('М1',1,3),
		('М2',2,3),
		('М3',3,4),
		('М4',4,4),
		('Э1',1,5),
		('Э2',2,5),
		('Э3',3,6),
		('Э4',4,6);

INSERT INTO Curators (name,surname)
VALUES	('Peggi','Spears'),
		('Margo','Edmonds'),
		('Gregoire','Delamar'),
		('Amandy','Cridlon'),
		('Peria','Aslen'),
		('Bobbee','Speir'),
		('Kiah','Pauncefort'),
		('Larine','Jest'),
		('Veriee','St Pierre'),
		('Nicolea','Dovidian'),
		('Aubrey','Lohde'),
		('Rita','Jacop');

INSERT INTO GroupsCurators (curator_id,group_id)
VALUES	(1,1),
		(2,2),
		(3,3),
		(4,4),
		(5,5),
		(6,6),
		(7,7),
		(8,8),
		(9,9),
		(10,10),
		(11,11),
		(12,12);

INSERT INTO Lectures (lecture_room, subject_id,teacher_id)
VALUES	('М101',1,1),
		('М102',1,2),
		('М103',2,3),
		('М104',2,4),
		('М105',3,5),
		('М105',3,6),
		('Р101',4,7),
		('Р102',4,8),
		('Р103',5,9),
		('Р104',5,10),
		('Р105',6,11),
		('Э101',6,12),
		('Э102',7,13),
		('Э103',7,14),
		('Э104',8,15),
		('Э105',8,16),
		('К101',9,17),
		('К102',9,18),
		('К103',10,19),
		('К104',10,20),
		('К105',11,21),
		('Ф101',11,22),
		('Ф102',12,23),
		('Ф103',12,24),
		('Ф104',13,25),
		('Ф105',13,26),
		('Д101',14,27),
		('Д102',14,28),
		('Д103',15,29),
		('Д103',15,30);

INSERT INTO GroupsLectures (group_id,lecture_id)
VALUES	(1,1),
		(1,2),
		(1,3),
		(2,3),
		(2,4),
		(2,5),
		(3,5),
		(3,6),
		(3,7),
		(4,7),
		(4,8),
		(4,9),
		(5,9),
		(5,10),
		(5,11),
		(6,11),
		(6,12),
		(6,13),
		(7,13),
		(7,14),
		(7,15),
		(8,15),
		(8,16),
		(8,17),
		(9,17),
		(9,18),
		(9,19),
		(10,19),
		(10,20),
		(10,21),
		(11,21),
		(11,22),
		(11,23),
		(12,23),
		(12,24),
		(12,25);

--Запросы
--1. ??? Вывести все возможные пары строк преподавателей и групп.
-- Возможно не совсем правильно понял задание
SELECT Teachers.name +' '+ Teachers.surname as 'Преподаватель', Groups.name as 'Название группы'
FROM Teachers, Groups

--2. Вывести названия факультетов, фонд финансирования кафедр которых превышает фонд финансирования факультета.
SELECT Faculties.name as 'Название факультета', Faculties.financing as 'Фонд факультета'
FROM Faculties
JOIN Departments on Departments.faculty_id = Faculties.id
GROUP BY Faculties.name, Faculties.financing
HAVING SUM(Departments.financing) > Faculties.financing


--3. Вывести фамилии кураторов групп и названия групп, которые они курируют.
SELECT surname as 'Фамилия куратора', Groups.name as 'Наименование группы'
FROM Curators
LEFT JOIN GroupsCurators on GroupsCurators.curator_id = Curators.id
RIGHT JOIN Groups on GroupsCurators.group_id=Groups.id

--4. Вывести имена и фамилии преподавателей, которые читают лекции у группы “Р3”.
SELECT Teachers.name + ' ' + Teachers.surname as 'Имя преподавателя', Groups.name as 'Название группы'
FROM Teachers
LEFT JOIN Lectures ON Teachers.id = Lectures.teacher_id
RIGHT JOIN GroupsLectures ON Lectures.id = GroupsLectures.lecture_id
RIGHT JOIN Groups ON GroupsLectures.group_id = Groups.id
WHERE Groups.name='Р3';

--5. Вывести фамилии преподавателей и названия факультетов на которых они читают лекции.
SELECT Teachers.surname as 'Фамилия преподавателя', Faculties.name as 'Название факультета'
FROM Teachers
LEFT JOIN Lectures on Teachers.id = Lectures.teacher_id
RIGHT JOIN GroupsLectures ON Lectures.id = GroupsLectures.lecture_id
RIGHT JOIN Groups ON Groups.id = GroupsLectures.group_id
RIGHT JOIN Departments ON Departments.id = Groups.department_id
RIGHT JOIN Faculties ON Faculties.id = Departments.faculty_id
GROUP BY Teachers.surname, Faculties.name;

--6. Вывести названия кафедр и названия групп, которые к ним относятся.
SELECT Departments.name as 'Кафедра', Groups.name as 'Название группы'
FROM Departments
JOIN Groups on Groups.department_id = Departments.id;

--7. Вывести названия дисциплин, которые читает преподаватель “Oran Stronough”.
SELECT Subjects.name as 'Название дисциплины'
FROM Subjects
LEFT JOIN Lectures ON Subjects.id = Lectures.subject_id
RIGHT JOIN Teachers ON Teachers.id = Lectures.teacher_id
WHERE Teachers.name = 'Oran' AND Teachers.surname = 'Stronough';

--8. Вывести названия кафедр, на которых читается дисциплина “Металлургия”.
SELECT Departments.name as 'Название кафедры'
FROM Departments
LEFT JOIN Groups ON Groups.department_id = Departments.id
RIGHT JOIN GroupsLectures ON Groups.id = GroupsLectures.group_id
RIGHT JOIN Lectures ON Lectures.id = GroupsLectures.lecture_id
RIGHT JOIN Subjects ON Subjects.id = Lectures.subject_id
WHERE Subjects.name = 'Металлургия'
GROUP BY Departments.name;

--9. Вывести названия групп, которые относятся к факультету “ЭВМ”.
SELECT Groups.name as 'Название группы'
FROM Groups
LEFT JOIN Departments ON Groups.department_id = Departments.id
RIGHT JOIN Faculties ON Departments.faculty_id = Faculties.id
WHERE Faculties.name = 'ЭВМ';

--10. Вывести названия групп 4-го курса, а также название факультетов, к которым они относятся.
SELECT Groups.name as 'Название группы', Faculties.name as 'Название факультета'
FROM Groups
LEFT JOIN Departments ON Groups.department_id = Departments.id
RIGHT JOIN Faculties ON Departments.faculty_id = Faculties.id
WHERE Groups.year = 4;

--11. Вывести полные имена преподавателей и лекции, которые они читают (названия дисциплин и групп), причем отобрать только те лекции, которые читаются в аудитории “Э103”.
SELECT Teachers.name + ' ' + Teachers.surname as 'Полное имя преподавателя', Subjects.name as 'Название дисциплины', Groups.name as 'Название группы'
FROM Teachers
LEFT JOIN Lectures ON Teachers.id = Lectures.teacher_id
RIGHT JOIN Subjects ON Lectures.subject_id = Subjects.id
RIGHT JOIN GroupsLectures ON Lectures.id = GroupsLectures.lecture_id
RIGHT JOIN Groups ON GroupsLectures.group_id = Groups.id
WHERE Lectures.lecture_room = 'Э103';
