package com.bitcamp.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/list_view")
public class ListViewController {
	
	//@Autowired
	//private LoginService loginservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public String listView() {
		return "member/list_view";
	}

}
