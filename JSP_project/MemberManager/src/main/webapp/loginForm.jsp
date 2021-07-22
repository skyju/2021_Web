<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	CookieBox box = new CookieBox(request);
	String reid = box.existCookie("reid") ? box.getCookieValue("reid") : "";
	String checked = box.existCookie("reid") ? "checked" : "";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/default.css">
<style>
</style>
<script>
</script>
</head>
<body>
	<%@ include file="/WEB-INF/frame/header.jsp"%>
	<%@ include file="/WEB-INF/frame/nav.jsp"%>
	<div class="contents">
		<h2>Login</h2>
		<hr>
		<form action="login.jsp" method="post">
			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" name="id" value=<%=reid%>></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="password" name="pw"></td>
				</tr>
				<tr>
					<th></th>
					<td>
						<input type="checkbox" name="reid" value="on" <%=checked%>> 
						아이디 기억하기
						</td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>