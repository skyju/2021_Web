package com.bitcamp.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.member.dao.MemberDao;
import com.bitcamp.member.domain.Member;
import com.bitcamp.member.util.ConnectionProvider;

@Service
public class EditService {
	
	@Autowired
	MemberDao dao;

	public int edit(
			HttpServletRequest request
			) {
		
		int resultCnt = 0;
		Member member = (Member) request.getSession().getAttribute("member");
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			member.setPw(request.getParameter("pw"));
			member.setName(request.getParameter("name"));
			
			resultCnt = dao.updateMember(conn, member);
			request.getSession().setAttribute("member", member);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return resultCnt;
	}
	
}
