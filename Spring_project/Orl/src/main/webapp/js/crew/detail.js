//el 들어간 거는 js로 빼면 오류남 ? el표현된 것이 서버에서 돌아야하니까..
//어떻게 해결? el 표현으로 넘기지말고 html로 표현해서 넣으면 가능 - val() 이나 text() 사용하는 등..
//js src 하는 위에서 js 변수로 잡아도 되는데, idx를 노출해도 되면 이렇게 하면되고, 노출하면 안되는 정보일 경우 x

// 경로 처리가 문제다..

$(document).ready(function(){
		
    commentList();
    
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
                commentList();
            }
        })
    });
    
    $('#outFromCrew').on('click', 'button', function(){
        $.ajax({
            url: 'http://localhost:8080/orl/crew/deleteCrewMemberFromList',
            type: 'get',
            data: {
                memberIdx : myMemberIdx,
                crewIdx : crewIdx
            },
            success : function(data){
                if(data==0){
                    alert('탈퇴에 실패했습니다.');
                } else if(data==1){
                    alert('해당 크루를 탈퇴했습니다.');
                    location.href="<c:url value='/crew/detail/"+crewIdx+"&1'/>"
                }
                commentList();
            }
        });	
    });
    
    
});

function commentList(){
    $.ajax({
        url: 'http://localhost:8080/orl/crew/getCommentInfo',
        type: 'GET',
        data: {
            crewIdx: crewIdx,
            currentPageNum : currentPageNum
        },
        contentType: "application/x-www-form-urlencoded; charset=UTF-8;",
        success: function(data){ // data가 json -> js객체로 변환해서 옴
            var html = '';
            var html2 = '';
            $.each(data.infoList, function(index, item){
                html += '<tr><td><img id="profile" src="<c:url value="/images/default.jpg"/>"></td>';
                html +=	'<td><p id="nickname">'+item.memberNickName+'</p>';
                html += '<p class="content">'+item.crewComment+'</p>';
                html += '<p class="date">'+item.crewCommentDate+'</p>';
                html += '</td></tr>';
                $('#commentList').html(html);
            });
            
            var currentPageNumber = parseInt(currentPageNum);
            var prev = currentPageNumber-1;
            if (prev==0){
                prev = 1;
            }
            var next = currentPageNumber+1;
            if (next>data.totalPageNum){
                next = data.totalPageNum
            }
            
            html2 += '<li class="page-item"><a class="page-link" href="<c:url value="/crew/detail/'+crewIdx+'&'+prev+'"/>">&lt</a></li>';
            for(var i=1 ; i <= data.totalPageNum; i++){
                html2 += '<li class="page-item"><a href="<c:url value="/crew/detail/'+crewIdx+'&'+i+'"/>" class="page-link">'+i+'</a></li>';
            }
            html2 += '<li class="page-item"><a class="page-link" href="<c:url value="/crew/detail/'+crewIdx+'&'+next+'"/>">&gt</a></li>';
            $('#paging').html(html2);
        }
    });                                                                                                                     
}