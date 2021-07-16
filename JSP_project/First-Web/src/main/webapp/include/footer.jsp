<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<footer class="text_left div_algin_center">
	<p>
		이메일: <%= request.getParameter("email") %>, 전화번호 : <%= request.getParameter("tel") %>
	</p>
</footer>