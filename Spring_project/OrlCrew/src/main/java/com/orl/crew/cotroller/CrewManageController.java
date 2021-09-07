package com.orl.crew.cotroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orl.crew.domain.Crew;
import com.orl.crew.domain.CrewInsertRequest;
import com.orl.crew.service.CrewManageService;

@Controller
public class CrewManageController {
	
	@Autowired
	CrewManageService service;
	
	@RequestMapping("/crew/edit/{crewIdx}")
	public String getCrewEditPage(
			HttpServletRequest request,
			@PathVariable("crewIdx")int crewIdx,
			Model model
			) {
		boolean chk = service.isHaveAuth(crewIdx, request);
		Crew crew = service.selectCrew(crewIdx);
		
		model.addAttribute("chk", chk);
		model.addAttribute("crew", crew);
		
		return "crew/edit";
	}
	
	@RequestMapping(value = "/crew/edit/{crewIdx}", method = RequestMethod.POST)
	public String crewEdit(
			@PathVariable("crewIdx")int crewIdx,
			CrewInsertRequest crewRequest,
			HttpServletRequest request,
			Model model
			) {
		int result = service.updateCrew(crewRequest, request);
		model.addAttribute("result", result);
		return "";
	}
	
	@RequestMapping("/crew/memberManage/{crewIdx}")
	public String getCrewMemberMngPage(
			HttpServletRequest request,
			@PathVariable("crewIdx")int crewIdx,
			Model model
			) {
		boolean chk = service.isHaveAuth(crewIdx, request);
		Crew crew = service.selectCrew(crewIdx);
		
		model.addAttribute("chk", chk);
		model.addAttribute("crew", crew);
		
		return "crew/memberManage";
	}
	
	@RequestMapping("/crew/remove/{crewIdx}")
	public String getCrewRemovePage(
			HttpServletRequest request,
			@PathVariable("crewIdx")int crewIdx,
			Model model
			) {
		boolean chk = service.isHaveAuth(crewIdx, request);
		Crew crew = service.selectCrew(crewIdx);
		
		model.addAttribute("chk", chk);
		model.addAttribute("crew", crew);
		
		return "crew/remove";
	}
	
	@RequestMapping(value="/crew/remove/{crewIdx}", method = RequestMethod.POST)
	public String crewRemove(
			@PathVariable("crewIdx")int crewIdx,
			@RequestParam("crewName")String crewName,
			Model model
			) {
		int result = service.deleteCrew(crewIdx, crewName);
		model.addAttribute("result", result);
		return "";
	}
	
}
