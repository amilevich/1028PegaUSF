--Run this then create a new connection named ERS_DB 

CREATE USER CDD IDENTIFIED BY p4ssw0rd;

GRANT CONNECT,RESOURCE TO CDD;
GRANT DBA TO CDD WITH ADMIN OPTION;
GRANT CREATE SESSION TO CDD;
GRANT UNLIMITED TABLESPACE TO CDD;
