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
<link rel="stylesheet" href="<c:url value='/css/crew-list.css'/>">
<link rel="preconnect" href="https://fonts.googleapis.com">
</head>
<body>
	<div class="section">
		<div class="article">
			<h1>MY CREW</h1>
			<div class="article-crew">
				<div>
					<a href="#"><img src="<c:url value='/images/main1.jpg'/>"></a>
				</div>
				<p>내 크루</p>
			</div>
			<div class="article-crew">
				<div>
					<a href="#"><img src="<c:url value='/images/main1.jpg'/>"></a>
				</div>
				<p>내 크루</p>
			</div>
			<div class="article-crew">
				<div>
					<a href="#"><img src="<c:url value='/images/main1.jpg'/>"></a>
				</div>
				<p>내 크루</p>
			</div>


		</div>
		<div class="container">
			<div class="search-box">
				<h1>POPULAR CREW</h1>
				<input class="search-txt" type="text" name=""
					placeholder="Type to search"> <a class="search-btn"
					onclick="menuToggle();" href="#"> <i class="fa fa-search"
					aria-hidden="true"></i>
				</a>
			</div>
			<div class="row justify-content-center">

				<div class="col-md-4">
					<div class="card shadow" style="width: 25rem; height: 35rem;">
						<div class="inner">
							<div>
								<a href='<c:url value="/crew/detail"/>'> <img
									src="<c:url value='/images/main1.jpg'/>" class="card-img-top"
									alt="card image cap"></a>
							</div>
						</div>
						<div class="card-body text-left">
							<h4 class="card-title">크루 이름: 비트캠프</h4>
							<p class="card-text">크루장: ppelpp</p>
							<p class="card-text">크루소개 : 포스코는 1968년 4월1일 산업화라는 국가적 사명을 안고
								출범했습니다. 앞으로도 포스코는 ‘더불어 함께 발전하는 기업시민’ 이라는 경영이념을 바탕으로 신뢰와 존경 받는
								영속기업으로 발전해 나갈 것입니다.</p>
							<a href="#" class="btn btn-success">GO</a>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="card shadow" style="width: 25rem; height: 35rem;">
						<div class="inner">
							<div>
								<a href='<c:url value="/crew/detail"/>'> <img
									src="<c:url value='/images/main1.jpg'/>" class="card-img-top"
									alt="card image cap"></a>
							</div>
						</div>
						<div class="card-body text-left">
							<h4 class="card-title">크루 이름: 비트캠프</h4>
							<p class="card-text">크루장: ppelpp</p>
							<p class="card-text">크루소개 : 포스코는 1968년 4월1일 산업화라는 국가적 사명을 안고
								출범했습니다. 앞으로도 포스코는 ‘더불어 함께 발전하는 기업시민’ 이라는 경영이념을 바탕으로 신뢰와 존경 받는
								영속기업으로 발전해 나갈 것입니다.</p>
							<a href="#" class="btn btn-success">GO</a>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="card shadow" style="width: 25rem; height: 35rem;">
						<div class="inner">
							<div>
								<a href='<c:url value="/crew/detail"/>'> <img
									src="<c:url value='/images/main1.jpg'/>" class="card-img-top"
									alt="card image cap"></a>
							</div>
						</div>
						<div class="card-body text-left">
							<h4 class="card-title">크루 이름: 비트캠프</h4>
							<p class="card-text">크루장: ppelpp</p>
							<p class="card-text">크루소개 : 포스코는 1968년 4월1일 산업화라는 국가적 사명을 안고
								출범했습니다. 앞으로도 포스코는 ‘더불어 함께 발전하는 기업시민’ 이라는 경영이념을 바탕으로 신뢰와 존경 받는
								영속기업으로 발전해 나갈 것입니다.</p>
							<a href="#" class="btn btn-success">GO</a>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card shadow" style="width: 25rem; height: 35rem;">
						<div class="inner">
							<div>
								<a href='<c:url value="/crew/detail"/>'> <img
									src="<c:url value='/images/main1.jpg'/>" class="card-img-top"
									alt="card image cap"></a>
							</div>
						</div>
						<div class="card-body text-left">
							<h4 class="card-title">크루 이름: 비트캠프</h4>
							<p class="card-text">크루장: ppelpp</p>
							<p class="card-text">크루소개 : 포스코는 1968년 4월1일 산업화라는 국가적 사명을 안고
								출범했습니다. 앞으로도 포스코는 ‘더불어 함께 발전하는 기업시민’ 이라는 경영이념을 바탕으로 신뢰와 존경 받는
								영속기업으로 발전해 나갈 것입니다.</p>
							<a href="#" class="btn btn-success">GO</a>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card shadow" style="width: 25rem; height: 35rem;">
						<div class="inner">
							<div>
								<a href='<c:url value="/crew/detail"/>'> <img
									src="<c:url value='/images/main1.jpg'/>" class="card-img-top"
									alt="card image cap"></a>
							</div>
						</div>
						<div class="card-body text-left">
							<h4 class="card-title">크루 이름: 비트캠프</h4>
							<p class="card-text">크루장: ppelpp</p>
							<p class="card-text">크루소개 : 포스코는 1968년 4월1일 산업화라는 국가적 사명을 안고
								출범했습니다. 앞으로도 포스코는 ‘더불어 함께 발전하는 기업시민’ 이라는 경영이념을 바탕으로 신뢰와 존경 받는
								영속기업으로 발전해 나갈 것입니다.</p>
							<a href="#" class="btn btn-success">GO</a>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card shadow" style="width: 25rem; height: 35rem;">
						<div class="inner">
							<div>
								<a href='<c:url value="/crew/detail"/>'> <img
									src="<c:url value='/images/main1.jpg'/>" class="card-img-top"
									alt="card image cap"></a>
							</div>
						</div>
						<div class="card-body text-left">
							<h4 class="card-title">크루 이름: 비트캠프</h4>
							<p class="card-text">크루장: ppelpp</p>
							<p class="card-text">크루소개 : 포스코는 1968년 4월1일 산업화라는 국가적 사명을 안고
								출범했습니다. 앞으로도 포스코는 ‘더불어 함께 발전하는 기업시민’ 이라는 경영이념을 바탕으로 신뢰와 존경 받는
								영속기업으로 발전해 나갈 것입니다.</p>
							<a href="#" class="btn btn-success">GO</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="page">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							<span class="sr-only">Previous</span>
					</a></li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">4</a></li>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
							class="sr-only">Next</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>
	<%@ include file="/WEB-INF/frame/meta-footer.jsp"%>
</body>
</html>