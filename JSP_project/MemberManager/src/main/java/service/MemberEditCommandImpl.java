package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDao;
import member.domain.Member;
import util.ConnectionProvider;

public class MemberEditCommandImpl implements Command {
	
	public int editMember(HttpServletRequest request) {
		
		int resultCnt = 0;
		Member member = (Member) request.getSession().getAttribute("member");
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			member.setPw(request.getParameter("pw"));
			member.setName(request.getParameter("name"));
			
			resultCnt = MemberDao.getInstance().updateMember(conn, member);
			request.getSession().setAttribute("member", member);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return resultCnt;
	}
	
	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		int resultCnt = editMember(request);
		request.setAttribute("result", resultCnt);
		
		return "/WEB-INF/views/editMember.jsp";
	}
}
