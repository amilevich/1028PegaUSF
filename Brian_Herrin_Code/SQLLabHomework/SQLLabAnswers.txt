--For 1.0, the sql file for chinook is included.
--2.1
--Task – Select all records from the Employee table.
SELECT * FROM Employee;
--Task – Select all records from the Employee table where last name is King.
SELECT * FROM Employee WHERE LastName = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM Employee WHERE FirstName = 'Andrew' AND ReportsTo IS NULL;

--2.2
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM Album ORDER BY Title DESC;

--Task – Select first name from Customer and sort result set in ascending order by city
SELECT FirstName FROM Customer ORDER BY City ASC;

--2.3
--Task – Insert two new records into Genre table
SELECT * FROM Genre;
INSERT INTO Genre (GenreId, Name) VALUES (26, 'Country');
INSERT INTO Genre (GenreId, Name) VALUES (27, 'First-Person Shooter');

--Task – Insert two new records into Employee table
SELECT * FROM Employee;
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (9, 'Callan', 'Lauren', 'IT Staff', 6, TO_DATE('1968-1-9 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-3-4 00:00:00','yyyy-mm-dd hh24:mi:ss'), '923 7 ST NW', 'Lumbridge', 'AB', 'Canada', 'T1H 1Y8', '+1 (403) 467-3351', '+1 (403) 467-8772', 'lauren@chinookcorp.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (10, 'Calan', 'Laurie', 'IT Staff', 6, TO_DATE('1968-1-9 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-3-4 00:00:00','yyyy-mm-dd hh24:mi:ss'), '923 7 ST NW', 'Varrock', 'AB', 'Canada', 'T1H 1Y8', '+1 (403) 467-3351', '+1 (403) 467-8772', 'laurie@chinookcorp.com');

--Task – Insert two new records into Customer table
SELECT * FROM Customer;
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (60, 'Karan', 'Bielsen', 'Slander Boulevard 51', 'Co-openhagen', 'Denmark', '1720', '+453 3331 9993', 'karan.bielsen@jubii.dk', 4);
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (61, 'Karie', 'Dielsen', 'Sander Boulevard 51', 'Clopenhagen', 'Denmark', '1721', '+453 3331 9992', 'karie.dielsen@jubii.dk', 4);

--2.4
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer SET FirstName = 'Robert', LastName = 'Walter' WHERE FirstName = 'Aaron' AND LastName = 'Mitchell';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE Artist SET Name = 'CCR' WHERE Name = 'Creedence Clearwater Revival';

--2.5
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM Invoice WHERE BillingAddress LIKE "T%";

--2.6
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM Invoice WHERE BillingAddress LIKE "T%";

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM Employee WHERE HireDate > '2003-06-01' AND HireDate < '2004-03-01';

--2.7
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM Customer WHERE FirstName = 'Robert' AND LastName = 'Walter';

--3.1
--Task – Create a function that returns the current time.
create or replace FUNCTION GETCURRENTDATE 
    RETURN DATE
IS
BEGIN
    RETURN SYSTIMESTAMP;
END;

--Task – Create a function that returns the length of a mediatype from the mediatype table
create or replace FUNCTION getMediaLength (id NUMBER)
	RETURN NUMBER IS
	cname VARCHAR2(120);
	cursor c1 is
   	SELECT Name FROM MediaType
     	WHERE MediaTypeId = id;
BEGIN
	open c1;fetch c1 into cname;

	IF c1%NOTFOUND THEN
		cname := ''; 
    	END IF;
	DBMS_OUTPUT.PUT_LINE(cname);
	RETURN LENGTH(cname);
END;

--3.2
--Task – Create a function that returns the average total of all invoices
create or replace FUNCTION getAverageTotal
	RETURN NUMBER IS
    total_average NUMBER := 0;
BEGIN
    SELECT AVG(Total) INTO total_average FROM Invoice;
	RETURN total_average;
END;
--Output: 5.65194174757281553398058252427184466019

--Task – Create a function that returns the most expensive track
create or replace FUNCTION getExpensiveTrack
	RETURN NUMBER IS
	cid NUMBER;
	cursor c1 is
   	SELECT TrackId FROM Track
   	WHERE UnitPrice = (SELECT MAX(UnitPrice) FROM Track);
BEGIN
	open c1;fetch c1 into cid;

	IF c1%NOTFOUND THEN
		cid := 0; 
    END IF;
	DBMS_OUTPUT.PUT_LINE(cid);
	RETURN cid;
END;

--3.3
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace FUNCTION getAverageInvoiceLine
	RETURN NUMBER IS
	average NUMBER;
    	money_total NUMBER;
    	item_total NUMBER;
BEGIN
    SELECT SUM(UnitPrice*Quantity) INTO money_total FROM InvoiceLine;
    SELECT SUM(Quantity) INTO item_total FROM InvoiceLine;
    SELECT (money_total / item_total) INTO average FROM dual;
    DBMS_OUTPUT.PUT_LINE(average);
	RETURN average;
END;

--3.4
--Task – Create a function that returns all employees who are born after 1968.
SELECT EmployeeId FROM Employee WHERE BirthDate > TO_DATE('31-12-1968','DD-MM-YYYY');

--5.0
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE PROCEDURE delete_invoice_procedure(IN given_id  NUMBER)
IS
BEGIN
	DELETE FROM InvoiceLine where InvoiceLine.InvoiceId = given_id;
	DELETE FROM Invoice WHERE InvoiceId = given_id;
	commit;
END;
/

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE PROCEDURE delete_invoice_procedure(IN new_id  NUMBER, new_first_name VARCHAR2(40), new_last_name VARCHAR2(20), new_Company VARCHAR2(80), new_Address VARCHAR2(70), new_City VARCHAR2(40), new_State VARCHAR2(40), new_Country VARCHAR2(40), new_PostalCode VARCHAR2(10), new_Phone VARCHAR2(24), new_Fax VARCHAR2(24), new_Email VARCHAR2(60) NOT NULL, new_SupportRepId NUMBER)
IS
BEGIN
	INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (new_id, new_first_name, new_last_name, new_Company, new_Address, new_City, new_State, new_Country, new_PostalCode, new_Phone, new_Fax, new_Email, new_SupportRepId);
	commit;
END;
/

--6.0
--6.1
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE SEQUENCE emps_id_seq;
CREATE OR REPLACE TRIGGER trigger_applications AFTER
    INSERT ON Employee
    FOR EACH ROW
BEGIN
    SELECT
        emps_id_seq.NEXTVAL
    INTO :new.EmployeeId
    FROM
        dual;
END;
/

--7.0
--7.1
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT FirstName, LastName, CustomerId
FROM Customer
INNER JOIN Invoice
ON Customer.CustomerId = Invoice.CustomerId;

--7.2
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT FirstName, LastName, CustomerId, InvoiceId, Total
FROM Customer
OUTER JOIN Invoice
ON Customer.CustomerId = Invoice.CustomerId;

--7.3
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT Name, Title
FROM Artist
RIGHT JOIN Album
ON Artist.ArtistId  = Album.ArtistId ;

--7.4
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT Name
FROM Artist ORDER BY Name ASC
CROSS JOIN Album
ON Artist.ArtistId = Album.ArtistId;

--7.5
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT A.CustomerName AS CustomerName1, B.CustomerName AS CustomerName2
FROM Employee A, Employee B
WHERE A.ReportsTo <> B.ReportsTo;

