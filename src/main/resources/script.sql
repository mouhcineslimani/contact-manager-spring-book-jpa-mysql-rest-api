DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id LONG,
    fullname VARCHAR(50),
    phone VARCHAR(20),
    address VARCHAR(40),
    PRIMARY KEY (id)
);
