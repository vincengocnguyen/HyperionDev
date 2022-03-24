create table project (NUM varchar(50) NOT NULL, NAME varchar(50) NOT NULL, BUILD_TYPE varchar(50) NOT NULL, BUILD_ADDRESS varchar(50) NOT NULL, ERF_NUM varchar(50) NOT NULL, DEADLINE date NOT NULL, TOTAL_FEE decimal(15,2) UNSIGNED NOT NULL, AMOUNT_PAID decimal(15,2) UNSIGNED NOT NULL, STATUS varchar(20) NOT NULL, CONT_ID int NOT NULL, CUST_ID int NOT NULL, ARCH_ID int NOT NULL, PRIMARY KEY(NUM));

  
create table customer (ID int NOT NULL, FIRSTNAME varchar(50) NOT NULL, LASTNAME varchar(50) NOT NULL, PHONE_NUM char(10) NOT NULL, EMAIL varchar(50) NOT NULL, ADDRESS varchar(50) NOT NULL, PRIMARY KEY(ID));


create table contractor (ID int NOT NULL, FIRSTNAME varchar(50) NOT NULL, LASTNAME varchar(50) NOT NULL, PHONE_NUM char(10) NOT NULL, EMAIL varchar(50) NOT NULL, ADDRESS varchar(50) NOT NULL, PRIMARY KEY(ID));


create table architect (ID int NOT NULL, FIRSTNAME varchar(50) NOT NULL, LASTNAME varchar(50) NOT NULL, PHONE_NUM char(10) NOT NULL, EMAIL varchar(50) NOT NULL, ADDRESS varchar(50) NOT NULL, PRIMARY KEY(ID));

insert into project values ('MC100', 'Magna Carta', 'Apartment', 'High Street', '92', '2020-05-20', 15000000, 10000000, 'Not Completed', 1, 1, 1);

insert into contractor values (1, 'John', 'Smith', '929292', 'john@smith.com', 'Downing Street');

insert into customer values (1, 'Luke', 'Skywalker', '121212', 'luke@jedi.com', 'Tatoine');

insert into architect values (1, 'George', 'Lucas', '151515', 'george@lucas.com', 'Hollywood');


insert into project values ('KL100', 'Kings Landing', 'Castle', 'Westeros', '12', '2010-06-20', 125, 10, 'Not Completed', 2, 2, 2);

insert into contractor values (2, 'Jon', 'Snow', '151515', 'jon@snow.com', 'Winterfell');

insert into customer values (2, 'Joffrey', 'Lannister', '585858', 'dude@dude.com', 'Kings Landing');

insert into architect values (2, 'George', 'Martin', '989898', 'george@martin.com', 'Duststown');