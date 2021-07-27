<%@page import="guest.service.WriteMsgService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="msgRequest" class="guest.domain.MsgRequest"/>
<jsp:setProperty property="*" name="msgRequest"/>
<%
	int result = WriteMsgService.getInstance().writeMsg(msgRequest);
	request.setAttribute("result", result);
%>
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
<jsp:forward page="write_view.jsp"></jsp:forward>
</body>
</html>