
DROP TABLE IF EXISTS user;


CREATE TABLE users (
    id BIGINT IDENTITY PRIMARY KEY,
    name VARCHAR(50)
);


INSERT INTO users VALUES (1, 'Adrian');
INSERT INTO users VALUES (2, 'Ian');
INSERT INTO users VALUES (1, 'Melissa');
INSERT INTO users VALUES (2, 'Ariel');