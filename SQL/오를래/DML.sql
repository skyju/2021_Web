-- 멤버 insert
insert into final.member 
(memberId, memberPw, memberName, memberEmail, memberProfile, memberNickname, memberBirth) 
values ('member1', 'member1', 'newmem', 'weeer@naver.com', 'fffff.jsp', 'newmem', 20200809);

insert into final.member 
(memberId, memberPw, memberName, memberEmail, memberProfile, memberNickname, memberBirth) 
values ('member2', 'member2', 'newmem2', 'asdf@naver.com', 'ssss.jsp', 'newmem2', 20200810);

-- 사진게시판 insert
insert into final.PhotoBoard (boardPhoto, boardDiscription, hashtag, memberIdx)
values ('newphoto', '꽃사진', '#북한산#꽃나들이', 1);

insert into final.PhotoBoard (boardPhoto, boardDiscription, hashtag, memberIdx)
values ('newphoto1', '나무사진', '#설악산#나들이', 2);

-- 사진게시판 댓글 insert
insert into final.photoBoardComment (comment, boardIdx, memberIdx) 
values ('별로에여 우우우 별로다', 1, 2);

-- 크루 insert
insert into final.crew (crewName, crewDiscription, crewTag, memberIdx) 
values ('우주짱짱산타모임', '산을 짱짱 잘타는 사람만 오시길 바랍니다', '#고수', 1);

-- 크루가입 insert
insert into final.crewreg (memberIdx, crewIdx) values (1, 1);
insert into final.crewreg (memberIdx, crewIdx) values (2, 1);

-- 크루댓글 insert
insert into final.crewComment (crewComment, memberIdx, crewIdx) 
values ('이크루 구려요', 2, 1);

-- 팔로우 insert
insert into final.follow (memberIdx, memberIdx2) 
values (1,2);

-- 좋아요 insert
insert into final.like (memberIdx, boardIdx)
values (2,1);

-- select문 모아놓음
select * from final.member;
select * from final.photoBoard;
select * from final.photoBoardComment;
select * from final.crew;
select * from final.crewreg;
select * from final.crewComment;
select * from final.follow;
select * from final.like;