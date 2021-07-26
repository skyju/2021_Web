<%@page import="util.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.MemberDao"%>
<%@page import="domain.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Member> list = (List<Member>) request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 목록</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/default.css">
<style>
	td {
		text-align: center;
		padding: 5px 10px;
	}
	
	button {
		margin: 5px 0;
	}
	#list_header {
		padding-left: 15px;
	}
	table {
		padding-top: 10px;
		padding-left: 15px;
	}
</style>
<script>
</script>
</head>
<body>
	<%@ include file="/WEB-INF/frame/header.jsp"%>
	<%@ include file="/WEB-INF/frame/nav.jsp"%>
	<h1 id="list_header">멤버 리스트</h1>
	<hr>
	<table border=1>
		<tr>		
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>가입일</th>
		</tr>
		
	<%
		if(list != null && !list.isEmpty()) {
			for(int i=0; i<list.size(); i++) {
	%>
		<tr>	
			<td><%= list.get(i).getId() %></td>
			<td><%= list.get(i).getPw() %></td>
			<td><%= list.get(i).getName( )%></td>
			<td><%= list.get(i).getDate() %></td>
			<td>
				<a href="editForm.jsp">수정</a> 
				<a href="javascript:delMember()">삭제</a>
			</td>
		</tr>
	<%
			}
		}
	%>
	</table>
	<script>
		function delMember(){
			if(confirm('정말 삭제하시겠습니까?')) {
				location.href = 'deleteMember.jsp';
			}
		}
	</script>
</body>
</html>