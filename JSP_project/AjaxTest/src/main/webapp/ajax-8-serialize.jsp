<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<style>
</style>
<script>
	$(document).ready(function(){
		
		$('#myform').submit(function(){
			
			console.log($(this).serialize());
			console.log($(this).serializeArray());
			//$().serialize(): form태그 내의 name 속성 값들을 모두 가지고 옴(문자열로)
			//$().serializeArray(): 위와 같은데, 객체(배뎔)로 가지고옴
			//$().param(): 객체 내용을 요청 매개변수의 문자열로 만듦
			
			$.ajax({
				url : 'parameter.jsp',
				// data : $(this).serialize(),
				data : $(this).serializeArray(),
				success : function(data) {
					$('#menu').append(data);
				}
			});
			
			return false;
		});
		
	});
	
</script>
</head>
<body>

	<h1>제품 등록</h1>
	<hr>
	
	<form id="myform">
		제품 이름 : <input type="text" id="pname" name="pname"><br>
		제품 가격 : <input type="number" id="price" name="price"><br>
		<input type="submit" id="btn">
	</form>
	
	<hr>
	
	<div id="menu">
		<h3>메뉴표</h3>
		<hr>
		
		
	</div>
	
	
</body>
</html>