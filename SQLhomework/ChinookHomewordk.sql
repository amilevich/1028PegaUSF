/*SQL HOMEWORD INVOLVED WITH THE CHINOOK*/

/*1. SELECTING ALL RECORDS FROM THE EMPLOYEE TABLE*/
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE LastName='King';
SELECT * FROM EMPLOYEE WHERE FirstName='Andrew' AND REPORTSTO IS NULL;

/*ORDER BY*/
SELECT * FROM ALBUM ORDER BY TITLE DESC;
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;

/*INSERT INTO*/
SELECT * FROM GENRE;
INSERT INTO GENRE (genreid,name) VALUES (26, 'Reggaeton');
INSERT INTO GENRE (genreid,name) VALUES (27, 'Trap');

SELECT * FROM EMPLOYEE;

INSERT INTO EMPLOYEE (employeeid, lastname, firstname, title, 
reportsto, birthdate, hiredate, address, city, state, country, postalcode, 
phone, fax, email) VALUES
(9, 'Rosario','Aleandro','IT STAFF',7,'01-DEC-94','01-DEC-07',
'123 SESAME ST','RICHPORT','FL','RICHSON','TTH HNH','+1 (205) 252-4465','+1 (403) 265-2121','rosario@outlook.com');

INSERT INTO EMPLOYEE (employeeid, lastname, firstname, title, 
reportsto, birthdate, hiredate, address, city, state, country, postalcode, 
phone, fax, email) VALUES
(10, 'Escobar','Pablo','SALES',10,'01-JAN-94','01-FEB-07',
'1050 RICHMOND ST','ICELAND','FL','FLEXVILLE','FGF YTT','+1 (105) 654-3512','+1 (403) 260-2171','escobar@outlook.com');

SELECT * FROM CUSTOMER;

INSERT INTO CUSTOMER (customerid,firstname,lastname,company,address,city,state,country,postalcode,phone,fax,email,supportrepid)
VALUES (60,'Samuel','Sanders','Revature','122 SILLY ST','RICHCITY','FL','USA','09874',
'+1 (550) 415-5561','+44 (36) 212-5454','sander@outlook.com',7);

INSERT INTO CUSTOMER (customerid,firstname,lastname,company,address,city,state,country,postalcode,phone,fax,email,supportrepid)
VALUES (61,'James','Kitten','Revature','165 SETTLE ST','ARKHAM','FL','USA','09874',
'+1 (550) 415-5561','+44 (36) 212-5454','kitten@outlook.com',10);

/*UPDATING*/
SELECT * FROM CUSTOMER;
UPDATE CUSTOMER SET FIRSTNAME = 'Robert' , LASTNAME = 'Walter' WHERE CUSTOMERID = 32;

SELECT * FROM ARTIST;
UPDATE ARTIST SET NAME='CCR' WHERE NAME='Creedence Clearwater Revival';

/*LIKE*/
SELECT * FROM INVOICE;
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

/*BETWEEN*/
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

/*DELETE*/
DELETE FROM invoiceline WHERE invoiceid IN 
 (SELECT invoiceid FROM invoice WHERE customerid = 
 (SELECT customerid FROM customer WHERE firstname ='Robert' AND lastname = 'Walter'));
 DELETE FROM invoice WHERE customerid = (SELECT customerid FROM customer WHERE firstname ='Robert' AND lastname = 'Walter');
 DELETE FROM customer WHERE firstname ='Robert' AND lastname = 'Walter';

/*SQL FUNTION*/
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

/*SYSTEM DEFINED AGGREGATE FUNCTIONS*/
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

/*SYSTEM AGGREGATE */
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

/*SCALAR FUNCTION*/
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

/*USER DEFINED TABLE VALUES*/
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

/*TRANSACTIONS*/

CREATE OR REPLACE PROCEDURE pro_invoice
(v_invoiceid IN invoice.invoiceid%TYPE) IS
BEGIN
DELETE FROM invoiceline WHERE invoiceid = v_invoiceid;
DELETE FROM invoice WHERE invoiceid = v_invoiceid;
DBMS_OUTPUT.PUT_LINE('Record with invoice id: ' || v_invoiceid || ' has been deleted from invoice and invoiceline table.');
COMMIT;
END;
/
--nested
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

/*TRIGGERS*/
    CREATE OR REPLACE TRIGGER trigger_insert
AFTER INSERT ON employee
BEGIN
DBMS_OUTPUT.PUT_LINE('Trigger fired  after insert because new row inserted.');
END;
/
/*INNER*/
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICE
FROM CUSTOMER
INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
/*OUTER*/
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
/*RIGHT*/
SELECT ARTIST.name, ALBUM.TITLE FROM ALBUM RIGHT JOIN ARTIST ON ARTIST.ARTISTID = ALBUM.ARTISTID;
/*CROSS*/
SELECT * FROM ALBUM CROSS JOIN ARTIST ORDER BY ARTIST.name ASC;
/*SELF*/
SELECT a.firstname, a.lastname, b.firstname || ' ' || b.lastname AS "Manager"
FROM employee a, employee b WHERE a.reportsto = b.employeeid;