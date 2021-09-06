package com.orl.crew.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orl.crew.domain.Crew;
import com.orl.crew.domain.SearchType;
import com.orl.crew.service.CrewRestService;

@RestController
public class CrewListRestController {
	
	@Autowired
	private CrewRestService restService;
	
	@GetMapping("/crew/crewName")
	@CrossOrigin
	public List<Crew> getSortingName(SearchType searchType){
		return restService.getSortingName(searchType);
	}
}
