package com.bitcamp.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.member.service.EditService;

@Controller
@RequestMapping("/member/edit")
public class EditController {
	
	@Autowired
	private EditService editservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public String editForm() {
		return "member/editForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String edit(
			HttpServletRequest request, 
			Model model
			) {
		int result = editservice.edit(request);
		model.addAttribute("result", result);
		return "member/edit";
	}
	
}
