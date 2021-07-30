package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDao;
import util.ConnectionProvider;

public class IdCheckCommandImpl implements Command {
	
	String cntCheck;
	String id;
	
	public String idCheck(HttpServletRequest request) {
		//String result = "N";
		
		int cnt = 0;
		id = request.getParameter("id");
		
		Connection conn = null;
		MemberDao dao = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			
			cnt = dao.selectById(conn, id);
			
			//result = cnt > 0 ? "N" : "Y";
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		cntCheck = cnt > 0 ? "N" : "Y";
		
		return cntCheck;
	}

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		idCheck(request);
		request.setAttribute("result", cntCheck);
		return "/WEB-INF/views/idcheck.jsp";
	}
	
}