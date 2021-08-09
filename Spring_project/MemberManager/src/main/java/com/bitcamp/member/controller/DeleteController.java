package com.bitcamp.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.member.service.DeleteService;

@Controller
@RequestMapping("/member/delete")
public class DeleteController {
	
	@Autowired
	private DeleteService deleteservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public String delete(
			HttpServletRequest request, 
			Model model
			) {
		int result = deleteservice.delete(request);
		model.addAttribute("result", result);
		return "member/delete";
	}
	
}
