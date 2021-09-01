package com.bitcamp.app.member.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bitcamp.app.member.domain.Member;
import com.bitcamp.app.member.mapper.MemberMapper;
import com.bitcamp.app.member.util.CookieBox;

@Service
@Qualifier("loginservice") // set
public class LoginService {
	
	private MemberMapper dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	boolean loginChk = false;

	public boolean login(
			HttpServletRequest request, 
			HttpServletResponse response, 
			String id, 
			String pw, 
			String reid
			) {

		cookieChk(response, reid, id);
		dao = template.getMapper(MemberMapper.class);
		
		if (id != null && pw != null && id.trim().length() > 2 && pw.trim().length() > 2) {
			Member member = dao.selectByIdPw(id, pw);
			if (member != null) {
				request.getSession().setAttribute("member", member);
				loginChk = true;
			}
		}
		return loginChk;
	}

	public void cookieChk(HttpServletResponse response, String reid, String id) {

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

	public boolean chkURI(String uri) {
		boolean chk = true;

		if (!uri.startsWith("/member")) {
			chk = false;
		}
		return chk;
	}
}
