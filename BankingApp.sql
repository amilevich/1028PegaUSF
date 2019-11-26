SELECT * FROM Bank_Accounts;
SELECT * FROM Bank_Clients;
SELECT * FROM Bank_Employees;

CREATE USER Banker IDENTIFIED BY p4ssw0rd;
GRANT CONNECT, RESOURCE TO Banker;
GRANT DBA TO Banker WITH ADMIN OPTION;

CREATE TABLE Bank_Accounts(
    acct_num NUMBER(12) PRIMARY KEY,
    balance NUMBER(12, 2) NOT NULL,
    status VARCHAR2 (9) NOT NULL
);

CREATE TABLE Bank_Clients(
    user_name VARCHAR2(20) PRIMARY KEY,
    password VARCHAR2 (16) NOT NULL,
    first_name VARCHAR2 (20) NOT NULL,
    last_name VARCHAR2 (50) NOT NULL,
    date_of_birth DATE NOT NULL,
    address VARCHAR2(50) NOT NULL
);

CREATE TABLE Bank_Employees(
    user_name VARCHAR2(20) PRIMARY KEY,
    password VARCHAR2 (16) NOT NULL,
    first_name VARCHAR2 (20) NOT NULL,
    last_name VARCHAR2 (50) NOT NULL,
    date_of_birth DATE NOT NULL,
    address VARCHAR2(50) NOT NULL,
    admin_priv number(1) NOT NULL
);

CREATE TABLE Client_Accounts(
    user_name VARCHAR2(20) NOT NULL,
    acct_num NUMBER(12) NOT NULL,
    CONSTRAINT user_fk FOREIGN KEY (user_name) REFERENCES Bank_Clients(user_name),
    CONSTRAINT acct_fk FOREIGN KEY (acct_num) REFERENCES Bank_Accounts(acct_num),
    CONSTRAINT c_a_pk PRIMARY KEY (user_name,acct_num)
);

INSERT INTO Bank_Clients VALUES ('BobSmith', 'passw0rd', 'Bob', 'Smith', '07-DEC-72', '789 Maple Ave Tampa FL 12345');
INSERT INTO Bank_Employees VALUES ('JohnDoe', 'passw0rd', 'John', 'Doe', '21-JAN-63', '123 Main St Tampa FL 12345', 1);
INSERT INTO Bank_Employees VALUES ('JaneDoe', 'passw0rd', 'Jane', 'Doe', '01-AUG-67', '123 Main St Tampa FL 12345', 0);
INSERT INTO Bank_Accounts VALUES (95, 500.50, 'Approved');
INSERT INTO Client_Accounts VALUES ('BobSmith', 95);

SELECT Bank_Accounts.acct_num, balance, status FROM Bank_Accounts INNER JOIN Client_Accounts 
ON Client_Accounts.acct_num = Bank_Accounts.acct_num WHERE user_name='BobSmith';

CREATE SEQUENCE acct_seq
    START WITH 100
    INCREMENT BY 1;
/

CREATE SEQUENCE client_acct_seq
    START WITH 100
    INCREMENT BY 1;
/

CREATE TRIGGER acct_seq_trigger
BEFORE INSERT ON Bank_Accounts
FOR EACH ROW
BEGIN
    IF :new.acct_num IS NULL THEN
    SELECT acct_seq.nextval INTO :new.acct_num FROM dual;
    END IF;
END;
/

CREATE TRIGGER client_acct_seq_trigger
BEFORE INSERT ON Client_Accounts
FOR EACH ROW
BEGIN
    IF :new.acct_num IS NULL THEN
    SELECT client_acct_seq.nextval INTO :new.acct_num FROM dual;
    END IF;
END;
/

