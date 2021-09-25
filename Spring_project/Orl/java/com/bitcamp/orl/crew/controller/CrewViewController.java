package com.bitcamp.orl.crew.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CrewViewController {
	
	//Crew List view 주는  method
	@RequestMapping("/crew/list")
	public String getCrewList(
			@RequestParam(value="searchType", required = false)String searchType,
			@RequestParam(value="keyword", required = false)String keyword,
			Model model
			) {
		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);
		return "crew/list";
	}

	// 크루 생성 페이지 view 주는 method
	@RequestMapping("/crew/insert")
	public String insert() {
		return "crew/insertForm";
	}

	// Crew Detail Page view 주는 method
	@RequestMapping("/crew/detail")
	public String getCrewDetail(
			@RequestParam("crewIdx") int crewIdx,
			Model model
			) {
		model.addAttribute("crewIdx", crewIdx);
		return "crew/detail";
	}

	// 크루 수정 page를 주는 method
	@RequestMapping("/crew/edit/{crewIdx}")
	public String getCrewEditPage(
			@PathVariable("crewIdx") int crewIdx, 
			Model model) {
		model.addAttribute("crewIdx", crewIdx);
		return "crew/edit";
	}
	
	// 크루원 관리 page를 주는 method
	@RequestMapping("/crew/memberManage/{crewIdx}")
	public String getCrewMemberManagePage(
			@PathVariable("crewIdx") int crewIdx, 
			Model model) {
		model.addAttribute("crewIdx", crewIdx);
		return "crew/memberManage";
	}

	// 크루 삭제 page를 주는 method
	@RequestMapping("/crew/remove/{crewIdx}")
	public String getCrewRemovePage(
			@PathVariable("crewIdx") int crewIdx, 
			Model model) {
		model.addAttribute("crewIdx", crewIdx);
		return "crew/remove";
	}
}
