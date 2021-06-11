-- 1. 사원의 수 - count
-- 2. 사원의 급여 총합 - sum
-- 3. 급여 평균 - avg
-- 4. 최대 급여 - max
-- 5. 최소 급여 - min
-- 6. 그룹함수는 null값을 제외하고 연산한다.

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



