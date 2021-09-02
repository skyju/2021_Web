package com.orl.crew.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orl.crew.dao.Dao;
import com.orl.crew.domain.Crew;
import com.orl.crew.domain.CrewComment;
import com.orl.crew.domain.CrewCommentInfo;
import com.orl.crew.domain.CrewInfo;
import com.orl.member.domain.Member;

@Service
public class CrewDetailService {
	
	private Dao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public CrewInfo getCrewInfo(
			HttpSession session, 
			int crewIdx
			) {
		
		CrewInfo crewinfo = getCrew(crewIdx).crewToCrewInfo();
		Member member = (Member)session.getAttribute("member");
		
		crewinfo.setCrewMemberNum(getCrewMemberNum(crewIdx));
		crewinfo.setCrewCommentNum(getCrewCommentNum(crewIdx));
		
		if(member != null) {
			crewinfo.setIsReg(getIsCrewMember(member.getMemberIdx(), crewIdx));
		} else {
			crewinfo.setIsReg(false);
		}
		
		return crewinfo;
	}
	
	public Crew getCrew(int crewIdx) {
		Crew crew = null;
		dao = template.getMapper(Dao.class);
		crew = dao.selectCrew(crewIdx);
		return crew;
	}
	
	public int getCrewMemberNum(int crewIdx) {
		dao = template.getMapper(Dao.class);
		int crewMemberNum = dao.selectCrewMemberNum(crewIdx);
		return crewMemberNum;
	}
	
	public int getCrewCommentNum(int crewIdx) {
		dao = template.getMapper(Dao.class);
		int crewCommentNum = dao.selectCrewCommentNum(crewIdx);
		return crewCommentNum;
	}
	
	public boolean getIsCrewMember(int memberIdx, int crewIdx) {
		boolean chk = false;
		dao = template.getMapper(Dao.class);
		int chkInt = dao.selectCountMemberToRegCrew(memberIdx, crewIdx);
		if(chkInt != 0) {
			chk = true;
		}
		return chk;
	}
	
	public List<CrewCommentInfo> getCrewComment(int crewIdx) {
		dao = template.getMapper(Dao.class);
		
		List<CrewComment> list = dao.selectCrewComment(crewIdx);
		List<CrewCommentInfo> infoList = null;
		if(list != null) {
			for(int i = 0 ; i < list.size() ; i++) {
				CrewCommentInfo info = list.get(i).CommentToInfo();
				Member commentMember = getCommentMember(list.get(i).getMemberIdx());
				info.setMemberNickName(commentMember.getMemberNickname());
				info.setMemberProfile(commentMember.getMemberProfile());
				infoList.add(info);
			}
		}
		return infoList;
	}
	
	public Member getCommentMember(int memberIdx) {
		dao = template.getMapper(Dao.class);
		return dao.selectCommentMember(memberIdx);
	}
}
