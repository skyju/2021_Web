<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>naver signUp Copy</title>
    <link rel="stylesheet" href="/First-Web/loginEx2/css/signup.css">
</head>

<body>

    <header>
        <div id="logo" class="text_center">
            <span class="blind">
                <h1>NAVER</h1>
            </span>
        </div>
    </header>

    <section>
        <form action="login.jsp" method="post" name="signUp">
            <fieldset class="signUp_form">
                <legend class="blind">로그인</legend>

                <div class="back_white">
                    <label for="id">아이디</label>
                    <input type="text" name="id" class="text_right" placeholder="@naver.com">
                </div>

                <label for="pw">비밀번호</label>
                <input type="password" name="pw" class="text_right" placeholder="비밀번호">

                <label for="pw2">비밀번호 재확인</label>
                <input type="password" class="text_right" placeholder="비밀번호">

                <div class="back_white">
                    <label for="name">이름</label>
                    <input type="text" name="name">
                </div>

                <div class="birth">
                    <label for="birth">생년월일</label>
                    <div class="table back_white">
                        <div class="table_cell">
                            <input type="text" name="year" placeholder="년(4자)">
                        </div>
                        <div class="table_cell">
                            <select name="month">
                                <option value="1" selected>월</option>
                            </select>
                        </div>
                        <div class="table_cell">
                            <input type="text" name="date" placeholder="일">
                        </div>
                    </div>
                </div>

                <label for="sex">성별</label>
                <select name="sex">
                    <option value="0" selected>성별</option>
                </select>

                <div class="back_white">
                    <label for="email">본인 확인 이메일<p class="weaker">(선택)</p></label>
                    <input type="text" name="email">
                </div>

                <div class="cell_phone">
                    <label for="cell_phone">휴대전화</label>
                    <select name="tel_nation">
                        <option value="82" selected>대한민국 +82</option>
                    </select>
                    <div class="table">
                        <div class="table_cell back_white">
                            <input type="text" name="tel" placeholder="전화번호 입력">
                        </div>
                        <div class="table_cell">
                            <input type="submit" value="인증번호 받기">
                        </div>
                    </div>
                    <input type="text" placeholder="인증번호를 입력하세요">
                </div>
                <div class="final_singup">
                    <input type="submit" title="가입하기" value="가입하기">
                </div>
            </fieldset>
        </form>
    </section>

    <footer>
        <div class="plus text_center">
            <p><a href="">이용약관</a></p>
            <p>|</p>
            <p><a href="">개인정보처리방침</a></p>
            <p>|</p>
            <p><a href="">책임의 한계와 법적고지</a></p>
            <p>|</p>
            <p><a href="">회원정보 고객센터</a></p>
            <br>
            <p>© NAVER Corp.</p>
        </div>
	</table>
    </footer>
</body>
</body>
</html>