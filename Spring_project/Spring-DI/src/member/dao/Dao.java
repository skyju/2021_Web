package member.dao;

import java.util.Collection;

import member.domain.Member;

public interface Dao {
	
	// ȸ�� �����͸� email�� �˻� -> Member��ü�� ��ȯ
	Member selectByEmail(String email);
	
	// ������ ����
	void insert(Member member);
	
	// update
	void update(Member member);
	
	Collection<Member> selectAll();
}
