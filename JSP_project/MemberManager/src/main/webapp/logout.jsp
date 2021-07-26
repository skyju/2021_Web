<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
<style>
</style>
<script>
	alert('로그아웃되었습니다.');
	location.href = 'index.jsp';
</script>
</head>
<body>
</body>
</html>