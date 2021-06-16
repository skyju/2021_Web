-- 21.06.16

-- DML

-- 데이터 입력 : 행단위 입력
-- INSERT INTO 테이블명(컬럼명, ...) VALUES (데이터, 데이터, ...)
-- 입력하고자 하는 컬럼과 입력 데이터의 개수는 일치해야 한다.
-- 컬럼의 도메인과 입력 데이터의 타입이 일치해야 한다.
-- 기본키와 같이 NOT NULL 인 경우 컬럼을 생략하면 안된다.

CREATE TABLE DEPT01
AS SELECT * FROM DEPT WHERE 1=0;

