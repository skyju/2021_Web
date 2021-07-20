<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1>부서 정보 등록</h1>
	<hr>
	<form action="regDept.jsp" method="post">
		<table>
			<tr>
				<th>부서번호</th>
				<td><input type="number" name="deptno" required="required"></td>
			</tr>
			<tr>
				<th>부서명</th>
				<td><input type="text" name="dname" required="required"></td>
			</tr>
			<tr>
				<th>위치</th>
				<td><input type="text" name="loc" required="required"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="등록">
					<input type="reset">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>