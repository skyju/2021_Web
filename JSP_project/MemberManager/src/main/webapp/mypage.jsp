<%@page import="domain.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 페이지</title>
<link rel="stylesheet" href="<c:url value='/css/default.css'/>">
<c:if test="${loginInfo eq null}">
	<script>
		alert('로그인이 필요한 페이지입니다. \n로그인 후 사용해주세요.');
		location.href = "loginForm.jsp";
	</script>
</c:if>
<%
	LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");
%>
</head>
</head>
<body>
	<c:import url="/WEB-INF/frame/header.jsp" />
	<c:import url="/WEB-INF/frame/nav.jsp" />
	<div class="contents">
		<h2>My Page</h2>
		<hr>
		<h3>내정보</h3>
		<table border=1>
			<tr>
				<th>내 이름</th>
				<th>아이디</th>
				<th>수정하기</th>
				<th>탈퇴하기</th>
			</tr>
			<tr>
				<td>${loginInfo.getName()}</td>
				<td>${loginInfo.getId()}</td>
				<td><a href="editForm.jsp">수정</a> </td>
				<td><a href="javascript:delMember()">탈퇴</a></td>
		</table>
	</div>
	<script>
		function delMember(){
			if(confirm('정말 삭제하시겠습니까?')) {
				location.href = 'deleteMember.jsp';
			}
		}
	</script>
</body>
</html>