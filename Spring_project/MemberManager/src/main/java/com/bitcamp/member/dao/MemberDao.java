package com.bitcamp.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bitcamp.member.domain.*;
import com.bitcamp.member.util.*;

@Repository
public class MemberDao {

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
				list.add(makeMember(rs));
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
		String sql = "insert into member values (default, ?, ?, ?, default, ?)";
		String sql2 = "insert into member values (default, ?, ?, ?, default, default)";
		try {

			if (member.getPhoto() != null) {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getPw());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getPhoto());
			} else {
				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getPw());
				pstmt.setString(3, member.getName());
			}
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
		ResultSet rs = null;
		Member member = null;
		String sql = "select * from member where id = ? and pw = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = makeMember(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(pstmt);
			CloseUtil.close(rs);
		}
		return member;
	}

	public Member selectByIdx(Connection con, int idx) {
		PreparedStatement pstmt = null;
		Member member = null;
		String sql = "select * from member where idx = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(pstmt);
		}
		return member;
	}
	
	// ID 중복여부 확인을 위한 id 값으로 검색 -> 개수 반환
		public int selectById(Connection conn, String id) throws SQLException {
			
			int cnt = 0;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "select count(*) from member where id=?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					cnt = rs.getInt(1);
				}
				
			} finally {
				CloseUtil.close(rs);
				CloseUtil.close(pstmt);
			}
			
			return cnt;
		}

	public int deleteMember(Connection con, int idx) {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from member where idx = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
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
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getIdx());
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(pstmt);
		}
		return resultCnt;
	}
	
	private Member makeMember(ResultSet rs) throws SQLException {
		
		Member member = new Member();
		member.setIdx(rs.getInt("idx"));
		member.setId(rs.getString("id"));
		member.setPw(rs.getString("pw"));
		member.setName(rs.getString("name"));
		member.setDate(rs.getTimestamp("signdate"));
		member.setPhoto(rs.getString("photo"));
		
		return member;	
	}

}