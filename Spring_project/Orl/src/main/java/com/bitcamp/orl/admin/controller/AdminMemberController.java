	package com.bitcamp.orl.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminMemberController {

	
	@RequestMapping("/admin/member")
	public String MemberList() {
		
		return "admin/admin_member";
	}
	
}