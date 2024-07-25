-- create ADDRESS and PERSON

CREATE TABLE PERSON(
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1001, INCREMENT BY 1),
    firstname CHAR(30),
    lastname CHAR(30),
    ssn VARCHAR(20)
);

CREATE TABLE ADDRESS(
    addrid INTEGER NOT NULL PRIMARY KEY
      GENERATED ALWAYS AS IDENTITY
        (START WITH 101, INCREMENT BY 1),
    id INT NOT NULL,
    street CHAR(50),
    city CHAR(50),
   state VARCHAR(20),
   zip VARCHAR(20)     
 );

INSERT INTO PERSON (firstname, lastname, ssn) VALUES ('John','Smith','555882121');
INSERT INTO PERSON (firstname, lastname, ssn)  VALUES
('Joe','Richards','535811101');
INSERT INTO PERSON (firstname, lastname, ssn)  VALUES
('Anna','Davis','678884121');
INSERT INTO ADDRESS (id, street, city, state, zip) VALUES
 (1001, '10 Adams St.', 'Fairfield', 'IA', '52556');
INSERT INTO ADDRESS (id, street, city, state, zip)  VALUES
 (1002, '3210 Pleasant Plains Rd.', 'Fairfield', 'IA', '52556');
INSERT INTO ADDRESS (id, street, city, state, zip)  VALUES
 (1003, '313 Main St.', 'Fairfield', 'IA', '52556');

 SELECT firstname, street FROM PERSON P, ADDRESS A WHERE P.id = A.id;