package com.orl.crew.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orl.crew.service.CrewNameCheckService;

@Controller
public class CrewNameCheckController {
	
	@Autowired
	private CrewNameCheckService service;
	
	@RequestMapping(value="crew/nameCheck", method=RequestMethod.POST)
	public String crewNameCheck(
			@RequestParam("crewName") String crewName,
			Model model
			) {
		String result = service.crewNameCheck(crewName);
		model.addAttribute("result", result);
		return "crew/nameCheck";
	}
}
