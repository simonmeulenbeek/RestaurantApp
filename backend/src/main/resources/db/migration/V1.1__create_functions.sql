DELIMITER //

CREATE PROCEDURE InsertTestDataIfTableIsEmpty(
    IN tableName VARCHAR(64),
    IN insertData TEXT
)
BEGIN
    DECLARE tableIsEmpty BOOLEAN;

    -- Controleer of de tabel leeg is
    SET @checkQuery = CONCAT('SELECT COUNT(*) = 0 INTO @tableIsEmpty FROM ', tableName);
    PREPARE stmt FROM @checkQuery;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;

    IF @tableIsEmpty THEN
        -- Voeg testgegevens in als de tabel leeg is
        SET @insertQuery = CONCAT('INSERT INTO ', tableName, ' ', insertData);
        PREPARE stmt FROM @insertQuery;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt;
    END IF;
END //

DELIMITER ;