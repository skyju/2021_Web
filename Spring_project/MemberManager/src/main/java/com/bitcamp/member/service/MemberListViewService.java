package com.bitcamp.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.member.dao.MemberDao;
import com.bitcamp.member.util.CloseUtil;
import com.bitcamp.member.util.ConnectionProvider;

@Service
public class MemberListViewService {
	
	@Autowired
	MemberDao dao;

	public void viewList(
			HttpServletRequest request
			) {
		
		Connection conn = null;
		
		try{
			conn = ConnectionProvider.getConnection();
			request.setAttribute("result", dao.getMemberList(conn));
		
		} catch(SQLException e){
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			CloseUtil.close(conn);
		}
	}
	
}
