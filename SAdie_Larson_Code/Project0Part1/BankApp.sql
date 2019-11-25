CREATE TABLE AccountU(
    a_pKey NUMBER(6)PRIMARY KEY,
    a_accountKey NUMBER(6), 
    a_accountStatus NUMBER(2),
    a_userName1 VARCHAR2(60),
    a_passWord1 VARCHAR2(60),
    a_userName2 VARCHAR2(60),
    a_passWord2 VARCHAR2(60),
    a_userType NUMBER(3),
    a_joint NUMBER(6)
);
--INSERT INTO AccountU VALUES(1,152,1, 'sadie','larson','NULL','NULL',1,0);
CREATE TABLE AccountM(
    a_checking FLOAT(10),
    a_savings FLOAT(10),
    a_pKey_fk NUMBER(6),
    CONSTRAINT a_pKey_fk FOREIGN KEY (a_pKey_fk) REFERENCES AccountU (a_pKey) ON DELETE CASCADE
);
DROP TABLE AccountM;
DROP TABLE AccountU;
SELECT * FROM AccountU;
UPDATE AccountU SET a_accountStatus = 1 WHERE a_accountKey = 292;
SELECT * FROM AccountM;

--INSERT INTO AccountU(a_accountKey, a_accountStatus, a_userName1, a_passWord1, a_userName2, a_passWord2, a_userType, a_joint) VALUES(123,'1','l','u','o','p','1',0);
		 


CREATE SEQUENCE account_seq
    START WITH 27
    INCREMENT BY 1;
    --this sequence will be used to handle the id field for employees
/

CREATE OR REPLACE TRIGGER account_seq_trigger
BEFORE INSERT ON AccountU -- when and what action happens ('after')
FOR EACH ROW
BEGIN
    IF :new.a_pKey is NULL THEN
    SELECT account_seq.nextval INTO :new.a_pKey FROM dual;
    END IF;
END;
/
