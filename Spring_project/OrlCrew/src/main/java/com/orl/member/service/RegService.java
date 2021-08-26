package com.orl.member.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orl.member.dao.Dao;
import com.orl.member.domain.Member;
import com.orl.member.domain.MemberRequest;

@Service
public class RegService {

	private Dao dao;

	@Autowired
	private SqlSessionTemplate template;

	public int reg(
			MemberRequest memberRequest, 
			HttpServletRequest request
			) {

		int resultCnt = 0;

		try {
			Member member = new Member();

			member.setMemberId(memberRequest.getMemberId());
			member.setMemberPw(memberRequest.getMemberPw());
			member.setMemberName(memberRequest.getMemberName());
			member.setMemberEmail(memberRequest.getMemberEmail());
			member.setMemberNickname(memberRequest.getMemberNickname());
			member.setMemberBirth(memberRequest.getMemberBirth());
			
			dao = template.getMapper(Dao.class);
			resultCnt = dao.insertMember(member);

		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultCnt;
	}

}
