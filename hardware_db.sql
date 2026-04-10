CREATE DATABASE hardware_db;
USE hardware_db;


DROP TABLE IF EXISTS hardware;

CREATE TABLE hardware (
    id INT PRIMARY KEY AUTO_INCREMENT,
    brand VARCHAR(100),
    spec INT,
    type VARCHAR(20)
);


ALTER TABLE hardware AUTO_INCREMENT = 1;


INSERT INTO hardware (brand, spec, type) VALUES
('Dell XPS 13', 16, 'Laptop'),
('Samsung S24', 50, 'Phone'),
('MacBook Pro', 32, 'Laptop'),
('iPhone 15', 48, 'Phone'),
('ASUS Zenbook', 16, 'Laptop'),
('Google Pixel 8', 50, 'Phone'),
('Lenovo Legion', 32, 'Laptop'),
('Huawei P60', 48, 'Phone'),
('HP Spectre', 16, 'Laptop'),
('Sony Xperia', 16, 'Phone');


SELECT * FROM hardware;

DROP DATABASE hardware_db;