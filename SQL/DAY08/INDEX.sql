-- 2021- 06 - 17 

-- INDEX: 검색을 빠르게 하기 위한 객체
-- 물리적인 저장 공간이 필요
-- 생성 시간이 필요
-- 많은 INDEX를 생성하면 DML작업이 많은 경우 성능저하


-- <테스트>
-- EMP01 테이블을 복사 > 로우들을 계속 복사

-- EMP 테이블을 복사한 EMP01테이블 생성
DROP TABLE EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP;

-- EMP01 테이블 조회
SELECT * FROM EMP01;

-- EMP01테이블에 계속 튜플을 복사해 넣음
INSERT INTO EMP01 SELECT * FROM EMP01;

-- 찾고싶은 특정 튜플 넣음
INSERT INTO EMP01 (EMPNO, ENAME) VALUES (7777, 'KING');
INSERT INTO EMP01 (EMPNO, ENAME) VALUES (7777, 'SON');

-- 성능 테스트
SELECT * FROM EMP01 WHERE ENAME = 'SON';

-- EMP01테이블에 ENAME 컬럼을 INDEX 설정
CREATE INDEX INDEX_EMP01_ENAME
ON EMP01(ENAME);

-- INDEX를 사용해서 성능 테스트
SELECT * FROM EMP01 WHERE ENAME = 'SON';

-- INDEX 사용 주의사항
-- DML이 많은 경우, 
-- 하나의 테이블에 INDEX가 3~4개 이상으로 들어갈 때는 사용을 고려해봐야 함
-- 또한 검색 결과가 전체 튜플의 4~5% 이하로 들어올 때만 효과가 있음
