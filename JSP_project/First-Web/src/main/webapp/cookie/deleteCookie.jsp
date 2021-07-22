<%@page import="cookieUtil.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* 
	// 쿠키의 삭제: 쿠키 유지시간을 0으로 설정
	Cookie cookie = new Cookie("name", "");
	cookie.setMaxAge(0);
	// setMaxAge(60 * 60) -> 60초(1분) * 60 -> 1시간
	// 60*60*24*7 => 7일
	response.addCookie(cookie);
	*/
	response.addCookie(CookieBox.createCookie("name", "", "/First-Web/cookie", 0));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 삭제 페이지</title>
<style>
</style>
<script>
</script>
</head>
<body>
	<h1>쿠키 값이 변경되었습니다.</h1>
	<a href="viewCookie.jsp">쿠키 보기</a>
</body>
</html>