<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello</title>
<%@ include file="/WEB-INF/frame/header.jsp"%>
</head>
<body>
	<c:import url="/WEB-INF/frame/nav.jsp" />
	<div class="contents">
		<h1>방명록 리스트</h1>
		<h2>${member}</h2>
	</div>
</body>
</html>