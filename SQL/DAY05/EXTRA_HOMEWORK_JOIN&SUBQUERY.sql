-- 1 마당서점의 고객이 요구하는 다음 질문에 대해 SQL문을 작성하시오.

-- (5) 박지성이구매한도서의출판사수

    SELECT COUNT(DISTINCT PUBLISHER)
    FROM ORDERS NATURAL JOIN BOOK
    WHERE CUSTID = (SELECT CUSTID
                    FROM CUSTOMER
                    WHERE NAME = '박지성');

-- (6) 박지성이 구매한 도서의 이름, 가격, 정가와 판매 가격의 차이
    
    -- NATURAL JOIN 활용
    SELECT BOOKNAME, SALEPRICE, PRICE-SALEPRICE AS GAPPRICE
    FROM ORDERS NATURAL JOIN BOOK
    WHERE CUSTID = (SELECT CUSTID
                    FROM CUSTOMER
                    WHERE NAME = '박지성');

-- (7) 박지성이 구매하지 않은 도서의 이름

    SELECT BOOKNAME
    FROM BOOK MINUS (SELECT BOOKNAME 
                     FROM BOOK 
                     WHERE BOOKID IN (SELECT BOOKID
                                      FROM ORDERS 
                                      WHERE CUSTID = (SELECT CUSTID 
                                                      FROM CUSTOMER 
                                                      WHERE NAME = '박지성')));

-- 2 마당서점의 운영자와 경영자가 요구하는 다음 질문에 대해 SQL 문을 작성하시오.

-- (8) 주문하지 않은 고객의 이름(부속질의사용)

    -- 부속질의: WHERE 절에 작성하는 것
    SELECT NAME
    FROM CUSTOMER C
    WHERE NOT EXISTS (SELECT *
                      FROM ORDERS O
                      WHERE C.CUSTID = O.CUSTID);

-- (9) 주문금액의 총액과 주문의 평균금액
    
    SELECT SUM(SALEPRICE) AS TOTALSALE, AVG(SALEPRICE) AS AVGSALE
    FROM ORDERS;

-- (10) 고객의 이름과 고객 별 구매액
    
    SELECT NAME, SUM(SALEPRICE) AS PAY
    FROM CUSTOMER NATURAL JOIN ORDERS
    GROUP BY NAME;
    
-- (11) 고객의 이름과 고객이 구매한 도서 목록

    SELECT NAME, BOOKNAME
    FROM CUSTOMER NATURAL JOIN BOOK NATURAL JOIN ORDERS;

-- (12) 도서의 가격(Book 테이블)과 판매가격(Orders 테이블)의 차이가 가장 많은 주문
    
    SELECT * 
    FROM BOOK NATURAL JOIN ORDERS
    WHERE PRICE - SALEPRICE = (SELECT MAX(PRICE-SALEPRICE)
                              FROM BOOK NATURAL JOIN ORDERS);

-- (13) 도서의 판매액 평균보다 자신의 구매액 평균이 더 높은 고객의 이름
                       
    SELECT NAME
    FROM CUSTOMER NATURAL JOIN ORDERS
    GROUP BY CUSTID
    HAVING AVG(SALEPRICE) > (SELECT AVG(SALEPRICE)
                             FROM ORDERS);
    
-- 3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.

-- (1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
        
    SELECT NAME
    FROM CUSTOMER NATURAL JOIN BOOK NATURAL JOIN ORDERS
    WHERE PUBLISHER IN (SELECT PUBLISHER
                        FROM BOOK NATURAL JOIN CUSTOMER NATURAL JOIN ORDERS
                        WHERE NAME = '박지성')
          AND NAME != '박지성';
    
-- (2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름

    SELECT NAME
    FROM CUSTOMER NATURAL JOIN BOOK NATURAL JOIN ORDERS
    GROUP BY NAME
    HAVING COUNT(DISTINCT PUBLISHER) >= 2;
    
