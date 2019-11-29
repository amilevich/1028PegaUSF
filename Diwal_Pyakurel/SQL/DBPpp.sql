--2.1  SELECT
SELECT * FROM employee;
SELECT * FROM employee where lastname='King';
SELECT * FROM employee where firstname = 'Andrew' and reportsto is null;

--2.2 ORDER BY
SELECT * FROM album ORDER BY title DESC;
SELECT firstname FROM customer ORDER BY city;

--2.3 INSERT INTO

SELECT * from customer;
INSERT INTO genre VALUES(26, 'Opera2');
INSERT INTO genre VALUES(27, 'Opera3');
INSERT INTO employee  VALUES(10,'Diwal', 'Pyakurel', 'Manager', '1', '06-Feb-1990', '06-Feb-2000', '1200 Broadmoor Dr', 'Austin', 'TX', 'Canada', 'T5K 2N1', '+1(737) 222-2222', '+1(737) 222-2222', 'diwalpyak@gmail.com' );
INSERT INTO employee  VALUES(12,'DP', 'PK', 'Manager2', '8', '06-Jan-1990', '06-Mar-2000', '1300 Broadmoor Dr', 'Austin', 'TX', 'USA', 'T5K 2N1', '+1(737) 000-2332', '+1(737) 222-2222', 'diwalpyak@gmail.com' );
INSERT INTO customer VALUES(103, 'DD', 'pp', null, '1200 Broad', 'Austin', null, 'USA', '22', '+1(737) 000-2332', null, 'diwal@h', 5);
INSERT INTO customer VALUES(203, 'YY', 'XX', null, '4508 Deep', 'Austin', null, 'USA', '33', '+1(737) 000-2332', null, 'miwal@h', 5);

--2.4 Update

UPDATE customer SET firstname = 'Robert', lastname='walter' WHERE firstname='Aaron' and lastname = 'Mitchell';
UPDATE artist SET name= 'CCR' where name= 'Creedence Clearwater Revival';

--2.5 Like
SELECT * FROM invoice where billingaddress LIKE 'T%';

--2.6 Between
SELECT * FROM invoice WHERE total BETWEEN 10 and 15;
select * from employee WHERE HIREDATE BETWEEN TO_DATE('20030601', 'YYYYMMDD') and TO_DATE('20040301', 'YYYYMMDD');

--2.7 DELETE





--3.1 Get Current time
--DATE and TIME FUNCTION
CREATE OR REPLACE FUNCTION print_date_time
return DATE
IS time_date DATE;
BEGIN
SELECT CURRENT_TIMESTAMP INTO time_date FROM dual ;
return time_date;
END;
/
ALTER SESSION set nls_date_format = 'DD-MM-YYYY HH24:MI:SS' 


--MEDIA TYPE LENGTH

SELECT * FROM MEDIATYPE;


CREATE OR REPLACE FUNCTION get_mediatyp_name(media_id in NUMBER)
RETURN NUMBER
IS length_media NUMBER;
BEGIN
 select LENGTH(name) INTO length_media FROM mediatype WHERE mediatypeid = media_id;
return length_media;
END;
/
SELECT get_mediatyp_name(1) from DUAL;

--3.2 SYSTEM DEFINED AGGREGATE FUNCTION
SELECT * FROM invoice;
CREATE OR REPLACE FUNCTION get_average_invoices
RETURN NUMBER
IS avgs NUMBER;
BEGIN
SELECT AVG(total) into avgs from invoice;
return avgs;
END;
/
SELECT get_average_invoices() from DUAL;

--most expensive track
CREATE OR REPLACE TYPE get_expensive_track AS OBJECT (
    name  VARCHAR2(1000),
    price   NUMBER(10)
);

CREATE OR REPLACE TYPE expensive_table_table AS TABLE OF get_expensive_track;

CREATE OR REPLACE FUNCTION get_expensive_track_table
return  expensive_table_table 
AS
exp_table expensive_table_table;
price NUMBER(10);
BEGIN

SELECT MAX(unitprice) INTO price FROM track;

SELECT get_expensive_track(test.name, test.unitprice) bulk collect into exp_table from (SELECT name, unitprice from track where unitprice=price)test;
return exp_table;
END;
/

SELECT * FROM TABLE (get_expensive_track_table);


--3.3 User Defined Scalar Functions
CREATE or replace function avg_price
return NUMBER
IS
price NUMBER(5,2);
BEGIN
SELECT AVG(unitprice) INTO price
FROM invoiceline;
RETURN price;
END;
/
SELECT avg_price() FROM DUAL;



--3.4 User Defined Table Valued Functions





--5.0 Transactions
DROP function delete_inv;

CREATE OR REPLACE FUNCTION delete_inv(id IN NUMBER)
return varchar2 AS
BEGIN
	DELETE FROM invoice where invoiceid = id;
 return 'done';
END;
/
alter table invoiceline
drop constraint fk_invoicelineinvoiceid;

select delete_inv(399) from DUAL;

SELECT * FROM customer;

CREATE OR REPLACE function add_customers(id IN NUMBER, first_name in VARCHAR2, last_name IN VARCHAR2, company in VARCHAR2, address in VARCHAR2, city in VARCHAR2, states in VARCHAR2, country in VARCHAR2, postalcode in VARCHAR2, phone in VARCHAR2, fax in VARCHAR2, email in VARCHAR2, supported_id in NUMBER)
return VARCHAR2;
BEGIN
INSERT INTO customer VALUES(id, first_name, last_name, company, address,city,states,  postalcode, country, phone, fax, email, supported_id);
return 'Done';
END;
/

--6.1

DROp trigger employee_trigger;
CREATE TRIGGER employee_trigger 

AFTER INSERT  ON employee FOR each row

BEGIN
 DBMS_OUTPUT.PUT_LINE('new');
END;
/


--7.0 JOINS
--7.1 INNER JOINS

SELECT customer.customerid, customer.firstname,lastname, customer.company, invoice.invoiceid FROM customer INNER JOIN invoice ON customer.customerid=invoice.invoiceid;

--7.3 Create a right join that joins album and artist specifying artist name and title.

SELECT artist.artistid, album.title, artist.name FROM artist RIGHT JOIN album ON artist.artistid=album.albumid; 

--7.2  Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

SELECT customer.customerid, firstname, customer.lastname, invoice.invoiceid, invoice.total from customer FULL OUTER JOIN invoice ON customer.customerid=invoice.customerid; 
--7.4 CROSS JOIN
SELECT * FROM album CROSS JOIN artist ORDER BY artist.name;

--7.5 SELF JOIN Perform a self-join on the employee table, joining on the reportsto column.


