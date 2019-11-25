CREATE TABLE Employee (
    employeeID NUMBER NOT NULL PRIMARY KEY,
    employeeFirstName VARCHAR(255) NOT NULL,
    employeeLastName VARCHAR(255) NOT NULL,
    employeeUsername VARCHAR(255) NOT NULL,
    employeePassword VARCHAR(255) NOT NULL
);

CREATE TABLE Customer (
    customerID NUMBER,
    customerFirstName VARCHAR(255) NOT NULL,
    customerLastName VARCHAR(255)NOT NULL,
    customerUsername VARCHAR(255)NOT NULL,
    customerPassword VARCHAR(255)NOT NULL
    );
    
    CREATE TABLE Accountt (
    accountID NUMBER,
    balance NUMBER NOT NULL,
    accountType VARCHAR(255) NOT NULL,
    isJoint NUMBER CHECK (isJoint=0 OR isJoint=1),
    customerID NUMBER
);
CREATE SEQUENCE customers_sequence
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;
    
    CREATE OR REPLACE TRIGGER tr_insert_customers
    BEFORE INSERT ON customers
    FOR EACH ROW
    BEGIN
    SELECT customers_equence.nextval INTO : new.cuestomerID FROM Dual;

ALTER TABLE Accountt
ADD FOREIGN KEY (customerID) REFERENCES Customer(customerID);

ALTER TABLE Accountt
ADD status VARCHAR(255);

SELECT * FROM Customer;
SELECT * FROM Accountt;




