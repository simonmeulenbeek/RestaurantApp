-- Create 'orders' table
CREATE TABLE IF NOT EXISTS orders (
    id CHAR(36) DEFAULT (uuid()),
    session_id CHAR(36) NOT NULL,
    FOREIGN KEY (session_id) REFERENCES customer_sessions(id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE UNIQUE INDEX index_orders ON orders(id);
CREATE UNIQUE INDEX index_orders_session ON orders (session_id, id)