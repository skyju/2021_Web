package com.bitcamp.member.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.member.domain.Member;
import com.bitcamp.member.domain.Report;
import com.bitcamp.member.service.RegService;
import com.bitcamp.member.service.RestService;

@org.springframework.web.bind.annotation.RestController 
//RestController 말구 그냥 Controller로 쓰면
//@RequestMapping 밑에 @ResponseBody를 적어야함
public class RestController {
	
	@Autowired
	private RestService restService;
	
	@Autowired
	private RegService regService;
	
	@RequestMapping("/members/{id}")
	@CrossOrigin
	public Member getMember(
			@PathVariable("id") int idx
			) {
		Member member = restService.getMember(idx);
		System.out.println(member);
		return member;
	}
	
	@GetMapping("/members")
	@CrossOrigin
	public List<Member> getMembers(){
		return restService.getMembers();
	}
	
	@GetMapping("/members1")
	@CrossOrigin
	public Map<Integer, Member> getMembers1(){
		return restService.getMembers1();
	}
	
	@PostMapping("/members/reg1")
	@CrossOrigin
	public String regMember1(
			Report report,
			HttpServletRequest request
			) {
		return Integer.toString(regService.reg(report, request));
	}
	
	@PostMapping("/members/reg2")
	@CrossOrigin
	public String regMember2(
			@RequestBody Report report,
			HttpServletRequest request
			) {
		return Integer.toString(regService.reg(report, request));
	}
}
