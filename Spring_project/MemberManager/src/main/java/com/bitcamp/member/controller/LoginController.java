package com.bitcamp.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.member.service.LoginService;

@Controller
@RequestMapping("/member/login")
public class LoginController {
	
	@Autowired
	@Qualifier("loginservice") //get
	private LoginService loginservice;
	
	//@RewquestHeader에서 key갑중 referer를 통해 바로 직전에 머물렀던 링크 주소를 얻을 수 있다.
	@RequestMapping(method = RequestMethod.GET)
	public String loginForm(
			@RequestHeader(value="referer", required = false) String redirectUri,
			Model model
			) {
		model.addAttribute("redirectUri", redirectUri);
		return "member/loginForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(
			HttpServletRequest request, 
			HttpServletResponse response,
			Model model,
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam(value="reid", required = false) String reid,
			@RequestParam(value = "redirectUri", required = false) String redirectUri
			) {
		
		boolean loginChk = loginservice.login(request, response, id, pw, reid);
		model.addAttribute("loginChk", loginChk);
		
		
		String view = "member/login";
		
		// chkURI 메서드 : 파라미터로 받는 스트링이 /member로 시작하면  false 아니면 true 리턴
		// 즉, redirectUri-이전에 머물렀던 페이지가 /member로 시작하지 않으면서 로그인이 성공했을 시 이전 페이지로 이동시키는 처리
		if(loginservice.chkURI(redirectUri) && loginChk) {
				redirectUri = redirectUri.substring(request.getContextPath().length());
				view = "redirect:"+redirectUri;
		}
		
		return view;
	}
	
	
}
