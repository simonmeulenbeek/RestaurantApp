-- Create 'tablet_registrations' table
CREATE TABLE IF NOT EXISTS tablet_registrations (
    tablet_id CHAR(36) NOT NULL,
    table_id CHAR(36) NOT NULL,
    FOREIGN KEY (tablet_id) REFERENCES tablets(id),
    FOREIGN KEY (table_id) REFERENCES tables(id),
    PRIMARY KEY (tablet_id, table_id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE UNIQUE INDEX unique_index_tablet ON tablet_registrations (tablet_id, table_id);
CREATE UNIQUE INDEX tablet_id_index_tablet ON tablet_registrations (tablet_id);
CREATE INDEX table_id_index_tablet ON tablet_registrations (table_id);