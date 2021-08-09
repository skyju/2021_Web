package com.bitcamp.member.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bitcamp.member.dao.MemberDao;
import com.bitcamp.member.domain.Member;
import com.bitcamp.member.util.ConnectionProvider;
import com.bitcamp.member.util.CookieBox;


@Service
@Qualifier("loginservice") //set
public class LoginService {
	
	@Autowired
	MemberDao dao;
	
	boolean loginChk = false;
	String id;
	String pw;
	String reid;

	public boolean login(HttpServletRequest request, HttpServletResponse response) {

		Connection conn = null;

		id = request.getParameter("id");
		pw = request.getParameter("pw");
		reid = request.getParameter("reid");
		cookieChk(response);

		if (id != null && pw != null & id.trim().length() > 2 && pw.trim().length() > 2) {
			try {
				conn = ConnectionProvider.getConnection();
				Member member = dao.selectByIdPw(conn, id, pw);

				if (member != null) {
					request.getSession().setAttribute("member", member);
					loginChk = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return loginChk;
	}

	public void cookieChk(HttpServletResponse response) {

		if (reid != null && reid.equals("on")) {
			// 쿠키 저장: 사용자 ID를 저장(1년)
			try {
				response.addCookie(CookieBox.createCookie("reid", id, "/", 60 * 60 * 24 * 365));
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

}
