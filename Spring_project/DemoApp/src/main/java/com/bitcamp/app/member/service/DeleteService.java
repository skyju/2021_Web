package com.bitcamp.app.member.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.app.member.domain.Member;
import com.bitcamp.app.member.mapper.MemberMapper;

@Service
public class DeleteService {
	
	final String UPLOAD_URI = "/uploadfile";
	
	private MemberMapper dao;

	@Autowired
	private SqlSessionTemplate template;

	public int delete(HttpServletRequest request) {
		
		int resultCnt = 0;
		
		try {
			
			dao = template.getMapper(MemberMapper.class);
			
			Member member = (Member)request.getSession().getAttribute("member");
			
			String path = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
			File file = new File(path+"/"+member.getPhoto());
			if(file.exists()) {
				file.delete();
			}
			
			resultCnt = dao.deleteMember(member.getIdx());
			
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
	
		return resultCnt;
	}
}
