-- 32. EQUI 조인을 사용하여 SCOTT 사원의 부서번호와 부서 이름을 출력하시오.

-- EQUI JOIN
SELECT E.ENAME, E.DEPTNO, D.DNAME
FROM DEPT D, EMP E
WHERE E.ENAME = 'SCOTT' AND D.DEPTNO = E. DEPTNO;

-- INNER JOIN
SELECT E.ENAME, E.DEPTNO, D.DNAME
FROM DEPT D INNER JOIN EMP E ON E.ENAME = 'SCOTT' AND D.DEPTNO = E.DEPTNO;

-- 33. INNER JOIN과 ON 연산자를 사용하여 사원 이름과 함께 그 사원이 소속된 부서이름과 지역 명을 출력하시오.

-- EQUI JOIN
SELECT E.ENAME, D.DNAME, D.LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;

-- INNER JOIN
SELECT E.ENAME, D.DNAME, D.LOC
FROM DEPT D INNER JOIN EMP E ON D.DEPTNO = E.DEPTNO;

-- USING
SELECT ENAME, DNAME, LOC
FROM EMP INNER JOIN DEPT
USING (DEPTNO);

-- NATURAL JOIN
SELECT ENAME, DNAME, LOC
FROM EMP NATURAL JOIN DEPT;

-- 36. 조인과 WildCARD를 사용하여 이름에 ‘A’가 포함된 모든 사원의 이름과 부서명을 출력하시오.

SELECT ENAME, DNAME
FROM EMP NATURAL JOIN DEPT
WHERE ENAME LIKE('%A%');

-- REGEXP 활용
SELECT ENAME, DNAME
FROM EMP NATURAL JOIN DEPT
WHERE REGEXP_LIKE(ENAME, '[A]');

-- 37. JOIN을 이용하여 NEW YORK에 근무하는 모든 사원의 이름, 업무, 부서번호 및 부서명을 출력하시오.

SELECT E.ENAME, E.JOB, E.DEPTNO, D.DNAME
FROM DEPT D, EMP E
WHERE D.DEPTNO = E.DEPTNO AND REGEXP_LIKE(D.LOC, 'NEW YORK');

-- NATURAL JOIN
SELECT ENAME, JOB, DEPTNO, DNAME
FROM EMP NATURAL JOIN DEPT
WHERE REGEXP_LIKE(LOC, 'NEW YORK');

-- 38. SELF JOIN을 사용하여 사원의 이름 및 사원번호, 관리자 이름을 출력하시오.

SELECT E.ENAME, E.EMPNO, M.ENAME AS MGRNAME
FROM EMP E, EMP M
WHERE E.MGR = M.EMPNO;

-- 39. OUTER JOIN, SELF JOIN을 사용하여 관리자가 없는 사원을 포함하여
-- 사원번호를 기준으로 내림차순 정렬하여 출력하시오.

-- 방법1: (+) 이용: OUTER JOIN
SELECT E.ENAME, E.EMPNO, M.ENAME AS MGRNAME
FROM EMP E, EMP M
WHERE E.MGR = M.EMPNO(+) -- 표현하고자 하는 칼럼이 테이블의 반대쪽, NULL값을 가지는 위치에
ORDER BY E.EMPNO DESC;

-- 방법2: ANSI JOIN - LEFT OUTER JOIN 이용
SELECT E.ENAME, E.EMPNO, M.ENAME AS MGRNAME
FROM EMP E LEFT OUTER JOIN EMP M ON E.MGR = M.EMPNO
ORDER BY E.EMPNO DESC;

-- 표현해야 하는 행이 오른쪽에 있으면, RIGHT OUTER JOIN 으로 바꾸면 됨
SELECT E.ENAME, E.EMPNO, M.ENAME AS MAGNAME
FROM EMP M RIGHT OUTER JOIN EMP E ON M.EMPNO = E.MGR
ORDER BY E.EMPNO DESC;

-- 40. SELF JOIN을 사용하여 지정한 사원의 이름, 부서번호, 
-- 지정한 사원과 동일한 부서에서 근무하는 사원을 출력하시오. ( SCOTT )

-- SELF JOIN
SELECT E.DEPTNO, S.ENAME
FROM EMP E, EMP S
WHERE E.ENAME = 'SCOTT' AND E.DEPTNO = S.DEPTNO;

-- EXTRA) SUBQUERY를 이용하여 풀이
SELECT DEPTNO, ENAME
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO 
                FROM EMP 
                WHERE ENAME = 'SCOTT');

-- 41. SELF JOIN을 사용하여 WARD 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하시오.

SELECT E.ENAME, E.HIREDATE
FROM EMP E, EMP W
WHERE W.ENAME = 'WARD' AND E.HIREDATE > W.HIREDATE
ORDER BY E.HIREDATE;

-- EXTRA) SUBQUERY를 이용하여 풀이
SELECT ENAME, HIREDATE
FROM EMP
WHERE HIREDATE > (SELECT HIREDATE 
                  FROM EMP 
                  WHERE ENAME = 'WARD')
ORDER BY HIREDATE;

-- 42. SELF JOIN 을 사용하여 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을 
-- 관리자의 이름 및 입사일과 함께 출력하시오.

SELECT E.ENAME, E.HIREDATE, M.ENAME AS MGRNAME, M.HIREDATE AS MGRHIREDATE
FROM EMP E, EMP M
WHERE E.MGR = M.EMPNO AND E.HIREDATE < M.HIREDATE
ORDER BY E.HIREDATE;
