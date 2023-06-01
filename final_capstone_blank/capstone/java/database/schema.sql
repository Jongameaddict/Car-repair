--BEGIN TRANSACTION;

DROP TABLE IF EXISTS repair_status;
DROP TABLE IF EXISTS repair_costs;
-- DROP TABLE IF EXISTS admins;
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