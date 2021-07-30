<%@page import="member.domain.Member"%>
<%@page import="member.domain.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 페이지</title>
<link rel="stylesheet" href="<c:url value='/css/default.css'/>">
<c:if test="${result eq null}">
	<script>
		alert('로그인이 필요한 페이지입니다. \n로그인 후 사용해주세요.');
		location.href = "loginForm.do";
	</script>
</c:if>
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
				<th>프로필 이미지</th>
				<td>
					<img src="<c:url value="/upload/${result.photo}"/>" style="width: 200px">
				</td>
			</tr>
			<tr>
				<th>내 이름</th>
				<td>${result.name}</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${result.id}</td>
			</tr>
			<tr>
				<th>수정하기</th>
				<td><a href="editForm.do">수정</a> </td>
			</tr>
			<tr>
				<th>탈퇴하기</th>
				<td><a href="javascript:delMember()">탈퇴</a></td>
			</tr>
		</table>
	</div>
	<script>
		function delMember(){
			if(confirm('정말 탈퇴 하시겠습니까?')) {
				location.href = 'deleteMember.do';
			}
		}
	</script>
</body>
</html>