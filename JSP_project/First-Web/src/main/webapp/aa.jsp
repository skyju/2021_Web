<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>AAA</h1>
</body>
</html>
<%-- <jsp:forward page="bb.jsp"/> 
--%>
<jsp:forward page="include/footer.jsp">
	<jsp:param name="email" value="test@gmail.com"/>
	<jsp:param name="tel" value="010-0000-0000"/>
</jsp:forward>