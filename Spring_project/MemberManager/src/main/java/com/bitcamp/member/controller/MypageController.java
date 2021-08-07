package com.bitcamp.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/mypage")
public class MypageController {
	
	//@Autowired
	// LoginService loginservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public String mypage() {
		return "member/mypage";
	}
	
}
