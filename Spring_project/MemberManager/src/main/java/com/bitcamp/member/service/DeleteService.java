package com.bitcamp.member.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.member.dao.JdbcTemplateMemberDao;
import com.bitcamp.member.domain.Member;

@Service
public class DeleteService {
	
	final String UPLOAD_URI = "/uploadfile";
	
	@Autowired
	private JdbcTemplateMemberDao dao;

	public int delete(HttpServletRequest request) {
		
		int resultCnt = 0;
		
		try {
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
