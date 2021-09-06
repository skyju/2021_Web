package com.orl.crew.cotroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orl.crew.domain.CrewInsertRequest;
import com.orl.crew.service.CrewInsertService;

@Controller
@RequestMapping("/crew/insert")
public class CrewInsertController {

	@Autowired
	private CrewInsertService insertService;


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

		int insertResult = insertService.insert(crewRequest, request);
		model.addAttribute("result", insertResult);
		
		return "crew/insert";
	}
}