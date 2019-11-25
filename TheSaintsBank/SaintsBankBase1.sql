
CREATE TABLE Customer(

      CustomerID NUMBER(4) PRIMARY KEY,
      cUsername VARCHAR2(50) UNIQUE,
      cPassword VARCHAR2(50)NOT NULL,
      firstName VARCHAR2(50) NOT NULL,
      lastName VARCHAR2(50)NOT NULL
         
);

CREATE TABLE CAccount(

        CustomerID NUMBER(8) PRIMARY KEY,
        AccountNumber NUMBER(9) UNIQUE,
        AccountType VARCHAR2(50),
        AccountBalance NUMBER(15),
        
     FOREIGN KEY(CustomerID) REFERENCES Customer(CustomerID)
       
        
);

CREATE TABLE Employee(

        eUserId NUMBER(8) PRIMARY KEY,
        eUser VARCHAR2(50) UNIQUE,
        ePassword VARCHAR2(50) NOT NULL
        
);

CREATE TABLE BankAdmin(

        adminId NUMBER(8) PRIMARY KEY,
        adminUser VARCHAR2(50) UNIQUE,
        adminPass VARCHAR2(50) NOT NULL
        
);

INSERT INTO BankAdmin VALUES (1852, 'marcus', 'Saints19');
INSERT INTO Employee VALUES (534, 'bossmoves', 'saints2');

ALTER TABLE Customer ADD
 approveStatus INT CHECK (approveStatus = 0 OR approveStatus = 1);
 
INSERT INTO Customer
(CustomerID,cUsername, cPassword,firstName, lastName) 
VALUES (472, 'stlouisone', 'there', 'marcus','stlouis');

SELECT * FROM Customer;
SELECT * FROM Employee;
SELECT * FROM CAccount;
SELECT * FROM BankAdmin;

SELECT CustomerId FROM Customer WHERE Approvestatus = 0;

COMMIT;

