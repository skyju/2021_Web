<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <title>내 정보 수정</title>
	<div id="editMemberArea" style="display: none;">
            <fieldset>
                <legend>데이터 수정</legend>
                <div id="close"><input type="button" id="closebutton" value="닫기"></div>
                <form>
                    <table>
                        <tr>
                            <td>
                                <label for="editId">아이디(이메일)</label>
                                <input type="text" id="editId" disabled>
                                <input type="hidden" id="index">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="editPw">비밀번호</label>
                                <input type="password" id="editPw" required>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="editRepw">비밀번호 확인</label>
                                <input type="password" id="editRepw" required>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="editName">이름</label>
                                <input type="text" id="editName" required>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="submit" value="수정">
                            </td>
                        </tr>
                    </table>
                </form>
            </fieldset>
        </div>