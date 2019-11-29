--2.1 SELECT

SELECT * FROM EMPLOYEE;

SELECT * FROM EMPLOYEE 
WHERE EMPLOYEE.LASTNAME = 'King';

SELECT * FROM EMPLOYEE 
WHERE EMPLOYEE.FIRSTNAME = 'Andrew'
AND EMPLOYEE.REPORTSTO IS NULL;

--2.2 ORDER BY 
SELECT * FROM ALBUM ORDER BY ALBUM.TITLE DESC;

SELECT CUSTOMER.FIRSTNAME FROM CUSTOMER ORDER BY CUSTOMER.CITY ASC;

--2.3
INSERT INTO GENRE VALUES (26,'Dream Pop');
INSERT INTO GENRE VALUES (27,'Death Punk');

SELECT * FROM EMPLOYEE;

INSERT INTO EMPLOYEE(EMPLOYEEID,LASTNAME,FIRSTNAME,TITLE)
VALUES(9, 'Melo','Caio','PrettyCool');

INSERT INTO EMPLOYEE(EMPLOYEEID,LASTNAME,FIRSTNAME,TITLE)
VALUES(10, 'Anderson','Tim','OK');


INSERT INTO CUSTOMER(CUSTOMERID,FIRSTNAME,LASTNAME,COUNTRY,EMAIL)
VALUES (60,'Caio','Melo','Brazil','123@gmail.com');

INSERT INTO CUSTOMER(CUSTOMERID,FIRSTNAME,LASTNAME,COUNTRY,EMAIL)
VALUES (61,'Caroline','Ossy','USA','123@aol.com');

--2.4
UPDATE Customer
SET
LASTNAME = 'Walter',
FIRSTNAME = 'Robert'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

UPDATE ARTIST
SET
NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

--2.5 LIKE
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
SELECT * FROM INVOICE WHERE TOTAL>15 AND TOTAL<50;


SELECT * FROM EMPLOYEE WHERE HIREDATE > '01-JUN-03' 
AND HIREDATE < '01-MAR-04';

--2.7 DELETE
ALTER TABLE INVOICE
DROP CONSTRAINT FK_INVOICECUSTOMERID;
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';


--3.1 System Functions

SELECT SYSDATE FROM DUAL;

SELECT LENGTH(name) FROM MEDIATYPE;

---3.2
--Task – Create a function that returns the average total of all invoices DONE
--Task – Create a function that returns the most expensive track DONE

SELECT AVG(TOTAL) FROM INVOICE;

SELECT MAX(UNITPRICE) FROM TRACK;

--3.3
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table DONE

CREATE OR REPLACE FUNCTION return_invoice_avg_function
RETURN NUMBER
IS 
    invoice_avg_func NUMBER;
BEGIN 
    SELECT AVG(UNITPRICE)
    INTO invoice_avg_func
    FROM INVOICELINE;
    RETURN invoice_avg_func;
    -- Returning this gives me an error so i printed it instead.
END; 
/

SELECT RETURN_INVOICE_AVG_FUNCTION from DUAL;

--3.4
--Task – Create a function that returns all employees who are born after 1968.

CREATE OR REPLACE TYPE emp_obj AS OBJECT(
first_name VARCHAR2(20),
last_name VARCHAR2(20),
birth_date DATE
);
/

CREATE OR REPLACE TYPE emp_table AS TABLE OF emp_obj;
/

CREATE OR REPLACE FUNCTION ret_old_employees
RETURN emp_table
AS
new_emp_table emp_table;
BEGIN
SELECT emp_obj(tempTable.firstname,tempTable.lastname,tempTable.birthdate)
BULK COLLECT INTO new_emp_table
FROM
(SELECT firstname, lastname, birthdate
FROM employee WHERE BIRTHDATE > ('31-DEC-68'))tempTable;
RETURN new_emp_table;
END;
/

SELECT * FROM TABLE(ret_old_employees);


--5.0 
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them). DONE!

CREATE OR REPLACE PROCEDURE del_invoice(temp_invoiceId IN invoice.invoiceid%TYPE) IS
BEGIN
DELETE FROM invoiceline WHERE invoiceid = temp_invoiceid;
DELETE FROM invoice WHERE invoiceid = temp_invoiceid;
COMMIT;
END;
/

BEGIN 
del_invoice(216);
END;
/
-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table DONE!

CREATE OR REPLACE PROCEDURE ins_customer
(
temp_customerid IN customer.customerid%TYPE,
temp_firstname IN customer.firstname%TYPE,
temp_lastname IN customer.lastname%TYPE,
temp_company IN customer.company%TYPE,
temp_email IN customer.email%TYPE
)
IS
BEGIN 
INSERT INTO CUSTOMER (customerid, firstname, lastname, company,email)
VALUES (temp_customerid, temp_firstname,temp_lastname,temp_company,temp_email);
COMMIT;
END;
/

SELECT * FROM CUSTOMER;

BEGIN
ins_customer(62,'Timmy','Turner','Yeungling','hello123@hellokitty.com');
END;
/

SELECT * FROM CUSTOMER;

--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.

CREATE OR REPLACE TRIGGER insert_trig
AFTER INSERT ON EMPLOYEE
BEGIN 
DBMS_OUTPUT.PUT_LINE('New employee insert detected. Beep boop.');
END;
/

--7.1 INNER

--Task – Create an inner join that joins customers
--and orders and specifies the name of the customer and the invoiceId.

SELECT customer.firstname, customer.lastname,invoice.invoiceid
FROM CUSTOMER
INNER JOIN invoice
ON customer.customerid = invoice.customerid;

--7.2
--Task – Create an outer join that joins the 
--customer and invoice table
-- specifying the :
--CustomerId, firstname, lastname, invoiceId, and total.

SELECT customer.customerid,customer.firstname,customer.lastname,invoice.invoiceid,invoice.total
FROM customer
FULL OUTER JOIN invoice 
ON customer.customerid = invoice.customerid;

--7.3
--Task – Create a right join that joins 
--album and artist specifying artist name and title.

SELECT artist.name,album.title
FROM album 
RIGHT JOIN artist ON artist.artistid = album.artistid;


--7.4
--Task – Create a cross join that joins album and artist 
--and sorts by artist name in ascending order.

SELECT *
FROM album
CROSS JOIN artist 
ORDER BY artist.name ASC;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.

SELECT a.firstname, a.lastname, b.firstname || ' ' || b.lastname AS "Manager"
FROM employee a, employee b
WHERE a.reportsto = b.employeeid;



