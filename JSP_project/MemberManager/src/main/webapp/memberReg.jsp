<%@page import="service.MemberRegService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <jsp:useBean id="member" class="domain.Member" />
<jsp:setProperty property="*" name="member" /> --%>
<%
	int resultCnt = MemberRegService.getInstance().regMember(member);
	if (resultCnt > 0) {
%>
<script>
	alert('등록되었습니다.');
	location.href = 'index.jsp';
</script>
<%
	} else {
%>
<script>
	alert('아이디 중복 여부를 확인해주세요. \n입력페이지로 다시 이동합니다.');
	window.history.go(-1);
</script>
<%
	}
%>