<%@page import="jdbc.util.JdbcUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="dept.dao.DeptDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 요청을 받고 처리

	// 처리 부분
	Connection con = null;
	DeptDao dao = DeptDao.getInstance();

	// 2. DB 연결
	try{
		con = ConnectionProvider.getConnection();
		// 결과 데이터 Request의 속성에 저장 -> data를 공유 혹은 전달
		request.setAttribute("result", dao.getDeptList(con));
	} catch(SQLException e){
		e.printStackTrace();
	} catch(Exception e){
		e.printStackTrace();
	} finally{
		JdbcUtil.close(con);
	}
%>
<jsp:forward page="list_view.jsp" />
<!--  list_view.jsp : view 의 역할만!!!! -->
