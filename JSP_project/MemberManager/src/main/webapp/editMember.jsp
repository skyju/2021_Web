<%@page import="java.sql.SQLException"%>
<%@page import="util.ConnectionProvider"%>
<%@page import="dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Member member = (Member)session.getAttribute("member");
	member.setId(request.getParameter("id"));
	member.setPw(request.getParameter("pw"));
	member.setName(request.getParameter("name"));
	
	Connection con = null;
	int resultCnt = 0;
	try{
		con = ConnectionProvider.getConnection();
		resultCnt = MemberDao.getInstance().updateMember(con, member);
		session.setAttribute("member", member);
		session.setAttribute("loginInfo", member.toLoginInfo());
	} catch(SQLException e) {
		e.printStackTrace();
	}
	if(resultCnt > 0) {
%>
<script>
	alert('수정되었습니다.');
	location.href = "<%=request.getContextPath()%>/";
</script>
<%
	} else {
		%>
<script>
	alert("해당 데이터를 찾지 못했습니다.");
	window.history.go(-1);
</script>
<%
	}
%>