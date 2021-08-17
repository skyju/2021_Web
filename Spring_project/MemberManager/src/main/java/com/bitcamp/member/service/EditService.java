package com.bitcamp.member.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.member.dao.Dao;
import com.bitcamp.member.domain.Member;

@Service
public class EditService {

	private Dao dao;

	@Autowired
	private SqlSessionTemplate template;

	public int edit(HttpServletRequest request) {

		dao = template.getMapper(Dao.class);
		
		Member member = (Member) request.getSession().getAttribute("member");
		member.setPw(request.getParameter("pw"));
		member.setName(request.getParameter("name"));

		request.getSession().setAttribute("member", member);

		return dao.updateMember(member);
	}

}
