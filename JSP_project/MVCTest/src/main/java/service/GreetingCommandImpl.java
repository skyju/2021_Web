package service;

import javax.servlet.http.HttpServletRequest;

public class GreetingCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request) {
		
		request.setAttribute("result", "안녕하세요");
		return "/WEB-INF/views/greeting.jsp";
	}

}
