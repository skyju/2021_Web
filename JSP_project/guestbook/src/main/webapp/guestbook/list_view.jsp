<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div.msg_box {
	padding: 5px;
	border: 1px solid #AAA;
	margin: 5px;
	width: 300px;
}

div.paging {
	padding: 10px;
	margin-left: 10px;
	margin-bottom: 150px;
}
</style>
<script>
</script>
</head>
<body>
	<form action="writemsg.jsp" method="post">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="guestname" required></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td>메시지</td>
				<td><textarea name="msg" rows="10" cols="30"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="메시지남기기"></td>
			</tr>
		</table>
	</form>
	
	<hr>
	<c:if test="${listView.msgList ne null and not empty listView.msgList}">
		<c:forEach items="${listView.msgList}" var="msg">
			<div class="msg_box">
				<table>
					<tr>
						<td>메세지 아이디</td>
						<td>${msg.msgid}</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>${msg.guestname}</td>
					</tr>
					<tr>
						<td>메세지</td>
						<td>${msg.msg}</td>
					</tr>
					<tr>
						<td>작성일</td>
						<td>${msg.regdate}</td>
					</tr>
					<tr>
						<td><button onclick="location.href='confirmDelete.jsp?mid=${msg.msgid}'">
						삭제하기</button></td>
					</tr>
				</table>
			</div>
		</c:forEach>
	</c:if>

	<!-- 페이징 -->
	<c:if test="${listView.totalPageNum>0}">
		<div class="paging">
			<c:forEach begin="1" end="${listView.totalPageNum}" var="num">
				<span>[<a href="list.jsp?page=${num}">${num}</a>]
				</span>
			</c:forEach>
		</div>
	</c:if>
</body>
</html>