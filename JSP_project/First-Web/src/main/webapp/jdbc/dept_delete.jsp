<%@page import="jdbc.util.JdbcUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="dept.dao.DeptDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 사용자가 전달하는 deptno 받고
	String deptno = request.getParameter("deptno");
	
	// DB 에 있는 데이터를 삭제
	int resultCnt = 0;
	
	// 2. DB 처리 : insert
	Connection con = null;
	DeptDao dao = DeptDao.getInstance();
	
	try{
		con = ConnectionProvider.getConnection();
		resultCnt = dao.deleteDept(con, Integer.parseInt(deptno));
	} catch(SQLException e){
		e.printStackTrace();
	} catch(Exception e){
		e.printStackTrace();
	} finally{
		JdbcUtil.close(con);
	}
	
	if(resultCnt>0){
		%>
		<script>
			alert('삭제되었습니다.');
			location.href = 'dept_list.jsp';
		</script>
		<%
	} else {
		%>
		<script>
			alert("해당 데이터를 찾지 못했습니다.");
			location.href = 'dept_list.jsp';
		</script>
		<%
	}
	
%>