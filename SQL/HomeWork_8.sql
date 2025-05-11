--Функция
--1. Пользовательская функция возвращает количество уникальных покупателей.
--CREATE FUNCTION UniqueUsers()
--RETURNS INT
--AS
--BEGIN
--DECLARE @result INT =(
--	SELECT DISTINCT COUNT(*) FROM Clients)
--	RETURN @result
--END

--SELECT dbo.UniqueUsers() as 'Уникальные клиенты';

--DROP FUNCTION dbo.UniqueUsers

--2. Пользовательская функция возвращает среднюю цену товара конкретного вида.
--   Вид товара передаётся в качестве параметра. Например, среднюю цену обуви.
--CREATE FUNCTION AvgPrice(@type NVARCHAR(50))
--RETURNS @Results TABLE
--(
--type NVARCHAR(50),
--avgCost FLOAT
--)
--AS
--BEGIN
--	INSERT INTO @Results VALUES (@type, (SELECT AVG(Cost)
--	FROM Products
--	JOIN Type ON Products.TypeId = Type.Id
--	WHERE Type.Name like @type))
--	RETURN
--END

-- SELECT * FROM dbo.AvgPrice('Training apparatus') --проверка работы функции

-- DROP FUNCTION AvgPrice --для удаления функции

--для проверки функции
--SELECT Type.Name , AVG(Cost)
--FROM Products
--JOIN Type ON Products.TypeId = Type.Id
--GROUP BY Type.Name

--3. Пользовательская функция возвращает среднюю цену продажи по каждой дате, когда осуществлялись продажи.
--CREATE FUNCTION AvgSalesByDate()
--RETURNS @Results TABLE
--(
--saleDate DATE,
--saleCountByDate INT,
--avgCostByDate FLOAT
--)
--AS
--BEGIN
--	INSERT INTO @Results

--	SELECT Date,
--	COUNT(*),
--	AVG(Cost)
--	FROM Sales
--	JOIN Storage ON Storage.id = Sales.StorageId
--	JOIN Products ON Products.Id = Storage.ProductId
--	GROUP BY Date

--	RETURN
--END

--SELECT COUNT(*) FROM Sales

--SELECT * FROM AvgSalesByDate() -- для проверки работы функции

-- DROP FUNCTION AvgSalesByDate --для удаления функции

-- скрипт для проверки
--SELECT Date , COUNT(*) as 'Количество продаж' , AVG(Cost) as 'Средняя цена'
--FROM Sales
--JOIN Storage ON Storage.id = Sales.StorageId
--JOIN Products ON Products.Id = Storage.ProductId
--GROUP BY Date
--ORDER BY Date DESC

--4. Пользовательская функция возвращает информацию о последнем проданном товаре. Критерий определения последнего проданного товара: дата продажи.
--CREATE FUNCTION LastSale()
--RETURNS @LastSaleInfo TABLE
--(
--sale_date DATE,
--client_full_name NVARCHAR(100),
--employee_full_name NVARCHAR(100),
--product_name NVARCHAR(100),
--product_price MONEY
--)
--AS
--BEGIN
--	INSERT INTO @LastSaleInfo
--	SELECT TOP 1 Date, c.FullName, e.FullName, p.Name, p.Cost
--	FROM Sales s
--	JOIN Clients c ON c.id = s.ClientId
--	JOIN Employees e ON e.Id = s.EmployeeId
--	JOIN Storage st ON st.Id = s.StorageId
--	JOIN Products p ON p.Id = st.ProductId
--	ORDER BY Date DESC
--	RETURN
--END

--SELECT * FROM LastSale() --проверка функции

--DROP FUNCTION LastSale -- удаление функции

--5. Пользовательская функция возвращает информацию о первом проданном товаре. Критерий определения первого проданного товара: дата продажи.
--CREATE FUNCTION FirstSale()
--RETURNS @FirstSaleInfo TABLE
--(
--sale_date DATE,
--client_full_name NVARCHAR(100),
--employee_full_name NVARCHAR(100),
--product_name NVARCHAR(100),
--product_price MONEY
--)
--AS
--BEGIN
--	INSERT INTO @FirstSaleInfo
--	SELECT TOP 1 Date, c.FullName, e.FullName, p.Name, p.Cost
--	FROM Sales s
--	JOIN Clients c ON c.id = s.ClientId
--	JOIN Employees e ON e.Id = s.EmployeeId
--	JOIN Storage st ON st.Id = s.StorageId
--	JOIN Products p ON p.Id = st.ProductId
--	ORDER BY Date
--	RETURN
--END

--SELECT * FROM FirstSale() --проверка функции

--DROP FUNCTION FirstSale -- удаление функции

--Процедура
--1. Хранимая процедура показывает информацию о всех продавцах
--CREATE PROCEDURE ShowEmployeesInfo
--AS
--BEGIN
--    SELECT FullName as 'Полное имя продавца',
--    EmploymentDate as 'Дата начала работы',
--    p.Name as 'Должность',
--    Salary as 'Заработная плата'
--    FROM Employees e
--    JOIN Positions p ON p.Id = e.PositionId
--END

--EXEC ShowEmployeesInfo --выполнение процедуры

--DROP PROCEDURE ShowEmployeesInfo -- удаление процедуры

--2. Хранимая процедура показывает информацию о всех покупателях
--CREATE PROCEDURE ShowClientsInfo
--AS
--BEGIN
--	SELECT FullName as 'Полное имя покупателя',
--	Email as 'Почтовый ящик',
--	Phone as 'Номер телефона',
--	Gender as 'Пол покупателя'
--	FROM Clients c
--END

--EXEC ShowClientsInfo --выполнение процедуры

--DROP PROCEDURE ShowClientsInfo --удаление процедуры

--3. Хранимая процедура показывает полную информацию о продажах
--CREATE PROCEDURE ShowSalesInfo
--AS
--BEGIN
--	SELECT Date AS 'Дата продажи',
--	e.FullName AS 'Полное имя продавца',
--	c.FullName AS 'Полное имя покупателя',
--	s.Quantity AS 'Количество проданного товара',
--	p.Name AS 'Наименование товара'
--	FROM Sales s
--	JOIN Employees e ON e.id = s.EmployeeId
--	JOIN Clients c ON c.id = s.ClientId
--	JOIN Storage st ON s.StorageId = st.Id
--	JOIN Products p ON p.Id = st.ProductId
--END

--EXEC ShowSalesInfo --выполнение процедуры

--DROP PROCEDURE ShowSalesInfo --удаление процедуры

--4. Хранимая процедура показывает полную информацию о всех продажах в конкретный день.
--   Дата продажи передаётся в качестве параметра
--CREATE PROCEDURE ShowSalesInfoByDate
--@date DATE
--AS
--BEGIN
--	SELECT Date AS 'Дата продажи',
--	e.FullName AS 'Полное имя продавца',
--	c.FullName AS 'Полное имя покупателя',
--	s.Quantity AS 'Количество проданного товара',
--	p.Name AS 'Наименование товара'
--	FROM Sales s
--	JOIN Employees e ON e.id = s.EmployeeId
--	JOIN Clients c ON c.id = s.ClientId
--	JOIN Storage st ON s.StorageId = st.Id
--	JOIN Products p ON p.Id = st.ProductId
--	WHERE s.Date = @date
--END

--EXEC ShowSalesInfoByDate '2021-03-11' --выполнение процедуры

--DROP PROCEDURE ShowSalesInfoByDate --удаление процедуры

--5. Хранимая процедура показывает полную информацию о всех продажах в некотором временном сегменте.
--   Дата старта и конца сегмента передаётся в качестве параметра
--CREATE PROCEDURE ShowSalesInfoBetweenDates
--@startDate DATE,
--@endDate DATE
--AS
--BEGIN
--	SELECT Date AS 'Дата продажи',
--	e.FullName AS 'Полное имя продавца',
--	c.FullName AS 'Полное имя покупателя',
--	s.Quantity AS 'Количество проданного товара',
--	p.Name AS 'Наименование товара'
--	FROM Sales s
--	JOIN Employees e ON e.id = s.EmployeeId
--	JOIN Clients c ON c.id = s.ClientId
--	JOIN Storage st ON s.StorageId = st.Id
--	JOIN Products p ON p.Id = st.ProductId
--	WHERE s.Date BETWEEN @startDate AND @endDate
--END

--EXEC ShowSalesInfoBetweenDates '2020-01-01', '2024-01-01' --выполнение процедуры

--DROP PROCEDURE ShowSalesInfoBetweenDates --удаление процедуры
