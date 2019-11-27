
-- Log in information
CREATE TABLE Customers(
    customer_pk NUMBER,
    customerID NUMBER,
    accountType VARCHAR2(50),
    username VARCHAR2(50),
    passwords VARCHAR2(50),
    totalBalance NUMBER,
    pendingApproved NUMBER
    );
    
CREATE TABLE Employee(
    e_id NUMBER,
    e_username VARCHAR2(50),
    e_passwords VARCHAR2(50)
);
    
CREATE TABLE Admins(
    a_id NUMBER(6) PRIMARY KEY,
    a_username VARCHAR2(50),
    a_passwords VARCHAR2(50)
);

SELECT * FROM Customers;

SELECT * FROM Customers;
SELECT * FROM Employee;
SELECT * FROM Admins;
DROP TABLE Employee;
DROP TABLE Admins;
DROP TABLE Customers;
--******************************************************************************************************************************

-- Accounts Pending
CREATE TABLE PendingAccounts(
    customerID NUMBER,
    accountType VARCHAR2(50),
    username VARCHAR2(50),
    passwords VARCHAR2(50),
    totalBalance NUMBER
);

--******************************************************************************************************************************

-- Accounts Active
CREATE TABLE ActiveAccounts(
    customerID NUMBER,
    accountType VARCHAR2(50),
    username VARCHAR2(50),
    passwords VARCHAR2(50),
    totalBalance NUMBER
);

--******************************************************************************************************************************

--Sequence
--An object/entity that will maintain a counter for you

CREATE SEQUENCE cus_seq
        START WITH 1
        INCREMENT BY 1;
/
--******************************************************************************************************************************

--Trigger
--An object/entity that we can create that waits for actions to occur and performs the designated code
CREATE OR REPLACE TRIGGER cus_seq_trigger
BEFORE INSERT ON Customers
FOR EACH ROW
BEGIN
    IF :new.customer_pk is NULL THEN 
    SELECT cus_seq.nextval INTO :new.customer_pk FROM dual;
    END IF;
END;
/

--******************************************************************************************************************************

