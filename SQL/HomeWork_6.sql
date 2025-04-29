--DROP DATABASE University;
CREATE DATABASE University
GO
USE University

--Таблицы
--1. Кафедры (Departments)
--- Идентификатор (Id). Уникальный идентификатор кафедры.
-- 	Тип данных — int.
-- 	Авто приращение.
-- 	Не может содержать null-значения.
-- 	Первичный ключ.
--- Финансирование (Financing). Фонд финансирования кафедры.
-- 	Тип данных — money.
-- 	Не может содержать null-значения.
-- 	Не может быть меньше 0.
-- 	Значение по умолчанию — 0.
--- Название (Name). Название кафедры.
-- 	Тип данных — nvarchar(100).
--  Не может содержать null-значения.
-- 	Не может быть пустым.
-- 	Должно быть уникальным.
--- Идентификатор факультета (FacultyId). Факультет, в состав которого входит кафедра.
-- 	Тип данных — int.
-- 	Не может содержать null-значения.
-- 	Внешний ключ.
CREATE TABLE Departments
(
id INT PRIMARY KEY IDENTITY,
financing MONEY NOT NULL DEFAULT(0),
name NVARCHAR(100) NOT NULL UNIQUE,
faculty_id INT NOT NULL,

CONSTRAINT CK_Departments_financing CHECK(financing>=0)
);

--2. Факультеты (Faculties)
--- Идентификатор (Id). Уникальный идентификатор факультета.
--  Тип данных — int.
-- 	Авто приращение.
-- 	Не может содержать null-значения.
--  Первичный ключ.
--- Название (Name). Название факультета.
-- 	Тип данных — nvarchar(100).
-- 	Не может содержать null-значения.
-- 	Не может быть пустым.
-- 	Должно быть уникальным.
CREATE TABLE Faculties
(
id INT PRIMARY KEY IDENTITY,
financing MONEY NOT NULL DEFAULT(0),
name NVARCHAR(100) NOT NULL UNIQUE,

CONSTRAINT CK_Faculties_financing CHECK(financing>=0)
);

--3. Группы (Groups)
--- Идентификатор (Id). Уникальный идентификатор группы.
-- 	Тип данных — int.
-- 	Авто приращение.
-- 	Не может содержать null-значения.
-- 	Первичный ключ.
--- Название (Name). Название группы.
-- 	Тип данных — nvarchar(10).
-- 	Не может содержать null-значения.
-- 	Не может быть пустым.
-- 	Должно быть уникальным.
--- Курс (Year). Курс (год) на котором обучается группа.
-- 	Тип данных — int.
-- 	Не может содержать null-значения.
-- 	Должно быть в диапазоне от 1 до 5.
--- Идентификатор кафедры (DepartmentId). Кафедра, в состав которой входит группа.
-- 	Тип данных — int.
--  Не может содержать null-значения.
--  Внешний ключ.
CREATE TABLE Groups
(
id INT PRIMARY KEY IDENTITY,
name NVARCHAR(10) NOT NULL UNIQUE,
year INT NOT NULL,
department_id INT NOT NULL,

CONSTRAINT CK_Groups_year CHECK(year BETWEEN 1 and 5)
);

--4. Группы и лекции (GroupsLectures)
--- Идентификатор (Id). Уникальный идентификатор группы и лекции.
-- 	Тип данных — int.
-- 	Авто приращение.
-- 	Не может содержать null-значения.
-- 	Первичный ключ.
--- Идентификатор группы (GroupId). Группа.
-- 	Тип данных — int.
-- 	Не может содержать null-значения.
-- 	Внешний ключ.
--- Идентификатор лекции (LectureId). Лекция.
-- 	Тип данных — int.
-- 	Не может содержать null-значения.
-- 	Внешний ключ.
CREATE TABLE GroupsLectures
(
id INT PRIMARY KEY IDENTITY,
group_id INT NOT NULL,
lecture_id INT NOT NULL
);

--5. Лекции (Lectures)
--- Идентификатор (Id). Уникальный идентификатор лекции.
-- 	Тип данных — int.
-- 	Авто приращение.
-- 	Не может содержать null-значения.
-- 	Первичный ключ.
--- День недели (DayOfWeek). День недели, в который читается лекция.
-- 	Тип данных — int.
-- 	Не может содержать null-значения.
-- 	Должен быть в диапазоне от 1 до 7.
--- Аудитория (LectureRoom). Аудитория в которой читается лекция.
-- 	Тип данных — nvarchar(max).
-- 	Не может содержать null-значения.
--  Не может быть пустым.
--- Идентификатор дисциплины (SubjectId). Дисциплина, по которой читается лекция.
-- 	Тип данных — int.
-- 	Не может содержать null-значения.
-- 	Внешний ключ.
--- Идентификатор преподавателя (TeacherId). Преподаватель, который читает лекцию.
-- 	Тип данных — int.
-- 	Не может содержать null-значения.
--  Внешний ключ.
CREATE TABLE Lectures
(
id INT PRIMARY KEY IDENTITY,
day_of_week INT NOT NULL,
lecture_room NVARCHAR(30) NOT NULL,
subject_id INT NOT NULL,
teacher_id INT NOT NULL,

CONSTRAINT CK_Lectures_day_of_week CHECK(day_of_week BETWEEN 1 AND 7)
);

--6. Дисциплины (Subjects)
--- Идентификатор (Id). Уникальный идентификатор дисциплины.
-- 	Тип данных — int.
-- 	Авто приращение.
-- 	Не может содержать null-значения.
-- 	Первичный ключ.
--- Название (Name). Название дисциплины.
-- 	Тип данных — nvarchar(100).
-- 	Не может содержать null-значения.
-- 	Не может быть пустым.
-- 	Должно быть уникальным.
CREATE TABLE Subjects
(
id INT PRIMARY KEY IDENTITY,
name NVARCHAR(100) NOT NULL UNIQUE
);

--7. Преподаватели (Teachers)
--- Идентификатор (Id). Уникальный идентификатор преподавателя.
-- 	Тип данных — int.
-- 	Авто приращение.
-- 	Не может содержать null-значения.
-- 	Первичный ключ.
--- Имя (Name). Имя преподавателя.
-- 	Тип данных — nvarchar(max).
-- 	Не может содержать null-значения.
-- 	Не может быть пустым.
--- Ставка (Salary). Ставка преподавателя.
-- 	Тип данных — money.
-- 	Не может содержать null-значения.
-- 	Не может быть меньше либо равно 0.
--- Фамилия (Surname). Фамилия преподавателя.
-- 	Тип данных — nvarchar(max).
-- 	Не может содержать null-значения.
-- 	Не может быть пустым.
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
--добавление дополнительной таблицы Students со связкой с таблицей Groups для заданий 5,7
CREATE TABLE Students
(
id INT PRIMARY KEY IDENTITY,
name NVARCHAR(30) NOT NULL,
surname NVARCHAR(30) NOT NULL,
group_id INT NOT NULL,

CONSTRAINT FK_Students_group_id FOREIGN KEY(group_id) REFERENCES Groups(id)
);
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

INSERT INTO Lectures (day_of_week,lecture_room, subject_id,teacher_id)
VALUES	(1,'М101',1,1),
		(1,'М102',1,2),
		(2,'М103',2,3),
		(2,'М104',2,4),
		(3,'М105',3,5),
		(3,'М105',3,6),
		(4,'Р101',4,7),
		(4,'Р102',4,8),
		(5,'Р103',5,9),
		(5,'Р104',5,10),
		(6,'Р105',6,11),
		(6,'Э101',6,12),
		(7,'Э102',7,13),
		(7,'Э103',7,14),
		(1,'Э104',8,15),
		(1,'Э105',8,16),
		(2,'К101',9,17),
		(2,'К102',9,18),
		(3,'К103',10,19),
		(3,'К104',10,20),
		(4,'К105',11,21),
		(4,'Ф101',11,22),
		(5,'Ф102',12,23),
		(5,'Ф103',12,24),
		(6,'Ф104',13,25),
		(6,'Ф105',13,26),
		(7,'Д101',14,27),
		(7,'Д102',14,28),
		(1,'Д103',15,29),
		(1,'Д103',15,30);

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
--=========================================================================================================
--добавление данных в дополнительную таблицу Students
INSERT INTO Students (name, surname,group_id)
VALUES	('Anallise', 'Domenico',1),
		('Ellette', 'Snare',1),
		('Dorelle', 'Adamsson',1),
		('Fionna', 'Ollet',1),
		('Marie', 'Hing',1),
		('Sal', 'Curmi',1),
		('Querida', 'Talloe',1),
		('Parnell', 'Gherarducci',1),
		('Jeramie', 'Jeaneau',1),
		('Merrily', 'New',1),
		('Douglass', 'Gerwood',1),
		('Antonia', 'Mingard',1),
		('Sena', 'Balsdon',1),
		('Rhodia', 'Marval',1),
		('Daveta', 'Brasener',1),
		('Reena', 'Domesday',1),
		('Kingsley', 'Beine',1),
		('Emelita', 'McTerrelly',2),
		('Silvain', 'Petrosian',2),
		('Filberto', 'Kynston',2),
		('Rosalie', 'Wogdon',2),
		('Morly', 'Libermore',2),
		('Edeline', 'Leguay',2),
		('Jasper', 'Beardmore',2),
		('Krystle', 'Agge',2),
		('Berne', 'Rutland',2),
		('Milzie', 'Lafontaine',2),
		('Micheline', 'Fantin',2),
		('Connor', 'Grain',2),
		('Jewell', 'Rylands',2),
		('Kermy', 'Langelay',2),
		('Jorrie', 'Byron',2),
		('Mireielle', 'Grahamslaw',2),
		('Etty', 'Robottham',2),
		('Tyler', 'MacGrath',2),
		('Ailbert', 'Giffin',2),
		('Dale', 'Minthorpe',2),
		('Lita', 'Northill',2),
		('Anthiathia', 'Dyball',3),
		('Natalina', 'Bentinck',3),
		('Noelyn', 'Aymes',3),
		('Sacha', 'Manclark',3),
		('Della', 'Paddon',3),
		('Vanny', 'Goodrick',3),
		('Adolph', 'Karsh',3),
		('Sorcha', 'Shurey',3),
		('Mellicent', 'Towll',3),
		('Emelen', 'Glanert',3),
		('Umberto', 'De la Feld',3),
		('Vergil', 'Masson',3),
		('Noelani', 'Wrennall',3),
		('Zak', 'Duffus',3),
		('Rebeca', 'Kingerby',3),
		('Perle', 'Hackwell',3),
		('Kathlin', 'Clemow',3),
		('Allister', 'Epple',3),
		('Selig', 'Bolin',3),
		('Trefor', 'Leband',3),
		('Kalina', 'Sinkins',4),
		('Chrysler', 'Cham',4),
		('Leonard', 'Coulbeck',4),
		('Malina', 'Gresswood',4),
		('Hanni', 'Loffel',4),
		('Ariel', 'Hurdidge',4),
		('Dollie', 'Gasken',4),
		('Dickie', 'McIlmurray',4),
		('Estrella', 'Richings',4),
		('Kaitlin', 'Faragan',4),
		('Kimbell', 'Turbayne',4),
		('Randell', 'Reddington',4),
		('Karilynn', 'Pharo',4),
		('Mariel', 'Osan',4),
		('Norton', 'Work',4),
		('Pamela', 'Spinello',4),
		('Barbra', 'Cohani',4),
		('Carlotta', 'Doll',4),
		('Graehme', 'Raubheim',4),
		('Matty', 'Iwaszkiewicz',4),
		('Josias', 'Jocic',4),
		('Avram', 'Blees',4),
		('Dorothea', 'Thurley',4),
		('Dorolice', 'Weldon',4),
		('Seymour', 'Bwye',5),
		('Harriott', 'Want',5),
		('Lewiss', 'Shurlock',5),
		('Victoria', 'Gallimore',5),
		('Joby', 'Flement',5),
		('Jodi', 'Dunbobbin',5),
		('Laina', 'Hellard',5),
		('Bernadette', 'O''Kuddyhy',5),
		('Zelda', 'Lund',5),
		('Sile', 'Barenskie',5),
		('Gregor', 'Schuricke',5),
		('Jefferey', 'Iorns',5),
		('Kippy', 'Yankishin',5),
		('Sibby', 'Attwell',5),
		('Valle', 'Butchart',5),
		('Wheeler', 'Flucker',5),
		('Ray', 'McAline',5),
		('Elisha', 'Carnegy',5),
		('Stefanie', 'Innwood',5),
		('Harri', 'Ocheltree',6),
		('Ingaberg', 'Tapenden',6),
		('Otha', 'Gaule',6),
		('Vivia', 'O''Toole',6),
		('Loree', 'Torrans',6),
		('Michaela', 'Drewery',6),
		('Kaile', 'Stuckley',6),
		('Vivyanne', 'Abden',6),
		('Aymer', 'Wims',6),
		('Bellanca', 'Wreath',6),
		('Murry', 'Klausen',6),
		('Octavia', 'Alp',6),
		('Christalle', 'De Haven',6),
		('Godwin', 'Bridal',6),
		('Magdaia', 'Suddock',6),
		('Iorgos', 'Fishbourne',7),
		('Vere', 'Edards',7),
		('King', 'Simister',7),
		('Susi', 'Kneeshaw',7),
		('Petr', 'Laguerre',7),
		('Rance', 'McGauhy',7),
		('Cheryl', 'Burtt',7),
		('Davey', 'Prichet',7),
		('Armando', 'Artus',7),
		('Modesty', 'Chalke',7),
		('Skipper', 'Ciotto',7),
		('Tabbatha', 'Yewman',7),
		('Thor', 'Doughartie',7),
		('Austina', 'Le Fleming',7),
		('Barrie', 'Easum',7),
		('Milty', 'McConville',7),
		('Ulric', 'Baal',7),
		('Tristam', 'Slate',8),
		('Fletch', 'Kloser',8),
		('Theo', 'Seagrove',8),
		('Randy', 'Dougharty',8),
		('Roberta', 'Fortey',8),
		('Ingamar', 'Coare',8),
		('Tasha', 'Tracy',8),
		('Daron', 'Dowzell',8),
		('Domingo', 'Dyas',8),
		('Anderson', 'Ridings',8),
		('Rosie', 'Whitehurst',8),
		('Cynthy', 'Ballintime',8),
		('Onida', 'Buten',8),
		('Sherilyn', 'Thompstone',8),
		('Kirbie', 'Irnys',8),
		('Batholomew', 'Crudge',8),
		('Corrinne', 'Drage',8),
		('Holmes', 'Mea',8),
		('Carmela', 'Bartolomeo',8),
		('Larine', 'Gasperi',8),
		('Jojo', 'Clutram',8),
		('Geoffrey', 'Saipy',9),
		('Frederik', 'Bettam',9),
		('Norma', 'Woolhouse',9),
		('Darcy', 'Ponsford',9),
		('Chiquia', 'Anetts',9),
		('Osmund', 'Clashe',9),
		('Harp', 'Swannell',9),
		('Jemie', 'MacLeese',9),
		('Beatrisa', 'Crimp',9),
		('Cody', 'Vittore',9),
		('Vachel', 'Orknay',9),
		('Ursulina', 'Muff',9),
		('Bartie', 'Vanichev',9),
		('Kendrick', 'Gloyens',9),
		('Rustin', 'Filochov',9),
		('Horatio', 'Letcher',9),
		('Martino', 'Canning',9),
		('Tommie', 'Gall',9),
		('Michel', 'Pycock',9),
		('Zelig', 'Naismith',9),
		('Fayina', 'Minshull',9),
		('Hildagarde', 'Friedenbach',9),
		('Roma', 'Marmion',9),
		('Wilden', 'Highway',10),
		('Fitzgerald', 'Mesnard',10),
		('Maryanna', 'Bonnaire',10),
		('Beverlee', 'Shayler',10),
		('Gina', 'Farbrother',10),
		('Sheelagh', 'Roos',10),
		('Malina', 'Gowar',10),
		('Chrystal', 'Glassard',10),
		('Sharon', 'Ashtonhurst',10),
		('Mariette', 'Ferie',10),
		('Clair', 'Silbert',10),
		('Harrietta', 'Arnholz',10),
		('Martelle', 'Andrag',10),
		('Olivette', 'West',10),
		('Zabrina', 'Kurdani',10),
		('Karlene', 'Winspur',10),
		('Rickard', 'Tompion',10),
		('Colver', 'Duester',10),
		('Kellen', 'Frew',10),
		('Zarah', 'Dayer',10),
		('Gilly', 'Colleer',10),
		('Augustina', 'Salasar',10),
		('Sampson', 'MacDearmid',11),
		('Dot', 'Grimble',11),
		('Zebedee', 'Parminter',11),
		('Carmon', 'Pietrzak',11),
		('Rafaelita', 'Whybrow',11),
		('Olwen', 'Essex',11),
		('Margery', 'Haistwell',11),
		('Dorita', 'Siflet',11),
		('Luise', 'De Haven',11),
		('Yulma', 'Aleixo',11),
		('Andee', 'Lethbridge',11),
		('Mack', 'Severs',11),
		('Lonni', 'Malatalant',11),
		('Eddi', 'McComish',11),
		('Ardis', 'Aplin',11),
		('Kathy', 'Clell',11),
		('Cordy', 'Mattersey',11),
		('Ellyn', 'Pinchback',11),
		('Boot', 'De Caroli',11),
		('Georgie', 'Handrick',11),
		('Crysta', 'Hargess',11),
		('Kearney', 'Youhill',11),
		('Estelle', 'Cash',12),
		('Kienan', 'Colliver',12),
		('Klaus', 'Treppas',12),
		('Maryrose', 'Dohr',12),
		('Brett', 'Ives',12),
		('Kylila', 'Dobrowolski',12),
		('Neel', 'Elam',12),
		('Alie', 'Franscioni',12),
		('Melva', 'Tolchar',12),
		('Carri', 'Delgardillo',12),
		('Brenn', 'Kissock',12),
		('Willow', 'Girvin',12),
		('Siward', 'Talbot',12),
		('Abey', 'Tuddall',12),
		('Mureil', 'Cordero',12),
		('Bendicty', 'Atwell',12),
		('Marcos', 'Danielsen',12),
		('Carole', 'MacKnocker',12),
		('Briana', 'Boutton',12);

--Запросы
--1. Вывести количество преподавателей кафедры “Высшая математика”.
SELECT COUNT(DISTINCT Teachers.id) as 'Количество преподавателей'
FROM Teachers
JOIN Lectures  ON Teachers.id = Lectures.teacher_id
JOIN GroupsLectures ON Lectures.id = GroupsLectures.lecture_id
JOIN Groups ON Groups.id = GroupsLectures.group_id
JOIN Departments ON Departments.id = Groups.department_id
WHERE Departments.name = 'Высшая математика';

--2. Вывести количество лекций, которые читает преподаватель “Amandy Cridlon”.
SELECT COUNT(Lectures.id) as 'Количество лекций'
FROM Lectures
JOIN Teachers ON Teachers.id = Lectures.teacher_id
WHERE Teachers.name = 'Amandy' AND Teachers.surname = 'Cridlon';

--3. Вывести количество занятий, проводимых в аудитории “М105”.
SELECT COUNT(*) as 'Количество занятий'
FROM Lectures
WHERE lecture_room = 'М105';

--4. Вывести названия аудиторий и количество лекций, проводимых в них.
SELECT Lectures.lecture_room as 'Аудитория', COUNT (Lectures.id) as 'Количество лекций'
FROM Lectures
GROUP BY lecture_room;

--5. Вывести количество студентов, посещающих лекции преподавателя “Cherry Dalliwatr”.
SELECT COUNT(*) as 'Количество студентов'
FROM Students s
JOIN Groups g ON g.id = s.group_id
JOIN GroupsLectures gl ON gl.group_id = g.id
JOIN Lectures l ON l.id = gl.lecture_id
JOIN Teachers t ON t.id = l.teacher_id
WHERE t.name = 'Cherry' AND t.surname = 'Dalliwatr';

--6. Вывести среднюю ставку преподавателей факультета “ЭВМ”.
SELECT AVG(t.salary) 'Средняя ставка преподавателя'
FROM Teachers t
JOIN Lectures l ON l.teacher_id = t.id
JOIN GroupsLectures gl ON l.id = gl.lecture_id
JOIN Groups g ON g.id = gl.group_id
JOIN Departments d ON d.id = g.department_id
JOIN Faculties f ON f.id = d.faculty_id
WHERE f.name = 'ЭВМ';

--7. Вывести минимальное и максимальное количество студентов среди всех групп.
-- тут не понял как сделать без использования подзапроса, поэтому использовал подзапрос
SELECT MIN (student_count) AS 'Минимум студентов', MAX(student_count) as 'Максимум студентов'
FROM (
	SELECT group_id,
	COUNT(*) AS student_count
	FROM Students
	GROUP BY group_id
	) AS GroupCounts;

--8. Вывести средний фонд финансирования кафедр.
SELECT AVG(financing) as 'Средний фонд финансирования кафедр'
FROM Departments;

--9. Вывести полные имена преподавателей и количество читаемых ими дисциплин.
SELECT t.name + ' ' + t.surname AS 'Имя преподавателя', COUNT(s.id) AS 'Количество дисциплин'
From Teachers t
JOIN Lectures l ON l.teacher_id = t.id
JOIN Subjects s ON s.id = l.subject_id
GROUP BY t.name + ' ' + t.surname;

--10. Вывести количество лекций в каждый день недели.
SELECT day_of_week as 'День недели', COUNT(*) as 'Количество лекций'
FROM Lectures
GROUP BY day_of_week;

--11. Вывести номера аудиторий и количество кафедр, чьи лекции в них читаются.
SELECT l.lecture_room as 'Номер аудитории', COUNT(DISTINCT d.id) as 'Количество кафедр'
FROM Lectures l
JOIN GroupsLectures gl ON gl.lecture_id = l.id
JOIN Groups g ON g.id = gl.group_id
JOIN Departments d ON d.id = g.department_id
GROUP BY l.lecture_room

--12.Вывести названия факультетов и количество дисциплин, которые на них читаются.
SELECT f.name as 'Название факультета', COUNT(DISTINCT s.id) as 'Количество дисциплин'
FROM Faculties f
JOIN Departments d ON d.faculty_id = f.id
JOIN Groups g ON g.department_id = d.id
JOIN GroupsLectures gl ON gl.group_id = g.id
JOIN Lectures l ON l.id = gl.lecture_id
JOIN Subjects s ON l.subject_id = s.id
GROUP BY f.name;

--13. Вывести количество лекций для каждой пары преподаватель-аудитория.
SELECT t.name + ' ' + t.surname AS 'Имя преподавателя', l.lecture_room, COUNT(*) as 'Количество лекций'
FROM Lectures l
JOIN Teachers t ON t.id = l.teacher_id
GROUP BY t.name + ' ' + t.surname, l.lecture_room
