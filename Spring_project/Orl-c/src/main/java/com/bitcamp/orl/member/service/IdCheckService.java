package com.bitcamp.orl.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.member.dao.Dao;

@Service
public class IdCheckService {

	private Dao dao;
	@Autowired
	private SqlSessionTemplate template;
	
	public String idCheck(String id) {
		
		String result ="Y";
		dao=template.getMapper(Dao.class);
		
		if(dao.selectById(id)>0 ||id ==null || id.equals("")) {
			result="N";
		}
		
		
		System.out.println("서비스"+result);
		return result;
	}
	
}
