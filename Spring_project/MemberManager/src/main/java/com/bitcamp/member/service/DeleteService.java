package com.bitcamp.member.service;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.member.dao.MemberDao;
import com.bitcamp.member.domain.Member;
import com.bitcamp.member.util.ConnectionProvider;

@Service
public class DeleteService {
	
	final String UPLOAD_URI = "/uploadfile";
	
	@Autowired
	MemberDao dao;

	public int delete(
			HttpServletRequest request
			) {
		
		int resultCnt = 0;
		Member member = new Member();
		Connection conn = null;
		File file = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			member = (Member)request.getSession().getAttribute("member");
			
			String path = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
			file = new File(path+"/"+member.getPhoto());
			if(file.exists()) {
				file.delete();
			}
			
			resultCnt = dao.deleteMember(conn, member.getIdx());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
	
		return resultCnt;
	}
	
}
