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
	public String idCheck(
			HttpServletRequest request, 
			Model model
			) {
		model.addAttribute("result", idchkservice.idCheck(request));
		return "member/idcheck";
	}
	
}
