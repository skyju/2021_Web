// 흐름 위주 복기 -07 08 수업 
// JQuery로 변경 -07 12 수업

function Member(id, pw, name) { // 1. 생성자: 함수 인 것을 기억할 것 (js에는 클래스가 없으므로)
    this.id = id;
    this.pw = pw;
    this.name = name;
};

let memberArray = [];

$(document).ready(function () {

    if (localStorage.getItem('memberArray')) {
        memberArray = JSON.parse(localStorage.getItem('memberArray'));
    }
    setList();

    $('#joinMemberArea').submit(function () {

        let id = $('#id', this);
        let pw = $('#pw', this);
        let repw = $('#repw', this);
        let name = $('#name', this);

        if (id.val().length < 1) {
            $('#id+#necessary').css('display', 'block');
            $('#id+#necessary').html('<p>필수 입력 사항입니다.</p>');
            return false;
        } else {
            let regexp = /(^\w+)\@(\w+)(\.)(com|co.kr)$/;
            if (!regexp.test(id.val())) {
                $('#id+#necessary').css('display', 'block');
                $('#id+#necessary').html('<p>이메일 형식에 맞게 입력해주세요.</p>');
                return false;
            }
        }

        if (pw.val().length < 1) {
            $('#pw+#necessary').css('display', 'block');
            $('#pw+#necessary').html('<p>필수 입력 사항입니다.</p>');
            return false;
        } else if (pw.val().length < 8 || pw.val().length > 30) {
            $('#pw+#necessary').css('display', 'block');
            $('#pw+#necessary').html('<p>비밀번호는 8자 이상 30자 이하여야 합니다.</p>');
            return false;
        } else if (pw.val().search(/[0-9]/g) < 0 || pw.val().search(/[a-z]/ig) < 0) {
            $('#pw+#necessary').css('display', 'block');
            $('#pw+#necessary').html('<p>비밀번호는 영어와 숫자를 모두 포함해야 합니다.</p>')
            return false;
        }

        if (repw.val().length < 1) {
            $('#repw+#necessary').css('display', 'block');
            $('#repw+#necessary').html('<p>필수 입력 사항입니다.</p>');
            return false;
        }

        if (name.val().length < 1) {
            $('#name+#necessary').css('display', 'block');
            $('#name+#necessary').html('<p>필수 입력 사항입니다.</p>');
            return false;
        } else {
            let regexp = /^[a-zA-Z가-힣]+$/gm;
            if (!regexp.test(name.val())) {
                $('#name+#necessary').css('display', 'block');
                $('#name+#necessary').html('<p>잘못된 입력입니다.</p>');
                return false;
            }
        }

        if (pw.val() != repw.val()) {
            alert('비밀번호가 일치하지 않습니다.');
            return false;
        }
        memberArray.push(new Member(id.val(), pw.val(), name.val()));
        localStorage.setItem('memberArray', JSON.stringify(memberArray));
        alert('등록 완료');

        this.reset();
    });

    $('#id').focus(function () {
        $('#id+#necessary').html('');
        $('#id+#necessary').css('display', 'none');
    });

    $('#pw').focus(function () {
        $('#pw+#necessary').html('');
        $('#pw+#necessary').css('display', 'none');
    });

    $('#repw').focus(function () {
        $('#repw+#necessary').html('');
        $('#repw+#necessary').css('display', 'none');
    });

    $('#name').focus(function () {
        $('#name+#necessary').html('');
        $('#name+#necessary').css('display', 'none');
    });
});

function setList() {
    let tbody = '<tr>';
    if (memberArray.length < 1) {
        tbody += '<td colspan="5">입력 값이 없습니다.</td></tr>';
    } else {
        for (let i = 0; i < memberArray.length; i++) {
            tbody += '<td>' + Number(i + 1) + '</td>';
            tbody += '<td>' + memberArray[i].id + '</td>';
            tbody += '<td>' + memberArray[i].pw + '</td>';
            tbody += '<td>' + memberArray[i].name + '</td>';
            tbody += '<td><a href="javascript:editMember(' + i + ')">수정</a>'
                + ' | <a href="javascript:deleteMember(' + i + ')">삭제</a></td></tr>';
        }
    }
    $('#list').html(tbody);
}

function deleteMember(i) {
    if (confirm('정말 삭제하시겠습니까?')) {
        memberArray.splice(i, 1);
        localStorage.setItem('memberArray', JSON.stringify(memberArray));
        alert('삭제되었습니다.');
        setList();
    }
}

function editMember(i) {

    $('#editMemberArea').css('display', 'block');
    $('#editId').val(memberArray[i].id);
    $('#editPw').val(memberArray[i].pw);
    $('#editName').val(memberArray[i].name);

    $('#closebutton').mouseenter(function () {
        $('#closebutton').css('background', 'rgb(107, 129, 255)');
    });
    $('#closebutton').mouseleave(function () {
        $('#closebutton').css('background', 'rgb(184, 200, 245)');
    });
    $('#closebutton').click(function () {
        $('#editMemberArea').css('display', 'none');
    });

    $('#editMemberArea').submit(function () {

        if ($('#editPw').val().length < 8 || $('#editPw').val().length > 30) {
            alert('비밀번호는 8자 이상 30자 이하여야 합니다.');
            return false;
        } else if ($('#editPw').val().search(/[0-9]/g) < 0 || $('#editPw').val().search(/[a-z]/ig) < 0) {
            alert('비밀번호는 영어와 숫자를 모두 포함해야 합니다.');
            return false;
        }

        if ($('#editPw').val() != $('#editRepw').val()) {
            alert('비밀번호가 일치하지 않습니다.');
            return false;
        }

        if (!(/^[a-zA-Z가-힣]+$/gm.test($('#editName').val()))) {
            alert('이름은 영문 또는 한글로 입력해주세요.');
            return false;
        }

        if (!confirm('수정하시겠습니까?')) {
            return false;
        }
        //localStorage에 반영
        memberArray[i].pw = $('#editPw').val();
        memberArray[i].name = $('#editName').val();
        localStorage.setItem('memberArray', JSON.stringify(memberArray));

        alert('수정되었습니다.');
        setList();
        this.reset;
        $('#editMemberArea').css('display', 'none');
    });
}