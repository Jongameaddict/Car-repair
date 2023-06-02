BEGIN TRANSACTION;


DROP TABLE IF EXISTS repair_service;
DROP TABLE IF EXISTS repair_types;
DROP TABLE IF EXISTS services;
DROP TABLE IF EXISTS cars;
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
	pickuptime time,
	
	PRIMARY KEY(service_id)
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



COMMIT TRANSACTION;
