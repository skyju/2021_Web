-- 21.06.16

-- DML

--     <CRUD>
-- INSERT : C REATE
-- SELECT : R EAD
-- UPDATE : U PDATE
-- DELETE : D ELETE

-- 데이터 입력 : 행단위 입력
-- INSERT INTO 테이블명(컬럼명, ...) VALUES (데이터, 데이터, ...)
-- 입력하고자 하는 컬럼과 입력 데이터의 개수는 일치해야 한다.
-- 컬럼의 도메인과 입력 데이터의 타입이 일치해야 한다.
-- 기본키와 같이 NOT NULL 인 경우 컬럼을 생략하면 안된다.

CREATE TABLE DEPT01
AS SELECT * FROM DEPT WHERE 1=0;

-- 1번부서 개발팀 서울 위치
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (10, '개발팀', '서울');

--
DESC EMP;

ROLLBACK;

DESC ORDERS;

INSERT INTO ORDERS (ORDERID, CUSTID, BOOKID) VALUES (11,6,11);
-- 외래키 오류



-- 서브쿼리를 이용해서 데이터 입력
DROP TABLE DEPT02;

-- NOT NULL 조건외에 다른 제약조건은 가져오지 않음
CREATE TABLE DEPT02
AS SELECT * FROM DEPT WHERE 1=2;
-- MS SQL에서는 아래처럼 작성
SELECT * INTO DEPT02
FROM DEPT
WHERE 1=2;


INSERT INTO DEPT02
SELECT * FROM DEPT;

SELECT * 
FROM DEPT02; 
-- DEPT02에는 UNIQUE 제약조건이 따라오지 않아서, 중복된 데이터가 계속 들어감




-- 데이터를 변경: 
-- UPDATE 테이블명 
-- SET 컬럼이름=새로운데이터, 컬럼이름=새로운데이터 
-- WHERE 행을 선택하는 조건 

CREATE TABLE DEPT03
AS SELECT * FROM DEPT;

SELECT * FROM DEPT03;

-- 모든 부서의 위치를 SEOUL로 이동
UPDATE DEPT03 SET LOC = 'SEOUL';

-- 10번 부서의 위치를 PUSAN으로 이동, 부서 이름도 DEV로 변경
UPDATE DEPT03
SET LOC = 'PUSAN', DNAME = 'DEV'
WHERE DEPTNO = 10;

-- EMP01 새롭게 생성하고 UPDATE
DROP TABLE EMP01;

CREATE TABLE EMP01 AS SELECT * FROM EMP;

SELECT * FROM EMP01;

-- 모든 사원의 부서번호를 30번으로 수정합시다.
UPDATE EMP01
SET DEPTNO = 30;

-- 모든 사원의 급여를 10% 인상시키는 UPDATE 문
UPDATE EMP01
SET SAL = SAL*1.1;

-- 모든 사원의 입사일을 오늘로 수정
UPDATE EMP01
SET HIREDATE = SYSDATE;

UPDATE EMP01
SET HIREDATE = '21/06/16';

ROLLBACK;

-- 급여가 3000 이상인 사원만 급여를 10% 인상합니다.
UPDATE EMP01
SET SAL = SAL*1.1
WHERE SAL >= 3000;

-- 1981년에 입사한 사원의 입사일을 오늘로 수정핪다
UPDATE EMP01
SET HIREDATE = SYSDATE
WHERE SUBSTR(HIREDATE, 1, 2) = '81';

-- SCOTT 사원의 부서번호는 30번으로, 직금은 MANAGER로 한번에 수정하도록 합시다.
UPDATE EMP01
SET DEPTNO=30, JOB='MANAGER'
WHERE ENAME = 'SCOTT';

-- SCOTT 사원의 입사일은 오늘로, 급여를 50으로 커미션을 4000으로 수정합시다.
UPDATE EMP01
SET HIREDATE = SYSDATE, SAL = 50, COMM = 4000
WHERE ENAME = 'SCOTT';

-- 20번 부서의 지역명을 40번 부서의 지역명으로 변경하기 위해서 서브 쿼리문을 사용해봅시다.
DROP TABLE DEPT01;
CREATE TABLE DEPT01 AS SELECT * FROM DEPT;
SELECT * FROM DEPT01;

UPDATE DEPT01 SET LOC = (SELECT LOC FROM DEPT01 WHERE DEPTNO = 40)
WHERE DEPTNO = 20;

-- 서브쿼리를 이용해서 부서번호가 20인 부서의 부서명과 지역명을
-- 부서번호 10번인 부서와 동일하게 변경하도록 해봅시다.
UPDATE DEPT01
SET (DNAME, LOC) = (SELECT DNAME, LOC FROM DEPT01 WHERE DEPTNO = 10)
WHERE DEPTNO = 20;

SELECT * FROM DEPT01;




-- 데이터의 삭제 : 행단위 삭제
-- DELETE FROM 테이블 이름 WHERE 조건

-- DEPT01 테이블의 모든 데이터를 삭제
DELETE FROM DEPT01;

-- 이름이 SCOTT인 사원을 삭제
DELETE FROM EMP01 WHERE ENAME = 'SCOTT';
SELECT * FROM EMP01;

-- EMP01테이블에서 부서명이 SALES인 사원을 모두 삭제해봅시다.
DELETE FROM EMP01 
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');

ROLLBACK;