package com.bitcamp.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.member.dao.Dao;
import com.bitcamp.member.domain.Member;
import com.bitcamp.member.domain.SearchType;

@Service
public class MemberListViewService {

	private Dao dao;

	@Autowired
	private SqlSessionTemplate template;

	public List<Member> getMemberList(){
		return template.getMapper(Dao.class).selectAll();
	}

	public List<Member> getMemberList(SearchType searchType){
		return template.getMapper(Dao.class).selectMember(searchType);
	}
	
	/*
	public void viewList(HttpServletRequest request) {
		request.setAttribute("result", dao.getMemberList());
	}
	*/
}
