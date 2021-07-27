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
	<h3>메세지를 삭제하려면 비밀번호를 입력하세요.</h3>
	<form action="msgDelete.jsp" method="post">
		비밀번호 <input type="password" name="password"> <input
			type="hidden" name="mid" value="${param.mid}"><br> <input
			type="submit" value="삭제">
	</form>
	<hr>
	<p><a href="list.jsp">메인으로 돌아가기</a></p>
</body>
</html>