-- 2021-06-14 SUB QUERY 문제풀이

-- 43. 사원 번호가 7788인 사원과 담당 업무가 같은 사원을 표시(사원 이름과 담당업무)하시오.

-- 사원번호가 7788인 사원은 제외하고 출력
SELECT EMPNO, ENAME, JOB
FROM EMP
WHERE JOB = (SELECT JOB
             FROM EMP
             WHERE EMPNO = 7788)
      AND EMPNO != 7788;
      
-- SELF JOIN으로 풀이
SELECT E.EMPNO, E.ENAME, E.JOB
FROM EMP E, EMP N
WHERE N.EMPNO = 7788 AND E.JOB = N.JOB AND E.EMPNO != 7788;

-- 44. 사원번호가 7499인 사원보다 급여가 많은 사원을 표시하시오. 사원이름과 담당 업무

SELECT ENAME, JOB
FROM EMP
WHERE SAL > (SELECT SAL
             FROM EMP
             WHERE EMPNO = 7499);

-- SELF JOIN으로 풀이
SELECT E1.ENAME, E1.JOB
FROM EMP E1, EMP E2
WHERE E1.SAL > E2. SAL AND E2.EMPNO = 7499;
​
-- 45. 최소급여를 받는 사원의 이름, 담당업무 및 급여를 표시하시오. (그룹함수 사용)

SELECT ENAME, JOB, SAL
FROM EMP
WHERE SAL = (SELECT MIN(SAL)
             FROM EMP);
             
-- MIN함수 쓰지 않고 ALL 사용
SELECT ENAME, JOB, SAL
FROM EMP
WHERE SAL <= ALL (SELECT SAL
                  FROM EMP);
             
-- SELF JOIN으로 풀이
SELECT E1.ENAME, E1.JOB, E1.SAL
FROM EMP E1, EMP E2
GROUP BY E1.ENAME, E1.JOB, E1.SAL
HAVING E1.SAL = MIN(E2.SAL);

-- INLINE VIEW와 ROWNUM이용하여 풀이
SELECT ENAME, JOB, SAL
FROM (SELECT ENAME, JOB, SAL FROM EMP ORDER BY SAL)
WHERE ROWNUM < 2;

-- 46. 평균급여가 가장 적은 직급의 직급 이름과 직급의 평균을 구하시오.

SELECT JOB, AVG(SAL)
FROM EMP
GROUP BY JOB
HAVING AVG(SAL) = (SELECT MIN(AVG(SAL))
                   FROM EMP
                   GROUP BY JOB);

-- 47. 각 부서의 최소 급여를 받는 사원의 이름, 급여, 부서번호를 표시하시오.

-- 첫 번째 풀이
SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE SAL IN (SELECT MIN(SAL)
              FROM EMP
              GROUP BY DEPTNO);
-- IN연산자 주의해야함 예를들어 
-- 10번 부서의 최소급여가 100,
-- 20번 부서의 최소급여가 200
-- 30번 부서의 최소급여가 500 인경우,
-- 10번 부서에 급여를 200 받는 사원도 존재하는 경우
-- IN연산자에 걸려서 문제가 됨

-- 수업답안
SELECT ENAME, SAL, DEPTNO
FROM EMP E1
WHERE SAL IN (SELECT MIN(SAL)
              FROM EMP E2
              WHERE E1.DEPTNO = E2.DEPTNO)-- 이처럼 상관관계 처리 해야함
;

-- INLINE SUB QUERY로 변경해서 풀이
SELECT E1.ENAME, E1.SAL, E1.DEPTNO
FROM EMP E1, (SELECT DEPTNO, MIN(SAL) AS MINSAL
              FROM EMP
              GROUP BY DEPTNO) E2
WHERE E1.SAL = E2.MINSAL;

-- 48. 담당업무가 ANALYST 인 사원보다 급여가 적으면서 업무가 ANALYST가 아닌 사원들을 표시
-- (사원번호, 이름, 담당 업무, 급여)하시오.

SELECT EMPNO, ENAME, JOB, SAL
FROM EMP
WHERE SAL < ALL (SELECT SAL
                 FROM EMP
                 WHERE JOB = 'ANALYST')
      AND JOB != 'ANALYST'
ORDER BY SAL;

-- 49. 부하직원이 없는 사원의 이름을 표시하시오.

-- 풀이:
-- 내 EMPNO가 누군가의 MGR이면, 내가 상사인 거고
-- 내 EMPNO가 아무의 MGR도 아니면 부하직원이 없는 것
SELECT ENAME
FROM EMP E
WHERE NOT EMPNO IN (SELECT MGR
                    FROM EMP M
                    WHERE E.EMPNO = M.MGR);

-- NOT EXISTS 사용 가능
SELECT ENAME
FROM EMP E
WHERE NOT EXISTS (SELECT *
                  FROM EMP M
                  WHERE E.EMPNO = M.MGR);

-- 50. 부하직원이 있는 사원의 이름을 표시하시오.

SELECT ENAME
FROM EMP E
WHERE EMPNO IN (SELECT MGR
                FROM EMP M
                WHERE E.EMPNO = M.MGR);
                
-- 마찬가지로 EXISTS 사용가능
SELECT ENAME
FROM EMP E
WHERE EXISTS (SELECT *
              FROM EMP M
              WHERE E.EMPNO = M.MGR);
​
-- 51. BLAKE와 동일한 부서에 속한 사원의 이름과 입사일을 표시하는 질의를 작성하시오.(단 BLAKE는 제외)

SELECT ENAME, HIREDATE
FROM EMP
WHERE (DEPTNO = (SELECT DEPTNO
                 FROM EMP
                 WHERE ENAME = 'BLAKE'))
      AND ENAME != 'BLAKE';
​
-- 52. 급여가 평균 급여보다 많은 사원들의 사원 번호와 이름을 표시하되 
-- 결과를 급여에 대해서 오름차순으로 정렬하시오.

SELECT EMPNO, ENAME
FROM EMP
WHERE SAL > (SELECT AVG(SAL)
             FROM EMP)
ORDER BY SAL;
​
-- 53. 이름에 K가 포함된 사원과 같은 부서에서 일하는 사원의 사원 번호와 이름을 표시하시오.

SELECT EMPNO, ENAME
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO
                 FROM EMP
                 WHERE ENAME LIKE '%K%');
                
-- 54. 부서위치가 DALLAS인 사원의 이름과 부서번호 및 담당업무를 표시하시오.

-- NATURAL JOIN으로 풀이(더 간단함)
SELECT ENAME, DEPTNO, JOB
FROM EMP NATURAL JOIN DEPT
WHERE LOC = 'DALLAS';

-- SUB QUERY를 이용하여 풀이
SELECT ENAME, DEPTNO, JOB
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO
                FROM DEPT
                WHERE LOC = 'DALLAS');

-- 55. KING에게 보고하는 사원의 이름과 급여를 표시하시오.

-- 풀이:
-- 자신의 MGR이 KING의 EMPNO와 같은 사람을 찾으면 됨
SELECT ENAME, SAL
FROM EMP
WHERE MGR = (SELECT EMPNO
             FROM EMP
             WHERE ENAME = 'KING');

-- 56. RESEARCH 부서의 사원에 대한 부서번호, 사원이름 및 담당 업무를 표시하시오.

-- NATURAL JOIN으로 풀이(더 간단함)
SELECT DEPTNO, ENAME, JOB
FROM EMP NATURAL JOIN DEPT
WHERE DNAME = 'RESEARCH';
​
-- SUB QUERY를 이용하여 풀이
SELECT DEPTNO, ENAME, JOB
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO
                FROM DEPT
                WHERE DNAME = 'RESEARCH');

-- 57. 평균 월급보다 많은 급여를 받고
-- 이름에 M이 포함된 사원과 같은 부서에서 근무하는 사원의 
-- 사원 번호, 이름, 급여를 표시하시오.

SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL > (SELECT AVG(SAL)
             FROM EMP) AND
      DEPTNO IN (SELECT DEPTNO
                 FROM EMP
                 WHERE ENAME LIKE '%M%');

-- 58. 평균급여가 가장 적은 업무를 찾으시오. 
                   
-- 풀이: 46번 문제와 같음
SELECT JOB, AVG(SAL)
FROM EMP
GROUP BY JOB
HAVING AVG(SAL) = (SELECT MIN(AVG(SAL))
                   FROM EMP
                   GROUP BY JOB);

-- 59. 담당업무가 MANAGER 인 사원이 소속된 부서와 동일한 부서의 사원을 표시하시오.

SELECT ENAME
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO
                 FROM EMP
                 WHERE JOB = 'MANAGER');
