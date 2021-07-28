<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
</style>
<script>
	$(document).ready(function(){
		//alert("ready");
		
		$.getJSON('data.json', function(data) {
			
			$.each(data, function(index, value) {
				var html = '<h3>이름: '+value.name+', 가격 : '+value.price+'</h3>';
				$('body').append(html);
			});
			
		});
		
		/*
		JSON 문법
		객체 배열 -> 문자열 -> localStorage에 저장 수정 삭제
		JSON.parse(localStorage.getItem('저장할 이름'))
		localStorage.setItem('저장할 이름', JSON.stringify(객체배열))
		
		json 파일 : text file, 아무데서나 열어도 됨
		
		*/
		
	});
</script>
</head>
<body>
</body>
</html>