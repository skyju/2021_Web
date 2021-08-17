<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입 폼</title>
<%@ include file="/WEB-INF/frame/header.jsp"%>
<script src="<c:url value='/js/ajax_idcheck.js'/>"></script>
<script src="<c:url value='/js/ajax_reg.js'/>"></script>
<link rel="stylesheet" href="<c:url value='/css/idcheck.css'/>">
</head>
<body>
	<c:import url="/WEB-INF/frame/nav.jsp" />
	<div class="contents">
		<h2>회원가입</h2>
		<hr>
		<form method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" id="id" required="required">
						<span id="msg" class="display_none"></span></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" id="pw"
						required="required"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" id="name"
						required="required"></td>
				</tr>
				<tr>
					<td>프로필 사진</td>
					<td><input type="file" name="photo" id="photo"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="등록">
							<input type="reset"></td>
				</tr>
			</table>
		</form>
		<br>
		<div>
			ajax로 회원 가입 <input type="button" value="회원가입" id="btnReg1">
		</div>
		<div>
			ajax로 Json 전송 회원 가입 <input type="button" value="회원가입" id="btnReg2">
		</div>
	</div>
</body>
</html>