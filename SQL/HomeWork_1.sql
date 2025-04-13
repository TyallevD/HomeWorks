--Выведи название, цену и тираж, а также добавь колонку "Общая сумма", где будет Price * Pressrun.
--(Используй AS для красивого имени):
--select name as 'Название книги', price as 'Цена', pressrun as 'Тираж', Price * pressrun as 'Общая сумма'
--from books;

--Выведи книги, отсортированные по тиражу (от большего к меньшему), а если тираж одинаковый — по цене (по возрастанию). 
--select *
--from books
--order by Pressrun desc, price asc;

--Выведи книги, отсортированные по формату (Format) по алфавиту, а затем по дате (Date) по убыванию. 
--select * 
--from books
--order by izd asc, Date desc --Поменял Format на Izd, т.к. в поле формат не алфавитные значения

--Переименуй колонки: Name → "Книга", Price → "Цена", Pressrun → "Тираж".
--(Только переименование, без сортировки) 
--select name as 'Книга', Price as 'Цена', Pressrun as 'Тираж'
--from books;

--Выведи названия книг и коды (Code), отсортированные по названию по алфавиту. 
--select name, code 
--from books
--order by Name;

--Покажи только Name, Pages и Format, отсортированные по количеству страниц (Pages) по убыванию. 
--select name, pages, format
--from books
--order by Pages desc;

--Выведи все книги, добавив колонку "Цена за 1 страницу", рассчитанную как Price / Pages. 
--select *, Price/Pages as 'Цена за 1 страницу' 
--from books where Pages!=0; -- т.к. есть строки с Pages = 0, то исключаем их для получения корректного результата

--Отсортируй книги по Category, потом по Themes, потом по Name. 
--select *
--from books
--order by Category, Themes, Name;

--Выведи название книги, цену и дату, отсортированные по дате (сначала самые новые).
--select name, price, Date 
--from books
--order by Date;