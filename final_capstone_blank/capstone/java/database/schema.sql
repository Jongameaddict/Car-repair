BEGIN TRANSACTION;


DROP TABLE IF EXISTS repair_service;
DROP TABLE IF EXISTS repair_types;
DROP TABLE IF EXISTS services;
DROP TABLE IF EXISTS cars;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS users;



CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE cars (
	car_id SERIAL,
	make varchar(50) NOT NULL,
	model varchar(50) NOT NULL,
	year int NOT NULL,
	color varchar(50) NOT NULL,
	description varchar(200),
	
	PRIMARY KEY(car_id)
);

CREATE TABLE repair_types(
	repair_id SERIAL,
	repair_type varchar(200) NOT NULL,
	price int NOT NULL,
	
	PRIMARY KEY(repair_id)
);

CREATE TABLE repair_service(
	repair_id int NOT NULL,
	service_id int NOT NULL,
	
	PRIMARY KEY(repair_id, service_id)
);

CREATE TABLE services(
	service_id SERIAL,
	car_id int NOT NULL,
	user_id int NOT NULL,
	
	PRIMARY KEY(service_id)
);

CREATE TABLE person(
	user_id int NOT NULL,
	firstname varchar(200) NOT NULL,
	lastname varchar(200) NOT NULL,
	username varchar(200) NOT NULL,
	email varchar(200) NOT NULL,
	phone int NOT NULL,
	
	
	PRIMARY KEY(user_id)
);

ALTER TABLE repair_service
ADD FOREIGN KEY (repair_id) REFERENCES repair_types(repair_id);

ALTER TABLE repair_service
ADD FOREIGN KEY (service_id) REFERENCES services(service_id);

ALTER TABLE services
ADD FOREIGN KEY (car_id) REFERENCES cars(car_id);

ALTER TABLE services
ADD FOREIGN KEY (user_id) REFERENCES users(user_id);

ALTER TABLE person
ADD FOREIGN KEY (user_id) REFERENCES users(user_id);

INSERT INTO repair_types(repair_type, price) VALUES
	('Oil Change', 40),
	('Brake Pad Replacement', 150),
	('Battery Replacement', 120),
	('Alternator Replacement', 350),
	('Radiator Replacement', 400),
	('Wheel Alignment', 100),
	('Headlight Bulb Replacement', 50),
	('Fuel Injector Cleaning', 100),
	('Timing Belt Replacement', 500),
	('Transmission Fluid Flush', 200);


COMMIT TRANSACTION;