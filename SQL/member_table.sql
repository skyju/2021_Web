CREATE TABLE `member` (
`idx` int(11) NOT NULL AUTO_INCREMENT unique,
`id` varchar(20) COLLATE utf8_bin NOT NULL unique,
`pw` varchar(20) COLLATE utf8_bin NOT NULL,
`name` varchar(20) COLLATE utf8_bin NOT NULL,
`signdate` datetime NOT NULL DEFAULT NOW(),
PRIMARY KEY(`idx`)
);

SELECT * FROM project.member;

update project.member set id = 'news', pw = 'news', name = 'news' where idx = 1;

DELETE FROM project.member;
commit;
select * from project.member where id = 'aaa' and pw ='www';

drop table project.member;
