package com.bitcamp.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bitcamp.member.domain.Member;

@Repository
public class JdbcTemplateMemberDao {
	
	@Autowired
	private JdbcTemplate template;

	public List<Member> getMemberList() {
		return template.query("select * from member", new MemberRowMapper());	
	}

	/*
	public int insertMember(Member member) {
		int resultCnt = 0;
		if(member.getPhoto() != null) {
			resultCnt = template.update("insert into member values (default, ?, ?, ?, default, ?)", 
										member.getId(),
										member.getPw(), 
										member.getName(), 
										member.getPhoto());
		} else {
			resultCnt = template.update("insert into member values (default, ?, ?, ?, default, default)", 
										member.getId(),
										member.getPw(),
										member.getName());
		}
		return resultCnt;
	}
	*/
	
	public int insertMember1(final Member member) {
		int resultCnt = 0;
		final String sql1 = "insert into member values (default, ?, ?, ?, default, ?)";
		final String sql2 = "insert into member values (default, ?, ?, ?, default, default)";
	
		// 자동 증가한 컬럼의 값을 저장할 객체
		KeyHolder keyholder = new GeneratedKeyHolder();
		resultCnt = template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				if(member.getPhoto() != null) {
					PreparedStatement pstmt = con.prepareStatement(sql1, new String[] {"idx"});
					pstmt.setString(1, member.getId());
					pstmt.setString(2, member.getPw());
					pstmt.setString(3, member.getName());
					pstmt.setString(4, member.getPhoto());
					return pstmt;
				} else {
					PreparedStatement pstmt = con.prepareStatement(sql2, new String[] {"idx"});
					pstmt.setString(1, member.getId());
					pstmt.setString(2, member.getPw());
					pstmt.setString(3, member.getName());
					return pstmt;
				}
			}
		}
		,keyholder);
		
		Number idx = keyholder.getKey();
		member.setIdx(idx.intValue());
		
		return resultCnt;

	}
	
	//밑에 꺼도 원래 preparedstatement이기 때문에 위처럼 다 바꿔야함

	public Member selectByIdPw(String id, String pw) {
		return template.queryForObject("select * from member where id = ? and pw = ?"
				, new MemberRowMapper(), id, pw);
	}

	public Member selectByIdx(int idx) {
		return template.queryForObject("select * from member where idx = ?", Member.class, idx);
	}
	
	// ID 중복여부 확인을 위한 id 값으로 검색 -> 개수 반환
	public int selectById(String id) throws SQLException {
		return template.queryForObject("select count(*) from member where id=?", Integer.class, id);
	}
	
	public int deleteMember(int idx) {
		return template.queryForObject("delete from member where idx = ?", Integer.class, idx);
	}

	public int updateMember(Member member) {
		
		return template.queryForObject("update member set id = ?, pw = ?, name = ? where idx = ?", Integer.class, 
				member.getId(), 
				member.getPw(),
				member.getName(),
				member.getIdx());
	}

}