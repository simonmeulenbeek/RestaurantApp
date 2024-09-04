-- Create 'CustomerSession' table
CREATE TABLE IF NOT EXISTS customer_sessions (
    id CHAR(36) DEFAULT (uuid()),
    table_id CHAR(36) NOT NULL,
    FOREIGN KEY (table_id) REFERENCES tables(id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE UNIQUE INDEX index_customer_sessions ON customer_sessions(id);
CREATE INDEX index_customer_sessions_table ON customer_sessions(table_id);

