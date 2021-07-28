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
		
		$.getJSON('data.json', function(data){
			$.each(data, function(index, value){
				var html = '<h3>이름: '+value.name+', 가격 : '+value.price+'</h3>';
				$('body').append(html);
			});
		});
		
		
		
	});
</script>
</head>
<body>
</body>
</html>