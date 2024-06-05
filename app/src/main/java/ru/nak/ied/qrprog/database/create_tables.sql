CREATE SCHEMA IF NOT EXISTS maintenance COLLATE = utf8_general_ci;
USE maintenance;

CREATE TABLE IF NOT EXISTS maintenance.users (
     id INT AUTO_INCREMENT PRIMARY KEY,
     personNum INT,
     name VARCHAR(255),
     surname VARCHAR(255),
     password INT
     );