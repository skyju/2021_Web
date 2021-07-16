<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//포스트로 받을 때 필수
//사용자가 전달한 데이터의 한글 처리!!!
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
String pw = request.getParameter("pw");
%>
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
<h1>request Form Test: result</h1>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><%=id%></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<%=pw%>
			</td>
		</tr>
	</table>
</body>
</html>