<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//포스트로 받을 때 필수
//사용자가 전달한 데이터의 한글 처리!!!
request.setCharacterEncoding("utf-8");

String userName = request.getParameter("username");
String job = request.getParameter("job");
String[] interests = request.getParameterValues("interest");

request.setAttribute("userName", userName);
request.setAttribute("job", job);
request.setAttribute("age", 30); // 30 -> auto Boxing
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

	<h1>request Form Test: result</h1>
	<table border="1">
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
		<tr>
			<td></td>
			<td>
				<jsp:include page="view.jsp"></jsp:include>
			</td>
		</tr>
	</table>
	
</body>
</html>