package com.bitcamp.orl.crew.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CrewViewController {

	// 크루 생성 페이지 view 주는 method
	@RequestMapping("/crew/insert")
	public String insert() {
		return "crew/insertForm";
	}
	
	//Crew Detail Page view 값을 주는 controller
	@RequestMapping("/crew/detail")
	public String getCrewDetail(
			@RequestParam("crewIdx")int crewIdx,
			@RequestParam(value="currentPageNum", required = false, defaultValue = "1")int currentPageNum,
			Model model
			) {
		model.addAttribute("crewIdx", crewIdx);
		return "crew/detail";
	}
}
