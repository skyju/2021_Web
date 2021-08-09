<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 목록</title>
<style>
	td {
		text-align: center;
		padding: 5px 10px;
	}
	button {
		margin: 5px 0;
	}
	#list_header {
		padding-left: 15px;
	}
	table {
		padding-top: 10px;
		padding-left: 15px;
	}
</style>
<script>
</script>
</head>
<body>
	<c:import url="/WEB-INF/frame/header.jsp" />
	<c:import url="/WEB-INF/frame/nav.jsp" />
	<h1 id="list_header">멤버 리스트</h1>
	<hr>
	<table border=1>
		<tr>
			<th>회원번호</th>	
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>가입일시</th>
		</tr>
		<c:if test="${result ne null and not empty result}">
			<c:forEach items="${result}" var="member">
				<tr>
					<td>
						<img src="<c:url value="/uploadfile/${member.photo}"/>" style="width: 50px">
						${member.idx}
					</td>
					<td>${member.id}</td>
					<td>${member.pw}</td>
					<td>${member.name }</td>
					<td><fmt:formatDate value="${member.date}" pattern="yyyy-MM-dd HH:mm" timeZone="UTC+9"/></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>