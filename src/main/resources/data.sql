USE test;

INSERT INTO products
(name, title_x, price, quantity, created_at, updated_at)
VALUES
    ('Tablet', 'Android Tablet', 22000.00, 12, NOW(), NOW()),
    ('Smartwatch', 'Fitness Smartwatch', 12000.00, 18, NOW(), NOW()),
    ('Keyboard', 'Mechanical Keyboard', 4500.00, 30, NOW(), NOW()),
    ('Mouse', 'Wireless Mouse', 1800.00, 40, NOW(), NOW()),
    ('Monitor', '4K Monitor', 28000.00, 8, NOW(), NOW()),
    ('Printer', 'Laser Printer', 16000.00, 6, NOW(), NOW()),
    ('Speaker', 'Bluetooth Speaker', 6500.00, 25, NOW(), NOW()),
    ('Camera', 'Mirrorless Camera', 85000.00, 4, NOW(), NOW()),
    ('Router', 'WiFi 6 Router', 7500.00, 15, NOW(), NOW()),
    ('PowerBank', '20000mAh Power Bank', 3200.00, 35, NOW(), NOW()),
    ('Charger', '65W Fast Charger', 2500.00, 50, NOW(), NOW()),
    ('SSD', '1TB NVMe SSD', 9000.00, 20, NOW(), NOW()),
    ('HardDisk', '2TB External HDD', 7000.00, 14, NOW(), NOW()),
    ('Microphone', 'USB Condenser Microphone', 11000.00, 9, NOW(), NOW()),
    ('Webcam', 'Full HD Webcam', 5500.00, 16, NOW(), NOW()),
    ('Projector', 'Full HD Projector', 42000.00, 3, NOW(), NOW()),
    ('Gamepad', 'Wireless Game Controller', 3800.00, 22, NOW(), NOW()),
    ('Earbuds', 'Noise Cancelling Earbuds', 8000.00, 28, NOW(), NOW()),
    ('SmartTV', '55 Inch Smart TV', 60000.00, 7, NOW(), NOW()),
    ('Console', 'Gaming Console', 50000.00, 5, NOW(), NOW());

INSERT INTO patients (name, age, gender, address, phone_number, created_at)
VALUES
    ('John Doe', 30, 'Male', '123 Main Street, Delhi', '9876543210', NOW()),
    ('Priya Sharma', 25, 'Female', '45 MG Road, Bangalore', '9123456789', NOW()),
    ('Amit Verma', 40, 'Male', '78 Civil Lines, Lucknow', '9988776655', NOW()),
    ('Neha Gupta', 35, 'Female', '22 Park Avenue, Mumbai', '9090909090', NOW()),
    ('Rahul Singh', 28, 'Male', '56 Sector 18, Noida', '9191919191', NOW());



