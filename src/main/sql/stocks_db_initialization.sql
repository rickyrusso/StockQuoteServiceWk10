/** create the stocks database */

DROP TABLE IF EXISTS stocks.person_quote CASCADE;
DROP TABLE IF EXISTS stocks.quotes CASCADE;
DROP TABLE IF EXISTS stocks.person CASCADE;

CREATE TABLE stocks.quotes(
                              ID INT NOT NULL AUTO_INCREMENT,
                              symbol VARCHAR(4) NOT NULL,
                              time DATETIME NOT NULL,
                              price DECIMAL(6,2) NOT NULL,
                              PRIMARY KEY ( id )
);

CREATE TABLE stocks.person(
                              ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                              first_name VARCHAR(256) NOT NULL,
                              last_name VARCHAR(256) NOT NULL,
                              birth_date DATETIME NOT NULL
);

CREATE TABLE stocks.person_quote
(
    ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    person_id INT NOT NULL,
    quote_id INT NOT NULL,
    FOREIGN KEY (person_id) REFERENCES stocks.person (ID),
    FOREIGN KEY (quote_id) REFERENCES stocks.quotes (ID)
);


INSERT INTO stocks.quotes (symbol,time,price) VALUES ('GOOG','2019-08-19 00:00:00','85.00');
INSERT INTO stocks.quotes (symbol,time,price) VALUES ('GOOG','2019-02-03 00:00:00','527.35');
INSERT INTO stocks.quotes (symbol,time,price) VALUES ('APPL','2019-01-01 00:00:00','118.27');
INSERT INTO stocks.quotes (symbol,time,price) VALUES ('AMZN','2019-02-03 00:00:00','363.21');

INSERT INTO stocks.person (first_name, last_name, birth_date) value ('Sundar', 'Pichai', '1972-6-10');
INSERT INTO stocks.person (first_name, last_name, birth_date) value ('Tim', 'Cook', '1960-11-1');
INSERT INTO stocks.person (first_name, last_name, birth_date) value ('Jeff', 'Bezos', '1964-1-12-');

INSERT INTO stocks.person_quote (person_id, quote_id) value (1, 1);
INSERT INTO stocks.person_quote (person_id, quote_id) value (1, 2);
INSERT INTO stocks.person_quote (person_id, quote_id) value (2, 3);
INSERT INTO stocks.person_quote (person_id, quote_id) value (3, 1);
INSERT INTO stocks.person_quote (person_id, quote_id) value (3, 2);
INSERT INTO stocks.person_quote (person_id, quote_id) value (3, 3);
INSERT INTO stocks.person_quote (person_id, quote_id) value (3, 4);