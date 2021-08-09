<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
	<ul>
		<c:if test="${sessionScope.member eq null}">
			<li><a href='<c:url value="/member/reg"/>'>회원가입</a></li>
			<li><a href='<c:url value="/member/login"/>'>로그인</a></li>
		</c:if>
		<c:if test="${sessionScope.member ne null }">
			<li><a href='<c:url value="/member/logout"/>'>로그아웃</a></li>
			<li><a href='<c:url value="/member/list_view"/>'>회원리스트</a></li>
		</c:if>
		<li><a href='<c:url value="/member/mypage"/>'>마이페이지</a></li>
		<li><a href='<c:url value="/board/list"/>'>방명록</a></li>
	</ul>
</nav>