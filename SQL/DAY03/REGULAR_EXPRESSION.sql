
-- 정규 표현식 (REGULAR EXPRESSION - REGEXP_)
-- https://ko.wikipedia.org/wiki/%EC%A0%95%EA%B7%9C_%ED%91%9C%ED%98%84%EC%8B%9D 참고

-- [:digit] 숫자의 묶음을 나타내는 숫자 클래스 0~9, -- [0-9] = [[:digit:]]
-- [:alpha] 알파벳을 뜻하는 문자 클래스
-- [:upper] 대문자
-- [:lower] 소문자
-- [:alnum] 대소문자 구분하지 않고, 영숫자 \w, -- [\w] = [[:alnum:]] 

-- 유의할 점: or을 대체하는 |는 되지만, &는 정규표현식에 없음



-- Oracle의 정규 표현식 사용 법  
-- (1) REGEXP_LIKE(문자열, 패턴, ...) : LIKE과 유사, 정규식을 사용할 수 있는 LIKE
-- (2) REGEXP_COUNT: 패턴에 일치하는 문자열 갯수 카운트 -- 6/10
-- (3) REGEXP_INSTR: 문자열 내에서 패턴에 일치하는 시작 위치를 찾아줌
-- (4) REGEXP_SUBSTR: 문자열 내에서 패턴에 일치하는 문자열을 추출
-- (5) REGEXP_REPLACE: 문자열 내에서 패턴에 일치하는 문자열을 다른 문자열로 대체



-- (1) REGEXP_LIKE(source_char, pattern [, match_param])

-- 특정문자로 시작하는 문자열 찾기
SELECT ENAME
FROM EMP
WHERE REGEXP_LIKE(ENAME, '^A');

SELECT ENAME
FROM EMP
WHERE REGEXP_LIKE(ENAME, '^C.*');

SELECT ENAME
FROM EMP
WHERE ENAME LIKE 'A%';

-- 특정문자로 끝나는 문자열 찾기
SELECT ENAME
FROM EMP
WHERE REGEXP_LIKE(ENAME, 'N$');

SELECT ENAME
FROM EMP
WHERE ENAME LIKE '%N';

-- 특정문자가 들어있는 문자열 찾기 
-- (대소문자 구분은 ,'C'): case sensitive
-- (대소문자 무시는 ,'i'): ignore
SELECT ENAME
FROM EMP
WHERE REGEXP_LIKE(ENAME, 'A|B|C');

SELECT ENAME
FROM EMP
WHERE REGEXP_LIKE(ENAME, 'a|b|c', 'i'); -- 대소문자 무시는 정규식 사용해야 가능

-- 특정문자로 시작하고, 한문자 건너 띄고, 다음문자가 특정문자인 문자열 찾기
SELECT ENAME
FROM EMP
WHERE REGEXP_LIKE(ENAME, '^[B-Z].I');

-- 특정문자가 N번 반복되는 문자열 찾기
SELECT ENAME
FROM EMP
WHERE REGEXP_LIKE(ENAME, 'L{2}'); --  중괄호 써야 함 주의

-- 패턴이 반복되는 경우 \1을 여러번 사용하여 처리
SELECT ENAME
FROM EMP
WHERE REGEXP_LIKE(ENAME, '(LE)\1');

-- 전화번호 포맷이 999.999.999와 일치하는 데이터 찾기
SELECT PHONE_NUMBER
FROM EMPLOYEES
WHERE REGEXP_LIKE(PHONE_NUMBER, '([[:digit:]]{3})\.([0-9]{3})\.([0-9]{4})');





-- (2) REGEXP_COUNT: 패턴에 일치하는 문자열 갯수 카운트
                    -- 기존의 COUNT()함수는 ROW갯수를 세는 함수고, 
                    -- 정규표현식 COUNT는 하나의 문자열 내에서 반복문자열의 갯수를 셈
                    -- 예를들어 긍정적 표현이 몇개 있는지 COUNT
                    
-- REGEXP_COUNT(soure_char, pattern [,position [, match_param]])

-- 전화번호 포맷이 999.999.999와 일치하는 데이터 찾기
SELECT PHONE_NUMBER
FROM EMPLOYEES
WHERE REGEXP_COUNT(PHONE_NUMBER, '([[:digit:]]{3})\.([0-9]{3})\.([0-9]{4})')=1;

-- 
