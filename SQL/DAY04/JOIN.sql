-- 06.11

-- JOIN


-- CROSS JOIN
-- 스키마들의 합 : 집합의 곱 연산과 같다.

-- 카티샨 프로덕트 :
-- 두 테이블에 속한 튜플들의 모든 가능한 쌍을 생성함
SELECT *
FROM EMP, DEPT;

-- 동등 조인: EQUI JOIN
-- 보통 외래키 = 기본키
SELECT * 
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
ORDER BY D.DNAME, E.ENAME;

-- EQUI 조인을 사용하여 SCOTT 사원의 부서번호와 부서 이름을 출력하시오.

SELECT E.ENAME, D.DEPTNO, DNAME
FROM DEPT D, EMP E
WHERE E.ENAME = 'SCOTT' AND D.DEPTNO = E. DEPTNO;

-- SELF JOIN : 자기 자신을 조인 (참조)
-- EMP > MGR 칼럼이 EMP.EMPNO 참조

SELECT E.ENAME || '의 메니저는' || M.ENAME || '입니다.'
FROM EMP E, EMP M
WHERE E.MGR = M.EMPNO;

SELECT E.EMPNO, E.ENAME, E.MGR, M.ENAME
FROM EMP E, EMP M
WHERE E.MGR = M.EMPNO(+); -- 오라클에서 NULL표현

