$(document).ready(function () {
	$('#btnReg1').click(function () {
		var photoFile = $('#photo')[0];

		if(photoFile != null){
			var file1 = photoFile.files[0];
		}

		var formData = new FormData();

		formData.append("id", $('#id').val());
		formData.append("pw", $('#pw').val());
		formData.append("name", $('#name').val());

		if(file1 != null){
			formData.append("photo", file1);
		}

		console.log(formData);

		$.ajax({
			url: '/member/members/reg1',
			type: 'post',
			data: formData,
			enctype: 'multipart/form-data',
			processData: false,
			contentType: false,
			cache: false,
			success: function (data) {
				if(data==1){
					alert('회원가입이 완료되었습니다.');
					location.href = '/member/index';
				} else if(data==0){
					alert("중복된 아이디입니다.");
				}
			}
		});
	});

	$('#btnReg2').click(function () {
		var userid = $('#id').val();
		var pw = $('#pw').val();
		var username = $('#name').val();
		var member = {
			id: userid,
			pw: pw,
			name: username
		}

		console.log(JSON.stringify(member));

		$.ajax({
			url: '/member/members/reg2',
			type: 'post',
			data: JSON.stringify(member),
			dataType: 'json',
			contentType: 'application/json',
			success: function (data) {
				if(data==1){
					alert('회원가입이 완료되었습니다.');
					location.href = '/member/index';
				} else if(data==0){
					alert("중복된 아이디입니다.");
				}
			}
		});
	});
});