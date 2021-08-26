<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<%@ include file="/WEB-INF/frame/meta-header.jsp"%>
<link rel="stylesheet" href="<c:url value='/css/crew-detail.css'/>">
</head>
<body>
	<div class="section">
		<section>
			<div class="box">
				<div class="card">
					<img src="<c:url value='/images/hiking2.jpg'/>"
						class="card-img-top" alt="...">
					<div class="card-body">
						<div class="crew_name_section">
							<h3 class="card-title">산타</h3>
							<a href='<c:url value="/crew/edit"/>'
								class="btn btn-sm color_blue text_bold">크루 관리</a>
						</div>
						<p class="card-text">크루소개글. 안녕하세요~ 산타자 크루입니다. 함께 산을 오를 사람을
							모집합니다. 반갑습니다.</p>
						<p class="crew_hashtag">#20대 #30대 #서울 #쉬엄쉬엄</p>
						<div class="crew_information">
							<span class="crew_captain">
								<p class="text_bold">크루장</p> <img id="profile"
								src="<c:url value='/images/default.jpg'/>">
							</span> <span class="crew_number">
								<p class="text_bold">크루원</p>
								<p>200</p>
							</span> <span class="crew_comment_number">
								<p class="text_bold">댓글</p>
								<p>130</p>
							</span>
						</div>
					</div>
				</div>
				<div class="comment_section">
					<div class="comment_table">
						<div>
							<table>
								<tr>
									<td><img id="profile"
										src="<c:url value='/images/default.jpg'/>"></td>
									<td>
										<p id="nickname">닉네임</p>
										<p class="content">Lorem ipsum dolor sit amet consectetur,
											adipisicing elit. Lasem alsit slikasandra met sln
											concenstrated ferspon loawe yoose.</p>
										<p class="date">2021.08.18 03:23</p>
									</td>
								</tr>
								<tr>
									<td><img id="profile"
										src="<c:url value='/images/default.jpg'/>"></td>
									<td>
										<p id="nickname">닉네임</p>
										<p class="content">Lorem ipsum dolor sit amet consectetur,
											adipisicing elit.</p>
										<p class="date">2021.08.18 03:23</p>
									</td>
								</tr>
								<tr>
									<td><img id="profile"
										src="<c:url value='/images/default.jpg'/>"></td>
									<td>
										<p id="nickname">닉네임</p>
										<p class="content">Lorem ipsum dolor sit amet consectetur,
											adipisicing elit.</p>
										<p class="date">2021.08.18 03:23</p>
									</td>
								</tr>
							</table>
						</div>
					</div>
					<div class="input_section">
						<div>
							<ul class="pagination">
								<li class="page-item"><a class="page-link" href="#">&lt</a></li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#">4</a></li>
								<li class="page-item"><a class="page-link" href="#">5</a></li>
								<li class="page-item"><a class="page-link" href="#">&gt</a></li>
							</ul>
						</div>
						<div class="input_control">
							<div>
								<input type="text" class="form-control">
							</div>
							<div>
								<input type="submit" value="게시"
									class="btn1 btn-light form-control">
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
	<%@ include file="/WEB-INF/frame/meta-footer.jsp"%>
</body>
</html>