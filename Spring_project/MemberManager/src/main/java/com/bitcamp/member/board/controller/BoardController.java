package com.bitcamp.member.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@RequestMapping("/board/list")
	public String getList(
			) {
		return "board/list";
	}
}	