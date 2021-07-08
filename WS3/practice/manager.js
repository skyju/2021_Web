
// 회원의 정보: 아이디, 비밀번호, 이름
// Member -> 생성자 함수를 정의

function Member(id, pw, name) {
    this.userID = id;
    this.pw = pw;
    this.userName = name;
}
// 객체가 가지는 메소드는 공통으로 사용 ->
// prototype

Member.prototype.makeHtml = function () {
    return '[id: ' + this.userID + ' , pw: ' + this.pw + ' , name: ' + this.userName + ']'
}

// 회원 정보 저장 배열
let members = []; //new Array();
// 배열 -> JSON(문자열) -> localStorage에 저장, 수정, 삭제
// setItem('members', JSON.stringify(members))


// 사용자가 입력한 정보를 가지고 Member객체를 생성
// submit 이벤트 연결

window.onload = function () {
    //localStorage에 저장된 데이터가 있는지 확인하고
    //localStorage.getItem('members') 없으면 null 반환
    if (localStorage.getItem('members') == null) {
        // 배열 members를 저장
        localStorage.setItem('members', JSON.stringify(members));
    } else {
        members = JSON.parse(localStorage.getItem('members'));
        //JSON문자열 -> 객체로 반환
        setList();
    }

    // 사용자가 입력한 값 캐스팅
    let userID = document.querySelector('#userID');
    let pw = document.querySelector('#pw');
    let repw = document.querySelector('#repw');
    let userName = document.querySelector('#userName');

    // regForm casting
    let regForm = document.getElementById('regForm');

    regForm.onsubmit = function () {

        if (userID.value.trim().length < 1) {
            //alert('아이디를 입력해주세요');
            document.querySelector('#userID+div.msg').innerHTML = '필수 항목 입니다.';
            document.querySelector('#userID+div.msg').style.display = 'block';
            return false;
        }

        if (pw.value.trim().length < 1 || repw.value.trim().length < 1) {
            document.querySelector('#pw+div.msg').innerHTML = '필수 항목 입니다.';
            document.querySelector('#pw+div.msg').style.display = 'block';
            return false;
        }

        // 비밀번호 확인 
        if (pw.value.trim() != repw.value.trim()) {
            document.querySelector('#repw+div.msg').innerHTML = '비밀번호가 일치하지 않습니다.';
            document.querySelector('#repw+div.msg').style.display = 'block';
            return false;
        }

        if (userName.value.trim().length < 1) {
            document.querySelector('#userName+div.msg').innerHTML = '필수 항목 입니다.';
            document.querySelector('#userName+div.msg').style.display = 'block';
            return false;
        }

        //배열에 사용자 정보를 추가
        members.push(new Member(userID.value, pw.value, userName.value));
        alert('등록되었습니다.');

        // localStorage에 저장
        localStorage.setItem('members', JSON.stringify(members));

        // 입력된 값 지우기
        this.reset();

        // 리스트 세팅
        setList();

        return false;
    }

    userID.addEventListener('focus', function () {
        document.querySelector('#userID+div.msg').innerHTML = '';
        document.querySelector('#userID+div.msg').style.display = 'none';
    });

    pw.addEventListener('focus', function () {
        document.querySelector('#pw+div.msg').innerHTML = '';
        document.querySelector('#pw+div.msg').style.display = 'none';
    });

    repw.addEventListener('focus', function () {
        document.querySelector('#repw+div.msg').innerHTML = '';
        document.querySelector('#repw+div.msg').style.display = 'none';
        repw.value = '';
    });

    userName.addEventListener('focus', function () {
        document.querySelector('#userName+div.msg').innerHTML = '';
        document.querySelector('#userName+div.msg').style.display = 'none';
    });
}


// 배열에 있는 요소들을 테이블에 행을 만들어 출력
function setList() {

    let tbody = '';
    console.log(members.length);
    
    if (members.length < 1) {
        tbody += '<tr>';
        tbody += '  <td colspan="5">회원이 없습니다.</td>';
        tbody += '</tr>';
    } else {
        for (let i = 0; i < members.length; i++) {
            tbody += '<tr>'
            tbody += '  <td>' + (Number(i + 1)) + '</td>'
            tbody += '  <td>' + members[i].userID + '</td>';
            tbody += '  <td>' + members[i].pw + '</td>';
            tbody += '  <td>' + members[i].userName + '</td>';
            tbody += '  <td><a href="javascript:editMember(' + i + ')">수정</a> | '
                + '<a href="javascript:deleteMember(' + i + ')">삭제</a></td>';
            tbody += '</tr>';
        }
    }

    document.querySelector('#list').innerHTML = tbody;
}

function deleteMember(index) {
    // 배열의 index 요소를 삭제
    // index에서 시작해서 count 만큼의 요소를 삭제하고 남은 요소를 반환
    // splice(index, 1)

    let member = members[index]
    if (confirm('삭제하시겠습니까?')) {

        // 배열 삭제
        members.splice(index, 1);
        // 삭제 현황을 localStorage에 배열 통째로 저장
        localStorage.setItem('members', JSON.stringify(members));

        // 안되는 이유:
        // 배열 요소가 아니라 key값 참조해서 삭제, (members 통째로 날라감)
        // localStorage.removeItem('members');

        alert('삭제되었습니다.');
        setList();
    }
}

function editMember(index) {

    // 수정 폼 영역이 노출되어야 한다
    document.querySelector('#editFormArea').style.display = 'block';

    // editForm의 태그들의 value  값을 세팅
    let editUserId = document.querySelector('#editId');
    let editPw = document.querySelector('#editPw');
    let editRepw = document.querySelector('#editRepw');
    let editName = document.querySelector('#editName');
    let editIdx = document.querySelector('#index');

    // 이전 데이터를 폼에 세팅
    editUserId.value = members[index].userID;
    editPw.value = members[index].pw;
    editRepw.value = members[index].repw;
    editName.value = members[index].userName;
    editIdx.value = index;

    document.querySelector('#div_close').onclick = function () {
        this.reset;
        document.querySelector('#editFormArea').style.display = 'none';
    }

    document.querySelector('#editForm').onsubmit = function () {
        // let member = new Member(editUserId, editPw, editName);
        if (editPw.value != editRepw.value) {
            alert('비밀번호가 일치하지 않습니다.');
            return false;
        }
        if (!confirm('수정하시겠습니까?')) {
            return false;
        }

        members[editIdx.value].pw = editPw.value;
        members[editIdx.value].userName = editName.value;
        alert('수정되었습니다.');

        this.reset;
        document.querySelector('#editFormArea').style.display = 'none';

        // 수정 현황을 localStorage에 저장
        localStorage.setItem('members', JSON.stringify(members));

        setList();

        return false;
    }
}
