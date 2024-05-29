CREATE DATABASE IF NOT EXISTS restaurant;
CREATE USER IF NOT EXISTS 'restaurant_user' IDENTIFIED BY 'restaurant_password';
GRANT ALL PRIVILEGES ON restaurant.* to 'restaurant_user'@'%';
FLUSH PRIVILEGES;
USE restaurant;