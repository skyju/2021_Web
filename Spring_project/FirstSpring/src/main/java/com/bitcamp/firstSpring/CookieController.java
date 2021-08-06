package com.bitcamp.firstSpring;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

public class CookieController {
	//쿠키생성해주는 요청 처리
	@RequestMapping(value="/cookie/make")
	public String makeCookie(HttpServletResponse response) {
		Cookie c = new Cookie("username", "KING");
		response.addCookie(c);
		
		//service.process(response)
		
		return "cookie/make";
	}
	
	@RequestMapping("/cookie/view")
	public String viewCookie(
			//@CookieValue(value = "usernames", required = true) String userName,
			@CookieValue(value="username", defaultValue = "Scott") String userName,
			Model model
			) {
		model.addAttribute("userName", userName);
		System.out.println(userName);
		//service.process(model, String...)
		
		return "cookie/view";
	}
	
}
