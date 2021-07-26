<%@page import="domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
	<ul>
		<c:if test="${sessionScope.loginInfo eq null}">
			<li><a href='<c:url value="/regForm.jsp"/>'>회원가입</a></li>
			<li><a href='<c:url value="/loginForm.jsp"/>'>로그인</a></li>
		</c:if>
		<c:if test="${sessionScope.loginInfo ne null }">
			<li><a href='<c:url value="/logout.jsp"/>'>로그아웃</a></li>
			<li><a href='<c:url value="/member_list.jsp"/>'>회원리스트</a></li>
		</c:if>
		<li><a href='<c:url value="/mypage.jsp"/>'>마이페이지</a></li>
	</ul>
</nav>