<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 등록</title>
    <link rel="stylesheet" href="/First-Web/loginEx/css/default.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"
        integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
    <script src="jQuery.js"></script>
</head>
<body>
    <header>
        <div id="header">
            <h1>회원 등록 페이지</h1>
        </div>
    </header>
    <section>
        <div id="joinMemberArea">
            <fieldset>
                <legend>회원등록</legend>
                <form action="login.jsp" method="post">
                    <table>
                        <tr>
                            <td>
                                <label for="id">아이디(이메일)</label>
                                <input type="text" id="id" name="id">
                                <div id="necessary"></div>
                            </td>
                            <td>
                                <label for="pw">비밀번호</label>
                                <input type="password" id="pw" name="pw">
                                <div id="necessary"></div>
                            </td>
                            <td>
                                <label for="repw">비밀번호 확인</label>
                                <input type="password" id="repw" name="repw">
                                <div id="necessary"></div>
                            </td>
                            <td>
                                <lable for="name">이름</lable>
                                <input type="text" id="name" name="name">
                                <div id="necessary"></div>
                            </td>
                            <td>
                                <input type="submit" value="등록">
                            </td>
                        </tr>
                    </table>
                </form>
            </fieldset>
        </div>
    </section>
</body>

</html>