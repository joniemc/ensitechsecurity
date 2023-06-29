DROP TABLE IF EXISTS tbl_user;
DROP TABLE IF EXISTS tbl_logg;

CREATE TABLE tbl_user(
    user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(15),
    user_password VARCHAR(90),
    user_state VARCHAR(5),
    user_login INT
);

CREATE TABLE tbl_logg(
    logg_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(15),
    logg_path VARCHAR(35),
    logg_date TIMESTAMP
);
