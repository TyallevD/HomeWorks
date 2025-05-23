 CREATE DATABASE MiniBank
 GO
 USE MiniBank

 CREATE TABLE CreditCards
 (
 id INT PRIMARY KEY IDENTITY,
 owner NVARCHAR(60) NOT NULL,
 pin_code INT NOT NULL,
 card_number NVARCHAR(19) NOT NULL,
 amount MONEY NOT NULL,

 CONSTRAINT CK_pin_code CHECK (pin_code LIKE '[0-9][0-9][0-9][0-9]'),
 CONSTRAINT CK_card_number CHECK (card_number LIKE '[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]')
 );

 ALTER TABLE CreditCards
 ADD CONSTRAINT CK_amount CHECK (amount BETWEEN 0 AND 10000);

 INSERT INTO CreditCards (owner,card_number,pin_code,amount)
 	VALUES	('Иван Иванович','1234-1234-1234-1234',1234,7000),
 			('Петр Петрович','4321-4321-4321-4321',4321,5000);

 --1. Перевод денег между двумя пользователями (с проверкой достаточности средств)
 CREATE PROC MoneyTransfer
 @cardNumberSender NVARCHAR(19),
 @cardNumberReceiver NVARCHAR(19),
 @amount INT
 AS
 BEGIN
 	IF @amount > 0
 		BEGIN
 			BEGIN TRANSACTION
 			BEGIN TRY

 			UPDATE CreditCards
 			SET amount = amount - @amount
 			WHERE card_number LIKE @cardNumberSender;

 			UPDATE CreditCards
 			SET amount = amount + @amount
 			WHERE card_number LIKE @cardNumberReceiver;

 			COMMIT;
 			END TRY

 			BEGIN CATCH
 				PRINT ('Ошибка перевода');
 				ROLLBACK;
 			END CATCH;
 		END;
 	ELSE
 		BEGIN
 			PRINT ('Нельзя отправить деньги');
 		END;
 END;
 -- проверка выполнения:

 --2. Пополнение карты через процедуру с транзакцией