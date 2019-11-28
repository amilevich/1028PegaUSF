SELECT * FROM Employee;
SELECT * FROM Employee WHERE lastname = 'King';
SELECT * FROM Employee WHERE firstname = 'Andrew' AND REPORTSTO IS NULL;
--order by
SELECT * FROM Album ;
SELECT * FROM Album ORDER BY TITLE DESC;
SELECT * FROM Customer;
SELECT * FROM Customer ORDER BY firstname ASC;

--INSERT INTO 
SELECT * FROM Genre;
INSERT INTO Genre(GenreId, name)
VALUES (26, 'Bachata');
INSERT INTO Genre(GenreId, name)
VALUES (27, 'Merengue');

--UPDATE
SELECT * FROM Customer;
UPDATE Customer
SET firstname = 'Robert' WHERE firstname = 'Aaron';
UPDATE Customer
SET lastname = 'Walter' WHERE lastname = 'Mitchell';
SELECT * FROM Artist;
UPDATE Artist
SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

--LIKE
SELECT * FROM Invoice;
SELECT * FROM Invoice WHERE billingaddress LIKE 'T%';

--BETWEEN
SELECT * FROM Invoice WHERE total BETWEEN 15 AND 50;
SELECT * FROM Employee;
SELECT * FROM Employee WHERE  hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';

-- DELETE
SELECT * FROM Customer;
DELETE FROM Customer WHERE firstname = 'Robert' AND lastname = 'Walter';
DELETE FROM Invoice WHERE CustomerId = '32';
SELECT * FROM Invoiceline;

--SQL FUNCTION

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
SELECT get_time() FROM dual;

CREATE OR REPLACE FUNCTION getlength(x IN VARCHAR2) 
RETURN INTEGER AS z VARCHAR(200);
BEGIN 
    z := LENGTH(x);
    RETURN z;
END;
/
SELECT getlength(name) FROM mediatype;
--3.2
CREATE OR REPLACE FUNCTION myavg
RETURN NUMBER AS totavg NUMBER(3,2);
BEGIN 
   SELECT AVG(total) INTO totavg FROM invoice;
    RETURN totavg;
END;
/
SELECT myavg FROM dual;
CREATE OR REPLACE TYPE high_object AS OBJECT (
    name  VARCHAR(200),
    price   NUMBER(10,2)
);
/
CREATE OR REPLACE TYPE high_table AS TABLE OF high_object;
/

CREATE or replace function get_high_price 
return high_table

AS
v_high_table high_table;
highest_price NUMBER(10,2);

BEGIN
SELECT MAX(unitprice) INTO highest_price
FROM track;
SELECT high_object(A.name,A.unitprice)
BULK COLLECT INTO v_high_table
FROM (SELECT name, unitprice FROM track WHERE unitprice = highest_price) A; RETURN v_high_table;
END;
/
SELECT * FROM TABLE(get_high_price);

--3.3 
CREATE or replace function get_avg_price 
return NUMBER IS
avg_price NUMBER(10,2);

BEGIN
SELECT AVG(unitprice) INTO avg_price
FROM invoiceline;
RETURN avg_price;
END;
/

SELECT get_avg_price() FROM DUAL;

--3.4 
create or replace function bornafter(x date)
return sys_refcursor is refcur sys_refcursor;
begin
    open refcur for 'select firstname, lastname from employee 
    where birthdate >= :x' using x;
    return refcur;
end;
/
declare 
x date;
fn employee.firstname%type;
ln employee.lastname%type;
returncur sys_refcursor;
begin
x := to_date('1968', 'yyyy');
select bornafter(x) into returncur from dual;
dbms_output.put_line('here');
    Loop
        fetch returncur into fn, ln;
        exit when returncur%notfound;
        DBMS_OUTPUT.PUT_LINE(fn || ' ' || ln);
    end loop;
end;
/
--Transactions
--delete Invoice
CREATE OR REPLACE PROCEDURE invoice1

(v_invoiceid IN invoice.invoiceid%TYPE) IS

BEGIN

DELETE FROM invoiceline WHERE invoiceid = v_invoiceid;

DELETE FROM invoice WHERE invoiceid = v_invoiceid;

DBMS_OUTPUT.PUT_LINE('Record with invoice id: ' || v_invoiceid || ' has been deleted from invoice and invoiceline table.');

COMMIT;

END;

/

--nested
CREATE OR REPLACE PROCEDURE pro_insert_cust (v_customerid IN customer.customerid%TYPE, 
v_firstname IN customer.firstname%TYPE,
v_lastname IN customer.lastname%TYPE,
v_email IN customer.email%TYPE) IS BEGIN
INSERT INTO CUSTOMER (customerid, firstname, lastname, email) 
VALUES (v_customerid, v_firstname, v_lastname, v_email);
COMMIT;
DBMS_OUTPUT.PUT_LINE('Id: ' || v_customerid || ' First name: ' ||
v_firstname || ' Last name: ' || v_lastname || ' Email: ' || v_email || ' inserted into Customer table.');
END pro_insert_cust;
/

--Triggers

-- AFTER/FOR
CREATE OR REPLACE TRIGGER trg_insert
AFTER INSERT ON employee
BEGIN
DBMS_OUTPUT.PUT_LINE('Trigger fired  after insert because new row inserted.');
END;
/
--JOINS

-- INNER
SELECT customer.firstname, customer.lastname, invoice.invoiceid

FROM customer

INNER JOIN invoice

ON customer.customerid = invoice.customerid;

--OUTER
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
FROM customer FULL OUTER JOIN invoice ON customer.customerid = invoice.customerid;

-- RIGHT
SELECT artist.name, album.title FROM album RIGHT JOIN artist ON artist.artistid = album.artistid;

-- CROSS
SELECT * FROM album CROSS JOIN artist ORDER BY artist.name ASC;

--SELF
SELECT a.firstname, a.lastname, b.firstname || ' ' || b.lastname AS "Manager"
FROM employee a, employee b WHERE a.reportsto = b.employeeid;