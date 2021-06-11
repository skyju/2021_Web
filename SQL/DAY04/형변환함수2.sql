-- 21-06-11
-- DECODE함수 : 분기를 위해 사용 > 자바의 SWITCH CASE와 유사
-- DECODE(컬럼, 조건1 값, 결과1,
            -- 조건2 값, 결과2, ...)

SELECT ENAME, DEPTNO, JOB, SAL, UPSAL
        DECODE