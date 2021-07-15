<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//스크립트 영역
	Date now = new Date();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>현재시간</title>
	<style>
	</style>
	<script>
	</script>
</head>
<body>
	현재 시각:
	<%=now%>
</body>
</html>