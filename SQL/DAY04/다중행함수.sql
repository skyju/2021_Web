-- 1. 사원의 수 - count
-- 2. 사원의 급여 총합 - sum
-- 3. 급여 평균 - avg
-- 4. 최대 급여 - max
-- 5. 최소 급여 - min
-- 6. 그룹함수는 null값을 제외하고 연산한다.
-- 7. group by
-- 8. group by & having

-- 결과가 단일행이므로, 앞에 일반 컬럼을 같이 고르지 못함

-- 1. 사원의 수
select count(*) as numberOfemp
from emp;

-- 2. 사원 급여의 총합
select to_char(sum(sal), '$9,999,999') as sumOfsal
from emp;

-- 3. 사원 급여의 평균
select to_char(round(avg(sal), 2), '$9,999,999.99') as avgOfsal
from emp;

-- 4. 최대 급여
select to_char(max(sal), '$9,999,999') as maxOfsal
from emp;

-- 5. 최소 급여
select to_char(min(sal), '$9,999,999') as minOfsal
from emp;

-- 6. null값을 배제하고 계산
select sum(comm) as "커미션의 총합",
       avg(comm) as "커미션의 평균"
from emp;



-- 7.
-- 특정 컬럼을 이용해서 그룹핑하기 > group by
-- select 그룹핑할 기준의 컬럼, 그룹함수 
-- from table 
-- where 
-- group by 그룹핑할 기준의 칼럼


-- 부서별 사원 수
select deptno, count(*)
from emp
group by deptno;

-- 부서별 연봉의 합계, 평균, 최대, 최소
select deptno, count(*) as "부서인원", sum(sal), trunc(avg(sal)), max(sal), min(sal)
from emp
group by deptno;


-- distict와 같은
select distinct job
from emp;

select job
from emp
group by job;

-- 부서 별로 사원 수와 커미션을 받는 사원들의 수를 계산하여 출력하라
select deptno, count(*), count(comm)
from emp
group by deptno;


select count(*), count(comm)
from emp
where deptno = 10;


-- 8. 
-- select 그룹핑할 기준의 컬럼, 그룹함수 
-- from table 
-- where 
-- group by 그룹핑할 기준의 칼럼
-- having 그룹함수 (=, !=, >, <, <=, >=)

select deptno, avg(sal)
from emp
group by deptno
having avg(sal) >= 2000;

-- 부서별 급여의 최대값과 최소값을 구하되,
-- 최대 급여가 2900이상인 부서만 출력하라.
select deptno, max(sal), min(sal)
from emp
group by deptno
having max(sal) >= 2900
order by deptno;

