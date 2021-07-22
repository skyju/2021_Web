package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Member;
import util.CloseUtil;

public class MemberDao {
	private MemberDao() {}
	private static MemberDao dao = new MemberDao();
	public static MemberDao getInstance() {
		return dao == null? new MemberDao() : dao;
	}

	public List<Member> getMemberList(Connection con) {
		Statement stmt = null;
		ResultSet rs = null;
		List<Member> list = null;

		try {
			stmt = con.createStatement();
			String sql = "select * from member";
			rs = stmt.executeQuery(sql);
			list = new ArrayList<Member>();

			while (rs.next()) {
				list.add(new Member(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getTimestamp(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(rs);
			CloseUtil.close(stmt);
		}
		return list;
	}
	
	public int insertMember(Connection con, Member member) {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into member values (default, ?, ?, ?, default)";
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  member.getId());
			pstmt.setString(2,  member.getPw());
			pstmt.setString(3,  member.getName());
			
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(pstmt);
		}
		return resultCnt;
	}
	
	public Member selectByIdPw(Connection con, String id, String pw) {
		PreparedStatement pstmt = null;
		ResultSet rs=  null;
		Member member = null;
		
		String sql = "select * from member where id = ? and pw = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member =  new Member();
				member.setIdx(rs.getInt("idx"));
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setDate(rs.getTimestamp("signdate"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(pstmt);
			CloseUtil.close(rs);
		}
		return member;
	}
	
	public int deleteMember(Connection con, int idx) {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from member where idx = ?";
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  idx);
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(pstmt);
		}
		return resultCnt;
	}
	
	public int updateMember(Connection con, Member member) {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "update member set id = ?, pw = ?, name = ? where idx = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setInt(3, member.getIdx());
			resultCnt = pstmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(pstmt);
		}
		return resultCnt;
	}
	
}