package com.orl.crew.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.orl.crew.domain.Crew;
import com.orl.crew.domain.CrewComment;
import com.orl.crew.domain.SearchType;
import com.orl.member.domain.Member;

public interface Dao {
	
	List<Crew> selectAll();
	
	List<Crew> selectAll(String crewName);
	
	//검색을 통한 crew 리스트 
	List<Crew> selectCrewAll(SearchType searchType);
	
	List<Crew> selectMyCrewList(@Param("memberIdx")int memberIdx);

	List<Crew> selectMyCrewList(@Param("memberIdx")int memberIdx, SearchType searchType);
	
	Crew selectCrew(@Param("crewIdx")int crewIdx);
	
	int selectCrewMemberNum(@Param("crewIdx")int crewIdx);
	
	int selectCrewCommentNum(@Param("crewIdx")int crewIdx);
	
	int selectCountMemberToRegCrew(@Param("memberIdx")int memberIdx, @Param("crewIdx")int crewIdx);
	
	Member selectMemberByMemberIdx(@Param("memberIdx")int memberIdx);
	
	List<CrewComment> selectCrewComment(@Param("crewIdx")int crewIdx);
	
	int insertCrewReg(@Param("memberIdx")int memberIdx, @Param("crewIdx")int crewIdx);
	
	int insertCrewComment(@Param("crewComment")String crewComment, @Param("memberIdx")int memberIdx, @Param("crewIdx")int crewIdx);
	
	List <CrewComment> selectCrewCommentPaging(@Param("crewIdx")int crewIdx, @Param("firstRow")int firstRow, @Param("amountPerPage")int amountPerPage);

	int insertCrew(Crew crew);
	
	int selectByCrewName(@Param("crewName")String crewName);
	
	int deleteCrew(@Param("crewIdx")int crewIdx);
	
	int updateCrew(@Param("crewName")String crewName, @Param("crewPhoto")String crewPhoto, @Param("crewDiscription")String crewDiscription, @Param("crewTag")String crewTag);

	int updateCrewWithoutPhoto(@Param("crewName")String crewName, @Param("crewDiscription")String crewDiscription, @Param("crewTag")String crewTag);
	
	
	
}
