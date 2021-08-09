package com.bitcamp.member.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler
			) throws Exception {
		
		System.out.println("Interceptor prehandle in");
		
		// 1. 로그인 여부 확인
		// 2. 로그인 상태에 따라 true/false로 return
		// 3. 로그인 상태가 아니라면 로그인 페이지로 redirect
		
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("member") != null) {
			return true;
		}
		response.sendRedirect(request.getContextPath()+"/member/login?referer="+request.getRequestURI());
		return false;
	}
}