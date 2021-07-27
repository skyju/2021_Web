create table project.guestbook_msg (
	msgid int not null auto_increment primary key,
    guestname varchar(20) not null,
    password varchar(20) not null,
    msg text not null,
    regdate timestamp default current_timestamp
);

drop table guestbook_msg;

-- select
select * from project.guestbook_msg;

-- limit <-> oracle의 rownum
select * from project.guestbook_msg limit 0, 3;
-- limit, index, count: 페이징 처리를 위하여
select * from project.guestbook_msg order by regdate desc limit 0, 3;

-- 전체 게시물 개수
select count(*) from project.guestbook_msg;

select * from project.guestbook_msg where msgid = 1 and password = '1111';


-- DML
insert into project.guestbook_msg (guestname, password, msg) 
values('king', '1111', 'Hello');

update project.guestbook_msg 
set guestname='scott', password='0000', msg='안녕하세요'
where msgid=1;

delete from project.guestbook_msg where msgid=1;