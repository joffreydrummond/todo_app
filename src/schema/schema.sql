DROP DATABASE IF EXISTS todo_db;
CREATE DATABASE todo_db;
USE todo_db;

DROP TABLE IF EXISTS users;
CREATE TABLE users(
user_id int NOT NULL AUTO_INCREMENT,
first_name char(50) NOT NULL,
last_name char(50) NOT NULL ,
email_address char(50) NOT NULL,
phone_number char(10) NOT NULL,
PRIMARY KEY(user_id)
);

DROP TABLE IF EXISTS status;
CREATE TABLE status(
status_id int NOT NULL AUTO_INCREMENT,
status int NOT NULL DEFAULT(1),
status_date datetime NOT NULL default(current_timestamp),
PRIMARY KEY(status_id)
);

DROP TABLE IF EXISTS todos;
CREATE TABLE todos(
todo_id int NOT NULL AUTO_INCREMENT,
todo_content char(255) not null,
created_date datetime NOT NULL default(current_timestamp),
user_id int NOT NULL,
status_id int NOT NULL DEFAULT(1),
PRIMARY KEY(todo_id),
FOREIGN KEY(user_id) REFERENCES users(user_id),
FOREIGN KEY(status_id) REFERENCES status(status_id)
);

INSERT INTO users(first_name, last_name, email_address, phone_number)
VALUES("Jim", "Fresh", "jimfresh@freshmode.com", "6235551234");
INSERT INTO users(first_name, last_name, email_address, phone_number)
VALUES("Fred", "Fresh", "fred@redfred.com", "2535551234");
INSERT INTO users(first_name, last_name, email_address, phone_number)
VALUES("Sally", "Fresh", "sally@sally.com", "7125554521");

INSERT INTO status(status)
VALUES(1);
INSERT INTO status(status)
VALUES(2);
INSERT INTO status(status)
VALUES(3);

INSERT INTO todos(todo_content, user_id)
VALUES("Grocery shopping", 1);
INSERT INTO todos(todo_content, user_id)
VALUES("Wash car", 2);
INSERT INTO todos(todo_content, user_id)
VALUES("Feed dog", 3);