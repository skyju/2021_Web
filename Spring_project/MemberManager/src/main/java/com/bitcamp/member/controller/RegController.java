package com.bitcamp.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.member.domain.Report;
import com.bitcamp.member.service.RegService;

@Controller
@RequestMapping("/member/reg")
public class RegController {
	
	@Autowired
	private RegService regservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public String regForm() {
		return "member/regForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String reg(
			Report report,
			HttpServletRequest request,
			Model model
			) {
		int result = regservice.reg(report, request);
		model.addAttribute("result", result);
		return "member/reg";
	}
	
}
