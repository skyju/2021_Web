<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello</title>
<%@ include file="/WEB-INF/frame/header.jsp"%>
</head>
<body>
	<c:import url="/WEB-INF/frame/nav.jsp" />
	<div class="contents">
		<h2>Login</h2>
		<hr>
		<form action="<c:url value='/member/login'/>" method="post">
			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" name="id" value="${cookie.reid.value}"></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="password" name="pw"></td>
				</tr>
				<tr>
					<th></th>
					<td>
						<input type="checkbox" name="reid" value="on" ${cookie.reid.value ne null ? 'checked':''}> 
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