-- 멤버
CREATE TABLE final.member (
   `memberIdx` INTEGER NOT NULL AUTO_INCREMENT,
   `memberId`VARCHAR(50) NOT NULL, 
   `memberPw` VARCHAR(50) NOT NULL ,
   `memberName` VARCHAR(50) NOT NULL ,
   `memberEmail` VARCHAR(40) NOT NULL,
   `memberProfile` VARCHAR(100) NULL,
   `memberNickname` VARCHAR(50) NOT NULL ,
   `memberRegdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
   `memberBirth` TIMESTAMP NULL,
    constraint pk_memberIdx PRIMARY KEY (memberIdx),
    constraint member_memberid_uq UNIQUE KEY (memberId),
	constraint member_memberNickname_uq UNIQUE KEY (memberNickname)
);

-- 사진게시판
CREATE TABLE final.PhotoBoard (
   `boardIdx` INTEGER NOT NULL AUTO_INCREMENT,
   `boardPhoto` VARCHAR(100) NOT NULL,
   `boardDiscription` text NULL,
   `boardDate` TIMESTAMP  NULL DEFAULT CURRENT_TIMESTAMP,
   `hashtag` varchar(200) NULL,
   `memberIdx` INTEGER NOT NULL,
    PRIMARY KEY (`boardIdx`),
    CONSTRAINT `FK_memberIdx_to_board` FOREIGN KEY (`memberIdx`) REFERENCES final.member(`memberIdx`)
);

-- 사진게시판-댓글
CREATE TABLE final.PhotoBoardComment (
   boardCommnetIdx INTEGER NOT NULL AUTO_INCREMENT ,
   comment text NOT NULL,
   commentDate TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
   boardIdx INTEGER NOT NULL,
   memberIdx INTEGER NOT NULL,
   PRIMARY KEY (`boardCommnetIdx`),
   CONSTRAINT `FK_boardIdx_to_boardComment` FOREIGN KEY (`boardIdx`) REFERENCES final.PhotoBoard(`boardIdx`),
   CONSTRAINT `FK_memberIdx_to_boardComment` FOREIGN KEY (`memberIdx`) REFERENCES final.member(`memberIdx`)
);

-- 크루
CREATE TABLE final.crew (
	`crewIdx` INTEGER NOT NULL auto_increment,
	`crewName` VARCHAR(50) NOT NULL,
	`crewDiscription` TEXT NOT NULL,
	`crewCreatedate` timestamp default current_timestamp,
	`crewTag` varchar(200) NULL,
	`memberIdx` INTEGER NOT NULL,
    constraint pk_crewIdx primary key (crewIdx),
    constraint unique_crewName unique key (crewName),
    constraint fk_memberIdx_to_crewOwner foreign key (memberIdx) references final.member(memberIdx) 
);

-- 크루가입
CREATE TABLE final.crewreg (
	`crewRegIdx` INTEGER NOT NULL auto_increment,
	`crewRegdate` timestamp default current_timestamp,
	`memberIdx` INTEGER NOT NULL,
	`crewIdx` INTEGER NOT NULL,
    constraint pk_crewIdx primary key (crewRegIdx),
	constraint fk_memberIdx_to_crewReg foreign key (memberIdx) references final.member(memberIdx),
    constraint fk_crewIdx_to_crewReg foreign key (crewIdx) references final.crew(crewIdx)
);

-- 크루댓글
CREATE TABLE final.crewComment (
	`crewCommentIdx` INTEGER NOT NULL auto_increment,
	`crewComment` text NOT NULL,
	`crewCommentDate` timestamp default current_timestamp,
	`memberIdx` INTEGER NOT NULL,
	`crewIdx` INTEGER NOT NULL,
    constraint pk_crewCommentidx primary key (crewCommentIdx),
    constraint fk_memberIdx_to_crewComment foreign key (memberIdx) references final.member(memberIdx),
    constraint fk_crewIdx_to_crewComment foreign key (crewIdx) references final.crew(crewIdx)
);

-- 드랍테이블
drop table final.member;

drop table final.crew;
drop table final.crewreg;
drop table final.crewComment;

DROP TABLE IF EXISTS final.PhotoBoard;
DROP TABLE IF EXISTS final.PhotoBoardComment;