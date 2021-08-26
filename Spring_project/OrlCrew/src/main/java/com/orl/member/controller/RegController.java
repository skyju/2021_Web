package com.orl.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orl.member.domain.MemberRequest;
import com.orl.member.service.RegService;

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
			MemberRequest memberRequest, 
			HttpServletRequest request, 
			Model model) {
		int result = regservice.reg(memberRequest, request);
		model.addAttribute("result", result);
		return "member/reg";
	}

}
