<%@page import="domain.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 페이지</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/default.css">
<%
	//session 정보 가져오기
	LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");

	if(loginInfo == null ) {
%>
<script>
	alert('로그인이 필요한 페이지입니다. \n로그인 후 사용해주세요.');
	location.href = "<%=request.getContextPath()%>/loginForm.jsp";
</script>
</head>
<%
	} else {
%>
</head>
<body>
	<%@ include file="/WEB-INF/frame/header.jsp"%>
	<%@ include file="/WEB-INF/frame/nav.jsp"%>
	<div class="contents">
		<h2>My Page</h2>
		<hr>
		<h3>내정보</h3>
		<h5>
		이름: 
<%
	out.print(loginInfo.getName());
%>
		아이디:
<%
	out.print(loginInfo.getId());
%>
		</h5>
	</div>
</body>
</html>
<%
	}
%>