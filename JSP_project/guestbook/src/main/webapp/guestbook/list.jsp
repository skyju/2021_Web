<%@page import="guest.service.MsgListService"%>
<%@page import="guest.domain.MsgListView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//페이지 번호를 받음(되돌아온거면 list_view에서 param으로 넘겨받고, 없다면 1로 시작)
	String pageNumStr = request.getParameter("page");
	int pageNum =  1;
	if(pageNumStr != null) {
		pageNum = Integer.parseInt(pageNumStr);
	}
	
	MsgListView listView = MsgListService.getInstance().getMsgList(pageNum);
	request.setAttribute("listView", listView);
%>
<jsp:forward page="list_view.jsp"/>