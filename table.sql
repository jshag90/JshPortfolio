show databases;

create database seminar;

use seminar;

CREATE USER 'seminar'@'localhost' IDENTIFIED BY 'seminar';
grant all on seminar.* to 'seminar'@'localhost' identified by 'seminar';
FLUSH PRIVILEGES;

CREATE TABLE `users` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,  
  `isAdmin` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)  
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

create table `usersInfo`(
  `infoId` bigint(255) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `tel` varchar(255) NOT NULL,
  PRIMARY KEY (`infoId`),
  foreign key(`infoId`) references `users`(`id`) 
)ENGINE=InnoDB AUTO_INCREMENT=0  DEFAULT CHARSET=utf8;

create table `userBoard`(
`bId` bigint(20) NOT NULL AUTO_INCREMENT,
`bUserName` varchar(255) NOT NULL,
`bTitle` varchar(200) NOT NULL,
`bContent` varchar(300) NOT NULL,
`bHit` int(20) not null,
`bRegDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`bId`)
) ENGINE=InnoDB AUTO_INCREMENT=0  DEFAULT CHARSET=utf8;

CREATE TABLE `log` (
  `LogId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `LogUserName` varchar(255) NOT NULL,
  `LogRegDate` datetime NOT NULL COMMENT '등록 날짜',
  `LogContent` varchar(8000) NOT NULL DEFAULT '' COMMENT '로그 내용',
  `IpAddress` varchar(255) NOT NULL,
  `LogInHit` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`LogId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table `qna`(
  `QnaId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `QnaUserName` varchar(255) NOT NULL,
  `QnaQuestion` varchar(1000) NOT NULL DEFAULT '' COMMENT '질문',
  `QnaAnswer` varchar(8000) NOT NULL DEFAULT '' COMMENT '답변',
  `QnaRegDate` datetime NOT NULL COMMENT '등록 날짜',
  PRIMARY KEY(`QnaId`)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

 create table `notice`(
  `NoticeId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `NoticeUserName` varchar(255) NOT NULL,
  `NoticeTitle` varchar(300) NOT NULL DEFAULT '' COMMENT '제목',
  `NoticeContent` varchar(8000) NOT NULL DEFAULT '' COMMENT '내용',
  `NoticeRegDate` datetime NOT NULL COMMENT '등록 날짜',
  PRIMARY KEY(`NoticeId`)
 )ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;