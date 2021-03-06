--21.06.15 DDL 생성 과제

CREATE TABLE PHONEINFO_BASIC(
IDX NUMBER(6) CONSTRAINT PIB_IDX_PK PRIMARY KEY,
FR_NAME VARCHAR2(20) CONSTRAINT PIB_NAME_NN NOT NULL,
FR_PHONENUMBER VARCHAR2(20) CONSTRAINT PIB_PN_NN NOT NULL,
FR_EMAIL VARCHAR2(20),
FR_ADDRESS VARCHAR2(20),
FR_REGDATE DATE DEFAULT SYSDATE
);

CREATE TABLE PHONEINFO_UNIV(
IDX NUMBER(6) CONSTRAINT PIU_IDX_PK PRIMARY KEY,
FR_U_MAJOR VARCHAR2(20) DEFAULT 'N' CONSTRAINT PIU_MAJOR_NN NOT NULL,
FR_U_YEAR NUMBER(1) DEFAULT '1' 
                    CONSTRAINT PIU_YEAR_NN NOT NULL 
                    CONSTRAINT PIU_YEAR_CHECK CHECK(0 < FR_U_YEAR AND FR_U_YEAR < 5),
FR_REF NUMBER(7) CONSTRAINT PIU_REF_FK REFERENCES PHONEINFO_BASIC(IDX) NOT NULL
);

CREATE TABLE PHONEINFO_COM(
IDX NUMBER(6) CONSTRAINT PIC_IDX_PK PRIMARY KEY,
FR_C_COMPANY VARCHAR2(20) DEFAULT 'N' CONSTRAINT PIC_COMPANY_NN NOT NULL,
FR_REF NUMBER(6) CONSTRAINT PIC_REF_FK REFERENCES PHONEINFO_BASIC(IDX) NOT NULL
);


DROP TABLE PHONEINFO_BASIC;
DROP TABLE PHONEINFO_UNIV;
DROP TABLE PHONEINFO_COM;

DESC PHONEINFO_BASIC;
DESC PHONEINFO_UNIV;
DESC PHONEINFO_COM;