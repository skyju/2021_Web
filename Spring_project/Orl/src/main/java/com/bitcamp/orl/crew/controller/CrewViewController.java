package com.bitcamp.orl.crew.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CrewViewController {

	// 크루 생성 페이지 view 주는 method
	@RequestMapping("/crew/insert")
	public String insert() {
		return "crew/insertForm";
	}
}
