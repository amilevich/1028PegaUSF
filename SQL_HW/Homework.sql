--2.1 SELECT
--Task – Select all records from the Employee table.

SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
SELECT * FROM EMPLOYEE WHERE REPORTSTO IS NULL AND FIRSTNAME = 'Andrew';

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
--Task – Select first name from Customer and sort result set in ascending order by city

SELECT * FROM ALBUM ORDER BY TITLE DESC; --ORDER BY CITY DESC;
SELECT FIRSTNAME,CITY FROM CUSTOMER ORDER BY CITY ;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
--Task – Insert two new records into Employee table
--Task – Insert two new records into Customer table

INSERT INTO GENRE VALUES (26,'turkishjazz');
INSERT INTO GENRE VALUES (100,'frenchjazz');

INSERT INTO EMPLOYEE VALUES (9,	'Callahan2',	'Laura'	, 'IT Staff', 6	,'09-JAN-68','	04-MAR-04'	,'NW'	,'Lethbridge','AB',	'Canada','TH','+1 (403) 467-3351','+1 (403) 467-8772	','laura@chinookcorp.com');
INSERT INTO EMPLOYEE VALUES (10,	'Callahan3',	'Laura'	, 'IT Staff', 6	,'09-JAN-68','	04-MAR-04'	,'NW'	,'Lethbridge','AB',	'Canada','TH','+1 (403) 467-3351','+1 (403) 467-8772	','laura@chinookcorp.com');
INSERT INTO EMPLOYEE VALUES (11,null,null,null,null,null,null,null,null,null,null,null,null,null,);

INSERT INTO CUSTOMER VALUES (60,'Tim',	'Goyer',	'Apple Inc.'	,'1 Infinite Loop','	Cupertino	','CA',	'USA',	'95014',	'+1 (408) 996-1010',	'+1 (408) 996-1011',	'tgoyer@apple.com',	3);
INSERT INTO CUSTOMER VALUES (61,'Tim',	'Goyer',	'Apple Inc.'	,'1 Infinite Loop','	Cupertino	','CA',	'USA',	'95014',	'+1 (408) 996-1010',	'+1 (408) 996-1011',	'tgoyer@apple.com',	3);

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”

UPDATE CUSTOMER SET firstname = 'Robert', lastname= 'Walter' WHERE CustomerID = 32;
UPDATE ARTIST SET NAME = 'CCR' WHERE ARTISTID = 76;

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”

SELECT * FROM INVOICE WHERE billingaddress LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004

SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-2001' AND '01-MAR-2004';
DELETE FROM CUSTOMER WHERE NAME BETWEEN '01-JUN-2001' AND '01-MAR-2004';


--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).

 DELETE FROM invoiceline WHERE invoiceid IN
 (SELECT invoiceid FROM invoice WHERE customerid =
 (SELECT customerid FROM customer WHERE firstname ='Robert' AND lastname = 'Walter'));
 DELETE FROM invoice WHERE customerid = (SELECT customerid FROM customer WHERE firstname ='Robert' AND lastname = 'Walter');
 DELETE FROM customer WHERE firstname ='Robert' AND lastname = 'Walter';

--3.0 SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.

ALTER SESSION SET nls_date_format = 'HH12:MI:SS';
create or replace function sqltime
return DATE
IS cur_time DATE;
BEGIN
  SELECT CURRENT_TIMESTAMP
    INTO cur_time
    FROM dual;
  RETURN cur_time;
END;
/
SELECT sqltime() FROM dual;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
--Task – Create a function that returns the most expensive track

create or replace function invoice_avg
return NUMBER
IS ort NUMBER(3,2);
BEGIN
  SELECT AVG(total)
    INTO ort
    FROM INVOICE;
  RETURN ort;
END;
/
SELECT invoice_avg() FROM DUAL;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.

CREATE OR REPLACE TYPE emp_object AS OBJECT (
    first_name  VARCHAR(30),
    last_name VARCHAR2(30),
    birth_date   DATE
);
/
CREATE OR REPLACE TYPE emp_table AS TABLE OF emp_object;
/
CREATE or replace function birth
return emp_table AS collects emp_table;
BEGIN
SELECT emp_object(obj.firstname,obj.lastname,obj.birthdate)
BULK COLLECT INTO collects
FROM
(SELECT firstname, lastname, birthdate FROM employee WHERE birthdate >= ('01-Jan-1968')) obj;
RETURN collects;
END;
/
SELECT * FROM TABLE(birth);


--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).

CREATE OR REPLACE PROCEDURE deletion
(temp IN invoice.invoiceid%TYPE) IS BEGIN
DELETE FROM invoiceline WHERE invoiceid = temp; DELETE FROM invoice WHERE invoiceid = temp;
DBMS_OUTPUT.PUT_LINE('Record with invoice id: ' ||temp|| ' has been deleted from invoice and invoiceline table.');
COMMIT;
END;
/


--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER trg_insert
AFTER INSERT ON employee
BEGIN
DBMS_OUTPUT.PUT_LINE('Trigger fired  after insert because new row inserted.');
END;
/
INSERT INTO EMPLOYEE VALUES (12,	'Callahan3',	'Laura'	, 'IT Staff', 6	,'09-JAN-68','	04-MAR-04'	,'NW'	,'Lethbridge','AB',	'Canada','TH','+1 (403) 467-3351','+1 (403) 467-8772	','laura@chinookcorp.com');


--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT customer.firstname, customer.lastname,invoice.invoiceid, invoice.billingstate FROM customer
INNER JOIN invoice ON customer.customerid = invoice.customerid;


--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total FROM invoice
FULL OUTER JOIN customer ON customer.customerid = invoice.customerid;


--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT artist.name, album.title FROM album
RIGHT JOIN artist ON artist.artistid = album.artistid;


--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM artist CROSS JOIN album ORDER BY artist.name ASC; -- doesnt allow default asc



--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT a.firstname, a.lastname, b.firstname || b.lastname AS "Manager"
FROM employee a, employee b
WHERE a.reportsto = b.employeeid;


