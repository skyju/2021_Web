package com.orl.crew.cotroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.orl.crew.service.CrewMemberRegService;

@Controller
@RequestMapping("/crew/memberReg")
public class CrewMemberRegController {

	@Autowired
	CrewMemberRegService service;
	
	@RequestMapping("/{crewIdx}")
	public String crewMemberReg(
			HttpServletRequest request,
			@PathVariable("crewIdx")int crewIdx,
			Model model
			) {
		
		int resultCnt = service.reg(request, crewIdx);
		model.addAttribute("resultCnt", resultCnt);
		
		return "crew/memberReg";
	}
}
