--Условие задачи: Таблица умножения на заданное число
--Пользователь вводит целое положительное число. Необходимо с помощью SQL-сценария построить таблицу умножения для этого числа от 1 до 10.
--Результатом должна быть таблица из 10 строк, где каждая строка содержит выражение вида:
--N × i = R,
--где
--N — введённое пользователем число,
--i — множитель от 1 до 10,
--R — результат умножения.

--Задание 1. Вывод:
DECLARE @userNumber INT = 7;
DECLARE @factor INT = 10;
DECLARE @result INT;
DECLARE @Results TABLE
(
number INT,
factor INT,
result INT
)
WHILE (@factor>=0)
	BEGIN
	SET @result = @userNumber * @factor;

	INSERT INTO @Results
	VALUES	(@userNumber, @factor, @result);

	SET @factor = @factor - 1
	END
SELECT *
FROM @Results

--2) Определение чётных и нечётных чисел от 1 до N
--Условие:
--
--Пользователь вводит число N. Для каждого числа от 1 до N указать, является ли оно чётным или нечётным.
--Пример:
--
--Number	Type
--1	Odd
--2	Even
--3	Odd

--Задание 2. Вывод:
DECLARE @countNumbers INT = 10;
DECLARE @Results TABLE
(
userNumber INT,
type NVARCHAR(10)
)

WHILE (@countNumbers>=0)
BEGIN
	IF (@countNumbers %2 = 0)
	 INSERT INTO @Results VALUES (@countNumbers, 'Четное')
	ELSE
	INSERT INTO @Results VALUES (@countNumbers, 'Нечетное')
	SET @countNumbers = @countNumbers-1;
END

SELECT *
FROM @Results

--3) Таблица факториалов от 1 до N
--Условие:
--
--Пользователь вводит число N. Построить таблицу, где для каждого числа от 1 до N указано его факториальное значение (1 × 2 × ... × N).
--Пример вывода:
--Number	Factorial
--1	1
--2	2
--3	6
--4	24
--5	120

--Задание 3. Вывод:
DECLARE @userNumber INT = 10;
DECLARE @startNumber INT;
DECLARE @factorial INT;
DECLARE @Results TABLE
(
number INT,
factorial INT
)

WHILE (@userNumber > 0)
	BEGIN
	SET @startNumber = 1;
	SET @factorial = 1;

	WHILE (@startNumber<=@userNumber)
		BEGIN
			SET @factorial = @factorial * @startNumber;
			SET @startNumber = @startNumber + 1;
		END

	INSERT INTO @Results
	VALUES (@userNumber, @factorial);

	SET @userNumber = @userNumber - 1;
	END

SELECT *
FROM @Results
ORDER BY number

--4) Определение  чисел от N до N
--Условие:
--
--Пользователь вводит число N. Для каждого числа от N до N указать, является ли оно чётным или нечётным, положительным или отрицательным , кратная ли 5ти или нет

--Задание 4. Вывод:
DECLARE @userNumberStart INT = -20;
DECLARE @userNumberEnd INT = 20;
DECLARE @isEven NVARCHAR(8);
DECLARE @isPositive NVARCHAR(13);
DECLARE @isMultipleOf5 NVARCHAR(11);
DECLARE @Results TABLE
(
number INT,
is_even NVARCHAR(8),
is_positive NVARCHAR(13),
is_multiple_of_5 NVARCHAR(11)
);

WHILE (@userNumberStart<=@userNumberEnd)
	BEGIN
		IF (@userNumberStart%2=0)
			SET @isEven = 'Четное'
		ELSE
			SET @isEven = 'Нечетное';
		IF(@userNumberStart >= 0)
			SET @isPositive = 'Положительное'
		ELSE
			SET @isPositive = 'Отрицательное';
		IF (@userNumberStart%5 = 0)
			SET @isMultipleOf5 = 'Кратно 5'
		ELSE
			SET @isMultipleOf5 = 'Не кратно 5';
		INSERT INTO @Results VALUES (@userNumberStart,@isEven,@isPositive,@isMultipleOf5);
		SET @userNumberStart = @userNumberStart+ 1;

	END
SELECT *
FROM @Results