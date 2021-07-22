<%@page import="ncs.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Member> list = (List<Member>) request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<style>
</style>
<script>
</script>
</head>
<body>
	<h1>회원 목록</h1>
	<button onclick="location.href='inputForm.jsp';">멤버 등록</button>
	<hr>
	<form>
		<table>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
			</tr>
		<%
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
		%>
			<tr>
				<td><%=list.get(i).getId()%></td>
				<td><%=list.get(i).getPw()%></td>
				<td><%=list.get(i).getName()%></td>
				<td><%=list.get(i).getDate()%></td>
			</tr>
		<%
			}
		}
		%>
	</table>
	</form>
</body>
</html>