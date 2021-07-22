<%@page import="cookieUtil.CookieBox"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//Cookie[] cookies = request.getCookies();
	CookieBox box = new CookieBox(request);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 보기 페이지</title>
</head>
<body>
	<h1>Cookie 보기</h1>
	<hr>
	name = <%= box.getCookieValue("name")%>
	<br>
	age = <%= box.getCookieValue("age")%>
	<br>
	number = <%= box.getCookieValue("number")%>
	<br>
	<a href="makeCookie.jsp">쿠키 생성</a>
	<br>
	<a href="editCookie.jsp">쿠키 수정</a>
	<br>
	<a href="deleteCookie.jsp">쿠키 삭제</a>
</body>
</html>