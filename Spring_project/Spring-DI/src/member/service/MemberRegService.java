
package member.service;

import java.util.Date;

import member.dao.Dao;
import member.domain.Member;
import member.domain.RegRequest;

public class MemberRegService {
	
	Dao dao ;
	
	public MemberRegService(Dao dao) {
		this.dao = dao;
		System.out.println("MemberRegService �ν��Ͻ� ����");
	}
	
	public void regMember(RegRequest request) throws Exception {
		
		// �ߺ� �̸��� üũ
		Member member = dao.selectByEmail(request.getEmail());
		
		if(member != null) {
			throw new Exception("�ߺ� �̸��� !!");
		}
		
		Member newMember = new Member(
				0, 
				request.getEmail(), 
				request.getPassword(), 
				request.getName(), 
				new Date());
		
		dao.insert(newMember);
	}

}