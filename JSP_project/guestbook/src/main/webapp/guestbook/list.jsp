<%@page import="guest.service.MsgListService"%>
<%@page import="guest.domain.MsgListView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//사용자로부터 페이지 번호를 받는다. list.jsp?page=?
	String pageNumStr = request.getParameter("page");
	int pageNum =  1;
	if(pageNumStr != null) {
		pageNum = Integer.parseInt(pageNumStr);
	}
	
	MsgListView listView = MsgListService.getInstance().getMsgList(pageNum);
	request.setAttribute("listView", listView);
%>
<jsp:forward page="list_view.jsp"/>