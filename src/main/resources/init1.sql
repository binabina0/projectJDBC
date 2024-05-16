CREATE SCHEMA IF NOT EXISTS list;
USE list;

-- Drop the table if it already exists
DROP TABLE IF EXISTS Equipment;

-- Create Equipment Table
CREATE TABLE Equipment (
    EquipmentID INT PRIMARY KEY AUTO_INCREMENT,
    SerialNumber VARCHAR(50) NOT NULL UNIQUE,
    EquipmentName VARCHAR(100) NOT NULL,
    Category VARCHAR(100) NOT NULL,
    Quantity INT NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
    TotalPrice DECIMAL(10, 2) GENERATED ALWAYS AS (Quantity * Price) STORED,
    PurchaseDate DATE NOT NULL
);

-- Insert sample data into Equipment Table
INSERT INTO Equipment (SerialNumber, EquipmentName, Category, Quantity, Price, PurchaseDate)
VALUES
('SN123456', 'Dell Laptop', 'Computer', 10, 500.00, '2023-01-15'),
('SN654321', 'Epson Projector', 'Projector', 5, 300.00, '2022-11-10'),
('SN111222', 'Office Desk', 'Furniture', 15, 150.00, '2021-05-22'),
('SN333444', 'Office Chair', 'Furniture', 20, 75.00, '2020-07-30')
('SN555666', 'HP Desktop PC', 'Computer', 8, 700.00, '2023-03-20'),
('SN777888', 'Optoma Projector', 'Projector', 3, 600.00, '2022-09-05'),
('SN999000', 'Teachers Desk', 'Furniture', 5, 200.00, '2021-10-12'),
('SN112233', 'Student Desk', 'Furniture', 50, 50.00, '2020-12-01')
('SN444555', 'Lenovo ThinkPad', 'Computer', 15, 600.00, '2023-02-10'),
('SN666777', 'Sony Digital Camera', 'Electronics', 7, 400.00, '2022-08-15'),
('SN888999', 'Samsung Smartboard', 'Electronics', 4, 1200.00, '2021-11-25'),
('SN000111', 'Library Shelf', 'Furniture', 10, 100.00, '2020-09-20');

-- Drop the table if it already exists
DROP TABLE IF EXISTS OrderedEquipment;

-- Create OrderedEquipment Table
CREATE TABLE OrderedEquipment (
    OrderID INT PRIMARY KEY AUTO_INCREMENT,
    SerialNumber VARCHAR(50) NOT NULL UNIQUE,
    EquipmentName VARCHAR(100) NOT NULL,
    Category VARCHAR(100) NOT NULL,
    Quantity INT NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
    TotalPrice DECIMAL(10, 2) GENERATED ALWAYS AS (Quantity * Price) STORED,
    OrderDate DATE NOT NULL
);

-- Insert sample data into OrderedEquipment Table
INSERT INTO OrderedEquipment (SerialNumber, EquipmentName, Category, Quantity, Price, OrderDate)
VALUES
('SN987654', 'HP Printer', 'Office Supplies', 3, 200.00, '2024-05-15'),
('SN654987', 'Epson Scanner', 'Office Supplies', 2, 150.00, '2024-05-15'),
('SN123789', 'BenQ Monitor', 'Computer Accessories', 5, 250.00, '2024-05-15');

-- Drop the table if it already exists
DROP TABLE IF EXISTS DeliveredEquipment;

-- Create DeliveredEquipment Table
CREATE TABLE DeliveredEquipment (
    DeliveryID INT PRIMARY KEY AUTO_INCREMENT,
    SerialNumber VARCHAR(50) NOT NULL UNIQUE,
    EquipmentName VARCHAR(100) NOT NULL,
    Category VARCHAR(100) NOT NULL,
    Quantity INT NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
    TotalPrice DECIMAL(10, 2) GENERATED ALWAYS AS (Quantity * Price) STORED,
    DeliveryDate DATE NOT NULL
);

-- Insert sample data into DeliveredEquipment Table
INSERT INTO DeliveredEquipment (SerialNumber, EquipmentName, Category, Quantity, Price, DeliveryDate)
VALUES
('SN123456', 'Dell Laptop', 'Computer', 10, 500.00, '2023-01-15'),
('SN654321', 'Epson Projector', 'Projector', 5, 300.00, '2022-11-10'),
('SN111222', 'Office Desk', 'Furniture', 15, 150.00, '2021-05-22'),
('SN333444', 'Office Chair', 'Furniture', 20, 75.00, '2020-07-30')
('SN555666', 'HP Desktop PC', 'Computer', 8, 700.00, '2023-03-20'),
('SN777888', 'Optoma Projector', 'Projector', 3, 600.00, '2022-09-05'),
('SN999000', 'Teachers Desk', 'Furniture', 5, 200.00, '2021-10-12'),
('SN112233', 'Student Desk', 'Furniture', 50, 50.00, '2020-12-01')
('SN444555', 'Lenovo ThinkPad', 'Computer', 15, 600.00, '2023-02-10'),
('SN666777', 'Sony Digital Camera', 'Electronics', 7, 400.00, '2022-08-15'),
('SN888999', 'Samsung Smartboard', 'Electronics', 4, 1200.00, '2021-11-25'),
('SN000111', 'Library Shelf', 'Furniture', 10, 100.00, '2020-09-20');


