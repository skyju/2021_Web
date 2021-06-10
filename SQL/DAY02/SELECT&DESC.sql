-- 2021.06.09, 06.10
-- SQL Basic: SELECT 

-- 1) TAB
    --  계정 HR이 권한을 가진 테이블 객체 리스트
    SELECT * FROM TAB;


-- 2) DESC: DESCIRBE
    -- 테이블의 정보를 검색 : 컬럼의 이름, NULL허용 유무, 타입, 사이즈
    DESC DEPT;


-- 3) SELECT 
    -- select {컬럼명,...} from 테이블 이름 where 조건 -> 원하는 행, 열을 표현 -> 결과 : 테이블

    --(1). 덧셈연산자사용하기
        select ename, sal, sal+300 as addsal
        from emp;


    --(2). ORDER BY 컬럼 [ASC|DESC] 
        -- 결과 행의 정렬
        -- ASC: 오름차순: DEFAULT라서 명기 안함
        select ename, sal, sal*12+100 as income
        from emp
        order by income desc;
        
    ​    -- DESC: 내림차순:
        select ename, sal
        from emp
        where sal > 2000
        order by sal desc;
        
        -- 급여를 기준으로 내림차순 정렬을 하고, 
        -- 급여가 같을 경우 사원 이름을 기준으로 오름차순 정렬
        SELECT *
        FROM EMP
        ORDER BY SAL DESC, ENAME ASC;


​    --(3). 비교연산자 
        -- 주의사항: 문자열 비교 시 ''사용, (자바와 달리 문자열 검색에 SINGLE QUOTE)
        
        -- 사원번호가 7788인 사원의 이름과 부서번호를 출력하시오.
        select ename, deptno
        from emp
        where empno=7788;
    
        -- 이름이 'SCOTT'인 사원을 출력
        select *
        from emp
        where ename = 'SCOTT';
    
        -- (#주의#)비교 연산은 정확하게 비교해야 함
        -- 예를 들어 소문자로 검색하면 인식 못함
        select *
        from emp
        where ename = 'scott';
    
        -- 날짜 타입의 데이터 비교시에도 작은 따옴표를 사용해야 함
        select *
        from emp
        where hiredate = '96/11/17';

​
    --(4). 범위연산자
        -- 1) 논리연산자: <=, <, >, >=
        -- 2) BETWEEN A AND B : A 이상 B 이하
        
        -- 2000이상 3000 이하의 급여를 받는 직원 리스트
        
        -- BETWEEN을 사용한다면
        SELECT ENAME, JOB, SAL, SAL*1.1 AS ADDSAL
        FROM EMP
        WHERE SAL BETWEEN 2000 AND 3000;
        
        -- 논리연산자를 사용한다면
        select ename, sal 
        from emp
        where not ( sal>=2000 and sal<=3000 );

        -- 날짜에도 적용해서 기간 검색을 할 수 있음
        SELECT *
        FROM EMP
        WHERE HIREDATE BETWEEN '81/01/01' AND '81/12/31';


    --(5). 논리연산자: and, or, not
    
        -- AND 연산
        -- 10번 부서의 관리자를 찾아 출력
        select *
        from emp
        where deptno = 10 and job = 'MANAGER';
    
        -- OR 연산
        -- 10번 부서의 직원들과 관리자들의 리스트를 출력
        SELECT *
        FROM EMP
        WHERE DEPTNO = 10 OR JOB = 'MANAGER'
        ORDER BY DEPTNO ASC;
    
        -- NOT 연산
        -- 10번 부서의 직원을 제외한 나머지 직원들 출력 (20,30)
        SELECT *
        FROM EMP
        WHERE NOT DEPTNO = 10
        ORDER BY DEPTNO ASC;
    
    
    --(6). IN연산자 : 여러개의 OR 연산자 사용시 대체 가능
    
        -- 커미션이 300 또는 500 또는 1400
        SELECT *
        FROM EMP
        WHERE COMM IN(300,500,1400);
    
        -- 부서번호가 20 및 30에 속한 사원의  -> 행의 조건
        -- 이름과 부서번호를 출력, 이름을 기준으로 내림차순
        select ename, deptno
        from emp
        --where deptno=20 or deptno=30
        where deptno in (20, 30)
        order by ename desc;
    
    
    --(7). LIKE연산자
        -- %와일드카드, _문자 하나 와일드카드(자리수)
        
        -- ENAME LIKE 'F%' -> F로 시작하는 문자열
        -- ENAME LIKE '%F' -> F로 끝나는 문자열
        -- ENAME LIKE '%F%' -> F를 포함하는 문자열
        -- 예를들어 'java' 단어를 포함하는 지 > title like '%java%'
        
        -- 1981년도에 입사한 사원의 이름과 입사일을 출력하시오.
        select ename, hiredate
        from emp
        where hiredate like '81%';

        -- F로 시작하는 이름을 가진 사원 검색
        select *
        from emp
        where ename like 'F%';

        -- 중간에 LA가 들어가는 이름을 가진 사원 검색
        SELECT *
        FROM EMP
        WHERE ENAME LIKE '%LA%';

        -- 자리수 패턴: 컬럼의 값이 자리수가 정해져 있고 값이 패턴이 있는 경우
        -- 사원의 이름의 두 번째 문자에 A를 포함하는 사원의 리스트
        SELECT *
        FROM EMP
        WHERE ENAME LIKE '_A%';
​
        --이름에 A와 E를 모두 포함하고 있는 사원의 이름을 표시하시오.
        select ename
        from emp
        where ename like '%A%' and ename like '%E%';
    ​

    --(8) IS NULL 과 IS NOT NULL 연산자
        -- NULL값을 확인하는 연산자
        -- null : 있는것도 아니고 없는것도 아닌 데이터 연산의 결과도 null , 비교연산 불가, 산술연산 불가
        -- 따라서 = NULL과 같이 비교할 수 없음
        
        -- 커미션이 등록되어 있지 않은 사원의 리스트(0은 안보임)
        SELECT *
        FROM EMP
        WHERE COMM IS NULL;
        
        -- 커미션이 등록되어 있는 사원의 리스트(0도 보임)
        SELECT *
        FROM EMP
        WHERE COMM IS NOT NULL
        ORDER BY COMM;

        -- 커미션을 받을 수 있는 자격이 되는 
        -- 사원의 이름, 급여, 커미션을 출력하되 
        -- 급여 및 커미션을 기준으로 내림차순 정렬하여 표시하시오.
        select ename, sal, comm
        from emp
        where comm is not null and comm>0
        order by sal desc, comm desc;


    -- (+) 응용문제
    -- 담당업무가 CLERK, 또는 SALESMAN이면서  -- (or) and
    -- 급여가 $1600, $950 또는 $1300이 아닌 사원의  -- not (or) 
    -- 이름, 담당업무, 급여를 출력하시오.
    select ename, job, sal
    from emp
    where ( job in ('CLERK', 'SALESMAN') ) and ( sal not in(1600, 950, 1300) );
