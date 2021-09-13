package com.bitcamp.orl.crew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.SearchType;
import com.bitcamp.orl.crew.service.CrewListViewService;

@RestController
public class CrewListRestController {
	
	@Autowired
	private CrewListViewService service;
	
	@RequestMapping("/crew/searchList")
	@CrossOrigin
	public List<Crew> getSortingName(
			@RequestParam(value="selectSearch", required = false, defaultValue ="")String selectSearch,
			@RequestParam(value="search", required = false, defaultValue = "")String search
			){
		List<Crew> list= null;
		SearchType searchType = new SearchType(selectSearch, search);
		System.out.println(searchType);
		
		if(searchType.getKeyword() !=null && searchType.getKeyword().trim().length() > 0) {
			list= service.getCrewListAll(searchType);
		} else {
			list = service.getCrewListAll();
		}
		
		return list;
	}
}
