--2.1
SELECT * FROM Employee;
SELECT * FROM Employee WHERE LastName = 'King';
SELECT * FROM Employee WHERE FirstName = 'Andrew' AND REPORTSTO = null;

--2.2
SELECT * FROM ALBUM ORDER BY Title DESC;
SELECT FirstName FROM Customer ORDER BY City DESC;

--2.3
INSERT INTO Genre VALUES('26', 'Enter The Wu');
INSERT INTO Genre VALUES('27', 'Rumours');

INSERT INTO Customer VALUES (60, 'David', 'Prater', 'Revature', '123 Galaxy Ave',  'Tampa', 'FL', 'America', '33612', '(123)456-7890', '(987)456-3210', 'david@prater.com', 4);
INSERT INTO Customer VALUES (61, 'Jerry', 'Smith', 'Unemployeed', '123 Space Mountain',  'Tampa', 'FL', 'America', '33612', '(147)852-9630', '(654)987-1234', 'jerry@gmail.com', 3);

INSERT INTO Employee VALUES(9, 'David', 'Prater', 'Developer', 6, TO_DATE('1993-8-11 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2019-10-28 00:00:00','yyyy-mm-dd hh24:mi:ss'), '123 Galaxy ST', 'Tampa', 'FL', 'America', '67124', '+1 (123) 456-7890', '+1 (123) 456-7890', 'david@prater.com');
INSERT INTO Employee VALUES(10, 'Rick', 'Sanchez', 'Scientist', 1, TO_DATE('1960-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('1970-11-11 00:00:00','yyyy-mm-dd hh24:mi:ss'), '123 Banana ST', 'C-137', 'FL', 'Earth', '33612', '+1 (987) 654-3210', '+1 (987) 654-3210', 'rick@sanchez.com');

--2.4
UPDATE Customer SET FirstName = 'Robert', LastName = 'Walter' WHERE CustomerID = 32;
UPDATE Artist SET Name = 'CCR' WHERE ArtistID = 76;

--2.5
SELECT * FROM Invoice WHERE BillingAddress = 'T%';

--2.6
SELECT * FROM Invoice WHERE TOTAL BETWEEN 15 AND 50;
SELECT * FROM Employee WHERE HireDate BETWEEN '1-JUN-2003' AND '1-MAR-2004';

--2.7
ALTER TABLE INVOICE DROP CONSTRAINT FK_CustomerID;
DELETE FROM Customer WHERE CustomerID = 32;

-- 3.1
SELECT SYSDATE FROM dual;
SELECT LENGTH(name) FROM MediaType;

--3.2
SELECT AVG(ALL Total) FROM Invoice;
SELECT MAX(UnitPrice) FROM Track;

--3.3
CREATE OR REPLACE FUNCTION return_invoiceline_avg
RETURN NUMBER
IS
    invoiceline_avg NUMBER;
BEGIN
    SELECT AVG(UNITPRICE)
    INTO invoiceline_avg
    FROM INVOICELINE;
    RETURN invoiceline_avg;
END;


--3.4
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE TYPE employee_object AS OBJECT (
    first_name   VARCHAR(20),
    last_name    VARCHAR2(20),
    birth_date   DATE
);
/

CREATE OR REPLACE TYPE employee_table AS
    TABLE OF employee_object;
/

CREATE OR REPLACE FUNCTION employee_born RETURN employee_table AS
    v_employee_table employee_table;
BEGIN
    SELECT
        employee_object(a.firstname, a.lastname, a.birthdate)
    BULK COLLECT
    INTO v_employee_table
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
        ) a;

    RETURN v_employee_table;
END;
/

SELECT
    *
FROM
    TABLE ( employee_born );

--5.0
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE delete_invoice
(v_InvoiceID IN Invoice.InvoiceID%TYPE) IS
BEGIN
DELETE FROM InvoiceLine WHERE InvoiceID = v_InvoiceID;
DELETE FROM Invoice WHERE InvoiceID = InvoiceID;
COMMIT;
END;

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE insert_customer
(
v_CustomerID IN Customer.CustomerID%TYPE,
v_FirstName IN Customer.FirstName%TYPE,
v_LastName IN Customer.LastName%TYPE,
v_Email IN Customer.Email%TYPE,
v_Address In Customer.Address%TYPE
) IS
BEGIN
INSERT INTO CUSTOMER (Customerid, FirstName, LastName, Email, Address) 
VALUES (v_CustomerID, v_FirstName, v_LastName, v_Email, v_Email);
COMMIT;
END insert_customer;
/

6.1 AFTER/FOR
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER insert_trigger
AFTER INSERT ON Employee
BEGIN
DBMS_OUTPUT.PUT_LINE('Trigger fired after insert because new row inserted.');
END;
/

--7.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT Customer.FirstName, Customer.LastName, Invoice.InvoiceID FROM Customer
INNER JOIN Invoice ON Customer.CustomerID = Invoice.CustomerID;

--7.2 OUTER
SELECT Customer.CustomerID, Customer.FirstName, Customer.LastName, Invoice.InvoiceID, Invoice.Total FROM Customer
FULL OUTER JOIN Invoice ON Customer.CustomerID = Invoice.CustomerID;

--7.3 RIGHT
SELECT Artist.Name, Album.Title FROM ALbum
RIGHT JOIN Artist ON Artist.ArtistID = Album.ArtistID;

--7.4 CROSS
SELECT * FROM Album CROSS JOIN Artist ORDER BY Artist.Name ASC;

--7.5 SELF
SELECT A.FirstName, A.LastName, B.FirstName || ' ' || B.LastName AS "Manager"
FROM Employee A, Employee B WHERE A.ReportsTo = B.EmployeeID;
