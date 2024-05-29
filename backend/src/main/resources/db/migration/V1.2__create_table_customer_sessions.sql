-- Create 'CustomerSession' table
CREATE TABLE IF NOT EXISTS customer_sessions (
    id CHAR(36) DEFAULT (uuid()),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE UNIQUE INDEX index_customer_sessions ON customer_sessions(id);