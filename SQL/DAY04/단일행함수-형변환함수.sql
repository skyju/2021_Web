-- 2021.06.11

-- 형변환 함수

-- 날짜 -> 문자 : to_char(날짜 데이터, '패턴')
-- 숫자 -> 문자 : to_char(숫자, '패턴')

select sysdate, to_char(sysdate, 'YYYY.MM.DD. DAY HH24:MM:SS PM')
from dual;

select ename, hiredate, to_char(hiredate, 'YYYY.MM.DD.')
from emp;

select orderid, orderdate, to_char(orderdate, 'YYYY.MM.DD')
from orders;

select to_char(123456, '0,000,000,000'), to_char(123456, 'L9,999,999,999')
from dual;

select ename, to_char(sal, '$999,999,999')
from emp;

select empno, ename, to_char(sal*1100, 'L999,999,999')
from emp;

-- 문자 -> 숫자 : to_number(문자 데이터, '패턴')
-- 문자 -> 날짜 : to_date(문자 데이터, '패턴')

-- '1,000,000' + 100000 ?

select to_number('1,000,000', '9999999999'),
        to_number('1,000,000', '9,999,999') + 100000
from dual;

-- 날짜끼리 계산하기
select to_date('2012.05.17', 'YYYY.MM.DD'), sysdate-to_date('2012.05.17', 'YYYY.MM.DD')
from dual;

-- 만나이 계산하기
select to_date('2012.05.17', 'YYYY.MM.DD'),
        trunc((sysdate-to_date('2012.05.17', 'YYYY.MM.DD'))/365)
from dual;

