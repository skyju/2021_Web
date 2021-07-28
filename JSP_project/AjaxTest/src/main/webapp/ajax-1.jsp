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
	
	// Ajax: 클라이언트와 서버 측의 데이터 전송 및 처리를 비동기적으로 처리
	// 기본 
	//		- $.ajax(options);
	//		- $.ajax(url, options(type, async, timeout, 
	//					complete, success, error ... ));

	$(document).ready(function(){
		// alert("ready");
		
		$.ajax('data.html', {
			success: function(data){
				$('body').append(data);
			}
		});
	});
</script>
</head>
<body>
ajax-1.jsp
</body>
</html>