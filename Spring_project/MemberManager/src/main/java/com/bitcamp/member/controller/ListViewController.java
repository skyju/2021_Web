package com.bitcamp.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.member.domain.Member;
import com.bitcamp.member.domain.SearchType;
import com.bitcamp.member.service.MemberListViewService;

@Controller
@RequestMapping("/member/list_view")
public class ListViewController {
	
	@Autowired
	MemberListViewService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String listView(
			SearchType searchType,
			Model model
			) {
		
		List<Member> list = null;
		if(searchType.getKeyword() !=null 
				&& searchType.getKeyword().trim().length()>0) {
			list = service.getMemberList(searchType);
		} else {
			list = service.getMemberList();
		}
		model.addAttribute("memberList", list);
		return "member/list_view";
	}

}
