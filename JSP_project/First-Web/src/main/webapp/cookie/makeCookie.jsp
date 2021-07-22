<%@page import="cookieUtil.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 쿠키: 문자열 데이터를 사용자의 브라우저에 저장
	// 쿠키 생성 -> response.add(cookie)
	// Cookie cookie1 = new Cookie("name", "son");
	// Cookie cookie2 = new Cookie("age", "30");
	// 쿠키 굽는다: 쿠키를 브라우저로 응답
	response.addCookie(CookieBox.createCookie("name", "손흥민"));
	response.addCookie(CookieBox.createCookie("age", "30"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 생성 페이지</title>
<style>
</style>
<script>
</script>
</head>
<body>
	<h1>Cookie 저장</h1>
	<a href="viewCookie.jsp">쿠키 보기</a>
</body>
</html>