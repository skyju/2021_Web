<%@page import="java.sql.SQLException"%>
<%@page import="util.ConnectionProvider"%>
<%@page import="dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="util.ConnectionProvider"%>
<%@page import="domain.Member"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 사용자가 전달한 데이터를 받고 -> DB에서 확인 -> 로그인 처리 -> Session에 저장
	// reid 확인 하고 값을 받아오면 쿠키 설정
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String reid = request.getParameter("reid");
	
	Connection con = null;
	boolean loginChk = false;
	
	if(id != null && pw != null & id.trim().length() > 2 && pw.trim().length() > 2) {
		try{
			con = ConnectionProvider.getConnection();
			Member member = MemberDao.getInstance().selectByIdPw(con, id, pw);
			
			if(member != null) {
				// 여기까지 왔을 떄가 로그인 성공, session에 저장
				//session.setAttribute("member", member);
				session.setAttribute("loginInfo", member.toLoginInfo());
				loginChk = true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	// ID 저장을 위한 쿠키 설정
	// reid 값의 유무 체크
	if(reid != null && reid.equals("on")) {
		// 쿠키 저장: 사용자 ID를 저장(1년)
		response.addCookie(CookieBox.createCookie("reid", id, "/", 60*60*24*365));
	} else {
		// 쿠키값을 저장하지 않는다
		response.addCookie(CookieBox.createCookie("reid", id, "/", 0));
	}
	
	if(loginChk) {
		//쿠키까지 전부 처리하고 보내기 위해서
		response.sendRedirect("index.jsp");
	} else {
%>
<script>
	alert('아이디 또는 비밀번호가 일치하지 않습니다.');
	history.go(-1); //window 생략해도 됨
</script>
<%
	}
%>