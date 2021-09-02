package com.orl.crew.cotroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.orl.crew.domain.CrewInfo;
import com.orl.crew.service.CrewDetailService;

@Controller
@RequestMapping("/crew/detail")
public class CrewDetailController {
	
	@Autowired
	CrewDetailService service;
	
	@RequestMapping("/{crewIdx}")
	public String getCrewDetail(
			@PathVariable("crewIdx")int crewIdx,
			HttpServletRequest request,
			Model model
			) {
		
		CrewInfo crewinfo = service.getCrewInfo(request.getSession(), crewIdx);
		model.addAttribute("crew", crewinfo);
		model.addAttribute("crewIdx", crewIdx);
		return "crew/detail";
	}
	
}