<%@page import="util.CloseUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="dao.MemberDao"%>
<%@page import="util.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Connection con = null;
	MemberDao dao = MemberDao.getInstance();
	try{
		con = ConnectionProvider.getConnection();
		request.setAttribute("result", dao.getMemberList(con));
	} catch(SQLException e){
		e.printStackTrace();
	} catch(Exception e){
		e.printStackTrace();
	} finally{
		CloseUtil.close(con);
	}
%>
<jsp:forward page="list_view.jsp" />
