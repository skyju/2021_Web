package com.bitcamp.orl.crew.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.orl.crew.domain.CrewInfo;
import com.bitcamp.orl.crew.service.CrewCommentService;
import com.bitcamp.orl.crew.service.CrewDetailService;

@Controller
public class CrewCommentController {
	
	@Autowired
	CrewCommentService service;
	
	@Autowired
	CrewDetailService detailService;
	
	@RequestMapping("/crew/commentDelete/{crewCommentIdx}&{crewIdx}")
	public String CommentDelete(
			@PathVariable("crewCommentIdx")int crewCommentIdx,
			@PathVariable("crewIdx")int crewIdx,
			Model model,
			HttpSession session
			) {
		int result = service.deleteCrewComment(crewCommentIdx);
		CrewInfo crewinfo = detailService.getCrewInfo(session, crewIdx);
 		model.addAttribute("resultCnt", result);
 		model.addAttribute("crew", crewinfo);
		return "crew/commentDelete";
	}
}
