--2.1 SELECT 
--Select all records from the Employee table.
SELECT
    *
FROM
    employee;
--Select all records from the Employee table where last name is King.

SELECT
    *
FROM
    employee
WHERE
    lastname = 'King';
--Select all record from the Employee table where the first name is Andrew and REPORTSTO is NULL.

SELECT
    *
FROM
    employee
WHERE
    firstname = 'Andrew'
    AND reportsto IS NULL;

--2.2 ORDER BY
--Select all albums in Album table and sort result set in a descending order by title.

SELECT
    *
FROM
    album
ORDER BY
    title DESC;
--Select first name from Customer and sort result set in ascending order by city.

SELECT
    *
FROM
    customer
ORDER BY
    city ASC;

--2.3 INSERT INTO
--Insert two new records into Genre table

SELECT
    *
FROM
    genre;

INSERT INTO genre VALUES (
    26,
    'Show Tunes'
);

INSERT INTO genre VALUES (
    27,
    'Country'
);
--Insert two new records into Employee table.

INSERT INTO employee VALUES (
    9,
    'Kelly',
    'Charlie',
    'Janitor',
    '4',
    ''
);

INSERT INTO employee VALUES (
    10,
    'Reynolds',
    'Dennis',
    'Bartender'
);
--Insert two new records into Customer table.
INSERT
    INTO customer
VALUES ();
INSERT INTO customer VALUES ();

--2.4 UPDATE  
--Update Aaron Mitchell in Customer table to Robert Walter
SELECT * FROM customer;
UPDATE customer SET firstname = 'Robert', lastname = 'Walter' WHERE  firstname = 'Aaron' AND lastname = 'Mitchell';
--Update name of artist in the Artist table "Creedence Clearwater Revival" to "CCR"
SELECT * FROM artist
UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

--2.5 LIKE
--Select all invoices with a billing address like "T%"
SELECT billingaddress FROM invoice WHERE billingaddress like 'T%';

--2.6 BETWEEN
-- Select all invoices that have a total between 15 and 50
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;
--Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7 DELETE
--Delete a record in Customer table where the name is Robert Walter
 DELETE FROM invoiceline WHERE invoiceid IN (SELECT invoiceid FROM invoice WHERE customerid = (SELECT customerid FROM customer WHERE firstname ='Robert' AND lastname = 'Walter'));
 DELETE FROM invoice WHERE customerid = (SELECT customerid FROM customer WHERE firstname ='Robert' AND lastname = 'Walter');
 DELETE FROM customer WHERE firstname ='Robert' AND lastname = 'Walter';
 
--3.1 System Defined Functions
--Create a function that returns the current time.
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

--Ceate a function that returns the length of a mediatype from the mediatype table
create or replace function get_media_length(id IN INT)
return INT
IS len INT;
begin
  select LENGTH(name)
    INTO len
    FROM mediatype
    WHERE mediatypeid = id;
  RETURN len;
END;
/
DECLARE
id INT;
namevar VARCHAR2(50);
BEGIN
id := get_media_length(2);
SELECT mediatype.name INTO namevar FROM mediatype WHERE mediatype.mediatypeid = 2;
DBMS_OUTPUT.PUT_LINE('The length of ' || '"' || namevar || '"' || ' is ' || id || '.');
END;
/

--3.2 System Defined Aggregate Functions
--Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION get_invoice_avg RETURN NUMBER IS
    average NUMBER(3, 2);
BEGIN
    SELECT
        AVG(total)
    INTO average
    FROM
        invoice;

    RETURN average;
END;
/

SELECT
    get_invoice_avg()
FROM
    dual;
 
 --Task – Create a function that returns the most expensive track
CREATE OR REPLACE TYPE high_object AS OBJECT (
    name  VARCHAR(200),
    price   NUMBER(10,2)
);
/
CREATE OR REPLACE TYPE high_table AS
    TABLE OF high_object;
/

CREATE OR REPLACE FUNCTION get_high_price RETURN high_table AS
    v_high_table    high_table;
    highest_price   NUMBER(10, 2);
BEGIN
    SELECT
        MAX(unitprice)
    INTO highest_price
    FROM
        track;

    SELECT
        high_object(a.name, a.unitprice)
    BULK COLLECT
    INTO v_high_table
    FROM
        (
            SELECT
                name,
                unitprice
            FROM
                track
            WHERE
                unitprice = highest_price
        ) a;

    RETURN v_high_table;
END;
/

SELECT
    *
FROM
    TABLE ( get_high_price );

DROP FUNCTION get_high_price;
DROP TYPE high_table;
DROP TYPE high_object;
--3.3 User Defined Scalar Functions
--Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION get_avg_price RETURN NUMBER IS
    avg_price NUMBER(10, 2);
BEGIN
    SELECT
        AVG(unitprice)
    INTO avg_price
    FROM
        invoiceline;

    RETURN avg_price;
END;
/

SELECT
    get_avg_price()
FROM
    dual;

--3.4 User defined Table Value Functions
--Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE TYPE emp_object AS OBJECT (
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    birth_date DATE
    );
    /
    CREATE OR REPLACE TYPE emp_table AS TABLE OF emp_object;
    /
    CREATE or replace function get_emp_born
    return emp_table AS v_emp_table emp_table;
    BEGIN SELECT
    emp_object(e.firstname, e.lastname, e.birthdate)
BULK COLLECT
INTO v_emp_table
FROM
    (
        SELECT
            firstname,
            lastname,
            birthdate
        FROM
            employee
        WHERE
            birthdate >= ( '01-Jan-1968' )
    ) e;
    REUTRN v_emp_tablel;
END;
    /
SELECT
    *
FROM
    TABLE ( get_emp_born );
    
--5.0 Transactions
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).

CREATE OR REPLACE PROCEDURE pro_del_invoice (
    v_invoiceid IN invoice.invoiceid%TYPE
) IS
BEGIN
    DELETE FROM invoiceline
    WHERE
        invoiceid = v_invoiceid;

    dbms_output.put_line('Record with invoice id: '
                         || v_invoiceid
                         || ' has been deleted from the invoice and the invoiceline table.');
    COMMIT;
END;
/

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table

CREATE OR REPLACE PROCEDURE pro_insert_cust (
    v_customerid   IN   customer.customerid%TYPE,
    v_customerid   IN   customer.firstnameid%TYPE,
    v_customerid   IN   customer.lastnameid%TYPE,
    v_email        IN   customer.email%TYPE
) IS
BEGIN
    INSERT INTO customer (
        customerid,
        firstname,
        lastname,
        email
    ) VALUES (
        v_customerid,
        v_firstname,
        v_lastname,
        v_email
    );

    COMMIT;
    dbms_output.put_line('Id: '
                         || v_customerid
                         || ' First name: '
                         || v_firstname
                         || ' Last name: '
                         || v_lastname
                         || ' Email: '
                         || v_email
                         || ' inserted into Customer table.');

END pro_insert_cust;
/

--6.0 Triggers 
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER trg_insert AFTER INSERT ON employee
BEGIN 
DBMS_OUTPUT.PUT_LINE('Trigger fired  after insert because new row inserted.');
END;
/
SELECT * FROM employee;

--7.0 JOINS!
--7.1 Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT customer.firstname, customer.lastname, invoice.invoiceid
FROM customer
INNER JOIN invoice
ON customer.customerid = invoice.customerid;

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
FROM customer
FULL OUTER JOIN invoice ON customer.customerid = invoice.customerid;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT artist.name, album.title
FROM album
RIGHT JOIN artist ON artist.artistid = album.artistid;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM album
CROSS JOIN artist
ORDER BY artist.name ASC;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT a.firstname, a.lastname, b.firstname || ' ' || b.lastname AS "Manager"
FROM employee a, employee b
WHERE a.reportsto = b.employeeid;
