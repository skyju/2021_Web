<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//포스트로 받을 때 필수
//사용자가 전달한 데이터의 한글 처리!!!
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/First-Web/loginEx2/css/login.css">
    <title>Login page Copy</title>
</head>

<header>
    <div id="logo" class="text_center">
        <span class="blind">
            <h1>NAVER</h1>
        </span>
    </div>
</header>

<section>
    <form action="myPage.jsp" method="post" name="Login">
        <fieldset class="login_form text_center">
            <legend class="blind" >로그인</legend>
            <input type="text" name="id" value="<%=id%>" class="int" maxlength="41">
            <input type="password" name="pw" placeholder="비밀번호" class="int" maxlength="41">
            <input type="submit" title="로그인" alt="로그인" value="로그인">
            <input type="checkbox">
            <p class="text_left"> 로그인 상태 유지</p>

        </fieldset>
    </form>

    <div class="plus">
        <h2 class="text_center">더욱 간편한 로그인</h2>
        <div class="qr_area">
            <div class="item">
                <input class="QR_login" type="button" value="QR코드 로그인">
            </div>
            <div class="item">
                <input class="disposable_login" type="button" value="일회용 번호 로그인">
            </div>
        </div>
        <div class="extra text_center">
            <p><a href="">아이디 찾기</a></p>
            <p>|</p>
            <p><a href="">비밀번호 찾기</a></p>
            <p>|</p>
            <p><a href="">회원가입</a></p>
        </div>
    </div>

</section>

<footer>
    <div class="plus text_center">
        <img src="http://placehold.it/200x70">
        <p><a href="">이용약관</a></p>
        <p>|</p>
        <p><a href="">개인정보처리방침</a></p>
        <p>|</p>
        <p><a href="">책임의 한계와 법적고지</a></p>
        <p>|</p>
        <p><a href="">회원정보 고객센터</a></p>
    </div>
</footer>
</body>

</html>