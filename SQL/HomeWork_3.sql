-- 1) Вывести все записи из таблицы books, где тираж (Pressrun) больше 1000. 
--select *
--from books
--where Pressrun>1000;

-- 2) Показать только названия книг (Name) и количество страниц (Pages). 
--select Name as 'Название книги', Pages as 'Количество страниц'
--from books;

-- 3) Найти книги, у которых цена меньше 200. 
--select *
--from books
--where Price <200;

-- 4) Найти книги, у которых Pages = 0 или Price = 0. 
--select *
--from books
--where Pages = 0 or Price = 0;

-- 5) Найти книги, где Pressrun больше 500 и цена меньше 300. 
--select *
--from books
--where Pressrun > 500 and Price < 300;

-- 6) Отсортировать книги по возрастанию количества страниц. 
--select *
--from books
--order by Pages;

-- 7) Вывести 10 самых дешёвых книг. 
--select top 10 *
--from books
--order by Price

-- 8) Показать всех издателей (Izd), названия которых начинаются на букву 'A'. 
--select izd 
--from books
--where name like 'A%'

-- 9) Подсчитать количество книг, где количество страниц больше 150. 
--select count(*) as 'Количество книг со страницами больше 150'
--from books
--where pages>150;

-- 10) Найти среднюю цену книг, где Pressrun больше 1000. 
--select AVG(PRICE) as 'Средняя цена книг, где тираж выше 1000'
--from books
--where Pressrun > 1000;

-- 11) Найти минимальное и максимальное значение в колонке Pages. 
--select MIN(Pages) as 'Минимальное значение', MAX(Pages) as 'Максимальное значение'
--from books;

-- 12) Вывести книги, в названии которых есть символ '1'.  
--select *
--from books
--where Name like '%1%';

-- 13) Отсортировать книги по возрастанию произведения Price * Pages. 
--select *
--from books
--order by Price * Pages;

-- 14) Показать книги, у которых Pages между 50 и 250. 
--select *
--from books
--where Pages between 50 and 250;

-- 15) Вывести книги, у которых дата публикации старше 01.01.2015.
--select *
--from books
--where Date < '2015-01-01';

-- 16) Посчитать количество книг для каждого издателя, где Pages > 200. 
--select izd as 'Издатель', count(*) as 'Количество книг'
--from books
--where pages > 200
--group by izd;

-- 17) Найти издательства, у которых средняя цена книг меньше 300. 
--select izd as'Издатель'
--from books
--group by izd
--having AVG(Price) < 300;

-- 18) Найти книгу с минимальным значением Price * Pages.
--изменил количество страниц на 1 во всех книгах с количеством =0, т.к. результат получается неочевидным
--update books set pages = 1, price = 1 
--where pages = 0 and pages is null and price is null;

--выполнение задания
--select top 1 name, MIN(Price*Pages) as'Минимальное значение Price * Pages'
--from books
--group by name
--order by MIN (Price * Pages);


-- 19) Найти название самой старой книги по дате (Date). 
--select top 1  name, min(DATE) as 'Минимальная дата'
--from books
--group by name
--having min(date) is not null
--order by min(Date)

-- 20) Найти издателя с наибольшим суммарным тиражом (Pressrun).
--select top 1  izd, sum(Pressrun) as 'Суммарный тираж'
--from books
--group by izd
--order by sum(Pressrun) desc;

-- 21) Добавить новую книгу с названием 'Learning SQL', ценой 450, издательством 'EduBooks' и 320 страницами. 
--insert into books (Name, Price, Izd, Pages)
--values ('Learning SQL', 450, 'EduBooks', 320);

-- Выводим результат:
--select * 
--from books 
--where name = 'Learning SQL'; 

-- 22) Добавить 3 книги, в которых цена = 999, но у всех разные издатели. 
--insert into books (Price, Izd)
--values (999, 'Первый издатель'),
--(999, 'Второй издатель'),
--(999, 'Третий издатель');

--select * 
--from books
--where izd like '% издатель'; --для вывода результата

-- 23) Удалить все книги, у которых название начинается с 'Test'.
--добавляем, так как таких книг нет:
--insert into books (name)
--values	('Test1'),
--		('Test2'),
--		('Test 3');

--проверяем
--select *
--from books
--where name like 'Test%';

--удаляем по заданию
--delete from books 
--where name like 'Test%';


-- 24) Увеличить цену на 15% для всех книг, у которых Price < 300.
--update books 
--set price = price * 0.15 
--where price <300;

-- 25) Переименовать все книги с названием 'Old Title' на 'Modern SQL Guide'.
--добавляем, т.к. такой книги в таблице нет:
--insert into books (name)
--values ('Old Title');

--проверяем, что добавилась:
--select * 
--from books 
--where name = 'Old Title';

--изменяем название по заданию
--update books
--set name = 'Modern SQL Guide'
--where name = 'Old Title';

--проверяем, что книги с новым названием присутствуют в таблице:
--select * 
--from books 
--where name = 'Modern SQL Guide';