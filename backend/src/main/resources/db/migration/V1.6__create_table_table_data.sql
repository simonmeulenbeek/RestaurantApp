-- Create 'tables' table
CREATE TABLE IF NOT EXISTS tables (
    id CHAR(36) DEFAULT (uuid()),
    table_number INTEGER,
    CHECK (table_number>=1),
    PRIMARY KEY (id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE UNIQUE INDEX index_tables ON tables (id);