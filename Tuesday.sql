CREATE TABLE animals(
    animal_id NUMBER(6) PRIMARY KEY,--MAX ID POSSIBLE IS 999999
    animal_name VARCHAR2(100) NOT NULL,
    animal_leg_count NUMBER(3) CHECK (animal_leg_count > 0) NOT NULL
    );

SELECT * FROM animals;

INSERT INTO animals VALUES(1, 'Tom', 5);
INSERT INTO animals VALUES(2, 'Jerry', 7);
INSERT INTO animals VALUES(3, 'Spike', 2.5);
INSERT INTO animals VALUES(4, 'Nemo', 0);
INSERT INTO animals VALUES(5, 'Squidward', 8);

DROP TABLE animals;


CREATE TABLE food(
    food_id NUMBER(6) PRIMARY KEY,
    food_name VARCHAR2(50) NOT NULL,
    food_calories NUMBER(10),
    animal_id NUMBER(6),
    CONSTRAINT animal_id_fk FOREIGN KEY (animal_id) REFERENCES animals (animal_id)
);

SELECT * FROM food;

INSERT INTO food VALUES(1, 'baklava', 500, 5);
INSERT INTO food VALUES(2, 'cheese', 1000, 2);

/*
WHERE clause
use a WHERE clause to apply any condition to a CRUD operation
*/

SELECT * FROM animals WHERE animal_id > 2;
DELETE FROM animals WHERE animal_id=5;
DELETE FROM food WHERE food_id=1;

/*
REFERENTIAL INTEGRITY
the enforcement of foreign key relations.
It prevents a user from inserting a record into a table with a foreign key
that points to a non existent element.
It also prevents a user from deleting a record that another table is
referencing.
This is all to prevent orphan records, i.e. a record without a parent

DELETE CASCADE -> if this is deleted, delete all the records that hold a
reference 
*/

SELECT * FROM animals;
SELECT * FROM food;

UPDATE animals SET animal_name = 'DivaD' WHERE animal_id=3;

--ALTER
---used to change table/column related entities/constraints

CREATE TABLE numbers(
    stuff NUMBER(9)
    );
    
INSERT INTO numbers VALUES(1);
INSERT INTO numbers VALUES(2);
INSERT INTO numbers VALUES(3);

SELECT * FROM awesome_numbers;

ALTER TABLE numbers RENAME TO awesome_numbers;
ALTER TABLE awesome_numbers ADD CONSTRAINT check_num CHECK (stuff>0);
ALTER TABLE awesome_numbers DROP CONSTRAINT check_num;

TRUNCATE TABLE food;

CREATE TABLE employees(
    e_id NUMBER(3) PRIMARY KEY,
    e_name VARCHAR2(50) NOT NULL,
    e_salary NUMBER(9),
    e_title VARCHAR2(20)
    );

INSERT INTO employees VALUES(1, 'Chad', 500, 'janitor');
INSERT INTO employees VALUES(3, 'Kailey', 40000, 'carwasher');
INSERT INTO employees VALUES(7, 'Diva', 200000, 'awesome');
INSERT INTO employees VALUES(2, 'Wawa', 999999, 'gas station employee');
INSERT INTO employees VALUES(13, 'Cristian', 40000, 'carwasher');
INSERT INTO employees VALUES(12, 'Victor', 30000, 'gas station employee');
INSERT INTO employees VALUES(31, 'Stenson', 500000, 'Bawss');

SELECT * FROM employees;

/*
AGGREGATE FUNCTION
- functions that you apply to a column that will process all the data and return
a single value back
Example:
SUM()
AVG()
MAX()
MIN()
COUNT()
*/
SELECT SUM(e_salary) FROM employees;
SELECT COUNT(*) FROM employees;

SELECT SUM(e_salary), e_title FROM employees GROUP BY e_title;
SELECT COUNT(*), e_title FROM employees GROUP BY e_title;
-- group by -> combines results by the specified column

SELECT COUNT(*), e_title FROM employees GROUP BY e_title ORDER BY LOWER(e_title);

/*
SCALAR FUNCTION
- a function that applies to each cell of a column, i.e. alters the value within
each row 
Example:
LOWER()
UPPER()
ABS()
ROUND()
CONCAT()
LENGTH()
TRIM()
*/

SELECT UPPER(e_name), LOWER(e_title) FROM employees;

--HAVING
-- having is a conditional that can be applied to aggregate data
-- if GROUP BY is NOT used, HAVING behaves like WHERE

SELECT SUM(e_salary), 

