package ncs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.JdbcUtil;

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
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		return list;
	}
	
	public int insertMember(Connection con, Member member) {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into member values (default, ?, ?, ?, ?)";
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  member.getId());
			pstmt.setString(2,  member.getPw());
			pstmt.setString(3,  member.getName());
			pstmt.setTimestamp(4,  member.getDate());
			
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return resultCnt;
	}
}