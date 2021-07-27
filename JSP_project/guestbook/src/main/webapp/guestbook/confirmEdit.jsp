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
	<h3>필수 입력 사항을 입력해주세요.</h3>
	<form action="msgEdit.jsp" method="post">
		<table>
			<tr>
				<td>
					비밀번호 <input type="password" name="password">
				</td>
			</tr>
			<tr>
				<td>
					작성자 <input type="text" name="guestname">
				</td>
			</tr>
			<tr>
				<th>수정할 메세지</th>
			</tr>
			<tr>
				<td>
					<textarea name="msg" rows="10" cols="30"></textarea>				
				</td>
			</tr>
			<tr>
				<td>
					<input type="hidden" name="mid" value="${param.mid}">
					<input type="submit" value="수정">
				</td>
			</tr>
		</table>
	</form>
	<hr>
	<p>
		<a href="list.jsp">메인으로 돌아가기</a>
	</p>
</body>
</html>