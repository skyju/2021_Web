package com.bitcamp.member.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.member.dao.JdbcTemplateMemberDao;
import com.bitcamp.member.domain.Member;

@Service
public class EditService {

	@Autowired
	private JdbcTemplateMemberDao dao;

	public int edit(HttpServletRequest request) {

		int resultCnt = 0;
		Member member = (Member) request.getSession().getAttribute("member");
		member.setPw(request.getParameter("pw"));
		member.setName(request.getParameter("name"));

		resultCnt = dao.updateMember(member);
		request.getSession().setAttribute("member", member);

		return resultCnt;
	}

}
