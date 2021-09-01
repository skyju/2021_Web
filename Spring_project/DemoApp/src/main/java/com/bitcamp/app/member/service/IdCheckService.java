package com.bitcamp.app.member.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.app.member.mapper.MemberMapper;

@Service
public class IdCheckService {

	private MemberMapper dao;

	@Autowired
	private SqlSessionTemplate template;

	public String idCheck(HttpServletRequest request) {

		String result = "Y";
		dao = template.getMapper(MemberMapper.class);

		if(dao.selectById(request.getParameter("id"))>0) {
			result = "N";
		}
		return result;
	}

}
