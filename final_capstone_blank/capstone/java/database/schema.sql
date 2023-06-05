--BEGIN TRANSACTION;

<<<<<<< HEAD

DROP TABLE IF EXISTS repair_service;
DROP TABLE IF EXISTS repair_types;
DROP TABLE IF EXISTS services;
DROP TABLE IF EXISTS cars;
DROP TABLE IF EXISTS person;
=======
DROP TABLE IF EXISTS repair_status;
DROP TABLE IF EXISTS repair_costs;
-- DROP TABLE IF EXISTS admins;
>>>>>>> main
DROP TABLE IF EXISTS users;
-- DROP TABLE IF EXISTS customers;
-- DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS car_info;

CREATE TABLE car_info (
	car_id SERIAL UNIQUE PRIMARY KEY,
	color varchar(50),
	make varchar(50),
	model varchar(50),
	year int
);



CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL
	--CONSTRAINT PK_user PRIMARY KEY (user_id)
--	CONSTRAINT fk_group_number FOREIGN KEY (group_number) REFERENCES interest_group(group_number),
);
--rollback

CREATE TABLE repair_costs (
	service_id SERIAL PRIMARY KEY,
	service_type varchar(50) NOT NULL,
	price int NOT NULL
	--CONSTRAINT FK_price FOREIGN KEY (price) REFERENCES employees(estimated_price)
);

--table for repair status
CREATE TABLE repair_status (
	car_id int NOT NULL,
	status varchar(50) NOT NULL,
	CONSTRAINT FK_car_id PRIMARY KEY (car_id)-- REFERENCES car_info(car_id)
);

<<<<<<< HEAD
CREATE TABLE cars (
	car_id SERIAL,
	make varchar(50) NOT NULL,
	model varchar(50) NOT NULL,
	year int NOT NULL,
	color varchar(50) NOT NULL,
	
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
	customer_id int NOT NULL,
	employee_id int NOT NULL,
	repair_status varchar(50) NOT NULL,
	payment_status varchar(50) NOT NULL,
	pickuptime timestamp,
	
	PRIMARY KEY(service_id)
);

CREATE TABLE person(
	user_id int NOT NULL,
	firstname varchar(200),
	lastname varchar(200),
	phone int,
	email varchar(200),
	address varchar(200),
	city varchar(200),
	state varchar(200),
	zipcode int,
	
	PRIMARY KEY(user_id)
);

ALTER TABLE repair_service
ADD FOREIGN KEY (repair_id) REFERENCES repair_types(repair_id);

ALTER TABLE repair_service
ADD FOREIGN KEY (service_id) REFERENCES services(service_id);

ALTER TABLE services
ADD FOREIGN KEY (car_id) REFERENCES cars(car_id);

ALTER TABLE services
ADD FOREIGN KEY (customer_id) REFERENCES users(user_id);

ALTER TABLE services
ADD FOREIGN KEY (employee_id) REFERENCES users(user_id);

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
=======

-- CREATE TABLE employees (
-- 	user_id int,
-- 	car_id int,
-- 	estimated_price int NOT NULL
--  	--CONSTRAINT PK_car_id PRIMARY KEY (car_id),
-- 	--CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES users(user_id)
-- );

-- CREATE TABLE customers (
-- 	user_id SERIAL,
-- 	car_id int NOT NULL,
-- 	estimated_price int NOT NULL,
-- 	approved_price boolean NOT NULL,
-- 	--CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES users(user_id),
-- 	CONSTRAINT FK_car_id FOREIGN KEY (car_id) REFERENCES employees(car_id)
-- 	--CONSTRAINT FK_price FOREIGN KEY (estimated_price) REFERENCES employees(estimated_price)
-- );

-- CREATE TABLE admins (
-- 	user_id SERIAL,
-- 	car_id int NOT NULL,
-- 	--CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES users(user_id),
-- 	CONSTRAINT FK_car_id FOREIGN KEY (car_id) REFERENCES employees(car_id)
-- );

--table for repair costs, one car to many prices
--rollback
--COMMIT TRANSACTION;

--SELECT * FROM customers
>>>>>>> main
