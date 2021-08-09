package com.bitcamp.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.member.domain.Member;

@Controller
@RequestMapping("/member/mypage")
public class MypageController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String mypage(
			HttpServletRequest request,
			Model model
			) {
		Member member = (Member) request.getSession().getAttribute("member");
		model.addAttribute("result", member);
		return "member/mypage";
	}
	
}
