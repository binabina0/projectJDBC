CREATE SCHEMA IF NOT EXISTS list;
USE list;

DROP TABLE IF EXISTS Zavkhoz;
CREATE TABLE Zavkhoz (id BIGINT PRIMARY KEY AUTO_INCREMENT, zavkhoz_username VARCHAR(80),zavkhoz_password VARCHAR(80));
INSERT INTO Zavkhoz (zavkhoz_username,zavkhoz_password) VALUES ('zavkhoz','zavkhoz123');

DROP TABLE IF EXISTS Deliveryman;
CREATE TABLE Deliveryman (id BIGINT PRIMARY KEY AUTO_INCREMENT, deliveryman_username VARCHAR(80),deliveryman_password VARCHAR(80));
INSERT INTO Deliveryman (deliveryman_username,deliveryman_password) VALUES ('deliveryman','deliveryman123');

DROP TABLE IF EXISTS Director;
CREATE TABLE Director (id BIGINT PRIMARY KEY AUTO_INCREMENT, director_username VARCHAR(80),director_password VARCHAR(80));
INSERT INTO Director (director_username,director_password) VALUES ('director','director123');

DROP TABLE IF EXISTS SchoolEquipment;
-- Create the table
CREATE TABLE SchoolEquipment (
    id SERIAL PRIMARY KEY,
    serial_number VARCHAR(50),
    equipment_name VARCHAR(100),
    category VARCHAR(50),
    quantity INT,
    price DECIMAL(10, 2),
    delivery_rate DECIMAL(10, 2) AS (0.02 * price),
    total_price DECIMAL(10, 2) AS (price + (0.02 * price)),
    purchase_date DATE
);

-- Sample insert statements
INSERT INTO SchoolEquipment (serial_number, equipment_name, category, quantity, price, purchase_date) VALUES
('SN001', 'Projector', 'Electronics', 5, 500.00, '2024-05-01'),
('SN002', 'Whiteboard', 'Furniture', 10, 150.00, '2024-05-02'),
('SN003', 'Laptop', 'Electronics', 15, 800.00, '2024-05-03'),
('SN004', 'Desk', 'Furniture', 20, 100.00, '2024-05-04'),
('SN005', 'Printer', 'Electronics', 8, 300.00, '2024-05-05'),
('SN006', 'Chair', 'Furniture', 25, 50.00, '2024-05-06'),
('SN007', 'Microscope', 'Science Equipment', 3, 1200.00, '2024-05-07'),
('SN008', 'Bookshelf', 'Furniture', 6, 200.00, '2024-05-08'),
('SN009', 'Desktop Computer', 'Electronics', 12, 1000.00, '2024-05-09'),
('SN010', 'Globe', 'Educational', 2, 80.00, '2024-05-10'),
('SN011', 'Calculator', 'Electronics', 30, 20.00, '2024-05-11'),
('SN012', 'Table', 'Furniture', 15, 120.00, '2024-05-12'),
('SN013', 'Projector Screen', 'Electronics', 5, 100.00, '2024-05-13'),
('SN014', 'Markers', 'Stationery', 50, 5.00, '2024-05-14'),
('SN015', 'Soccer Ball', 'Sports Equipment', 12, 15.00, '2024-05-15'),
('SN016', 'Lab Coat', 'Clothing', 20, 25.00, '2024-05-16'),
('SN017', 'Safety Goggles', 'Safety Equipment', 18, 8.00, '2024-05-17'),
('SN018', 'Musical Instruments', 'Arts', 7, 200.00, '2024-05-18'),
('SN019', 'Textbooks', 'Books', 40, 30.00, '2024-05-19'),
('SN020', 'Gym Equipment', 'Sports Equipment', 10, 400.00, '2024-05-20');

DROP TABLE IF EXISTS OrderedSchoolEquipment;
-- Create the table
CREATE TABLE OrderedSchoolEquipment (
    id SERIAL PRIMARY KEY,
    serial_number VARCHAR(50),
    equipment_name VARCHAR(100),
    category VARCHAR(50),
    quantity INT,
    price DECIMAL(10, 2),
    delivery_rate DECIMAL(10, 2) AS (0.02 * price),
    total_price DECIMAL(10, 2) AS (price + (0.02 * price)),
    ordered_date DATE
);

-- Sample insert statements
INSERT INTO OrderedSchoolEquipment (serial_number, equipment_name, category, quantity, price, ordered_date) VALUES
('SN021', 'Laptop', 'Electronics', 5, 800.00, '2024-05-01'),
('SN022', 'Desk', 'Furniture', 2, 100.00, '2024-05-02'),
('SN023', 'Projector', 'Electronics', 3, 500.00, '2024-05-03'),
('SN024', 'Whiteboard', 'Furniture', 1, 150.00, '2024-05-04'),
('SN025', 'Microscope', 'Science Equipment', 2, 1200.00, '2024-05-05'),
('SN026', 'Printer', 'Electronics', 4, 300.00, '2024-05-06'),
('SN027', 'Chair', 'Furniture', 3, 50.00, '2024-05-07'),
('SN028', 'Bookshelf', 'Furniture', 2, 200.00, '2024-05-08'),
('SN029', 'Desktop Computer', 'Electronics', 3, 1000.00, '2024-05-09'),
('SN030', 'Projector Screen', 'Electronics', 2, 100.00, '2024-05-10');


-- Drop the table if it already exists
DROP TABLE IF EXISTS DeliveredSchoolEquipment;

-- Create the table
CREATE TABLE DeliveredSchoolEquipment (
    id SERIAL PRIMARY KEY,
    serial_number VARCHAR(50),
    equipment_name VARCHAR(100),
    category VARCHAR(50),
    quantity INT,
    price DECIMAL(10, 2),
    delivery_rate DECIMAL(10, 2) AS (0.02 * price),
    total_price DECIMAL(10, 2) AS (price + (0.02 * price)),
    delivered_date DATE
);

-- Sample insert statements
INSERT INTO DeliveredSchoolEquipment (serial_number, equipment_name, category, quantity, price, delivered_date) VALUES
('SN001', 'Projector', 'Electronics', 5, 500.00, '2024-05-01'),
('SN002', 'Whiteboard', 'Furniture', 10, 150.00, '2024-05-02'),
('SN003', 'Laptop', 'Electronics', 15, 800.00, '2024-05-03'),
('SN004', 'Desk', 'Furniture', 20, 100.00, '2024-05-04'),
('SN005', 'Printer', 'Electronics', 8, 300.00, '2024-05-05'),
('SN006', 'Chair', 'Furniture', 25, 50.00, '2024-05-06'),
('SN007', 'Microscope', 'Science Equipment', 3, 1200.00, '2024-05-07'),
('SN008', 'Bookshelf', 'Furniture', 6, 200.00, '2024-05-08'),
('SN009', 'Desktop Computer', 'Electronics', 12, 1000.00, '2024-05-09'),
('SN010', 'Globe', 'Educational', 2, 80.00, '2024-05-10'),
('SN011', 'Calculator', 'Electronics', 30, 20.00, '2024-05-11'),
('SN012', 'Table', 'Furniture', 15, 120.00, '2024-05-12'),
('SN013', 'Projector Screen', 'Electronics', 5, 100.00, '2024-05-13'),
('SN014', 'Markers', 'Stationery', 50, 5.00, '2024-05-14'),
('SN015', 'Soccer Ball', 'Sports Equipment', 12, 15.00, '2024-05-15'),
('SN016', 'Lab Coat', 'Clothing', 20, 25.00, '2024-05-16'),
('SN017', 'Safety Goggles', 'Safety Equipment', 18, 8.00, '2024-05-17'),
('SN018', 'Musical Instruments', 'Arts', 7, 200.00, '2024-05-18'),
('SN019', 'Textbooks', 'Books', 40, 30.00, '2024-05-19'),
('SN020', 'Gym Equipment', 'Sports Equipment', 10, 400.00, '2024-05-20');
