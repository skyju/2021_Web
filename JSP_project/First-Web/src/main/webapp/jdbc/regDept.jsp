<%@page import="dept.domain.Dept"%>
<%@page import="dept.dao.DeptDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
<%
	// 1. 사용자가 입력한 데이터를 받고 -> 처리 -> 결과를 속성에 저장 -> view
	// 입력 데이터의 한글 처리 필수(post 방식이잖음)
	request.setCharacterEncoding("UTF-8");

	String deptno = request.getParameter("deptno");
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
	
	int resultCnt = 0;
	
	Connection con = null;
	DeptDao dao = DeptDao.getInstance();
	
	try{
		con = ConnectionProvider.getConnection();
		resultCnt = dao.insertDept(con, new Dept(Integer.parseInt(deptno), dname, loc));
	
	} catch(Exception e){
		e.printStackTrace();
	}

	// 3. dept_list.jsp 이동
	//response.sendRedirect("dept_list.jsp");
	if(resultCnt>0){
		%>
<script>
	alert('등록되었습니다.');
	location.href = "dept_list.jsp";
</script>
<%
	} else {
		%>
<script>
	alert('오류 발생으로 등록되지 않았습니다. \n 입력페이지로 다시 돌아갑니다.');
	//location.href = "dept_regForm.jsp";
	//이전페이지로 돌아가게 처리하는 방법
	window.history.go(-1);
</script>
<%
	}
	
%>
</head>
<body>

</body>
</html>