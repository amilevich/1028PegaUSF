CREATE TABLE bankCustomer(
acctId NUMBER(6) NOT NULL primary key,
userName VARCHAR(225) NOT NULL,
password1 VARCHAR(225) NOT NULL,
fName VARCHAR(225) NOT NULL,
lName VARCHAR(225) NOT NULL,
cusId NUMBER NOT NULL,
status VARCHAR(225) NOT NULL,
balance NUMBER (10)NOT NULL
);

ALTER TABLE bankCustomer
ADD(
    CONSTRAINT bankCustomer_pk PRIMARY KEY(id)
    );
    CREATE OR REPLACE TRIGGER bankCustomer_on_insert
  BEFORE INSERT ON bankCustomers
  FOR EACH ROW
BEGIN
  SELECT bankCustomer_sequence.nextval
  INTO :new.acctId
  FROM bankAccount;
END;
    


CREATE TABLE bankAccount(
acctId NUMBER(6) NOT NULL,
accountBalance NUMBER(10) NOT NULL,
status VARCHAR(225) NOT NULL

);
ALTER TABLE bankAccount
ADD FOREIGN KEY (acctId) REFERENCES bankAccount(acctId);




DROP TABLE bankAccount;
SELECT * FROM  bankCustomer;

