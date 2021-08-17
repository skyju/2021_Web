$(document).ready(function () {
	$('#btnReg1').click(function () {
		var photoFile = $('#photo');
		var file1 = photoFile[0].files[0];

		//console.log(file1);

		var formData = new FormData();

		formData.append("id", $('#id').val());
		formData.append("pw", $('#pw').val());
		formData.append("name", $('#name').val());
		formData.append("photo", file1);
		console.log(formData);
		$.ajax({
			url: '/members/reg1',
			type: 'post',
			data: formData,
			enctype: 'multipart/form-data',
			processData: false,
			contentType: false,
			cache: false,
			success: function (data) {
				console.log(data);
			}
		});
	});


	$('#btnReg2').click(function () {
		var userid = $('#id').val();
		var pw = $('#pw').val();
		var username = $('#name').val();
		var member = {
			memberid: userid,
			password: pw,
			membername: username
		}

		console.log(JSON.stringify(member));

		$.ajax({
			url: '/members/reg2',
			type: 'post',
			data: JSON.stringify(member),
			dataType: 'json',
			contentType: 'application/json',
			success: function (data) {
				console.log(data);
			}
		});
	});
});