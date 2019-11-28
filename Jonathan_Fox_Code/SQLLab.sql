/*2.1
Task – Select all records from the Employee table.
Task – Select all records from the Employee table where last name is King.
Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
*/
SELECT * FROM Employee;
SELECT * FROM Employee WHERE lastname = 'King';
SELECT * FROM Employee WHERE firstname = 'Andrew' and reportsto IS NULL;

/*2.2
Task – Select all albums in Album table and sort result set in descending order by title.
Task – Select first name from Customer and sort result set in ascending order by city.
*/

SELECT * FROM Album ORDER BY title DESC;
SELECT firstname FROM Customer ORDER BY city ASC;

/*2.3
Task – Insert two new records into Genre table
Task – Insert two new records into Employee table
Task – Insert two new records into Customer table
*/

SELECT * FROM Genre;
INSERT INTO Genre VALUES(26, '??????');
INSERT INTO Genre VALUES(-1, 'Industrial');
SELECT * FROM Employee;
INSERT INTO Employee VALUES(-1, 'input', 'validation', 'failed', NULL, NULL, NULL, NULL, 'North Pole', NULL, 'Arctic Circle', '-1', NULL, NULL, 'dont@me.com');
INSERT INTO Employee VALUES(-2, 'junk', 'junk', 'junk', NULL, NULL, NULL, 'junk', 'junk', 'junk', 'junk', NULL, NULL, NULL, 'junk');
SELECT * FROM Customer;
INSERT INTO Customer VALUES(-1, 'name', 'name', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'dont@me.com', NULL);
INSERT INTO Customer VALUES(-2, 'junk', 'junk', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'junk', NULL);

/*2.4
Task – Update Aaron Mitchell in Customer table to Robert Walter
Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
*/

SELECT * FROM Customer WHERE customerid  = 32;
UPDATE Customer SET firstname = 'Robert', lastname = 'Walter' WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
SELECT * FROM Artist WHERE artistid = 76;
UPDATE Artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';


/*2.5 Task – Select all invoices with a billing address like “T%”*/

SELECT * FROM Invoice WHERE billingaddress LIKE 'T%';

/*2.6
Task – Select all invoices that have a total between 15 and 50
Task – Select all employees hired between 1st of June 2003 and 1st of March 2004.
*/

SELECT * FROM Invoice WHERE total > 15 AND total < 50;
SELECT * FROM Employee WHERE hiredate > DATE '2003-06-01' AND hiredate < DATE '2004-03-01';

/*2.7 Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).*/

SELECT * FROM Customer WHERE customerid  = 32;
DELETE FROM Customer WHERE firstname = 'Robert' AND lastname = 'Walter';
SELECT * FROM Invoice WHERE customerid = 32;
DELETE FROM Invoice WHERE customerid = 32;
ALTER TABLE invoice DROP CONSTRAINT FK_invoicecustomerid;
ALTER TABLE Invoice ADD CONSTRAINT FK_invoicecustomerid FOREIGN KEY (customerid) REFERENCES Customer (customerid) ON DELETE CASCADE;
SELECT * FROM invoice INNER JOIN invoiceline USING (invoiceid) WHERE customerid = 32;
ALTER TABLE invoiceline DROP CONSTRAINT fk_invoicelineinvoiceid;
ALTER TABLE InvoiceLine ADD CONSTRAINT FK_InvoiceLineInvoiceId FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId) ON DELETE CASCADE;

/*3.1
Task – Create a function that returns the current time.
Task – Create a function that returns the length of a mediatype from the mediatype table
*/

CREATE OR REPLACE FUNCTION get_time
RETURN TIMESTAMP
IS BEGIN RETURN (CURRENT_TIMESTAMP); END;
/

SELECT get_time() FROM DUAL;

CREATE OR REPLACE FUNCTION get_mt_length(id IN NUMBER)
RETURN NUMBER AS len NUMBER:=0;
BEGIN
SELECT LENGTH(name) INTO len FROM MediaType WHERE mediatypeid = id;
RETURN len;
END;
/

SELECT * FROM MediaType;
SELECT get_mt_length(2) FROM dual;

/*3.2
Task – Create a function that returns the average total of all invoices
Task – Create a function that returns the most expensive track
*/

SELECT * FROM Invoice;

CREATE OR REPLACE FUNCTION get_avg_invoice
RETURN NUMBER AS average NUMBER:=0;
BEGIN
SELECT AVG(total) INTO average FROM Invoice;
RETURN average;
END;
/
SELECT get_avg_invoice() FROM dual;

SELECT * FROM Track;

CREATE OR REPLACE FUNCTION get_max_track
RETURN NUMBER AS max_track NUMBER:=0;
BEGIN
SELECT MAX(unitprice) INTO max_track FROM Track;
RETURN max_track;
END;
/
SELECT get_max_track() FROM dual;

/*3.3 Task – Create a function that returns the average price of invoiceline items in the invoiceline table*/

SELECT * FROM Invoiceline;

CREATE OR REPLACE FUNCTION get_avg_invoiceline
RETURN NUMBER AS average NUMBER:=0;
BEGIN
SELECT AVG(unitprice) INTO average FROM Invoiceline;
RETURN average;
END;
/

SELECT get_avg_invoiceline() FROM dual;

/*3.4 Task – Create a function that returns all employees who are born after 1968.*/

SELECT * FROM Employee;

CREATE OR REPLACE TYPE emp_record AS OBJECT(
    EmployeeId NUMBER,
    LastName VARCHAR2(20),
    FirstName VARCHAR2(20),
    Title VARCHAR2(30),
    ReportsTo NUMBER,
    BirthDate DATE,
    HireDate DATE,
    Address VARCHAR2(70),
    City VARCHAR2(40),
    State VARCHAR2(40),
    Country VARCHAR2(40),
    PostalCode VARCHAR2(10),
    Phone VARCHAR2(24),
    Fax VARCHAR2(24),
    Email VARCHAR2(60)
);
/

CREATE OR REPLACE TYPE emp_table AS TABLE OF emp_record;
/

CREATE OR REPLACE FUNCTION after_1968
RETURN emp_table AS t emp_table;
BEGIN
SELECT emp_record(employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email) 
BULK COLLECT INTO t FROM Employee WHERE birthdate >= DATE '1969-01-01';
RETURN t;
END;
/

SELECT * FROM TABLE(after_1968());

/*5.0
Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
*/

SELECT * FROM invoice;

CREATE OR REPLACE PROCEDURE delete_invoice (id NUMBER)
IS BEGIN
DELETE FROM invoice WHERE invoiceid = delete_invoice.id;
END;
/

BEGIN
delete_invoice(218);
END;
/

/*6.1 Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table. */

CREATE OR REPLACE TRIGGER trig
AFTER INSERT ON Employee
BEGIN
dbms_output.put_line('inserted');
END;
/

SELECT * FROM Employee;

DELETE FROM Employee WHERE employeeid = -2;
INSERT INTO Employee VALUES(-2, 'junk', 'junk', 'junk', NULL, NULL, NULL, 'junk', 'junk', 'junk', 'junk', NULL, NULL, NULL, 'junk');


/*7.1 Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.*/

SELECT * FROM Customer;
SELECT * FROM Invoice;

SELECT Customer.firstname, Customer.lastname, Invoice.invoiceid FROM Customer INNER JOIN Invoice ON Customer.customerid = Invoice.customerid;

/*7.2 Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.*/

SELECT customer.customerid, firstname, lastname, invoiceid, total FROM Customer FULL OUTER JOIN Invoice ON invoice.customerid = customer.customerid;

/*7.3 Task – Create a right join that joins album and artist specifying artist name and title.*/

SELECT * FROM artist;
SELECT * FROM album;

SELECT artist.name, album.title FROM album RIGHT OUTER JOIN artist ON album.artistid = artist.artistid;

/*7.4 Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
*/

SELECT * FROM album CROSS JOIN artist ORDER BY artist.name ASC;

/*7.5 Task – Perform a self-join on the employee table, joining on the reportsto column.*/

SELECT * FROM employee;

SELECT * FROM employee t1 LEFT OUTER JOIN employee t2 ON t2.employeeid = t1.reportsto ORDER BY t1.employeeid;