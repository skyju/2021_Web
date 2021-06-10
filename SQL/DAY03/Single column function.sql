-- 21/06/10

-- function : (1) single column function(단일 행 함수)
                -- : 하나의 행이 포함하는 특정 컬럼의 값 하나를 처리하고 반환
            --(2) multiple column function(다중 행 함수)
                -- : 여러 행의 특정 컬럼값들을 대상으로 연산하고 반환 -> advanced : grouping 

                
-- 숫자 단일행 함수

-- ABS : 절대값 
SELECT ABS(10), ABS(-10)
FROM DUAL; --연습하기 위한 테이블

-- FLOOR: 소숫점 절산
SELECT FLOOR(3.14)
FROM DUAL;

-- ROUND: 반올림, 반내림
SELECT ROUND(3.14159, 2) -- 소수점 2째 자리까지 출력되도록 반올림
FROM DUAL;

SELECT ROUND(15.193, -2) -- -는 양수(정수)방향
FROM DUAL;

-- TRUNC: 소수점 아래 안남길거면 FLOOR와 같음
SELECT TRUNC(14.222,2) -- ROUND와 다르게 반올림하지않고 2째 자리 까지 남기고 절사
FROM DUAL;

-- MOD: 나머지값
SELECT MOD(11,4)
FROM DUAL;

SELECT ENAME, SAL
FROM EMP
WHERE MOD(SAL,2) =1;  -- 짝 홀 판단



-- 문자 단일행 함수

-- CONCAT(문자, 문자) > '문자'||'문자'
SELECT CONCAT('ABC','DEF')
FROM DUAL;

SELECT 'ABC'||'DEF'
FROM DUAL;

-- SUBSTR: 문자열의 일부 추출하기
-- SUBSTR(원본문자열, 시작인덱스, 길이)
SELECT SUBSTR('APPLE',1,3)
FROM DUAL;

-- 방향을 거꾸로
SELECT SUBSTR('APPLE',-3) -- 뒤에서 3개 추출
FROM DUAL;

-- REPLACE: 특정 문자열(패턴)을 다른 문자열(패턴)으로 변경하기
SELECT REPLACE('APPLE','P','X') -- P를 찾아 X로 변경
FROM DUAL;

SELECT REPLACE('JACK AND JUE', 'J', '**') -- 앞의 글자 익명처리하기 
FROM DUAL; 


-- 날짜 단일 행 함수

-- SYSDATE : 오늘 날짜 가져오기
SELECT SYSDATE
FROM DUAL;

