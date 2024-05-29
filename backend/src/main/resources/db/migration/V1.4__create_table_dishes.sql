-- Create 'dishes' table
CREATE TABLE IF NOT EXISTS dishes (
    id CHAR(36) PRIMARY KEY DEFAULT (uuid()),
    name VARCHAR(128) NOT NULL,
    price DECIMAL(5, 2) NOT NULL
);

CREATE UNIQUE INDEX index_dishes ON dishes (name);
CREATE INDEX index_dishes_price ON dishes(price);