<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	
	<h3>
	<c:url value="/aa.jsp" var="urlAa"/> <!-- 출력안함 -->
	<c:url value="/aa.jsp"/> <br><!-- var속성 기입안하면 출력함 -->
	경로: ${urlAa} <br>
	해당 경로로 이동 : <a href="${urlAa}">이동</a>
	</h3>
	
	<hr>
	
	<!-- 파라미터를 함꼐 전송하기 -->
	<c:url value="/aa.jsp" var="urlaa">
		<c:param name="type" value="aa"/>
		<c:param name="index">1</c:param>
	</c:url>
	
	<a href="${urlaa}">${urlaa}</a>
	
</body>
</html>