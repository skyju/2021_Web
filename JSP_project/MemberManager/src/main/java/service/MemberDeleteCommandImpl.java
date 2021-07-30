package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDao;
import member.domain.Member;
import util.ConnectionProvider;

public class MemberDeleteCommandImpl implements Command {
	
	public int deleteMember(HttpServletRequest request) {
		
		int resultCnt = 0;
		Member member = new Member();
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			member = (Member)request.getSession().getAttribute("member");
			
			resultCnt = MemberDao.getInstance().deleteMember(conn, member.getIdx());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
	
		return resultCnt;
	}
	
	
	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		int result = deleteMember(request);
		request.setAttribute("result", result);
		
		return "/WEB-INF/views/deleteMember.jsp";
	}

}
