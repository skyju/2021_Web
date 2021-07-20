<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
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
	// 1. 사용자가 입력한 데이터를 받고
	// 입력 데이터의 한글 처리 필수(post 방식이잖음)
	request.setCharacterEncoding("UTF-8");

	String deptno = request.getParameter("deptno");
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
	
	int resultCnt = 0;
	
	// 2. DB 처리 : INSERT
	//데이터 베이스 드라이버 로드
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		con = ConnectionProvider.getConnection();
	
		String sqlUpdate = "update dept set dname=?, loc=? where deptno=?";
		pstmt = con.prepareStatement(sqlUpdate);
	
		pstmt.setString(1, dname);
		pstmt.setString(2, loc);
		pstmt.setInt(3, Integer.parseInt(deptno));
	
		resultCnt = pstmt.executeUpdate();
	
	} catch(Exception e){
		e.printStackTrace();
	}
	
	//out.println(resultCnt);
	
	// 3. dept_list.jsp 이동
	//response.sendRedirect("dept_list.jsp");
	if(resultCnt>0){
		%>
<script>
	alert('수정되었습니다.');
	location.href = "dept_list.jsp";
</script>
<%
	} else {
		%>
<script>
alert("해당 데이터를 찾지 못했습니다.");
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