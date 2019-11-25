--/*******************************************************************************
--  Create database
--********************************************************************************/
CREATE USER bankadmin IDENTIFIED BY p4ssw0rd
    DEFAULT TABLESPACE users
    TEMPORARY TABLESPACE temp
    QUOTA 10M ON users;

GRANT connect TO bankadmin;

GRANT resource TO bankadmin;

GRANT
    CREATE SESSION
TO bankadmin;

GRANT
    CREATE TABLE
TO bankadmin;

GRANT
    ALTER TABLE
TO bankadmin;

GRANT
    CREATE VIEW
TO bankadmin;

CONN bankadmin / p4ssw0rd

--/*******************************************************************************
--  Create Tables
--********************************************************************************/

CREATE TABLE bank_ids (
    bank_id             NUMBER NOT NULL,
    account_increment   NUMBER NOT NULL,
    user_increment      NUMBER NOT NULL
);

CREATE TABLE boolean_type (
    "TRUE"    NUMBER(1, 0) DEFAULT 1,
    "FALSE"   NUMBER(1, 0) DEFAULT 0,
    "BNULL"   NUMBER(1, 0)
);

ALTER TABLE boolean_type
    ADD CONSTRAINT boolean_type_ck1 CHECK ( true = 1
                                            AND false = 0
                                            AND bnull IS NULL );

CREATE TABLE accounts (
    active_account_id   NUMBER NOT NULL,
    customer_id         NUMBER NOT NULL,
    balance             NUMBER,
    approval            NUMBER(1, 0),
    CONSTRAINT account_pk PRIMARY KEY ( active_account_id )
);

CREATE TABLE applications (
    application_id   NUMBER NOT NULL,
    customer_id      NUMBER NOT NULL,
    balance          NUMBER,
    approval         NUMBER(1, 0),
    CONSTRAINT application_pk PRIMARY KEY ( application_id )
);

CREATE TABLE customers (
    customer_id   NUMBER NOT NULL,
    account_id    NUMBER NOT NULL,
    username      VARCHAR2(50),
    password      VARCHAR2(50),
    firstname     VARCHAR2(50),
    lastname      VARCHAR2(50),
    CONSTRAINT customer_pk PRIMARY KEY ( customer_id )
);

CREATE TABLE employees (
    employee_id   NUMBER NOT NULL,
    username      VARCHAR2(50),
    password      VARCHAR2(50)
);

ALTER TABLE accounts
    ADD CONSTRAINT customer_id_fk FOREIGN KEY ( customer_id )
        REFERENCES customers ( customer_id );

ALTER TABLE applications
    ADD CONSTRAINT customer_id_fk FOREIGN KEY ( customer_id )
        REFERENCES customers ( customer_id );

ALTER TABLE customers
    ADD CONSTRAINT account_id_fk FOREIGN KEY ( account_id )
        REFERENCES accounts ( active_account_id );

ALTER TABLE customers
    ADD CONSTRAINT application_id_fk FOREIGN KEY ( account_id )
        REFERENCES applications ( application_id );

CREATE TABLE customer_with_accounts (
    customer_id   NUMBER NOT NULL,
    account_id    NUMBER NOT NULL
);

CREATE TABLE customer_with_applications (
    customer_id   NUMBER NOT NULL,
    account_id    NUMBER NOT NULL
);

CREATE SEQUENCE appls_id_seq;

CREATE OR REPLACE TRIGGER trigger_applications BEFORE
    INSERT ON Applications
    FOR EACH ROW
BEGIN
    SELECT
        appls_id_seq.NEXTVAL
    INTO :new.application_id
    FROM
        dual;

END;

CREATE SEQUENCE accts_id_seq;

CREATE OR REPLACE TRIGGER trigger_accounts BEFORE
    INSERT ON Accounts
    FOR EACH ROW
BEGIN
    SELECT accts_id_seq.NEXTVAL
    INTO :new.active_account_id
    FROM dual;

END;

CREATE SEQUENCE cust_id_seq;

CREATE OR REPLACE TRIGGER trigger_customers BEFORE
    INSERT ON Customers
    FOR EACH ROW
BEGIN
    SELECT cust_id_seq.NEXTVAL
    INTO :new.customer_id FROM dual;
END;

CREATE SEQUENCE employee_id_seq;

CREATE OR REPLACE TRIGGER trigger_employees BEFORE
    INSERT ON Employees
    FOR EACH ROW
BEGIN
    SELECT employee_id_seq.NEXTVAL
    INTO :new.employee_id FROM dual;
END;