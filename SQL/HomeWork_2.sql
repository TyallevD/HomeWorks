--1. Выведи все книги, у которых цена больше 200.
select *
from books
where Price>200;

--2. Выведи книги, у которых количество страниц от 300 до 600 включительно.
select *
from books
--where pages >= 300 and pages <=600 --вариант c операторами больше или равно и меньше или равно
where pages between 300 and 600 --вариант с оператором between

--3. Показать книги, изданные издательством 'DiaSoft'.
select *
from books
where izd = 'DiaSoft';

--4. Показать книги, у которых Date не указана.
select *
from books
where Date is null;

--5. Вывести все уникальные издательства (Izd) из таблицы.
select distinct izd
from books;

--6. Выбери книги, у которых цена — 10, 50, 100 или 150.
select * 
from books
where Price in (10,50,100,150);

--7. Показать книги, где название начинается с "SQL".
select *
from books
where name like 'SQL%';

--8. Вывести книги, у которых Pressrun равен 1.
select *
from books
where Pressrun = 1;

--9. Показать книги, у которых название содержит Fə.
select *
from books
where name like N'%Fə';

--10. Вывести книги, у которых цена не равна 100.
select *
from books
where Price !=100;

--11. Показать 3% самых дешёвых книг, у которых страниц больше 300, и цена не входит в (100, 200, 300).
select top (3) percent *
from books
where Pages>300 and Price not in (100,200,300)
order by Price asc;

--12. Показать книги, где Price > 150, Izd не "DiaSoft", и дата указана (Date IS NOT NULL).
select * 
from books
where Price >150 and izd !='DiaSoft' and Date is not null;

--13. Вывести книги, где название состоит из 3 букв, первая — "Д", третья — "К".
select * 
from books
where Name like 'Д_К';

--14. Сгруппировать книги по New (0 и 1), и показать статус: old или new.
select *,
case
when New = 0 then 'old'
when New = 1 then 'new'
end as 'Status'
from books
order by New;

--15. Вывести название книги, цену и текстовую "оценку стоимости" через IIF, по таким правилам:
--> 300 → "очень дорогая"
--> 200 → "дорогая"
--> 100 → "не очень дорогая"
--<= 100 → "дешёвая"
--NULL → "нет информации"
select Name , Price, iif (Price >300, 'очень дорогая',
iif (Price >200, 'дорогая',
iif (Price >100, 'не очень дорогая',
iif (Price <=100, 'дешевая', 'нет информации')))) as 'Оценка стоимости'
from books;

--16. **Выведи книги, у которых:
--Pages > 500
--и это одна самая дорогая книга по этому условию**
select top (1)*
from books
where Pages > 500
order by Price desc;

--17. **Составь запрос, который покажет:
--Name, Price, Pressrun,
--статус тиража (IIF(Pressrun = 1) → "1 экз.", IS NULL → "нет данных", иначе — "в наличии")**
select Name as 'Наименование книги', Price as 'Цена', Pressrun as 'Тираж',
iif(Pressrun = 1, '1 экз.',
iif (Pressrun is null, 'нет данных',
iif (Pressrun = 0, 'нет в наличии','в наличии'))) as 'Статус Тиража'
from books;

--18. **Показать книги, у которых:
--Izd содержит одну букву из набора [а-яa-z], как 2-й символ,
--и название не начинается с "A"**
select *
from books
where Izd like '[^А][а-яa-z]%';

--19. Вывести все книги, отсортированные по убыванию стоимости всего тиража (Price * Pressrun).
select *, Price*Pressrun as 'Стоимость тиража'
from books 
order by Price*Pressrun desc;

--20. Вывести книги, где цена NULL или <= 100, но Pressrun больше 3000.
select * 
from books
where (Price is null or Price <=100) and Pressrun >3000;