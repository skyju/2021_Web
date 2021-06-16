-- 06/16 
-- <View>

-- 자주 사용되는 30번 부서에 소속된 사원들의 사번과 이름과 부서번호를
-- 출력하기 위한 SELECT문을 하나의 뷰로 정의해 봅시다.

-- 뷰 만들기
CREATE OR REPLACE VIEW EMP_VIEW_30
AS
SELECT EMPNO, ENAME, DEPTNO
FROM EMP
WHERE DEPTNO = 30;

-- 뷰 조회하기
SELECT * FROM EMP_VIEW_30;
SELECT * FROM EMP_DETAILS_VIEW;

-- 뷰 조회할 때, WHERE절 사용
SELECT * FROM EMP_VIEW_30 WHERE ENAME = 'JAMES';

-- 뷰 삭제하기
DROP VIEW EMP_VIEW_30;



-- 인라인 뷰 (FROM절에 들어가는 SUB QUERY)
-- 사원 중에 입사일이 빠른 사람 5명만을 얻어 오는 질의문을 작성해 봅시다.
-- TOP-N을 구하기 위해서는 ROWNUM과 인라인 뷰가 사용됩니다.

SELECT *
FROM (SELECT * FROM EMP ORDER BY HIREDATE)
WHERE ROWNUM <= 5;

-- 왜 아래처럼 하면 안되나요?
SELECT *
FROM EMP
WHERE ROWNUM <= 5
ORDER BY HIREDATE;
-- ORDER BY는 맨 아래 작성해야 하기 때문에,
-- ROWNUM으로 먼저 튜플이 잘리고 나서 정렬이 되기 때문에!

-- 마찬가지로 가장 최근에 입사한 사람 5명만 뽑을 때는 ORDER BY를 DESC로 하면 됨


-- ROWNUM 더 알아보기

--(1)
SELECT ROWNUM, ENAME
FROM EMP;
-- 기본적으로 EMP가 가지고 있는 ROWNUM이 보임 (INSERT 순서 대로)

--(2)
SELECT ROWNUM, ENAME
FROM (SELECT * FROM EMP ORDER BY ENAME);
-- 인라인 뷰가 생성되면서 SROTING된 순서대로 새롭게 ROWNUM이 만들어짐.
-- 따라서 (1) 과 (2) 는 다른 결과를 보여줍니다. 



-- 입사일 기준으로 정렬한 뷰를 생성하여 활용하기
CREATE OR REPLACE VIEW VIEW_HIR
AS
SELECT * FROM EMP ORDER BY HIREDATE;

SELECT ROWNUM, ENAME, HIREDATE
FROM VIEW_HIR;

SELECT ROWNUM, ENAME, HIREDATE
FROM VIEW_HIR
WHERE ROWNUM < 6
ORDER BY ENAME;
