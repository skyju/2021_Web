<%@page import="cookieUtil.CookieBox"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	/* Cookie[] cookies = request.getCookies();
	if(cookies != null && cookies.length > 0) {
		for(int i = 0 ; i < cookies.length ; i++) { 
			if(cookies[i].getName().equals("name")){
				Cookie cookie = new Cookie("name", URLEncoder.encode("min", "utf-8"));
				response.addCookie(cookie);
			}
		}
	} */
	response.addCookie(CookieBox.createCookie("name", "홍길동"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 수정 페이지</title>
</head>
<body>
	<h1>쿠키 값이 변경되었습니다.</h1>
	<a href="viewCookie.jsp">쿠키 보기</a>
</body>
</html>