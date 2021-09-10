<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>크루 상세</title>
<link rel="stylesheet" href="<c:url value='/css/crew/crew-detail.css'/>">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<script defer
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>

	// 페이징 road하지말고 ajax로 비동기통신3
	// 토글 밖에 클릭하면 꺼지게 (body)에 걸어서
	// 클래스에 번호일일히 붙이지 않는 방법 -> on 으로 위에 태그로 잡아서 처리
	// 검색/페이징
	// 부트 (el -> timeleaf)
	
	$(document).ready(function(){
		
		if('${crew.crewTag}' == null){
			return;
		} else {
			var str = [];
			const crewTagArr = '${crew.crewTag}';
			str = crewTagArr.split(",");
			var html = "";
			for(var idx = 0 ; idx < str.length ; idx++){
				html += '<li class="tag-item">#'+str[idx]+" </li>";
			}
			$("#crewHashTag").html(html);
		}
		
		commentList(1);
		
		//댓글 입력
		$('#submit').click(function(){
			var formData = new FormData();
			formData.append("crewIdx", $('#crewIdx').val());
			formData.append("crewComment", $('#crewComment').val());
			$.ajax({
				url: 'http://localhost:8080/orl/crew/commentInsert',
				type: 'post',
				data: formData,
				processData: false,
				contentType: false,
				cache: false,
				success : function(data){
					if(data==0){
						alert('로그인 여부를 확인해주세요.');
					}
					commentList(1);
				}
			})
		});
		
		//크루 가입
		$('#joinToCrew').on('click', 'button', function(){
			
			if('${sessionScope.member.memberIdx}'==''){
				window.location.href="<c:url value='/member/login'/>";
			} else {
				$.ajax({
					url: 'http://localhost:8080/orl/crew/joinToCrewMemberList',
					type: 'get',
					data: {
						memberIdx : '${sessionScope.member.memberIdx}',
						crewIdx : '${crew.crewIdx}'
					},
					success : function(data){
						if(data==0){
							alert('가입에 실패했습니다.');
						} else if(data==1){
							alert('크루에 가입하셨습니다.');
							window.location.href="<c:url value='/crew/detail?crewIdx=${crew.crewIdx}&currentPageNum=1'/>";
						}
					}
				});	
			}
		});
		
		//크루 탈퇴
		$('#outFromCrew').on('click', 'button', function(){
			$.ajax({
				url: 'http://localhost:8080/orl/crew/deleteCrewMemberFromList',
				type: 'get',
				data: {
					memberIdx : '${sessionScope.member.memberIdx}',
					crewIdx : '${crew.crewIdx}'	
				},
				success : function(data){
					if(data==0){
						alert('탈퇴에 실패했습니다.');
					} else if(data==1){
						alert('해당 크루를 탈퇴했습니다.');
						window.location.href="<c:url value='/crew/detail?crewIdx=${crew.crewIdx}&currentPageNum=1'/>"
					}
				}
			});	
		});
		
		
	}); //document ready 끝
	
	//토글 관리
	function commentToggle(parameter){
		const toggleMenu = document.querySelector('.commentMenu'+parameter+'');
		toggleMenu.classList.toggle('active');
		var html = '<li><a href="#">수정</a></li>';
		html += '<li><a href="javascript:deleteComment('+parameter+')">삭제</a>';
		$('#commentMenu'+parameter+'').html(html);
	}
	
	//댓글 삭제
	function deleteComment(parameter){
		$.ajax({
			url: 'http://localhost:8080/orl/crew/commentDelete',
			type: 'GET',
			data: {crewCommentIdx : parameter},
			success: function(data){
				commentList(1);
			}
		});
	}
	
	//출력함수
	function commentList(parameter){
		$.ajax({
			url: 'http://localhost:8080/orl/crew/getCommentInfo',
			type: 'GET',
			data: {
				crewIdx: '${crew.crewIdx}',
				currentPageNum : parameter
			},
			contentType: "application/x-www-form-urlencoded; charset=UTF-8;",
			success: function(data){
				
				if(data.infoList.length == 0) {
					var html = '<tr><td>아직 작성된 댓글이 없습니다.</td></tr>';
					$('#commentList').html(html);
					return;
				}
				
				var html = '';
				var html2 = '';
				
				$.each(data.infoList, function(index, item){
					html += '<tr><td><img id="profile" src="<c:url value="/images/default.jpg"/>"></td>';
					html +=	'<td><p id="nickname">'+item.memberNickName+'</p>';
					html += '<p class="content">'+item.crewComment+'</p>';
					html += '<p class="date">'+item.crewCommentDate+'</p></td>';
					html += '<td>';
					if('${sessionScope.member.memberIdx}' == item.memberIdx){
						html += '<div class="commentMenuBox">';
						html += '<div class="icon" onclick="commentToggle('+item.crewCommentIdx+');">';
						html += '<a href="#"><img id="commentMng" src="<c:url value="/images/crew/icon.png"/>"></a>';
						html +=	'<div class="commentMenu commentMenu'+item.crewCommentIdx+'"><ul id="commentMenu'+item.crewCommentIdx+'"></ul></div>';
						html += '</div>';
						html += '</div>';
					}
					html += '</td></tr>';
					$('#commentList').html(html);
				});
				
				var currentPageNum = parseInt('${cri.currentPageNum}');
				
				var prev = currentPageNum-1;
				if (prev==0){
					prev = 1;
				}
				var next = currentPageNum+1;
				if (next>data.totalPageNum){
					next = data.totalPageNum
				}
				
				html2 += '<li class="page-item">';
				html2 += '<a class="page-link" href="javascript:commentList('+prev+')">&lt</a></li>';
				for(var i=1 ; i <= data.totalPageNum; i++){
					html2 += '<li class="page-item">';
					html2 += '<a href="javascript:commentList('+i+')" class="page-link">'+i+'</a></li>';
				}
				html2 += '<li class="page-item">';
				html2 += '<a class="page-link" href="javascript:commentList('+next+')">&gt</a></li>';
				$('#paging').html(html2);
			}
		});                                                                                                                     
	}
</script>
<%@ include file="/WEB-INF/frame/default/header.jsp"%>
</head>
<body>
<c:if test="${updateResult eq 1}">
<script>
	alert('수정되었습니다.')
</script>
</c:if>
	<div class="section">
		<section>
			<div class="box">
				<div class="card">
					<img src="<c:url value='/images/crew/${crew.crewPhoto}'/>" class="card-img-top" alt="..." id="cardImg">
						
					<div class="card-body">
					
						<div class="crew_name_section">
							<h3 class="card-title">${crew.crewName}</h3>
							<c:if test="${member.memberIdx eq crew.memberIdx}">
							<a href='<c:url value="/crew/edit/${crew.crewIdx}"/>'
								class="btn btn-sm color_blue text_bold">크루 관리</a>
							</c:if>
						</div>
						
						<p class="card-text">${crew.crewDiscription}</p>
						<ul class="crew_hashtag" id="crewHashTag"></ul>
						
						<div class="crew_information">
							<span class="crew_captain">
								<p class="text_bold">${crew.memberNickName}</p> 
								<img id="profile" src="<c:url value='/images/default.jpg'/>">
							</span>
							<span class="crew_number">
								<p class="text_bold">크루원</p>
								<p>${crew.crewMemberNum}</p>
							</span>
							<span class="crew_comment_number">
								<p class="text_bold">댓글</p>
								<p>${crew.crewCommentNum}</p>
							</span>
						</div>
						<c:if test="${crew.isReg ne true}">
							<div class="join_section" id="joinToCrew">
	              <button class="btn btn-light">가입하기</button>
	            </div>
            </c:if>
            <c:if test="${crew.isReg eq true and sessionScope.member.memberIdx ne crew.memberIdx}">
            	<div class="join_section" id="outFromCrew">
            		<button class="btn btn-light">탈퇴하기</button>
            	</div>
            </c:if>
					</div>
				</div>
				
				<div class="comment_section">
					<div class="comment_table">
						<table id="commentList">
							
						</table>
					</div>
					
					<div class="input_section">
						<div>
							<ul class="pagination" id="paging">
							</ul>
						</div>
						
						<c:if test="${crew.isReg ne true}">
							<div class="input_control">
								<div>
									<input type="text" class="form-control" readonly="readonly">
								</div>
								<div>
									<input type="submit" value="게시" class="btn1 btn-light form-control" readonly="readonly">
								</div>
							</div>
						</c:if>
						<c:if test="${crew.isReg eq true}">
							<form method="post">
								<div class="input_control">
									<div>
										<input type="text" name="crewComment" class="form-control" id="crewComment">
										<input type="hidden" value="${crew.crewIdx}" id="crewIdx">
									</div>
									<div>
										<input type="submit" value="게시" class="btn1 btn-light form-control" id="submit">
									</div>
								</div>
							</form>
						</c:if>
					</div>
				</div>
			</div>
		</section>
	</div>
	<%@ include file="/WEB-INF/frame/default/footer.jsp"%>
</body>
</html>