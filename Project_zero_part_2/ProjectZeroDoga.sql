CREATE TABLE AdminTable(
    p_id number(10) not null,
    --primary key  
    p_auth NUMBER(10),
    p_name VARCHAR2(50),
    p_psswrd VARCHAR2(50),
    p_balance NUMBER(10),
    p_state VARCHAR2(50),
    
    CONSTRAINT user_primary_key PRIMARY KEY(p_id)
);

SELECT * FROM AdminTable;

CREATE SEQUENCE serial_num_seq
start with 1000
increment by 1
/
CREATE TRIGGER serial_num_seq_trigger
BEFORE INSERT ON users --when and what actions happen ('after')
FOR EACH ROW
BEGIN --loop
    IF :new.p_id =0 THEN
    SELECT serial_num_seq.nextval INTO :new.p_id FROM dual;
    END IF;
END;
/

--INSERT INTO Admin1 VALUES('pup', 'yellow');

DROP TABLE AdminTable;