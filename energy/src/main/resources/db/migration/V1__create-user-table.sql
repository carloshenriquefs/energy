CREATE SEQUENCE SEQ_USER
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE TB_USER(
    ID INTEGER DEFAULT SEQ_USER.NEXTVAL NOT NULL,
    NAME VARCHAR2(100) NOT NULL,
    EMAIL VARCHAR2(100) UNIQUE NOT NULL,
    PASSWORD VARCHAR2(255) NOT NULL,
    ROLE VARCHAR2(50) DEFAULT 'USER' NOT NULL
);
