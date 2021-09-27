package com.bitcamp.orl.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminFeedController {

	@RequestMapping("/admin/feed")
	public String FeedList() {
		
		return "admin/admin_feed";
	}
	
	
}
