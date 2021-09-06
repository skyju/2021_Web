package com.orl.crew.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orl.crew.dao.Dao;
import com.orl.crew.domain.Crew;

@Service
public class CrewManageService {
	
	Dao dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	public Crew selectCrew(
			int crewIdx
			) {
		dao = template.getMapper(Dao.class);
		Crew crew = dao.selectCrew(crewIdx);
		return crew;
	}
	
	public int deleteCrew(
			int crewIdx,
			String crewName
			) {
		
		int resultCnt = 0;
		
		dao = template.getMapper(Dao.class);
		resultCnt = dao.deleteCrew(crewIdx);
		
		return resultCnt;
	}
}
