package com.bitcamp.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(method = RequestMethod.GET)
	public String loginForm() {
		return "member/loginForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(
			HttpServletRequest request, 
			HttpServletResponse response,
			Model model,
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam("reid") String reid
			) {
		boolean loginChk = loginservice.login(request, response, id, pw, reid);
		model.addAttribute("loginChk", loginChk);
		return "member/login";
	}
	
}
