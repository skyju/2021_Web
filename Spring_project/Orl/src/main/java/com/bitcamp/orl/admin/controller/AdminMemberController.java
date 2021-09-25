package com.bitcamp.orl.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminMemberController {

	
	@RequestMapping("/admin/member")
	public String MemberList() {
		
		return "admin/admin_member";
	}
	
	@RequestMapping("/admin/member/delete")
	public String MemberDelete(@RequestParam("memberIdx")int memberIdx, Model model) {
		
		model.addAttribute("memberIdx",memberIdx);
		
		return "admin/admin_memberDelete";
	}
	
}