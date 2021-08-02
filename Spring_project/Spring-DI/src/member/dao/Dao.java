package member.dao;

import java.util.Collection;

import member.domain.Member;

public interface Dao {
	
	// 회원 데이터를 email로 검색 -> Member객체로 반환
	Member selectByEmail(String email);
	
	// 데이터 저장
	void insert(Member member);
	
	// update
	void update(Member member);
	
	Collection<Member> selectAll();
}
