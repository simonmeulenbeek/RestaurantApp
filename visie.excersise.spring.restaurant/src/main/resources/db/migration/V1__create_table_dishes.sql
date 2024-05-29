-- Create 'dishes' table
CREATE TABLE IF NOT EXISTS dishes (
    id INTEGER PRIMARY KEY,
    name VARCHAR(128) NOT NULL,
    price DECIMAL(3, 2) NOT NULL
)