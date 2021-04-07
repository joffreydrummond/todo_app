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
status char(50) NOT NULL,
status_date datetime NOT NULL DEFAULT(current_timestamp),
PRIMARY KEY(status_id)
);

DROP TABLE IF EXISTS todos;
CREATE TABLE todos(
todo_id int NOT NULL AUTO_INCREMENT,
created_date datetime NOT NULL DEFAULT(current_timestamp),
user_id int NOT NULL,
status_id int NOT NULL,
PRIMARY KEY(todo_id),
FOREIGN KEY(user_id) REFERENCES users(user_id),
FOREIGN KEY(status_id) REFERENCES status(status_id)
);