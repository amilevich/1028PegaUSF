DROP USER bank CASCADE;


CREATE USER bank
IDENTIFIED BY bank0
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to bank;
GRANT resource to bank;
GRANT create session TO bank;
GRANT create table TO bank;
GRANT create view TO bank;

conn bank/bank0

CREATE TABLE AccountBank
(
    AccountId VARCHAR2(10) NOT NULL,
    Balance NUMBER NOT NULL,
    Joint NUMBER NOT NULL,
    Pending NUMBER NOT NULL,
    CONSTRAINT PK_AccountBank PRIMARY KEY  (AccountId)
);

CREATE TABLE UserAccount
(
    UserAccountId NUMBER NOT NULL,
    userName VARCHAR2(40) NOT NULL,
    AccountId VARCHAR2(10) NOT NULL,
    CONSTRAINT PK_UserAccount PRIMARY KEY  (UserAccountId)
);

CREATE TABLE BankUser
(
    userName VARCHAR2(40) NOT NULL,
    userPass VARCHAR2(20) NOT NULL,
    userType NUMBER,
    CONSTRAINT PK_BankUser PRIMARY KEY  (userName)
);

ALTER TABLE UserAccount ADD CONSTRAINT FK_UserAccount
    FOREIGN KEY (userName) REFERENCES BankUser (userName);
    
ALTER TABLE UserAccount ADD CONSTRAINT FK_AccountUser
    FOREIGN KEY (AccountId) REFERENCES AccountBank (AccountId); 
    
CREATE SEQUENCE useraccount_seq
    START WITH 100 
    INCREMENT BY 1;
    
CREATE OR REPLACE TRIGGER useraccount_seq_trigger
BEFORE INSERT ON UserAccount 
FOR EACH ROW
BEGIN
    IF :new.UserAccountId = 0 THEN
    SELECT useraccount_seq.nextval INTO :new.UserAccountId FROM dual;
    END IF;
END; 

INSERT INTO  BankUser VALUES('employee', 'employee', 2);
INSERT INTO BankUser VALUES('admin', 'admin', 3);


