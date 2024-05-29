CREATE DATABASE IF NOT EXISTS restaurant;
CREATE USER IF NOT EXISTS 'flyway_user' IDENTIFIED BY 'flyway_password';
GRANT create user, reload ON *.* TO 'flyway_user';
GRANT ALL ON restaurant.* TO 'flyway_user';
GRANT GRANT OPTION ON restaurant.* TO 'flyway_user';

-- CREATE DATABASE IF NOT EXISTS 'restaurant';
-- CREATE USER IF NOT EXISTS flyway_user IDENTIFIED BY 'flyway_password';
-- GRANT ALL ON restaurant.* TO 'flyway_user'@'%';
-- GRANT CREATE_USER to flyway_user;