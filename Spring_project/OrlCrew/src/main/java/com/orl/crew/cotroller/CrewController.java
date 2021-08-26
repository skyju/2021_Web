package com.orl.crew.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CrewController {
	
	@RequestMapping("/crew/list")
	public String getCrewList() {
		return "crew/list";
	}
	
	@RequestMapping("/crew/detail")
	public String getCrewDetail() {
		return "crew/detail";
	}
	
	@RequestMapping("/crew/edit")
	public String getCrewEdit() {
		return "crew/edit";
	}
	
	@RequestMapping("/crew/memberManage")
	public String getCrewMemberMng() {
		return "crew/memberManage";
	}
	
	@RequestMapping("/crew/remove")
	public String getCrewRemove() {
		return "crew/remove";
	}
	
}
