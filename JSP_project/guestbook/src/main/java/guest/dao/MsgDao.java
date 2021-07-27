package guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import guest.domain.Msg;
import guest.jdbc.JdbcUtil;

public class MsgDao {

	private MsgDao() {
	}

	private static MsgDao dao = new MsgDao();

	public static MsgDao getInstance() {
		return dao;
	}
	
	//INSERT 메세지 작성
	public int writeMsg(Connection conn, Msg msg) throws SQLException {
		int resultCnt = 0;
		PreparedStatement pstmt = null;

		String sql = "insert into guestbook_msg (guestname, password, msg) values(?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, msg.getGuestname());
			pstmt.setString(2, msg.getPassword());
			pstmt.setString(3, msg.getMsg());
			resultCnt = pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return resultCnt;
	}
	
	//SELECT 메세지 개수
	public int selectAllCount(Connection conn) throws SQLException {
		int totalCount = 0;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "select count(*) from project.guestbook_msg";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				totalCount = rs.getInt(1);
			}
		} finally {
			JdbcUtil.close(stmt);
			JdbcUtil.close(rs);
		}

		return totalCount;
	}
	
	//SELECT 메세지 리스트
	public List<Msg> selectMsgList(Connection conn, int firstRow, int MsgCntPerPage) throws SQLException {
		List<Msg> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from project.guestbook_msg order by regdate desc limit ?, ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, MsgCntPerPage);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<Msg>();
			while(rs.next()) {
				list.add(new Msg(rs.getInt(1), 
						rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getTimestamp(5)));
			}
			
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		return list;
	}
	
	//SELECT mid로 객체 찾기
	public Msg selectMsgByMid(Connection conn, int mid) throws SQLException {
		Msg msg = null;
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		
		String selectSql = "select * from guestbook_msg where msgid = ?";
		
		try {
			pstmt = conn.prepareStatement(selectSql);
			pstmt.setInt(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				msg = new Msg(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getTimestamp(5));
			}
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		return msg;
	}
	
	/*
	//SELECT 아이디와 비밀번호로 객체 찾기
	public Msg selectMsgByMidPw(Connection conn, int msgid, String password) throws SQLException {
		Msg msg = null;
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		
		String selectSql = "select * from guestbook_msg where msgid = ? and password = ?";
		
		try {
			pstmt = conn.prepareStatement(selectSql);
			pstmt.setInt(1, msgid);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				msg = new Msg(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getTimestamp(5));
			}
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		return msg;
	}
	*/
	
	//DELETE 메세지 삭제
	public int deleteMsg(Connection conn, Msg msg) throws SQLException {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String deleteSql = "delete from guestbook_msg where msgid = ?";
		
		try {
			pstmt = conn.prepareStatement(deleteSql);
			pstmt.setInt(1, msg.getMsgid());
			resultCnt = pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return resultCnt;
	}
}
