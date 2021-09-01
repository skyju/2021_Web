'use strict'

$(document).ready(function() {
	
		$('#id').focusin(function() {
			$('#msg').addClass('display_none');
			$('#msg').removeClass('color_blue');
			$('#msg').removeClass('color_red');
			$(this).val('');
		});

		$('#id').focusout(function() {
			// ajax 비동기 통신 -> id를 서버로 보내고 사용가능 유무의 응답 코드를 받는다.
			$.ajax({
				url: 'idcheck',
				type: 'post',
				data: {
					id: $(this).val()
				},
				success: function(data) {
					// data : Y / N
					if (data == 'Y') {
						$('#msg').html('사용가능');
						$('#msg').addClass('color_blue');
						$('#msg').removeClass('display_none');
					} else {
						$('#msg').html('사용불가능');
						$('#msg').addClass('color_red');
						$('#msg').removeClass('display_none');
					}
				},
				error: function(request, status, error) {
					alert('서버 통신에 문제가 발생했습니다. 다시 실행해주세요.');
					console.log(request);
					console.log(status);
					console.log(error);
				}
			});

		});

});