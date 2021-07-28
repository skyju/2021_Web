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