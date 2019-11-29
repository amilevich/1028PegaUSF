
--2.1 SELECT
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE lastname = 'King';
SELECT * FROM EMPLOYEE WHERE firstname = 'Andrew' and reportsto = null;

--2.2 ORDER BY
SELECT * FROM ALBUM  ORDER BY UPPER(title) DESC;
SELECT firstname FROM CUSTOMER  ORDER BY UPPER(city);

--2.3 INSERT INTO
INSERT INTO GENRE  VALUES (30, 'Hiphop');
INSERT INTO GENRE  VALUES (31, 'Urban');
INSERT INTO EMPLOYEE  VALUES (11, 'Garcia', 'Adriana', 'HR Staff', 6, TO_DATE('1970-5-29 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-1-2 00:00:00','yyyy-mm-dd hh24:mi:ss'), '540 Pine', 'Orlando', 'AB', 'Cuba', 'T1K 5N8', '+1 (407) 456-1246', '+1 (403) 456-8485', 'adriana@chinookcorp.com');
INSERT INTO EMPLOYEE  VALUES (12, 'Perez', 'Julia', 'HR Staff', 6, TO_DATE('1968-1-9 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-3-4 00:00:00','yyyy-mm-dd hh24:mi:ss'), '390 Semoram', 'Orlando', 'AB', 'Cuba', 'T1H 1Y8', '+1 (403) 467-3351', '+1 (407) 467-8972', 'julia@chinookcorp.com');
INSERT INTO CUSTOMER (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (60, 'Perez', 'Jose', '12 Zapata', 'Matanzas', 'Cuba', '110017', '+53 22 634546', 'jose@gmail.com', 3);
INSERT INTO CUSTOMER (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (61, 'Gonzales', 'Carlos', '567 Linea', 'Cienfuegos', 'Cuba', '560001', '+53 24 504563', 'carlos@yahoo.com', 3);

--2.4 UPDATE
UPDATE CUSTOMER SET firstname = 'Robert', lastname = 'Walter' WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
UPDATE ARTIST SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

--2.5 LIKE
SELECT * FROM INVOICE WHERE billingaddress  like 'T%';

--2.6 BETWEEN
SELECT * FROM INVOICE WHERE total BETWEEN 15 AND 50;
SELECT * FROM EMPLOYEE WHERE hiredate BETWEEN to_date('01-JUN-03','DD-MON-YY') AND to_date('01-MAR-04','DD-MON-YY');

--2.7 DELETE
DELETE FROM CUSTOMER WHERE firstname = 'Robert' and lastname = 'Walter';

ALTER TABLE INVOICELINE 
DROP CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE INVOICELINE
ADD CONSTRAINT FK_INVOICELINEINVOICEID FOREIGN KEY
(INVOICEID) REFERENCES INVOICE (INVOICEID) ON DELETE CASCADE ENABLE;

ALTER TABLE INVOICELINE  DROP CONSTRAINT FK_INVOICELINETRACKID;

ALTER TABLE INVOICELINE ADD CONSTRAINT FK_INVOICELINETRACKID FOREIGN KEY
(TRACKID) REFERENCES TRACK ( TRACKID ) ON DELETE CASCADE ENABLE;

--3.1 System Defined Functions
CREATE OR REPLACE FUNCTION currentTime 
RETURN VARCHAR2 IS 
   ct VARCHAR2(8); 
BEGIN 
   SELECT TO_CHAR(CURRENT_DATE, 'HH:MI:SS') INTO ct FROM DUAL; 
   RETURN ct; 
END currentTime; 
/ 
CREATE OR REPLACE FUNCTION lengthMediatype 
RETURN NUMBER IS 
   lm NUMBER:=0; 
BEGIN 
   SELECT COUNT(*) INTO lm FROM mediatype; 
   RETURN lm; 
END lengthMediatype; 
/
--3.2 System Defined Aggregate Functions
CREATE OR REPLACE FUNCTION averageTotalInvoices 
RETURN NUMBER IS 
   ati NUMBER:=0; 
BEGIN 
   SELECT avg(total) INTO ati FROM invoice; 
   RETURN ati; 
END averageTotalInvoices; 
/

CREATE OR REPLACE FUNCTION expensiveTrack 
RETURN VARCHAR2 IS 
   et VARCHAR2(100); 
BEGIN 
   SELECT t1.name INTO et FROM track t1, track t2 WHERE ROWNUM = 1 AND t1.unitprice > t2.unitprice;
   RETURN et; 
END expensiveTrack; 
/

--3.3 User Defined Scalar Functions
CREATE OR REPLACE FUNCTION averagePriceInvoiceline 
RETURN NUMBER IS 
   api NUMBER:=0; 
BEGIN 
   select avg(riu.unitprice)  into api from (select invoiceid, unitprice from invoiceline group by  invoiceid, unitprice) riu;
   RETURN api; 
END averagePriceInvoiceline; 
/

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE TYPE 
employee_rec IS OBJECT 
  ( EMPLOYEEID  NUMBER , 
	LASTNAME VARCHAR2(20), 
	FIRSTNAME VARCHAR2(20), 
	TITLE VARCHAR2(20), 
	REPORTSTO NUMBER, 
	BIRTHDATE DATE, 
	HIREDATE DATE, 
	ADDRESS VARCHAR2(70), 
	CITY VARCHAR2(40), 
	STATE VARCHAR2(40), 
	COUNTRY VARCHAR2(40), 
	POSTALCODE VARCHAR2(10), 
	PHONE VARCHAR2(20), 
	FAX VARCHAR2(20), 
	EMAIL VARCHAR2(20));
  
CREATE OR REPLACE TYPE employee_table AS TABLE OF employee_rec;
/

CREATE OR REPLACE  FUNCTION  employeeswhoborn
(born IN employee.birthdate%type)
RETURN employee_table IS  
employee_t employee_table;
BEGIN 

     SELECT employee_rec(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO,
                         BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY,
                         POSTALCODE, PHONE, FAX, EMAIL )
       BULK COLLECT INTO employee_t
       FROM employee
     WHERE birthdate > born;
   RETURN employee_t; 
END employeeswhoborn; 

--5.0 Transactions
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE INVOICELINE 
DROP CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE INVOICELINE
ADD CONSTRAINT FK_INVOICELINEINVOICEID FOREIGN KEY
(INVOICEID) REFERENCES INVOICE (INVOICEID) ON DELETE CASCADE ENABLE;

CREATE OR REPLACE PROCEDURE deleteInvoice(iid IN invoice.invoiceid%type) IS 
BEGIN 
   delete from invoice where invoiceid = iid;
END deleteInvoice;

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table

CREATE OR REPLACE PROCEDURE insertNewCustomer(inc IN customer%rowtype) IS 
BEGIN 
   INSERT INTO customer VALUES (inc.customerid, inc.firstname, inc.lastname, inc.company,
                                inc.address, inc.city, inc.state, inc.country, inc.postalcode,
                                inc.phone, inc.fax, inc.email, inc.supportrepid);
END insertNewCustomer;


--6.1 AFTER/FOR
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table. 
CREATE OR REPLACE TRIGGER employeeAfterInsert 
AFTER INSERT ON employee 
FOR EACH ROW 
BEGIN 
  UPDATE employee SET firstname = UPPER(firstname) WHERE employeeid = :new.employeeid;
END; 
/

--7.1 INNER
SELECT C.firstname, I.invoiceid   FROM CUSTOMER C INNER JOIN INVOICE I ON C.customerid = I.customerid; 

--7.2 OUTER
SELECT C.CustomerId, C.firstname, C.lastname, I.invoiceId, I.total  FROM CUSTOMER C LEFT OUTER JOIN INVOICE I ON C.customerid = I.customerid; 

--7.3 RIGHT
SELECT AR.name, al.title FROM ALBUM AL RIGHT OUTER JOIN ARTIST AR ON AL.artistid = AR.artistid;

--7.4 CROSS
SELECT * FROM ALBUM AL CROSS JOIN ARTIST AR ORDER BY UPPER(AR.name);

--7.5 SELF
SELECT *FROM EMPLOYEE E1, EMPLOYEE E2 WHERE E1.reportsto = E2.reportsto;


























