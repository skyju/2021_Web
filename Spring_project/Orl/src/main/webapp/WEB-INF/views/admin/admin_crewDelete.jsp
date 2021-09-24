<%@page import="com.bitcamp.orl.member.domain.Member"%>
<%@page import="com.mysql.cj.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제중</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
/*부트서버*/
const url = 'http://52.79.178.223:8081';
/*뷰 서버*/
const url2 = '${pageContext.request.contextPath}';
const crewIdx = '${crewIdx}';
$(document).ready(function() {
	$.ajax({
		url : url + '/admin/crew/deleteCrew',
		data : {
			crewIdx : crewIdx
		},
		success : function(data) {
			if (data > 0) {
				alert('삭제되었습니다.');
				window.location.href = url2+"/admin/crew";
			} else if (data == 0) {
				alert('삭제에 실패하였습니다.');
				window.history.go(-1);
			}
		}
	});
});
</script>
</head>
</html>