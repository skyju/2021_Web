package com.bitcamp.orl.feed.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bitcamp.orl.feed.domain.FeedCommentRequest;
import com.bitcamp.orl.feed.domain.FeedEdit;
import com.bitcamp.orl.feed.service.FeedViewService;
import com.bitcamp.orl.member.domain.MemberDto;

@Controller
public class FeedViewController {
	
	@Autowired
	private FeedViewService viewService;

	@RequestMapping("/feed/feedview/{memberIdx}&{boardIdx}")
	public String getFeedView(
			@PathVariable("memberIdx") int memberIdx,
			@PathVariable("boardIdx") int boardIdx,
			HttpServletRequest request,
			Model model) {
		
		//피드 상세
		model.addAttribute("selectFeedView", viewService.getFeedView(boardIdx));
		
		//memberIdx
		int myIdx = ((MemberDto) request.getSession().getAttribute("memberVo")).getMemberIdx();
		model.addAttribute("boardMemberIdx", memberIdx);
		
		//좋아요
		int likeStatus = viewService.getLikeStatus(myIdx, boardIdx);
		int totalLikeCount = viewService.getTotalLikeCount(boardIdx);
		model.addAttribute("totalLikeCount", totalLikeCount);
		model.addAttribute("likeStatus", likeStatus);

		return "/feed/feedview";

	}

	@RequestMapping(value="/feed/feedview/{memberIdx}&{boardIdx}", method = RequestMethod.POST)
	public String postFeedView(
			@PathVariable("memberIdx") int memberIdx,
			@PathVariable("boardIdx") int boardIdx,
			FeedCommentRequest commentRequest,
			HttpServletRequest request,
			Model model) {
		
		// 댓글 작성 insert
		viewService.insertComment(commentRequest, request);

		return "redirect:/feed/feedview/"+memberIdx+"&"+boardIdx;
	}

}