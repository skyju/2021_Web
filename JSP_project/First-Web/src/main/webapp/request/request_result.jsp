<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String userName = request.getParameter("username");
String job = request.getParameter("job");
String[] interests = request.getParameterValues("interest");
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
	<h1>request Form Test</h1>
	<table>
		<tr>
			<td>이름</td>
			<td><%=userName%></td>
		</tr>
		<tr>
			<td>직업</td>
			<td><%=job%></td>
		</tr>
		<tr>
			<td>관심사항</td>
			<td>
				<%
				if (interests != null && interests.length > 0) {
					for (int i = 0; i < interests.length; i++) {
						out.println(interests[i]+"<br>");
					}
				}
				%>
			</td>
		</tr>
	</table>
</body>
</html>