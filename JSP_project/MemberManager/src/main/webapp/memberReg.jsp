<%@page import="domain.Member"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.SQLException"%>
<%@page import="util.ConnectionProvider"%>
<%@page import="dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="domain.Member" />
<jsp:setProperty property="*" name="member" />
<%
	int resultCnt = 0;
	Connection con = null;
	MemberDao dao = null;
	
	try {
		con = ConnectionProvider.getConnection();
		dao = MemberDao.getInstance();
		resultCnt = dao.insertMember(con, member);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	if (resultCnt > 0) {
%>
<script>
	alert('등록되었습니다.');
	location.href = '<%=request.getContextPath()%>/index.jsp';
</script>
<%
	} else {
%>
<script>
	alert('오류 발생으로 등록되지 않았습니다.\n입력페이지로 다시 이동합니다.');
	window.history.go(-1);
</script>
<%
	}
%>