SELECT * FROM Ers_Reimbursement_Status;
SELECT * FROM Ers_Reimbursement_Type;
SELECT * FROM Ers_Users_Roles;
SELECT * FROM Ers_Users;
SELECT * FROM Ers_Reimbursements;

CREATE TABLE Ers_Reimbursement_Status(
    reimb_status_id NUMBER(1),
    reimb_status VARCHAR2(8),
    CONSTRAINT reimb_status_pk PRIMARY KEY(reimb_status_id)
);
INSERT INTO Ers_Reimbursement_Status VALUES (1, 'Pending');
INSERT INTO Ers_Reimbursement_Status VALUES (2, 'Approved');
INSERT INTO Ers_Reimbursement_Status VALUES (3, 'Denied');

CREATE TABLE Ers_Reimbursement_Type(
    reimb_type_id NUMBER(1),
    reimb_type VARCHAR2(7),
    CONSTRAINT reimb_type_pk PRIMARY KEY(reimb_type_id)
);
INSERT INTO Ers_Reimbursement_Type VALUES (1, 'Travel');
INSERT INTO Ers_Reimbursement_Type VALUES (2, 'Lodging');
INSERT INTO Ers_Reimbursement_Type VALUES (3, 'Food');
INSERT INTO Ers_Reimbursement_Type VALUES (4, 'Other');

CREATE TABLE Ers_Users_Roles(
    ers_user_role_id NUMBER(1),
    user_role VARCHAR2(15),
    CONSTRAINT ers_user_roles_pk PRIMARY KEY(ers_user_role_id)
);
INSERT INTO Ers_Users_Roles VALUES (0, 'Employee');
INSERT INTO Ers_Users_Roles VALUES (1, 'Finance Manager');

CREATE TABLE Ers_Users(
ers_user_id NUMBER(6),
ers_username VARCHAR2(30),
ers_password VARCHAR2(20),
user_first_name VARCHAR2(20),
user_last_name VARCHAR2(30),
user_email VARCHAR2(50),
user_role_id NUMBER(1),
CONSTRAINT ers_users_pk PRIMARY KEY(ers_user_id),
CONSTRAINT ers_user_roles_fk FOREIGN KEY (user_role_id) REFERENCES Ers_Users_Roles ( ers_user_role_id)
);

INSERT INTO Ers_Users VALUES (101, 'BillL', 'p4ssw0rd', 'Bill', 'Lumbergh', 'billlumbergh@somecompany.com', 1);

CREATE TABLE Ers_Reimbursements(
reimb_id NUMBER(6),
reimb_amount NUMBER(6),
reimb_submitted TIMESTAMP(9),
reimb_resolved TIMESTAMP(9),
reimb_description VARCHAR2(250),
reimb_author NUMBER(6),
reimb_resolver NUMBER(6),
reimb_status_id NUMBER(1),
reimb_type_id NUMBER(1),
CONSTRAINT ers_reimbursement_pk PRIMARY KEY(reimb_id),
CONSTRAINT ers_user_fk_auth FOREIGN KEY (reimb_author) REFERENCES Ers_Users(ers_user_id)
);


CREATE SEQUENCE reimb_seq
    START WITH 1000
    INCREMENT BY 1;
/

CREATE SEQUENCE ers_users_seq
    START WITH 1000
    INCREMENT BY 1;
/

CREATE TRIGGER reimb_seq_trigger
BEFORE INSERT ON Ers_Reimbursements
FOR EACH ROW
BEGIN
    IF :new.reimb_id IS NULL THEN
    SELECT reimb_seq.nextval INTO :new.reimb_id FROM dual;
    END IF;
END;
/

CREATE TRIGGER ers_users_seq_trigger
BEFORE INSERT ON Ers_Users
FOR EACH ROW
BEGIN
    IF :new.ers_user_id IS NULL THEN
    SELECT ers_users_seq.nextval INTO :new.ers_user_id FROM dual;
    END IF;
END;
/