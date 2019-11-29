--2.1 SELECT
SELECT * FROM EMPLOYEE WHERE LastName='King';
SELECT * FROM EMPLOYEE WHERE FirstName='Andrew' AND REPORTSTO IS NULL;

--2.2 ORDER BY

SELECT * FROM ALBUM ORDER BY TITLE DESC;
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;

--2.3 INSERT INTO
SELECT * FROM GENRE;
INSERT INTO GENRE (genreid,name) VALUES (26, 'Podcast');
INSERT INTO GENRE (genreid,name) VALUES (27, 'Tech Reviews');

SELECT * FROM EMPLOYEE;

INSERT INTO EMPLOYEE (employeeid, lastname, firstname, title, 
reportsto, birthdate, hiredate, address, city, state, country, postalcode, 
phone, fax, email) VALUES
(9, 'da Great','david','CEO',NULL,'21-JUl-93','01-JAN-01',
'71869 New York Ave','New York','NY','United States','F3I 9U1 ','+1 (718) 101-5432','+1 (718) 2213-9045','Billy@gmail.com');

INSERT INTO EMPLOYEE (employeeid, lastname, firstname, title, 
reportsto, birthdate, hiredate, address, city, state, country, postalcode, 
phone, fax, email) VALUES
(10, 'Phantom','Danny','Intern',5,'01-JAN-15','01-FEB-19',
'1011 Pine ST','KANSAS CITY','KC','United States','GGD 3J5','+1 (485) 129-83452','+1 (132) 442-9953','ghost@gmail.com');

SELECT * FROM CUSTOMER;

INSERT INTO CUSTOMER (customerid,firstname,lastname,company,address,city,state,country,postalcode,phone,fax,email,supportrepid)
VALUES (60,'Tenticals','Squidward','KrustyKrabs','face Statue','Bikini Bottom','ATL','USA','84321',
'+1 (320) 111-0000','+1 (433) 999-4223','DontBotherMe@gmail.com',7);

INSERT INTO CUSTOMER (customerid,firstname,lastname,company,address,city,state,country,postalcode,phone,fax,email,supportrepid)
VALUES (61,'Scott','Michael','Dunder Mifflin','1725 Slough Ave','Scranton','PA','USA','94221',
'+1 (320) 123-4123','+1 (320) 210-2054','coolio@gmail.com',1);

--2.4 UPDATE
UPDATE CUSTOMER SET FIRSTNAME = 'Robert' , LASTNAME = 'Walter' WHERE CUSTOMERID = 32;

SELECT * FROM ARTIST;
UPDATE ARTIST SET NAME='CCR' WHERE NAME='Creedence Clearwater Revival';

--2.5 LIKE
SELECT * FROM INVOICE;
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7 DELETE
DELETE FROM invoiceline WHERE invoiceid IN 
 (SELECT invoiceid FROM invoice WHERE customerid = 
 (SELECT customerid FROM customer WHERE firstname ='Robert' AND lastname = 'Walter'));
 DELETE FROM invoice WHERE customerid = (SELECT customerid FROM customer WHERE firstname ='Robert' AND lastname = 'Walter');
 DELETE FROM customer WHERE firstname ='Robert' AND lastname = 'Walter';

--3.1 System Defined Functions
ALTER SESSION SET nls_date_format = 'HH12:MI:SS';
create or replace function get_time
return DATE
IS cur_time DATE;
BEGIN
  SELECT CURRENT_TIMESTAMP
    INTO cur_time
    FROM dual;
  RETURN cur_time;
END;
/
SELECT get_time() FROM dual;

--3.2 System Defined Aggregate Functions.1
create or replace function get_avg
return NUMBER
IS average NUMBER(3,2);
BEGIN
  SELECT AVG(total)
    INTO average
    FROM invoice;
  RETURN average;
END;
/
SELECT get_avg() FROM DUAL;

--3.2 System Defined Aggregate Functions.2
CREATE OR REPLACE TYPE high_track AS OBJECT (
    name  VARCHAR(200),
    price   NUMBER(10,2)
);
/
CREATE OR REPLACE TYPE track_table AS TABLE OF high_track;
/
CREATE or replace function get_high_track 
return track_table
AS
v_high_track high_track;
highest_price NUMBER(10,2);
BEGIN
SELECT MAX(unitprice) INTO highest_price
FROM track;
SELECT high_track(A.name,A.unitprice)
BULK COLLECT INTO v_high_track
FROM
(SELECT name, unitprice
FROM track WHERE unitprice = highest_price) A;
RETURN v_high_track;

END;
/
SELECT * FROM TABLE(get_high_price);

-- 3.3 User Defined Scalar Functions

CREATE or replace function get_avg
return NUMBER
IS
avg_price NUMBER(10,2);
BEGIN
SELECT AVG(unitprice) INTO avg_price
FROM invoiceline;
RETURN avg_price;
END;
/
SELECT get_avg() FROM DUAL;

-- 3.4 User Defined Table Valued Functions
CREATE OR REPLACE TYPE empobj AS OBJECT (
    firstname  VARCHAR(20),
    lastname VARCHAR2(20),
    birthdate   DATE
);
/
CREATE OR REPLACE TYPE emptable AS TABLE OF empobj;
/
CREATE or replace function emp_bod 
return emptable
AS
c_emp_table emptable;
BEGIN
SELECT empobj(A.firstname,A.lastname,A.birthdate)
BULK COLLECT INTO c_emp_table
FROM
(SELECT firstname, lastname, birthdate
FROM employee WHERE birthdate >= ('01-Jan-1968')) A;
RETURN v_emp_table;
END;
/
SELECT * FROM TABLE(get_emp_bod);

--5.0 TRANSACTIONS

CREATE OR REPLACE PROCEDURE pro_invoice
(v_invoiceid IN invoice.invoiceid%TYPE) IS
BEGIN
DELETE FROM invoiceline WHERE invoiceid = v_invoiceid;
DELETE FROM invoice WHERE invoiceid = v_invoiceid;
DBMS_OUTPUT.PUT_LINE('Record with invoice id: ' || v_invoiceid || ' has been deleted from invoice and invoiceline table.');
COMMIT;
END;
/
-- Nested
CREATE OR REPLACE PROCEDURE insert_cust (v_customerid IN customer.customerid%TYPE,
v_firstname IN customer.firstname%TYPE,
v_lastname IN customer.lastname%TYPE,
v_email IN customer.email%TYPE) IS BEGIN
INSERT INTO CUSTOMER (customerid, firstname, lastname, email)
VALUES (v_customerid, v_firstname, v_lastname, v_email);
COMMIT;
DBMS_OUTPUT.PUT_LINE('Id: ' || v_customerid || ' First name: ' ||
v_firstname || ' Last name: ' || v_lastname || ' Email: ' || v_email || ' inserted into Customer table.');
END insert_cust;

--6.0 TRIGGERS
    CREATE OR REPLACE TRIGGER trigger_insert
AFTER INSERT ON employee
BEGIN
DBMS_OUTPUT.PUT_LINE('Trigger fired  after insert because new row inserted.');
END;
/

--7.0 JOINS

--INNER
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICE
FROM CUSTOMER
INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--OUTER
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--RIGHT
SELECT ARTIST.name, ALBUM.TITLE FROM ALBUM RIGHT JOIN ARTIST ON ARTIST.ARTISTID = ALBUM.ARTISTID;

--CROSS 
SELECT * FROM ALBUM CROSS JOIN ARTIST ORDER BY ARTIST.name ASC;

--SELF 
SELECT a.firstname, a.lastname, b.firstname || ' ' || b.lastname AS "Manager"
FROM employee a, employee b WHERE a.reportsto = b.employeeid;