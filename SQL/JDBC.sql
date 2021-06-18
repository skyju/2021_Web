-- 2021/06/18

-- JDBC
SELECT * FROM DEPT01;

DELETE FROM DEPT01;

INSERT INTO DEPT01 VALUES (DEPT01_DEPTNO_SEQ.NEXTVAL, 'DEV', 'SEOUL');

-- DEPT01 DEPTNO에 입력할 일련 번호 > SEQUENCE

CREATE SEQUENCE DEPT01_DEPTNO_SEQ
START WITH 10
INCREMENT BY 10;

--

DELETE FROM DEPT01 WHERE DEPTNO = ?;

UPDATE DEPT01 SET DNAME = ?, LOC = ? WHERE DEPTNO = ?;

select DEPT01_DEPTNO_SEQ.nextval from dual;

select * from dept;
COMMIT;

INSERT INTO DEPT VALUES(50, 'MARKETING', 'SEOUL');

delete from dept where deptno = 50;

DROP TABLE MEMBER;

DROP INDEX MEMBER_INDEX;

DROP VIEW MEMBER_VIEW;
