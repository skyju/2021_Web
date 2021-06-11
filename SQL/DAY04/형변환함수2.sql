-- 21-06-11
-- DECODE함수 : 분기를 위해 사용 > 자바의 SWITCH CASE와 유사
-- DECODE(컬럼, 조건1 값, 결과1,
            -- 조건2 값, 결과2, ...)

-- EMP 테이블에서 부서번호에 맞는 부서 이름 출력

SELECT e.ename, d.deptno, d.dname
FROM EMP e, DEPT d
WHERE e.deptno = d.deptno
order by d.dname;

-- 위처럼 쓰는게 맞지만, 아래처럼 쓸 수도 있다. (그러나 데이터가 수정될 때마다 수정해야 함)

select ename, deptno,
    decode(deptno,  10, 'ACCOUNTINGS',
                    20, 'RESEARCH',
                    30, 'SALES',
                    40, 'OPERATIONS'
    ) as dname
from emp
order by dname;



-- 직급에 따라 급여를 인상하는 방법
-- 직급이 'ANALYST'인 사원은 5%,
--      'SALESMAN'인 사원은 10%,
--      'MANAGER'인 사원은 15%,
--      'CLERK'인 사원은 20% 인상한다.

select ename, sal, 
       decode(job, 'ANALYST', sal*1.05,
                    'SALESMAN', sal*1.1,
                    'MANAGER', sal*1.15,
                    'CLERK', sal*1.2) as upsal
from emp;
