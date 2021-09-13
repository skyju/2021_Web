package com.bitcamp.orl.crew.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.CrewListCriteria;
import com.bitcamp.orl.crew.domain.PageMaker;
import com.bitcamp.orl.crew.domain.SearchType;
import com.bitcamp.orl.crew.service.CrewListViewService;

@Controller
public class CrewListViewController {
	
	@Autowired
	CrewListViewService service;
	
	@RequestMapping("/crew/list")
	public String getCrewList(
			HttpServletRequest request,
			Model model,
			@RequestParam(value="searchType", required = false)String searchType,
			@RequestParam(value="keyword", required = false)String keyword,
			CrewListCriteria cri
			) {
		
		//내 크루 리스트 처리
		List<Crew> myCrewList = null;
		myCrewList = service.getMyCrewList(request);
		
		//페이징 처리
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		int totalNum = service.getCrewCount();
		pageMaker.setTotalCount(totalNum);
		
		//리스트 가져오기+검색
		SearchType st = new SearchType(searchType, keyword);
		List<Crew> allCrewList = service.getCrewListAll(st);
		if(st.getKeyword() !=null && st.getKeyword().trim().length() > 0) {
			allCrewList= service.getCrewListAll(st);
		} else {
			allCrewList = service.getCrewListAll();
		}
		
		model.addAttribute("myCrewList", myCrewList);
		model.addAttribute("list", allCrewList);
		model.addAttribute("pageMaker", pageMaker);
		
		return "crew/list";
	}
	
}
