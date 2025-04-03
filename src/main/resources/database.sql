DROP DATABASE IF EXISTS metro;

CREATE DATABASE metro;

USE metro;


CREATE TABLE ticket_windows(
    id INT AUTO_INCREMENT PRIMARY KEY,
    customerName VARCHAR(50),
    customerPeriod INT,
    lineNumber INT,
    reservation_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

