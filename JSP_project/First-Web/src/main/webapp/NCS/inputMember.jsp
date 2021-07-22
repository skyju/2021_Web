<%@page import="java.time.LocalDateTime"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="ncs.Member"%>
<%@page import="ncs.ConnectionProvider"%>
<%@page import="ncs.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 처리중</title>
<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	
	Timestamp date = Timestamp.valueOf(LocalDateTime.now());
	
	int resultCnt = 0;
	
	Connection con = null;
	MemberDao dao = MemberDao.getInstance();
	try{
		con = ConnectionProvider.getConnection();
		resultCnt = dao.insertMember(con, new Member(0, id, pw, name, date));
	
	} catch(Exception e){
		e.printStackTrace();
	}

	if(resultCnt>0){
		%>
<script>
	alert('등록되었습니다.');
	location.href = "outputMember.jsp";
</script>
<%
	} else {
		%>
<script>
	alert('오류 발생으로 등록되지 않았습니다. \n 입력페이지로 다시 돌아갑니다.');
	window.history.go(-1);
</script>
<%
	}
	
%>
</head>
<body>
</body>
</html>