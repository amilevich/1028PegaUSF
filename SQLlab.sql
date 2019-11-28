/*2.1
*/
SELECT * FROM Employee;
SELECT * FROM Employee WHERE lastname = 'King';
SELECT * FROM Employee WHERE firstname = 'Andrew' AND reportsto IS NULL;

/*2.2
*/
SELECT * FROM Album ORDER BY title DESC;
SELECT firstname FROM Customer ORDER BY city;

/*2.3
*/
INSERT INTO Genre VALUES (26, 'Symphonic Metal');
INSERT INTO Genre VALUES (27, 'Action');

INSERT INTO Employee VALUES (9, 'Smith', 'John', 'Sales Support Agent', 2, '21-JUL-86', '09-DEC-03', '101 Maple Dr', 'Calgary', 'AB', 'Canada', 'T2P 5M5', '+1 (403) 263-2443', '+1 (403) 263-2120', 'john@chinookcorp.com');
INSERT INTO Employee VALUES (10, 'Doe', 'Jane', 'IT Staff', 6, '19-DEC-63', '21-JUN-04', '123 Main St.', 'Lethbridge', 'AB', 'Canada', 'T1H 1Z9', '+1 (403) 467-3498', '+1 (403) 263-2849', 'jane@chinookcorp.com');

INSERT INTO Customer VALUES (60, 'Mike', 'Johnson', null, '123 Central Ave.', 'Tampa', 'FL', 'USA', '12345', '+1 (941) 349-9853', null, 'MJforever@aol.com', 4);
INSERT INTO Customer VALUES (61, 'Sarah', 'Freeman', null, '8973 1st St.', 'Orlando', 'FL', 'USA', '54983', '(941) 450-9863', null, 'freemans@gmail.com', 5);

/*2.4
*/
UPDATE Customer SET firstname = 'Aaron', lastname = 'Mitchell' WHERE customerid=32;
UPDATE Artist SET name='CCR' WHERE name='Creedence Clearwater Revival';

/*2.5
*/
SELECT * FROM Invoice WHERE billingaddress LIKE 'T%';

/*2.6
*/
SELECT * FROM Invoice WHERE total>15 AND total<50;
SELECT * FROM Employee WHERE hiredate>'01JUN-03' AND hiredate<'01-MAR-04';

/*2.7
*/
ALTER TABLE Invoice DROP CONSTRAINT FK_InvoiceCustomerID;
ALTER TABLE Invoice ADD CONSTRAINT FK_InvoiceCustomerID FOREIGN KEY (CustomerId) 
    REFERENCES Customer (CustomerId) ON DELETE CASCADE ;
DELETE FROM Customer WHERE firstname='Robert' AND lastname='Walter';

/*3.1
*/
CREATE PROCEDURE current_time
IS
BEGIN
    CURTIME(0);
END;
/

CREATE PROCEDURE mediatype_length
IS
BEGIN
    SELECT length('Protected MPEG-4 video file') FROM dual;
END;
/

/*3.2
*/
SELECT SUM(total)FROM Invoice;

DECLARE 
    max_unit_price NUMBER;
BEGIN
    SELECT MAX(unitprice)INTO max_unit_price FROM Track;
    SELECT * BULK COLLECT INTO some_table_name FROM Track WHERE unitprice = max_unit_price;
END;
/

/*3.3
*/
SELECT AVG(unitprice) FROM Invoiceline;

/*3.4
*/
SELECT * FROM Employee WHERE TO_DATE(birthdate)>TO_DATE('31-DEC-1968');

/*5.1
*/
CREATE PROCEDURE delete_invoice (invoice_id NUMBER)
AS
BEGIN
    DELETE FROM invoiceline WHERE invoiceid = invoice_id;
    DELETE FROM invoice WHERE invoiceid = invoice_id;
END;
/

/*5.2
*/
CREATE PROCEDURE new_customer_record
IS
BEGIN
    INSERT INTO Customer VALUES(0, "", "", "", "", "", "", "", "", "", "", "", 0);
END;
/
SELECT * FROM Customer;
/*6.1
*/
CREATE TRIGGER insert_trigger_name_here
AFTER INSERT ON Employee
FOR EACH ROW
BEGIN
--insert meaningful task to be performed
END;
/

/*7.1
*/
SELECT invoice.invoiceid, customer.firstname, customer.lastname FROM invoice 
        INNER JOIN customer ON invoice.customerid = customer.customerid;

/*7.2
*/
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total FROM customer
        FULL OUTER JOIN invoice ON customer.customerid = invoice.customerid;

/*7.3
*/
SELECT Artist.Name, Album.Title FROM Album RIGHT JOIN Artist ON Album.ArtistID = Artist.ArtistID ORDER BY Artist.Name;

/*7.4
*/
SELECT * FROM Album CROSS JOIN Artist ORDER BY Artist.Name ASC;

/*7.5
*/
SELECT * FROM employee a, employee b WHERE a.reportsto = b.employeeid;







