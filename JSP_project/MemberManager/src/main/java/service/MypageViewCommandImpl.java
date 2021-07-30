package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.domain.Member;

public class MypageViewCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		Member member = (Member) request.getSession().getAttribute("member");
		request.setAttribute("result", member);
		return "/WEB-INF/views/mypage.jsp";
	}

}
