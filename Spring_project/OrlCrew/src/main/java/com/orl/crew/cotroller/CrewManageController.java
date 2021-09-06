package com.orl.crew.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orl.crew.domain.Crew;
import com.orl.crew.service.CrewManageService;

@Controller
public class CrewManageController {
	
	@Autowired
	CrewManageService service;
	
	@RequestMapping("/crew/edit/{crewIdx}")
	public String getCrewEdit(
			@PathVariable("crewIdx")int crewIdx,
			Model model
			) {
		Crew crew = service.selectCrew(crewIdx);
		model.addAttribute("crew", crew);
		return "crew/edit";
	}
	
	@RequestMapping("/crew/memberManage/{crewIdx}")
	public String getCrewMemberMng(
			@PathVariable("crewIdx")int crewIdx,
			Model model
			) {
		Crew crew = service.selectCrew(crewIdx);
		model.addAttribute("crew", crew);
		return "crew/memberManage";
	}
	
	@RequestMapping("/crew/remove/{crewIdx}")
	public String getCrewRemove(
			@PathVariable("crewIdx")int crewIdx,
			Model model
			) {
		Crew crew = service.selectCrew(crewIdx);
		model.addAttribute("crew", crew);
		return "crew/remove";
	}
	
	@RequestMapping(value="/crew/remove/{crewIdx}", method = RequestMethod.POST)
	public String crewRemove() {
		return "";
	}
	
}
