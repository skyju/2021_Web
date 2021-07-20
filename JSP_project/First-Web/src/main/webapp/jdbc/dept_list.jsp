<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="dept.domain.Dept"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 요청을 받고 처리

	// 처리 부분
	// 1. 드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");

	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 2. DB 연결
	con = ConnectionProvider.getConnection();
	
	// 3. Statement 객체
	stmt = con.createStatement();
	String sqlSelect = "select * from dept";
	
	// 4. ResultSet 객체
	rs = stmt.executeQuery(sqlSelect);
	
	// 5. List<Dept> 결과
	List<Dept> deptList = new ArrayList<Dept>();
	
	while(rs.next()) {
		int deptno = rs.getInt("deptno");
		String dname = rs.getString("dname");
		String loc = rs.getNString("loc");
		deptList.add(new Dept(deptno, dname, loc));	
	}
	
	// 6. 결과 데이터 Request의 속성에 저장 -> data를 공유 혹은 전달
	request.setAttribute("result", deptList);
%>
<jsp:forward page="list_view.jsp" />
<!--  list_view.jsp : view 의 역할만!!!! -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
	
</script>
</head>
<body>

</body>
</html>