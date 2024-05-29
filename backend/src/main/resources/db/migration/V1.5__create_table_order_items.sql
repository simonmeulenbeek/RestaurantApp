-- Create 'order_items' table
CREATE TABLE IF NOT EXISTS order_items (
    order_id CHAR(36) NOT NULL,
    dish_id CHAR(36) NOT NULL,
    amount INTEGER NOT NULL,
    price_per_unit DECIMAL(5, 2) NOT NULL,
    CHECK (amount>=1),
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (dish_id) REFERENCES dishes(id),
    PRIMARY KEY (order_id, dish_id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE INDEX index_order_items ON order_items (order_id);