DROP TABLE IF EXISTS greetings;
CREATE TABLE IF NOT EXISTS greetings  (
    id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    message VARCHAR(255) NOT NULL,
    username  VARCHAR(255) NOT NULL
);

INSERT INTO greetings(message, username) VALUES ('hello!', 'James');
INSERT INTO greetings(message, username) VALUES ('hello!!!', 'Jack');
INSERT INTO greetings(message, username) VALUES ('hello...', 'Jane');
INSERT INTO greetings(message, username) VALUES ('bye...', 'Janine');
INSERT INTO greetings(message, username) VALUES ('bye!', 'Jasmine');
INSERT INTO greetings(message, username) VALUES ('bye!!!', 'Nick');