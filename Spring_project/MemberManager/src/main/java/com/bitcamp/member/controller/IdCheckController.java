package com.bitcamp.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.member.service.IdCheckService;

@Controller
@RequestMapping("/member/idcheck")
public class IdCheckController {
	
	@Autowired
	private IdCheckService idchkservice;
	
	@RequestMapping(method = RequestMethod.POST)
	public String delete(
			HttpServletRequest request, 
			Model model
			) {
		String result = idchkservice.idCheck(request);
		model.addAttribute("result", result);
		return "member/idcheck";
	}
	
}
