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
<c:if test="${result>0}">
	<script>
		alert('수정되었습니다.');
		location.href = "index.jsp";
	</script>
</c:if>
<c:if test="${result eq 0}">
	<script>
		alert("해당 데이터를 찾지 못했습니다.");
		window.history.go(-1);
	</script>
</c:if>
</head>
<body>
</body>
</html>