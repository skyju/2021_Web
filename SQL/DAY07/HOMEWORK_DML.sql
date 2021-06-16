--06/16 DML 과제

-- 1. PHONEINFO_BASIC 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
  
    -- 테이블 정보 먼저 확인  
    DESC PHONEINFO_BASIC;
    
    -- 입력된 값 확인하기
    SELECT * FROM PHONEINFO_BASIC;

    -- (1) 튜플 삽입: 모든 ATTRIBUTE에 값 넣기
    INSERT INTO PHONEINFO_BASIC 
    VALUES(1,'JOHN', '010-1234-1234', 'JOHN@GMAIL.COM', 'SEOUL', DEFAULT);
    INSERT INTO PHONEINFO_BASIC
    VALUES(1,'MATT', '010-1111-1111', 'MATT@GMAIL.COM', 'INCHEON', DEFAULT);
    
    -- (2) 튜플 삽입: 특정 ATTRIBUTE에 값 넣기
    INSERT INTO PHONEINFO_BASIC (IDX, FR_NAME, FR_PHONENUMBER, FR_EMAIL) 
    VALUES(3, 'SCOTT', '010-1234-4567', 'SCOTT@NAVER.COM');
    
    -- (3) 튜플 업데이트: (2)에서 넣지 않은 주소와 등록시간 넣어보기
    UPDATE PHONEINFO_BASIC 
    SET FR_ADDRESS = 'PUSAN', FR_REGDATE = DEFAULT 
    WHERE FR_NAME = 'SCOTT';
    
    -- (4) 튜플 업데이트: SCOTT의 주소를 JOHN의 주소와 같게 변경하기
    UPDATE PHONEINFO_BASIC
    SET FR_ADDRESS = (SELECT FR_ADDRESS FROM PHONEINFO_BASIC WHERE FR_NAME = 'JOHN')
    WHERE FR_NAME = 'SCOTT';
    
    -- (5) 튜플 삭제: 모든 튜플 삭제하기
    DELETE FROM PHONEINFO_BASIC;
    
    -- (6) 튜플 삭제: 특정 튜플 삭제하기
    DELETE FROM PHONEINFO_BASIC WHERE FR_NAME = 'SCOTT';
    
-- 2. PHONEINFO_UNIV 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL

    -- 테이블 정보 먼저 확인  
    DESC PHONEINFO_UNIV;
    
    -- 입력된 값 확인하기
    SELECT * 
    FROM PHONEINFO_UNIV;
    
    -- 모든 친구 정보 확인하기
    SELECT * 
    FROM PHONEINFO_BASIC B FULL OUTER JOIN PHONEINFO_UNIV U
    ON B.IDX = U.FR_REF;

    -- (1) 튜플 삽입: 모든 ATTRIBUTE에 값 넣기
    INSERT INTO PHONEINFO_UNIV 
    VALUES(1, 'MATH', 3, 1);
    
    -- (2) 튜플 삽입: 특정 ATTRIBUTE에 값 넣기 
    -- FR_U_MAJOR와 FR_U_YEAR 기입하지 않음
    INSERT INTO PHONEINFO_UNIV (IDX, FR_REF) 
    VALUES(2, 2);
    -- MAJOR 는 DEFAULT값 N으로, YEAR는 DEFAULT값 1로 들어감
    
    -- (3) 튜플 업데이트: IDX 2번에 (2)에서 넣지 않은 전공넣어보기
    UPDATE PHONEINFO_UNIV 
    SET FR_U_MAJOR = 'KOREAN'
    WHERE IDX = 2;
    
    -- (4) 튜플 업데이트: IDX 2번의 학년을 IDX 1번의 학년과 같게 변경하기
    UPDATE PHONEINFO_UNIV
    SET FR_U_YEAR = (SELECT FR_U_YEAR FROM PHONEINFO_UNIV WHERE IDX = 1)
    WHERE IDX = 2;
    
    -- (5) 튜플 삭제: 모든 튜플 삭제하기
    DELETE FROM PHONEINFO_UNIV;
    
    -- (6) 튜플 삭제: 특정 튜플 삭제하기
    DELETE FROM PHONEINFO_UNIV WHERE FR_U_MAJOR = 'MATH';

-- 3. PHONEINFO_COM 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL

    -- 테이블 정보 먼저 확인  
    DESC PHONEINFO_COM;
    
    -- 입력된 값 확인하기
    SELECT * 
    FROM PHONEINFO_COM;
    
    -- 모든 친구 정보 확인하기
    SELECT * 
    FROM PHONEINFO_BASIC B 
    FULL OUTER JOIN PHONEINFO_UNIV U
    ON B.IDX = U.FR_REF
    FULL OUTER JOIN PHONEINFO_COM C
    ON B.IDX = C.FR_REF;
    
    -- 또는 아래처럼 작성할 수 있음
    SELECT * 
    FROM PHONEINFO_BASIC B, PHONEINFO_UNIV U, PHONEINFO_COM C
    WHERE B.IDX = U.FR_REF(+) AND B.IDX = C.FR_REF(+);

    -- (1) 튜플 삽입: 모든 ATTRIBUTE에 값 넣기
    INSERT INTO PHONEINFO_COM 
    VALUES(1, 'A_COMPANY', 1);
    
    -- (2) 튜플 삽입: 특정 ATTRIBUTE에 값 넣기 
    -- 이 테이블은, 모든 ATTRIBUTE가 NOT NULL이기 때문에, 모든 ATTRIBUTE를 기입해야함
    INSERT INTO PHONEINFO_COM (IDX, FR_C_COMPANY, FR_REF) 
    VALUES(2, 'B_COMPANY', 3);
    
    -- (+) 이처럼 기본키 값만 다르면 외래키는 중복해서 들어갈 수 있기 때문에 
    -- 이상한 데이터가 들어갈 수 있는 가능성이 있어서, 기본키값을 여러 값의 복합키로 만들어 사용할 수 있음 
    INSERT INTO PHONEINFO_COM VALUES (3, 'C_COMPANY', 3);
    -- 외래키 값이 똑같은, SCOTT에대한 값이지만 데이터가 또 들어감
    
    -- (3) 튜플 업데이트: IDX 1번의 회사를 C_COMPANY로 변경하기
    UPDATE PHONEINFO_COM 
    SET FR_C_COMPANY = 'C_COMPANY'
    WHERE IDX = 1;
    
    -- (4) 튜플 업데이트: IDX 2번의 회사를 IDX 1번의 회사와 같게 변경하기
    UPDATE PHONEINFO_COM
    SET FR_C_COMPANY = (SELECT FR_C_COMPANY FROM PHONEINFO_COM WHERE IDX = 1)
    WHERE IDX = 2;
    
    -- (5) 튜플 삭제: 모든 튜플 삭제하기
    DELETE FROM PHONEINFO_COM;
    
    -- (6) 튜플 삭제: 특정 튜플 삭제하기
    DELETE FROM PHONEINFO_COM WHERE IDX = 1;
    
    
    ROLLBACK;
    
