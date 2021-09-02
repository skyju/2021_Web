package com.orl.crew.cotroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.orl.crew.domain.CrewCommentInfo;
import com.orl.crew.domain.CrewInfo;
import com.orl.crew.service.CrewDetailService;

@Controller
public class CrewDetailController {
	
	@Autowired
	CrewDetailService service;
	
	@RequestMapping("/crew/detail/{crewIdx}")
	public String getCrewDetail(
			@PathVariable("crewIdx")int crewIdx,
			HttpSession session,
			Model model
			) {
		
		CrewInfo crewinfo = service.getCrewInfo(session, crewIdx);
		model.addAttribute("crew", crewinfo);
		
		List<CrewCommentInfo> list = service.getCrewComment(crewIdx);
		model.addAttribute("commentList", list);
		
		return "crew/detail";
	}
	
}
