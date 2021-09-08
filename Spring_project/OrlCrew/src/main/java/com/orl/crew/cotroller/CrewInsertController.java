package com.orl.crew.cotroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orl.crew.domain.Crew;
import com.orl.crew.domain.CrewCommentCriteria;
import com.orl.crew.domain.CrewInfo;
import com.orl.crew.domain.CrewInsertRequest;
import com.orl.crew.service.CrewDetailService;
import com.orl.crew.service.CrewInsertService;

@Controller
@RequestMapping("/crew/insert")
public class CrewInsertController {

	@Autowired
	private CrewInsertService insertService;
	
	@Autowired
	private CrewDetailService detailService;

	@RequestMapping(method = RequestMethod.GET)
	public String insert() {
		return "crew/insert";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String reg(
			CrewInsertRequest crewRequest, 
			HttpServletRequest request, 
			Model model
			) {
		Crew crew = insertService.insert(crewRequest, request);
		CrewInfo crewinfo = detailService.getCrewInfo(request.getSession(), crew.getCrewIdx());
		CrewCommentCriteria cri = new CrewCommentCriteria(crew.getCrewIdx(), 1);
		
		model.addAttribute("crew", crewinfo);
		model.addAttribute("cri", cri);
		
		return "crew/detail";
	}
}