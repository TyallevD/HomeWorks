CREATE DATABASE SportingShop
GO
USE SportingShop

CREATE TABLE [Type]
(
	Id INT PRIMARY KEY IDENTITY,
	[Name] NVARCHAR(50) NOT NULL CHECK([Name] !=' '),

	CONSTRAINT UQ_Type_Name UNIQUE([Name])
)


CREATE TABLE Fabricator
(
	Id INT PRIMARY KEY IDENTITY,
	[Name] NVARCHAR(50) NOT NULL CHECK([Name] !=' ') ,

	CONSTRAINT UQ_Fabricator_Name UNIQUE([Name])
)


CREATE TABLE Products
(
	Id INT PRIMARY KEY IDENTITY,
	[Name] NVARCHAR(50) NOT NULL ,
	PrimeCost MONEY NOT NULL ,
	TypeId INT NOT NULL,
	FabricatorId INT NOT NULL,
	[Cost] MONEY NOT NULL ,

	CONSTRAINT CK_Sales_Cost CHECK([Cost]>0),
	CONSTRAINT FK_Product_TypeId FOREIGN KEY (TypeId) REFERENCES [Type](Id),
	CONSTRAINT UQ_Product_Name UNIQUE([Name]),
	CONSTRAINT CK_Product_Name CHECK([Name] !=' '),
	CONSTRAINT CK_Product_PrimeCost CHECK(PrimeCost>0),
	CONSTRAINT FK_Product_FabricatorId FOREIGN KEY (FabricatorId) REFERENCES Fabricator(Id)
)


CREATE TABLE Storage
(
    Id INT PRIMARY KEY IDENTITY,
	ProductId INT NOT NULL,
	Quantity INT NOT NULL,

	CONSTRAINT CK_Storage_Quantity  CHECK(Quantity >= 0),
	CONSTRAINT FK_Storage_ProductId FOREIGN KEY (ProductId) REFERENCES Products(Id)
)


CREATE TABLE Positions
(
	Id INT PRIMARY KEY IDENTITY,
	[Name] NVARCHAR(50) NOT NULL CHECK([Name] !=' ') ,

	CONSTRAINT UQ_Positions_Name UNIQUE([Name])
)


CREATE TABLE Employees
(
     Id INT PRIMARY KEY IDENTITY,
	 FullName NVARCHAR(50) NOT NULL ,
	 PositionId INT NOT NULL,
 	 EmploymentDate DATE NOT NULL ,
	 Gender NVARCHAR(5) NOT NULL ,
	 Salary MONEY NOT NULL ,

	 CONSTRAINT UQ_Employees_FullName UNIQUE(FullName),
	 CONSTRAINT CK_Employees_FullName CHECK(FullName!=' '),
	 CONSTRAINT CK_Employees_Gender CHECK(Gender IN('Man','Woman')),
	 CONSTRAINT CK_Employees_EmploymentDate CHECK(EmploymentDate <= GETDATE()),
	 CONSTRAINT FK_Employees_PositionId FOREIGN KEY (PositionId) REFERENCES Positions(Id),
)


CREATE TABLE Clients
(
		Id INT PRIMARY KEY IDENTITY,
		FullName NVARCHAR(50) NOT NULL  ,
		Email NVARCHAR(50) NOT NULL ,
		Phone NVARCHAR(50) NOT NULL   ,
		Gender NVARCHAR(10) NOT NULL ,
		Discount FLOAT NOT NULL,
		IsSubcribe BIT NOT NULL ,
		DateSubcribe DATE ,

		 CONSTRAINT UQ_Clients_FullName UNIQUE(FullName),
		 CONSTRAINT CK_Clients_FullName CHECK(FullName!=' '),
		 CONSTRAINT CK_Clients_Email CHECK(Email != ' '),
		 CONSTRAINT CK_Clients_Phone CHECK(Phone != ' '),
		 CONSTRAINT CK_Clients_Discount CHECK(Discount BETWEEN 0 AND 90), -- vozmojnaya skidka 0-90%
		 CONSTRAINT CK_Clients_Gender CHECK(Gender IN('Man','Woman'))
)

CREATE TABLE History
(
	Id INT PRIMARY KEY IDENTITY,
	ClientId INT NOT NULL,
	ProductId INT NOT NULL,
	[Date] DATE NOT NULL,

	CONSTRAINT CK_History_Date CHECK([Date] <= GETDATE()),
	CONSTRAINT FK_History_ClientId FOREIGN KEY (ClientId) REFERENCES Clients(Id),
	CONSTRAINT FK_History_ProductId FOREIGN KEY (ProductId) REFERENCES Products(Id)
)

CREATE TABLE Sales
(
	Id INT PRIMARY KEY IDENTITY,
	Quantity INT NOT NULL,
	[Date] DATE NOT NULL ,
	EmployeeId INT NOT NULL,
	ClientId INT NOT NULL,
	StorageId  INT NOT NULL,

	CONSTRAINT CK_Sales_Date CHECK([Date] <= GETDATE()),
	CONSTRAINT CK_Sales_Quantity  CHECK(Quantity > 0),
	CONSTRAINT FK_Sales_EmployeeId FOREIGN KEY (EmployeeId) REFERENCES Employees(Id),
	CONSTRAINT FK_Sales_ClientId FOREIGN KEY (ClientId) REFERENCES Clients(Id),
	CONSTRAINT FK_Sales_StorageId FOREIGN KEY (StorageId) REFERENCES Storage(Id)
)




--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------

insert into [Type] (Name) values ('Protection');
insert into [Type] (Name) values ('Training apparatus');
insert into [Type] (Name) values ('Clothing');


insert into Fabricator (Name) values ('Adidas');
insert into Fabricator (Name) values ('Puma');
insert into Fabricator (Name) values ('Nike');
insert into Fabricator (Name) values ('Reebok');


--Protection
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (179,'Capo two side', 21, 1, 3);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (218,'Capo professional', 55, 1, 1);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (232,'Capo for champion', 89, 1, 4);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (182,'Capo one side', 45, 1, 3);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (170,'Capo', 36, 1, 2);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (117,'Capo for junior', 12, 1, 3);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (109,'Capo Power', 44, 1, 1);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (207,'Capo mini', 39, 1, 4);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (144,'Wrestling gloves', 37, 1, 1);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (213,'Boxing gloves', 26, 1, 2);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (212,'KickBoxing gloves', 49, 1, 3);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (178,'Taekwondo gloves', 33, 1, 4);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (145,'MMA gloves', 37, 1, 1);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (149,'UFC gloves', 26, 1, 2);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (236,'Karate gloves', 26, 1, 2);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (161,'Wrestling Helmet', 21, 1, 1);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (140,'Boxing Helmet', 44, 1, 2);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (175,'KickBoxing Helmet', 42, 1, 3);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (143,'Taekwondo Helmet', 31, 1, 4);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (156,'MMA Helmet', 54, 1, 1);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (172,'UFC Helmet', 55, 1, 2);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (173,'Karate Helmet', 34, 1, 2);
 --Training apparatus  ,
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (152,'Press chair professional', 18, 2, 2);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (123,'Press chair little', 32, 2, 3);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (230,'Press chair big', 11, 2, 1);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (222,'Press chair iron', 44, 2, 4);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (130,'Press chair D232', 11, 2, 1);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (192,'Press chair Space X', 44, 2, 4);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (102,'Running track for sporsmen',116, 2, 4);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (157,'Running track for children', 125, 2, 3);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (217,'Running track iron', 116, 2, 4);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (146,'Running track Space x', 137, 2, 2);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (199,'Running track rt2021', 127, 2, 3);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (172,'Running track professional', 142, 2, 1);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (117,'Running track for girl',116, 2, 4);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (207,'Running track zh1121', 125, 2, 3);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (195,'Running track xvqa9910', 116, 2, 4);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (131,'Running track ZHOK34', 137, 2, 2);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (127,'Running track 5 functionals', 127, 2, 3);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (240,'Running track simple', 142, 2, 1);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (217,'Barbell 2 pair', 10, 2, 3);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (249,'Barbell 1 pair', 10, 2, 2);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (123,'Barbell 16kq', 28, 2, 1);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (239,'Barbell 2kq', 11, 2, 3);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (232,'Barbell 8kq', 27, 2, 4);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (108,'Bike simulator professional', 88, 2, 2);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (198,'Bike simulator 1 speed', 73, 2, 2);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (200,'Bike simulator simple', 63, 2, 2);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (132,'Bike simulator 2 speed', 77, 2, 1);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values ( 167,'Bike simulator 3 speed', 86, 2, 4);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (121,'Bike simulator 4 speed', 92, 2, 3);
insert into Products ( [Cost],[Name], PrimeCost, TypeId, FabricatorId) values (132,'Bike simulator SQ121', 49, 2, 3);
insert into Products  ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (143,'Bike simulator for children', 42, 2, 3);
insert into Products  ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (146,'Bike simulator 5 speed', 131, 2, 1);
--Clothing
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (199,'Kimono Taekwondo', 33, 3, 1);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (172,'Kimono Judo', 31, 3, 3);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (117,'Kimono man', 19, 3, 4);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (207,'Kimono woman', 27, 3, 4);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (195,'Kimono child', 11, 3, 3);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (131,'Kimono professional', 43, 3, 4);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (127,'Kimono simple', 41, 3, 2);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (240,'Kimono Aykido', 36, 3, 4);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (217,'Shoes for football', 41, 3, 1);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (218,'Shoes for basketball', 13, 3, 4);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (232,'Shoes 42 size', 25, 3, 1);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (182,'Shoes 41 szie', 13, 3, 2);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (170,'Shoes 40 size', 43, 3, 1);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (117,'Shoes simple', 25, 3, 4);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (109,'Shoes for girl', 13, 3, 3);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (207,'Shoes for child', 44, 3, 2);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (144,'Shoes for man', 34, 3, 2);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (213,'Shoes 39 size', 24, 3, 4);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (212,'Tights WRESTLINg', 41, 3, 1);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (154,'Tights sport', 25, 3, 4);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (163,'Tights 5mm', 43, 3, 2);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (111,'Tights 4mm', 21, 3, 2);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (193,'Tights for girl', 31, 3, 4);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (173,'Tights for runnign', 27, 3, 4);
insert into Products ([Cost],[Name], PrimeCost, TypeId, FabricatorId) values (122,'Tights for swimming', 22, 3, 3);


insert into Storage (ProductId, Quantity) values (1, 95);
insert into Storage (ProductId, Quantity) values (2, 89);
insert into Storage (ProductId, Quantity) values (3, 146);
insert into Storage (ProductId, Quantity) values (4, 73);
insert into Storage (ProductId, Quantity) values (5, 105);
insert into Storage (ProductId, Quantity) values (6, 180);
insert into Storage (ProductId, Quantity) values (7, 106);
insert into Storage (ProductId, Quantity) values (8, 185);
insert into Storage (ProductId, Quantity) values (9, 199);
insert into Storage (ProductId, Quantity) values (10, 192);
insert into Storage (ProductId, Quantity) values (11, 100);
insert into Storage (ProductId, Quantity) values (12, 89);
insert into Storage (ProductId, Quantity) values (13, 89);
insert into Storage (ProductId, Quantity) values (14, 190);
insert into Storage (ProductId, Quantity) values (15, 113);
insert into Storage (ProductId, Quantity) values (16, 101);
insert into Storage (ProductId, Quantity) values (17, 142);
insert into Storage (ProductId, Quantity) values (18, 192);
insert into Storage (ProductId, Quantity) values (19, 94);
insert into Storage (ProductId, Quantity) values (20, 86);
insert into Storage (ProductId, Quantity) values (21, 105);
insert into Storage (ProductId, Quantity) values (22, 138);
insert into Storage (ProductId, Quantity) values (23, 191);
insert into Storage (ProductId, Quantity) values (24, 133);
insert into Storage (ProductId, Quantity) values (25, 116);
insert into Storage (ProductId, Quantity) values (26, 101);
insert into Storage (ProductId, Quantity) values (27, 146);
insert into Storage (ProductId, Quantity) values (28, 103);
insert into Storage (ProductId, Quantity) values (29, 91);
insert into Storage (ProductId, Quantity) values (30, 110);
insert into Storage (ProductId, Quantity) values (31, 55);
insert into Storage (ProductId, Quantity) values (32, 56);
insert into Storage (ProductId, Quantity) values (33, 70);
insert into Storage (ProductId, Quantity) values (34, 115);
insert into Storage (ProductId, Quantity) values (35, 140);
insert into Storage (ProductId, Quantity) values (36, 49);
insert into Storage (ProductId, Quantity) values (37, 159);
insert into Storage (ProductId, Quantity) values (38, 189);
insert into Storage (ProductId, Quantity) values (39, 154);
insert into Storage (ProductId, Quantity) values (40, 109);
insert into Storage (ProductId, Quantity) values (41, 78);
insert into Storage (ProductId, Quantity) values (42, 55);
insert into Storage (ProductId, Quantity) values (43, 152);
insert into Storage (ProductId, Quantity) values (44, 166);
insert into Storage (ProductId, Quantity) values (45, 185);
insert into Storage (ProductId, Quantity) values (46, 75);
insert into Storage (ProductId, Quantity) values (47, 38);
insert into Storage (ProductId, Quantity) values (48, 58);
insert into Storage (ProductId, Quantity) values (49, 167);
insert into Storage (ProductId, Quantity) values (50, 154);
insert into Storage (ProductId, Quantity) values (51, 179);
insert into Storage (ProductId, Quantity) values (52, 128);
insert into Storage (ProductId, Quantity) values (53, 56);
insert into Storage (ProductId, Quantity) values (54, 151);
insert into Storage (ProductId, Quantity) values (55, 75);
insert into Storage (ProductId, Quantity) values (56, 185);
insert into Storage (ProductId, Quantity) values (57, 174);
insert into Storage (ProductId, Quantity) values (58, 131);
insert into Storage (ProductId, Quantity) values (59, 195);
insert into Storage (ProductId, Quantity) values (60, 98);
insert into Storage (ProductId, Quantity) values (61, 74);
insert into Storage (ProductId, Quantity) values (62, 102);
insert into Storage (ProductId, Quantity) values (63, 94);
insert into Storage (ProductId, Quantity) values (64, 189);
insert into Storage (ProductId, Quantity) values (65, 195);
insert into Storage (ProductId, Quantity) values (66, 164);
insert into Storage (ProductId, Quantity) values (67, 125);
insert into Storage (ProductId, Quantity) values (68, 68);
insert into Storage (ProductId, Quantity) values (69, 167);
insert into Storage (ProductId, Quantity) values (70, 59);
insert into Storage (ProductId, Quantity) values (71, 135);
insert into Storage (ProductId, Quantity) values (72, 134);
insert into Storage (ProductId, Quantity) values (73, 43);
insert into Storage (ProductId, Quantity) values (74, 55);
insert into Storage (ProductId, Quantity) values (75, 177);
insert into Storage (ProductId, Quantity) values (76, 96);
insert into Storage (ProductId, Quantity) values (77, 75);
insert into Storage (ProductId, Quantity) values (78, 162);
insert into Storage (ProductId, Quantity) values (79, 155);

insert into Positions (Name) values ('Consultant');
insert into Positions (Name) values ('Chief consultant')
insert into Positions (Name) values ('Manager');
insert into Positions (Name) values ('Trainee');
insert into Positions (Name) values ('General manager');



insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Woman','Oren Meran', 3, ' 2016-11-10', 500);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Woman','Woodrow Clowley', 1, '2017-11-07', 401);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Woman','Shanna Simenon', 2, '2017-05-07', 491);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Woman','Kit Gheorghe', 2, '2017-1-01', 371);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Woman','Gianna Twelvetree', 1, '2019-2-11', 329);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Woman','Fanya Yerrill', 5,   '2021-3-04', 289);






insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Woman','Hamlen Openshaw', 3, '2016-7-11', 284);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Woman','Yasmin Jarritt', 1,  '2019-08-02', 442);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Woman','Arch Cammell', 5,    '2018-05-03', 475);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Woman', 'Regina Sorrill', 1, '2018-03-06', 312);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Woman', 'Marcelline Messer', 1, '2017-6-02', 204);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Woman', 'Cara Durrance', 3, '2017-5-11', 271);


insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Woman', 'Letti Riveles', 4, '2020-6-11', 323);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Woman', 'Howie Wasiel', 1, '2017-2-04', 484);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Woman', 'Brunhilde Buten', 2, '2018-03-08', 330);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Woman', 'Dalt Bartoletti', 4, '2017-10-04', 475);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Woman', 'Sol Wherton', 5, '2017-8-11', 355);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Woman', 'Paten Leckie', 4, '2019-9-03', 233);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Woman', 'Jennilee Marriage', 5, '2016-10-11', 388);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Waldon Megany', 3, '2019-05-03', 271);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Ardelia Trebilcock', 3, '2019-3-07', 400);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Karel Lardiner', 1, '2021-02-02', 473);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Ritchie Edmund', 4, '2017-06-08', 432);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Windham Trowle', 5, '2019-3-02', 496);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Cchaddie Portch', 5, '2018-4-11', 209);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Zed Janecek', 1, '2019-7-05', 370);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Giselle Nisius', 4, '2018-2-09', 447);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Ricky Grastye', 3, '2021-5-04', 477);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Nerta Creighton', 1, '2017-8-12', 329);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Debra Ramberg', 5, '2016-4-09', 244);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Jessalyn Varnham', 4, '2019-1-02', 388);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Thorndike Birtonshaw', 2, '2018-2-11', 437);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Thorstein Bristowe', 5, '2021-5-04', 443);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Goran Kopacek', 1, '2016-1-10', 318);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Iggy McEntagart', 5, '2017-9-10', 463);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Elbertina Tuke', 3, '2019-8-01', 467);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Miner MacRory', 3, '2019-9-01', 239);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Paolina Smallthwaite', 2, '2019-9-12', 207);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Leisha Tomkins', 5, '2018-9-09', 434);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Petunia Kareman', 2, '2020-8-12', 361);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Rutherford Boerderman', 1, '2017-03-03', 397);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Walt Tetlow', 3, '2019-7-11', 398);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Derby De Normanville', 3, '2017-05-01', 367);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Mahala Davson', 1, '2018-6-06', 214);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Elita Glandfield', 5, '2018-5-07', 349);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Louisa Musicka', 3, '2021-4-05', 245);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Dalton MacParland', 4, '2017-3-09', 457);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Leanna Pinnington', 1, '2018-2-07', 386);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Rafferty Meijer', 5, '2018-09-05', 362);
insert into Employees (Gender, FullName, PositionId, EmploymentDate, Salary) values ('Man', 'Kiri Doughill', 5,  '2016-11-09', 439);



insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Woman','Angie Smaling', 'asmaling0@canalblog.com', '503-775-9438', 15, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman','Gaultiero Cammack', 'gcammack1@hatena.ne.jp', '120-675-4940', 43, 1,'2018-08-04');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Woman','Aveline de Cullip', 'ade2@mediafire.com', '425-465-2791', 30, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Woman','Ethel Stirley', 'estirley3@photobucket.com', '761-605-4286', 19, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman','Fanchon Bollans', 'fbollans4@ow.ly', '909-428-5610', 40, 1,'2019-02-19');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Woman','Pearline Bane', 'pbane5@mayoclinic.com', '841-363-3705', 4, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman','Pet McGurgan', 'pmcgurgan6@slate.com', '237-359-4676', 27, 1,'2018-11-17');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman','Caril Mainstone', 'cmainstone7@ebay.co.uk', '772-185-0079', 23, 1,'2021-02-15');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Woman','Cullie Hinks', 'chinks8@live.com', '508-597-9403', 45, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Woman', 'Britt Tolotti', 'btolotti9@tamu.edu', '814-219-9350', 16, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman', 'Yuma Skerritt', 'yskerritta@pen.io', '106-772-4356', 15, 1,'2020-09-07');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Woman', 'Currey Semken', 'csemkenb@dmoz.org', '872-784-8398', 19, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Woman', 'Clementia Almon', 'calmonc@networkadvertising.org', '120-772-7612', 30, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman', 'Marjory Pabelik', 'mpabelikd@jalbum.net', '567-301-5830', 36, 1,'2019-07-25');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman', 'Viviana Flahive', 'vflahivee@nydailynews.com', '403-301-4996', 2, 1,'2020-07-26');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Woman', 'Beret Fooks', 'bfooksf@xinhuanet.com', '710-203-3060', 13, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman', 'Wilfrid Faust', 'wfaustg@java.com', '859-693-7841', 27, 1,'2017-07-22');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Woman', 'Michell Yuryatin', 'myuryatinh@stumbleupon.com', '950-288-1405', 35, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman', 'Dyna Bladon', 'dbladoni@hp.com', '536-718-5195', 2, 1,'2018-07-03');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman', 'Gibby Titterell', 'gtitterellj@ox.ac.uk', '734-500-1988', 6, 1,'2021-03-24');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman', 'Darcy Knightsbridge', 'dknightsbridgek@msn.com', '982-814-5631', 17, 1,'2019-04-26');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman', 'Tiphany Kinig', 'tkinigl@ask.com', '514-153-9987', 28, 1,'2018-06-12');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman', 'Mayor Segrott', 'msegrottm@jugem.jp', '866-598-9051', 10, 1,'2019-09-25');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman', 'Guenevere Wolfe', 'gwolfen@europa.eu', '491-120-6720', 22, 1,'2019-01-23');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman', 'Radcliffe Samber', 'rsambero@t.co', '688-993-8781', 23, 1,'2018-12-26');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman', 'Roberto Hiseman', 'rhisemanp@dell.com', '475-636-6782', 12, 1,'2017-06-11');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Woman', 'Helga Yitzovitz', 'hyitzovitzq@mashable.com', '357-809-5525', 2, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman', 'Diane Kovnot', 'dkovnotr@wp.com', '615-848-2994', 11, 1,'2018-01-25');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman', 'Aguistin Kitteridge', 'akitteridges@utexas.edu', '951-924-5781', 46, 1,'2020-12-03');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Woman', 'Woodie Lalor', 'wlalort@pen.io', '789-938-4786', 3, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman', 'Anissa Monument', 'amonumentu@go.com', '256-258-3548', 13, 1,'2018-07-08');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman', 'Viv Polye', 'vpolyev@whitehouse.gov', '775-761-7702', 35, 1,'2019-09-25');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman', 'Sasha Rimington', 'srimingtonw@goo.gl', '753-338-8025', 29, 1,'2019-08-07');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman', 'Michel Hargie', 'mhargiex@wiley.com', '368-379-6517', 1, 1,'2020-03-03');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Woman', 'Madelyn Brind', 'mbrindy@live.com', '925-900-4590', 17, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Woman', 'Carce MacGaughey', 'cmacgaugheyz@google.it', '799-811-4243', 47, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman', 'Jamey Bembrick', 'jbembrick10@ihg.com', '298-305-1476', 26, 1,'2020-08-17');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Woman', 'Hastie Walters', 'hwalters11@howstuffworks.com', '157-400-0202', 45, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Woman', 'Auberon Van Dalen', 'avan12@vinaora.com', '995-762-4275', 11, 1,'2018-03-15');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Leigh McGarrie', 'lmcgarrie13@google.com', '115-196-3740', 0, 1,'2018-06-28');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Mellisa Sives', 'msives14@deviantart.com', '308-837-8927', 47, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Hailee Lerner', 'hlerner15@surveymonkey.com', '913-862-0628', 50, 1,'2018-06-28');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Magdalen Rapport', 'mrapport16@aboutads.info', '789-223-7805', 5, 1,'2018-07-08');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Min Bacon', 'mbacon17@unblog.fr', '483-727-8062', 24, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Carney Lippo', 'clippo18@deviantart.com', '474-718-6189', 44, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Melodie Hamm', 'mhamm19@elegantthemes.com', '377-816-6322', 3, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Charmian Mullany', 'cmullany1a@behance.net', '710-588-5435', 12, 1,'2020-07-11');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Tyson Heino', 'theino1b@desdev.cn', '609-915-1880', 15, 1,'2019-08-21');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Bar Luciani', 'bluciani1c@microsoft.com', '580-635-7094', 44, 1,'2019-08-04');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Karoly Lanphier', 'klanphier1d@sun.com', '275-887-5858', 28, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Andrey Denham', 'adenham1e@forbes.com', '331-554-2544', 7, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Klement Hallor', 'khallor1f@forbes.com', '346-336-8256', 9, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Candice Andreucci', 'candreucci1g@cmu.edu', '728-271-2615', 20, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Sula Abramchik', 'sabramchik1h@hatena.ne.jp', '184-983-8653', 26, 1,'2018-04-06');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Mac Stoile', 'mstoile1i@huffingtonpost.com', '197-383-6827', 16, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Cornie Eldredge', 'celdredge1j@fotki.com', '954-181-8475', 40, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Adorne Dulson', 'adulson1k@ucla.edu', '925-129-3633', 36, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Westleigh Jobe', 'wjobe1l@nydailynews.com', '472-654-1082', 14, 1,'2019-11-06');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Celeste Bahike', 'cbahike1m@symantec.com', '563-490-7672', 10, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Sergeant Aubin', 'saubin1n@guardian.co.uk', '295-726-9300', 12, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Stanislaw Rolles', 'srolles1o@homestead.com', '303-526-0966', 41, 1,'2019-02-02');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Lindy Blune', 'lblune1p@prnewswire.com', '458-823-3392', 37, 1,'2020-06-30');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Christen Haulkham', 'chaulkham1q@wp.com', '249-723-4759', 0, 1,'2019-05-22');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Adrianne Seczyk', 'aseczyk1r@google.pl', '131-192-6748', 19, 1,'2017-11-30');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Lamont Thurling', 'lthurling1s@baidu.com', '894-199-7861', 1, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Lindsay Fallowes', 'lfallowes1t@buzzfeed.com', '430-671-6172', 48, 1,'2019-03-08');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Viviene Keenlyside', 'vkeenlyside1u@ed.gov', '263-145-0011', 45, 1,'2021-04-23');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Armin Pattrick', 'apattrick1v@archive.org', '940-750-9197', 28, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Vanny Shelton', 'vshelton1w@51.la', '898-782-9293', 31, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Evin Mitie', 'emitie1x@macromedia.com', '834-157-2074', 49, 1,'2018-11-15');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Myrtia Goodliffe', 'mgoodliffe1y@army.mil', '888-626-6997', 44, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Cammy MacKegg', 'cmackegg1z@ehow.com', '814-943-5821', 21, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Crystie Stiles', 'cstiles20@joomla.org', '658-292-8133', 12, 1,'2020-01-05');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Caresa Challace', 'cchallace21@usnews.com', '778-619-7904', 16, 1,'2020-04-02');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Rickie Crack', 'rcrack22@uiuc.edu', '388-198-2270', 41, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Aldous Tooker', 'atooker23@reverbnation.com', '628-992-9291', 16, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Ellyn Macauley', 'emacauley24@dailymotion.com', '434-170-5843', 21, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Ebonee O''Donnelly', 'eodonnelly25@npr.org', '405-302-3491', 44, 1,'2018-07-26');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Niel Lurcock', 'nlurcock26@rambler.ru', '564-113-1520', 43, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Tracey Tolerton', 'ttolerton27@thetimes.co.uk', '545-338-9305', 19, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Marji Dreakin', 'mdreakin28@dropbox.com', '695-313-8086', 31, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Elicia Knappett', 'eknappett29@blogtalkradio.com', '675-282-0684', 28, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Konstanze Chapling', 'kchapling2a@ameblo.jp', '297-997-3051', 25, 1,'2019-05-25');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Kessia Dufore', 'kdufore2b@posterous.com', '511-287-0901', 28, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Odille Gainfort', 'ogainfort2c@booking.com', '220-542-2093', 36, 1,'2018-09-12');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Clio Ciabatteri', 'cciabatteri2d@51.la', '676-364-0451', 24, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Tristam Lever', 'tlever2e@canalblog.com', '980-407-4731', 44, 1,'2020-05-29');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Zabrina Braunle', 'zbraunle2f@shutterfly.com', '432-228-2749', 16, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Rutherford Beevens', 'rbeevens2g@dyndns.org', '108-294-3405', 39, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Janeva Pattini', 'jpattini2h@cbsnews.com', '578-900-1629', 27, 1,'2018-07-11');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Marys Di Frisco', 'mdi2i@noaa.gov', '529-811-5618', 44, 1,'2017-09-14');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Ramsay Shorey', 'rshorey2j@1und1.de', '949-484-1743', 7, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Carree Dispencer', 'cdispencer2k@behance.net', '367-576-9643', 42, 1,'2017-09-02');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Launce Dudmarsh', 'ldudmarsh2l@vinaora.com', '275-271-7329', 50, 1,'2017-12-19');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Pierce Gush', 'pgush2m@imdb.com', '392-141-6233', 19, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Katusha Pinniger', 'kpinniger2n@cnet.com', '790-330-1034', 15, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man','Farlie Marquand', 'fmarquand2o@shareasale.com', '978-526-0842', 13, 1,'2018-02-15');
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Sonny Greenman', 'sgreenman2p@whitehouse.gov', '938-396-5294', 12, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe) values ('Man','Lazare Rubinfeld', 'lrubinfeld2q@omniture.com', '908-808-7437', 29, 0);
insert into Clients (Gender, FullName, Email, Phone, Discount, IsSubcribe,DateSubcribe) values ('Man', 'Marley Hawtry', 'mhawtry2r@rediff.com', '707-597-7491', 6, 1,'2020-07-21');



insert into History (ClientId, ProductId, [Date]) values (86, 70, '2017-05-12');
insert into History (ClientId, ProductId, [Date]) values (91, 11, '2017-02-25');
insert into History (ClientId, ProductId, [Date]) values (16, 36, '2020-07-10');
insert into History (ClientId, ProductId, [Date]) values (83, 46, '2021-05-16');
insert into History (ClientId, ProductId, [Date]) values (81, 54, '2019-02-26');
insert into History (ClientId, ProductId, [Date]) values (64, 66, '2017-05-07');
insert into History (ClientId, ProductId, [Date]) values (97, 13, '2019-02-04');
insert into History (ClientId, ProductId, [Date]) values (58, 5,  '2016-09-22');
insert into History (ClientId, ProductId, [Date]) values (91, 28, '2020-07-27');
insert into History (ClientId, ProductId, [Date]) values (18, 16, '2017-02-05');
insert into History (ClientId, ProductId, [Date]) values (75, 43, '2019-06-29');
insert into History (ClientId, ProductId, [Date]) values (80, 12, '2017-07-17');
insert into History (ClientId, ProductId, [Date]) values (96, 55, '2018-08-12');
insert into History (ClientId, ProductId, [Date]) values (99, 13, '2018-06-19');
insert into History (ClientId, ProductId, [Date]) values (37, 7,  '2016-10-24');
insert into History (ClientId, ProductId, [Date]) values (16, 50, '2018-05-06');
insert into History (ClientId, ProductId, [Date]) values (23, 40, '2020-01-28');
insert into History (ClientId, ProductId, [Date]) values (86, 48, '2021-05-19');
insert into History (ClientId, ProductId, [Date]) values (63, 78, '2019-03-03');
insert into History (ClientId, ProductId, [Date]) values (48, 36, '2017-08-18');
insert into History (ClientId, ProductId, [Date]) values (98, 13, '2017-07-03');
insert into History (ClientId, ProductId, [Date]) values (100, 65,'2018-07-19');
insert into History (ClientId, ProductId, [Date]) values (46, 43, '2016-10-14');
insert into History (ClientId, ProductId, [Date]) values (85, 53, '2017-05-29');
insert into History (ClientId, ProductId, [Date]) values (36, 40, '2017-01-24');
insert into History (ClientId, ProductId, [Date]) values (96, 64, '2020-07-13');
insert into History (ClientId, ProductId, [Date]) values (38, 67, '2020-05-27');
insert into History (ClientId, ProductId, [Date]) values (44, 43, '2020-03-03');
insert into History (ClientId, ProductId, [Date]) values (42, 55, '2019-02-07');
insert into History (ClientId, ProductId, [Date]) values (14, 36, '2018-07-23');
insert into History (ClientId, ProductId, [Date]) values (26, 27, '2017-12-24');
insert into History (ClientId, ProductId, [Date]) values (30, 2,  '2020-03-16');
insert into History (ClientId, ProductId, [Date]) values (51, 45, '2020-06-29');
insert into History (ClientId, ProductId, [Date]) values (59, 51, '2017-06-11');
insert into History (ClientId, ProductId, [Date]) values (95, 48, '2017-11-03');
insert into History (ClientId, ProductId, [Date]) values (22, 17, '2019-02-11');
insert into History (ClientId, ProductId, [Date]) values (73, 56, '2017-01-09');
insert into History (ClientId, ProductId, [Date]) values (87, 6,  '2020-12-07');
insert into History (ClientId, ProductId, [Date]) values (76, 14, '2018-12-21');
insert into History (ClientId, ProductId, [Date]) values (42, 46, '2020-11-15');
insert into History (ClientId, ProductId, [Date]) values (8, 20,  '2016-10-26');
insert into History (ClientId, ProductId, [Date]) values (96, 61, '2019-11-18');
insert into History (ClientId, ProductId, [Date]) values (98, 61, '2018-01-02');
insert into History (ClientId, ProductId, [Date]) values (25, 23, '2019-05-10');
insert into History (ClientId, ProductId, [Date]) values (15, 66, '2018-05-22');
insert into History (ClientId, ProductId, [Date]) values (45, 31, '2020-01-28');
insert into History (ClientId, ProductId, [Date]) values (43, 47, '2020-02-22');
insert into History (ClientId, ProductId, [Date]) values (41, 72, '2018-04-13');
insert into History (ClientId, ProductId, [Date]) values (60, 7,  '2018-02-28');



insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (6, 50,  '2021-3-11',   6, 18);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (18, 44, '2020-2-20',   8, 17);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (94, 43, '2020-05-08',  1, 15);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (35, 13, '2019-01-31',  3, 11);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (30, 54, '2017-06-09',  8, 1);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (25, 64, '2020-08-11',  2, 14);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (79, 5,  '2017-10-15',  6, 4);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (38, 39, '2020-03-03',  9, 15);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (94, 55, '2018-11-18',  4, 8);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (5, 67,  '2018-10-02',  7, 7);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (18, 10, '2017-09-25',  7, 17);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (86, 61, '2016-11-17',  1, 18);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (50, 28, '2017-08-26',  8, 7);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (22, 64, '2018-09-09',  8, 11);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (42, 37, '2019-09-03',  10, 16);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (60, 69, '2018-01-03',  8, 17);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (75, 39, '2019-2-17',   3, 16);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (23, 52, '2019-1-09',   8, 4);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (97, 41, '2017-1-29',   2, 11);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (98, 76, '2018-02-03',  2, 11);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (14, 45, '2017-06-18',  5, 15);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (38, 12, '2017-06-18',  8, 7);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (26, 79, '2019-02-10',  9, 1);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (12, 8,  '2021-02-17',  2, 16);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (4, 3,   '2021-02-06',  1, 17);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (66, 29, '2020-03-11',  1, 3);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (3, 51,  '2018-09-22',  4, 1);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (95, 61, '2018-11-23',  7, 14);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (78, 2,  '2019-11-26',  9, 16);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (25, 79, '2019-08-24',  4, 3);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (90, 63, '2019-12-04',  2, 12);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (8, 77,  '2017-05-22',  9, 12);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (99, 12, '2021-05-19',  1, 7);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (71, 30, '2016-09-25',  9, 14);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (32, 26, '2021-03-05',  4, 3);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (73, 65, '2019-04-06',  5, 14);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (6, 16,  '2019-08-26',  7, 17);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (9, 57,  '2020-11-03',  9, 8);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (66, 77, '2019-08-30',  7, 16);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (1, 43,  '2017-05-19',  3, 1);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (57, 2,  '2020-12-08',  7, 17);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (98, 25, '2020-04-15',  10, 12);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (52, 77, '2019-10-04',  7, 15);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (86, 8,  '2017-11-01',  2, 17);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (42, 3,  '2018-03-12',  4, 16);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (5, 13,  '2017-11-17',  3, 3);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (80, 43, '2019-03-20',  1, 1);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (96, 43, '2020-07-17',  3, 8);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (48, 46, '2018-05-17',  10, 16);
insert into Sales (ClientId, StorageId, [Date], Quantity, EmployeeId) values (54, 14, '2018-12-16',  6, 17);


--Задание 1: Архивирование удалённых товаров
--Таблицы: Products, ArchiveProducts
--Условие:
--При удалении товара из таблицы Products, информация о нём должна переноситься в ArchiveProducts.

--При выполнении задания возникли проблемы, т.к. удаление товаров из Products возможен только после очистки данных по этому товару из Storage, Sales, History
-- 1) из Storage (Склад) удаление оправдано, т.к. допустим это склад, если у нас больше нет товара - то на складе его тоже не должно быть,
-- поэтому удаление полное и не переносится в другую таблицу
-- 2) из Sales (продаж) можно перенести данные к примеру в ArchiveSales
-- 3) из History (истории продаж) так же данные переносятся в ArchiveHistory

--создание таблицы, куда будут переноситься удаленные товары
CREATE TABLE ArchiveProducts
(
id INT PRIMARY KEY IDENTITY,
product_id INT NOT NULL,
name NVARCHAR(50) NOT NULL,
prime_cost MONEY NOT NULL,
type_id INT NOT NULL,
fabricator_id INT NOT NULL,
cost MONEY NOT NULL
);

--создание таблицы, куда будут переноситься устаревшие продажи
CREATE TABLE ArchiveSales
(
id INT PRIMARY KEY IDENTITY,
sale_id INT NOT NULL,
quantity INT NOT NULL,
sale_date DATE NOT NULL,
employee_id INT NOT NULL,
client_id INT NOT NULL,
storage_id INT NOT NULL
);

--создание таблицы с архивной историей продаж
CREATE TABLE ArchiveHistory
(
id INT PRIMARY KEY IDENTITY,
history_id INT NOT NULL,
client_id INT NOT NULL,
product_id INT NOT NULL,
history_date DATE NOT NULL
);

--удаление таблиц
--DROP TABLE ArchiveProducts;
--DROP TABLE ArchiveSales;
--DROP TABLE ArchiveHistory;

--1) Триггер для переноса продаж (Sales) в архивные продажи (ArchiveSales)
CREATE TRIGGER ReplaceSalesToArchive
ON Sales
INSTEAD OF DELETE
AS
BEGIN
	DECLARE @storage_id INT = (SELECT DISTINCT StorageId FROM deleted);

	INSERT INTO ArchiveSales (sale_id, quantity, sale_date,employee_id,client_id,storage_id)
	SELECT Id, Quantity, Date, EmployeeId,ClientId,StorageId
	FROM
	deleted;

	DELETE FROM Sales WHERE StorageId = @storage_id;
END;

--Удаление триггера
--DROP TRIGGER ReplaceSalesToArchive

--Создание триггера для удаления данных со склада (Storage), удаление происходит полностью, т.к. смысла нет в архивном складе, товар на складе либо есть либо его нет.
CREATE TRIGGER DeleteFromStorage
ON Storage
INSTEAD OF DELETE
AS
BEGIN
	DECLARE @storage_id INT = (SELECT Id FROM deleted);

	DELETE FROM Sales WHERE Sales.StorageId = @storage_id;
	DELETE FROM Storage WHERE Storage.Id = @storage_id;
END;

--DROP TRIGGER DeleteFromStorage;

--Создание триггера на перенос истории (History) в архивную историю (ArchiveHistory)
CREATE TRIGGER ReplaceHistoryToArchiveHistory
ON History
INSTEAD OF DELETE
AS
BEGIN
	DECLARE @product_id INT = (SELECT DISTINCT ProductId FROM deleted);

	INSERT INTO ArchiveHistory (history_id, client_id, product_id, history_date)
	SELECT Id, ClientId, ProductId, Date
	FROM
	deleted;

	DELETE FROM History WHERE History.ProductId = @product_id;
END;

--Удаление триггера
--DROP TRIGGER ReplaceHistoryToArchiveHistory;

--Создание основного триггера для переноса продуктов (Products) в архивные продукты (ArchiveProducts)
--Перенос продукта будет осуществляться под одному, т.к. для очистки Products нужно почистить Историю (History), склад (Storage),
--а в свою очередь Склад можно почистить, если почистить продажи (Sales) и перенести их в архивные продажи (ArchiveSales)
CREATE TRIGGER ReplaceProductsToArchive
ON Products
INSTEAD OF DELETE
AS
BEGIN
	DECLARE @product_id INT = (SELECT id FROM deleted);
	DECLARE @storage_id INT = (SELECT Id FROM Storage WHERE Storage.ProductId = @product_id);

	INSERT INTO ArchiveProducts (product_id,name,prime_cost,type_id,fabricator_id,cost)
	SELECT Id,Name,PrimeCost,TypeId,FabricatorId,Cost
	FROM
	deleted;

	DELETE FROM Sales WHERE Sales.StorageId = @storage_id;
	DELETE FROM Storage WHERE Storage.ProductID = @product_id;
	DELETE FROM History WHERE History.ProductId = @product_id;
	DELETE FROM Products WHERE id = @product_id;
END;

--удаление триггера
--DROP TRIGGER ReplaceProductsToArchive;

--Проверка работы триггера на товаре, информация о котором есть во всех указанных таблицах:
DELETE FROM Products WHERE Id = 43;

--Задание 2: Запрет скидки больше 30%
--Таблица: Clients
--Условие:
--Создай триггер, который не позволяет вставлять нового клиента, если значение Discount больше 30.

--Создание триггера
CREATE TRIGGER CheckDiscountMore30
ON Clients
INSTEAD OF INSERT
AS
BEGIN
	DECLARE @discount FLOAT;
	SELECT @discount = Discount FROM inserted;

	IF @discount>30
		PRINT ('Скидка более 30% запрещена политикой компании');
	ELSE
		INSERT INTO Clients
		SELECT FullName, Email, Phone, Gender, Discount, IsSubcribe, DateSubcribe
		FROM inserted;
END;

--Удаление триггера
DROP TRIGGER CheckDiscountMore30;

--проверка триггера
INSERT INTO Clients
VALUES ('Егор Скидочный','egor@gmail.com','8-800-555-35-35','Man',45,1,GETDATE());

--корректный вариант вставки
INSERT INTO Clients
VALUES ('Егор Нескидочный','egor2@gmail.com','8-800-555-35-35','Man',30,1,GETDATE());

--Задание 3: Логирование обновления зарплаты
--Таблицы: Employees, EmployeeLog
--Условие:
--При обновлении записи в таблице Employees, если изменяется поле Salary, записывать:
--старую зарплату,
--новую зарплату,
--имя сотрудника,
--дату изменения
--в таблицу EmployeeLog.

--создание таблицы, куда будут вписываться изменения ЗП из Employees
CREATE TABLE EmployeeLogs
(
id INT PRIMARY KEY IDENTITY,
old_salary MONEY,
new_salary MONEY,
employee_full_name NVARCHAR (50),
salary_change_date DATE
);

--удаление таблицы
DROP TABLE EmployeeLogs;

--создание триггера
CREATE TRIGGER CheckEmployeesSalaryChanging
ON Employees
INSTEAD OF UPDATE
AS
BEGIN
	DECLARE @employee_id INT;
	DECLARE @old_salary MONEY;
	DECLARE @new_salary MONEY;
	DECLARE @employee_full_name NVARCHAR(50);

	SELECT @employee_id = id
	FROM inserted;
	SELECT @old_salary = Salary
	FROM deleted;
	SELECT @new_salary = Salary
	FROM inserted;
	SELECT @employee_full_name = FullName
	FROM inserted;

	INSERT INTO EmployeeLogs
	VALUES (@old_salary,@new_salary,@employee_full_name,GETDATE())

	UPDATE Employees
	SET Salary = @new_salary
	WHERE Employees.id = @employee_id;
END;

--проверка триггера
UPDATE Employees
SET Salary = 500.00
WHERE Employees.Id = 1;

--проверка, что запись попала в новую таблицу
SELECT *
FROM EmployeeLogs;




















