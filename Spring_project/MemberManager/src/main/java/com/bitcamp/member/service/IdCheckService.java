package com.bitcamp.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.member.dao.MemberDao;
import com.bitcamp.member.util.ConnectionProvider;

@Service
public class IdCheckService {
	
	@Autowired
	MemberDao dao;

	public String idCheck(
			HttpServletRequest request
			) {
		
		String cntCheck;
		int cnt = 0;
		Connection conn = null;
		
		String id = request.getParameter("id");
		
		try {
			conn = ConnectionProvider.getConnection();
			cnt = dao.selectById(conn, id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cntCheck = cnt > 0 ? "N" : "Y";
		return cntCheck;
	}
	
}
