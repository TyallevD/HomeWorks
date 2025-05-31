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
 	DECLARE @cardBalance MONEY;
 	SELECT @cardBalance = amount FROM CreditCards WHERE card_number = @cardNumberSender;

  	IF @amount > 0 AND EXISTS (SELECT card_number FROM CreditCards WHERE card_number = @cardNumberReceiver) AND EXISTS (SELECT card_number FROM CreditCards WHERE card_number = @cardNumberSender)
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
 				IF @amount > @cardBalance
 					BEGIN
 						PRINT ('Недостаточно средств');
 					END;
 				ELSE
 					BEGIN
  						PRINT ('Ошибка перевода');
 					END;
  				ROLLBACK;
  			END CATCH;
  		END;
  	ELSE
  		BEGIN
 			IF NOT EXISTS (SELECT card_number FROM CreditCards where card_number = @cardNumberSender)
  					BEGIN
  						PRINT ('Неверная карта отправителя');
  					END;
 			ELSE IF NOT EXISTS (SELECT card_number FROM CreditCards where card_number = @cardNumberReceiver)
  					BEGIN
  						PRINT ('Неверная карта получателя');
  					END;
 			ELSE
 				BEGIN
  					PRINT ('Нельзя отправить деньги');
 				END;
  		END;
  END;

  -- удаление процедуры:
 -- DROP PROCEDURE MoneyTransfer;

  -- проверка:
EXEC MoneyTransfer '1234-1234-1234-1234','4321-4321-4321-4321', 500 --успешное выполнение
EXEC MoneyTransfer '1234-1234-1234-1234','4321-4321-4321-4321', 6500 -- ошибка перевода (если средств достаточно, но у получателя достигнут верхний лимит в 10 тысяч)
EXEC MoneyTransfer '1234-1234-1234-1235','4321-4321-4321-4321', 500 -- неверная карта отправителя
EXEC MoneyTransfer '1234-1234-1234-1234','4321-4321-4321-4320', 500 -- неверная карта получателя
EXEC MoneyTransfer '1234-1234-1234-1234','4321-4321-4321-4321', 11500 -- недостаточно средств

 --2. Пополнение карты через процедуру с транзакцией
 CREATE PROC CardReplenishment
 @cardNumberReceiver NVARCHAR(19),
 @amount INT
 AS
 BEGIN
 	IF @amount > 0 AND EXISTS (SELECT card_number FROM CreditCards WHERE card_number = @cardNumberReceiver)
 		BEGIN
 			BEGIN TRANSACTION
 			BEGIN TRY
 				UPDATE CreditCards
 				SET amount = amount + @amount
 				WHERE card_number = @cardNumberReceiver;
 				COMMIT;
 			END TRY
 			BEGIN CATCH
 				PRINT ('Ошибка пополнения карты');
 				ROLLBACK;
 			END CATCH;
 			END;
 	ELSE
 		BEGIN
 		IF NOT EXISTS (SELECT card_number FROM CreditCards where card_number = @cardNumberReceiver)
 					BEGIN
 						PRINT ('Такой карты не существует');
 					END;
 		ELSE
 			BEGIN
 			PRINT ('Сумма пополнения должна быть больше нуля');
 			END;
 		END;
 END;

-- удаление процедуры
--DROP PROCEDURE CardReplenishment;

-- проверка:
 EXEC CardReplenishment '1234-1234-1234-1234', 11500 -- "ошибка пополнения карты" (т.к. верхний лимит 10 тысяч на карте)
 EXEC CardReplenishment '1234-1234-1234-1235', 500 -- ошибка "такой карты не существует"
 EXEC CardReplenishment '1234-1234-1234-1234', -500 -- ошибка "сумма пополнения должна быть больше нуля"
 EXEC CardReplenishment '1234-1234-1234-1234', 500 -- успешное выполнение