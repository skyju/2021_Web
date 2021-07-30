<%@page import="member.domain.Member"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="member.domain.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 수정 페이지</title>
<link rel="stylesheet" href="<c:url value='/css/default.css'/>">
<%-- <link rel="stylesheet" href="<c:url value='/css/idcheck.css'/>"> --%>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<%-- <script src="<c:url value='/js/ajax_idcheck.js'/>"></script> --%>
<%-- 
<script> var loginchk; </script>
<c:if test="${member.id eq id}">
	<script>
		loginchk = true;
		$('#msg').addClass('display_none');
	</script>
</c:if>
 --%>
</head>
</head>
<body>
	<c:import url="/WEB-INF/frame/header.jsp" />
	<c:import url="/WEB-INF/frame/nav.jsp" />
	<h1 id="list_header">정보 수정 페이지</h1>
	<hr>
	<h3>수정할 정보를 입력해주세요</h3>
	<form action="editMember.do" method="post">
		<table border=1>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="id" id="id" value="${member.id}" disabled="disabled">
					<%-- <span id="msg" class="display_none"></span>
					<img id="loadingimg" class="display_none" alt="loading" src="<c:url value="/image/loading.gif"/>">  --%>
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