<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 수정 페이지</title>
</head>
</head>
<body>
	<c:import url="/WEB-INF/frame/header.jsp" />
	<c:import url="/WEB-INF/frame/nav.jsp" />
	<h1 id="list_header">정보 수정 페이지</h1>
	<hr>
	<h3>수정할 정보를 입력해주세요</h3>
	<form action="<c:url value='/member/edit'/>" method="post">
		<table border=1>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="id" id="id" value="${member.id}" disabled="disabled">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" value="${member.pw}" required="required"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value="${member.name}" required="required"></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="수정">
					<input type="reset">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>