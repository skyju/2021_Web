<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제</title>
<c:if test="${result>0}">
	<script>
		alert('삭제되었습니다.');
		location.href = "logout.jsp";
	</script>
</c:if>
<c:if test="${result eq 0}">
	<script>
		alert("권한이 없습니다.");
		window.history.go(-1);
</script>
</c:if>
</head>
</html>