package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDao;
import util.CloseUtil;
import util.ConnectionProvider;

public class MemberListViewCommandImpl implements Command {
	
	public void viewMemberList(HttpServletRequest request) {
		Connection conn = null;
		MemberDao dao = MemberDao.getInstance();
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
	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		viewMemberList(request);
		return "/WEB-INF/views/list_view.jsp";
	}

}
