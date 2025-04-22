--✅ 1. Вывести названия всех книг и имена их авторов, отсортированных по имени автора (по возрастанию).
--Используй: SELECT, JOIN, ORDER BY
--select Name as 'Название книги', FirstName + ' ' +LastName as 'Имя автора'
--from Books
--join Authors on Books.Id_Author = Authors.id
--order by FirstName + ' ' + LastName;

--✅ 2. Вывести всех студентов, у которых ещё нет читательских билетов (S_Cards).
--Используй: LEFT JOIN, WHERE, IS NULL
--select FirstName +' '+ LastName as 'Студенты без карточки', S_Cards.id as 'ID карточки'
--from Students
--left join S_Cards on Students.id = S_Cards.Id_Student
--where S_Cards.Id is null;

--✅ 3. Посчитать, сколько книг издаёт каждое издательство (Press) и отсортировать по убыванию.
--Используй: JOIN, GROUP BY, COUNT, ORDER BY
--select Press.Name, count(quantity) as 'Количество книг'
--from Books 
--join Press on Press.Id = Books.Id_Press
--group by Press.Name
--order by COUNT(quantity) desc;

--✅ 4. Вывести имена и фамилии всех преподавателей, которых нет среди студентов.
--Используй: EXCEPT
--select FirstName , LastName 
--from Teachers
--except 
--select FirstName,  LastName 
--from Students;

--✅ 5. Показать список всех факультетов, даже если на них нет ни одного студента.
--Используй: LEFT JOIN
--select Faculties.Name as 'Наименование факультета', count(Students.Id) as 'Количество студентов'
--from Faculties
--left join Groups on Faculties.Id = Groups.Id_Faculty 
--left join Students on Students.id_group = Groups.id
--group by Faculties.Name;

--✅ 6. Вывести список всех книг, темы которых начинаются на A или B.
--Используй: JOIN, LIKE
--select Books.Name as 'Наименование книги', Themes.Name as 'Тема'
--from Books
--join Themes on Books.Id_Themes = Themes.Id
--where Themes.Name like 'А%' or Themes.Name like 'В%';

--✅ 7. Найти всех студентов с фамилией длиннее 8 символов.
--Используй: WHERE, ?
--select *
--from Students
--where LastName like '_________%';

--✅ 8. Показать количество студентов в каждой группе.
--Используй: GROUP BY, COUNT
--select Groups.Name as 'Наименование группы', count(*) as 'Количество студентов в группе'
--from Students
--join Groups on Groups.id = Students.Id_Group
--group by Groups.Name;

--✅ 9. Вывести топ 5 авторов по количеству книг, которые они написали.
--Используй: JOIN, GROUP BY, COUNT, ORDER BY, TOP
--select top 5 Authors.FirstName + ' ' + Authors.LastName as 'Автор', count(Quantity) as 'Количество книг'
--from Authors
--join Books on Books.Id_Author = Authors.Id
--group by Authors.FirstName + ' ' + Authors.LastName
--order by COUNT(Quantity) desc;

--✅ 10. Обновить фамилию всех студентов с именем "Ali" на "Aliev".
--Используй: UPDATE, WHERE
--update Students
--set LastName = 'Aliev'
--where FirstName = 'Ali';