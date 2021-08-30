package com.orl.crew.cotroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orl.crew.domain.Crew;
import com.orl.crew.service.CrewListViewService;

@Controller
@RequestMapping("/crew/list")
public class CrewListViewController {
	
	@Autowired
	CrewListViewService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getCrewList(
			HttpServletRequest request,
			Model model
			) {
		
		//내 크루 리스트 처리//
		List<Crew> myCrewList = null;
		myCrewList = service.getMyCrewList(request);
		model.addAttribute("myCrewList", myCrewList);
		
		//전체 크루 리스트 처리//
		List<Crew> crewListAll = null;
		crewListAll = service.getCrewListAll();
		model.addAttribute("crewListAll", crewListAll);
		
		return "crew/list";
	}
	
}
