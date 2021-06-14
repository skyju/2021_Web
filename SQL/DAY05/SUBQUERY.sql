-- 06.14 서브쿼리

-- 1) SELECT 절에 : SCALAR SUBQUERY

-- 사원이름과 사원이름에 맞는 부서명 출력하기
SELECT ENAME, (SELECT DNAME 
               FROM DEPT 
               WHERE EMP.DEPTNO = DEPT.DEPTNO) AS DNAME
FROM EMP;

-- 주문번호와 그에 맞는 고객이름 출력하기
SELECT O.ORDERID, (SELECT C.NAME
                  FROM CUSTOMER C
                  WHERE O.CUSTID = C.CUSTID) AS NAME
FROM ORDERS O;

-- 마당 서점의 고객 별 판매액을 출력
SELECT C.CUSTID, C.NAME, SUM(O.SALEPRICE) AS TOTALPAY
FROM ORDERS O, CUSTOMER C
WHERE O.CUSTID = C.CUSTID
GROUP BY C.CUSTID, C.NAME;

-- 이 문제를 서브쿼리, 스칼리 부속질의로
SELECT CUSTID, (SELECT NAME
                FROM CUSTOMER
                WHERE CUSTOMER.CUSTID = ORDERS.CUSTID) AS NAME,
                SUM(ORDERS.SALEPRICE) AS TOTALPAY
FROM ORDERS
GROUP BY CUSTID;





-- 2) FROM 절에 : INLINE VIEW(TABLE SUBQUERY)

-- 고객 번호가 2 이하(CUSTOMER 테이블)
-- 인 고객의 판매액을 보이시오(ORDERS 테이블) -- 결과는 고객이름과 고객 별 판매액 출력
SELECT O.CUSTID, C.NAME, SUM(O.SALEPRICE)
FROM (SELECT * 
      FROM CUSTOMER 
      WHERE CUSTID <= 2) C, ORDERS O
WHERE C.CUSTID = O.CUSTID
GROUP BY O.CUSTID, C.NAME;




-- 3) WHERE 절에 : NESTED SUBQUERY(PREDICATE SUBQUERY) : 중첩질의
    -- 비교연산자를 이용할 때는 단일 행 단일 열의 결과를 갖는 부속 질의를 사용
    -- > , < , != ....
    
-- 평균 급여보다 더 많은 급여를 받는 사원 검색
SELECT *
FROM EMP
WHERE SAL > (SELECT AVG(SAL)
             FROM EMP)
ORDER BY SAL;

-- 평균 주문금액 이하의 주문에 대해서
-- 주문번호와 금액을 보이시오

SELECT ORDERID, BOOKID, SALEPRICE, BOOKNAME
FROM ORDERS NATURAL JOIN BOOK
WHERE SALEPRICE <= (SELECT AVG(SALEPRICE)
                   FROM ORDERS)
ORDER BY SALEPRICE;

-- 각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해 
-- 주문번호, 고객번호, 금액을 보이시오

SELECT *
FROM ORDERS O1
WHERE SALEPRICE > (SELECT AVG(SALEPRICE)
                   FROM ORDERS O2
                   WHERE O2.CUSTID = O1.CUSTID)
ORDER BY ORDERDATE;

-- 디버깅 위해 확인
SELECT * FROM ORDERS;
SELECT AVG(SALEPRICE) FROM ORDERS WHERE CUSTID=1;


-- 여기까지는 값과 값비교


-- 다중 행을 비교 : 다중행 연산자 사용
-- IN
-- ANY, SOME
-- ALL
-- EXISTS, NOT EXISTS

-- 3000이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원을 출력

SELECT EMPNO, ENAME, JOB, SAL, DEPTNO, DNAME
FROM EMP NATURAL JOIN DEPT
WHERE DEPTNO IN (SELECT DEPTNO
                 FROM EMP
                 WHERE SAL >= 3000)
ORDER BY DEPTNO;


-- 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.
SELECT SUM(SALEPRICE) AS TOTAL
FROM ORDERS
WHERE CUSTID IN(SELECT CUSTID
                FROM CUSTOMER
                WHERE REGEXP_LIKE(ADDRESS, '대한민국'));

-- 3번 고객이 주문한 도서의 최고 금액보다 
-- 더 비싼 도서를 구입한 주문의 주문번호와 금액을 구하시오.

SELECT ORDERID, SALEPRICE, NAME, CUSTID
FROM ORDERS NATURAL JOIN CUSTOMER
WHERE SALEPRICE > (SELECT MAX(SALEPRICE)
                   FROM ORDERS
                   WHERE CUSTID = 3);

SELECT ORDERID, SALEPRICE, NAME, CUSTID
FROM ORDERS NATURAL JOIN CUSTOMER
WHERE SALEPRICE > ALL (SELECT SALEPRICE
                       FROM ORDERS
                       WHERE CUSTID = 3);

-- 디버깅 위해 확인
SELECT *
FROM ORDERS
ORDER BY CUSTID;


-- 부서번호가 30번인 사원들의 급여 중 가장 작은 값(950)보다 많은 급여를 받는
-- 사원의 이름, 급여를 출력

SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE SAL> ANY (SELECT SAL
                FROM EMP
                WHERE DEPTNO = 30)
ORDER BY DEPTNO;

-- 디버깅 위해 확인
SELECT *
FROM EMP
ORDER BY DEPTNO;

-- EXISTS 연산자로 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 출력

SELECT SUM(SALEPRICE)
FROM ORDERS O
WHERE EXISTS (SELECT * 
              FROM CUSTOMER C 
              WHERE O.CUSTID = C.CUSTID 
                    AND C.ADDRESS LIKE '%대한민국%');

