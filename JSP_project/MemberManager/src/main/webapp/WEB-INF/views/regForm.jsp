<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입 폼</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(document).ready(function(){
		
		$('#id').focusin(function(){
			$('#msg').addClass('display_none');
			$('#msg').removeClass('color_blue');
			$('#msg').removeClass('color_red');
			$(this).val('');
		});
		
		$('#id').focusout(function(){
			// ajax 비동기 통신 -> id를 서버로 보내고 사용가능 유무의 응답 코드를 받는다.
			$.ajax({
				
				url: 'idcheck.jsp',
				type: 'post',
				data: {
					id:$(this).val()
				}, 
				beforeSend : function(){
					$('#loadingimg').removeClass('display_none');
				},
				success : function(data){
					// data : Y / N
					if(data == 'Y'){
						$('#msg').html('사용가능');
						${'#msg'}.addClass('color_blue');
						$('#msg').removeClass('display_none');
					} else {
						$('#msg').html('사용불가능');
						${'#msg'}.addClass('color_red');
						$('#msg').removeClass('display_none');
					}
				},
				error : function(request, status, error){
					alert('서버 통신에 문제가 발생했습니다. 다시 실행해주세요.');
					console.log(request);
					console.log(status);
					console.log(error);
				},
				complete : function(){
					$('#loadingimg').addClass('display_none');
				}
			});
			
		});
		
		
		
	});
</script>
<link rel="stylesheet" href="<c:url value='/css/default.css'/>">
<style>
	.display_none {
		display: none;
	}
	.color_blue {
		color: blue;
	}
	.color_red {
		color: red;
	}
	#loadingimg {
		height : 20px;
	}
</style>
</head>
<body>
	<c:import url="/WEB-INF/frame/header.jsp" />
	<c:import url="/WEB-INF/frame/nav.jsp" />
	<div class="contents">
		<h2>회원가입</h2>
		<hr>
		<form action="memberReg.do" method="post" enctype="multipart/form-data"> 
			<table>
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="id" id="id">
						<span id="msg" class="display_none"></span>
						<img id="loadingimg" class="display_none" alt="loading" src="<c:url value="/image/loading.gif"/>"> 
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="password" name="pw" id="pw" required="required">
						<span id="msg" class="display_none"></span>
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>	
						<input type="text" name="name" id="name" required="required">
						<span id="msg" class="display_none"></span>
					</td>
				</tr>
				<tr>
					<td>프로필 사진</td>
					<td><input type="file" name="photo"></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="등록">
						<input type="reset">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>