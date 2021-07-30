package service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDao;
import member.domain.Member;
import util.ConnectionProvider;
import util.CookieBox;

public class LoginCommandImpl implements Command {
	
	boolean loginChk = false;
	String id;
	String pw;
	String reid;
	
	public boolean login(HttpServletRequest request, HttpServletResponse response) {
		
		Connection conn = null;
		
		// 사용자가 전달한 데이터를 받고 -> DB에서 확인 -> 로그인 처리 -> Session에 저장
		// reid 확인 하고 값을 받아오면 쿠키 설정
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		reid = request.getParameter("reid");
		cookieChk(response);
		
		if(id != null && pw != null & id.trim().length() > 2 && pw.trim().length() > 2) {
			try{
				conn = ConnectionProvider.getConnection();
				Member member = MemberDao.getInstance().selectByIdPw(conn, id, pw);
				
				if(member != null) {
					// 여기까지 왔을 떄가 로그인 성공, session에 저장
					request.getSession().setAttribute("member", member);
					request.getSession().setAttribute("loginInfo", member.toLoginInfo());
					loginChk = true;
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return loginChk;
	}
	
	public void cookieChk(HttpServletResponse response) {
		
		// ID 저장을 위한 쿠키 설정
		// reid 값의 유무 체크
		if(reid != null && reid.equals("on")) {
			// 쿠키 저장: 사용자 ID를 저장(1년)
			try {
				response.addCookie(CookieBox.createCookie("reid", id, "/", 60*60*24*365));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else {
			// 쿠키값을 저장하지 않는다
			try {
				response.addCookie(CookieBox.createCookie("reid", id, "/", 0));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		login(request, response);
		request.setAttribute("loginChk", loginChk);
		return "/WEB-INF/views/login.jsp";
	}

}
