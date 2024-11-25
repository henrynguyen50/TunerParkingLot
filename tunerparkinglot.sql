CREATE DATABASE TunerParkingLot;
USE TunerParkingLot;
CREATE TABLE Cars (
    id INT AUTO_INCREMENT PRIMARY KEY,
    make VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    makeyear VARCHAR(50) NOT NULL,
    color VARCHAR(20) NOT NULL,
    modifications TEXT,
    photo_url VARCHAR(255)
);

