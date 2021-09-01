package com.bitcamp.app.member.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.app.member.domain.Member;
import com.bitcamp.app.member.mapper.MemberMapper;

@Service
public class EditService {

	private MemberMapper dao;

	@Autowired
	private SqlSessionTemplate template;

	public int edit(HttpServletRequest request) {

		dao = template.getMapper(MemberMapper.class);
		
		Member member = (Member) request.getSession().getAttribute("member");
		member.setPw(request.getParameter("pw"));
		member.setName(request.getParameter("name"));

		request.getSession().setAttribute("member", member);

		return dao.updateMember(member);
	}

}
