<%@page import="dept.dao.DeptDao"%>
<%@page import="java.sql.SQLException"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String deptno = request.getParameter("deptno");
	
	Connection con = null;
	DeptDao dao = null;
	
	try {
		con = ConnectionProvider.getConnection();
		// 부서정보를 form_view.jsp 전달(공유)
		request.setAttribute("dept", dao.selectByDeptno(con, Integer.parseInt(deptno)));
	} catch(SQLException e){
		e.printStackTrace();
	}
	
	
%>
<jsp:forward page="form_view.jsp"/>
