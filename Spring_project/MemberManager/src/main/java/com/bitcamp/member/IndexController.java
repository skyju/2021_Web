package com.bitcamp.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String getIndexPage() {
		return "redirect:/index";
	}
	
	@RequestMapping("/index")
	public void getIndex() {
	}
}
