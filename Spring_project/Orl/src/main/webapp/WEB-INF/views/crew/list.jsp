<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>크루</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<script defer
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="<c:url value='/css/crew/crew-list.css'/>">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
$(document).ready(function() {
	
	const cList = [];
	
	const searchType = '${searchType}';
	const	keyword = '${keyword}';
	
	function getCrewList() {
		if(keyword == ""){
			$.ajax({
				url : '<c:url value="/crew/searchList"/>',
				type : 'get',
				success : function(data) {
					cList = data;
					crewList(cList);
				}
			});
		} else {
			$.ajax({
				url : '<c:url value="/crew/searchList"/>',
				type : 'get',
				data : {
					searchType: '${searchType}',
					keyword : '${keyword}'
				},
				success : function(data) {
					cList = data;
					crewList(cList);
				}
			});
		}
	}

	$('#nameList').click(function() {
		console.log("이름순으로 정렬");
		cList.sort(function(a, b) {
			a = a.crewName;
			b = b.crewName;
			return a < b ? -1 : a > b ? 1 : 0;
		});
		crewList(cList);
	});

	$('#newestList').click(function() {
		console.log("최신순으로 정렬");
		cList.sort(function(a, b) {
			a = a.crewCreatedate;
			b = b.crewCreatedate;
			return a > b ? -1 : a < b ? 1 : 0;
		});
		crewList(cList);
	});

	$('#oldList').click(function() {
		console.log("오래된순으로 정렬");
		cList.sort(function(a, b) {
			a = a.crewCreatedate;
			b = b.crewCreatedate;
			return a < b ? -1 : a > b ? 1 : 0;
		});
		crewList(cList);
	});
		
}); //document ready end.
	
	
	//출력함수
	function crewList(cList) {
		var ccList = [];
		ccList = cList;
		var html = '<div id="row" class="row">';
		$.each(ccList, function(index, item) {
				html += '<div class="col-md-4">';
				html += '<div class="card shadow">';
				html += '<div class="inner">';
				html += '<div>';
				html += '<a href="<c:url value="/crew/detail?crewIdx='+item.crewIdx+'"/>">';
				html += '<img src="<c:url value="/images/crew/'+item.crewPhoto+'"/>" class="card-img-top" alt="card image cap">';
				html += '<div class="card-body text-left">';
				html += '<h4 class="card-title">크루 이름: '+item.crewName+'</h4>';
				html += '<p class="card-text">크루장: '+item.memberNickName+'</p>';
				html += '<p class="card-text">크루소개 : '+item.crewDiscription+'</p>';
				html += '</div>';
				html += '</a>';
				html += '</div>';
				html += '</div>';
				html += '</div>';
				html += '</div>';
				$('#cList').html(html);
		});
	}
</script>
</head>
<%@ include file="/WEB-INF/frame/default/header.jsp"%>
<body>
	<div class="section">

		<div class="article">
			<h1>MY CREW</h1>
			<div class="article-crew">
				<div>
					<a href="<c:url value='/crew/insert'/>"> <img
						src="<c:url value='/images/crew/new.JPG'/>"></a>
				</div>
				<a href="<c:url value='/crew/insert'/>" class="text-bold">나의 크루
					만들기</a>
			</div>
			<c:if test="${myCrewList ne null and not empty myCrewList}">
				<c:forEach items="${myCrewList}" var="crew">
					<div class="article-crew">
						<div>
							<a href='<c:url value="/crew/detail?crewIdx=${crew.crewIdx}"/>'>
								<img src="<c:url value='/images/crew/${crew.crewPhoto}'/>">
							</a>
						</div>
						<p>${crew.crewName}</p>
					</div>
				</c:forEach>
			</c:if>

		</div>

		<div class="container">
			<div class="search-box">
				<div class="dropdown">
					<h1>CREW</h1>
					<button class="curved" id="nameList">이름순으로 보기</button>
					<button class="curved" id="newestList">최신순으로 보기</button>
					<button class="curved" id="oldList">오랜된 순으로 보기</button>
				</div>
				<form action="" name="frm" id="form">
					<div class="search-drop">
						<div class="searchType">
							<select name="searchType" id="selectSearch">
								<option value="name">크루 이름</option>
								<option value="nickName">닉네임</option>
								<option value="tag">해시태그</option>
							</select>
							<div class="boxSearch">
								<span class="icon">
									<i id="searchType" class="fa fa-search" aria-hidden="true"></i>
								</span>
								<input id="search" class="search" type="text" name="keyword" placeholder="Type to search">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>

		<div id="cList"> 
		</div>

	<ul class="pagination">
    <c:if test="${pageMaker.prev}">
        <li>
            <a href="<c:url value="/crew/list/${pageMaker.makeQuery(pageMaker.startPage - 1)}"/>">[이전]</a>
        </li>
    </c:if>
   
    <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="index">
        <a href="<c:url value="/crew/list/${pageMaker.makeQuery(index)}"/>">[${index }]</a>
    </c:forEach>
 
    <c:if test="${pageMaker.next }">
        <li>
            <a href="<c:url value="/crew/detail/${pageMaker.makeQuery(pageMaker.endPage + 1)}"/>">[다음]</a>
        </li>
    </c:if>  
</ul>


	</div>

	<%@ include file="/WEB-INF/frame/default/footer.jsp"%>
</body>
</html>