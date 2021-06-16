-- 06/16 
-- <View>

-- 자주 사용되는 30번 부서에 소속된 사원들의 사번과 이름과 부서번호를
-- 출력하기 위한 SELECT문을 하나의 뷰로 정의해 봅시다.

CREATE OR REPLACE VIEW EMP_VIEW_30
AS
SELECT EMPNO, ENAME, DEPTNO
FROM EMP
WHERE DEPTNO = 30;

SELECT * FROM EMP_VIEW_30;