CREATE USER larsonsad IDENTIFIED BY p4ssw0rd;

GRANT CONNECT, RESOURCE TO larsonsad;
GRANT DBA TO larsonsad WITH ADMIN OPTION;

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
CREATE TABLE AccountM(
    a_checking FLOAT(10),
    a_savings FLOAT(10),
    a_pKey_fk NUMBER(6),
    CONSTRAINT a_pKey_fk FOREIGN KEY (a_pKey_fk) REFERENCES AccountU (a_pKey) ON DELETE CASCADE
);

--DROP STATMENTS
DROP TABLE AccountM;
DROP TABLE AccountU;


--SELET STAMTENTS
SELECT * FROM AccountU;
SELECT * FROM AccountM;

CREATE TABLE temp(
    seq NUMBER(10)
);
--INSERT STAMENTS TO TEST TRIGGER
INSERT INTO AccountU(a_accountKey, a_accountStatus, a_userName1, a_passWord1, a_userName2, a_password2, a_userType, a_joint) VALUES(152,1, 'sadie','larson','NULL','NULL',1,0);
INSERT INTO AccountM(a_checking, a_savings) VALUES(0, 5);	 
INSERT INTO temp VALUES(0);


CREATE SEQUENCE accountU_seq
   START WITH 27
   INCREMENT BY 1;
    --this sequence will be used to handle the id field for employees
/


CREATE OR REPLACE TRIGGER account_seq_trigger
BEFORE INSERT ON AccountU -- when and what action happens ('after')
FOR EACH ROW
BEGIN
    IF :new.a_pKey is NULL THEN
    UPDATE temp SET seq = accountU_seq.nextval;
    SELECT seq INTO :new.a_pKey FROM temp;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER accountM_seq_trigger
BEFORE INSERT ON AccountM -- when and what action happens ('after')
FOR EACH ROW
BEGIN
    IF :new.a_pKey_fk is NULL THEN
    SELECT seq INTO :new.a_pKey_fk FROM temp;
    END IF;
END;
/