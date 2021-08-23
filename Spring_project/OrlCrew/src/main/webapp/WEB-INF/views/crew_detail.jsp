<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/crew_detail.css">
</head>
<body>
	<%@ include file="/WEB-INF/frame/meta-header.jsp"%>
	<div class="section">
		<section>
			<div class="box">
				<div class="crew_section">
					<div class="crew_box">
						<img class="crew_img" src="hiking.jpg">
					</div>
					<div class="crew_box" id="crew_info">
						<h3>크루이름</h3>
						<p class="crew_introduction">크루소개글. 안녕하세요~ 산타자 크루입니다. 함께 산을 오를
							사람을 모집합니다. 반갑습니다. 안녕하세요~ 산타자 크루입니다. 함께 산을 오를 사람을 모집합니다. 반갑습니다.</p>
						<p class="crew_hashtag">#20대 #30대 #서울 #쉬엄쉬엄</p>
						<div class="crew_information">
							<span class="crew_captain">
								<p>크루장</p> 
								<img id="profile" src="default.jpg">
							</span>
							<span class="crew_number">
								<p>크루원</p>
								<p>200</p>
							</span>
							<span class="crew_comment_number">
								<p>댓글</p>
								<p>130</p>
							</span>
						</div>
						<div class="edit_btn">
							<button class="btn btn-secondary">크루 관리</button>
						</div>
						<div class="join_btn">
							<button class="btn btn-secondary">가입하기</button>
						</div>
					</div>
				</div>
				<div class="comment_section">
					<table class="comment_table">
						<tr>
							<td><img id="profile" src="default.jpg"></td>
							<td>
								<p id="nickname">닉네임</p>
							</td>
							<td>
								<p class="content">Lorem ipsum dolor sit amet consectetur,
									adipisicing elit.</p>
							</td>
							<td>
								<p class="date">21-08-18 03:23</p>
							</td>
						</tr>
						<tr>
							<td><img id="profile" src="default.jpg"></td>
							<td>
								<p id="nickname">닉네임</p>
							</td>
							<td>
								<p class="content">Lorem ipsum dolor sit amet consectetur,
									adipisicing elit.</p>
							</td>
							<td>
								<p class="date">21-08-18 03:23</p>
							</td>
						</tr>
						<tr>
							<td><img id="profile" src="default.jpg"></td>
							<td>
								<p id="nickname">닉네임</p>
							</td>
							<td>
								<p class="content">Lorem ipsum dolor sit amet consectetur,
									adipisicing elit.</p>
							</td>
							<td>
								<p class="date">21-08-18 03:23</p>
							</td>
						</tr>
						<tr>
							<td colspan="4">
								<ul class="pagination">
									<li class="page-item"><a class="page-link" href="#">&lt</a></li>
									<li class="page-item"><a class="page-link" href="#">1</a></li>
									<li class="page-item"><a class="page-link" href="#">2</a></li>
									<li class="page-item"><a class="page-link" href="#">3</a></li>
									<li class="page-item"><a class="page-link" href="#">4</a></li>
									<li class="page-item"><a class="page-link" href="#">5</a></li>
									<li class="page-item"><a class="page-link" href="#">&gt</a></li>
								</ul>
							</td>
						</tr>
					</table>
				</div>
				<div class="input_section">
					<input type="text" class="form-control"> <input
						type="submit" value="게시" class="btn1 btn-light form-control">
				</div>
			</div>
		</section>
	</div>
</body>
</html>