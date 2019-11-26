--2.1
SELECT * FROM Employee;
SELECT * FROM Employee WHERE lastname = 'King';
SELECT * FROM Employee WHERE firstname = 'Andrew' AND REPORTSTO IS NULL;

--2.2
SELECT * FROM Album ORDER BY(title) DESC;
SELECT firstname FROM Customer ORDER BY(city) ASC; 

--2.3
SELECT * FROM Genre;
INSERT INTO Genre VALUES(26, 'Thriller');
INSERT INTO Genre VALUES(27, 'Satire');

SELECT * FROM Employee;
INSERT INTO Employee VALUES(9, 'Rogers', 'Kailey', 'IT Staff', 6, '12-FEB-99', '12-AUG-04', '240 Kings Pond Ave', 'Winter Haven', 'FL', 'U.S.', '33880', '+1 (555) 555-5555', '+1 (403) 246-8773','kailey@chinookcorp.com');
INSERT INTO Employee VALUES(10, 'Moulder', 'Isaac', 'IT Staff', 6, '26-MAR-99', '20-AUG-04', '240 Kings Pond Ave', 'Winter Haven', 'FL', 'U.S.', '33880', '+1 (555) 555-6666', '+1 (403) 246-8774','isaac@chinookcorp.com');

SELECT * FROM Customer;
INSERT INTO Customer VALUES(60, 'Ben', 'Ortiz', 'Walgreens', '5361 Lakeland Lane', 'Lakeland', 'FL', 'U.S.', '33827', '+1 (863) 555-7755', '+1 (863) 455-6565', 'ben@walgreens.com', 5);
INSERT INTO Customer VALUES(61, 'Jefree', 'Starr', 'Jeffree Starr Cosmetics', '1000 Rich Lane', 'Calabasas', 'CA', 'U.S.', '47821', '+1 (100) 000-0000', '+1 (100) 100-1000', 'jefree@jefreestarrcosmetics.com', 3);

--2.4
UPDATE Customer SET firstname = 'Robert', lastname = 'Walter' WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
UPDATE Artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

--2.5
SELECT * FROM Invoice WHERE billingaddress LIKE 'T%';

--2.6
SELECT * FROM Invoice WHERE total BETWEEN 15 AND 50;
SELECT * FROM Employee WHERE hiredate BETWEEN '1-JUN-03' AND '1-MAR-04';

--2.7

ALTER TABLE Invoice DROP CONSTRAINT FK_InvoiceCustomerId;
ALTER TABLE Invoice ADD CONSTRAINT FK_InvoiceCustomerId
    FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId) ON DELETE CASCADE;
--Deletes Customer
DELETE FROM Customer WHERE firstname = 'Robert' AND lastname = 'Walter';

--3.1
ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MON-YYYY HH:MI:SS';
SELECT SESSIONTIMEZONE, CURRENT_TIMESTAMP FROM DUAL;

SELECT LENGTH(name) AS LengthOfName FROM Mediatype;

--3.2
SELECT AVG(total) "Average" FROM Invoice;

SELECT MAX(unitprice) "Maximum" FROM Track;
--3.3
SELECT AVG(unitprice) "Average" FROM Invoiceline;

--3.4
SELECT * FROM Employee WHERE birthdate > '31-DEC-68';

--5.0
ALTER TABLE InvoiceLine DROP CONSTRAINT FK_InvoiceLineInvoiceId;
ALTER TABLE INvoiceLine DROP CONSTRAINT FK_InvoiceLineTrackId;
ALTER TABLE InvoiceLine ADD CONSTRAINT FK_InvoiceLineInvoiceId
    FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId) ON DELETE CASCADE;
ALTER TABLE InvoiceLine ADD CONSTRAINT FK_InvoiceLineTrackId
    FOREIGN KEY (TrackId) REFERENCES Track (TrackId) ON DELETE CASCADE;
DELETE FROM Invoice WHERE invoiceid = 216;

SELECT * FROM Customer;
CREATE PROCEDURE insertion_of_leroy
IS
BEGIN
INSERT INTO Customer VALUES(62, 'Leroy', 'Jenkins', 'Twitch', '5555 Twitch Chat Lane', 'Los Angeles', 'CA', 'U.S.', '78549', '+1 (777) 444-6666', '+1 (777) 444-6667', 'leroy@twitch.com', 4);
END;
/

BEGIN
insertion_of_leroy();
END;
/

--6.1
SELECT * FROM Employee;
CREATE SEQUENCE emp_seq
    START WITH 100
    INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER emp_seq_trigger
BEFORE INSERT ON Employee 
FOR EACH ROW
BEGIN
    IF :new.employeeid IS NULL THEN
    SELECT emp_seq.nextval INTO :new.employeeid FROM dual;
    END IF;
END;
/
SELECT * FROM Employee;
INSERT INTO Employee VALUES(null, 'Hogan', 'Hulk', 'Sales Manager', 1, '15-MAR-55', '13-SEP-02', '555 Hulk Hogan Way', 'Orlando', 'FL', 'U.S.', '33803', '+1 (748) 746-1254', '+1 (748) 247-2214','hulk@chinookcorp.com');

--7.1
SELECT firstname, lastname, invoiceid FROM Customer INNER JOIN Invoice ON Customer.customerid = Invoice.invoiceid ORDER BY LOWER(Customer.lastname);

--7.2
SELECT firstname, lastname, invoiceid, total FROM CUSTOMER OUTER JOIN Invoice ON outer.customerid = invoice.customerid ORDER BY LOWER(outer.lastname);

--7.3
SELECT name, title FROM Artist OUTER RIGHT JOIN Album ON outer.artistid = album.artistid ORDER BY LOWER(outer.name);

--7.4
SELECT * FROM Artist CROSS JOIN Album ORDER BY(Artist.name)ASC;

--7.5
SELECT * FROM Employee a, Employee b WHERE a.employeeid = b.reportsto;
