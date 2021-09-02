package com.orl.crew.cotroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orl.crew.domain.CrewCommentInfo;
import com.orl.crew.domain.CrewInfo;
import com.orl.crew.service.CrewCommentService;

@RestController
public class CrewCommentRestController {
	
	@Autowired
	CrewCommentService commentService;
	
	@RequestMapping("/crew/getCommentInfo")
	@CrossOrigin
	public List<CrewCommentInfo> getCommentList(
			HttpServletRequest request,
			@RequestParam("crewIdx")int crewIdx
			){
		CrewInfo info = (CrewInfo) request.getSession().getAttribute("crew");
		List<CrewCommentInfo> list = commentService.getCrewComment(info.getCrewIdx());
		
		return list;
	}
	
	@RequestMapping("/crew/commentInsert")
	@CrossOrigin
	public int insertComment(
			@RequestParam("crewComment") String crewComment,
			@RequestParam("crewIdx") int crewIdx,
			HttpSession session
			) {
		return commentService.insertCrewComment(crewComment, session, crewIdx);
	}
}
