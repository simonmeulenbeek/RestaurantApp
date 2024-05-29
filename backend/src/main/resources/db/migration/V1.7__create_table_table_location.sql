-- Create 'table_locations' table
CREATE TABLE IF NOT EXISTS table_locations (
    table_id CHAR(36) NOT NULL,
    x_pos INTEGER,
    y_pos INTEGER,
    x_size INTEGER,
    y_size INTEGER,
    PRIMARY KEY (table_id),
    FOREIGN KEY (table_id) REFERENCES tables(id)
);

CREATE UNIQUE INDEX index_table_locations ON table_locations (table_id);